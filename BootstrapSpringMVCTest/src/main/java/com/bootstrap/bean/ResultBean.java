package com.bootstrap.bean;

import java.io.Serializable;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月25日下午4:55:26
 * @version 1.0
 */
public class ResultBean implements Serializable {

	private static final long serialVersionUID = 4041393010806550075L;

	private String id;

	private String name;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
