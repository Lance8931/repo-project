package com.phoneerp.bean;

import java.util.Date;

public class Allot {
	private Integer id;

	private Integer inShopId;

	private Integer outShopId;

	private String operatTime;

	private Date createTime;

	private Integer phoneId;

	private String imeiNo;

	private String startTime;

	private String endTime;

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

	public String getOperatTime() {
		return operatTime;
	}

	public void setOperatTime(String operatTime) {
		this.operatTime = operatTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
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

}