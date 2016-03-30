package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月18日上午11:52:49
 * @version 1.0
 */
@Controller
public class ExcelController {

	@Autowired
	private ExcelService excelServiceImpl;

	@RequestMapping(value = "/kkk")
	public String kkk() {
		return "excelImport";
	}

	@RequestMapping("/test")
	public void test() {
		excelServiceImpl.test();
	}
}
