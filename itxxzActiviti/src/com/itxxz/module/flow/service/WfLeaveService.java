package com.itxxz.module.flow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.module.flow.dao.WfLeaveMapper;
import com.itxxz.module.flow.entity.WfLeave;



/**
* Title: WfLeaveService.java
* 
* @author:IT学习者
* 
* @官网:www.itxxz.com
**/
@Service
public class WfLeaveService {

	@Autowired
	private WfLeaveMapper wfLeaveMapper;

	/**
	 * ɾ��
	 * 
	 * @author www.itxxz.com
	 */
	public void delWfLeave(WfLeave wfLeave) {
		try {
			wfLeaveMapper.delWfLeave(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.itxxz.service.impl.WfLeaveServiceImpl-[delWfLeave]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ���id��ѯ
	 * 
	 * @author www.itxxz.com
	 */
	public WfLeave getById(WfLeave wfLeave) {
		try {
			wfLeave = wfLeaveMapper.getById(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[getById]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return wfLeave;
	}

	/**
	 * ����
	 * 
	 * @author www.itxxz.com
	 */
	public void insertWfLeave(WfLeave wfLeave) {
		System.out.println(wfLeave);
		try {
			wfLeaveMapper.insertWfLeave(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[insertWfLeave]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 * 
	 * @author www.itxxz.com
	 * 
	 */
	public void updateWfLeave(WfLeave wfLeave) {
		try {
			wfLeaveMapper.updateWfLeave(wfLeave);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[updateWfLeave]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ���ʵ�����ѯ
	 * 
	 * @author www.itxxz.com
	 * 
	 */
	public List<WfLeave> findByEntity(WfLeave entity) {
		try {
			System.out.println("wfLeaveMapper:"+wfLeaveMapper);
			List<WfLeave> wfList = wfLeaveMapper.findByEntity(entity);
			System.out.println("���ʵ�����ѯ:" + wfList);
			System.out.println("����:" + wfList.size());
			return wfList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * �������ʵ���ѯ
	 * 
	 * @author www.itxxz.com
	 */
	public List<WfLeave> findByInstanceid(String instanceid) {
		List<WfLeave> wfList = null;
		try {
			wfList = wfLeaveMapper.findByInstanceid(instanceid);
		} catch (Exception e) {
			System.out
					.println("com.stobird.service.impl.WfLeaveServiceImpl-[findByInstanceid]-Exception ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return wfList;
	}

}