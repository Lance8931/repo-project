/*     */ package org.mybatis.generator.codegen;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public abstract class AbstractJavaGenerator extends AbstractGenerator
/*     */ {
/*     */   public abstract List<CompilationUnit> getCompilationUnits();
/*     */ 
/*     */   public static Method getGetter(Field field)
/*     */   {
/*  41 */     Method method = new Method();
/*  42 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*     */ 
/*  44 */     method.setReturnType(field.getType());
/*  45 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  46 */     StringBuilder sb = new StringBuilder();
/*  47 */     sb.append("return ");
/*  48 */     sb.append(field.getName());
/*  49 */     sb.append(';');
/*  50 */     method.addBodyLine(sb.toString());
/*  51 */     return method;
/*     */   }
/*     */ 
/*     */   public Method getJavaBeansGetter(IntrospectedColumn introspectedColumn) {
/*  55 */     FullyQualifiedJavaType fqjt = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/*  57 */     String property = introspectedColumn.getJavaProperty();
/*     */ 
/*  59 */     Method method = new Method();
/*  60 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  61 */     method.setReturnType(fqjt);
/*  62 */     method.setName(JavaBeansUtil.getGetterMethodName(property, fqjt));
/*  63 */     this.context.getCommentGenerator().addGetterComment(method, this.introspectedTable, introspectedColumn);
/*     */ 
/*  66 */     StringBuilder sb = new StringBuilder();
/*  67 */     sb.append("return ");
/*  68 */     sb.append(property);
/*  69 */     sb.append(';');
/*  70 */     method.addBodyLine(sb.toString());
/*     */ 
/*  72 */     return method;
/*     */   }
/*     */ 
/*     */   public Field getJavaBeansField(IntrospectedColumn introspectedColumn) {
/*  76 */     FullyQualifiedJavaType fqjt = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/*  78 */     String property = introspectedColumn.getJavaProperty();
/*     */ 
/*  80 */     Field field = new Field();
/*  81 */     field.setVisibility(JavaVisibility.PRIVATE);
/*  82 */     field.setType(fqjt);
/*  83 */     field.setName(property);
/*  84 */     this.context.getCommentGenerator().addFieldComment(field, this.introspectedTable, introspectedColumn);
/*     */ 
/*  87 */     return field;
/*     */   }
/*     */ 
/*     */   public Method getJavaBeansSetter(IntrospectedColumn introspectedColumn) {
/*  91 */     FullyQualifiedJavaType fqjt = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/*  93 */     String property = introspectedColumn.getJavaProperty();
/*     */ 
/*  95 */     Method method = new Method();
/*  96 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  97 */     method.setName(JavaBeansUtil.getSetterMethodName(property));
/*  98 */     method.addParameter(new Parameter(fqjt, property));
/*  99 */     this.context.getCommentGenerator().addSetterComment(method, this.introspectedTable, introspectedColumn);
/*     */ 
/* 102 */     StringBuilder sb = new StringBuilder();
/* 103 */     if ((isTrimStringsEnabled()) && (introspectedColumn.isStringColumn())) {
/* 104 */       sb.append("this.");
/* 105 */       sb.append(property);
/* 106 */       sb.append(" = ");
/* 107 */       sb.append(property);
/* 108 */       sb.append(" == null ? null : ");
/* 109 */       sb.append(property);
/* 110 */       sb.append(".trim();");
/* 111 */       method.addBodyLine(sb.toString());
/*     */     } else {
/* 113 */       sb.append("this.");
/* 114 */       sb.append(property);
/* 115 */       sb.append(" = ");
/* 116 */       sb.append(property);
/* 117 */       sb.append(';');
/* 118 */       method.addBodyLine(sb.toString());
/*     */     }
/*     */ 
/* 121 */     return method;
/*     */   }
/*     */ 
/*     */   public boolean isTrimStringsEnabled() {
/* 125 */     Properties properties = this.context.getJavaModelGeneratorConfiguration().getProperties();
/*     */ 
/* 127 */     boolean rc = StringUtility.isTrue(properties.getProperty("trimStrings"));
/*     */ 
/* 129 */     return rc;
/*     */   }
/*     */ 
/*     */   public String getRootClass() {
/* 133 */     String rootClass = this.introspectedTable.getTableConfigurationProperty("rootClass");
/*     */ 
/* 135 */     if (rootClass == null) {
/* 136 */       Properties properties = this.context.getJavaModelGeneratorConfiguration().getProperties();
/*     */ 
/* 138 */       rootClass = properties.getProperty("rootClass");
/*     */     }
/*     */ 
/* 141 */     return rootClass;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.AbstractJavaGenerator
 * JD-Core Version:    0.6.0
 */