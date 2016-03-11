/*    */ package org.mybatis.generator.codegen;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.ProgressCallback;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public abstract class AbstractGenerator
/*    */ {
/*    */   protected Context context;
/*    */   protected IntrospectedTable introspectedTable;
/*    */   protected List<String> warnings;
/*    */   protected ProgressCallback progressCallback;
/*    */ 
/*    */   public Context getContext()
/*    */   {
/* 40 */     return this.context;
/*    */   }
/*    */ 
/*    */   public void setContext(Context context) {
/* 44 */     this.context = context;
/*    */   }
/*    */ 
/*    */   public IntrospectedTable getIntrospectedTable() {
/* 48 */     return this.introspectedTable;
/*    */   }
/*    */ 
/*    */   public void setIntrospectedTable(IntrospectedTable introspectedTable) {
/* 52 */     this.introspectedTable = introspectedTable;
/*    */   }
/*    */ 
/*    */   public List<String> getWarnings() {
/* 56 */     return this.warnings;
/*    */   }
/*    */ 
/*    */   public void setWarnings(List<String> warnings) {
/* 60 */     this.warnings = warnings;
/*    */   }
/*    */ 
/*    */   public ProgressCallback getProgressCallback() {
/* 64 */     return this.progressCallback;
/*    */   }
/*    */ 
/*    */   public void setProgressCallback(ProgressCallback progressCallback) {
/* 68 */     this.progressCallback = progressCallback;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.AbstractGenerator
 * JD-Core Version:    0.6.0
 */