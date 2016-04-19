package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;


public class MsgType extends Common implements Serializable {

    private static final long serialVersionUID = -3727542901446444012L;
    /**
     * 类型名称
     */
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

}