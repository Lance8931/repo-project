/*    */ package org.mybatis.generator.codegen.mybatis3.javamapper.elements;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.mybatis.generator.api.CommentGenerator;
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
/*    */ public class InsertMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 40 */     Set importedTypes = new TreeSet();
/* 41 */     Method method = new Method();
/*    */ 
/* 43 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 44 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 45 */     method.setName(this.introspectedTable.getInsertStatementId());
/*    */ 
/* 47 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*    */ 
/* 50 */     importedTypes.add(parameterType);
/* 51 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */ 
/* 53 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 56 */     if (this.context.getPlugins().clientInsertMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 58 */       interfaze.addImportedTypes(importedTypes);
/* 59 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.InsertMethodGenerator
 * JD-Core Version:    0.6.0
 */