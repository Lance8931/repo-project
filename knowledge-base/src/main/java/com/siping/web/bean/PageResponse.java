package com.siping.web.bean;

import java.io.Serializable;
import java.util.List;

public class PageResponse<T> implements Serializable {

	private static final long serialVersionUID = -8136653444119805627L;

	private Integer total;
	private List<T> records;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
}
