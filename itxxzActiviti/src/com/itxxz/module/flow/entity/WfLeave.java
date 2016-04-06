package com.itxxz.module.flow.entity;

import java.io.Serializable;

/**
* Title: WfLeave.java
 * 
 * @author:IT学习者
 * 
 * @官网:www.itxxz.com
**/
public class WfLeave implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String leaveid;//请假id
	private String name;//请假人
	private Integer leaveCount;//请假天数
	private String leaveReason;//请假原因
	private String instanceid;//流程实例id

	/**
	 * @return 请假id
	 */
	public String getLeaveid() {
	 	return leaveid;
	}
	/**
	 * @设置 请假id
	 * @param leaveid
	 */
	public void setLeaveid(String leaveid) {
	 	this.leaveid = leaveid;
	}
	/**
	 * @return 请假人
	 */
	public String getName() {
	 	return name;
	}
	/**
	 * @设置 请假人
	 * @param name
	 */
	public void setName(String name) {
	 	this.name = name;
	}
	/**
	 * @return 请假天数
	 */
	public Integer instanceid() {
	 	return leaveCount;
	}
	/**
	 * @设置 请假天数
	 * @param leaveCount
	 */
	public void setLeaveCount(Integer leaveCount) {
	 	this.leaveCount = leaveCount;
	}
	/**
	 * @return 请假原因
	 */
	public String getLeaveReason() {
	 	return leaveReason;
	}
	/**
	 * @设置 请假原因
	 * @param leaveReason
	 */
	public void setLeaveReason(String leaveReason) {
	 	this.leaveReason = leaveReason;
	}
	/**
	 * @return 流程实例id
	 */
	public String getInstanceid() {
	 	return instanceid;
	}
	/**
	 * @设置 流程实例id
	 * @param instanceid
	 */
	public void setInstanceid(String instanceid) {
	 	this.instanceid = instanceid;
	}
}