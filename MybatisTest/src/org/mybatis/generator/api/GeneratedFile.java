/*    */ package org.mybatis.generator.api;
/*    */ 
/*    */ public abstract class GeneratedFile
/*    */ {
/*    */   private String targetProject;
/*    */ 
/*    */   public GeneratedFile(String targetProject)
/*    */   {
/* 31 */     this.targetProject = targetProject;
/*    */   }
/*    */ 
/*    */   public abstract String getFormattedContent();
/*    */ 
/*    */   public abstract String getFileName();
/*    */ 
/*    */   public String getTargetProject()
/*    */   {
/* 60 */     return this.targetProject;
/*    */   }
/*    */ 
/*    */   public abstract String getTargetPackage();
/*    */ 
/*    */   public String toString()
/*    */   {
/* 73 */     return getFormattedContent();
/*    */   }
/*    */ 
/*    */   public abstract boolean isMergeable();
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.GeneratedFile
 * JD-Core Version:    0.6.0
 */