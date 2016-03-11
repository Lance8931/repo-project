/*     */ package org.mybatis.generator.internal.rules;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable.TargetRuntime;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.config.TableConfiguration;
/*     */ 
/*     */ public abstract class BaseRules
/*     */   implements Rules
/*     */ {
/*     */   protected TableConfiguration tableConfiguration;
/*     */   protected IntrospectedTable introspectedTable;
/*     */ 
/*     */   public BaseRules(IntrospectedTable introspectedTable)
/*     */   {
/*  40 */     this.introspectedTable = introspectedTable;
/*  41 */     this.tableConfiguration = introspectedTable.getTableConfiguration();
/*     */   }
/*     */ 
/*     */   public boolean generateInsert()
/*     */   {
/*  52 */     return this.tableConfiguration.isInsertStatementEnabled();
/*     */   }
/*     */ 
/*     */   public boolean generateInsertSelective()
/*     */   {
/*  63 */     return this.tableConfiguration.isInsertStatementEnabled();
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType calculateAllFieldsClass()
/*     */   {
/*     */     String answer;
/*  78 */     if (generateRecordWithBLOBsClass()) {
/*  79 */       answer = this.introspectedTable.getRecordWithBLOBsType();
/*     */     }
/*     */     else
/*     */     {
/*  80 */       if (generateBaseRecordClass())
/*  81 */         answer = this.introspectedTable.getBaseRecordType();
/*     */       else {
/*  83 */         answer = this.introspectedTable.getPrimaryKeyType();
/*     */       }
/*     */     }
/*  86 */     return new FullyQualifiedJavaType(answer);
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByPrimaryKeyWithoutBLOBs()
/*     */   {
/*  98 */     boolean rc = (this.tableConfiguration.isUpdateByPrimaryKeyStatementEnabled()) && (this.introspectedTable.hasPrimaryKeyColumns()) && (this.introspectedTable.hasBaseColumns());
/*     */ 
/* 102 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByPrimaryKeyWithBLOBs()
/*     */   {
/* 114 */     boolean rc = (this.tableConfiguration.isUpdateByPrimaryKeyStatementEnabled()) && (this.introspectedTable.hasPrimaryKeyColumns()) && (this.introspectedTable.hasBLOBColumns());
/*     */ 
/* 118 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByPrimaryKeySelective()
/*     */   {
/* 130 */     boolean rc = (this.tableConfiguration.isUpdateByPrimaryKeyStatementEnabled()) && (this.introspectedTable.hasPrimaryKeyColumns()) && ((this.introspectedTable.hasBLOBColumns()) || (this.introspectedTable.hasBaseColumns()));
/*     */ 
/* 135 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateDeleteByPrimaryKey()
/*     */   {
/* 147 */     boolean rc = (this.tableConfiguration.isDeleteByPrimaryKeyStatementEnabled()) && (this.introspectedTable.hasPrimaryKeyColumns());
/*     */ 
/* 150 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateDeleteByExample()
/*     */   {
/* 161 */     boolean rc = this.tableConfiguration.isDeleteByExampleStatementEnabled();
/*     */ 
/* 163 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateBaseResultMap()
/*     */   {
/* 173 */     boolean rc = (this.tableConfiguration.isSelectByExampleStatementEnabled()) || (this.tableConfiguration.isSelectByPrimaryKeyStatementEnabled());
/*     */ 
/* 176 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateResultMapWithBLOBs()
/*     */   {
/* 187 */     boolean rc = ((this.tableConfiguration.isSelectByExampleStatementEnabled()) || (this.tableConfiguration.isSelectByPrimaryKeyStatementEnabled())) && (this.introspectedTable.hasBLOBColumns());
/*     */ 
/* 191 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateSQLExampleWhereClause()
/*     */   {
/* 206 */     boolean rc = (this.tableConfiguration.isSelectByExampleStatementEnabled()) || (this.tableConfiguration.isDeleteByExampleStatementEnabled()) || (this.tableConfiguration.isCountByExampleStatementEnabled());
/*     */ 
/* 210 */     if (this.introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.IBATIS2) {
/* 211 */       rc |= this.tableConfiguration.isUpdateByExampleStatementEnabled();
/*     */     }
/*     */ 
/* 214 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateMyBatis3UpdateByExampleWhereClause()
/*     */   {
/* 229 */     return (this.introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) && (this.tableConfiguration.isUpdateByExampleStatementEnabled());
/*     */   }
/*     */ 
/*     */   public boolean generateSelectByPrimaryKey()
/*     */   {
/* 242 */     boolean rc = (this.tableConfiguration.isSelectByPrimaryKeyStatementEnabled()) && (this.introspectedTable.hasPrimaryKeyColumns()) && ((this.introspectedTable.hasBaseColumns()) || (this.introspectedTable.hasBLOBColumns()));
/*     */ 
/* 247 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateSelectByExampleWithoutBLOBs()
/*     */   {
/* 258 */     return this.tableConfiguration.isSelectByExampleStatementEnabled();
/*     */   }
/*     */ 
/*     */   public boolean generateSelectByExampleWithBLOBs()
/*     */   {
/* 270 */     boolean rc = (this.tableConfiguration.isSelectByExampleStatementEnabled()) && (this.introspectedTable.hasBLOBColumns());
/*     */ 
/* 273 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateExampleClass()
/*     */   {
/* 284 */     boolean rc = (this.tableConfiguration.isSelectByExampleStatementEnabled()) || (this.tableConfiguration.isDeleteByExampleStatementEnabled()) || (this.tableConfiguration.isCountByExampleStatementEnabled()) || (this.tableConfiguration.isUpdateByExampleStatementEnabled());
/*     */ 
/* 289 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateCountByExample() {
/* 293 */     boolean rc = this.tableConfiguration.isCountByExampleStatementEnabled();
/*     */ 
/* 295 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByExampleSelective() {
/* 299 */     boolean rc = this.tableConfiguration.isUpdateByExampleStatementEnabled();
/*     */ 
/* 301 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByExampleWithoutBLOBs() {
/* 305 */     boolean rc = (this.tableConfiguration.isUpdateByExampleStatementEnabled()) && ((this.introspectedTable.hasPrimaryKeyColumns()) || (this.introspectedTable.hasBaseColumns()));
/*     */ 
/* 309 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean generateUpdateByExampleWithBLOBs() {
/* 313 */     boolean rc = (this.tableConfiguration.isUpdateByExampleStatementEnabled()) && (this.introspectedTable.hasBLOBColumns());
/*     */ 
/* 316 */     return rc;
/*     */   }
/*     */ 
/*     */   public IntrospectedTable getIntrospectedTable() {
/* 320 */     return this.introspectedTable;
/*     */   }
/*     */ 
/*     */   public boolean generateBaseColumnList() {
/* 324 */     return (generateSelectByPrimaryKey()) || (generateSelectByExampleWithoutBLOBs());
/*     */   }
/*     */ 
/*     */   public boolean generateBlobColumnList()
/*     */   {
/* 329 */     return (this.introspectedTable.hasBLOBColumns()) && ((this.tableConfiguration.isSelectByExampleStatementEnabled()) || (this.tableConfiguration.isSelectByPrimaryKeyStatementEnabled()));
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.rules.BaseRules
 * JD-Core Version:    0.6.0
 */