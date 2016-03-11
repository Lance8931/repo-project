/*     */ package org.mybatis.generator.codegen.ibatis2.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.Plugin.ModelClassType;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.RootClassInfo;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class BaseRecordGenerator extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  48 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  49 */     this.progressCallback.startTask(Messages.getString("Progress.8", table.toString()));
/*     */ 
/*  51 */     Plugin plugins = this.context.getPlugins();
/*  52 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */ 
/*  54 */     TopLevelClass topLevelClass = new TopLevelClass(this.introspectedTable.getBaseRecordType());
/*     */ 
/*  56 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  57 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */ 
/*  59 */     FullyQualifiedJavaType superClass = getSuperClass();
/*  60 */     if (superClass != null) {
/*  61 */       topLevelClass.setSuperClass(superClass);
/*  62 */       topLevelClass.addImportedType(superClass);
/*     */     }
/*     */     List<IntrospectedColumn> introspectedColumns;
/*  66 */     if (includePrimaryKeyColumns())
/*     */     {
/*  67 */       if (includeBLOBColumns())
/*  68 */         introspectedColumns = this.introspectedTable.getAllColumns();
/*     */       else
/*  70 */         introspectedColumns = this.introspectedTable.getNonBLOBColumns();
/*     */     }
/*     */     else
/*     */     {
/*  73 */       if (includeBLOBColumns()) {
/*  74 */         introspectedColumns = this.introspectedTable.getNonPrimaryKeyColumns();
/*     */       }
/*     */       else {
/*  77 */         introspectedColumns = this.introspectedTable.getBaseColumns();
/*     */       }
/*     */     }
/*     */ 
/*  81 */     String rootClass = getRootClass();
/*  82 */     for (IntrospectedColumn introspectedColumn : introspectedColumns) {
/*  83 */       if (RootClassInfo.getInstance(rootClass, this.warnings).containsProperty(introspectedColumn))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  88 */       Field field = getJavaBeansField(introspectedColumn);
/*  89 */       if (plugins.modelFieldGenerated(field, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.BASE_RECORD))
/*     */       {
/*  92 */         topLevelClass.addField(field);
/*  93 */         topLevelClass.addImportedType(field.getType());
/*     */       }
/*     */ 
/*  96 */       Method method = getJavaBeansGetter(introspectedColumn);
/*  97 */       if (plugins.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.BASE_RECORD))
/*     */       {
/* 100 */         topLevelClass.addMethod(method);
/*     */       }
/*     */ 
/* 103 */       method = getJavaBeansSetter(introspectedColumn);
/* 104 */       if (plugins.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.BASE_RECORD))
/*     */       {
/* 107 */         topLevelClass.addMethod(method);
/*     */       }
/*     */     }
/*     */ 
/* 111 */     List answer = new ArrayList();
/* 112 */     if (this.context.getPlugins().modelBaseRecordClassGenerated(topLevelClass, this.introspectedTable))
/*     */     {
/* 114 */       answer.add(topLevelClass);
/*     */     }
/* 116 */     return answer;
/*     */   }
/*     */ 
/*     */   private FullyQualifiedJavaType getSuperClass()
/*     */   {
/*     */     FullyQualifiedJavaType superClass;
/* 121 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 122 */       superClass = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*     */     }
/*     */     else {
/* 125 */       String rootClass = getRootClass();
/* 126 */       if (rootClass != null)
/* 127 */         superClass = new FullyQualifiedJavaType(rootClass);
/*     */       else {
/* 129 */         superClass = null;
/*     */       }
/*     */     }
/*     */ 
/* 133 */     return superClass;
/*     */   }
/*     */ 
/*     */   private boolean includePrimaryKeyColumns() {
/* 137 */     return (!this.introspectedTable.getRules().generatePrimaryKeyClass()) && (this.introspectedTable.hasPrimaryKeyColumns());
/*     */   }
/*     */ 
/*     */   private boolean includeBLOBColumns()
/*     */   {
/* 142 */     return (!this.introspectedTable.getRules().generateRecordWithBLOBsClass()) && (this.introspectedTable.hasBLOBColumns());
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.model.BaseRecordGenerator
 * JD-Core Version:    0.6.0
 */