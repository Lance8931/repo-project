/*     */ package org.mybatis.generator.api.dom;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ 
/*     */ public class OutputUtilities
/*     */ {
/*     */   private static final String lineSeparator;
/*     */ 
/*     */   public static void javaIndent(StringBuilder sb, int indentLevel)
/*     */   {
/*  54 */     for (int i = 0; i < indentLevel; i++)
/*  55 */       sb.append("    ");
/*     */   }
/*     */ 
/*     */   public static void xmlIndent(StringBuilder sb, int indentLevel)
/*     */   {
/*  69 */     for (int i = 0; i < indentLevel; i++)
/*  70 */       sb.append("  ");
/*     */   }
/*     */ 
/*     */   public static void newLine(StringBuilder sb)
/*     */   {
/*  81 */     sb.append(lineSeparator);
/*     */   }
/*     */ 
/*     */   public static Set<String> calculateImports(Set<FullyQualifiedJavaType> importedTypes)
/*     */   {
/*  92 */     StringBuilder sb = new StringBuilder();
/*  93 */     Set importStrings = new TreeSet();
/*  94 */     for (FullyQualifiedJavaType fqjt : importedTypes) {
/*  95 */       for (String importString : fqjt.getImportList()) {
/*  96 */         sb.setLength(0);
/*  97 */         sb.append("import ");
/*  98 */         sb.append(importString);
/*  99 */         sb.append(';');
/* 100 */         importStrings.add(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/* 104 */     return importStrings;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  30 */     String ls = System.getProperty("line.separator");
/*  31 */     if (ls == null) {
/*  32 */       ls = "\n";
/*     */     }
/*  34 */     lineSeparator = ls;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.OutputUtilities
 * JD-Core Version:    0.6.0
 */