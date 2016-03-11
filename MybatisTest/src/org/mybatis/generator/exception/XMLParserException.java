/*    */ package org.mybatis.generator.exception;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class XMLParserException extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 5172525430401340573L;
/*    */   private List<String> errors;
/*    */ 
/*    */   public XMLParserException(List<String> errors)
/*    */   {
/* 35 */     this.errors = errors;
/*    */   }
/*    */ 
/*    */   public XMLParserException(String error) {
/* 39 */     super(error);
/* 40 */     this.errors = new ArrayList();
/* 41 */     this.errors.add(error);
/*    */   }
/*    */ 
/*    */   public List<String> getErrors() {
/* 45 */     return this.errors;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.exception.XMLParserException
 * JD-Core Version:    0.6.0
 */