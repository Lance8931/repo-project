package com.itxxz.module.flow.entity;

import java.io.Serializable;

/**
* Title: WfLeave.java
 * 
 * @author:ITѧϰ��
 * 
 * @����:www.itxxz.com
**/
public class WfLeave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String leaveid;//���id
	private String name;//�����
	private Integer leaveCount;//�������
	private String leaveReason;//���ԭ��
	private String instanceid;//����ʵ��id

	/**
	 * @return ���id
	 */
	public String getLeaveid() {
	 	return leaveid;
	}
	/**
	 * @���� ���id
	 * @param leaveid
	 */
	public void setLeaveid(String leaveid) {
	 	this.leaveid = leaveid;
	}
	/**
	 * @return �����
	 */
	public String getName() {
	 	return name;
	}
	/**
	 * @���� �����
	 * @param name
	 */
	public void setName(String name) {
	 	this.name = name;
	}
	/**
	 * @return �������
	 */
	public Integer instanceid() {
	 	return leaveCount;
	}
	/**
	 * @���� �������
	 * @param leaveCount
	 */
	public void setLeaveCount(Integer leaveCount) {
	 	this.leaveCount = leaveCount;
	}
	/**
	 * @return ���ԭ��
	 */
	public String getLeaveReason() {
	 	return leaveReason;
	}
	/**
	 * @���� ���ԭ��
	 * @param leaveReason
	 */
	public void setLeaveReason(String leaveReason) {
	 	this.leaveReason = leaveReason;
	}
	/**
	 * @return ����ʵ��id
	 */
	public String getInstanceid() {
	 	return instanceid;
	}
	/**
	 * @���� ����ʵ��id
	 * @param instanceid
	 */
	public void setInstanceid(String instanceid) {
	 	this.instanceid = instanceid;
	}
}