package com.phoneerp.bean;

public class Inventory {
    private Integer id;

    private Integer shopId;

    private String phoneImeino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getPhoneImeino() {
        return phoneImeino;
    }

    public void setPhoneImeino(String phoneImeino) {
        this.phoneImeino = phoneImeino == null ? null : phoneImeino.trim();
    }
}