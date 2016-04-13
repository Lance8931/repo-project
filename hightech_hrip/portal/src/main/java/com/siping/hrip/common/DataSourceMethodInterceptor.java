package com.siping.hrip.common;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.database.mybatis.DynamicDataSourceHolder;

public class DataSourceMethodInterceptor implements MethodInterceptor, InitializingBean {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Transactional transactional = invocation.getMethod().getAnnotation(Transactional.class);

        if (null != transactional) {
            DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceHolder.DATA_SOURCE_WRITE);
        } else {
            DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceHolder.DATA_SOURCE_READ);
        }

        return invocation.proceed();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
