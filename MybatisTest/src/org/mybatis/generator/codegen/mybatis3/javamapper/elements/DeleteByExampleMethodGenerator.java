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
/*    */ public class DeleteByExampleMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set importedTypes = new TreeSet();
/* 42 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 44 */     importedTypes.add(type);
/*    */ 
/* 46 */     Method method = new Method();
/* 47 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 48 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 49 */     method.setName(this.introspectedTable.getDeleteByExampleStatementId());
/* 50 */     method.addParameter(new Parameter(type, "example"));
/*    */ 
/* 52 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 55 */     if (this.context.getPlugins().clientDeleteByExampleMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 57 */       interfaze.addImportedTypes(importedTypes);
/* 58 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.DeleteByExampleMethodGenerator
 * JD-Core Version:    0.6.0
 */