package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月28日下午4:39:03
 * @version 1.0
 */

public class ExcelHeadConfig {
	private Map<String, String> tableHead = null;

	public ExcelHeadConfig() {
		tableHead = new HashMap<String, String>();
	}

	/**
	 * 测评账号导出表头信息
	 *
	 * @return
	 *
	 * 		其中，Value中的数字代表了该字段应放的列数，文字代表表头名称；Key值表示应该从Datas中应获取的数据对应的字段名
	 *         如：从数据库取出的数据字段名为
	 *         ：assessAccountStartTime，那么对应的Key值就是assessAccountStartTime
	 *         如果是StartTime，那么对应的Key值就是StartTime
	 */
	public Map<String, String> getAccountExcelHead() {
		tableHead.put("assessAccountStartTime", "0#测评开始时间");
		tableHead.put("assessAccountStopTime", "1#测评结束时间");
		tableHead.put("assessAccountState", "2#测评状态");
		tableHead.put("assessAccountBatch", "3#测评批次");
		tableHead.put("assessAccountAccount", "4#测评账号");
		tableHead.put("assessAccountPwd", "5#测评账号密码");
		return tableHead;
	}

	public Map<String, String> getPhonesExcelHead() {
		tableHead.put("imeiNo", "0#手机串号");
		tableHead.put("brandName", "1#手机牌子");
		tableHead.put("colorName", "2#手机颜色");
		tableHead.put("modelName", "3#手机型号");
		tableHead.put("phoneType", "4#手机类型");
		tableHead.put("purPrice", "5#采购价格");
		tableHead.put("profit", "6#利润");
		tableHead.put("isSold", "7#是否卖出");
		tableHead.put("purTime", "8#采购时间");
		tableHead.put("shopName", "9#当前店铺");
		tableHead.put("billPrice", "10#销售价格");
		tableHead.put("orderTime", "11#销售时间");
		tableHead.put("salerName", "12#销售员");
		return tableHead;
	}
}
