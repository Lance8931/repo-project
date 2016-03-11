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
/*     */ public class UpdateByExampleSelectiveMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  38 */     Set importedTypes = new TreeSet();
/*  39 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  41 */     method.addBodyLine("UpdateByExampleParms parms = new UpdateByExampleParms(record, example);");
/*     */ 
/*  44 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  46 */     sb.append("int rows = ");
/*     */ 
/*  48 */     sb.append(this.daoTemplate.getUpdateMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getUpdateByExampleSelectiveStatementId(), "parms"));
/*     */ 
/*  51 */     method.addBodyLine(sb.toString());
/*     */ 
/*  53 */     method.addBodyLine("return rows;");
/*     */ 
/*  55 */     if (this.context.getPlugins().clientUpdateByExampleSelectiveMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  58 */       topLevelClass.addImportedTypes(importedTypes);
/*  59 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  65 */     if (getExampleMethodVisibility() == JavaVisibility.PUBLIC) {
/*  66 */       Set importedTypes = new TreeSet();
/*  67 */       Method method = getMethodShell(importedTypes);
/*     */ 
/*  69 */       if (this.context.getPlugins().clientUpdateByExampleSelectiveMethodGenerated(method, interfaze, this.introspectedTable))
/*     */       {
/*  72 */         interfaze.addImportedTypes(importedTypes);
/*  73 */         interfaze.addMethod(method);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes)
/*     */   {
/*     */     FullyQualifiedJavaType parameterType;
/*  81 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  82 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*     */     }
/*     */     else
/*     */     {
/*  84 */       if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/*  85 */         parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */       }
/*     */       else {
/*  88 */         parameterType = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*     */       }
/*     */     }
/*     */ 
/*  92 */     importedTypes.add(parameterType);
/*     */ 
/*  94 */     Method method = new Method();
/*  95 */     method.setVisibility(getExampleMethodVisibility());
/*  96 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/*  97 */     method.setName(getDAOMethodNameCalculator().getUpdateByExampleSelectiveMethodName(this.introspectedTable));
/*     */ 
/*  99 */     method.addParameter(new Parameter(parameterType, "record"));
/* 100 */     method.addParameter(new Parameter(new FullyQualifiedJavaType(this.introspectedTable.getExampleType()), "example"));
/*     */ 
/* 103 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 104 */       method.addException(fqjt);
/* 105 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 108 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 111 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleSelectiveMethodGenerator
 * JD-Core Version:    0.6.0
 */