package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Allot;
import com.phoneerp.dao.AllotMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月19日上午10:40:25
 * @version 1.0
 */
@Controller
@RequestMapping("/allot")
public class AllotController {

	@Autowired
	private AllotMapper allotMapper;

	@RequestMapping(value = "/getAllotList")
	@ResponseBody
	public Map<String, Object> getList(Allot allot, Long page, Long rows) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("allot", allot);
		paramMap.put("startNo", (page - 1) * rows);
		paramMap.put("pageSize", rows);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rows", allotMapper.getList(paramMap));
		resultMap.put("total", allotMapper.getCount(paramMap));
		return resultMap;
	}
}
