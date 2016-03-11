/*    */ package org.mybatis.generator.internal.db;
/*    */ 
/*    */ public enum DatabaseDialects
/*    */ {
/* 25 */   DB2("VALUES IDENTITY_VAL_LOCAL()"), 
/* 26 */   MYSQL("SELECT LAST_INSERT_ID()"), 
/* 27 */   SQLSERVER("SELECT SCOPE_IDENTITY()"), 
/* 28 */   CLOUDSCAPE("VALUES IDENTITY_VAL_LOCAL()"), 
/* 29 */   DERBY("VALUES IDENTITY_VAL_LOCAL()"), 
/* 30 */   HSQLDB("CALL IDENTITY()"), 
/* 31 */   SYBASE("SELECT @@IDENTITY"), 
/* 32 */   DB2_MF("SELECT IDENTITY_VAL_LOCAL() FROM SYSIBM.SYSDUMMY1"), 
/* 33 */   INFORMIX("select dbinfo('sqlca.sqlerrd1') from systables where tabid=1");
/*    */ 
/*    */   private String identityRetrievalStatement;
/*    */ 
/*    */   private DatabaseDialects(String identityRetrievalStatement)
/*    */   {
/* 41 */     this.identityRetrievalStatement = identityRetrievalStatement;
/*    */   }
/*    */ 
/*    */   public String getIdentityRetrievalStatement() {
/* 45 */     return this.identityRetrievalStatement;
/*    */   }
/*    */ 
/*    */   public static DatabaseDialects getDatabaseDialect(String database)
/*    */   {
/* 55 */     DatabaseDialects returnValue = null;
/*    */ 
/* 57 */     if ("DB2".equalsIgnoreCase(database))
/* 58 */       returnValue = DB2;
/* 59 */     else if ("MySQL".equalsIgnoreCase(database))
/* 60 */       returnValue = MYSQL;
/* 61 */     else if ("SqlServer".equalsIgnoreCase(database))
/* 62 */       returnValue = SQLSERVER;
/* 63 */     else if ("Cloudscape".equalsIgnoreCase(database))
/* 64 */       returnValue = CLOUDSCAPE;
/* 65 */     else if ("Derby".equalsIgnoreCase(database))
/* 66 */       returnValue = DERBY;
/* 67 */     else if ("HSQLDB".equalsIgnoreCase(database))
/* 68 */       returnValue = HSQLDB;
/* 69 */     else if ("SYBASE".equalsIgnoreCase(database))
/* 70 */       returnValue = SYBASE;
/* 71 */     else if ("DB2_MF".equalsIgnoreCase(database))
/* 72 */       returnValue = DB2_MF;
/* 73 */     else if ("Informix".equalsIgnoreCase(database)) {
/* 74 */       returnValue = INFORMIX;
/*    */     }
/*    */ 
/* 77 */     return returnValue;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.db.DatabaseDialects
 * JD-Core Version:    0.6.0
 */