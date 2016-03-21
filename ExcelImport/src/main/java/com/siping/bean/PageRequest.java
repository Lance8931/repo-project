package com.siping.bean;

import java.io.Serializable;

public class PageRequest implements Serializable {

	private static final long serialVersionUID = 1266864074198044690L;

	private Integer pageSize;
	private Integer pageNo;
	private Integer startNo;
	private String keyword;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStartNo() {
		this.startNo = (pageNo - 1) * pageSize;
		return startNo;
	}
}
