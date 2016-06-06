package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class OrgType extends Common implements Serializable {

    private static final long serialVersionUID = 2232686516951019183L;
    private String typeName;
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
}
