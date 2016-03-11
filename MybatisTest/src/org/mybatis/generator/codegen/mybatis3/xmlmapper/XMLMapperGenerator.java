/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper;
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
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.BaseColumnListElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.BlobColumnListElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.CountByExampleElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.DeleteByExampleElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.DeleteByPrimaryKeyElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.ExampleWhereClauseElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.InsertElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.InsertSelectiveElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.ResultMapWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.ResultMapWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByExampleWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByExampleWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByPrimaryKeyElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleSelectiveElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByPrimaryKeySelectiveElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByPrimaryKeyWithBLOBsElementGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByPrimaryKeyWithoutBLOBsElementGenerator;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class XMLMapperGenerator extends AbstractXmlGenerator
/*     */ {
/*     */   protected XmlElement getSqlMapElement()
/*     */   {
/*  58 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  59 */     this.progressCallback.startTask(Messages.getString("Progress.12", table.toString()));
/*     */ 
/*  61 */     XmlElement answer = new XmlElement("mapper");
/*  62 */     String namespace = this.introspectedTable.getMyBatis3JavaMapperType();
/*  63 */     if (namespace == null)
/*     */     {
/*  65 */       namespace = this.introspectedTable.getIbatis2SqlMapNamespace();
/*     */     }
/*  67 */     answer.addAttribute(new Attribute("namespace", namespace));
/*     */ 
/*  70 */     this.context.getCommentGenerator().addRootComment(answer);
/*     */ 
/*  72 */     addResultMapWithoutBLOBsElement(answer);
/*  73 */     addResultMapWithBLOBsElement(answer);
/*  74 */     addExampleWhereClauseElement(answer);
/*  75 */     addMyBatis3UpdateByExampleWhereClauseElement(answer);
/*  76 */     addBaseColumnListElement(answer);
/*  77 */     addBlobColumnListElement(answer);
/*  78 */     addSelectByExampleWithBLOBsElement(answer);
/*  79 */     addSelectByExampleWithoutBLOBsElement(answer);
/*  80 */     addSelectByPrimaryKeyElement(answer);
/*  81 */     addDeleteByPrimaryKeyElement(answer);
/*  82 */     addDeleteByExampleElement(answer);
/*  83 */     addInsertElement(answer);
/*  84 */     addInsertSelectiveElement(answer);
/*  85 */     addCountByExampleElement(answer);
/*  86 */     addUpdateByExampleSelectiveElement(answer);
/*  87 */     addUpdateByExampleWithBLOBsElement(answer);
/*  88 */     addUpdateByExampleWithoutBLOBsElement(answer);
/*  89 */     addUpdateByPrimaryKeySelectiveElement(answer);
/*  90 */     addUpdateByPrimaryKeyWithBLOBsElement(answer);
/*  91 */     addUpdateByPrimaryKeyWithoutBLOBsElement(answer);
/*     */ 
/*  93 */     return answer;
/*     */   }
/*     */ 
/*     */   protected void addResultMapWithoutBLOBsElement(XmlElement parentElement) {
/*  97 */     if (this.introspectedTable.getRules().generateBaseResultMap()) {
/*  98 */       AbstractXmlElementGenerator elementGenerator = new ResultMapWithoutBLOBsElementGenerator();
/*  99 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addResultMapWithBLOBsElement(XmlElement parentElement) {
/* 104 */     if (this.introspectedTable.getRules().generateResultMapWithBLOBs()) {
/* 105 */       AbstractXmlElementGenerator elementGenerator = new ResultMapWithBLOBsElementGenerator();
/* 106 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addExampleWhereClauseElement(XmlElement parentElement) {
/* 111 */     if (this.introspectedTable.getRules().generateSQLExampleWhereClause()) {
/* 112 */       AbstractXmlElementGenerator elementGenerator = new ExampleWhereClauseElementGenerator(false);
/*     */ 
/* 114 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addMyBatis3UpdateByExampleWhereClauseElement(XmlElement parentElement)
/*     */   {
/* 120 */     if (this.introspectedTable.getRules().generateMyBatis3UpdateByExampleWhereClause())
/*     */     {
/* 122 */       AbstractXmlElementGenerator elementGenerator = new ExampleWhereClauseElementGenerator(true);
/*     */ 
/* 124 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addBaseColumnListElement(XmlElement parentElement) {
/* 129 */     if (this.introspectedTable.getRules().generateBaseColumnList()) {
/* 130 */       AbstractXmlElementGenerator elementGenerator = new BaseColumnListElementGenerator();
/* 131 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addBlobColumnListElement(XmlElement parentElement) {
/* 136 */     if (this.introspectedTable.getRules().generateBlobColumnList()) {
/* 137 */       AbstractXmlElementGenerator elementGenerator = new BlobColumnListElementGenerator();
/* 138 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithoutBLOBsElement(XmlElement parentElement)
/*     */   {
/* 144 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/* 145 */       AbstractXmlElementGenerator elementGenerator = new SelectByExampleWithoutBLOBsElementGenerator();
/* 146 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithBLOBsElement(XmlElement parentElement) {
/* 151 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/* 152 */       AbstractXmlElementGenerator elementGenerator = new SelectByExampleWithBLOBsElementGenerator();
/* 153 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByPrimaryKeyElement(XmlElement parentElement) {
/* 158 */     if (this.introspectedTable.getRules().generateSelectByPrimaryKey()) {
/* 159 */       AbstractXmlElementGenerator elementGenerator = new SelectByPrimaryKeyElementGenerator();
/* 160 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByExampleElement(XmlElement parentElement) {
/* 165 */     if (this.introspectedTable.getRules().generateDeleteByExample()) {
/* 166 */       AbstractXmlElementGenerator elementGenerator = new DeleteByExampleElementGenerator();
/* 167 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByPrimaryKeyElement(XmlElement parentElement) {
/* 172 */     if (this.introspectedTable.getRules().generateDeleteByPrimaryKey()) {
/* 173 */       AbstractXmlElementGenerator elementGenerator = new DeleteByPrimaryKeyElementGenerator();
/* 174 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertElement(XmlElement parentElement) {
/* 179 */     if (this.introspectedTable.getRules().generateInsert()) {
/* 180 */       AbstractXmlElementGenerator elementGenerator = new InsertElementGenerator();
/* 181 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertSelectiveElement(XmlElement parentElement) {
/* 186 */     if (this.introspectedTable.getRules().generateInsertSelective()) {
/* 187 */       AbstractXmlElementGenerator elementGenerator = new InsertSelectiveElementGenerator();
/* 188 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addCountByExampleElement(XmlElement parentElement) {
/* 193 */     if (this.introspectedTable.getRules().generateCountByExample()) {
/* 194 */       AbstractXmlElementGenerator elementGenerator = new CountByExampleElementGenerator();
/* 195 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleSelectiveElement(XmlElement parentElement) {
/* 200 */     if (this.introspectedTable.getRules().generateUpdateByExampleSelective()) {
/* 201 */       AbstractXmlElementGenerator elementGenerator = new UpdateByExampleSelectiveElementGenerator();
/* 202 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithBLOBsElement(XmlElement parentElement) {
/* 207 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
/* 208 */       AbstractXmlElementGenerator elementGenerator = new UpdateByExampleWithBLOBsElementGenerator();
/* 209 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithoutBLOBsElement(XmlElement parentElement)
/*     */   {
/* 215 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
/* 216 */       AbstractXmlElementGenerator elementGenerator = new UpdateByExampleWithoutBLOBsElementGenerator();
/* 217 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeySelectiveElement(XmlElement parentElement)
/*     */   {
/* 223 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
/* 224 */       AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeySelectiveElementGenerator();
/* 225 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithBLOBsElement(XmlElement parentElement)
/*     */   {
/* 231 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
/* 232 */       AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithBLOBsElementGenerator();
/* 233 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithoutBLOBsElement(XmlElement parentElement)
/*     */   {
/* 239 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithoutBLOBs())
/*     */     {
/* 241 */       AbstractXmlElementGenerator elementGenerator = new UpdateByPrimaryKeyWithoutBLOBsElementGenerator();
/* 242 */       initializeAndExecuteGenerator(elementGenerator, parentElement);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initializeAndExecuteGenerator(AbstractXmlElementGenerator elementGenerator, XmlElement parentElement)
/*     */   {
/* 249 */     elementGenerator.setContext(this.context);
/* 250 */     elementGenerator.setIntrospectedTable(this.introspectedTable);
/* 251 */     elementGenerator.setProgressCallback(this.progressCallback);
/* 252 */     elementGenerator.setWarnings(this.warnings);
/* 253 */     elementGenerator.addElements(parentElement);
/*     */   }
/*     */ 
/*     */   public Document getDocument()
/*     */   {
/* 258 */     Document document = new Document("-//mybatis.org//DTD Mapper 3.0//EN", "http://mybatis.org/dtd/mybatis-3-mapper.dtd");
/*     */ 
/* 261 */     document.setRootElement(getSqlMapElement());
/*     */ 
/* 263 */     if (!this.context.getPlugins().sqlMapDocumentGenerated(document, this.introspectedTable))
/*     */     {
/* 265 */       document = null;
/*     */     }
/*     */ 
/* 268 */     return document;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator
 * JD-Core Version:    0.6.0
 */