/*     */ package org.mybatis.generator.plugins;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.GeneratedXmlFile;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.PluginAdapter;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.Document;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class SqlMapConfigPlugin extends PluginAdapter
/*     */ {
/*     */   private List<String> sqlMapFiles;
/*     */ 
/*     */   public SqlMapConfigPlugin()
/*     */   {
/*  60 */     this.sqlMapFiles = new ArrayList();
/*     */   }
/*     */ 
/*     */   public boolean validate(List<String> warnings) {
/*  64 */     boolean valid = true;
/*     */ 
/*  66 */     if (!StringUtility.stringHasValue(this.properties.getProperty("targetProject")))
/*     */     {
/*  68 */       warnings.add(Messages.getString("ValidationError.18", "SqlMapConfigPlugin", "targetProject"));
/*     */ 
/*  71 */       valid = false;
/*     */     }
/*     */ 
/*  74 */     if (!StringUtility.stringHasValue(this.properties.getProperty("targetPackage")))
/*     */     {
/*  76 */       warnings.add(Messages.getString("ValidationError.18", "SqlMapConfigPlugin", "targetPackage"));
/*     */ 
/*  79 */       valid = false;
/*     */     }
/*     */ 
/*  82 */     return valid;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles()
/*     */   {
/*  87 */     Document document = new Document("-//ibatis.apache.org//DTD SQL Map Config 2.0//EN", "http://ibatis.apache.org/dtd/sql-map-config-2.dtd");
/*     */ 
/*  91 */     XmlElement root = new XmlElement("sqlMapConfig");
/*  92 */     document.setRootElement(root);
/*     */ 
/*  94 */     root.addElement(new TextElement("<!--"));
/*  95 */     root.addElement(new TextElement("  This file is generated by MyBatis Generator."));
/*     */ 
/*  97 */     root.addElement(new TextElement("  This file is the shell of an SqlMapConfig file - in many cases you will need to add"));
/*     */ 
/* 100 */     root.addElement(new TextElement("    to this file before it is usable by iBATIS."));
/*     */ 
/* 103 */     StringBuilder sb = new StringBuilder();
/* 104 */     sb.append("  This file was generated on ");
/* 105 */     sb.append(new Date());
/* 106 */     sb.append('.');
/* 107 */     root.addElement(new TextElement(sb.toString()));
/*     */ 
/* 109 */     root.addElement(new TextElement("-->"));
/*     */ 
/* 111 */     XmlElement settings = new XmlElement("settings");
/* 112 */     settings.addAttribute(new Attribute("useStatementNamespaces", "true"));
/* 113 */     root.addElement(settings);
/*     */ 
/* 116 */     for (String sqlMapFile : this.sqlMapFiles) {
/* 117 */       XmlElement sqlMap = new XmlElement("sqlMap");
/* 118 */       sqlMap.addAttribute(new Attribute("resource", sqlMapFile));
/* 119 */       root.addElement(sqlMap);
/*     */     }
/*     */ 
/* 122 */     GeneratedXmlFile gxf = new GeneratedXmlFile(document, this.properties.getProperty("fileName", "SqlMapConfig.xml"), this.properties.getProperty("targetPackage"), this.properties.getProperty("targetProject"), false);
/*     */ 
/* 128 */     List answer = new ArrayList(1);
/* 129 */     answer.add(gxf);
/*     */ 
/* 131 */     return answer;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable)
/*     */   {
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append(sqlMap.getTargetPackage());
/* 143 */     sb.append('.');
/* 144 */     String temp = sb.toString();
/* 145 */     sb.setLength(0);
/* 146 */     sb.append(temp.replace('.', '/'));
/* 147 */     sb.append(sqlMap.getFileName());
/* 148 */     this.sqlMapFiles.add(sb.toString());
/*     */ 
/* 150 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.plugins.SqlMapConfigPlugin
 * JD-Core Version:    0.6.0
 */