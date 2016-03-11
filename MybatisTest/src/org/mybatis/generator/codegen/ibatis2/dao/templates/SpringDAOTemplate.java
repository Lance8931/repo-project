/*    */ package org.mybatis.generator.codegen.ibatis2.dao.templates;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ 
/*    */ public class SpringDAOTemplate extends AbstractDAOTemplate
/*    */ {
/*    */   protected void configureConstructorTemplate()
/*    */   {
/* 36 */     Method method = new Method();
/* 37 */     method.setConstructor(true);
/* 38 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 39 */     method.addBodyLine("super();");
/* 40 */     setConstructorTemplate(method);
/*    */   }
/*    */ 
/*    */   protected void configureDeleteMethodTemplate()
/*    */   {
/* 45 */     setDeleteMethodTemplate("getSqlMapClientTemplate().delete(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureInsertMethodTemplate()
/*    */   {
/* 50 */     setInsertMethodTemplate("getSqlMapClientTemplate().insert(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureQueryForListMethodTemplate()
/*    */   {
/* 55 */     setQueryForListMethodTemplate("getSqlMapClientTemplate().queryForList(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureQueryForObjectMethodTemplate()
/*    */   {
/* 60 */     setQueryForObjectMethodTemplate("getSqlMapClientTemplate().queryForObject(\"{0}.{1}\", {2});");
/*    */   }
/*    */ 
/*    */   protected void configureSuperClass()
/*    */   {
/* 65 */     setSuperClass(new FullyQualifiedJavaType("org.springframework.orm.ibatis.support.SqlMapClientDaoSupport"));
/*    */   }
/*    */ 
/*    */   protected void configureUpdateMethodTemplate()
/*    */   {
/* 71 */     setUpdateMethodTemplate("getSqlMapClientTemplate().update(\"{0}.{1}\", {2});");
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.templates.SpringDAOTemplate
 * JD-Core Version:    0.6.0
 */