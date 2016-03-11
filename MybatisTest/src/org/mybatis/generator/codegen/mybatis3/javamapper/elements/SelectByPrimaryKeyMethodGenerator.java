/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.rules.Rules;
/*    */ 
/*    */ public class SelectByPrimaryKeyMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 43 */     Set importedTypes = new TreeSet();
/* 44 */     Method method = new Method();
/* 45 */     method.setVisibility(JavaVisibility.PUBLIC);
/*    */ 
/* 47 */     FullyQualifiedJavaType returnType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*    */ 
/* 49 */     method.setReturnType(returnType);
/* 50 */     importedTypes.add(returnType);
/*    */ 
/* 52 */     method.setName(this.introspectedTable.getSelectByPrimaryKeyStatementId());
/*    */     boolean annotate;
/*    */     StringBuilder sb;
/* 54 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 55 */       FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*    */ 
/* 57 */       importedTypes.add(type);
/* 58 */       method.addParameter(new Parameter(type, "key"));
/*    */     }
/*    */     else
/*    */     {
/* 64 */       List<IntrospectedColumn> introspectedColumns = this.introspectedTable.getPrimaryKeyColumns();
/*    */ 
/* 66 */       annotate = introspectedColumns.size() > 1;
/* 67 */       if (annotate) {
/* 68 */         importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
/*    */       }
/*    */ 
/* 71 */       sb = new StringBuilder();
/* 72 */       for (IntrospectedColumn introspectedColumn : introspectedColumns) {
/* 73 */         FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
/*    */ 
/* 75 */         importedTypes.add(type);
/* 76 */         Parameter parameter = new Parameter(type, introspectedColumn.getJavaProperty());
/*    */ 
/* 78 */         if (annotate) {
/* 79 */           sb.setLength(0);
/* 80 */           sb.append("@Param(\"");
/* 81 */           sb.append(introspectedColumn.getJavaProperty());
/* 82 */           sb.append("\")");
/* 83 */           parameter.addAnnotation(sb.toString());
/*    */         }
/* 85 */         method.addParameter(parameter);
/*    */       }
/*    */     }
/*    */ 
/* 89 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 92 */     if (this.context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 94 */       interfaze.addImportedTypes(importedTypes);
/* 95 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByPrimaryKeyMethodGenerator
 * JD-Core Version:    0.6.0
 */