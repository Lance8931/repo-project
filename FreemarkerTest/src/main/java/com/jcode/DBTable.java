package com.jcode;

import java.util.List;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年7月6日下午4:26:24
 * @version 1.0
 */
public class DBTable {
	private String dbName; // 数据库表名
	private String javaBeanName;// javaBean文件名
	private String dbComment;// 数据库表备注(暂无)
	private DBColumn keyDbColumn;// 表的主键字段
	private List<DBColumn> allDbColumns;// 表的其余字段

	public DBTable() {
	}

	public DBTable(String dbName, String javaBeanName) {
		this.dbName = dbName;
		this.javaBeanName = javaBeanName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbComment() {
		return dbComment;
	}

	public void setDbComment(String dbComment) {
		this.dbComment = dbComment;
	}

	public DBColumn getKeyDbColumn() {
		return keyDbColumn;
	}

	public void setKeyDbColumn(DBColumn keyDbColumn) {
		this.keyDbColumn = keyDbColumn;
	}

	public String getJavaBeanName() {
		return javaBeanName;
	}

	public void setJavaBeanName(String javaBeanName) {
		this.javaBeanName = javaBeanName;
	}

	public List<DBColumn> getAllDbColumns() {
		return allDbColumns;
	}

	public void setAllDbColumns(List<DBColumn> allDbColumns) {
		this.allDbColumns = allDbColumns;
	}

}
