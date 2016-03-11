/*     */ package org.mybatis.generator.codegen.mybatis3.javamapper;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.CountByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.DeleteByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.DeleteByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.InsertMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.InsertSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByExampleSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByPrimaryKeySelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByPrimaryKeyWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.elements.UpdateByPrimaryKeyWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class JavaMapperGenerator extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  60 */     this.progressCallback.startTask(Messages.getString("Progress.17", this.introspectedTable.getFullyQualifiedTable().toString()));
/*     */ 
/*  62 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */ 
/*  64 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getMyBatis3JavaMapperType());
/*     */ 
/*  66 */     Interface interfaze = new Interface(type);
/*  67 */     interfaze.setVisibility(JavaVisibility.PUBLIC);
/*  68 */     commentGenerator.addJavaFileComment(interfaze);
/*     */ 
/*  70 */     addCountByExampleMethod(interfaze);
/*  71 */     addDeleteByExampleMethod(interfaze);
/*  72 */     addDeleteByPrimaryKeyMethod(interfaze);
/*  73 */     addInsertMethod(interfaze);
/*  74 */     addInsertSelectiveMethod(interfaze);
/*  75 */     addSelectByExampleWithBLOBsMethod(interfaze);
/*  76 */     addSelectByExampleWithoutBLOBsMethod(interfaze);
/*  77 */     addSelectByPrimaryKeyMethod(interfaze);
/*  78 */     addUpdateByExampleSelectiveMethod(interfaze);
/*  79 */     addUpdateByExampleWithBLOBsMethod(interfaze);
/*  80 */     addUpdateByExampleWithoutBLOBsMethod(interfaze);
/*  81 */     addUpdateByPrimaryKeySelectiveMethod(interfaze);
/*  82 */     addUpdateByPrimaryKeyWithBLOBsMethod(interfaze);
/*  83 */     addUpdateByPrimaryKeyWithoutBLOBsMethod(interfaze);
/*     */ 
/*  85 */     List answer = new ArrayList();
/*  86 */     if (this.context.getPlugins().clientGenerated(interfaze, null, this.introspectedTable))
/*     */     {
/*  88 */       answer.add(interfaze);
/*     */     }
/*     */ 
/*  91 */     return answer;
/*     */   }
/*     */ 
/*     */   protected void addCountByExampleMethod(Interface interfaze) {
/*  95 */     if (this.introspectedTable.getRules().generateCountByExample()) {
/*  96 */       AbstractJavaMapperMethodGenerator methodGenerator = new CountByExampleMethodGenerator();
/*  97 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByExampleMethod(Interface interfaze) {
/* 102 */     if (this.introspectedTable.getRules().generateDeleteByExample()) {
/* 103 */       AbstractJavaMapperMethodGenerator methodGenerator = new DeleteByExampleMethodGenerator();
/* 104 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByPrimaryKeyMethod(Interface interfaze) {
/* 109 */     if (this.introspectedTable.getRules().generateDeleteByPrimaryKey()) {
/* 110 */       AbstractJavaMapperMethodGenerator methodGenerator = new DeleteByPrimaryKeyMethodGenerator();
/* 111 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertMethod(Interface interfaze) {
/* 116 */     if (this.introspectedTable.getRules().generateInsert()) {
/* 117 */       AbstractJavaMapperMethodGenerator methodGenerator = new InsertMethodGenerator();
/* 118 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertSelectiveMethod(Interface interfaze) {
/* 123 */     if (this.introspectedTable.getRules().generateInsertSelective()) {
/* 124 */       AbstractJavaMapperMethodGenerator methodGenerator = new InsertSelectiveMethodGenerator();
/* 125 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithBLOBsMethod(Interface interfaze) {
/* 130 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/* 131 */       AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithBLOBsMethodGenerator();
/* 132 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithoutBLOBsMethod(Interface interfaze) {
/* 137 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/* 138 */       AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithoutBLOBsMethodGenerator();
/* 139 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByPrimaryKeyMethod(Interface interfaze) {
/* 144 */     if (this.introspectedTable.getRules().generateSelectByPrimaryKey()) {
/* 145 */       AbstractJavaMapperMethodGenerator methodGenerator = new SelectByPrimaryKeyMethodGenerator();
/* 146 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleSelectiveMethod(Interface interfaze) {
/* 151 */     if (this.introspectedTable.getRules().generateUpdateByExampleSelective()) {
/* 152 */       AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleSelectiveMethodGenerator();
/* 153 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithBLOBsMethod(Interface interfaze) {
/* 158 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
/* 159 */       AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleWithBLOBsMethodGenerator();
/* 160 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithoutBLOBsMethod(Interface interfaze) {
/* 165 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
/* 166 */       AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleWithoutBLOBsMethodGenerator();
/* 167 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeySelectiveMethod(Interface interfaze) {
/* 172 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
/* 173 */       AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeySelectiveMethodGenerator();
/* 174 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithBLOBsMethod(Interface interfaze) {
/* 179 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
/* 180 */       AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithBLOBsMethodGenerator();
/* 181 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithoutBLOBsMethod(Interface interfaze) {
/* 186 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithoutBLOBs())
/*     */     {
/* 188 */       AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithoutBLOBsMethodGenerator();
/* 189 */       initializeAndExecuteGenerator(methodGenerator, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initializeAndExecuteGenerator(AbstractJavaMapperMethodGenerator methodGenerator, Interface interfaze)
/*     */   {
/* 196 */     methodGenerator.setContext(this.context);
/* 197 */     methodGenerator.setIntrospectedTable(this.introspectedTable);
/* 198 */     methodGenerator.setProgressCallback(this.progressCallback);
/* 199 */     methodGenerator.setWarnings(this.warnings);
/* 200 */     methodGenerator.addInterfaceElements(interfaze);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator
 * JD-Core Version:    0.6.0
 */