package com.jcode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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
public class TestMapperXml {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBTable dbTable = new DBTable("article", "Article");
		String javaFileName = dbTable.getJavaBeanName();
		String packageName = "com.jcode";
		String mapperJavaFileName = javaFileName + "Mapper";
		String xmlFileName = mapperJavaFileName;
		String nameSpace = "com.jcode.dao";

		Configuration cfg = new Configuration();
		try {
			cfg.setClassForTemplateLoading(TestMapperXml.class, "/com/jcode"); // 指定模板所在的classpath目录
			cfg.setSharedVariable("upperFC", new UpperFirstCharacter()); // 添加一个"宏"共享变量用来将属性名首字母大写
			Template t = cfg.getTemplate("mapperxml.html"); // 指定模板
			FileOutputStream fos = new FileOutputStream(new File(
					"d:/Student12.java")); // java文件的生成目录

			/* 从数据库获取表名与字段 */
			DBHelper.kkk(dbTable);
			// 模拟数据源
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("nameSpace", nameSpace); // 命名空间名称
			data.put("dbTable", dbTable);
			data.put("javaFileNamePath", packageName + javaFileName);

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
