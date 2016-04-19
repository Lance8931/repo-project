package com.siping.hrip.portal.article.controller;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.MsgType;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.hrip.portal.article.service.MsgTypeService;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月19日上午10:49:02
 * @version 1.0
 */
@Controller
public class MsgTypeController {

	@Autowired
	private MsgTypeService msgTypeService;

	/**
	 * 跳转
	 * 
	 * @return
	 *
	 * @date 2016年4月19日上午11:40:33
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "msgType/redirect")
	public String redirect() {
		return "/";
	}

	/**
	 * 分页获取
	 * 
	 * @param msgType
	 * @param pageRequest
	 * @return
	 *
	 * @date 2016年4月19日下午1:43:41
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "msgType/getList")
	@ResponseBody
	public PageResponse<MsgType> getList(MsgType msgType,
			PageRequest pageRequest) {
		try {
			return msgTypeService.getListByPage(msgType, pageRequest);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 添加
	 * 
	 * @param typeName
	 * @return
	 *
	 * @date 2016年4月19日上午11:43:49
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "msgType/add")
	@ResponseBody
	public ResultMsg add(String typeName) {
		if (StringUtils.isNotBlank(typeName)) {
			MsgType msgType = new MsgType();
			msgType.setTypeName(typeName);
			try {
				msgTypeService.add(msgType);
				return new ResultMsg(true, "添加成功！");
			} catch (Exception e) {
				return new ResultMsg(false, "添加失败！");
			}
		} else {
			return new ResultMsg(false, "类型名称不能为空！");
		}
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @param typeName
	 * @return
	 *
	 * @date 2016年4月19日上午11:44:01
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "msgType/edit")
	@ResponseBody
	public ResultMsg edit(String id, String typeName) {
		if (StringUtils.isNotBlank(typeName)) {
			if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
				MsgType msgType = new MsgType();
				msgType.setId(new BigInteger(id));
				msgType.setTypeName(typeName);
				try {
					msgTypeService.edit(msgType);
					return new ResultMsg(true, "编辑成功！");
				} catch (Exception e) {
					return new ResultMsg(false, "编辑失败！");
				}
			} else {
				return new ResultMsg(false, "id非法！");
			}
		} else {
			return new ResultMsg(false, "类型名称不能为空！");
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 *
	 * @date 2016年4月19日上午11:44:08
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "msgType/delete")
	@ResponseBody
	public ResultMsg delete(String id) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			MsgType msgType = new MsgType();
			msgType.setId(new BigInteger(id));
			try {
				msgTypeService.delete(msgType);
				return new ResultMsg(true, "删除成功！");
			} catch (Exception e) {
				return new ResultMsg(false, "删除失败！");
			}
		} else {
			return new ResultMsg(false, "id非法！");
		}
	}
}
