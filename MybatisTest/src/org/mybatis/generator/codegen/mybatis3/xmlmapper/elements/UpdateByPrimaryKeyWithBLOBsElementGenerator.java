/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class UpdateByPrimaryKeyWithBLOBsElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  41 */     XmlElement answer = new XmlElement("update");
/*     */ 
/*  43 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getUpdateByPrimaryKeyWithBLOBsStatementId()));
/*     */     String parameterType;
/*  48 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass())
/*  49 */       parameterType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     else {
/*  51 */       parameterType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */ 
/*  54 */     answer.addAttribute(new Attribute("parameterType", parameterType));
/*     */ 
/*  57 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  59 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  61 */     sb.append("update ");
/*  62 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  63 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  66 */     sb.setLength(0);
/*  67 */     sb.append("set ");
/*     */ 
/*  69 */     Iterator iter = this.introspectedTable.getNonPrimaryKeyColumns().iterator();
/*     */ 
/*  71 */     while (iter.hasNext()) {
/*  72 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */ 
/*  74 */       sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  76 */       sb.append(" = ");
/*  77 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/*  80 */       if (iter.hasNext()) {
/*  81 */         sb.append(',');
/*     */       }
/*     */ 
/*  84 */       answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  87 */       if (iter.hasNext()) {
/*  88 */         sb.setLength(0);
/*  89 */         OutputUtilities.xmlIndent(sb, 1);
/*     */       }
/*     */     }
/*     */ 
/*  93 */     boolean and = false;
/*  94 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  96 */       sb.setLength(0);
/*  97 */       if (and) {
/*  98 */         sb.append("  and ");
/*     */       } else {
/* 100 */         sb.append("where ");
/* 101 */         and = true;
/*     */       }
/*     */ 
/* 104 */       sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/* 106 */       sb.append(" = ");
/* 107 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 109 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/* 112 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 115 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByPrimaryKeyWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */