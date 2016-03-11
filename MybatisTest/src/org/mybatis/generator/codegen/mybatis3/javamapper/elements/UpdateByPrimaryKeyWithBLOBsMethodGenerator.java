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
/*    */ public class UpdateByPrimaryKeyWithBLOBsMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set importedTypes = new TreeSet();
/*    */     FullyQualifiedJavaType parameterType;
/* 44 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 45 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*    */     }
/*    */     else {
/* 48 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*    */     }
/*    */ 
/* 52 */     importedTypes.add(parameterType);
/*    */ 
/* 54 */     Method method = new Method();
/* 55 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 56 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 57 */     method.setName(this.introspectedTable.getUpdateByPrimaryKeyWithBLOBsStatementId());
/*    */ 
/* 59 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */ 
/* 61 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 64 */     if (this.context.getPlugins().clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 67 */       interfaze.addImportedTypes(importedTypes);
/* 68 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByPrimaryKeyWithBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */