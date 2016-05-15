package com.phoneerp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Purchase;
import com.phoneerp.bean.PurchaseDetail;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.dao.PurchaseDetailMapper;
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

	@Autowired
	private PurchaseDetailMapper purchaseDetailMapper;

	@RequestMapping(value = "/getPurList", method = RequestMethod.POST)
	@ResponseBody
	public List<Purchase> getPurList(Purchase purchase) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pur", purchase);
		return purchaseMapper.getList(paramMap);
	}

	@RequestMapping(value = "/addPur", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addPur(Purchase purchase, List<PurchaseDetail> details) {
		return null;
	}
}
