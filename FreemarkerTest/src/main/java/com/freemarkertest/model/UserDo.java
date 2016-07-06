package com.freemarkertest.model;

import java.io.Serializable;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月11日上午10:35:27
 * @version 1.0
 */
public class UserDo implements Serializable {

	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}