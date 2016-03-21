package com.siping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.siping.bean.MaterialImportBean;
import com.siping.bean.PageModel;
import com.siping.bean.PageRequest;
import com.siping.bean.PageResponse;
import com.siping.bean.ResultMsg;
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

	/**
	 * 导入数据
	 * 
	 * @param multipartFiles
	 * @param request
	 * @return
	 *
	 * @date 2016年3月21日下午3:33:41
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public ModelAndView uploadExcel(
			@RequestParam MultipartFile[] multipartFiles,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String tableName = excelServiceImpl.excelImport(multipartFiles);
		mav.setViewName("list");
		mav.addObject("tableName", tableName);
		return mav;
	}

	@RequestMapping(value = "/kkk")
	public String kkk() {
		return "excelImport";
	}

	/**
	 * 获取临时表数据(分页)
	 * 
	 * @param pageRequest
	 * @return
	 *
	 * @date 2016年3月21日下午3:33:26
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/getlist", method = RequestMethod.POST)
	@ResponseBody
	public PageModel<MaterialImportBean> getProducts(
			@RequestBody PageRequest pageRequest) {
		PageModel<MaterialImportBean> pageModel = null;
		PageResponse<MaterialImportBean> pageResponse = new PageResponse<MaterialImportBean>();
		try {
			pageResponse = excelServiceImpl.getList(pageRequest,
					pageRequest.getKeyword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageModel = new PageModel<MaterialImportBean>(pageRequest.getPageNo(),
				pageRequest.getPageSize(), pageResponse.getTotal(),
				pageResponse.getRecords());
		return pageModel;
	}

	/**
	 * 审核
	 * 
	 * @return
	 *
	 * @date 2016年3月21日下午3:35:18
	 * @author siping-L.J.H
	 */
	public ResultMsg check() {
		ResultMsg msg = new ResultMsg();

		return msg;
	}
}
