package com.phoneerp.controller;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月28日下午4:37:02
 * @version 1.0
 */
public class ExcelExportController {
	/**
	 * 导出Excel数据 exportData
	 * 
	 * @param queryData
	 *            要导出的数据
	 * @param tableHead
	 *            表头数据
	 * @param fileName
	 *            sheet表单名称
	 * @return
	 * @throws Exception
	 *             文件输出异常
	 */
	public String exportData(List<?> queryData, Map<String, String> tableHead,
			String fileName, HttpServletRequest request) throws Exception {
		Workbook wb = new XSSFWorkbook();
		writeToExcel(queryData, tableHead, fileName, wb);
		String templateFilePath = request.getServletContext().getRealPath(
				"/resources/")
				+ "Template.xls";
		File targetFile = new File(templateFilePath);
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(targetFile);
			wb.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return templateFilePath;
	}

	// 将数据写入到Excel中
	public void writeToExcel(List<?> queryData, Map<String, String> tableHead,
			String fileName, Workbook wb) {
		// 获取易于处理表头
		String[] tabHead = getTabHead(tableHead);
		// 创建sheet表单
		Sheet sheet = wb.createSheet(fileName);
		// 创建表头
		Row headRow = sheet.createRow((int) 0);
		// 设置导出表格表头
		setTableHead(headRow, tableHead, wb, sheet);
		// 写入表体数据
		writeToExcel(queryData, tabHead, wb, sheet);
	}

	// 从设置好的表头中获取表头信息
	public String[] getTabHead(Map<String, String> tableHead) {
		String[] newHead = new String[tableHead.size()];
		for (Entry<String, String> th : tableHead.entrySet()) {
			String tempArray[] = new String[] { th.getValue() }[0].split("#");// 获取导出字段组合值
			newHead[Integer.parseInt(tempArray[0])] = th.getKey();
		}
		return newHead;
	}

	// 将对应数据读取到excel中
	public static String writeToExcel(List<?> queryData, String[] tableHead,
			Workbook wb, Sheet sheet) {
		try {
			CellStyle cellStyle = getCellStyle(wb);
			Map<String, String> map = null;
			for (int i = 0; i < queryData.size(); i++) {
				Row newRow = sheet.createRow(i + 1);
				map = convertBean(queryData.get(i));
				for (int j = 0; j < tableHead.length; j++) {
					Cell newCol = newRow.createCell(j);// 创建新的一列
					newCol.setCellValue(map.get(tableHead[j]));// 设置新的值
					newCol.setCellStyle(cellStyle);// 设置样式
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "数据写入成功";
	}

	// 设置表头信息
	public static void setTableHead(Row headRow, Map<String, String> tableHead,
			Workbook wb, Sheet sheet) {
		CellStyle cellStyle = getCellStyle(wb);
		Font font = wb.createFont();
		font.setFontName("微软雅黑");
		font.setBold(true);
		cellStyle.setFont(font);
		try {
			Cell cell;
			for (Entry<String, String> th : tableHead.entrySet()) {
				String[] cellArray = th.getValue().split("#");
				cell = headRow.createCell(Integer.parseInt(cellArray[0]));
				cell.setCellStyle(cellStyle);
				cell.setCellValue(cellArray[1]);
			}
		} catch (Exception e) {
			// throw new Exception("设置表头出错！表头规则：key:属性名,value:序号+显示名称", e);
		}
	}

	// 创建单元格格式
	public static CellStyle getCellStyle(Workbook wb) {
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);// 右边框
		return cellStyle;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (!"class".equals(propertyName)) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result.toString());
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

}
