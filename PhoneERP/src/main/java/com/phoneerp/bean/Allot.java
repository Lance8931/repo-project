package com.phoneerp.bean;

import java.util.Date;

public class Allot {
	private Integer id;

	private Integer inShopId;

	private Integer outShopId;

	private String operatTime;

	private Date createTime;

	private Integer phoneId;

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
}