/*    */ package org.mybatis.generator.api.dom.java;
/*    */ 
/*    */ public enum JavaVisibility
/*    */ {
/* 24 */   PUBLIC("public "), 
/* 25 */   PRIVATE("private "), 
/* 26 */   PROTECTED("protected "), 
/* 27 */   DEFAULT("");
/*    */ 
/*    */   private String value;
/*    */ 
/* 32 */   private JavaVisibility(String value) { this.value = value; }
/*    */ 
/*    */   public String getValue()
/*    */   {
/* 36 */     return this.value;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.JavaVisibility
 * JD-Core Version:    0.6.0
 */