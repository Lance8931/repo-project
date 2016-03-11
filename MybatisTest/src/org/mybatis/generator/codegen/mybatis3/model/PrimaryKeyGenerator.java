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
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class PrimaryKeyGenerator extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  48 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  49 */     this.progressCallback.startTask(Messages.getString("Progress.7", table.toString()));
/*     */ 
/*  51 */     Plugin plugins = this.context.getPlugins();
/*  52 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */ 
/*  54 */     TopLevelClass topLevelClass = new TopLevelClass(this.introspectedTable.getPrimaryKeyType());
/*     */ 
/*  56 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  57 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */ 
/*  59 */     String rootClass = getRootClass();
/*  60 */     if (rootClass != null) {
/*  61 */       topLevelClass.setSuperClass(new FullyQualifiedJavaType(rootClass));
/*  62 */       topLevelClass.addImportedType(topLevelClass.getSuperClass());
/*     */     }
/*     */ 
/*  65 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*     */     {
/*  67 */       if (RootClassInfo.getInstance(rootClass, this.warnings).containsProperty(introspectedColumn))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  72 */       Field field = getJavaBeansField(introspectedColumn);
/*  73 */       if (plugins.modelFieldGenerated(field, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.PRIMARY_KEY))
/*     */       {
/*  76 */         topLevelClass.addField(field);
/*  77 */         topLevelClass.addImportedType(field.getType());
/*     */       }
/*     */ 
/*  80 */       Method method = getJavaBeansGetter(introspectedColumn);
/*  81 */       if (plugins.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.PRIMARY_KEY))
/*     */       {
/*  84 */         topLevelClass.addMethod(method);
/*     */       }
/*     */ 
/*  87 */       method = getJavaBeansSetter(introspectedColumn);
/*  88 */       if (plugins.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, this.introspectedTable, Plugin.ModelClassType.PRIMARY_KEY))
/*     */       {
/*  91 */         topLevelClass.addMethod(method);
/*     */       }
/*     */     }
/*     */ 
/*  95 */     List answer = new ArrayList();
/*  96 */     if (this.context.getPlugins().modelPrimaryKeyClassGenerated(topLevelClass, this.introspectedTable))
/*     */     {
/*  98 */       answer.add(topLevelClass);
/*     */     }
/* 100 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.model.PrimaryKeyGenerator
 * JD-Core Version:    0.6.0
 */