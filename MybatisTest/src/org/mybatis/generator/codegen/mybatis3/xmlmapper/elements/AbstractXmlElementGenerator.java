/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.AbstractGenerator;
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public abstract class AbstractXmlElementGenerator extends AbstractGenerator
/*     */ {
/*     */   public abstract void addElements(XmlElement paramXmlElement);
/*     */ 
/*     */   protected XmlElement getSelectKey(IntrospectedColumn introspectedColumn, GeneratedKey generatedKey)
/*     */   {
/*  50 */     String identityColumnType = introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName();
/*     */ 
/*  53 */     XmlElement answer = new XmlElement("selectKey");
/*  54 */     answer.addAttribute(new Attribute("resultType", identityColumnType));
/*  55 */     answer.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
/*     */ 
/*  57 */     if (StringUtility.stringHasValue(generatedKey.getType())) {
/*  58 */       if ("pre".equalsIgnoreCase(generatedKey.getType()))
/*  59 */         answer.addAttribute(new Attribute("order", "BEFORE"));
/*  60 */       else if ("post".equalsIgnoreCase(generatedKey.getType()))
/*  61 */         answer.addAttribute(new Attribute("order", "AFTER"));
/*     */       else {
/*  63 */         answer.addAttribute(new Attribute("order", generatedKey.getType()));
/*     */       }
/*     */     }
/*     */ 
/*  67 */     answer.addElement(new TextElement(generatedKey.getRuntimeSqlStatement()));
/*     */ 
/*  71 */     return answer;
/*     */   }
/*     */ 
/*     */   protected XmlElement getBaseColumnListElement() {
/*  75 */     XmlElement answer = new XmlElement("include");
/*  76 */     answer.addAttribute(new Attribute("refid", this.introspectedTable.getBaseColumnListId()));
/*     */ 
/*  78 */     return answer;
/*     */   }
/*     */ 
/*     */   protected XmlElement getBlobColumnListElement() {
/*  82 */     XmlElement answer = new XmlElement("include");
/*  83 */     answer.addAttribute(new Attribute("refid", this.introspectedTable.getBlobColumnListId()));
/*     */ 
/*  85 */     return answer;
/*     */   }
/*     */ 
/*     */   protected XmlElement getExampleIncludeElement() {
/*  89 */     XmlElement ifElement = new XmlElement("if");
/*  90 */     ifElement.addAttribute(new Attribute("test", "_parameter != null"));
/*     */ 
/*  92 */     XmlElement includeElement = new XmlElement("include");
/*  93 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getExampleWhereClauseId()));
/*     */ 
/*  95 */     ifElement.addElement(includeElement);
/*     */ 
/*  97 */     return ifElement;
/*     */   }
/*     */ 
/*     */   protected XmlElement getUpdateByExampleIncludeElement() {
/* 101 */     XmlElement ifElement = new XmlElement("if");
/* 102 */     ifElement.addAttribute(new Attribute("test", "_parameter != null"));
/*     */ 
/* 104 */     XmlElement includeElement = new XmlElement("include");
/* 105 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
/*     */ 
/* 107 */     ifElement.addElement(includeElement);
/*     */ 
/* 109 */     return ifElement;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator
 * JD-Core Version:    0.6.0
 */