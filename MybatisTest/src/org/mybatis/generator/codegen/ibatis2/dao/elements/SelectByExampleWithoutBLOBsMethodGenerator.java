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
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class SelectByExampleWithoutBLOBsMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   private boolean generateForJava5;
/*     */ 
/*     */   public SelectByExampleWithoutBLOBsMethodGenerator(boolean generateForJava5)
/*     */   {
/*  41 */     this.generateForJava5 = generateForJava5;
/*     */   }
/*     */ 
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  46 */     Set importedTypes = new TreeSet();
/*  47 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  49 */     if (this.generateForJava5) {
/*  50 */       method.addSuppressTypeWarningsAnnotation();
/*     */     }
/*     */ 
/*  53 */     StringBuilder sb = new StringBuilder();
/*  54 */     sb.append(method.getReturnType().getShortName());
/*  55 */     sb.append(" list = ");
/*  56 */     sb.append(this.daoTemplate.getQueryForListMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getSelectByExampleStatementId(), "example"));
/*     */ 
/*  59 */     method.addBodyLine(sb.toString());
/*  60 */     method.addBodyLine("return list;");
/*     */ 
/*  62 */     if (this.context.getPlugins().clientSelectByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  65 */       topLevelClass.addImportedTypes(importedTypes);
/*  66 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  72 */     if (getExampleMethodVisibility() == JavaVisibility.PUBLIC) {
/*  73 */       Set importedTypes = new TreeSet();
/*  74 */       Method method = getMethodShell(importedTypes);
/*     */ 
/*  76 */       if (this.context.getPlugins().clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*     */       {
/*  79 */         interfaze.addImportedTypes(importedTypes);
/*  80 */         interfaze.addMethod(method);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/*  86 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*     */ 
/*  88 */     importedTypes.add(type);
/*  89 */     importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
/*     */ 
/*  91 */     Method method = new Method();
/*  92 */     method.setVisibility(getExampleMethodVisibility());
/*     */ 
/*  94 */     FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
/*     */ 
/*  97 */     if (this.generateForJava5)
/*     */     {
/*     */       FullyQualifiedJavaType fqjt;
/*  99 */       if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/* 100 */         fqjt = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*     */       }
/*     */       else
/*     */       {
/* 102 */         if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 103 */           fqjt = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*     */         }
/*     */         else
/* 106 */           throw new RuntimeException(Messages.getString("RuntimeError.12"));
/*     */       }
/* 110 */       importedTypes.add(fqjt);
/* 111 */       returnType.addTypeArgument(fqjt);
/*     */     }
/*     */ 
/* 114 */     method.setReturnType(returnType);
/*     */ 
/* 116 */     method.setName(getDAOMethodNameCalculator().getSelectByExampleWithoutBLOBsMethodName(this.introspectedTable));
/*     */ 
/* 118 */     method.addParameter(new Parameter(type, "example"));
/*     */ 
/* 120 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 121 */       method.addException(fqjt);
/* 122 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 125 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 128 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.SelectByExampleWithoutBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */