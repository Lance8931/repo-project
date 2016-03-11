/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class InsertElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  44 */     XmlElement answer = new XmlElement("insert");
/*     */ 
/*  46 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getInsertStatementId()));
/*     */ 
/*  49 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*     */ 
/*  52 */     answer.addAttribute(new Attribute("parameterClass", parameterType.getFullyQualifiedName()));
/*     */ 
/*  55 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  57 */     GeneratedKey gk = this.introspectedTable.getGeneratedKey();
/*     */ 
/*  59 */     if ((gk != null) && (gk.isBeforeInsert())) {
/*  60 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*     */ 
/*  64 */       if (introspectedColumn != null)
/*     */       {
/*  66 */         answer.addElement(getSelectKey(introspectedColumn, gk));
/*     */       }
/*     */     }
/*     */ 
/*  70 */     StringBuilder insertClause = new StringBuilder();
/*  71 */     StringBuilder valuesClause = new StringBuilder();
/*     */ 
/*  73 */     insertClause.append("insert into ");
/*  74 */     insertClause.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/*     */ 
/*  76 */     insertClause.append(" (");
/*     */ 
/*  78 */     valuesClause.append("values (");
/*     */ 
/*  80 */     List<String> valuesClauses = new ArrayList();
/*  81 */     Iterator iter = this.introspectedTable.getAllColumns().iterator();
/*     */ 
/*  83 */     while (iter.hasNext()) {
/*  84 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*  85 */       if (introspectedColumn.isIdentity())
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  90 */       insertClause.append(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*     */ 
/*  92 */       valuesClause.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*     */ 
/*  94 */       if (iter.hasNext()) {
/*  95 */         insertClause.append(", ");
/*  96 */         valuesClause.append(", ");
/*     */       }
/*     */ 
/*  99 */       if (valuesClause.length() > 80) {
/* 100 */         answer.addElement(new TextElement(insertClause.toString()));
/* 101 */         insertClause.setLength(0);
/* 102 */         OutputUtilities.xmlIndent(insertClause, 1);
/*     */ 
/* 104 */         valuesClauses.add(valuesClause.toString());
/* 105 */         valuesClause.setLength(0);
/* 106 */         OutputUtilities.xmlIndent(valuesClause, 1);
/*     */       }
/*     */     }
/*     */ 
/* 110 */     insertClause.append(')');
/* 111 */     answer.addElement(new TextElement(insertClause.toString()));
/*     */ 
/* 113 */     valuesClause.append(')');
/* 114 */     valuesClauses.add(valuesClause.toString());
/*     */ 
/* 116 */     for (String clause : valuesClauses) {
/* 117 */       answer.addElement(new TextElement(clause));
/*     */     }
/*     */ 
/* 120 */     if ((gk != null) && (!gk.isBeforeInsert())) {
/* 121 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(gk.getColumn());
/*     */ 
/* 125 */       if (introspectedColumn != null)
/*     */       {
/* 127 */         answer.addElement(getSelectKey(introspectedColumn, gk));
/*     */       }
/*     */     }
/*     */ 
/* 131 */     if (this.context.getPlugins().sqlMapInsertElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 133 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.InsertElementGenerator
 * JD-Core Version:    0.6.0
 */