package com.phoneerp.bean;

import java.math.BigDecimal;

public class SearchPhoneListBean {
	private String imeiNo;

	private String supplierId;

	private String brandId;

	private String purStartTime;

	private String purEndTime;

	private String currentShopId;

	private String isSold;

	private String salerId;

	private String saleStartTime;

	private String saleEndTime;

	private String modelId;

	private String colorId;

	private String phoneType;

	private BigDecimal purStartPrice;

	private BigDecimal purEndPrice;

	private BigDecimal billStartPrice;

	private BigDecimal billEndPrice;

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getPurStartTime() {
		return purStartTime;
	}

	public void setPurStartTime(String purStartTime) {
		this.purStartTime = purStartTime;
	}

	public String getPurEndTime() {
		return purEndTime;
	}

	public void setPurEndTime(String purEndTime) {
		this.purEndTime = purEndTime;
	}

	public String getCurrentShopId() {
		return currentShopId;
	}

	public void setCurrentShopId(String currentShopId) {
		this.currentShopId = currentShopId;
	}

	public String getIsSold() {
		return isSold;
	}

	public void setIsSold(String isSold) {
		this.isSold = isSold;
	}

	public String getSalerId() {
		return salerId;
	}

	public void setSalerId(String salerId) {
		this.salerId = salerId;
	}

	public String getSaleStartTime() {
		return saleStartTime;
	}

	public void setSaleStartTime(String saleStartTime) {
		this.saleStartTime = saleStartTime;
	}

	public String getSaleEndTime() {
		return saleEndTime;
	}

	public void setSaleEndTime(String saleEndTime) {
		this.saleEndTime = saleEndTime;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public BigDecimal getPurStartPrice() {
		return purStartPrice;
	}

	public void setPurStartPrice(BigDecimal purStartPrice) {
		this.purStartPrice = purStartPrice;
	}

	public BigDecimal getPurEndPrice() {
		return purEndPrice;
	}

	public void setPurEndPrice(BigDecimal purEndPrice) {
		this.purEndPrice = purEndPrice;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public BigDecimal getBillStartPrice() {
		return billStartPrice;
	}

	public void setBillStartPrice(BigDecimal billStartPrice) {
		this.billStartPrice = billStartPrice;
	}

	public BigDecimal getBillEndPrice() {
		return billEndPrice;
	}

	public void setBillEndPrice(BigDecimal billEndPrice) {
		this.billEndPrice = billEndPrice;
	}

}
