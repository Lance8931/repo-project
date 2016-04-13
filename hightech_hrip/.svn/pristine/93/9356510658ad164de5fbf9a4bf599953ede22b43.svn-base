package com.siping.hrip;

import java.io.IOException;
import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.stroma.framework.core.database.manager.SqlMappingRegistry;
import org.stroma.framework.core.database.redis.RedisAccess;
import org.stroma.framework.core.log.LogSettings;
import org.stroma.framework.core.platform.StromaScopeResolver;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.siping.hrip.common.log.ServiceLogMessageFilter;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class, scopeResolver = StromaScopeResolver.class)
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableTransactionManagement
@PropertySource({ "classpath:/site-master.properties", "classpath:/site-jdbc.properties", "classpath:/site-redis.properties", "classpath:/site-version.properties", "classpath:/site-social.properties" })
public class AppConfig extends DbConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        return multipartResolver;
    }

    @Bean
    @Qualifier("messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("i18n.nstechs-i18n");
        bundleMessageSource.setUseCodeAsDefaultMessage(true);
        return bundleMessageSource;
    }

    @Override
    public LogSettings logSettings() {
        LogSettings congig = super.logSettings();
        congig.setLogMessageFilter(new ServiceLogMessageFilter());
        return congig;
    }

    @Override
    protected void registrySqlMapping(SqlMappingRegistry registry) {
    }

    @Bean
    public RedisAccess redisAccess() throws IOException {
        RedisAccess redisAccess = new RedisAccess();
        JedisPoolConfig config = new JedisPoolConfig();
        String hostAddress = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            hostAddress = localHost.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        config.setMaxIdle(Integer.valueOf(propertyContext().getAllProperties().getProperty("redis.pool.maxIdle"))); // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxWaitMillis(Long.valueOf(propertyContext().getAllProperties().getProperty("redis.pool.maxWait"))); // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setTestOnBorrow(Boolean.valueOf(propertyContext().getAllProperties().getProperty("redis.pool.testOnBorrow"))); // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        JedisPool pool = new JedisPool(config, propertyContext().getAllProperties().getProperty("redis.host", hostAddress), Integer.valueOf(propertyContext().getAllProperties().getProperty(
            "redis.port")));
        redisAccess.setJedisPool(pool);
        // redisAccess.setPassword("ybRIPvhn1");
        return redisAccess;
    }
}
