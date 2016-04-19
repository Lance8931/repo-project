package com.siping.hrip.portal.article.service;

import com.siping.domain.portal.entity.MsgType;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月19日上午10:49:34
 * @version 1.0
 */
public interface MsgTypeService {

	/**
	 * 查询列表
	 * 
	 * @param msgType
	 * @param pageRequest
	 * @return
	 * @throws Exception
	 *
	 * @date 2016年4月19日下午1:42:17
	 * @author siping-L.J.H
	 */
	public PageResponse<MsgType> getListByPage(MsgType msgType,
			PageRequest pageRequest) throws Exception;

	/**
	 * 添加
	 * 
	 * @param msgType
	 *
	 * @date 2016年4月19日上午11:15:27
	 * @author siping-L.J.H
	 */
	public void add(MsgType msgType) throws Exception;

	/**
	 * 编辑
	 * 
	 * @param msgType
	 *
	 * @date 2016年4月19日上午11:15:39
	 * @author siping-L.J.H
	 */
	public void edit(MsgType msgType) throws Exception;

	/**
	 * 删除
	 * 
	 * @param msgType
	 *
	 * @date 2016年4月19日上午11:15:49
	 * @author siping-L.J.H
	 */
	public void delete(MsgType msgType) throws Exception;
}
