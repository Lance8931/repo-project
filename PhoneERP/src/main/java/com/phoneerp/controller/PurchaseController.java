package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Purchase;
import com.phoneerp.dao.PurchaseMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月15日下午4:01:52
 * @version 1.0
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseMapper purchaseMapper;

	@RequestMapping(value = "/getPurList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPurList(Purchase purchase, Long page,
			Long rows) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pur", purchase);
		paramMap.put("startNo", (page - 1) * rows);
		paramMap.put("pageSize", rows);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap.put("rows", purchaseMapper.getList(paramMap));
			resultMap.put("total", purchaseMapper.getCount(paramMap));
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
