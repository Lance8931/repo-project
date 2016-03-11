/*    */ package org.mybatis.generator.internal.rules;
/*    */ 
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ 
/*    */ public class HierarchicalModelRules extends BaseRules
/*    */ {
/*    */   public HierarchicalModelRules(IntrospectedTable introspectedTable)
/*    */   {
/* 34 */     super(introspectedTable);
/*    */   }
/*    */ 
/*    */   public boolean generatePrimaryKeyClass()
/*    */   {
/* 45 */     return this.introspectedTable.hasPrimaryKeyColumns();
/*    */   }
/*    */ 
/*    */   public boolean generateBaseRecordClass()
/*    */   {
/* 56 */     return this.introspectedTable.hasBaseColumns();
/*    */   }
/*    */ 
/*    */   public boolean generateRecordWithBLOBsClass()
/*    */   {
/* 66 */     return this.introspectedTable.hasBLOBColumns();
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.rules.HierarchicalModelRules
 * JD-Core Version:    0.6.0
 */