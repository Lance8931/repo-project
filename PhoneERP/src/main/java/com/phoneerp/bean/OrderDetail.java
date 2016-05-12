package com.phoneerp.bean;

public class OrderDetail {
    private Integer id;

    private String phoneImeino;

    private Long salePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneImeino() {
        return phoneImeino;
    }

    public void setPhoneImeino(String phoneImeino) {
        this.phoneImeino = phoneImeino == null ? null : phoneImeino.trim();
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }
}