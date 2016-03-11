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
/*    */ public class DeleteByPrimaryKeyMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 43 */     Set importedTypes = new TreeSet();
/* 44 */     Method method = new Method();
/* 45 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 46 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 47 */     method.setName(this.introspectedTable.getDeleteByPrimaryKeyStatementId());
/*    */     boolean annotate;
/*    */     StringBuilder sb;
/* 49 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 50 */       FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*    */ 
/* 52 */       importedTypes.add(type);
/* 53 */       method.addParameter(new Parameter(type, "key"));
/*    */     }
/*    */     else
/*    */     {
/* 59 */       List<IntrospectedColumn> introspectedColumns = this.introspectedTable.getPrimaryKeyColumns();
/*    */ 
/* 61 */       annotate = introspectedColumns.size() > 1;
/* 62 */       if (annotate) {
/* 63 */         importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
/*    */       }
/*    */ 
/* 66 */       sb = new StringBuilder();
/* 67 */       for (IntrospectedColumn introspectedColumn : introspectedColumns) {
/* 68 */         FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
/*    */ 
/* 70 */         importedTypes.add(type);
/* 71 */         Parameter parameter = new Parameter(type, introspectedColumn.getJavaProperty());
/*    */ 
/* 73 */         if (annotate) {
/* 74 */           sb.setLength(0);
/* 75 */           sb.append("@Param(\"");
/* 76 */           sb.append(introspectedColumn.getJavaProperty());
/* 77 */           sb.append("\")");
/* 78 */           parameter.addAnnotation(sb.toString());
/*    */         }
/* 80 */         method.addParameter(parameter);
/*    */       }
/*    */     }
/*    */ 
/* 84 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 87 */     if (this.context.getPlugins().clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 89 */       interfaze.addImportedTypes(importedTypes);
/* 90 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.DeleteByPrimaryKeyMethodGenerator
 * JD-Core Version:    0.6.0
 */