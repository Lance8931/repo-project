/*     */ package org.mybatis.generator.codegen.ibatis2;
/*     */ 
/*     */ import java.util.StringTokenizer;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class Ibatis2FormattingUtilities
/*     */ {
/*     */   public static String getEscapedColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/*  38 */     StringBuilder sb = new StringBuilder();
/*  39 */     sb.append(escapeStringForIbatis2(introspectedColumn.getActualColumnName()));
/*     */ 
/*  42 */     if (introspectedColumn.isColumnNameDelimited()) {
/*  43 */       sb.insert(0, introspectedColumn.getContext().getBeginningDelimiter());
/*     */ 
/*  45 */       sb.append(introspectedColumn.getContext().getEndingDelimiter());
/*     */     }
/*     */ 
/*  48 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getAliasedEscapedColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/*  58 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/*  59 */       StringBuilder sb = new StringBuilder();
/*     */ 
/*  61 */       sb.append(introspectedColumn.getTableAlias());
/*  62 */       sb.append('.');
/*  63 */       sb.append(getEscapedColumnName(introspectedColumn));
/*  64 */       return sb.toString();
/*     */     }
/*  66 */     return getEscapedColumnName(introspectedColumn);
/*     */   }
/*     */ 
/*     */   public static String getParameterClause(IntrospectedColumn introspectedColumn)
/*     */   {
/*  72 */     return getParameterClause(introspectedColumn, null);
/*     */   }
/*     */ 
/*     */   public static String getParameterClause(IntrospectedColumn introspectedColumn, String prefix)
/*     */   {
/*  77 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  79 */     sb.append('#');
/*  80 */     sb.append(introspectedColumn.getJavaProperty(prefix));
/*     */ 
/*  82 */     if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler())) {
/*  83 */       sb.append(",jdbcType=");
/*  84 */       sb.append(introspectedColumn.getJdbcTypeName());
/*  85 */       sb.append(",handler=");
/*  86 */       sb.append(introspectedColumn.getTypeHandler());
/*     */     } else {
/*  88 */       sb.append(':');
/*  89 */       sb.append(introspectedColumn.getJdbcTypeName());
/*     */     }
/*     */ 
/*  92 */     sb.append('#');
/*     */ 
/*  94 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getSelectListPhrase(IntrospectedColumn introspectedColumn)
/*     */   {
/* 105 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 106 */       StringBuilder sb = new StringBuilder();
/*     */ 
/* 108 */       sb.append(getAliasedEscapedColumnName(introspectedColumn));
/* 109 */       sb.append(" as ");
/* 110 */       if (introspectedColumn.isColumnNameDelimited()) {
/* 111 */         sb.append(introspectedColumn.getContext().getBeginningDelimiter());
/*     */       }
/*     */ 
/* 114 */       sb.append(introspectedColumn.getTableAlias());
/* 115 */       sb.append('_');
/* 116 */       sb.append(escapeStringForIbatis2(introspectedColumn.getActualColumnName()));
/*     */ 
/* 118 */       if (introspectedColumn.isColumnNameDelimited()) {
/* 119 */         sb.append(introspectedColumn.getContext().getEndingDelimiter());
/*     */       }
/* 121 */       return sb.toString();
/*     */     }
/* 123 */     return getEscapedColumnName(introspectedColumn);
/*     */   }
/*     */ 
/*     */   public static String escapeStringForIbatis2(String s)
/*     */   {
/* 128 */     StringTokenizer st = new StringTokenizer(s, "$#", true);
/* 129 */     StringBuilder sb = new StringBuilder();
/* 130 */     while (st.hasMoreTokens()) {
/* 131 */       String token = st.nextToken();
/* 132 */       if ("$".equals(token))
/* 133 */         sb.append("$$");
/* 134 */       else if ("#".equals(token))
/* 135 */         sb.append("##");
/*     */       else {
/* 137 */         sb.append(token);
/*     */       }
/*     */     }
/*     */ 
/* 141 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getAliasedActualColumnName(IntrospectedColumn introspectedColumn)
/*     */   {
/* 158 */     StringBuilder sb = new StringBuilder();
/* 159 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 160 */       sb.append(introspectedColumn.getTableAlias());
/* 161 */       sb.append('.');
/*     */     }
/*     */ 
/* 164 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 165 */       sb.append(StringUtility.escapeStringForJava(introspectedColumn.getContext().getBeginningDelimiter()));
/*     */     }
/*     */ 
/* 169 */     sb.append(introspectedColumn.getActualColumnName());
/*     */ 
/* 171 */     if (introspectedColumn.isColumnNameDelimited()) {
/* 172 */       sb.append(StringUtility.escapeStringForJava(introspectedColumn.getContext().getEndingDelimiter()));
/*     */     }
/*     */ 
/* 176 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getRenamedColumnNameForResultMap(IntrospectedColumn introspectedColumn)
/*     */   {
/* 188 */     if (StringUtility.stringHasValue(introspectedColumn.getTableAlias())) {
/* 189 */       StringBuilder sb = new StringBuilder();
/*     */ 
/* 191 */       sb.append(introspectedColumn.getTableAlias());
/* 192 */       sb.append('_');
/* 193 */       sb.append(introspectedColumn.getActualColumnName());
/* 194 */       return sb.toString();
/*     */     }
/* 196 */     return introspectedColumn.getActualColumnName();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities
 * JD-Core Version:    0.6.0
 */