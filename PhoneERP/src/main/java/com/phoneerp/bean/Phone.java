package com.phoneerp.bean;

public class Phone {
    private Integer id;

    private String imeino;

    private String color;

    private String brand;

    private Integer purPrice;

    private Integer salePrice;

    private Integer supplierId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeino() {
        return imeino;
    }

    public void setImeino(String imeino) {
        this.imeino = imeino == null ? null : imeino.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Integer getPurPrice() {
        return purPrice;
    }

    public void setPurPrice(Integer purPrice) {
        this.purPrice = purPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}