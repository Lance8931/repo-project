package com.ssm.bean;

import java.util.List;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月3日上午11:36:10
 * @version 1.0
 */
public class AjaxDataBean {
	private String userName;
	private String nickName;

	private String[] userNames;

	private List<String> nickNames;

	public List<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}

	public String[] getUserNames() {
		return userNames;
	}

	public void setUserNames(String[] userNames) {
		this.userNames = userNames;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
