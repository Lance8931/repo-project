package com.phoneerp.bean;

import java.util.Date;

public class Purchase {
	private Integer id;

	private String purNo;

	private Date purTime;

	private Integer shopId;

	private Integer supplierId;

	private String remark;

	private Date createTime;

	private Supplier supplier;

	private Shop shop;

	private String startTime;

	private String endTime;

	private String imeiNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPurNo() {
		return purNo;
	}

	public void setPurNo(String purNo) {
		this.purNo = purNo == null ? null : purNo.trim();
	}

	public Date getPurTime() {
		return purTime;
	}

	public void setPurTime(Date purTime) {
		this.purTime = purTime;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
}