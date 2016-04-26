package com.bootstrap.bean;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月26日上午10:37:08
 * @version 1.0
 */
public class RequestBean {

	private Integer limit;

	private Integer offset;

	private String order;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
