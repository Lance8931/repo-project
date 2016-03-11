/*     */ package org.mybatis.generator.codegen.ibatis2.dao.templates;
/*     */ 
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ 
/*     */ public class GenericSIDAOTemplate extends AbstractDAOTemplate
/*     */ {
/*  29 */   private FullyQualifiedJavaType sqlMapClientType = new FullyQualifiedJavaType("com.ibatis.sqlmap.client.SqlMapClient");
/*     */ 
/*     */   protected void configureCheckedExceptions()
/*     */   {
/*  41 */     addCheckedException(new FullyQualifiedJavaType("java.sql.SQLException"));
/*     */   }
/*     */ 
/*     */   protected void configureConstructorTemplate()
/*     */   {
/*  46 */     Method method = new Method();
/*  47 */     method.setConstructor(true);
/*  48 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  49 */     method.addBodyLine("super();");
/*  50 */     setConstructorTemplate(method);
/*     */   }
/*     */ 
/*     */   protected void configureDeleteMethodTemplate()
/*     */   {
/*  55 */     setDeleteMethodTemplate("sqlMapClient.delete(\"{0}.{1}\", {2});");
/*     */   }
/*     */ 
/*     */   protected void configureFields()
/*     */   {
/*  60 */     Field field = new Field();
/*  61 */     field.setVisibility(JavaVisibility.PRIVATE);
/*  62 */     field.setType(this.sqlMapClientType);
/*  63 */     field.setName("sqlMapClient");
/*  64 */     addField(field);
/*     */   }
/*     */ 
/*     */   protected void configureImplementationImports()
/*     */   {
/*  69 */     addImplementationImport(this.sqlMapClientType);
/*     */   }
/*     */ 
/*     */   protected void configureInsertMethodTemplate()
/*     */   {
/*  74 */     setInsertMethodTemplate("sqlMapClient.insert(\"{0}.{1}\", {2});");
/*     */   }
/*     */ 
/*     */   protected void configureMethods()
/*     */   {
/*  79 */     Method method = new Method();
/*  80 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  81 */     method.setName("setSqlMapClient");
/*  82 */     method.addParameter(new Parameter(this.sqlMapClientType, "sqlMapClient"));
/*  83 */     method.addBodyLine("this.sqlMapClient = sqlMapClient;");
/*  84 */     addMethod(method);
/*     */ 
/*  86 */     method = new Method();
/*  87 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  88 */     method.setName("getSqlMapClient");
/*  89 */     method.setReturnType(this.sqlMapClientType);
/*  90 */     method.addBodyLine("return sqlMapClient;");
/*  91 */     addMethod(method);
/*     */   }
/*     */ 
/*     */   protected void configureQueryForListMethodTemplate()
/*     */   {
/*  96 */     setQueryForListMethodTemplate("sqlMapClient.queryForList(\"{0}.{1}\", {2});");
/*     */   }
/*     */ 
/*     */   protected void configureQueryForObjectMethodTemplate()
/*     */   {
/* 101 */     setQueryForObjectMethodTemplate("sqlMapClient.queryForObject(\"{0}.{1}\", {2});");
/*     */   }
/*     */ 
/*     */   protected void configureUpdateMethodTemplate()
/*     */   {
/* 106 */     setUpdateMethodTemplate("sqlMapClient.update(\"{0}.{1}\", {2});");
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.templates.GenericSIDAOTemplate
 * JD-Core Version:    0.6.0
 */