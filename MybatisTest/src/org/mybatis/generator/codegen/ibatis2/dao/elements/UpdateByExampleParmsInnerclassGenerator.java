/*    */ package org.mybatis.generator.codegen.ibatis2.dao.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.java.Field;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.InnerClass;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class UpdateByExampleParmsInnerclassGenerator extends AbstractDAOElementGenerator
/*    */ {
/*    */   public void addImplementationElements(TopLevelClass topLevelClass)
/*    */   {
/* 41 */     topLevelClass.addImportedType(new FullyQualifiedJavaType(this.introspectedTable.getExampleType()));
/*    */ 
/* 44 */     InnerClass innerClass = new InnerClass(new FullyQualifiedJavaType("UpdateByExampleParms"));
/*    */ 
/* 46 */     innerClass.setVisibility(JavaVisibility.PROTECTED);
/* 47 */     innerClass.setStatic(true);
/* 48 */     innerClass.setSuperClass(this.introspectedTable.getExampleType());
/* 49 */     this.context.getCommentGenerator().addClassComment(innerClass, this.introspectedTable);
/*    */ 
/* 52 */     Method method = new Method();
/* 53 */     method.setConstructor(true);
/* 54 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 55 */     method.setName(innerClass.getType().getShortName());
/* 56 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "record"));
/*    */ 
/* 58 */     method.addParameter(new Parameter(new FullyQualifiedJavaType(this.introspectedTable.getExampleType()), "example"));
/*    */ 
/* 60 */     method.addBodyLine("super(example);");
/* 61 */     method.addBodyLine("this.record = record;");
/* 62 */     innerClass.addMethod(method);
/*    */ 
/* 64 */     Field field = new Field();
/* 65 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 66 */     field.setType(FullyQualifiedJavaType.getObjectInstance());
/* 67 */     field.setName("record");
/* 68 */     innerClass.addField(field);
/*    */ 
/* 70 */     method = new Method();
/* 71 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 72 */     method.setReturnType(FullyQualifiedJavaType.getObjectInstance());
/* 73 */     method.setName("getRecord");
/* 74 */     method.addBodyLine("return record;");
/* 75 */     innerClass.addMethod(method);
/*    */ 
/* 77 */     topLevelClass.addInnerClass(innerClass);
/*    */   }
/*    */ 
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleParmsInnerclassGenerator
 * JD-Core Version:    0.6.0
 */