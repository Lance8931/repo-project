package com.siping.util;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 扩展mybatis 自动生成代码插件
 *
 * 扩展方法有：condition、sets、getAll、deleteByIds、get、page、getCount
 * 
 * @author L.J.H
 * @version 1.0
 * @created 2016年3月2日 下午14:22:51
 */
public class MyBatisPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	// 此方法可用于将附加的XML元素添加到生成的mapper文件
	@Override
	public boolean sqlMapDocumentGenerated(Document document,
			IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();

		// 查询公用条件
		XmlElement conditionSql = new XmlElement("sql");
		conditionSql.addAttribute(new Attribute("id", "conditions"));
		XmlElement trim = new XmlElement("trim");
		trim.addAttribute(new Attribute("prefix", "where"));
		trim.addAttribute(new Attribute("prefixOverrides", "and|or"));
		trim.addElement(new TextElement(" 1 = 1"));
		List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
		for (IntrospectedColumn introspectedColumn : columns) {
			XmlElement ifXml = new XmlElement("if");
			ifXml.addAttribute(new Attribute("test", introspectedColumn
					.getJavaProperty() + " != null"));
			ifXml.addElement(new TextElement("and t."
					+ introspectedColumn.getActualColumnName() + " = #{"
					+ introspectedColumn.getJavaProperty() + "}"));
			trim.addElement(ifXml);
		}
		conditionSql.addElement(trim);

		// 修改公用条件
		XmlElement setSql = new XmlElement("sql");
		setSql.addAttribute(new Attribute("id", "sets"));
		XmlElement setTrim = new XmlElement("trim");
		setTrim.addAttribute(new Attribute("prefix", "SET"));
		setTrim.addAttribute(new Attribute("suffixOverrides", ","));
		List<IntrospectedColumn> noPrimaryKeyColumns = introspectedTable
				.getNonPrimaryKeyColumns();
		for (IntrospectedColumn introspectedColumn : noPrimaryKeyColumns) {
			XmlElement ifXml = new XmlElement("if");
			ifXml.addAttribute(new Attribute("test", introspectedColumn
					.getActualColumnName() + " != null"));
			ifXml.addElement(new TextElement("t."
					+ introspectedColumn.getActualColumnName() + " = #{"
					+ introspectedColumn.getJavaProperty() + "}"));
			setTrim.addElement(ifXml);
		}
		setSql.addElement(setTrim);

		// getAll
		XmlElement getAllElement = new XmlElement("select");
		getAllElement.addAttribute(new Attribute("id", "getAll"));
		getAllElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		getAllElement.addElement(new TextElement("select * from "
				+ introspectedTable.getFullyQualifiedTableNameAtRuntime()));

		// deleteByIds
		XmlElement deleteByIds = new XmlElement("delete");
		deleteByIds.addAttribute(new Attribute("id", "deleteByIds"));
		String id = introspectedTable.getPrimaryKeyColumns().size() > 0 ? introspectedTable
				.getPrimaryKeyColumns().get(0).getActualColumnName()
				: "id";
		deleteByIds.addElement(new TextElement(" delete from "
				+ introspectedTable.getFullyQualifiedTableNameAtRuntime()
				+ " where " + id + " in "));
		XmlElement deleteByIdsForeach = new XmlElement("foreach");
		deleteByIdsForeach.addAttribute(new Attribute("collection", "list"));
		deleteByIdsForeach.addAttribute(new Attribute("item", "item"));
		deleteByIdsForeach.addAttribute(new Attribute("index", "index"));
		deleteByIdsForeach.addAttribute(new Attribute("separator", ","));
		deleteByIdsForeach.addAttribute(new Attribute("open", "("));
		deleteByIdsForeach.addAttribute(new Attribute("close", ")"));
		deleteByIdsForeach.addElement(new TextElement("#{item}"));
		deleteByIds.addElement(deleteByIdsForeach);

		// get
		XmlElement get = new XmlElement("select");
		get.addAttribute(new Attribute("id", "get"));
		get.addAttribute(new Attribute("parameterType", "java.util.Map"));
		get.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		get.addElement(new TextElement("select *  from "
				+ introspectedTable.getFullyQualifiedTableNameAtRuntime()
				+ " t"));
		get.addElement(new TextElement("<include refid=\"conditions\"/>"));

		// getCount
		XmlElement getCount = new XmlElement("select");
		getCount.addAttribute(new Attribute("id", "getCount"));
		getCount.addAttribute(new Attribute("parameterType", "java.util.Map"));
		getCount.addAttribute(new Attribute("resultType", "java.lang.Long"));
		getCount.addElement(new TextElement(" select count(*) from "
				+ introspectedTable.getFullyQualifiedTableNameAtRuntime()
				+ " t"));
		getCount.addElement(new TextElement("<include refid=\"conditions\"/>"));

		// getByPage
		XmlElement page = new XmlElement("select");
		page.addAttribute(new Attribute("id", "getByPage"));
		page.addAttribute(new Attribute("parameterType", "java.util.Map"));
		page.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		page.addElement(new TextElement("select * from "
				+ introspectedTable.getFullyQualifiedTableNameAtRuntime()
				+ " t"));
		page.addElement(new TextElement("<include refid=\"conditions\"/>"));
		XmlElement ifXml = new XmlElement("if");
		ifXml.addAttribute(new Attribute("test", "startNo != null"));
		ifXml.addElement(new TextElement("LIMIT #{startNo},#{pageSize}"));
		page.addElement(ifXml);

		parentElement.addElement(conditionSql);
		parentElement.addElement(setSql);
		parentElement.addElement(getAllElement);
		parentElement.addElement(deleteByIds);
		parentElement.addElement(get);
		parentElement.addElement(getCount);
		parentElement.addElement(page);

		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
}
