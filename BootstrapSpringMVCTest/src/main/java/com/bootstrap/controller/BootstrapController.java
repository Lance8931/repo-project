package com.bootstrap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootstrap.bean.RequestBean;
import com.bootstrap.bean.ResultBean;
import com.bootstrap.dao.CityMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月25日上午11:58:22
 * @version 1.0
 */
@Controller
public class BootstrapController {

	@Autowired
	private CityMapper cityMapper;

	@RequestMapping("/redirect")
	public String redirect() {
		return "bootstrapTest";
	}

	@RequestMapping("/redirectTable")
	public String redirectTable() {
		return "bootstrapTableTest";
	}

	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getDataPage(HttpServletRequest request,
			@RequestBody RequestBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNo", bean.getOffset());
		map.put("pageSize", bean.getLimit());
		List<ResultBean> list = cityMapper.getListByPage(map);
		map.clear();
		map.put("total", cityMapper.getCount());
		map.put("records", list);
		return map;
	}
}
