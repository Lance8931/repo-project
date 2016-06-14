package com.phoneerp.bean;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月23日下午3:06:42
 * @version 1.0
 */
public class ExcelProperties {
	private Sheet sheet;
	private FormulaEvaluator formulaEvaluator;
	private int lastRowNum;

	public ExcelProperties(InputStream input, String originalFileName, int sheetNum) throws Exception {
		Workbook wb = null;
		String fileSuffix = originalFileName.substring(originalFileName.lastIndexOf(".")).toLowerCase();
		boolean isE2007 = false; // 判断是否是excel2007格式
		if (fileSuffix.endsWith("xlsx"))
			isE2007 = true;
		if (isE2007) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		// 解析公式结果
		this.formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		this.sheet = wb.getSheetAt(sheetNum);// 获得第sheetNum个表单
		System.out.println(sheet.getSheetName());
		this.lastRowNum = sheet.getLastRowNum();// 获取lastRowNum，从0开始计数
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public FormulaEvaluator getFormulaEvaluator() {
		return formulaEvaluator;
	}

	public void setFormulaEvaluator(FormulaEvaluator formulaEvaluator) {
		this.formulaEvaluator = formulaEvaluator;
	}

	public int getLastRowNum() {
		return lastRowNum;
	}

	public void setLastRowNum(int lastRowNum) {
		this.lastRowNum = lastRowNum;
	}
}
