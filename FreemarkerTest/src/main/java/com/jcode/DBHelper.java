package com.jcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年7月5日下午4:00:17
 * @version 1.0
 */
public class DBHelper {
	public static final String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "password";

	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBHelper(String sql) {
		try {
			Class.forName(name);// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			pst = conn.prepareStatement(sql);// 准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void kkk(DBTable dbTable) {
		String sql = "show full columns from " + dbTable.getDbName();// SQL语句
		DBHelper db1 = new DBHelper(sql);// 创建DBHelper对象
		List<DBColumn> columns = new ArrayList<DBColumn>();
		DBColumn column = null;
		try {
			ResultSet ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				column = new DBColumn();
				column.setDbColumnName(ret.getString("Field"));
				column.setDbType(ret.getString("Type"));
				column.setDbComment(ret.getString("Comment"));
				if (ret.getString("Key").equals("PRI")) {
					column.setIsKey(true);
					dbTable.setKeyDbColumn(column);
				}
				columns.add(column);
				System.out.println(column.getDbColumnName() + "    "
						+ column.getDbType() + "   " + column.getDbComment());
			}// 显示数据
			dbTable.setAllDbColumns(columns);
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
