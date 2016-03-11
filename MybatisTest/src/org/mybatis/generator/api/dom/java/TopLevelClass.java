/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class TopLevelClass extends InnerClass
/*     */   implements CompilationUnit
/*     */ {
/*     */   private Set<FullyQualifiedJavaType> importedTypes;
/*     */   private List<String> fileCommentLines;
/*     */ 
/*     */   public TopLevelClass(FullyQualifiedJavaType type)
/*     */   {
/*  39 */     super(type);
/*  40 */     this.importedTypes = new TreeSet();
/*  41 */     this.fileCommentLines = new ArrayList();
/*     */   }
/*     */ 
/*     */   public TopLevelClass(String typeName) {
/*  45 */     this(new FullyQualifiedJavaType(typeName));
/*     */   }
/*     */ 
/*     */   public Set<FullyQualifiedJavaType> getImportedTypes()
/*     */   {
/*  52 */     return Collections.unmodifiableSet(this.importedTypes);
/*     */   }
/*     */ 
/*     */   public void addImportedType(FullyQualifiedJavaType importedType) {
/*  56 */     if ((importedType != null) && (importedType.isExplicitlyImported()) && (!importedType.getPackageName().equals(getType().getPackageName())))
/*     */     {
/*  60 */       this.importedTypes.add(importedType);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getFormattedContent() {
/*  65 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  67 */     for (String fileCommentLine : this.fileCommentLines) {
/*  68 */       sb.append(fileCommentLine);
/*  69 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  72 */     if (StringUtility.stringHasValue(getType().getPackageName())) {
/*  73 */       sb.append("package ");
/*  74 */       sb.append(getType().getPackageName());
/*  75 */       sb.append(';');
/*  76 */       OutputUtilities.newLine(sb);
/*  77 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  80 */     Set<String> importStrings = OutputUtilities.calculateImports(this.importedTypes);
/*     */ 
/*  82 */     for (String importString : importStrings) {
/*  83 */       sb.append(importString);
/*  84 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  87 */     if (importStrings.size() > 0) {
/*  88 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  91 */     sb.append(super.getFormattedContent(0));
/*     */ 
/*  93 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public boolean isJavaInterface() {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isJavaEnumeration() {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   public void addFileCommentLine(String commentLine) {
/* 105 */     this.fileCommentLines.add(commentLine);
/*     */   }
/*     */ 
/*     */   public List<String> getFileCommentLines() {
/* 109 */     return this.fileCommentLines;
/*     */   }
/*     */ 
/*     */   public void addImportedTypes(Set<FullyQualifiedJavaType> importedTypes) {
/* 113 */     this.importedTypes.addAll(importedTypes);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.TopLevelClass
 * JD-Core Version:    0.6.0
 */