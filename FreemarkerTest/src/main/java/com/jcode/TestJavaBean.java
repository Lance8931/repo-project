package com.jcode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年7月5日下午3:14:37
 * @version 1.0
 */
public class TestJavaBean {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBTable dbTable = new DBTable("article", "Article");
		String javaFileName = dbTable.getJavaBeanName();
		String packageName = "com.jcode.model";
		Configuration cfg = new Configuration();
		try {
			cfg.setClassForTemplateLoading(TestJavaBean.class, "/com/jcode"); // 指定模板所在的classpath目录
			cfg.setSharedVariable("upperFC", new UpperFirstCharacter()); // 添加一个"宏"共享变量用来将属性名首字母大写
			Template t = cfg.getTemplate("javabean.html"); // 指定模板
			FileOutputStream fos = new FileOutputStream(new File(
					"d:/Student1.java")); // java文件的生成目录

			/* 从数据库获取表名与字段 */
			DBHelper.kkk(dbTable);
			// 模拟数据源
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("package", packageName); // 包名
			data.put("className", javaFileName);

			List<Object> pros = new ArrayList<Object>();
			List<String> importList = new ArrayList<String>();// 需要导入的包
			Map<String, Object> pro = null;
			ColumnsHander columnsHander = new ColumnsHander();
			for (DBColumn dbColumns : dbTable.getAllDbColumns()) {
				pro = new HashMap<String, Object>();
				pro.put("proType",
						columnsHander.returnType(dbColumns.getJavaType()));
				pro.put("proName", dbColumns.getDbColumnName());
				pro.put("proComment", dbColumns.getDbComment());
				if (columnsHander.getImportString() != null) {
					importList.add(columnsHander.getImportString());
				}
				pros.add(pro);
			}

			data.put("importList", importList);
			data.put("properties", pros);
			t.process(data, new OutputStreamWriter(fos, "utf-8")); //
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
