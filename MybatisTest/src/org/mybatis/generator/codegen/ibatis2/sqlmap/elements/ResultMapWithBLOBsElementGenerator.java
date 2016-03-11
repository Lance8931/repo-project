/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class ResultMapWithBLOBsElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  39 */     boolean useColumnIndex = StringUtility.isTrue(this.introspectedTable.getTableConfigurationProperty("useColumnIndexes"));
/*     */ 
/*  43 */     XmlElement answer = new XmlElement("resultMap");
/*     */ 
/*  45 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getResultMapWithBLOBsId()));
/*     */     String returnType;
/*  49 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  50 */       returnType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     }
/*     */     else
/*     */     {
/*  54 */       returnType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */ 
/*  57 */     answer.addAttribute(new Attribute("class", returnType));
/*     */ 
/*  60 */     StringBuilder sb = new StringBuilder();
/*  61 */     sb.append(this.introspectedTable.getIbatis2SqlMapNamespace());
/*  62 */     sb.append('.');
/*  63 */     sb.append(this.introspectedTable.getBaseResultMapId());
/*  64 */     answer.addAttribute(new Attribute("extends", sb.toString()));
/*     */ 
/*  66 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  68 */     int i = this.introspectedTable.getNonBLOBColumnCount() + 1;
/*  69 */     if ((StringUtility.stringHasValue(this.introspectedTable.getSelectByPrimaryKeyQueryId())) || (StringUtility.stringHasValue(this.introspectedTable.getSelectByExampleQueryId())))
/*     */     {
/*  73 */       i++;
/*     */     }
/*     */ 
/*  76 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getBLOBColumns())
/*     */     {
/*  78 */       XmlElement resultElement = new XmlElement("result");
/*     */ 
/*  80 */       if (useColumnIndex) {
/*  81 */         resultElement.addAttribute(new Attribute("columnIndex", Integer.toString(i++)));
/*     */       }
/*     */       else {
/*  84 */         resultElement.addAttribute(new Attribute("column", Ibatis2FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/*     */       }
/*     */ 
/*  88 */       resultElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*     */ 
/*  90 */       resultElement.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));
/*     */ 
/*  93 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */       {
/*  95 */         resultElement.addAttribute(new Attribute("typeHandler", introspectedColumn.getTypeHandler()));
/*     */       }
/*     */ 
/*  99 */       answer.addElement(resultElement);
/*     */     }
/*     */ 
/* 102 */     if (this.context.getPlugins().sqlMapResultMapWithBLOBsElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 105 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.ResultMapWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */