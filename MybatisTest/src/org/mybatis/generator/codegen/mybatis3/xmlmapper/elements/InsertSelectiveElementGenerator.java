/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
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
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class InsertSelectiveElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  40 */     XmlElement answer = new XmlElement("insert");
/*     */ 
/*  42 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getInsertSelectiveStatementId()));
/*     */ 
/*  45 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*     */ 
/*  48 */     answer.addAttribute(new Attribute("parameterType", parameterType.getFullyQualifiedName()));
/*     */ 
/*  51 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  53 */     GeneratedKey gk = this.introspectedTable.getGeneratedKey();
/*     */ 
/*  55 */     String sequenceColumn = null;
/*  56 */     if ((gk != null) && (gk.isBeforeInsert())) {
/*  57 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*     */ 
/*  61 */       if (introspectedColumn != null)
/*     */       {
/*  63 */         answer.addElement(getSelectKey(introspectedColumn, gk));
/*  64 */         sequenceColumn = gk.getColumn();
/*     */       }
/*     */     }
/*     */ 
/*  68 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  70 */     sb.append("insert into ");
/*  71 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  72 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  74 */     XmlElement insertTrimElement = new XmlElement("trim");
/*  75 */     insertTrimElement.addAttribute(new Attribute("prefix", "("));
/*  76 */     insertTrimElement.addAttribute(new Attribute("suffix", ")"));
/*  77 */     insertTrimElement.addAttribute(new Attribute("suffixOverrides", ","));
/*  78 */     answer.addElement(insertTrimElement);
/*     */ 
/*  80 */     XmlElement valuesTrimElement = new XmlElement("trim");
/*  81 */     valuesTrimElement.addAttribute(new Attribute("prefix", "values ("));
/*  82 */     valuesTrimElement.addAttribute(new Attribute("suffix", ")"));
/*  83 */     valuesTrimElement.addAttribute(new Attribute("suffixOverrides", ","));
/*  84 */     answer.addElement(valuesTrimElement);
/*     */ 
/*  86 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getAllColumns())
/*     */     {
/*  88 */       if (introspectedColumn.isIdentity())
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  93 */       boolean isSequenceColumn = sequenceColumn == null ? false : sequenceColumn.equals(introspectedColumn.getActualColumnName());
/*     */ 
/*  96 */       if (isSequenceColumn) {
/*  97 */         sb.setLength(0);
/*  98 */         sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/* 100 */         sb.append(',');
/* 101 */         insertTrimElement.addElement(new TextElement(sb.toString()));
/*     */ 
/* 103 */         sb.setLength(0);
/* 104 */         sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 106 */         sb.append(',');
/* 107 */         valuesTrimElement.addElement(new TextElement(sb.toString()));
/*     */ 
/* 109 */         continue;
/*     */       }
/*     */ 
/* 112 */       XmlElement insertNotNullElement = new XmlElement("if");
/* 113 */       sb.setLength(0);
/* 114 */       sb.append(introspectedColumn.getJavaProperty());
/* 115 */       sb.append(" != null");
/* 116 */       insertNotNullElement.addAttribute(new Attribute("test", sb.toString()));
/*     */ 
/* 119 */       sb.setLength(0);
/* 120 */       sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/* 122 */       sb.append(',');
/* 123 */       insertNotNullElement.addElement(new TextElement(sb.toString()));
/* 124 */       insertTrimElement.addElement(insertNotNullElement);
/*     */ 
/* 126 */       XmlElement valuesNotNullElement = new XmlElement("if");
/* 127 */       sb.setLength(0);
/* 128 */       sb.append(introspectedColumn.getJavaProperty());
/* 129 */       sb.append(" != null");
/* 130 */       valuesNotNullElement.addAttribute(new Attribute("test", sb.toString()));
/*     */ 
/* 133 */       sb.setLength(0);
/* 134 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/* 136 */       sb.append(',');
/* 137 */       valuesNotNullElement.addElement(new TextElement(sb.toString()));
/* 138 */       valuesTrimElement.addElement(valuesNotNullElement);
/*     */     }
/*     */ 
/* 141 */     if ((gk != null) && (!gk.isBeforeInsert())) {
/* 142 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*     */ 
/* 146 */       if (introspectedColumn != null)
/*     */       {
/* 148 */         answer.addElement(getSelectKey(introspectedColumn, gk));
/*     */       }
/*     */     }
/*     */ 
/* 152 */     if (this.context.getPlugins().sqlMapInsertSelectiveElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 154 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.InsertSelectiveElementGenerator
 * JD-Core Version:    0.6.0
 */