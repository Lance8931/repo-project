/*     */ package org.mybatis.generator.codegen.ibatis2.dao.elements;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class InsertMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  44 */     Set importedTypes = new TreeSet();
/*  45 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  47 */     FullyQualifiedJavaType returnType = method.getReturnType();
/*     */ 
/*  49 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  51 */     if (returnType != null) {
/*  52 */       sb.append("Object newKey = ");
/*     */     }
/*     */ 
/*  55 */     sb.append(this.daoTemplate.getInsertMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getInsertStatementId(), "record"));
/*     */ 
/*  58 */     method.addBodyLine(sb.toString());
/*     */ 
/*  60 */     if (returnType != null) {
/*  61 */       if ("Object".equals(returnType.getShortName()))
/*     */       {
/*  63 */         method.addBodyLine("return newKey;");
/*     */       } else {
/*  65 */         sb.setLength(0);
/*     */ 
/*  67 */         if (returnType.isPrimitive()) {
/*  68 */           PrimitiveTypeWrapper ptw = returnType.getPrimitiveTypeWrapper();
/*     */ 
/*  70 */           sb.append("return ((");
/*  71 */           sb.append(ptw.getShortName());
/*  72 */           sb.append(") newKey");
/*  73 */           sb.append(").");
/*  74 */           sb.append(ptw.getToPrimitiveMethod());
/*  75 */           sb.append(';');
/*     */         } else {
/*  77 */           sb.append("return (");
/*  78 */           sb.append(returnType.getShortName());
/*  79 */           sb.append(") newKey;");
/*     */         }
/*     */ 
/*  82 */         method.addBodyLine(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/*  86 */     if (this.context.getPlugins().clientInsertMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  88 */       topLevelClass.addImportedTypes(importedTypes);
/*  89 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  95 */     Set importedTypes = new TreeSet();
/*  96 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  98 */     if (this.context.getPlugins().clientInsertMethodGenerated(method, interfaze, this.introspectedTable))
/*     */     {
/* 100 */       interfaze.addImportedTypes(importedTypes);
/* 101 */       interfaze.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/* 106 */     Method method = new Method();
/*     */     FullyQualifiedJavaType returnType;
/* 109 */     if (this.introspectedTable.getGeneratedKey() != null) {
/* 110 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(this.introspectedTable.getGeneratedKey().getColumn());
/* 112 */       if (introspectedColumn == null)
/*     */       {
/* 116 */         returnType = null;
/*     */       } else {
/* 118 */         returnType = introspectedColumn.getFullyQualifiedJavaType();
/* 119 */         importedTypes.add(returnType);
/*     */       }
/*     */     } else {
/* 122 */       returnType = null;
/*     */     }
/*     */ 
/* 125 */     method.setReturnType(returnType);
/* 126 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 127 */     DAOMethodNameCalculator methodNameCalculator = getDAOMethodNameCalculator();
/* 128 */     method.setName(methodNameCalculator.getInsertMethodName(this.introspectedTable));
/*     */ 
/* 131 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*     */ 
/* 134 */     importedTypes.add(parameterType);
/* 135 */     method.addParameter(new Parameter(parameterType, "record"));
/*     */ 
/* 137 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 138 */       method.addException(fqjt);
/* 139 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 142 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 145 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.InsertMethodGenerator
 * JD-Core Version:    0.6.0
 */