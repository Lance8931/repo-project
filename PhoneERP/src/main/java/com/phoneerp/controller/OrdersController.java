package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Orders;
import com.phoneerp.dao.OrdersMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月19日下午2:09:56
 * @version 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersMapper ordersMapper;

	@RequestMapping(value = "/getOrdersList")
	@ResponseBody
	public Map<String, Object> getList(Orders orders, Long page, Long rows) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orders", orders);
		paramMap.put("startNo", (page - 1) * rows);
		paramMap.put("pageSize", rows);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rows", ordersMapper.getList(paramMap));
		resultMap.put("total", ordersMapper.getCount(paramMap));
		return resultMap;
	}
}
