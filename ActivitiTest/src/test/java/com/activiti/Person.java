package com.activiti;

import java.io.Serializable;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月6日下午5:09:47
 * @version 1.0
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 8379071759772449529L;

	private Integer id;
	private String name;
	private String education;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
}
