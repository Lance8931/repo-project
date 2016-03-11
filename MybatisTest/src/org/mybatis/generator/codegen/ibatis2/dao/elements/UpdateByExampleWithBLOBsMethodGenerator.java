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
/*     */ public class UpdateByExampleWithBLOBsMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  42 */     Set importedTypes = new TreeSet();
/*  43 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  45 */     method.addBodyLine("UpdateByExampleParms parms = new UpdateByExampleParms(record, example);");
/*     */ 
/*  48 */     StringBuilder sb = new StringBuilder();
/*  49 */     sb.append("int rows = ");
/*  50 */     sb.append(this.daoTemplate.getUpdateMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getUpdateByExampleWithBLOBsStatementId(), "parms"));
/*     */ 
/*  53 */     method.addBodyLine(sb.toString());
/*     */ 
/*  55 */     method.addBodyLine("return rows;");
/*     */ 
/*  57 */     if (this.context.getPlugins().clientUpdateByExampleWithBLOBsMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  60 */       topLevelClass.addImportedTypes(importedTypes);
/*  61 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  67 */     if (getExampleMethodVisibility() == JavaVisibility.PUBLIC) {
/*  68 */       Set importedTypes = new TreeSet();
/*  69 */       Method method = getMethodShell(importedTypes);
/*     */ 
/*  71 */       if (this.context.getPlugins().clientUpdateByExampleWithBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*     */       {
/*  74 */         interfaze.addImportedTypes(importedTypes);
/*  75 */         interfaze.addMethod(method);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes)
/*     */   {
/*     */     FullyQualifiedJavaType parameterType;
/*  82 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  83 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*     */     }
/*     */     else {
/*  86 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */     }
/*     */ 
/*  90 */     importedTypes.add(parameterType);
/*     */ 
/*  92 */     Method method = new Method();
/*  93 */     method.setVisibility(getExampleMethodVisibility());
/*  94 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/*  95 */     method.setName(getDAOMethodNameCalculator().getUpdateByExampleWithBLOBsMethodName(this.introspectedTable));
/*     */ 
/*  97 */     method.addParameter(new Parameter(parameterType, "record"));
/*  98 */     method.addParameter(new Parameter(new FullyQualifiedJavaType(this.introspectedTable.getExampleType()), "example"));
/*     */ 
/* 101 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 102 */       method.addException(fqjt);
/* 103 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 106 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 109 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleWithBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */