/*    */ package org.mybatis.generator.internal.rules;
/*    */ 
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ 
/*    */ public class FlatModelRules extends BaseRules
/*    */ {
/*    */   public FlatModelRules(IntrospectedTable introspectedTable)
/*    */   {
/* 34 */     super(introspectedTable);
/*    */   }
/*    */ 
/*    */   public boolean generatePrimaryKeyClass()
/*    */   {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean generateBaseRecordClass()
/*    */   {
/* 52 */     return true;
/*    */   }
/*    */ 
/*    */   public boolean generateRecordWithBLOBsClass()
/*    */   {
/* 61 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.rules.FlatModelRules
 * JD-Core Version:    0.6.0
 */