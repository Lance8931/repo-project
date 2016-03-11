/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class UpdateByPrimaryKeySelectiveElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  38 */     XmlElement answer = new XmlElement("update");
/*     */ 
/*  40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getUpdateByPrimaryKeySelectiveStatementId()));
/*     */     String parameterType;
/*  46 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass())
/*  47 */       parameterType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     else {
/*  49 */       parameterType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */ 
/*  52 */     answer.addAttribute(new Attribute("parameterType", parameterType));
/*     */ 
/*  55 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  57 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  59 */     sb.append("update ");
/*  60 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  61 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  63 */     XmlElement dynamicElement = new XmlElement("set");
/*  64 */     answer.addElement(dynamicElement);
/*     */ 
/*  66 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonPrimaryKeyColumns())
/*     */     {
/*  68 */       XmlElement isNotNullElement = new XmlElement("if");
/*  69 */       sb.setLength(0);
/*  70 */       sb.append(introspectedColumn.getJavaProperty());
/*  71 */       sb.append(" != null");
/*  72 */       isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
/*  73 */       dynamicElement.addElement(isNotNullElement);
/*     */ 
/*  75 */       sb.setLength(0);
/*  76 */       sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  78 */       sb.append(" = ");
/*  79 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/*  81 */       sb.append(',');
/*     */ 
/*  83 */       isNotNullElement.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/*  86 */     boolean and = false;
/*  87 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  89 */       sb.setLength(0);
/*  90 */       if (and) {
/*  91 */         sb.append("  and ");
/*     */       } else {
/*  93 */         sb.append("where ");
/*  94 */         and = true;
/*     */       }
/*     */ 
/*  97 */       sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  99 */       sb.append(" = ");
/* 100 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 102 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/* 105 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeySelectiveElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 108 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByPrimaryKeySelectiveElementGenerator
 * JD-Core Version:    0.6.0
 */