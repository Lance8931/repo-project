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
/*    */ 
/*    */ public class CountByExampleMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 44 */     Set importedTypes = new TreeSet();
/* 45 */     importedTypes.add(fqjt);
/*    */ 
/* 47 */     Method method = new Method();
/* 48 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 49 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 50 */     method.setName(this.introspectedTable.getCountByExampleStatementId());
/* 51 */     method.addParameter(new Parameter(fqjt, "example"));
/* 52 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 55 */     if (this.context.getPlugins().clientCountByExampleMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 57 */       interfaze.addImportedTypes(importedTypes);
/* 58 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.CountByExampleMethodGenerator
 * JD-Core Version:    0.6.0
 */