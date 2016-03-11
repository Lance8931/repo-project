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
/*    */ public class UpdateByPrimaryKeyWithoutBLOBsMethodGenerator extends AbstractDAOElementGenerator
/*    */ {
/*    */   public void addImplementationElements(TopLevelClass topLevelClass)
/*    */   {
/* 42 */     Set importedTypes = new TreeSet();
/* 43 */     Method method = getMethodShell(importedTypes);
/*    */ 
/* 45 */     StringBuilder sb = new StringBuilder();
/* 46 */     sb.append("int rows = ");
/* 47 */     sb.append(this.daoTemplate.getUpdateMethod(this.introspectedTable.getIbatis2SqlMapNamespace(), this.introspectedTable.getUpdateByPrimaryKeyStatementId(), "record"));
/*    */ 
/* 50 */     method.addBodyLine(sb.toString());
/*    */ 
/* 52 */     method.addBodyLine("return rows;");
/*    */ 
/* 54 */     if (this.context.getPlugins().clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(method, topLevelClass, this.introspectedTable))
/*    */     {
/* 57 */       topLevelClass.addImportedTypes(importedTypes);
/* 58 */       topLevelClass.addMethod(method);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void addInterfaceElements(Interface interfaze)
/*    */   {
/* 64 */     Set importedTypes = new TreeSet();
/* 65 */     Method method = getMethodShell(importedTypes);
/*    */ 
/* 67 */     if (this.context.getPlugins().clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(method, interfaze, this.introspectedTable))
/*    */     {
/* 70 */       interfaze.addImportedTypes(importedTypes);
/* 71 */       interfaze.addMethod(method);
/*    */     }
/*    */   }
/*    */ 
/*    */   private Method getMethodShell(Set<FullyQualifiedJavaType> importedTypes) {
/* 76 */     FullyQualifiedJavaType parameterType = new FullyQualifiedJavaType(this.introspectedTable.getBaseRecordType());
/*    */ 
/* 78 */     importedTypes.add(parameterType);
/*    */ 
/* 80 */     Method method = new Method();
/* 81 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 82 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 83 */     method.setName(getDAOMethodNameCalculator().getUpdateByPrimaryKeyWithoutBLOBsMethodName(this.introspectedTable));
/*    */ 
/* 87 */     method.addParameter(new Parameter(parameterType, "record"));
/*    */ 
/* 89 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getCheckedExceptions()) {
/* 90 */       method.addException(fqjt);
/* 91 */       importedTypes.add(fqjt);
/*    */     }
/*    */ 
/* 94 */     this.context.getCommentGenerator().addGeneralMethodComment(method, this.introspectedTable);
/*    */ 
/* 97 */     return method;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByPrimaryKeyWithoutBLOBsMethodGenerator
 * JD-Core Version:    0.6.0
 */