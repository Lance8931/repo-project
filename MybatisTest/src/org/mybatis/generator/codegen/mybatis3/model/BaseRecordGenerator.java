/*     */ package org.mybatis.generator.codegen.mybatis3.model;
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
/*  54 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */ 
/*  56 */     TopLevelClass topLevelClass = new TopLevelClass(type);
/*  57 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  58 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */ 
/*  60 */     FullyQualifiedJavaType superClass = getSuperClass();
/*  61 */     if (superClass != null) {
/*  62 */       topLevelClass.setSuperClass(superClass);
/*  63 */       topLevelClass.addImportedType(superClass);
/*     */     }
/*     */     List<IntrospectedColumn> introspectedColumns;
/*  67 */     if (includePrimaryKeyColumns())
/*     */     {
/*  68 */       if (includeBLOBColumns())
/*  69 */         introspectedColumns = this.introspectedTable.getAllColumns();
/*     */       else
/*  71 */         introspectedColumns = this.introspectedTable.getNonBLOBColumns();
/*     */     }
/*     */     else
/*     */     {
/*  74 */       if (includeBLOBColumns()) {
/*  75 */         introspectedColumns = this.introspectedTable.getNonPrimaryKeyColumns();
/*     */       }
/*     */       else {
/*  78 */         introspectedColumns = this.introspectedTable.getBaseColumns();
/*     */       }
/*     */     }
/*     */ 
/*  82 */     String rootClass = getRootClass();
/*  83 */     for (IntrospectedColumn introspectedColumn : introspectedColumns) {
/*  84 */       if (RootClassInfo.getInstance(rootClass, this.warnings).containsProperty(introspectedColumn))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  89 */       Field field = getJavaBeansField(introspectedColumn);
/*  90 */       if (plugins.modelFieldGenerated(field, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.BASE_RECORD))
/*     */       {
/*  93 */         topLevelClass.addField(field);
/*  94 */         topLevelClass.addImportedType(field.getType());
/*     */       }
/*     */ 
/*  97 */       Method method = getJavaBeansGetter(introspectedColumn);
/*  98 */       if (plugins.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.BASE_RECORD))
/*     */       {
/* 101 */         topLevelClass.addMethod(method);
/*     */       }
/*     */ 
/* 104 */       method = getJavaBeansSetter(introspectedColumn);
/* 105 */       if (plugins.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.BASE_RECORD))
/*     */       {
/* 108 */         topLevelClass.addMethod(method);
/*     */       }
/*     */     }
/*     */ 
/* 112 */     List answer = new ArrayList();
/* 113 */     if (this.context.getPlugins().modelBaseRecordClassGenerated(topLevelClass, this.introspectedTable))
/*     */     {
/* 115 */       answer.add(topLevelClass);
/*     */     }
/* 117 */     return answer;
/*     */   }
/*     */ 
/*     */   private FullyQualifiedJavaType getSuperClass()
/*     */   {
/*     */     FullyQualifiedJavaType superClass;
/* 122 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 123 */       superClass = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*     */     }
/*     */     else {
/* 126 */       String rootClass = getRootClass();
/* 127 */       if (rootClass != null)
/* 128 */         superClass = new FullyQualifiedJavaType(rootClass);
/*     */       else {
/* 130 */         superClass = null;
/*     */       }
/*     */     }
/*     */ 
/* 134 */     return superClass;
/*     */   }
/*     */ 
/*     */   private boolean includePrimaryKeyColumns() {
/* 138 */     return (!this.introspectedTable.getRules().generatePrimaryKeyClass()) && (this.introspectedTable.hasPrimaryKeyColumns());
/*     */   }
/*     */ 
/*     */   private boolean includeBLOBColumns()
/*     */   {
/* 143 */     return (!this.introspectedTable.getRules().generateRecordWithBLOBsClass()) && (this.introspectedTable.hasBLOBColumns());
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.model.BaseRecordGenerator
 * JD-Core Version:    0.6.0
 */