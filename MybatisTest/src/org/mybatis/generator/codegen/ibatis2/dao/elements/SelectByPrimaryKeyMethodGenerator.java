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
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*     */ 
/*     */ public class SelectByPrimaryKeyMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  44 */     Set importedTypes = new TreeSet();
/*  45 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  48 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  50 */     if (!this.introspectedTable.getRules().generatePrimaryKeyClass())
/*     */     {
/*  53 */       FullyQualifiedJavaType keyType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */ 
/*  55 */       topLevelClass.addImportedType(keyType);
/*     */ 
/*  57 */       sb.setLength(0);
/*  58 */       sb.append(keyType.getShortName());
/*  59 */       sb.append(" _key = new ");
/*  60 */       sb.append(keyType.getShortName());
/*  61 */       sb.append("();");
/*  62 */       method.addBodyLine(sb.toString());
/*     */ 
/*  64 */       for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */       {
/*  66 */         sb.setLength(0);
/*  67 */         sb.append("_key.");
/*  68 */         sb.append(JavaBeansUtil.getSetterMethodName(introspectedColumn.getJavaProperty()));
/*     */ 
/*  70 */         sb.append('(');
/*  71 */         sb.append(introspectedColumn.getJavaProperty());
/*  72 */         sb.append(");");
/*  73 */         method.addBodyLine(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/*  77 */     FullyQualifiedJavaType returnType = method.getReturnType();
/*     */ 
/*  79 */     sb.setLength(0);
/*  80 */     sb.append(returnType.getShortName());
/*  81 */     sb.append(" record = (");
/*  82 */     sb.append(returnType.getShortName());
/*  83 */     sb.append(") ");
/*  84 */     sb.append(this.daoTemplate.getQueryForObjectMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getSelectByPrimaryKeyStatementId(), "_key"));
/*     */ 
/*  87 */     method.addBodyLine(sb.toString());
/*  88 */     method.addBodyLine("return record;");
/*     */ 
/*  90 */     if (this.context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  92 */       topLevelClass.addImportedTypes(importedTypes);
/*  93 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  99 */     Set importedTypes = new TreeSet();
/* 100 */     Method method = getMethodShell(importedTypes);
/*     */ 
/* 102 */     if (this.context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze, this.introspectedTable))
/*     */     {
/* 104 */       interfaze.addImportedTypes(importedTypes);
/* 105 */       interfaze.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/* 110 */     Method method = new Method();
/* 111 */     method.setVisibility(JavaVisibility.PUBLIC);
/*     */ 
/* 113 */     FullyQualifiedJavaType returnType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*     */ 
/* 115 */     method.setReturnType(returnType);
/* 116 */     importedTypes.add(returnType);
/*     */ 
/* 118 */     method.setName(getDAOMethodNameCalculator().getSelectByPrimaryKeyMethodName(this.introspectedTable));
/*     */ 
/* 121 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 122 */       FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*     */ 
/* 124 */       importedTypes.add(type);
/* 125 */       method.addParameter(new Parameter(type, "_key"));
/*     */     } else {
/* 127 */       for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */       {
/* 129 */         FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/* 131 */         importedTypes.add(type);
/* 132 */         method.addParameter(new Parameter(type, introspectedColumn.getJavaProperty()));
/*     */       }
/*     */ 
/*     */     }
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
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.SelectByPrimaryKeyMethodGenerator
 * JD-Core Version:    0.6.0
 */