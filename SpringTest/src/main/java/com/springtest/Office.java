package com.springtest;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月24日上午11:15:04
 * @version 1.0
 */
public class Office {
	private String officeNo = "001";

	@Override
	public String toString() {
		return "officeNo:" + officeNo;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
}
