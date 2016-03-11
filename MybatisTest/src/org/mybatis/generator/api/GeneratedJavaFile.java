/*    */ package org.mybatis.generator.api;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ 
/*    */ public class GeneratedJavaFile extends GeneratedFile
/*    */ {
/*    */   private CompilationUnit compilationUnit;
/*    */ 
/*    */   public GeneratedJavaFile(CompilationUnit compilationUnit, String targetProject)
/*    */   {
/* 31 */     super(targetProject);
/* 32 */     this.compilationUnit = compilationUnit;
/*    */   }
/*    */ 
/*    */   public String getFormattedContent()
/*    */   {
/* 37 */     return this.compilationUnit.getFormattedContent();
/*    */   }
/*    */ 
/*    */   public String getFileName()
/*    */   {
/* 42 */     return this.compilationUnit.getType().getShortName() + ".java";
/*    */   }
/*    */ 
/*    */   public String getTargetPackage() {
/* 46 */     return this.compilationUnit.getType().getPackageName();
/*    */   }
/*    */ 
/*    */   public CompilationUnit getCompilationUnit()
/*    */   {
/* 58 */     return this.compilationUnit;
/*    */   }
/*    */ 
/*    */   public boolean isMergeable()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.GeneratedJavaFile
 * JD-Core Version:    0.6.0
 */