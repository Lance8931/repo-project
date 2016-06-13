package com.phoneerp.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Phone {
	private Integer id;

	private String imeiNo;

	private Integer colorId;

	private Integer brandId;

	private String phoneType;

	private BigDecimal purPrice;

	private BigDecimal salePrice;

	private Integer modelId;

	private Integer currentShopId;

	private Boolean isSold;

	private String remark;

	private Date createTime;

	private Boolean isDeleted;

	private Integer amount;

	private Purchase purchase;

	private Shop shop;

	private Orders orders;

	private Supplier supplier;

	private Saler saler;

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Saler getSaler() {
		return saler;
	}

	public void setSaler(Saler saler) {
		this.saler = saler;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo == null ? null : imeiNo.trim();
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public BigDecimal getPurPrice() {
		return purPrice;
	}

	public void setPurPrice(BigDecimal purPrice) {
		this.purPrice = purPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getCurrentShopId() {
		return currentShopId;
	}

	public void setCurrentShopId(Integer currentShopId) {
		this.currentShopId = currentShopId;
	}

	public Boolean getIsSold() {
		return isSold;
	}

	public void setIsSold(Boolean isSold) {
		this.isSold = isSold;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

}