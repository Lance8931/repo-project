package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

/**
 * 省市县JavaBean
 *
 * @author siping-L.J.H
 * @date 2016年4月29日上午10:04:11
 * @version 1.0
 */
public class Area extends Common implements Serializable {

    private static final long serialVersionUID = 9133106120696177360L;

    private Integer value;

    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
