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
/*    */ public class InsertSelectiveMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set importedTypes = new TreeSet();
/* 42 */     Method method = new Method();
/*    */ 
/* 44 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 45 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 46 */     method.setName(this.introspectedTable.getInsertSelectiveStatementId());
/*    */ 
/* 48 */     FullyQualifiedJavaType parameterType = this.introspectedTable.getRules().calculateAllFieldsClass();
/*    */ 
/* 51 */     importedTypes.add(parameterType);
/* 52 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */ 
/* 54 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 57 */     if (this.context.getPlugins().clientInsertSelectiveMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 59 */       interfaze.addImportedTypes(importedTypes);
/* 60 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.InsertSelectiveMethodGenerator
 * JD-Core Version:    0.6.0
 */