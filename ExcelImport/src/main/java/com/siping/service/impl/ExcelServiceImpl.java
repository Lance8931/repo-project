package com.siping.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.siping.bean.ExcelProperties;
import com.siping.bean.Material;
import com.siping.bean.MaterialImportBean;
import com.siping.bean.PageRequest;
import com.siping.bean.PageResponse;
import com.siping.bean.ResultBean;
import com.siping.dao.MaterialMapper;
import com.siping.service.ExcelService;
import com.siping.util.ExcelOperate;

/**
 * 导入ExcelService层
 *
 * @author siping-L.J.H
 * @date 2016年3月18日下午1:19:00
 * @version 1.0
 */
@Service
public class ExcelServiceImpl extends DefaultHandler implements ExcelService {

	@Autowired
	private MaterialMapper materialMapper;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private HttpServletRequest request;

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

	@Override
	public String excelImport(MultipartFile[] multipartFiles) throws Exception {
		ExcelProperties properties = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MaterialImportBean> list = new ArrayList<MaterialImportBean>();
		String tempTableName = "tempMaterial" + new Date().getTime();
		map.put("tableName", tempTableName);
		try {
			materialMapper.createTable(tempTableName);
			properties = new ExcelProperties(
					multipartFiles[0].getInputStream(),
					multipartFiles[0].getOriginalFilename(), 0);
			for (int j = 1, lastRowNum = properties.getLastRowNum(); j <= lastRowNum; j++) {
				System.out.println(j);
				Row row = properties.getSheet().getRow(j);
				if (null != row) {
					MaterialImportBean importBean = null;
					for (int i = 0, totalCellNum = row.getLastCellNum(); i < totalCellNum; i++) {
						Cell cell = row.getCell(i, Row.RETURN_BLANK_AS_NULL);// 空白的单元格返回null
						CellValue cellValue = properties.getFormulaEvaluator()
								.evaluate(cell);
						if (null != cell && cellValue != null) {
							if (null != importBean) {
								importBean = setMaterialExportBean(importBean,
										i, cellValue);
							} else {
								importBean = new MaterialImportBean();
								importBean = setMaterialExportBean(importBean,
										i, cellValue);
							}
						}
					}
					if (null != importBean) {
						list.add(importBean);
					}
				}
				if (list.size() == 1000) {
					map.put("list", list);
					materialMapper.insertBatch(map);
					map.remove("list");
					list.clear();
				}
			}
			if (list.size() > 0) {// 有数据时才进行操作
				map.put("list", list);
				materialMapper.insertBatch(map);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			materialMapper.dropTable(tempTableName);
		}
		return tempTableName;
	}

	public static void main(String[] args) {
		int j = 10555;
		System.out.println(10 / 3);// 取整
		System.out.println(10 % 3);// 取余
		for (int i = 0; i <= j; i++) {
			if (i % 1000 == 0) {
				System.out.println("每1000条：" + i);
			}
			if (i % 1000 > 0 && (i - (i % 1000) * 1000) % 100 == 0) {
				System.out.println("每100条：" + i);
			}
		}
	}

	@Override
	public void insertFromTempTable(String tableName) {
		Integer total = 0;
		PageRequest pageRequest = new PageRequest();
		Map<String, Object> map = new HashMap<String, Object>();
		pageRequest.setPageNo(1);
		pageRequest.setPageSize(100);
		map.put("tableName", tableName);
		total = materialMapper.getTotal(map);
		try {
			for (int i = 1, pageNum = total / 100 + 1; i <= pageNum; i++) {
				pageRequest.setPageNo(i);
				map.put("startNo", pageRequest.getStartNo());
				map.put("pageSize", pageRequest.getPageSize());
				// 方案一(使用sql语句进行批量插入)：
				// materialMapper.insertBatchTwo(map);
				// 方案二(将临时表数据取出进行数据包装，再进行批量插入)：
				List<MaterialImportBean> pros = materialMapper
						.getListByPage(map);
				insertBatchT(pros, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			materialMapper.dropTable(tableName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("resource")
	@Override
	public String createExcelTemplateFile() throws Exception {
		List<String> typeNames = materialMapper.getTypeList();
		List<String> unitNames = materialMapper.getUnitList();
		String[] typeStrings = typeNames.toArray(new String[typeNames.size()]);
		String[] unitStrings = unitNames.toArray(new String[unitNames.size()]);

		String templateFilePath = request.getServletContext().getRealPath(
				"/resources/ExcelTemplate/")
				+ "MaterialImportTemplate.xls";
		String outFilePath = request.getServletContext().getRealPath(
				"/resources/ExcelTemplate/")
				+ new Date().getTime() + ".xls";

		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(
				new FileInputStream(new File(templateFilePath))));// excel文件对象
		HSSFSheet sheetlist = wb.getSheetAt(0);// 工作表对象
		HSSFSheet sheetHidden = wb.createSheet("hidden");// 数据源工作表

		wb = (HSSFWorkbook) ExcelOperate.setCellDropDownList(wb, sheetlist,
				sheetHidden, typeStrings, 1, 10000, 3, 3, "!$A1:$A", 0,
				"typeHidden");
		wb = (HSSFWorkbook) ExcelOperate.setCellDropDownList(wb, sheetlist,
				sheetHidden, unitStrings, 1, 10000, 10, 10, "!$B1:$B", 1,
				"unitHidden");
		wb.setSheetHidden(wb.getSheetIndex("hidden"), true);
		Iterator<Row> rows = sheetlist.rowIterator();
		while (rows.hasNext()) {
			Row row = rows.next();
			Cell cell = row.createCell(15);
			cell.setCellValue(23);
			cell.setCellFormula("VLOOKUP(A4,hidden!$A:$B,2,0)");
		}
		FileOutputStream out = new FileOutputStream(outFilePath);
		wb.write(out);
		out.close();
		return outFilePath;
	}

	@SuppressWarnings("resource")
	@Override
	public String createExcelTemplateFileOne() throws Exception {
		List<ResultBean> types = materialMapper.getTypes();
		List<ResultBean> units = materialMapper.getUnits();

		String templateFilePath = request.getServletContext().getRealPath(
				"/resources/ExcelTemplate/")
				+ "MaterialImportTemplate.xls";
		String outFilePath = request.getServletContext().getRealPath(
				"/resources/ExcelTemplate/")
				+ new Date().getTime() + ".xls";

		Workbook wb = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(
				new File(templateFilePath))));// excel文件对象
		Sheet sheetlist = wb.getSheetAt(0);// 工作表对象
		Sheet sheetHidden = wb.createSheet("hidden");// 数据源工作表

		for (int i = 1; i < 10000; i++) {
			Row row = sheetlist.getRow(i);
			if (null == row) {
				row = sheetlist.createRow(i);
			}
			Cell cell = row.createCell(sheetlist.getRow(0).getLastCellNum());
			cell.setCellFormula("IF(ISNA(VLOOKUP(D" + (i + 1)
					+ ",hidden!$A:$B,2,FALSE)),\"\",VLOOKUP(D" + (i + 1)
					+ ",hidden!$A:$B,2,FALSE))");// 为每一行设置vlookup函数
			Cell cell1 = row
					.createCell(sheetlist.getRow(0).getLastCellNum() + 1);
			cell1.setCellFormula("VLOOKUP(K" + (i + 1) + ",hidden!$C:$D,2,0)");
			cell1.setCellFormula("IF(ISNA(VLOOKUP(K" + (i + 1)
					+ ",hidden!$C:$D,2,FALSE)),\"\",VLOOKUP(K" + (i + 1)
					+ ",hidden!$C:$D,2,FALSE))");
		}
		wb = ExcelOperate.setCellDropDownList(wb, sheetlist, sheetHidden,
				types, 1, 10000, 3, 3, "!$A1:$A", 0, 1, "typesHidden");
		wb = ExcelOperate.setCellDropDownList(wb, sheetlist, sheetHidden,
				units, 1, 10000, 10, 10, "!$C1:$C", 2, 3, "unitsHidden");
		sheetlist.setColumnHidden(sheetlist.getRow(0).getLastCellNum(), true);// 隐藏列
		sheetlist.setColumnHidden(sheetlist.getRow(0).getLastCellNum() + 1,
				true);// 隐藏列
		wb.setSheetHidden(wb.getSheetIndex("hidden"), true);// 隐藏sheet
		FileOutputStream out = new FileOutputStream(outFilePath);
		wb.write(out);
		out.close();
		return outFilePath;
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
				tempMaterial.setMaterialType(bean.getTypeId());
			}
			if (null != bean.getSeason()) {
				tempMaterial.setSeason(bean.getSeason());
			}

			if (null != bean.getSpecificationsModel()) {
				tempMaterial.setSpecificationsModel(bean
						.getSpecificationsModel());
			}
			if (null != bean.getUnit()) {
				tempMaterial.setUnitId(bean.getUnitId());
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
	private MaterialImportBean setMaterialExportBean(
			MaterialImportBean importBean, int i, CellValue cellValue) {
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
			importBean.setUnit(cellValue.getStringValue());
			break;
		case 11:
			importBean.setBarcode(cellValue.getStringValue());
			break;
		case 12:
			if (StringUtils.isNoneBlank(cellValue.getStringValue())) {
				importBean
						.setUnitId(Integer.valueOf(cellValue.getStringValue()));
			} else {
				importBean = null;
			}
			break;
		case 13:
			if (StringUtils.isNoneBlank(cellValue.getStringValue())) {
				importBean
						.setTypeId(Integer.valueOf(cellValue.getStringValue()));
			} else {
				importBean = null;
			}
			break;
		default:
			break;
		}
		return importBean;
	}

	private void setMaterialExportBean(MaterialImportBean importBean, int i,
			String value) {
		switch (i) {
		case 0:
			importBean.setMaterialNo(value);
			break;
		case 1:
			importBean.setMaterialName(value);
			break;
		case 2:
			importBean.setForeignName(value);
			break;
		case 3:
			importBean.setMaterialType(value);
			break;
		case 4:
			importBean.setBrand(value);
			break;
		case 5:
			importBean.setSpecificationsModel(value);
			break;
		case 6:
			importBean.setSeason(value);
			break;
		case 7:
			importBean.setIsPurchase(value);
			break;
		case 8:
			importBean.setIsSell(value);
			break;
		case 9:
			importBean.setIsInventory(value);
			break;
		case 10:
			importBean.setUnit(value);
			break;
		case 11:
			importBean.setBarcode(value);
			break;
		default:
			break;
		}
	}

	@Override
	public void test() {
		System.out.println("当前web名: " + context.getApplicationName());
		System.out.println("当前web项目绝对路径: "
				+ request.getServletContext().getRealPath("/"));
		System.out.println("当前web项目ExcelTemplate绝对路径："
				+ request.getServletContext().getRealPath(
						"/resources/ExcelTemplate/"));
		System.out.println("当前web名: " + request.getContextPath());
	}

	private List<MaterialImportBean> beans = new ArrayList<MaterialImportBean>();

	private Map<String, Object> map1 = new HashMap<String, Object>();

	@Override
	public String readExcelBySAX(MultipartFile[] multipartFiles)
			throws Exception {
		String copyFileName = request.getServletContext().getRealPath(
				"/resources/ExcelTemplate/")
				+ new Date().getTime() + ".xlsx";
		File file = new File(copyFileName);
		OutputStream out = new FileOutputStream(file);
		out.write(multipartFiles[0].getBytes());
		out.flush();
		out.close();
		String tempTableName = "tempMaterial" + new Date().getTime();
		map1.put("tableName", tempTableName);
		materialMapper.createTable(tempTableName);
		processOneSheet(copyFileName, 1);
		if (beans.size() > 0) {
			map1.put("list", beans);
			materialMapper.insertBatch(map1);
		}
		return tempTableName;
	}

	private void optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws SQLException {
		if (curRow > 0) {
			MaterialImportBean importBean = new MaterialImportBean();
			for (int k = 0; k < rowlist.size(); k++) {
				setMaterialExportBean(importBean, k, rowlist.get(k));
			}
			beans.add(importBean);
			if (beans.size() == 1000) {
				map1.put("list", beans);
				materialMapper.insertBatch(map1);
				map1.remove("list");
				beans.clear();
			}
		}
	}

	private SharedStringsTable sst;
	private String lastContents;
	private boolean nextIsString;

	private int sheetIndex = -1;
	private List<String> rowlist = new ArrayList<String>();
	private int curRow = 0;
	private int curCol = 0;

	// 当前遍历的Excel单元格列索引
	private int thisColumnIndex = -1;

	// 只遍历一个sheet，其中sheetId为要遍历的sheet索引，从1开始，1-3
	private void processOneSheet(String filename, int sheetId) throws Exception {
		OPCPackage pkg = OPCPackage.open(filename);
		XSSFReader r = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();

		XMLReader parser = fetchSheetParser(sst);

		// rId2 found by processing the Workbook
		// 根据 rId# 或 rSheet# 查找sheet
		InputStream sheet2 = r.getSheet("rId" + sheetId);
		sheetIndex++;
		InputSource sheetSource = new InputSource(sheet2);
		parser.parse(sheetSource);
		sheet2.close();
	}

	/**
	 * 遍历 excel 文件
	 */
	private void process(String filename) throws Exception {
		OPCPackage pkg = OPCPackage.open(filename);
		XSSFReader r = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();

		XMLReader parser = fetchSheetParser(sst);

		Iterator<InputStream> sheets = r.getSheetsData();
		while (sheets.hasNext()) {
			curRow = 0;
			sheetIndex++;
			InputStream sheet = sheets.next();
			InputSource sheetSource = new InputSource(sheet);
			parser.parse(sheetSource);
			sheet.close();
		}
	}

	private XMLReader fetchSheetParser(SharedStringsTable sst)
			throws SAXException {
		XMLReader parser = XMLReaderFactory
				.createXMLReader("org.apache.xerces.parsers.SAXParser");
		this.sst = sst;
		parser.setContentHandler(this);
		return parser;
	}

	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		// c => 单元格
		if (name.equals("c")) {
			// 如果下一个元素是 SST 的索引，则将nextIsString标记为true
			String cellType = attributes.getValue("t");
			if (cellType != null && cellType.equals("s")) {
				nextIsString = true;
			} else {
				nextIsString = false;
			}
		}
		// 置空
		lastContents = "";
	}

	public void endElement(String uri, String localName, String name)
			throws SAXException {
		// 根据SST的索引值的到单元格的真正要存储的字符串
		// 这时characters()方法可能会被调用多次
		if (nextIsString) {
			try {
				int idx = Integer.parseInt(lastContents);
				lastContents = new XSSFRichTextString(sst.getEntryAt(idx))
						.toString();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

		// v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引
		// 将单元格内容加入rowlist中，在这之前先去掉字符串前后的空白符
		if (name.equals("v")) {
			paddingNullCell();
			String value = lastContents.trim();
			value = value.equals("") ? " " : value;
			rowlist.add(curCol, value);
			curCol++;
		} else {
			// 如果标签名称为 row ，这说明已到行尾，调用 optRows() 方法
			if (name.equals("row")) {
				try {
					optRows(sheetIndex, curRow, rowlist);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rowlist.clear();
				curRow++;
				curCol = 0;
				thisColumnIndex = 0;
			}
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// 得到单元格内容的值
		lastContents += new String(ch, start, length);
	}

	/**
	 * 空的单元个填充
	 */
	private void paddingNullCell() {
		int index = curCol;
		if (thisColumnIndex > index) {
			for (int i = index; i < thisColumnIndex; i++) {
				rowlist.add(curCol, "");
				curCol++;
			}
		}
	}

	/**
	 * 从列名转换为列索引
	 * 
	 * @param name
	 * @return
	 */
	private static int nameToColumn(String name) {
		int column = -1;
		for (int i = 0; i < name.length(); ++i) {
			int c = name.charAt(i);
			column = (column + 1) * 26 + c - 'A';
		}
		return column;
	}

}
