package com.siping.hrip.common;

import org.stroma.framework.core.database.mybatis.DynamicDataSourceHolder;

public class MybatisDbSwitch {
    public static void switchToWrite() {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceHolder.DATA_SOURCE_WRITE);
    }

    public static void switchToRead() {
        DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceHolder.DATA_SOURCE_READ);
    }
}
