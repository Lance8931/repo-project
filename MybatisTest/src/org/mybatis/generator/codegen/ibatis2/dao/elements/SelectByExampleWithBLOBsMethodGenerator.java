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
/*     */ public class SelectByExampleWithBLOBsMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   private boolean generateForJava5;
/*     */ 
/*     */   public SelectByExampleWithBLOBsMethodGenerator(boolean generateForJava5)
/*     */   {
/*  40 */     this.generateForJava5 = generateForJava5;
/*     */   }
/*     */ 
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  45 */     Set importedTypes = new TreeSet();
/*  46 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  48 */     if (this.generateForJava5) {
/*  49 */       method.addSuppressTypeWarningsAnnotation();
/*     */     }
/*     */ 
/*  52 */     StringBuilder sb = new StringBuilder();
/*  53 */     sb.append(method.getReturnType().getShortName());
/*  54 */     sb.append(" list = ");
/*  55 */     sb.append(this.daoTemplate.getQueryForListMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getSelectByExampleWithBLOBsStatementId(), "example"));
/*     */ 
/*  58 */     method.addBodyLine(sb.toString());
/*  59 */     method.addBodyLine("return list;");
/*     */ 
/*  61 */     if (this.context.getPlugins().clientSelectByExampleWithBLOBsMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  64 */       topLevelClass.addImportedTypes(importedTypes);
/*  65 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  71 */     if (getExampleMethodVisibility() == JavaVisibility.PUBLIC) {
/*  72 */       Set importedTypes = new TreeSet();
/*  73 */       Method method = getMethodShell(importedTypes);
/*     */ 
/*  75 */       if (this.context.getPlugins().clientSelectByExampleWithBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*     */       {
/*  78 */         interfaze.addImportedTypes(importedTypes);
/*  79 */         interfaze.addMethod(method);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/*  85 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*     */ 
/*  87 */     importedTypes.add(type);
/*  88 */     importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
/*     */ 
/*  90 */     Method method = new Method();
/*  91 */     method.setVisibility(getExampleMethodVisibility());
/*     */ 
/*  93 */     FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
/*     */ 
/*  95 */     if (this.generateForJava5)
/*     */     {
/*     */       FullyQualifiedJavaType fqjt;
/*  97 */       if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/*  98 */         fqjt = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*     */       }
/*     */       else
/*     */       {
/* 102 */         fqjt = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */       }
/*     */ 
/* 106 */       importedTypes.add(fqjt);
/* 107 */       returnType.addTypeArgument(fqjt);
/*     */     }
/* 109 */     method.setReturnType(returnType);
/*     */ 
/* 111 */     method.setName(getDAOMethodNameCalculator().getSelectByExampleWithBLOBsMethodName(this.introspectedTable));
/*     */ 
/* 113 */     method.addParameter(new Parameter(type, "example"));
/*     */ 
/* 115 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 116 */       method.addException(fqjt);
/* 117 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 120 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 123 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.SelectByExampleWithBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */