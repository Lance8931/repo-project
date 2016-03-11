/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class ResultMapWithoutBLOBsElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  38 */     XmlElement answer = new XmlElement("resultMap");
/*  39 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getBaseResultMapId()));
/*     */     String returnType;
/*  43 */     if (this.introspectedTable.getRules().generateBaseRecordClass())
/*  44 */       returnType = this.introspectedTable.getBaseRecordType();
/*     */     else {
/*  46 */       returnType = this.introspectedTable.getPrimaryKeyType();
/*     */     }
/*     */ 
/*  49 */     answer.addAttribute(new Attribute("type", returnType));
/*     */ 
/*  52 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  54 */     int i = 1;
/*  55 */     if ((StringUtility.stringHasValue(this.introspectedTable.getSelectByPrimaryKeyQueryId())) || (StringUtility.stringHasValue(this.introspectedTable.getSelectByExampleQueryId())))
/*     */     {
/*  59 */       i++;
/*     */     }
/*     */ 
/*  62 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  64 */       XmlElement resultElement = new XmlElement("id");
/*     */ 
/*  66 */       resultElement.addAttribute(new Attribute("column", MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/*     */ 
/*  69 */       resultElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*     */ 
/*  71 */       resultElement.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));
/*     */ 
/*  74 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */       {
/*  76 */         resultElement.addAttribute(new Attribute("typeHandler", introspectedColumn.getTypeHandler()));
/*     */       }
/*     */ 
/*  80 */       answer.addElement(resultElement);
/*     */     }
/*     */ 
/*  83 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getBaseColumns())
/*     */     {
/*  85 */       XmlElement resultElement = new XmlElement("result");
/*     */ 
/*  87 */       resultElement.addAttribute(new Attribute("column", MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/*     */ 
/*  90 */       resultElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*     */ 
/*  92 */       resultElement.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));
/*     */ 
/*  95 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */       {
/*  97 */         resultElement.addAttribute(new Attribute("typeHandler", introspectedColumn.getTypeHandler()));
/*     */       }
/*     */ 
/* 101 */       answer.addElement(resultElement);
/*     */     }
/*     */ 
/* 104 */     if (this.context.getPlugins().sqlMapResultMapWithoutBLOBsElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 107 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.ResultMapWithoutBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */