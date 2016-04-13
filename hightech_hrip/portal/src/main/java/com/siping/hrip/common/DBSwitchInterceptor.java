package com.siping.hrip.common;

import java.lang.reflect.Method;

import javax.inject.Inject;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.database.JDBCAccessContext;
import org.stroma.framework.core.database.JDBCAccessFactory;
import org.stroma.framework.core.database.mybatis.DynamicDataSourceHolder;

public class DBSwitchInterceptor implements MethodInterceptor {
    private JDBCAccessContext jdbcAccessContext;
    private JDBCAccessFactory factory;

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        Transactional transactional = (Transactional) method.getAnnotation(Transactional.class);

        if (null != transactional) {
            DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceHolder.DATA_SOURCE_WRITE);
            this.jdbcAccessContext.setJdbcAccess(this.factory.getMasterJDBCAccess());
        } else {
            DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceHolder.DATA_SOURCE_READ);
            this.jdbcAccessContext.setJdbcAccess(this.factory.getSlaveJDBCAccess());
        }

        return methodInvocation.proceed();
    }

    @Inject
    public void setJdbcAccessContext(JDBCAccessContext jdbcAccessContext) {
        this.jdbcAccessContext = jdbcAccessContext;
    }

    @Inject
    public void setFactory(JDBCAccessFactory factory) {
        this.factory = factory;
    }
}
