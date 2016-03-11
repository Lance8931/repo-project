/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
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
/*  52 */     answer.addAttribute(new Attribute("parameterClass", parameterType));
/*     */ 
/*  55 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  57 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  59 */     sb.append("update ");
/*  60 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  61 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  63 */     XmlElement dynamicElement = new XmlElement("dynamic");
/*  64 */     dynamicElement.addAttribute(new Attribute("prepend", "set"));
/*  65 */     answer.addElement(dynamicElement);
/*     */ 
/*  67 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonPrimaryKeyColumns())
/*     */     {
/*  69 */       XmlElement isNotNullElement = new XmlElement("isNotNull");
/*  70 */       isNotNullElement.addAttribute(new Attribute("prepend", ","));
/*  71 */       isNotNullElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*     */ 
/*  73 */       dynamicElement.addElement(isNotNullElement);
/*     */ 
/*  75 */       sb.setLength(0);
/*  76 */       sb.append(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  78 */       sb.append(" = ");
/*  79 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/*  82 */       isNotNullElement.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/*  85 */     boolean and = false;
/*  86 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  88 */       sb.setLength(0);
/*  89 */       if (and) {
/*  90 */         sb.append("  and ");
/*     */       } else {
/*  92 */         sb.append("where ");
/*  93 */         and = true;
/*     */       }
/*     */ 
/*  96 */       sb.append(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  98 */       sb.append(" = ");
/*  99 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 101 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/* 104 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeySelectiveElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 107 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByPrimaryKeySelectiveElementGenerator
 * JD-Core Version:    0.6.0
 */