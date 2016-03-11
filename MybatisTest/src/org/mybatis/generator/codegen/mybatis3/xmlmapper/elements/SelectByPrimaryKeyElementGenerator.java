/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
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
/*  57 */       if (this.introspectedTable.getPrimaryKeyColumns().size() > 1)
/*  58 */         parameterType = "map";
/*     */       else {
/*  60 */         parameterType = ((IntrospectedColumn)this.introspectedTable.getPrimaryKeyColumns().get(0)).getFullyQualifiedJavaType().toString();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  65 */     answer.addAttribute(new Attribute("parameterType", parameterType));
/*     */ 
/*  68 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  70 */     StringBuilder sb = new StringBuilder();
/*  71 */     sb.append("select ");
/*     */ 
/*  73 */     if (StringUtility.stringHasValue(this.introspectedTable.getSelectByPrimaryKeyQueryId()))
/*     */     {
/*  75 */       sb.append('\'');
/*  76 */       sb.append(this.introspectedTable.getSelectByPrimaryKeyQueryId());
/*  77 */       sb.append("' as QUERYID,");
/*     */     }
/*  79 */     answer.addElement(new TextElement(sb.toString()));
/*  80 */     answer.addElement(getBaseColumnListElement());
/*  81 */     if (this.introspectedTable.hasBLOBColumns()) {
/*  82 */       answer.addElement(new TextElement(","));
/*  83 */       answer.addElement(getBlobColumnListElement());
/*     */     }
/*     */ 
/*  86 */     sb.setLength(0);
/*  87 */     sb.append("from ");
/*  88 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*     */ 
/*  90 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  92 */     boolean and = false;
/*  93 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  95 */       sb.setLength(0);
/*  96 */       if (and) {
/*  97 */         sb.append("  and ");
/*     */       } else {
/*  99 */         sb.append("where ");
/* 100 */         and = true;
/*     */       }
/*     */ 
/* 103 */       sb.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*     */ 
/* 105 */       sb.append(" = ");
/* 106 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 108 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/* 111 */     if (this.context.getPlugins().sqlMapSelectByPrimaryKeyElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 114 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByPrimaryKeyElementGenerator
 * JD-Core Version:    0.6.0
 */