package com.gaosheng.util.examples.xls;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.gaosheng.util.xls.XxlsAbstract;

public class XxlsPrint extends XxlsAbstract {

	@Override
	public void optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws SQLException {
		for (int i = 0; i < rowlist.size(); i++) {
			if (StringUtils.isNotBlank(rowlist.get(i))) {

			}
			System.out.print("'" + rowlist.get(i) + "',");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		XxlsPrint howto = new XxlsPrint();
		Long startTime = new Date().getTime();
		System.out.println("开始导入：" + startTime);
		howto.processOneSheet("D:/test.xlsx", 1);
		Long endTime = new Date().getTime();
		System.out.println("结束导入：" + endTime);
		System.out.println("间隔时间：" + (endTime - startTime) / 1000);
		// howto.processAllSheets("F:/new.xlsx");
	}
}
