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
/*     */ 
/*     */ public class CountByExampleMethodGenerator extends AbstractDAOElementGenerator
/*     */ {
/*     */   private boolean generateForJava5;
/*     */ 
/*     */   public CountByExampleMethodGenerator(boolean generateForJava5)
/*     */   {
/*  39 */     this.generateForJava5 = generateForJava5;
/*     */   }
/*     */ 
/*     */   public void addImplementationElements(TopLevelClass topLevelClass)
/*     */   {
/*  44 */     Set importedTypes = new TreeSet();
/*  45 */     Method method = getMethodShell(importedTypes);
/*     */ 
/*  48 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  50 */     sb.append("Integer count = (Integer)  ");
/*  51 */     sb.append(this.daoTemplate.getQueryForObjectMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getCountByExampleStatementId(), "example"));
/*     */ 
/*  54 */     method.addBodyLine(sb.toString());
/*     */ 
/*  56 */     if (this.generateForJava5)
/*  57 */       method.addBodyLine("return count;");
/*     */     else {
/*  59 */       method.addBodyLine("return count.intValue();");
/*     */     }
/*     */ 
/*  62 */     if (this.context.getPlugins().clientCountByExampleMethodGenerated(method, topLevelClass, this.introspectedTable))
/*     */     {
/*  64 */       topLevelClass.addImportedTypes(importedTypes);
/*  65 */       topLevelClass.addMethod(method);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addInterfaceElements(Interface interfaze)
/*     */   {
/*  71 */     if (getExampleMethodVisibility() == JavaVisibility.PUBLIC) {
/*  72 */       Set importedTypes = new TreeSet();
/*  73 */       Method method = getMethodShell(importedTypes);
/*     */ 
/*  75 */       if (this.context.getPlugins().clientCountByExampleMethodGenerated(method, interfaze, this.introspectedTable))
/*     */       {
/*  77 */         interfaze.addImportedTypes(importedTypes);
/*  78 */         interfaze.addMethod(method);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/*  84 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*     */ 
/*  86 */     importedTypes.add(type);
/*     */ 
/*  88 */     Method method = new Method();
/*  89 */     method.setVisibility(getExampleMethodVisibility());
/*  90 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/*  91 */     method.setName(getDAOMethodNameCalculator().getCountByExampleMethodName(this.introspectedTable));
/*     */ 
/*  93 */     method.addParameter(new Parameter(type, "example"));
/*     */ 
/*  95 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/*  96 */       method.addException(fqjt);
/*  97 */       importedTypes.add(fqjt);
/*     */     }
/*     */ 
/* 100 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*     */ 
/* 103 */     return method;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.CountByExampleMethodGenerator
 * JD-Core Version:    0.6.0
 */