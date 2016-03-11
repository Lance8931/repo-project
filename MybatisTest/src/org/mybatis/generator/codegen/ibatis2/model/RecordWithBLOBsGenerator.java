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
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.RootClassInfo;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class RecordWithBLOBsGenerator extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  47 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  48 */     this.progressCallback.startTask(Messages.getString("Progress.9", table.toString()));
/*     */ 
/*  50 */     Plugin plugins = this.context.getPlugins();
/*  51 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */ 
/*  53 */     TopLevelClass topLevelClass = new TopLevelClass(this.introspectedTable.getRecordWithBLOBsType());
/*     */ 
/*  55 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  56 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */ 
/*  58 */     if (this.introspectedTable.getRules().generateBaseRecordClass())
/*  59 */       topLevelClass.setSuperClass(this.introspectedTable.getBaseRecordType());
/*     */     else {
/*  61 */       topLevelClass.setSuperClass(this.introspectedTable.getPrimaryKeyType());
/*     */     }
/*     */ 
/*  64 */     String rootClass = getRootClass();
/*  65 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getBLOBColumns())
/*     */     {
/*  67 */       if (RootClassInfo.getInstance(rootClass, this.warnings).containsProperty(introspectedColumn))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  72 */       Field field = getJavaBeansField(introspectedColumn);
/*  73 */       if (plugins.modelFieldGenerated(field, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.RECORD_WITH_BLOBS))
/*     */       {
/*  76 */         topLevelClass.addField(field);
/*  77 */         topLevelClass.addImportedType(field.getType());
/*     */       }
/*     */ 
/*  80 */       Method method = getJavaBeansGetter(introspectedColumn);
/*  81 */       if (plugins.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.RECORD_WITH_BLOBS))
/*     */       {
/*  84 */         topLevelClass.addMethod(method);
/*     */       }
/*     */ 
/*  87 */       method = getJavaBeansSetter(introspectedColumn);
/*  88 */       if (plugins.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.RECORD_WITH_BLOBS))
/*     */       {
/*  91 */         topLevelClass.addMethod(method);
/*     */       }
/*     */     }
/*     */ 
/*  95 */     List answer = new ArrayList();
/*  96 */     if (this.context.getPlugins().modelRecordWithBLOBsClassGenerated(topLevelClass, this.introspectedTable))
/*     */     {
/*  98 */       answer.add(topLevelClass);
/*     */     }
/* 100 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.model.RecordWithBLOBsGenerator
 * JD-Core Version:    0.6.0
 */