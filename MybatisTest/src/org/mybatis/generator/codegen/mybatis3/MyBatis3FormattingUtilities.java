/*     */ package org.mybatis.generator.codegen.mybatis3;
/*     */ 
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class MyBatis3FormattingUtilities
/*     */ {
/*     */   public static String getParameterClause(IntrospectedColumn introspectedColumn)
/*     */   {
/*  36 */     return getParameterClause(introspectedColumn, null);
/*     */   }
/*     */ 
/*     */   public static String getParameterClause(IntrospectedColumn introspectedColumn, String prefix)
/*     */   {
/*  41 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  43 */     sb.append("#{");
/*  44 */     sb.append(introspectedColumn.getJavaProperty(prefix));
/*  45 */     sb.append(",jdbcType=");
/*  46 */     sb.append(introspectedColumn.getJdbcTypeName());
/*     */ 
/*  48 */     if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler())) {
/*  49 */       sb.append(",typeHandler=");
/*  50 */       sb.append(introspectedColumn.getTypeHandler());
/*     */     }
/*     */ 
/*  53 */     sb.append('}');
/*     */ 
/*  55 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getSelectListPhrase(IntrospectedColumn introspectedColumn)
/*     */   {
/*  66 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/*  67 */       StringBuilder sb = new StringBuilder();
/*     */ 
/*  69 */       sb.append(getAliasedEscapedColumnName(introspectedColumn));
/*  70 */       sb.append(" as ");
/*  71 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  72 */         sb.append(introspectedColumn.getContext().getBeginningDelimiter());
/*     */       }
/*     */ 
/*  75 */       sb.append(introspectedColumn.getTableAlias());
/*  76 */       sb.append('_');
/*  77 */       sb.append(escapeStringForMyBatis3(introspectedColumn.getActualColumnName()));
/*     */ 
/*  79 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  80 */         sb.append(introspectedColumn.getContext().getEndingDelimiter());
/*     */       }
/*  82 */       return sb.toString();
/*     */     }
/*  84 */     return getEscapedColumnName(introspectedColumn);
/*     */   }
/*     */ 
/*     */   public static String getEscapedColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/*  90 */     StringBuilder sb = new StringBuilder();
/*  91 */     sb.append(escapeStringForMyBatis3(introspectedColumn.getActualColumnName()));
/*     */ 
/*  94 */     if (introspectedColumn.isColumnNameDelimited()) {
/*  95 */       sb.insert(0, introspectedColumn.getContext().getBeginningDelimiter());
/*     */ 
/*  97 */       sb.append(introspectedColumn.getContext().getEndingDelimiter());
/*     */     }
/*     */ 
/* 100 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getAliasedEscapedColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/* 110 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 111 */       StringBuilder sb = new StringBuilder();
/*     */ 
/* 113 */       sb.append(introspectedColumn.getTableAlias());
/* 114 */       sb.append('.');
/* 115 */       sb.append(getEscapedColumnName(introspectedColumn));
/* 116 */       return sb.toString();
/*     */     }
/* 118 */     return getEscapedColumnName(introspectedColumn);
/*     */   }
/*     */ 
/*     */   public static String getAliasedActualColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/* 136 */     StringBuilder sb = new StringBuilder();
/* 137 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 138 */       sb.append(introspectedColumn.getTableAlias());
/* 139 */       sb.append('.');
/*     */     }
/*     */ 
/* 142 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 143 */       sb.append(StringUtility.escapeStringForJava(introspectedColumn.getContext().getBeginningDelimiter()));
/*     */     }
/*     */ 
/* 147 */     sb.append(introspectedColumn.getActualColumnName());
/*     */ 
/* 149 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 150 */       sb.append(StringUtility.escapeStringForJava(introspectedColumn.getContext().getEndingDelimiter()));
/*     */     }
/*     */ 
/* 154 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getRenamedColumnNameForResultMap(IntrospectedColumn introspectedColumn)
/*     */   {
/* 166 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 167 */       StringBuilder sb = new StringBuilder();
/*     */ 
/* 169 */       sb.append(introspectedColumn.getTableAlias());
/* 170 */       sb.append('_');
/* 171 */       sb.append(introspectedColumn.getActualColumnName());
/* 172 */       return sb.toString();
/*     */     }
/* 174 */     return introspectedColumn.getActualColumnName();
/*     */   }
/*     */ 
/*     */   public static String escapeStringForMyBatis3(String s)
/*     */   {
/* 180 */     return s;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities
 * JD-Core Version:    0.6.0
 */