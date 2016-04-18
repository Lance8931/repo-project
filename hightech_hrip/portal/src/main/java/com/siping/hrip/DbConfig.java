package com.siping.hrip;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.context.WebApplicationContext;
import org.stroma.framework.core.database.JDBCAccessContext;
import org.stroma.framework.core.database.JDBCAccessFactory;
import org.stroma.framework.core.database.mybatis.DynamicDataSource;
import org.stroma.framework.core.database.mybatis.DynamicDataSourceHolder;
import org.stroma.framework.core.platform.DefaultAppConfig;

import com.siping.hrip.common.DBSwitchInterceptor;
import com.siping.hrip.common.MybatisDbSwitch;
import com.siping.hrip.common.constant.Trans;

public abstract class DbConfig extends DefaultAppConfig {
    @Inject
    protected Environment env;

    @Bean(destroyMethod = "close")
    @Named("readDataSource")
    public DataSource readDataSource() throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(propertyContext().getAllProperties().getProperty("jdbc.driver.name"));
        dataSource.setUrl(propertyContext().getAllProperties().getProperty("jdbc.readdb.proxy.url"));
        dataSource.setUsername(propertyContext().getAllProperties().getProperty("jdbc.username"));
        dataSource.setPassword(propertyContext().getAllProperties().getProperty("jdbc.password"));
        dataSource.setTestOnBorrow(true);
        // TODO 数据合理性有待验证
        dataSource.setMaxActive(200); // 最大连接数量
        dataSource.setMaxIdle(200); // 最大空闲连接
        dataSource.setMinIdle(0); // 最小空闲连接
        dataSource.setInitialSize(5); // 初始化连接
        dataSource.setValidationQuery("select 1 from dual");
        return dataSource;
    }

    @Bean(destroyMethod = "close")
    @Named("writeDataSource")
    public DataSource writeDataSource() throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(propertyContext().getAllProperties().getProperty("jdbc.driver.name"));
        dataSource.setUrl(propertyContext().getAllProperties().getProperty("jdbc.writedb.proxy.url"));
        dataSource.setUsername(propertyContext().getAllProperties().getProperty("jdbc.username"));
        dataSource.setPassword(propertyContext().getAllProperties().getProperty("jdbc.password"));
        // TODO 数据合理性有待验证
        dataSource.setMaxActive(200); // 最大连接数量
        dataSource.setMaxIdle(200); // 最大空闲连接
        dataSource.setMinIdle(0); // 最小空闲连接
        dataSource.setInitialSize(5); // 初始化连接
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("select 1 from dual");
        return dataSource;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public JDBCAccessFactory jdbcAccessFactory() throws IOException {
        JDBCAccessFactory factory = new JDBCAccessFactory(writeDataSource(), readDataSource());
        return factory;
    }

    @Bean
    @Qualifier(Trans.JDBC)
    public DataSourceTransactionManager transactionManager() throws IOException {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(writeDataSource());
        // transactionManager.setDataSource(writeDataSource());//如果使用jdbc的方式，可改为一下
        return transactionManager;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public JDBCAccessContext jdbcAccessContext() {
        return new JDBCAccessContext();
    }

    @Bean
    public DynamicDataSource dynamicDataSource() throws IOException {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(writeDataSource());
        Map<Object, Object> targetDataSources = new ConcurrentHashMap<Object, Object>();
        targetDataSources.put(DynamicDataSourceHolder.DATA_SOURCE_READ, readDataSource());
        targetDataSources.put(DynamicDataSourceHolder.DATA_SOURCE_WRITE, writeDataSource());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDataSource());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperLocations = resolver.getResources("classpath*:config/mybatis/**/*Mapper.xml");
        factoryBean.setMapperLocations(mapperLocations);
        factoryBean.setConfigLocation(new ClassPathResource("config/mybatis/sqlMapConfig.xml"));
        return factoryBean;
    }

    @Bean
    @Named("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws IOException, Exception {
        return sqlSessionFactoryBean().getObject();
    }

    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean().getObject());
        return sqlSessionTemplate;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() throws IOException, Exception {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.siping.hrip.**.mapper"); // com.siping.service.**.mapper
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

    @Bean
    public DBSwitchInterceptor dbSwitchAdvice() {
        return new DBSwitchInterceptor();
    }

    @Bean
    public DefaultPointcutAdvisor dbSwitchAdvisor() {
        StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                Class<?> superclass = targetClass.getSuperclass();
                if (null != superclass && !superclass.equals(Object.class)) {
                    if (superclass.equals(MybatisDbSwitch.class))
                        return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        };
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(dbSwitchAdvice());
        advisor.setPointcut(pointcut);
        return advisor;
    }
}
