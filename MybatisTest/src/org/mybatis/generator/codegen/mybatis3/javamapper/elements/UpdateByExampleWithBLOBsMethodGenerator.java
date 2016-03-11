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
/*    */ public class UpdateByExampleWithBLOBsMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set importedTypes = new TreeSet();
/* 42 */     Method method = new Method();
/* 43 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 44 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 45 */     method.setName(this.introspectedTable.getUpdateByExampleWithBLOBsStatementId());
/*    */     FullyQualifiedJavaType parameterType;
/* 49 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 50 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*    */     }
/*    */     else {
/* 53 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*    */     }
/*    */ 
/* 56 */     method.addParameter(new Parameter(parameterType, "record", "@Param(\"record\")"));
/*    */ 
/* 58 */     importedTypes.add(parameterType);
/*    */ 
/* 60 */     FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 62 */     method.addParameter(new Parameter(exampleType, "example", "@Param(\"example\")"));
/*    */ 
/* 64 */     importedTypes.add(exampleType);
/*    */ 
/* 66 */     importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
/*    */ 
/* 69 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 72 */     if (this.context.getPlugins().clientUpdateByExampleWithBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 75 */       interfaze.addImportedTypes(importedTypes);
/* 76 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByExampleWithBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */