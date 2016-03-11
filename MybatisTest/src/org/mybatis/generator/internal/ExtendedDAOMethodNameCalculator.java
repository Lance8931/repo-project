/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class ExtendedDAOMethodNameCalculator
/*     */   implements DAOMethodNameCalculator
/*     */ {
/*     */   public String getInsertMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  37 */     StringBuilder sb = new StringBuilder();
/*  38 */     sb.append("insert");
/*  39 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/*  42 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getUpdateByPrimaryKeyWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  54 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  56 */     sb.append("update");
/*  57 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/*  60 */     Rules rules = introspectedTable.getRules();
/*     */ 
/*  62 */     if (!rules.generateUpdateByPrimaryKeyWithBLOBs())
/*  63 */       sb.append("ByPrimaryKey");
/*  64 */     else if (rules.generateRecordWithBLOBsClass())
/*  65 */       sb.append("ByPrimaryKey");
/*     */     else {
/*  67 */       sb.append("ByPrimaryKeyWithoutBLOBs");
/*     */     }
/*     */ 
/*  70 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getUpdateByPrimaryKeyWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/*  82 */     StringBuilder sb = new StringBuilder();
/*  83 */     sb.append("update");
/*  84 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/*  87 */     Rules rules = introspectedTable.getRules();
/*     */ 
/*  89 */     if (!rules.generateUpdateByPrimaryKeyWithoutBLOBs())
/*  90 */       sb.append("ByPrimaryKey");
/*  91 */     else if (rules.generateRecordWithBLOBsClass())
/*  92 */       sb.append("ByPrimaryKey");
/*     */     else {
/*  94 */       sb.append("ByPrimaryKeyWithBLOBs");
/*     */     }
/*     */ 
/*  97 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getDeleteByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 102 */     StringBuilder sb = new StringBuilder();
/* 103 */     sb.append("delete");
/* 104 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 106 */     sb.append("ByExample");
/*     */ 
/* 108 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getDeleteByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 113 */     StringBuilder sb = new StringBuilder();
/* 114 */     sb.append("delete");
/* 115 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 117 */     sb.append("ByPrimaryKey");
/*     */ 
/* 119 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getSelectByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 129 */     StringBuilder sb = new StringBuilder();
/* 130 */     sb.append("select");
/* 131 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 133 */     sb.append("ByExample");
/*     */ 
/* 135 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 137 */     if (rules.generateSelectByExampleWithBLOBs()) {
/* 138 */       sb.append("WithoutBLOBs");
/*     */     }
/*     */ 
/* 141 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getSelectByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 151 */     StringBuilder sb = new StringBuilder();
/* 152 */     sb.append("select");
/* 153 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 155 */     sb.append("ByExample");
/*     */ 
/* 157 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 159 */     if (rules.generateSelectByExampleWithoutBLOBs()) {
/* 160 */       sb.append("WithBLOBs");
/*     */     }
/*     */ 
/* 163 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getSelectByPrimaryKeyMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 168 */     StringBuilder sb = new StringBuilder();
/* 169 */     sb.append("select");
/* 170 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 172 */     sb.append("ByPrimaryKey");
/*     */ 
/* 174 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getUpdateByPrimaryKeySelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 179 */     StringBuilder sb = new StringBuilder();
/* 180 */     sb.append("update");
/* 181 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 183 */     sb.append("ByPrimaryKeySelective");
/*     */ 
/* 185 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getCountByExampleMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 190 */     StringBuilder sb = new StringBuilder();
/* 191 */     sb.append("count");
/* 192 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 194 */     sb.append("ByExample");
/*     */ 
/* 196 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getUpdateByExampleSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 201 */     StringBuilder sb = new StringBuilder();
/* 202 */     sb.append("update");
/* 203 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 205 */     sb.append("ByExampleSelective");
/*     */ 
/* 207 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getUpdateByExampleWithBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 212 */     StringBuilder sb = new StringBuilder();
/* 213 */     sb.append("update");
/* 214 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 217 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 219 */     if (!rules.generateUpdateByExampleWithoutBLOBs())
/* 220 */       sb.append("ByExample");
/* 221 */     else if (rules.generateRecordWithBLOBsClass())
/* 222 */       sb.append("ByExample");
/*     */     else {
/* 224 */       sb.append("ByExampleWithBLOBs");
/*     */     }
/*     */ 
/* 227 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getUpdateByExampleWithoutBLOBsMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 232 */     StringBuilder sb = new StringBuilder();
/*     */ 
/* 234 */     sb.append("update");
/* 235 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 238 */     Rules rules = introspectedTable.getRules();
/*     */ 
/* 240 */     if (!rules.generateUpdateByExampleWithBLOBs())
/* 241 */       sb.append("ByExample");
/* 242 */     else if (rules.generateRecordWithBLOBsClass())
/* 243 */       sb.append("ByExample");
/*     */     else {
/* 245 */       sb.append("ByExampleWithoutBLOBs");
/*     */     }
/*     */ 
/* 248 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getInsertSelectiveMethodName(IntrospectedTable introspectedTable)
/*     */   {
/* 253 */     StringBuilder sb = new StringBuilder();
/* 254 */     sb.append("insert");
/* 255 */     sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
/*     */ 
/* 257 */     sb.append("Selective");
/*     */ 
/* 259 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.ExtendedDAOMethodNameCalculator
 * JD-Core Version:    0.6.0
 */