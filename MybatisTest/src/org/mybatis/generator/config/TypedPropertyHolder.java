/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ public abstract class TypedPropertyHolder extends PropertyHolder
/*    */ {
/*    */   private String configurationType;
/*    */ 
/*    */   public String getConfigurationType()
/*    */   {
/* 33 */     return this.configurationType;
/*    */   }
/*    */ 
/*    */   public void setConfigurationType(String configurationType)
/*    */   {
/* 44 */     if (!"DEFAULT".equalsIgnoreCase(configurationType))
/* 45 */       this.configurationType = configurationType;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.TypedPropertyHolder
 * JD-Core Version:    0.6.0
 */