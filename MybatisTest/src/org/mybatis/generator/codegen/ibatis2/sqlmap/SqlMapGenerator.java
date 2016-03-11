/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.Document;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.codegen.AbstractXmlGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.AbstractXmlElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.BaseColumnListElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.BlobColumnListElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.CountByExampleElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.DeleteByExampleElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.DeleteByPrimaryKeyElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.ExampleWhereClauseElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.InsertElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.InsertSelectiveElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.ResultMapWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.ResultMapWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.SelectByExampleWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.SelectByExampleWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.SelectByPrimaryKeyElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByExampleSelectiveElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByExampleWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByExampleWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByPrimaryKeySelectiveElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByPrimaryKeyWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByPrimaryKeyWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class SqlMapGenerator extends AbstractXmlGenerator
/*     */ {
/*     */   protected XmlElement getSqlMapElement()
/*     */   {
/*  58 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  59 */     this.progressCallback.startTask(Messages.getString("Progress.12", table.toString()));
/*     */ 
/*  61 */     XmlElement answer = new XmlElement("sqlMap");
/*  62 */     answer.addAttribute(new Attribute("namespace", this.introspectedTable.getIbatis2SqlMapNamespace()));
/*     */ 
/*  65 */     this.context.getCommentGenerator().addRootComment(answer);
/*     */ 
/*  67 */     addResultMapWithoutBLOBsElement(answer);
/*  68 */     addResultMapWithBLOBsElement(answer);
/*  69 */     addExampleWhereClauseElement(answer);
/*  70 */     addBaseColumnListElement(answer);
/*  71 */     addBlobColumnListElement(answer);
/*  72 */     addSelectByExampleWithBLOBsElement(answer);
/*  73 */     addSelectByExampleWithoutBLOBsElement(answer);
/*  74 */     addSelectByPrimaryKeyElement(answer);
/*  75 */     addDeleteByPrimaryKeyElement(answer);
/*  76 */     addDeleteByExampleElement(answer);
/*  77 */     addInsertElement(answer);
/*  78 */     addInsertSelectiveElement(answer);
/*  79 */     addCountByExampleElement(answer);
/*  80 */     addUpdateByExampleSelectiveElement(answer);
/*  81 */     addUpdateByExampleWithBLOBsElement(answer);
/*  82 */     addUpdateByExampleWithoutBLOBsElement(answer);
/*  83 */     addUpdateByPrimaryKeySelectiveElement(answer);
/*  84 */     addUpdateByPrimaryKeyWithBLOBsElement(answer);
/*  85 */     addUpdateByPrimaryKeyWithoutBLOBsElement(answer);
/*     */ 
/*  87 */     return answer;
/*     */   }
/*     */ 
/*     */   protected void addResultMapWithoutBLOBsElement(XmlElement parentElement) {
/*  91 */     if (this.introspectedTable.getRules().generateBaseResultMap()) {
/*  92 */       AbstractXmlElementGenerator elementGenerator = new ResultMapWithoutBLOBsElementGenerator();
/*  93 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addResultMapWithBLOBsElement(XmlElement parentElement) {
/*  98 */     if (this.introspectedTable.getRules().generateResultMapWithBLOBs()) {
/*  99 */       AbstractXmlElementGenerator elementGenerator = new ResultMapWithBLOBsElementGenerator();
/* 100 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addExampleWhereClauseElement(XmlElement parentElement) {
/* 105 */     if (this.introspectedTable.getRules().generateSQLExampleWhereClause()) {
/* 106 */       AbstractXmlElementGenerator elementGenerator = new ExampleWhereClauseElementGenerator();
/* 107 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addBaseColumnListElement(XmlElement parentElement) {
/* 112 */     if (this.introspectedTable.getRules().generateBaseColumnList()) {
/* 113 */       AbstractXmlElementGenerator elementGenerator = new BaseColumnListElementGenerator();
/* 114 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addBlobColumnListElement(XmlElement parentElement) {
/* 119 */     if (this.introspectedTable.getRules().generateBlobColumnList()) {
/* 120 */       AbstractXmlElementGenerator elementGenerator = new BlobColumnListElementGenerator();
/* 121 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithoutBLOBsElement(XmlElement parentElement)
/*     */   {
/* 127 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/* 128 */       AbstractXmlElementGenerator elementGenerator = new SelectByExampleWithoutBLOBsElementGenerator();
/* 129 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithBLOBsElement(XmlElement parentElement) {
/* 134 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/* 135 */       AbstractXmlElementGenerator elementGenerator = new SelectByExampleWithBLOBsElementGenerator();
/* 136 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByPrimaryKeyElement(XmlElement parentElement) {
/* 141 */     if (this.introspectedTable.getRules().generateSelectByPrimaryKey()) {
/* 142 */       AbstractXmlElementGenerator elementGenerator = new SelectByPrimaryKeyElementGenerator();
/* 143 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByExampleElement(XmlElement parentElement) {
/* 148 */     if (this.introspectedTable.getRules().generateDeleteByExample()) {
/* 149 */       AbstractXmlElementGenerator elementGenerator = new DeleteByExampleElementGenerator();
/* 150 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByPrimaryKeyElement(XmlElement parentElement) {
/* 155 */     if (this.introspectedTable.getRules().generateDeleteByPrimaryKey()) {
/* 156 */       AbstractXmlElementGenerator elementGenerator = new DeleteByPrimaryKeyElementGenerator();
/* 157 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertElement(XmlElement parentElement) {
/* 162 */     if (this.introspectedTable.getRules().generateInsert()) {
/* 163 */       AbstractXmlElementGenerator elementGenerator = new InsertElementGenerator();
/* 164 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertSelectiveElement(XmlElement parentElement) {
/* 169 */     if (this.introspectedTable.getRules().generateInsertSelective()) {
/* 170 */       AbstractXmlElementGenerator elementGenerator = new InsertSelectiveElementGenerator();
/* 171 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addCountByExampleElement(XmlElement parentElement) {
/* 176 */     if (this.introspectedTable.getRules().generateCountByExample()) {
/* 177 */       AbstractXmlElementGenerator elementGenerator = new CountByExampleElementGenerator();
/* 178 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleSelectiveElement(XmlElement parentElement) {
/* 183 */     if (this.introspectedTable.getRules().generateUpdateByExampleSelective()) {
/* 184 */       AbstractXmlElementGenerator elementGenerator = new UpdateByExampleSelectiveElementGenerator();
/* 185 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithBLOBsElement(XmlElement parentElement) {
/* 190 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
/* 191 */       AbstractXmlElementGenerator elementGenerator = new UpdateByExampleWithBLOBsElementGenerator();
/* 192 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithoutBLOBsElement(XmlElement parentElement)
/*     */   {
/* 198 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
/* 199 */       AbstractXmlElementGenerator elementGenerator = new UpdateByExampleWithoutBLOBsElementGenerator();
/* 200 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeySelectiveElement(XmlElement parentElement)
/*     */   {
/* 206 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
/* 207 */       AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeySelectiveElementGenerator();
/* 208 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithBLOBsElement(XmlElement parentElement)
/*     */   {
/* 214 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
/* 215 */       AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithBLOBsElementGenerator();
/* 216 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithoutBLOBsElement(XmlElement parentElement)
/*     */   {
/* 222 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithoutBLOBs())
/*     */     {
/* 224 */       AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithoutBLOBsElementGenerator();
/* 225 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initializeAndExecuteGenerator(AbstractXmlElementGenerator elementGenerator, XmlElement parentElement)
/*     */   {
/* 232 */     elementGenerator.setContext(this.context);
/* 233 */     elementGenerator.setIntrospectedTable(this.introspectedTable);
/* 234 */     elementGenerator.setProgressCallback(this.progressCallback);
/* 235 */     elementGenerator.setWarnings(this.warnings);
/* 236 */     elementGenerator.addElements(parentElement);
/*     */   }
/*     */ 
/*     */   public Document getDocument()
/*     */   {
/* 241 */     Document document = new Document("-//ibatis.apache.org//DTD SQL Map 2.0//EN", "http://ibatis.apache.org/dtd/sql-map-2.dtd");
/*     */ 
/* 244 */     document.setRootElement(getSqlMapElement());
/*     */ 
/* 246 */     if (!this.context.getPlugins().sqlMapDocumentGenerated(document, this.introspectedTable))
/*     */     {
/* 248 */       document = null;
/*     */     }
/*     */ 
/* 251 */     return document;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.SqlMapGenerator
 * JD-Core Version:    0.6.0
 */