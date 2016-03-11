/*    */ package org.mybatis.generator.codegen.ibatis2.dao.elements;
/*    */ 
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.java.Interface;
/*    */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*    */ import org.mybatis.generator.api.dom.java.Method;
/*    */ import org.mybatis.generator.api.dom.java.Parameter;
/*    */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*    */ import org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class DeleteByExampleMethodGenerator extends AbstractDAOElementGenerator
/*    */ {
/*    */   public void addImplementationElements(TopLevelClass topLevelClass)
/*    */   {
/* 41 */     Set importedTypes = new TreeSet();
/* 42 */     Method method = getMethodShell(importedTypes);
/*    */ 
/* 44 */     StringBuilder sb = new StringBuilder();
/* 45 */     sb.append("int rows = ");
/* 46 */     sb.append(this.daoTemplate.getDeleteMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getDeleteByExampleStatementId(), "example"));
/*    */ 
/* 49 */     method.addBodyLine(sb.toString());
/* 50 */     method.addBodyLine("return rows;");
/*    */ 
/* 52 */     if (this.context.getPlugins().clientDeleteByExampleMethodGenerated(method, topLevelClass, this.introspectedTable))
/*    */     {
/* 54 */       topLevelClass.addImportedTypes(importedTypes);
/* 55 */       topLevelClass.addMethod(method);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 61 */     if (getExampleMethodVisibility() == JavaVisibility.PUBLIC) {
/* 62 */       Set importedTypes = new TreeSet();
/* 63 */       Method method = getMethodShell(importedTypes);
/*    */ 
/* 65 */       if (this.context.getPlugins().clientDeleteByExampleMethodGenerated(method, interfaze, this.introspectedTable))
/*    */       {
/* 67 */         interfaze.addImportedTypes(importedTypes);
/* 68 */         interfaze.addMethod(method);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/* 74 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*    */ 
/* 76 */     importedTypes.add(type);
/*    */ 
/* 78 */     Method method = new Method();
/* 79 */     method.setVisibility(getExampleMethodVisibility());
/* 80 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 81 */     method.setName(getDAOMethodNameCalculator().getDeleteByExampleMethodName(this.introspectedTable));
/*    */ 
/* 83 */     method.addParameter(new Parameter(type, "example"));
/*    */ 
/* 85 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 86 */       method.addException(fqjt);
/* 87 */       importedTypes.add(fqjt);
/*    */     }
/*    */ 
/* 90 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 93 */     return method;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.DeleteByExampleMethodGenerator
 * JD-Core Version:    0.6.0
 */