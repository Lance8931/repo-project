package com.phoneerp.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
	private Integer id;

	private Integer phoneId;

	private Integer salerId;

	private Integer shopId;

	private String orderTime;

	private Integer billNo;

	private BigDecimal billPrice;

	private String orderRemark;

	private String buyerName;

	private String buyerPhone;

	private Date createTime;

	private String orderStartTime;

	private String orderEndTime;

	private String orderStartPrice;

	private String orderEndPrice;

	private String imeiNo;

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public Integer getSalerId() {
		return salerId;
	}

	public void setSalerId(Integer salerId) {
		this.salerId = salerId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getBillNo() {
		return billNo;
	}

	public void setBillNo(Integer billNo) {
		this.billNo = billNo;
	}

	public BigDecimal getBillPrice() {
		return billPrice;
	}

	public void setBillPrice(BigDecimal billPrice) {
		this.billPrice = billPrice;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark == null ? null : orderRemark.trim();
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName == null ? null : buyerName.trim();
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone == null ? null : buyerPhone.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public String getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public String getOrderStartPrice() {
		return orderStartPrice;
	}

	public void setOrderStartPrice(String orderStartPrice) {
		this.orderStartPrice = orderStartPrice;
	}

	public String getOrderEndPrice() {
		return orderEndPrice;
	}

	public void setOrderEndPrice(String orderEndPrice) {
		this.orderEndPrice = orderEndPrice;
	}
}