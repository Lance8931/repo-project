package com.siping.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.siping.bean.Material;
import com.siping.bean.MaterialImportBean;
import com.siping.bean.PageRequest;
import com.siping.bean.PageResponse;
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

	@Autowired
	private MaterialMapper materialMapper;

	@Override
	public PageResponse<MaterialImportBean> getList(PageRequest pageRequest,
			String tableName) {
		PageResponse<MaterialImportBean> pageResponse = new PageResponse<MaterialImportBean>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("startNo", pageRequest.getStartNo());
		map.put("pageSize", pageRequest.getPageSize());
		List<MaterialImportBean> pros = materialMapper.getListByPage(map);
		Integer total = materialMapper.getTotal(map);
		pageResponse.setRecords(pros);
		pageResponse.setTotal(total);
		return pageResponse;
	}

	@SuppressWarnings("resource")
	@Override
	public String excelImport(MultipartFile[] multipartFiles) {
		String fileSuffix = multipartFiles[0]
				.getOriginalFilename()
				.substring(
						multipartFiles[0].getOriginalFilename()
								.lastIndexOf(".")).toLowerCase();
		boolean isE2007 = false; // 判断是否是excel2007格式

		Map<String, Object> map = new HashMap<String, Object>();

		List<MaterialImportBean> list = new ArrayList<MaterialImportBean>();

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
			int lastRowNum = sheet.getLastRowNum();// 获取lastRowNum，从0开始计数
			for (int j = 1; j <= lastRowNum; j++) {
				Row row = sheet.getRow(j);
				if (null != row) {
					MaterialImportBean importBean = new MaterialImportBean();
					int totalCellNum = row.getLastCellNum();
					for (int i = 0; i < totalCellNum; i++) {
						Cell cell = row.getCell(i);
						CellValue cellValue = evaluator.evaluate(cell);
						if (null != cell && cellValue != null) {
							setMaterialExportBean(importBean, i, cellValue);
						}
					}
					list.add(importBean);
				}
			}
			map.put("list", list);
			materialMapper.insertBatch(map);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return tempTableName;
	}

	@Override
	public void insertFromTempTable(String tableName) {
		PageRequest pageRequest = new PageRequest();
		pageRequest.setPageNo(1);
		pageRequest.setPageSize(100);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		Integer total = materialMapper.getTotal(map);
		int pageNum = total / 100 + 1;
		for (int i = 1; i <= pageNum; i++) {
			pageRequest.setPageNo(i);
			map.put("startNo", pageRequest.getStartNo());
			map.put("pageSize", pageRequest.getPageSize());
			// 方案一(使用sql语句进行批量插入)：
			// materialMapper.insertBatchTwo(map);
			// 方案二(将临时表数据取出进行数据包装，再进行批量插入)：
			List<MaterialImportBean> pros = materialMapper.getListByPage(map);
			insertBatchT(pros, map);
		}
		materialMapper.dropTable(tableName);
	}

	public String createExcelTemplateFile() {
		List<String> typeNames = materialMapper.getTypeList();
		List<String> unitNames = materialMapper.getUnitList();
		String[] typeStrings = typeNames.toArray(new String[typeNames.size()]);
		String[] unitStrings = unitNames.toArray(new String[unitNames.size()]);
		return null;
	}

	/**
	 * 批量添加
	 * 
	 * @param pros
	 * @param map
	 *
	 * @date 2016年3月22日上午10:10:13
	 * @author siping-L.J.H
	 */
	private void insertBatchT(List<MaterialImportBean> pros,
			Map<String, Object> map) {
		List<Material> tempMaterials = new ArrayList<Material>();
		Material tempMaterial = null;
		MaterialImportBean bean = null;
		for (int i = 0; i < pros.size(); i++) {
			bean = pros.get(i);
			tempMaterial = new Material();
			if (null != bean.getBarcode()) {
				tempMaterial.setBarcode(bean.getBarcode());
			}
			if (null != bean.getBrand()) {
				tempMaterial.setBrand(bean.getBrand());
			}
			if (null != bean.getForeignName()) {
				tempMaterial.setForeignName(bean.getForeignName());
			}

			if (null != bean.getIsInventory()) {
				tempMaterial
						.setIsInventory((bean.getIsInventory().equals("是")) ? true
								: false);
			}
			if (null != bean.getIsPurchase()) {
				tempMaterial
						.setIsPurchase((bean.getIsPurchase().equals("是")) ? true
								: false);
			}
			if (null != bean.getIsSell()) {
				tempMaterial.setIsSell((bean.getIsSell().equals("是")) ? true
						: false);
			}
			if (null != bean.getMaterialName()) {
				tempMaterial.setMaterialName(bean.getMaterialName());
			}
			if (null != bean.getMaterialNo()) {
				tempMaterial.setMaterialNo(bean.getMaterialNo());
			}
			if (null != bean.getMaterialType()) {
				tempMaterial.setMaterialType(materialMapper.getTypeId(bean
						.getMaterialType()));
			}
			if (null != bean.getSeason()) {
				tempMaterial.setSeason(bean.getSeason());
			}

			if (null != bean.getSpecificationsModel()) {
				tempMaterial.setSpecificationsModel(bean
						.getSpecificationsModel());
			}
			if (null != bean.getUnitId()) {
				tempMaterial.setUnitId(materialMapper.getUnitId(bean
						.getUnitId()));
			}
			tempMaterials.add(tempMaterial);
		}
		materialMapper.insertBatchThree(tempMaterials);
	}

	/**
	 * 设置导入临时表Bean值
	 * 
	 * @param importBean
	 * @param i
	 * @param cellValue
	 *
	 * @date 2016年3月21日上午11:48:53
	 * @author siping-L.J.H
	 */
	private void setMaterialExportBean(MaterialImportBean importBean, int i,
			CellValue cellValue) {
		switch (i) {
		case 0:
			importBean.setMaterialNo(cellValue.getStringValue());
			break;
		case 1:
			importBean.setMaterialName(cellValue.getStringValue());
			break;
		case 2:
			importBean.setForeignName(cellValue.getStringValue());
			break;
		case 3:
			importBean.setMaterialType(cellValue.getStringValue());
			break;
		case 4:
			importBean.setBrand(cellValue.getStringValue());
			break;
		case 5:
			importBean.setSpecificationsModel(cellValue.getStringValue());
			break;
		case 6:
			importBean.setSeason(cellValue.getStringValue());
			break;
		case 7:
			importBean.setIsPurchase(cellValue.getStringValue());
			break;
		case 8:
			importBean.setIsSell(cellValue.getStringValue());
			break;
		case 9:
			importBean.setIsInventory(cellValue.getStringValue());
			break;
		case 10:
			importBean.setUnitId(cellValue.getStringValue());
			break;
		case 11:
			importBean.setBarcode(cellValue.getStringValue());
			break;
		default:
			break;
		}
	}

}
