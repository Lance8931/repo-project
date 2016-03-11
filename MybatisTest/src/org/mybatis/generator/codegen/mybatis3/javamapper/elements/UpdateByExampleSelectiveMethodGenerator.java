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
/*    */ public class UpdateByExampleSelectiveMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 37 */     Set importedTypes = new TreeSet();
/* 38 */     Method method = new Method();
/* 39 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 40 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 41 */     method.setName(this.introspectedTable.getUpdateByExampleSelectiveStatementId());
/*    */     FullyQualifiedJavaType parameterType;
/* 45 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 46 */       parameterType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*    */     }
/*    */     else
/*    */     {
/* 48 */       if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/* 49 */         parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*    */       }
/*    */       else {
/* 52 */         parameterType = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*    */       }
/*    */     }
/* 55 */     method.addParameter(new Parameter(parameterType, "record", "@Param(\"record\")"));
/*    */ 
/* 57 */     importedTypes.add(parameterType);
/*    */ 
/* 59 */     FullyQualifiedJavaType exampleType = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 61 */     method.addParameter(new Parameter(exampleType, "example", "@Param(\"example\")"));
/*    */ 
/* 63 */     importedTypes.add(exampleType);
/*    */ 
/* 65 */     importedTypes.add(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
/*    */ 
/* 68 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 71 */     if (this.context.getPlugins().clientUpdateByExampleSelectiveMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 74 */       interfaze.addImportedTypes(importedTypes);
/* 75 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByExampleSelectiveMethodGenerator
 * JD-Core Version:    0.6.0
 */