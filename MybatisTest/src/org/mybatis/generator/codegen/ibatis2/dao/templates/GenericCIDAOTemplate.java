/*    */ package org.mybatis.generator.codegen.ibatis2.dao.templates;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.java.Field;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ 
/*    */ public class GenericCIDAOTemplate extends AbstractDAOTemplate
/*    */ {
/* 29 */   private FullyQualifiedJavaType sqlMapClientType = new FullyQualifiedJavaType("com.ibatis.sqlmap.client.SqlMapClient");
/*    */ 
/*    */   protected void configureCheckedExceptions()
/*    */   {
/* 41 */     addCheckedException(new FullyQualifiedJavaType("java.sql.SQLException"));
/*    */   }
/*    */ 
/*    */   protected void configureConstructorTemplate()
/*    */   {
/* 46 */     Method constructor = new Method();
/* 47 */     constructor.setConstructor(true);
/* 48 */     constructor.setVisibility(JavaVisibility.PUBLIC);
/* 49 */     constructor.addParameter(new Parameter(this.sqlMapClientType, "sqlMapClient"));
/*    */ 
/* 51 */     constructor.addBodyLine("super();");
/* 52 */     constructor.addBodyLine("this.sqlMapClient = sqlMapClient;");
/* 53 */     setConstructorTemplate(constructor);
/*    */   }
/*    */ 
/*    */   protected void configureDeleteMethodTemplate()
/*    */   {
/* 58 */     setDeleteMethodTemplate("sqlMapClient.delete(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureFields()
/*    */   {
/* 63 */     Field field = new Field();
/* 64 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 65 */     field.setType(this.sqlMapClientType);
/* 66 */     field.setName("sqlMapClient");
/* 67 */     addField(field);
/*    */   }
/*    */ 
/*    */   protected void configureImplementationImports()
/*    */   {
/* 72 */     addImplementationImport(this.sqlMapClientType);
/*    */   }
/*    */ 
/*    */   protected void configureInsertMethodTemplate()
/*    */   {
/* 77 */     setInsertMethodTemplate("sqlMapClient.insert(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureQueryForListMethodTemplate()
/*    */   {
/* 82 */     setQueryForListMethodTemplate("sqlMapClient.queryForList(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureQueryForObjectMethodTemplate()
/*    */   {
/* 87 */     setQueryForObjectMethodTemplate("sqlMapClient.queryForObject(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureUpdateMethodTemplate()
/*    */   {
/* 92 */     setUpdateMethodTemplate("sqlMapClient.update(\"{0}.{1}\", {2});");
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.templates.GenericCIDAOTemplate
 * JD-Core Version:    0.6.0
 */