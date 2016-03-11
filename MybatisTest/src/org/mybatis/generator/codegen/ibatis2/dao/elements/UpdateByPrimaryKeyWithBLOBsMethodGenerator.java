/*     */ package org.mybatis.generator.codegen.ibatis2.dao.elements;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class UpdateByPrimaryKeyWithBLOBsMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  42 */     Set importedTypes = new TreeSet();
/*  43 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  45 */     StringBuilder sb = new StringBuilder();
/*  46 */     sb.append("int rows = ");
/*  47 */     sb.append(this.daoTemplate.getUpdateMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getUpdateByPrimaryKeyWithBLOBsStatementId(), "record"));
/*     */ 
/*  50 */     method.addBodyLine(sb.toString());
/*     */ 
/*  52 */     method.addBodyLine("return rows;");
/*     */ 
/*  54 */     if (this.context.getPlugins().clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  57 */       topLevelClass.addImportedTypes(importedTypes);
/*  58 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  64 */     Set importedTypes = new TreeSet();
/*  65 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  67 */     if (this.context.getPlugins().clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*     */     {
/*  70 */       interfaze.addImportedTypes(importedTypes);
/*  71 */       interfaze.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes)
/*     */   {
/*     */     FullyQualifiedJavaType parameterType;
/*  78 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  79 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*     */     }
/*     */     else {
/*  82 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */     }
/*     */ 
/*  86 */     importedTypes.add(parameterType);
/*     */ 
/*  88 */     Method method = new Method();
/*  89 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  90 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/*  91 */     method.setName(getDAOMethodNameCalculator().getUpdateByPrimaryKeyWithBLOBsMethodName(this.introspectedTable));
/*     */ 
/*  93 */     method.addParameter(new Parameter(parameterType, "record"));
/*     */ 
/*  95 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/*  96 */       method.addException(fqjt);
/*  97 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 100 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 103 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByPrimaryKeyWithBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */