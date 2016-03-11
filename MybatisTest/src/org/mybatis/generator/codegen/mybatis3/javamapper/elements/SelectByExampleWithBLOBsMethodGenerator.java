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
/*    */ public class SelectByExampleWithBLOBsMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 41 */     Set importedTypes = new TreeSet();
/* 42 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 44 */     importedTypes.add(type);
/* 45 */     importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
/*    */ 
/* 47 */     Method method = new Method();
/* 48 */     method.setVisibility(JavaVisibility.PUBLIC);
/*    */ 
/* 50 */     FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
/*    */     FullyQualifiedJavaType listType;
/* 53 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 54 */       listType = new FullyQualifiedJavaType(this.introspectedTable.getRecordWithBLOBsType());
/*    */     }
/*    */     else
/*    */     {
/* 58 */       listType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*    */     }
/*    */ 
/* 62 */     importedTypes.add(listType);
/* 63 */     returnType.addTypeArgument(listType);
/* 64 */     method.setReturnType(returnType);
/* 65 */     method.setName(this.introspectedTable.getSelectByExampleWithBLOBsStatementId());
/*    */ 
/* 67 */     method.addParameter(new Parameter(type, "example"));
/*    */ 
/* 69 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 72 */     if (this.context.getPlugins().clientSelectByExampleWithBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 75 */       interfaze.addImportedTypes(importedTypes);
/* 76 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */