/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
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
/*     */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
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
/*  49 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass())
/*  50 */       parameterType = this.introspectedTable.getRecordWithBLOBsType();
/*     */     else {
/*  52 */       parameterType = this.introspectedTable.getBaseRecordType();
/*     */     }
/*     */ 
/*  55 */     answer.addAttribute(new Attribute("parameterClass", parameterType));
/*     */ 
/*  58 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  60 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  62 */     sb.append("update ");
/*  63 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  64 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  67 */     sb.setLength(0);
/*  68 */     sb.append("set ");
/*     */ 
/*  70 */     Iterator iter = this.introspectedTable.getNonPrimaryKeyColumns().iterator();
/*     */ 
/*  72 */     while (iter.hasNext()) {
/*  73 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */ 
/*  75 */       sb.append(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  77 */       sb.append(" = ");
/*  78 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/*  81 */       if (iter.hasNext()) {
/*  82 */         sb.append(',');
/*     */       }
/*     */ 
/*  85 */       answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  88 */       if (iter.hasNext()) {
/*  89 */         sb.setLength(0);
/*  90 */         OutputUtilities.xmlIndent(sb, 1);
/*     */       }
/*     */     }
/*     */ 
/*  94 */     boolean and = false;
/*  95 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  97 */       sb.setLength(0);
/*  98 */       if (and) {
/*  99 */         sb.append("  and ");
/*     */       } else {
/* 101 */         sb.append("where ");
/* 102 */         and = true;
/*     */       }
/*     */ 
/* 105 */       sb.append(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/* 107 */       sb.append(" = ");
/* 108 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 110 */       answer.addElement(new TextElement(sb.toString()));
/*     */     }
/*     */ 
/* 113 */     if (this.context.getPlugins().sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 116 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByPrimaryKeyWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */