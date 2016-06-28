package com.phoneerp.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.phoneerp.bean.Allot;
import com.phoneerp.bean.ExcelProperties;
import com.phoneerp.bean.Orders;
import com.phoneerp.bean.Phone;
import com.phoneerp.bean.PhoneExportBean;
import com.phoneerp.bean.PhoneImportBean;
import com.phoneerp.bean.Purchase;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.bean.SearchPhoneListBean;
import com.phoneerp.dao.AllotMapper;
import com.phoneerp.dao.BrandMapper;
import com.phoneerp.dao.ColorMapper;
import com.phoneerp.dao.ExcelExportMapper;
import com.phoneerp.dao.ModelMapper;
import com.phoneerp.dao.OrdersMapper;
import com.phoneerp.dao.PhoneMapper;
import com.phoneerp.dao.PurchaseMapper;
import com.phoneerp.dao.ShopMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月15日下午4:01:52
 * @version 1.0
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	private PhoneMapper phoneMapper;

	@Autowired
	private PurchaseMapper purchaseMapper;

	@Autowired
	private AllotMapper allotMapper;

	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
	private ColorMapper colorMapper;

	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ShopMapper shopMapper;

	@Autowired
	private ExcelExportController excelExportController;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ExcelExportMapper excelExportMapper;

	@RequestMapping("/imeiNoCheck")
	@ResponseBody
	public ResultMsg imeiNoCheck(String imeiNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		SearchPhoneListBean searchPhoneListBean = new SearchPhoneListBean();
		searchPhoneListBean.setImeiNo(imeiNo);
		paramMap.put("searchBean", searchPhoneListBean);
		paramMap.put("isCheck", true);
		if (phoneMapper.getCount(paramMap) > 0) {
			return new ResultMsg(false, "存在。");
		} else {
			return new ResultMsg(true, "不存在。");
		}
	}

	/**
	 * 采购
	 * 
	 * @param phone
	 * @return
	 *
	 * @date 2016年5月18日下午3:59:43
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg add(Phone phone) {
		Purchase purchase = phone.getPurchase();
		purchase.setShopId(phone.getCurrentShopId());
		purchase.setPrice(phone.getPurPrice());
		try {
			phoneMapper.insertSelective(phone);
			purchase.setPhoneId(phone.getId());
			purchaseMapper.insertSelective(purchase);
			return new ResultMsg(true, "成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "失败。");
		}

	}

	/**
	 * 获取列表
	 * 
	 * @param phone
	 * @return
	 *
	 * @date 2016年5月18日下午3:59:57
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/getPhoneList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getPhoneList(SearchPhoneListBean searchPhoneListBean, Long page, Long rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchBean", searchPhoneListBean);
		paramMap.put("startNo", (page - 1) * rows);
		paramMap.put("pageSize", rows);
		try {
			map.put("rows", phoneMapper.getList(paramMap));
			map.put("total", phoneMapper.getCount(paramMap));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加调拨单
	 * 
	 * @param allot
	 * @return
	 *
	 * @date 2016年5月18日下午4:08:35
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/addAllot", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addAllot(Allot allot) {
		Phone phone = new Phone();
		phone.setId(allot.getId());
		phone.setCurrentShopId(allot.getInShopId());
		allot.setId(null);
		allot.setPhoneId(phone.getId());
		try {
			phoneMapper.updateByPrimaryKeySelective(phone);
			allotMapper.insertSelective(allot);
			return new ResultMsg(true, "成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "失败。");
		}
	}

	@RequestMapping(value = "/addOrders", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addSale(Orders orders) {
		Phone phone = new Phone();
		phone.setId(orders.getId());
		phone.setAmount(0);
		phone.setSalePrice(orders.getBillPrice());
		phone.setIsSold(true);
		orders.setId(null);
		orders.setPhoneId(phone.getId());
		try {
			phoneMapper.updateByPrimaryKeySelective(phone);
			ordersMapper.insertSelective(orders);
			return new ResultMsg(true, "成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "失败。");
		}

	}

	@RequestMapping(value = "/getPhone", method = RequestMethod.GET)
	@ResponseBody
	public Phone getPhone(int id) {
		try {
			return phoneMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/importPhones", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg importPurPhones(@RequestParam MultipartFile importExcel) throws Exception {
		// try {
		// Thread.sleep(5000);
		// System.out.println("sdfsd");
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// return new ResultMsg(true, "成功");
		return excelImport(importExcel);
	}

	@RequestMapping(value = "/valiPhones", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg valiPhoneDatas(@RequestParam MultipartFile importExcel) throws Exception {
		// try {
		// Thread.sleep(5000);
		// System.out.println("sdfsdf");
		// } catch (InterruptedException e) {
		// e.printStackTrace();d
		// }
		// return new ResultMsg(true, null);
		return validata(importExcel);
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(SearchPhoneListBean searchPhoneListBean, String type) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		String filePath = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchBean", searchPhoneListBean);
		List<PhoneExportBean> queryData = excelExportMapper.getList(paramMap);
		filePath = excelExportController.exportData(queryData, new ExcelHeadConfig().getPhonesExcelHead(), "手机列表",
				request);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", new String("手机信息下载.xlsx".getBytes("UTF-8"), "iso-8859-1"));
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)), headers,
				HttpStatus.CREATED);
	}

	private ResultMsg validata(MultipartFile multipartFile) throws Exception {
		ExcelProperties properties = null;
		try {
			properties = new ExcelProperties(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), 0);
			for (int j = 1, lastRowNum = properties.getLastRowNum(); j <= lastRowNum; j++) {
				Row row = properties.getSheet().getRow(j);
				if (null != row) {
					for (int i = 0, totalCellNum = row.getLastCellNum(); i < totalCellNum; i++) {
						String cellValue = getCellValue(row.getCell(i));
						if (i == 1) {
							if (phoneMapper.getCountByImeiNo(cellValue) > 0) {
								return new ResultMsg(false, "第" + (j + 1) + "行手机串号：" + cellValue + "已存在。");
							}
						}
						if (i == 2) {
							if (colorMapper.getCountByColorName(cellValue) <= 0) {
								return new ResultMsg(false, "第" + (j + 1) + "行手机颜色：" + cellValue + "不存在。");
							}
						}
						if (i == 3) {
							if (brandMapper.getCountByBrandName(cellValue) <= 0) {
								return new ResultMsg(false, "第" + (j + 1) + "行手机牌子：" + cellValue + "不存在。");
							}
						}
						if (i == 4) {
							if (modelMapper.getCountByModelName(cellValue) <= 0) {
								return new ResultMsg(false, "第" + (j + 1) + "行手机型号：" + cellValue + "不存在。");
							}
						}
						if (i == 6) {
							if (shopMapper.getCountByShopName(cellValue) <= 0) {
								return new ResultMsg(false, "第" + (j + 1) + "行所属店铺：" + cellValue + "不存在。");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultMsg(true, null);
	}

	private ResultMsg excelImport(MultipartFile multipartFiles) throws Exception {
		ExcelProperties properties = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhoneImportBean> list = new ArrayList<PhoneImportBean>();
		String tempTableName = "phone_temp_" + new Date().getTime();
		map.put("tableName", tempTableName);
		try {
			phoneMapper.createTable(tempTableName);
			properties = new ExcelProperties(multipartFiles.getInputStream(), multipartFiles.getOriginalFilename(), 0);
			for (int j = 1, lastRowNum = properties.getLastRowNum(); j <= lastRowNum; j++) {
				Row row = properties.getSheet().getRow(j);
				if (null != row) {
					PhoneImportBean importBean = null;
					for (int i = 0, totalCellNum = row.getLastCellNum(); i < totalCellNum; i++) {
						Cell cell = row.getCell(i, Row.RETURN_BLANK_AS_NULL);// 空白的单元格返回null
						CellValue cellValue = properties.getFormulaEvaluator().evaluate(cell);
						if (null != cell && cellValue != null) {
							if (null != importBean) {
								importBean = setPhoneExportBean(importBean, i, getCellValue(cell));
							} else {
								importBean = new PhoneImportBean();
								importBean = setPhoneExportBean(importBean, i, getCellValue(cell));
							}
						}
					}
					if (null != importBean) {
						list.add(importBean);
					}
				}
				if (list.size() == 1000) {
					map.put("list", list);
					phoneMapper.insertBatch(map);
					map.remove("list");
					list.clear();
				}
			}
			if (list.size() > 0) {// 有数据时才进行操作
				map.put("list", list);
				phoneMapper.insertBatch(map);
			}

			phoneMapper.insertDatasFromTemp(tempTableName);

			phoneMapper.insertPurDatas(tempTableName);

			return new ResultMsg(true, "导入成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			phoneMapper.dropTable(tempTableName);
		}
		return new ResultMsg(false, "导入失败");
	}

	private PhoneImportBean setPhoneExportBean(PhoneImportBean importBean, int i, String value) {
		switch (i) {
		case 0:
			importBean.setPurTime(value);
			break;
		case 1:
			importBean.setImeiNo(value);
			break;
		case 2:
			importBean.setColor(value);
			break;
		case 3:
			importBean.setBrand(value);
			break;
		case 4:
			importBean.setModel(value);
			break;
		case 5:
			importBean.setPurPrice(value);
			break;
		case 6:
			importBean.setCurrentShop(value);
			break;
		case 8:
			importBean.setPhoneType(value);
			break;
		default:
			break;
		}
		return importBean;
	}

	private String getCellValue(Cell cell) {
		String value = "";
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				// 如果是date类型则 ，获取该cell的date值
				value = DateFormat.getDateInstance().format(DateUtil.getJavaDate(cell.getNumericCellValue()));// 返回算好的值
			} else {
				value = String.valueOf(Double.valueOf(cell.getNumericCellValue()).intValue());
			}
			break;
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = (cell.getBooleanCellValue() == true ? 1 : 0) + "";
			break;
		case Cell.CELL_TYPE_ERROR:
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
		default:
			break;
		}
		return value;
	}
}
