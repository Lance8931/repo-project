/*    */ package org.mybatis.generator.codegen.ibatis2.dao.templates;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ 
/*    */ public class IbatisDAOTemplate extends AbstractDAOTemplate
/*    */ {
/* 28 */   private FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("com.ibatis.dao.client.DaoManager");
/*    */ 
/*    */   protected void configureConstructorTemplate()
/*    */   {
/* 40 */     Method method = new Method();
/* 41 */     method.setConstructor(true);
/* 42 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 43 */     method.addParameter(new Parameter(this.fqjt, "daoManager"));
/* 44 */     method.addBodyLine("super(daoManager);");
/* 45 */     setConstructorTemplate(method);
/*    */   }
/*    */ 
/*    */   protected void configureDeleteMethodTemplate()
/*    */   {
/* 50 */     setDeleteMethodTemplate("delete(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureImplementationImports()
/*    */   {
/* 55 */     addImplementationImport(this.fqjt);
/*    */   }
/*    */ 
/*    */   protected void configureInsertMethodTemplate()
/*    */   {
/* 60 */     setInsertMethodTemplate("insert(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureQueryForListMethodTemplate()
/*    */   {
/* 65 */     setQueryForListMethodTemplate("queryForList(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureQueryForObjectMethodTemplate()
/*    */   {
/* 70 */     setQueryForObjectMethodTemplate("queryForObject(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureSuperClass()
/*    */   {
/* 75 */     setSuperClass(new FullyQualifiedJavaType("com.ibatis.dao.client.template.SqlMapDaoTemplate"));
/*    */   }
/*    */ 
/*    */   protected void configureUpdateMethodTemplate()
/*    */   {
/* 81 */     setUpdateMethodTemplate("update(\"{0}.{1}\", {2});");
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.templates.IbatisDAOTemplate
 * JD-Core Version:    0.6.0
 */