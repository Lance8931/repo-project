package com.jcode;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Ref;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年7月5日下午4:38:28
 * @version 1.0
 */
public class ColumnsHander {
	private String importString;

	public String getImportString() {
		return importString;
	}

	public void setImportString(String importString) {
		this.importString = importString;
	}

	public String returnType(String type) {
		String returnString = null;
		setImportString(null);
		switch (type) {
		case "int":
			returnString = "int";
			break;
		case "varchar":
		case "text":
			returnString = String.class.getSimpleName();
			break;
		case "char":
			returnString = "char";
			break;
		case "longvarchar":
			returnString = String.class.getSimpleName();
			break;
		case "bit":
			returnString = Boolean.class.getSimpleName();
			break;
		case "numeric":
			returnString = BigDecimal.class.getSimpleName();
			setImportString(BigDecimal.class.getCanonicalName());
			break;
		case "tinyint":
			returnString = "byte";
			break;
		case "smallint":
			returnString = "short";
			break;
		case "integer":
			returnString = Integer.class.getSimpleName();
			break;
		case "bigint":
			returnString = Long.class.getSimpleName();
			break;
		case "real":
		case "float":
			returnString = Float.class.getSimpleName();

		case "double":
			returnString = Double.class.getSimpleName();
			break;
		case "varbinary":
		case "binary":
			returnString = Byte.class.getSimpleName() + "[]";
			break;
		case "date":
			returnString = Date.class.getSimpleName();
			setImportString(Date.class.getCanonicalName());
			break;
		case "time":
			returnString = Time.class.getSimpleName();
			setImportString(Time.class.getCanonicalName());
			break;
		case "timestamp":
			returnString = Timestamp.class.getSimpleName();
			setImportString(Timestamp.class.getCanonicalName());
			break;
		case "clob":
			returnString = Clob.class.getSimpleName();
			setImportString(Clob.class.getCanonicalName());
			break;
		case "blob":
			returnString = Blob.class.getSimpleName();
			setImportString(Blob.class.getCanonicalName());
			break;
		case "array":
			returnString = Array.class.getSimpleName();
			setImportString(Array.class.getCanonicalName());
			break;
		case "ref":
			returnString = Ref.class.getSimpleName();
			setImportString(Ref.class.getCanonicalName());
			break;
		case "struct":
			returnString = Struct.class.getSimpleName();
			setImportString(Struct.class.getCanonicalName());
			break;
		default:
			break;
		}
		return returnString;
	}

}
