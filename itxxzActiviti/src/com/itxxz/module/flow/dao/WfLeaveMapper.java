package com.itxxz.module.flow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itxxz.module.flow.entity.WfLeave;

/**
 * Title: WfLeaveDao.java Description:
 * 
 * @author:IT学习者
 * 
 * @官网:www.itxxz.com
 **/
@Repository("wfLeaveMapper")
public interface WfLeaveMapper {

	public WfLeave getById(WfLeave entity);

	public void delWfLeave(WfLeave entity);

	public void insertWfLeave(WfLeave entity);

	public void updateWfLeave(WfLeave entity);

	public int getCountWfLeave(WfLeave entity);
	
	public List<WfLeave> findByEntity(WfLeave entity);

	public List<WfLeave> findByInstanceid(String instanceid);

}