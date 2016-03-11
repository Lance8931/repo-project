/*    */ package org.mybatis.generator.internal.rules;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ 
/*    */ public class ConditionalModelRules extends BaseRules
/*    */ {
/*    */   public ConditionalModelRules(IntrospectedTable introspectedTable)
/*    */   {
/* 35 */     super(introspectedTable);
/*    */   }
/*    */ 
/*    */   public boolean generatePrimaryKeyClass()
/*    */   {
/* 44 */     return this.introspectedTable.getPrimaryKeyColumns().size() > 1;
/*    */   }
/*    */ 
/*    */   public boolean generateBaseRecordClass()
/*    */   {
/* 56 */     return (this.introspectedTable.getBaseColumns().size() > 0) || (this.introspectedTable.getPrimaryKeyColumns().size() == 1) || ((this.introspectedTable.getBLOBColumns().size() > 0) && (!generateRecordWithBLOBsClass()));
/*    */   }
/*    */ 
/*    */   public boolean generateRecordWithBLOBsClass()
/*    */   {
/* 70 */     int otherColumnCount = this.introspectedTable.getPrimaryKeyColumns().size() + this.introspectedTable.getBaseColumns().size();
/*    */ 
/* 73 */     return (otherColumnCount > 1) && (this.introspectedTable.getBLOBColumns().size() > 1);
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.rules.ConditionalModelRules
 * JD-Core Version:    0.6.0
 */