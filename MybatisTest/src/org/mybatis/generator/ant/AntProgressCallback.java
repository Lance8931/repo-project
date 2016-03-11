/*    */ package org.mybatis.generator.ant;
/*    */ 
/*    */ import org.apache.tools.ant.Task;
/*    */ import org.mybatis.generator.internal.NullProgressCallback;
/*    */ 
/*    */ public class AntProgressCallback extends NullProgressCallback
/*    */ {
/*    */   private Task task;
/*    */   private boolean verbose;
/*    */ 
/*    */   public AntProgressCallback(Task task, boolean verbose)
/*    */   {
/* 39 */     this.task = task;
/* 40 */     this.verbose = verbose;
/*    */   }
/*    */ 
/*    */   public void startTask(String subTaskName)
/*    */   {
/* 45 */     if (this.verbose)
/* 46 */       this.task.log(subTaskName, 3);
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.ant.AntProgressCallback
 * JD-Core Version:    0.6.0
 */