package com.phoneerp.bean;

import java.util.Date;

public class Allot {
    private Integer id;

    private Integer inShopId;

    private Integer outShopId;

    private Date operatTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInShopId() {
        return inShopId;
    }

    public void setInShopId(Integer inShopId) {
        this.inShopId = inShopId;
    }

    public Integer getOutShopId() {
        return outShopId;
    }

    public void setOutShopId(Integer outShopId) {
        this.outShopId = outShopId;
    }

    public Date getOperatTime() {
        return operatTime;
    }

    public void setOperatTime(Date operatTime) {
        this.operatTime = operatTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}