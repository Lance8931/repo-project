package com.phoneerp.bean;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月13日下午2:44:38
 * @version 1.0
 */
public class ResultMsg {
	private boolean success;
	private String msg;

	public ResultMsg(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
