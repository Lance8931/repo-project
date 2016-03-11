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
/*     */ public class InsertSelectiveMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  43 */     Set importedTypes = new TreeSet();
/*  44 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  46 */     FullyQualifiedJavaType returnType = method.getReturnType();
/*  47 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  49 */     if (returnType != null) {
/*  50 */       sb.append("Object newKey = ");
/*     */     }
/*     */ 
/*  53 */     sb.append(this.daoTemplate.getInsertMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getInsertSelectiveStatementId(), "record"));
/*     */ 
/*  56 */     method.addBodyLine(sb.toString());
/*     */ 
/*  58 */     if (returnType != null) {
/*  59 */       if ("Object".equals(returnType.getShortName()))
/*     */       {
/*  61 */         method.addBodyLine("return newKey;");
/*     */       } else {
/*  63 */         sb.setLength(0);
/*     */ 
/*  65 */         if (returnType.isPrimitive()) {
/*  66 */           PrimitiveTypeWrapper ptw = returnType.getPrimitiveTypeWrapper();
/*     */ 
/*  68 */           sb.append("return ((");
/*  69 */           sb.append(ptw.getShortName());
/*  70 */           sb.append(") newKey");
/*  71 */           sb.append(").");
/*  72 */           sb.append(ptw.getToPrimitiveMethod());
/*  73 */           sb.append(';');
/*     */         } else {
/*  75 */           sb.append("return (");
/*  76 */           sb.append(returnType.getShortName());
/*  77 */           sb.append(") newKey;");
/*     */         }
/*     */ 
/*  80 */         method.addBodyLine(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/*  84 */     if (this.context.getPlugins().clientInsertSelectiveMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  86 */       topLevelClass.addImportedTypes(importedTypes);
/*  87 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  93 */     Set importedTypes = new TreeSet();
/*  94 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  96 */     if (this.context.getPlugins().clientInsertSelectiveMethodGenerated(method, interfaze, this.introspectedTable))
/*     */     {
/*  98 */       interfaze.addImportedTypes(importedTypes);
/*  99 */       interfaze.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/* 104 */     Method method = new Method();
/*     */     FullyQualifiedJavaType returnType;
/* 107 */     if (this.introspectedTable.getGeneratedKey() != null) {
/* 108 */       IntrospectedColumn introspectedColumn = this.introspectedTable.getColumn(this.introspectedTable.getGeneratedKey().getColumn());
/* 110 */       if (introspectedColumn == null)
/*     */       {
/* 114 */         returnType = null;
/*     */       } else {
/* 116 */         returnType = introspectedColumn.getFullyQualifiedJavaType();
/* 117 */         importedTypes.add(returnType);
/*     */       }
/*     */     } else {
/* 120 */       returnType = null;
/*     */     }
/* 122 */     method.setReturnType(returnType);
/* 123 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 124 */     method.setName(getDAOMethodNameCalculator().getInsertSelectiveMethodName(this.introspectedTable));
/*     */ 
/* 127 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*     */ 
/* 130 */     importedTypes.add(parameterType);
/* 131 */     method.addParameter(new Parameter(parameterType, "record"));
/*     */ 
/* 133 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 134 */       method.addException(fqjt);
/* 135 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 138 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 141 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.InsertSelectiveMethodGenerator
 * JD-Core Version:    0.6.0
 */