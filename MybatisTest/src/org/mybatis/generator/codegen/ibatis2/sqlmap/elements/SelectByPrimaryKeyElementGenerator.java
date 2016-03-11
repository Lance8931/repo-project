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
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class SelectByPrimaryKeyElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  39 */     XmlElement answer = new XmlElement("select");
/*     */ 
/*  41 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getSelectByPrimaryKeyStatementId()));
/*     */ 
/*  43 */     if (this.introspectedTable.getRules().generateResultMapWithBLOBs()) {
/*  44 */       answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getResultMapWithBLOBsId()));
/*     */     }
/*     */     else
/*  47 */       answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getBaseResultMapId()));
/*     */     String parameterType;
/*  52 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/*  53 */       parameterType = this.introspectedTable.getPrimaryKeyType();
/*     */     }
/*     */     else
/*     */     {
/*  57 */       parameterType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */ 
/*  60 */     answer.addAttribute(new Attribute("parameterClass", parameterType));
/*     */ 
/*  63 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  65 */     StringBuilder sb = new StringBuilder();
/*  66 */     sb.append("select ");
/*     */ 
/*  68 */     if (StringUtility.stringHasValue(this.introspectedTable.getSelectByPrimaryKeyQueryId()))
/*     */     {
/*  70 */       sb.append('\'');
/*  71 */       sb.append(this.introspectedTable.getSelectByPrimaryKeyQueryId());
/*  72 */       sb.append("' as QUERYID,");
/*     */     }
/*  74 */     answer.addElement(new TextElement(sb.toString()));
/*  75 */     answer.addElement(getBaseColumnListElement());
/*  76 */     if (this.introspectedTable.hasBLOBColumns()) {
/*  77 */       answer.addElement(new TextElement(","));
/*  78 */       answer.addElement(getBlobColumnListElement());
/*     */     }
/*     */ 
/*  81 */     sb.setLength(0);
/*  82 */     sb.append("from ");
/*  83 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*     */ 
/*  85 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  87 */     boolean and = false;
/*  88 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  90 */       sb.setLength(0);
/*  91 */       if (and) {
/*  92 */         sb.append("  and ");
/*     */       } else {
/*  94 */         sb.append("where ");
/*  95 */         and = true;
/*     */       }
/*     */ 
/*  98 */       sb.append(Ibatis2FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*     */ 
/* 100 */       sb.append(" = ");
/* 101 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 103 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/* 106 */     if (this.context.getPlugins().sqlMapSelectByPrimaryKeyElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 109 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.SelectByPrimaryKeyElementGenerator
 * JD-Core Version:    0.6.0
 */