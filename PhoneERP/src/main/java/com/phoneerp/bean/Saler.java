package com.phoneerp.bean;

public class Saler {
    private Integer id;

    private String salerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName == null ? null : salerName.trim();
    }
}