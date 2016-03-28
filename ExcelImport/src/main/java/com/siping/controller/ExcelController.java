package com.siping.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
	public ModelAndView uploadExcel(
			@RequestParam MultipartFile[] multipartFiles,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Long startTime = new Date().getTime();
		System.out.println("开始导入：" + startTime);
		String tableName = excelServiceImpl.excelImport(multipartFiles);
		Long endTime = new Date().getTime();
		System.out.println("结束导入：" + endTime);
		System.out.println("间隔时间：" + (endTime - startTime) / 1000);
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
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg check(String tableName) {
		try {
			excelServiceImpl.insertFromTempTable(tableName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResultMsg(false, 0, "审核失败");
		}
		return new ResultMsg(true, 1, "审核成功");
	}

	@RequestMapping(value = "/download")
	public void downLoadExcelTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("state", null);
		// 生成提示信息，
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			// 进行转码，使其支持中文文件名
			codedFileName = new File("D:\\MaterialExcelTemplate.xls").getName();
			System.out.println(codedFileName);
			response.setHeader("content-disposition", "attachment;filename="
					+ codedFileName + ".xls");
			// 产生工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 产生工作表对象
			HSSFSheet sheet = workbook.createSheet();
			for (int i = 1; i <= 30; i++) {
				HSSFRow row = sheet.createRow((int) i);// 创建一行
				HSSFCell cell = row.createCell((int) 0);// 创建一列
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("测试成功" + i);
			}
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
			}
			session.setAttribute("state", "open");
		}
	}

	@RequestMapping("/downloadOne")
	public ResponseEntity<byte[]> download() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		String filePath = null;
		filePath = excelServiceImpl.createExcelTemplateFile();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", new String(
				"模板下载.xls".getBytes("UTF-8"), "iso-8859-1"));
		return new ResponseEntity<byte[]>(
				FileUtils.readFileToByteArray(new File(filePath)), headers,
				HttpStatus.CREATED);
	}

	@RequestMapping("/downloadTwo")
	public ResponseEntity<byte[]> downloadTwo() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		String filePath = null;
		filePath = excelServiceImpl.createExcelTemplateFileOne();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", new String(
				"模板下载.xls".getBytes("UTF-8"), "iso-8859-1"));
		return new ResponseEntity<byte[]>(
				FileUtils.readFileToByteArray(new File(filePath)), headers,
				HttpStatus.CREATED);
	}

	@RequestMapping("/test")
	public void test() {
		excelServiceImpl.test();
	}

	@RequestMapping(value = "/downTest", method = RequestMethod.POST)
	public ModelAndView downTest(@RequestParam MultipartFile[] multipartFiles)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		Long startTime = new Date().getTime();
		System.out.println("开始导入：" + startTime);
		String tableName = excelServiceImpl.readExcelBySAX(multipartFiles);
		Long endTime = new Date().getTime();
		System.out.println("结束导入：" + endTime);
		System.out.println("间隔时间：" + (endTime - startTime) / 1000);
		mav.setViewName("list");
		mav.addObject("tableName", tableName);

		return mav;
	}
}
