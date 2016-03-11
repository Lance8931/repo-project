/*     */ package org.mybatis.generator.internal.rules;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ 
/*     */ public class RulesDelegate
/*     */   implements Rules
/*     */ {
/*     */   protected Rules rules;
/*     */ 
/*     */   public RulesDelegate(Rules rules)
/*     */   {
/*  65 */     this.rules = rules;
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType calculateAllFieldsClass() {
/*  69 */     return this.rules.calculateAllFieldsClass();
/*     */   }
/*     */ 
/*     */   public boolean generateBaseRecordClass() {
/*  73 */     return this.rules.generateBaseRecordClass();
/*     */   }
/*     */ 
/*     */   public boolean generateBaseResultMap() {
/*  77 */     return this.rules.generateBaseResultMap();
/*     */   }
/*     */ 
/*     */   public boolean generateCountByExample() {
/*  81 */     return this.rules.generateCountByExample();
/*     */   }
/*     */ 
/*     */   public boolean generateDeleteByExample() {
/*  85 */     return this.rules.generateDeleteByExample();
/*     */   }
/*     */ 
/*     */   public boolean generateDeleteByPrimaryKey() {
/*  89 */     return this.rules.generateDeleteByPrimaryKey();
/*     */   }
/*     */ 
/*     */   public boolean generateExampleClass() {
/*  93 */     return this.rules.generateExampleClass();
/*     */   }
/*     */ 
/*     */   public boolean generateInsert() {
/*  97 */     return this.rules.generateInsert();
/*     */   }
/*     */ 
/*     */   public boolean generateInsertSelective() {
/* 101 */     return this.rules.generateInsertSelective();
/*     */   }
/*     */ 
/*     */   public boolean generatePrimaryKeyClass() {
/* 105 */     return this.rules.generatePrimaryKeyClass();
/*     */   }
/*     */ 
/*     */   public boolean generateRecordWithBLOBsClass() {
/* 109 */     return this.rules.generateRecordWithBLOBsClass();
/*     */   }
/*     */ 
/*     */   public boolean generateResultMapWithBLOBs() {
/* 113 */     return this.rules.generateResultMapWithBLOBs();
/*     */   }
/*     */ 
/*     */   public boolean generateSelectByExampleWithBLOBs() {
/* 117 */     return this.rules.generateSelectByExampleWithBLOBs();
/*     */   }
/*     */ 
/*     */   public boolean generateSelectByExampleWithoutBLOBs() {
/* 121 */     return this.rules.generateSelectByExampleWithoutBLOBs();
/*     */   }
/*     */ 
/*     */   public boolean generateSelectByPrimaryKey() {
/* 125 */     return this.rules.generateSelectByPrimaryKey();
/*     */   }
/*     */ 
/*     */   public boolean generateSQLExampleWhereClause() {
/* 129 */     return this.rules.generateSQLExampleWhereClause();
/*     */   }
/*     */ 
/*     */   public boolean generateMyBatis3UpdateByExampleWhereClause() {
/* 133 */     return this.rules.generateMyBatis3UpdateByExampleWhereClause();
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByExampleSelective() {
/* 137 */     return this.rules.generateUpdateByExampleSelective();
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByExampleWithBLOBs() {
/* 141 */     return this.rules.generateUpdateByExampleWithBLOBs();
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByExampleWithoutBLOBs() {
/* 145 */     return this.rules.generateUpdateByExampleWithoutBLOBs();
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByPrimaryKeySelective() {
/* 149 */     return this.rules.generateUpdateByPrimaryKeySelective();
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByPrimaryKeyWithBLOBs() {
/* 153 */     return this.rules.generateUpdateByPrimaryKeyWithBLOBs();
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByPrimaryKeyWithoutBLOBs() {
/* 157 */     return this.rules.generateUpdateByPrimaryKeyWithoutBLOBs();
/*     */   }
/*     */ 
/*     */   public IntrospectedTable getIntrospectedTable() {
/* 161 */     return this.rules.getIntrospectedTable();
/*     */   }
/*     */ 
/*     */   public boolean generateBaseColumnList() {
/* 165 */     return this.rules.generateBaseColumnList();
/*     */   }
/*     */ 
/*     */   public boolean generateBlobColumnList() {
/* 169 */     return this.rules.generateBlobColumnList();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.rules.RulesDelegate
 * JD-Core Version:    0.6.0
 */