/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
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
/*  48 */     answer.addAttribute(new Attribute("parameterClass", parameterType.getFullyQualifiedName()));
/*     */ 
/*  51 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  53 */     GeneratedKey gk = this.introspectedTable.getGeneratedKey();
/*     */ 
/*  55 */     if ((gk != null) && (gk.isBeforeInsert())) {
/*  56 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*     */ 
/*  60 */       if (introspectedColumn != null)
/*     */       {
/*  62 */         answer.addElement(getSelectKey(introspectedColumn, gk));
/*     */       }
/*     */     }
/*     */ 
/*  66 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  68 */     sb.append("insert into ");
/*  69 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*  70 */     answer.addElement(new TextElement(sb.toString()));
/*     */ 
/*  72 */     XmlElement insertElement = new XmlElement("dynamic");
/*  73 */     insertElement.addAttribute(new Attribute("prepend", "("));
/*  74 */     answer.addElement(insertElement);
/*     */ 
/*  76 */     answer.addElement(new TextElement("values"));
/*     */ 
/*  78 */     XmlElement valuesElement = new XmlElement("dynamic");
/*  79 */     valuesElement.addAttribute(new Attribute("prepend", "("));
/*  80 */     answer.addElement(valuesElement);
/*     */ 
/*  82 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getAllColumns())
/*     */     {
/*  84 */       if (introspectedColumn.isIdentity())
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  89 */       XmlElement insertNotNullElement = new XmlElement("isNotNull");
/*  90 */       insertNotNullElement.addAttribute(new Attribute("prepend", ","));
/*  91 */       insertNotNullElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*     */ 
/*  93 */       insertNotNullElement.addElement(new TextElement(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn)));
/*     */ 
/*  96 */       insertElement.addElement(insertNotNullElement);
/*     */ 
/*  98 */       XmlElement valuesNotNullElement = new XmlElement("isNotNull");
/*  99 */       valuesNotNullElement.addAttribute(new Attribute("prepend", ","));
/* 100 */       valuesNotNullElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*     */ 
/* 102 */       valuesNotNullElement.addElement(new TextElement(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn)));
/*     */ 
/* 105 */       valuesElement.addElement(valuesNotNullElement);
/*     */     }
/*     */ 
/* 108 */     insertElement.addElement(new TextElement(")"));
/* 109 */     valuesElement.addElement(new TextElement(")"));
/*     */ 
/* 111 */     if ((gk != null) && (!gk.isBeforeInsert())) {
/* 112 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*     */ 
/* 116 */       if (introspectedColumn != null)
/*     */       {
/* 118 */         answer.addElement(getSelectKey(introspectedColumn, gk));
/*     */       }
/*     */     }
/*     */ 
/* 122 */     if (this.context.getPlugins().sqlMapInsertSelectiveElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 124 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.InsertSelectiveElementGenerator
 * JD-Core Version:    0.6.0
 */