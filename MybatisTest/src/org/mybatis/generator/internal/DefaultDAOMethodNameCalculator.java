/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class DefaultDAOMethodNameCalculator
/*     */   implements DAOMethodNameCalculator
/*     */ {
/*     */   public String getInsertMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  37 */     return "insert";
/*     */   }
/*     */ 
/*     */   public String getUpdateByPrimaryKeyWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  49 */     Rules rules = introspectedTable.getRules();
/*     */ 
/*  51 */     if (!rules.generateUpdateByPrimaryKeyWithBLOBs())
/*  52 */       return "updateByPrimaryKey";
/*  53 */     if (rules.generateRecordWithBLOBsClass()) {
/*  54 */       return "updateByPrimaryKey";
/*     */     }
/*  56 */     return "updateByPrimaryKeyWithoutBLOBs";
/*     */   }
/*     */ 
/*     */   public String getUpdateByPrimaryKeyWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  69 */     Rules rules = introspectedTable.getRules();
/*     */ 
/*  71 */     if (!rules.generateUpdateByPrimaryKeyWithoutBLOBs())
/*  72 */       return "updateByPrimaryKey";
/*  73 */     if (rules.generateRecordWithBLOBsClass()) {
/*  74 */       return "updateByPrimaryKey";
/*     */     }
/*  76 */     return "updateByPrimaryKeyWithBLOBs";
/*     */   }
/*     */ 
/*     */   public String getDeleteByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  82 */     return "deleteByExample";
/*     */   }
/*     */ 
/*     */   public String getDeleteByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  87 */     return "deleteByPrimaryKey";
/*     */   }
/*     */ 
/*     */   public String getSelectByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  97 */     Rules rules = introspectedTable.getRules();
/*     */ 
/*  99 */     if (!rules.generateSelectByExampleWithBLOBs()) {
/* 100 */       return "selectByExample";
/*     */     }
/* 102 */     return "selectByExampleWithoutBLOBs";
/*     */   }
/*     */ 
/*     */   public String getSelectByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 113 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 115 */     if (!rules.generateSelectByExampleWithoutBLOBs()) {
/* 116 */       return "selectByExample";
/*     */     }
/* 118 */     return "selectByExampleWithBLOBs";
/*     */   }
/*     */ 
/*     */   public String getSelectByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 124 */     return "selectByPrimaryKey";
/*     */   }
/*     */ 
/*     */   public String getUpdateByPrimaryKeySelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 129 */     return "updateByPrimaryKeySelective";
/*     */   }
/*     */ 
/*     */   public String getCountByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 134 */     return "countByExample";
/*     */   }
/*     */ 
/*     */   public String getUpdateByExampleSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 139 */     return "updateByExampleSelective";
/*     */   }
/*     */ 
/*     */   public String getUpdateByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 144 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 146 */     if (!rules.generateUpdateByExampleWithoutBLOBs())
/* 147 */       return "updateByExample";
/* 148 */     if (rules.generateRecordWithBLOBsClass()) {
/* 149 */       return "updateByExample";
/*     */     }
/* 151 */     return "updateByExampleWithBLOBs";
/*     */   }
/*     */ 
/*     */   public String getUpdateByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 157 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 159 */     if (!rules.generateUpdateByExampleWithBLOBs())
/* 160 */       return "updateByExample";
/* 161 */     if (rules.generateRecordWithBLOBsClass()) {
/* 162 */       return "updateByExample";
/*     */     }
/* 164 */     return "updateByExampleWithoutBLOBs";
/*     */   }
/*     */ 
/*     */   public String getInsertSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 170 */     return "insertSelective";
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.DefaultDAOMethodNameCalculator
 * JD-Core Version:    0.6.0
 */