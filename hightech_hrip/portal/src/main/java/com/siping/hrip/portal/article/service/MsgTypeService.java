package com.siping.hrip.portal.article.service;

import java.util.List;

import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.MsgType;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;

/**
 * @author siping-L.J.H
 * @date 2016年4月19日上午10:49:34
 * @version 1.0
 */
public interface MsgTypeService {

    /**
     * 查询列表
     * @param msgType
     * @param pageRequest
     * @return
     * @throws BusinessProcessException
     * @date 2016年4月19日下午1:42:17
     * @author siping-L.J.H
     */
    public PageResponse<MsgType> getListByPage(MsgType msgType, PageRequest pageRequest) throws BusinessProcessException;

    /**
     * 添加
     * @param msgType
     * @throws BusinessProcessException
     * @date 2016年4月19日上午11:15:27
     * @author siping-L.J.H
     */
    public ResultMsg add(MsgType msgType) throws BusinessProcessException;

    /**
     * 编辑
     * @param msgType
     * @date 2016年4月19日上午11:15:39
     * @author siping-L.J.H
     */
    public ResultMsg edit(MsgType msgType) throws BusinessProcessException;

    /**
     * 删除
     * @param msgType
     * @date 2016年4月19日上午11:15:49
     * @author siping-L.J.H
     */
    public ResultMsg delete(MsgType msgType) throws BusinessProcessException;

    /**
     * 查询所有
     * @param msgType
     * @return
     * @throws Exception
     * @date 2016年4月26日下午4:54:15
     * @author siping-L.J.H
     */
    public List<MsgType> get(MsgType msgType) throws BusinessProcessException;
}
