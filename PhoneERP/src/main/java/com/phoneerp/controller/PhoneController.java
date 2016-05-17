package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Phone;
import com.phoneerp.bean.Purchase;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.dao.PhoneMapper;
import com.phoneerp.dao.PurchaseMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月15日下午4:01:52
 * @version 1.0
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	private PhoneMapper phoneMapper;

	@Autowired
	private PurchaseMapper purchaseMapper;

	@RequestMapping("/imeiNoCheck")
	@ResponseBody
	public ResultMsg imeiNoCheck(String imeiNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Phone phone = new Phone();
		phone.setImeiNo(imeiNo);
		paramMap.put("phone", phone);
		paramMap.put("isCheck", true);
		if (phoneMapper.getCount(paramMap) > 0) {
			return new ResultMsg(false, "存在。");
		} else {
			return new ResultMsg(true, "不存在。");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg add(Phone phone) {
		Purchase purchase = phone.getPurchase();
		purchase.setShopId(phone.getCurrentShopId());
		purchase.setPrice(phone.getPurPrice());
		phoneMapper.insertSelective(phone);
		purchase.setPhoneId(phone.getId());
		purchaseMapper.insertSelective(purchase);
		System.out.println(phone);
		return new ResultMsg(true, "成功。");
	}

	@RequestMapping(value = "/getPhoneList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getSupplierList(Phone phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("phone", phone);
		map.put("rows", phoneMapper.getList(paramMap));
		return map;
	}
}
