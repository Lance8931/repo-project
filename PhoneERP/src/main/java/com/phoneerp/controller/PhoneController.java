package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Phone;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.dao.PhoneMapper;

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

	@RequestMapping("/imeiNoCheck")
	@ResponseBody
	public ResultMsg imeiNoCheck(String imeiNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Phone phone = new Phone();
		phone.setImeiNo(imeiNo);
		paramMap.put("phone", phone);
		paramMap.put("isCheck", true);
		if (phoneMapper.getCount(paramMap) > 1) {
			return new ResultMsg(false, "存在。");
		} else {
			return new ResultMsg(true, "不存在。");
		}
	}
}
