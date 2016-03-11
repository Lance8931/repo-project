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
/*     */ public class DeleteByPrimaryKeyMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  44 */     Set importedTypes = new TreeSet();
/*  45 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  47 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  49 */     if (!this.introspectedTable.getRules().generatePrimaryKeyClass())
/*     */     {
/*  52 */       FullyQualifiedJavaType keyType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */ 
/*  54 */       topLevelClass.addImportedType(keyType);
/*     */ 
/*  56 */       sb.setLength(0);
/*  57 */       sb.append(keyType.getShortName());
/*  58 */       sb.append(" _key = new ");
/*  59 */       sb.append(keyType.getShortName());
/*  60 */       sb.append("();");
/*  61 */       method.addBodyLine(sb.toString());
/*     */ 
/*  63 */       for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */       {
/*  65 */         sb.setLength(0);
/*  66 */         sb.append("_key.");
/*  67 */         sb.append(JavaBeansUtil.getSetterMethodName(introspectedColumn.getJavaProperty()));
/*     */ 
/*  69 */         sb.append('(');
/*  70 */         sb.append(introspectedColumn.getJavaProperty());
/*  71 */         sb.append(");");
/*  72 */         method.addBodyLine(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/*  76 */     sb.setLength(0);
/*  77 */     sb.append("int rows = ");
/*  78 */     sb.append(this.daoTemplate.getDeleteMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getDeleteByPrimaryKeyStatementId(), "_key"));
/*     */ 
/*  81 */     method.addBodyLine(sb.toString());
/*  82 */     method.addBodyLine("return rows;");
/*     */ 
/*  84 */     if (this.context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(method, topLevelClass, this.introspectedTable))
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
/*  96 */     if (this.context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, this.introspectedTable))
/*     */     {
/*  98 */       interfaze.addImportedTypes(importedTypes);
/*  99 */       interfaze.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/* 104 */     Method method = new Method();
/* 105 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 106 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 107 */     method.setName(getDAOMethodNameCalculator().getDeleteByPrimaryKeyMethodName(this.introspectedTable));
/*     */ 
/* 110 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 111 */       FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*     */ 
/* 113 */       importedTypes.add(type);
/* 114 */       method.addParameter(new Parameter(type, "_key"));
/*     */     } else {
/* 116 */       for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */       {
/* 118 */         FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/* 120 */         importedTypes.add(type);
/* 121 */         method.addParameter(new Parameter(type, introspectedColumn.getJavaProperty()));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 126 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 127 */       method.addException(fqjt);
/* 128 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 131 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 134 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.DeleteByPrimaryKeyMethodGenerator
 * JD-Core Version:    0.6.0
 */