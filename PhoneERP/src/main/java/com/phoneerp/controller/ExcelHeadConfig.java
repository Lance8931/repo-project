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
	 *         其中，Value中的数字代表了该字段应放的列数，文字代表表头名称；Key值表示应该从Datas中应获取的数据对应的字段名
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
}
