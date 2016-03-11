/*    */ package org.mybatis.generator.internal.db;
/*    */ 
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ public class ActualTableName
/*    */ {
/*    */   private String tableName;
/*    */   private String catalog;
/*    */   private String schema;
/*    */   private String fullName;
/*    */ 
/*    */   public ActualTableName(String catalog, String schema, String tableName)
/*    */   {
/* 36 */     this.catalog = catalog;
/* 37 */     this.schema = schema;
/* 38 */     this.tableName = tableName;
/* 39 */     this.fullName = StringUtility.composeFullyQualifiedTableName(catalog, schema, tableName, '.');
/*    */   }
/*    */ 
/*    */   public String getCatalog()
/*    */   {
/* 44 */     return this.catalog;
/*    */   }
/*    */ 
/*    */   public String getSchema() {
/* 48 */     return this.schema;
/*    */   }
/*    */ 
/*    */   public String getTableName() {
/* 52 */     return this.tableName;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 57 */     if ((obj == null) || (!(obj instanceof ActualTableName))) {
/* 58 */       return false;
/*    */     }
/*    */ 
/* 61 */     return obj.toString().equals(toString());
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 66 */     return this.fullName.hashCode();
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 71 */     return this.fullName;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.db.ActualTableName
 * JD-Core Version:    0.6.0
 */