package com.siping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.siping.service.ExcelService;

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

	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public String uploadExcel(@RequestParam MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		excelServiceImpl.excelImport(multipartFiles);
		return "excelImport";
	}

	@RequestMapping(value = "/kkk")
	public String kkk() {
		return "excelImport";
	}
}
