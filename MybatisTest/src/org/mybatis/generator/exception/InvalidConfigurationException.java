/*    */ package org.mybatis.generator.exception;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class InvalidConfigurationException extends Exception
/*    */ {
/*    */   static final long serialVersionUID = 4902307610148543411L;
/*    */   private List<String> errors;
/*    */ 
/*    */   public InvalidConfigurationException(List<String> errors)
/*    */   {
/* 33 */     this.errors = errors;
/*    */   }
/*    */ 
/*    */   public List<String> getErrors() {
/* 37 */     return this.errors;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.exception.InvalidConfigurationException
 * JD-Core Version:    0.6.0
 */