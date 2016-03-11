/*    */ package org.mybatis.generator.api;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.mybatis.generator.internal.NullProgressCallback;
/*    */ 
/*    */ public class VerboseProgressCallback extends NullProgressCallback
/*    */ {
/*    */   public void startTask(String taskName)
/*    */   {
/* 36 */     System.out.println(taskName);
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.VerboseProgressCallback
 * JD-Core Version:    0.6.0
 */