package com.phoneerp.bean;

/**
 * 用于传递json文件
 *
 * @author siping-L.J.H
 * @date 2016年5月12日下午6:00:33
 * @version 1.0
 */
public class Result {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private String text;
}
