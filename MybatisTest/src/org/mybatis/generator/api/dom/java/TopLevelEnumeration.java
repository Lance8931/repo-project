/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class TopLevelEnumeration extends InnerEnum
/*     */   implements CompilationUnit
/*     */ {
/*     */   private Set<FullyQualifiedJavaType> importedTypes;
/*     */   private List<String> fileCommentLines;
/*     */ 
/*     */   public TopLevelEnumeration(FullyQualifiedJavaType type)
/*     */   {
/*  41 */     super(type);
/*  42 */     this.importedTypes = new TreeSet();
/*  43 */     this.fileCommentLines = new ArrayList();
/*     */   }
/*     */ 
/*     */   public String getFormattedContent() {
/*  47 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  49 */     for (String fileCommentLine : this.fileCommentLines) {
/*  50 */       sb.append(fileCommentLine);
/*  51 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  54 */     if ((getType().getPackageName() != null) && (getType().getPackageName().length() > 0))
/*     */     {
/*  56 */       sb.append("package ");
/*  57 */       sb.append(getType().getPackageName());
/*  58 */       sb.append(';');
/*  59 */       OutputUtilities.newLine(sb);
/*  60 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  63 */     Set<String> importStrings = OutputUtilities.calculateImports(this.importedTypes);
/*     */ 
/*  65 */     for (String importString : importStrings) {
/*  66 */       sb.append(importString);
/*  67 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  70 */     if (importStrings.size() > 0) {
/*  71 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  74 */     sb.append(super.getFormattedContent(0));
/*     */ 
/*  76 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Set<FullyQualifiedJavaType> getImportedTypes() {
/*  80 */     return Collections.unmodifiableSet(this.importedTypes);
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getSuperClass() {
/*  84 */     throw new UnsupportedOperationException(Messages.getString("RuntimeError.11"));
/*     */   }
/*     */ 
/*     */   public boolean isJavaInterface()
/*     */   {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isJavaEnumeration() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   public void addImportedType(FullyQualifiedJavaType importedType) {
/*  97 */     if ((importedType.isExplicitlyImported()) && (!importedType.getPackageName().equals(getType().getPackageName())))
/*     */     {
/* 100 */       this.importedTypes.add(importedType);
/*     */     }
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
 * Qualified Name:     org.mybatis.generator.api.dom.java.TopLevelEnumeration
 * JD-Core Version:    0.6.0
 */