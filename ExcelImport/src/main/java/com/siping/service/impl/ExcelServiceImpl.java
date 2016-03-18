package com.siping.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.siping.bean.Material;
import com.siping.dao.MaterialMapper;
import com.siping.service.ExcelService;

/**
 * 导入ExcelService层
 *
 * @author siping-L.J.H
 * @date 2016年3月18日下午1:19:00
 * @version 1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {

	@Resource
	private MaterialMapper materialMapper;

	@SuppressWarnings("resource")
	@Override
	public void excelImport(MultipartFile[] multipartFiles) {
		String fileSuffix = multipartFiles[0]
				.getOriginalFilename()
				.substring(
						multipartFiles[0].getOriginalFilename()
								.lastIndexOf(".")).toLowerCase();
		boolean isE2007 = false; // 判断是否是excel2007格式

		Map<String, Object> map = new HashMap<String, Object>();

		List<Material> list = new ArrayList<Material>();

		String tempTableName = "tempMaterial" + new Date().getTime();
		map.put("tableName", tempTableName);
		materialMapper.createTable(tempTableName);
		if (fileSuffix.endsWith("xlsx"))
			isE2007 = true;
		try {
			InputStream input = multipartFiles[0].getInputStream(); // 建立输入流
			Workbook wb = null; // 根据文件格式(2003或者2007)来初始化
			if (isE2007) {
				wb = new XSSFWorkbook(input);
			} else {
				wb = new HSSFWorkbook(input);
			}
			// 解析公式结果
			FormulaEvaluator evaluator = wb.getCreationHelper()
					.createFormulaEvaluator();

			Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
			Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
			while (rows.hasNext()) {
				Row row = rows.next(); // 获得行数据
				Material material = new Material();
				System.out.println("Row #" + row.getRowNum()); // 获得行号从0开始
				int totalCellNum = row.getLastCellNum();
				for (int i = 0; i < totalCellNum; i++) {
					Cell cell = row.getCell(i);
					CellValue cellValue = evaluator.evaluate(cell);
					if (null != cell && 0 == i) {
						material.setMaterialNo(cellValue.getStringValue());
					}
					if (null != cell && 1 == i) {
						material.setMaterialName(cellValue.getStringValue());
					}
					if (null != cell && 2 == i) {
						material.setForeignName(cellValue.getStringValue());
					}
					if (null != cell && 3 == i) {
						material.setMaterialType(Integer.valueOf(cellValue
								.getStringValue()));
					}
					if (null != cell && 4 == i) {
						material.setBrand(cellValue.getStringValue());
					}
					if (null != cell && 5 == i) {
						material.setSpecificationsModel(cellValue
								.getStringValue());
					}
					if (null != cell && 6 == i) {
						material.setSeason(cellValue.getStringValue());
					}
					if (null != cell && 7 == i) {
						material.setIsPurchase(cellValue.getStringValue()
								.equals("1") ? true : false);
					}
					if (null != cell && 8 == i) {
						material.setIsSell(cellValue.getStringValue().equals(
								"1") ? true : false);
					}
					if (null != cell && 9 == i) {
						material.setIsInventory(cellValue.getStringValue()
								.equals("1") ? true : false);
					}
					if (null != cell && 10 == i) {
						material.setUnitId(Integer.valueOf(cellValue
								.getStringValue()));
					}
					if (null != cell && 11 == i) {
						material.setBarcode(cellValue.getStringValue());
					}
				}
				list.add(material);
				//
				// System.out.print("Cell #" + cell.getColumnIndex());
				// switch (cell.getCellType()) { // 根据cell中的类型来输出数据
				// case HSSFCell.CELL_TYPE_NUMERIC:
				// System.out.print("  numeric:"
				// + cell.getNumericCellValue() + "   ");
				// break;
				// case HSSFCell.CELL_TYPE_STRING:
				// System.out.print("  string:"
				// + cell.getStringCellValue() + "   ");
				// break;
				// case HSSFCell.CELL_TYPE_BOOLEAN:
				// System.out.print("  boolean:"
				// + cell.getBooleanCellValue() + "   ");
				// break;
				// case HSSFCell.CELL_TYPE_FORMULA:
				// System.out.print("  formula:" + cell.getCellFormula()
				// + "   ");
				// break;
				// default:
				// System.out.print("unsuported sell type");
				// break;
				// }

			}
			map.put("list", list);
			materialMapper.insertBatch(map);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
