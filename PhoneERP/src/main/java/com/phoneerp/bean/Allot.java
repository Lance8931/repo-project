package com.phoneerp.bean;

import java.util.Date;

public class Allot {
    private Integer id;

    private Integer inShopid;

    private Integer outShopid;

    private Integer phoneId;

    private Date operatTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInShopid() {
        return inShopid;
    }

    public void setInShopid(Integer inShopid) {
        this.inShopid = inShopid;
    }

    public Integer getOutShopid() {
        return outShopid;
    }

    public void setOutShopid(Integer outShopid) {
        this.outShopid = outShopid;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Date getOperatTime() {
        return operatTime;
    }

    public void setOperatTime(Date operatTime) {
        this.operatTime = operatTime;
    }
}