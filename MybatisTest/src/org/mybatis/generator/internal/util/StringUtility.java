/*     */ package org.mybatis.generator.internal.util;
/*     */ 
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ public class StringUtility
/*     */ {
/*     */   public static boolean stringHasValue(String s)
/*     */   {
/*  34 */     return (s != null) && (s.length() > 0);
/*     */   }
/*     */ 
/*     */   public static String composeFullyQualifiedTableName(String catalog, String schema, String tableName, char separator)
/*     */   {
/*  39 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  41 */     if (stringHasValue(catalog)) {
/*  42 */       sb.append(catalog);
/*  43 */       sb.append(separator);
/*     */     }
/*     */ 
/*  46 */     if (stringHasValue(schema)) {
/*  47 */       sb.append(schema);
/*  48 */       sb.append(separator);
/*     */     }
/*  50 */     else if (sb.length() > 0) {
/*  51 */       sb.append(separator);
/*     */     }
/*     */ 
/*  55 */     sb.append(tableName);
/*     */ 
/*  57 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static boolean stringContainsSpace(String s) {
/*  61 */     return (s != null) && (s.indexOf(' ') != -1);
/*     */   }
/*     */ 
/*     */   public static String escapeStringForJava(String s) {
/*  65 */     StringTokenizer st = new StringTokenizer(s, "\"", true);
/*  66 */     StringBuilder sb = new StringBuilder();
/*  67 */     while (st.hasMoreTokens()) {
/*  68 */       String token = st.nextToken();
/*  69 */       if ("\"".equals(token))
/*  70 */         sb.append("\\\"");
/*     */       else {
/*  72 */         sb.append(token);
/*     */       }
/*     */     }
/*     */ 
/*  76 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String escapeStringForXml(String s) {
/*  80 */     StringTokenizer st = new StringTokenizer(s, "\"", true);
/*  81 */     StringBuilder sb = new StringBuilder();
/*  82 */     while (st.hasMoreTokens()) {
/*  83 */       String token = st.nextToken();
/*  84 */       if ("\"".equals(token))
/*  85 */         sb.append("&quot;");
/*     */       else {
/*  87 */         sb.append(token);
/*     */       }
/*     */     }
/*     */ 
/*  91 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static boolean isTrue(String s) {
/*  95 */     return "true".equalsIgnoreCase(s);
/*     */   }
/*     */ 
/*     */   public static boolean stringContainsSQLWildcard(String s) {
/*  99 */     if (s == null) {
/* 100 */       return false;
/*     */     }
/*     */ 
/* 103 */     return (s.indexOf('%') != -1) || (s.indexOf('_') != -1);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.util.StringUtility
 * JD-Core Version:    0.6.0
 */