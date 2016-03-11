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
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class SelectByExampleWithoutBLOBsMethodGenerator extends AbstractJavaMapperMethodGenerator
/*    */ {
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 42 */     Set importedTypes = new TreeSet();
/* 43 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 45 */     importedTypes.add(type);
/* 46 */     importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
/*    */ 
/* 48 */     Method method = new Method();
/* 49 */     method.setVisibility(JavaVisibility.PUBLIC);
/*    */ 
/* 51 */     FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
/*    */     FullyQualifiedJavaType listType;
/* 54 */     if (this.introspectedTable.getRules().generateBaseRecordClass()) {
/* 55 */       listType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*    */     }
/*    */     else
/*    */     {
/* 57 */       if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 58 */         listType = new FullyQualifiedJavaType(this.introspectedTable.getPrimaryKeyType());
/*    */       }
/*    */       else
/* 61 */         throw new RuntimeException(Messages.getString("RuntimeError.12"));
/*    */     }
/* 64 */     importedTypes.add(listType);
/* 65 */     returnType.addTypeArgument(listType);
/* 66 */     method.setReturnType(returnType);
/*    */ 
/* 68 */     method.setName(this.introspectedTable.getSelectByExampleStatementId());
/* 69 */     method.addParameter(new Parameter(type, "example"));
/*    */ 
/* 71 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 74 */     if (this.context.getPlugins().clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 77 */       interfaze.addImportedTypes(importedTypes);
/* 78 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithoutBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */