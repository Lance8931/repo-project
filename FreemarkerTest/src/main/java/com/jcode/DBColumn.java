package com.jcode;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年7月5日下午4:14:31
 * @version 1.0
 */
public class DBColumn {
	private String javaField;// javabean的字段名
	private String javaType;// javabean的数据类型
	private String dbType;// 数据库字段的数据类型
	private String dbComment;// 数据库字段备注
	private String dbColumnName;// 数据库字段名
	private Boolean isKey = false;// 是否主键(默认不是)

	public String getJavaField() {
		return javaField;
	}

	public void setJavaField(String javaField) {
		String returnString = "";
		String[] strings = javaField.split("_");
		for (int i = 1; i < strings.length; i++) {
			strings[i] = strings[i].substring(0, 1).toUpperCase()
					+ strings[i].substring(1);
			System.out.println(strings[i]);
			returnString += strings[i];
		}
		if (strings.length > 0) {
			this.javaField = strings[0] + returnString;
		} else {
			this.javaField = javaField;
		}
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
		;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType
				.substring(
						0,
						dbType.indexOf("(") > 0 ? dbType.indexOf("(") : dbType
								.length()).toLowerCase();
		setJavaType(dbType);
	}

	public String getDbComment() {
		return dbComment;
	}

	public void setDbComment(String dbComment) {
		this.dbComment = dbComment;
	}

	public String getDbColumnName() {
		return dbColumnName;
	}

	public void setDbColumnName(String dbColumnName) {
		this.dbColumnName = dbColumnName;
		setJavaField(dbColumnName);
	}

	public Boolean getIsKey() {
		return isKey;
	}

	public void setIsKey(Boolean isKey) {
		this.isKey = isKey;
	}

}
