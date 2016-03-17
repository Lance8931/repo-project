package com.siping.web.bean;

import java.io.Serializable;

/**
 * 共通的类属性 author:liufei date:2015-01-08
 */
public class Common implements Serializable {

	private static final long serialVersionUID = 6581543002259605182L;
	private String addTime;
	private String addBy;
	private String updateTime;
	private String updateBy;
	private Integer activity = 1;
	public Integer pkey;

	public String getAddBy() {
		return addBy;
	}

	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}

	public Integer getPkey() {
		return pkey;
	}

	public void setPkey(Integer pkey) {
		this.pkey = pkey;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
