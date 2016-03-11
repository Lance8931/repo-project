/*     */ package org.mybatis.generator.codegen.ibatis2.dao;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.AbstractDAOElementGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.CountByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.DeleteByExampleMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.DeleteByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.InsertMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.InsertSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.SelectByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.SelectByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.SelectByPrimaryKeyMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleParmsInnerclassGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleSelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByExampleWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByPrimaryKeySelectiveMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByPrimaryKeyWithBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.elements.UpdateByPrimaryKeyWithoutBLOBsMethodGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class DAOGenerator extends AbstractJavaGenerator
/*     */ {
/*     */   private AbstractDAOTemplate daoTemplate;
/*     */   private boolean generateForJava5;
/*     */ 
/*     */   public DAOGenerator(AbstractDAOTemplate daoTemplate, boolean generateForJava5)
/*     */   {
/*  66 */     this.daoTemplate = daoTemplate;
/*  67 */     this.generateForJava5 = generateForJava5;
/*     */   }
/*     */ 
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  72 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  73 */     this.progressCallback.startTask(Messages.getString("Progress.14", table.toString()));
/*     */ 
/*  75 */     TopLevelClass topLevelClass = getTopLevelClassShell();
/*  76 */     Interface interfaze = getInterfaceShell();
/*     */ 
/*  78 */     addCountByExampleMethod(topLevelClass, interfaze);
/*  79 */     addDeleteByExampleMethod(topLevelClass, interfaze);
/*  80 */     addDeleteByPrimaryKeyMethod(topLevelClass, interfaze);
/*  81 */     addInsertMethod(topLevelClass, interfaze);
/*  82 */     addInsertSelectiveMethod(topLevelClass, interfaze);
/*  83 */     addSelectByExampleWithBLOBsMethod(topLevelClass, interfaze);
/*  84 */     addSelectByExampleWithoutBLOBsMethod(topLevelClass, interfaze);
/*  85 */     addSelectByPrimaryKeyMethod(topLevelClass, interfaze);
/*  86 */     addUpdateByExampleParmsInnerclass(topLevelClass, interfaze);
/*  87 */     addUpdateByExampleSelectiveMethod(topLevelClass, interfaze);
/*  88 */     addUpdateByExampleWithBLOBsMethod(topLevelClass, interfaze);
/*  89 */     addUpdateByExampleWithoutBLOBsMethod(topLevelClass, interfaze);
/*  90 */     addUpdateByPrimaryKeySelectiveMethod(topLevelClass, interfaze);
/*  91 */     addUpdateByPrimaryKeyWithBLOBsMethod(topLevelClass, interfaze);
/*  92 */     addUpdateByPrimaryKeyWithoutBLOBsMethod(topLevelClass, interfaze);
/*     */ 
/*  94 */     List answer = new ArrayList();
/*  95 */     if (this.context.getPlugins().clientGenerated(interfaze, topLevelClass, this.introspectedTable))
/*     */     {
/*  97 */       answer.add(topLevelClass);
/*  98 */       answer.add(interfaze);
/*     */     }
/*     */ 
/* 101 */     return answer;
/*     */   }
/*     */ 
/*     */   protected TopLevelClass getTopLevelClassShell() {
/* 105 */     FullyQualifiedJavaType interfaceType = new FullyQualifiedJavaType(this.introspectedTable.getDAOInterfaceType());
/*     */ 
/* 107 */     FullyQualifiedJavaType implementationType = new FullyQualifiedJavaType(this.introspectedTable.getDAOImplementationType());
/*     */ 
/* 110 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */ 
/* 112 */     TopLevelClass answer = new TopLevelClass(implementationType);
/* 113 */     answer.setVisibility(JavaVisibility.PUBLIC);
/* 114 */     answer.setSuperClass(this.daoTemplate.getSuperClass());
/* 115 */     answer.addImportedType(this.daoTemplate.getSuperClass());
/* 116 */     answer.addSuperInterface(interfaceType);
/* 117 */     answer.addImportedType(interfaceType);
/*     */ 
/* 119 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getImplementationImports())
/*     */     {
/* 121 */       answer.addImportedType(fqjt);
/*     */     }
/*     */ 
/* 124 */     commentGenerator.addJavaFileComment(answer);
/*     */ 
/* 127 */     answer.addMethod(this.daoTemplate.getConstructorClone(commentGenerator, implementationType, this.introspectedTable));
/*     */ 
/* 131 */     for (Field field : this.daoTemplate.getFieldClones(commentGenerator, this.introspectedTable))
/*     */     {
/* 133 */       answer.addField(field);
/*     */     }
/*     */ 
/* 137 */     for (Method method : this.daoTemplate.getMethodClones(commentGenerator, this.introspectedTable))
/*     */     {
/* 139 */       answer.addMethod(method);
/*     */     }
/*     */ 
/* 142 */     return answer;
/*     */   }
/*     */ 
/*     */   protected Interface getInterfaceShell() {
/* 146 */     Interface answer = new Interface(new FullyQualifiedJavaType(this.introspectedTable.getDAOInterfaceType()));
/*     */ 
/* 148 */     answer.setVisibility(JavaVisibility.PUBLIC);
/*     */ 
/* 150 */     String rootInterface = this.introspectedTable.getTableConfigurationProperty("rootInterface");
/*     */ 
/* 152 */     if (rootInterface == null) {
/* 153 */       rootInterface = this.context.getJavaClientGeneratorConfiguration().getProperty("rootInterface");
/*     */     }
/*     */ 
/* 157 */     if (StringUtility.stringHasValue(rootInterface)) {
/* 158 */       FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);
/*     */ 
/* 160 */       answer.addSuperInterface(fqjt);
/* 161 */       answer.addImportedType(fqjt);
/*     */     }
/*     */ 
/* 164 */     for (FullyQualifiedJavaType fqjt : this.daoTemplate.getInterfaceImports()) {
/* 165 */       answer.addImportedType(fqjt);
/*     */     }
/*     */ 
/* 168 */     this.context.getCommentGenerator().addJavaFileComment(answer);
/*     */ 
/* 170 */     return answer;
/*     */   }
/*     */ 
/*     */   protected void addCountByExampleMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 175 */     if (this.introspectedTable.getRules().generateCountByExample()) {
/* 176 */       AbstractDAOElementGenerator methodGenerator = new CountByExampleMethodGenerator(this.generateForJava5);
/*     */ 
/* 178 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByExampleMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 185 */     if (this.introspectedTable.getRules().generateDeleteByExample()) {
/* 186 */       AbstractDAOElementGenerator methodGenerator = new DeleteByExampleMethodGenerator();
/* 187 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addDeleteByPrimaryKeyMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 194 */     if (this.introspectedTable.getRules().generateDeleteByPrimaryKey()) {
/* 195 */       AbstractDAOElementGenerator methodGenerator = new DeleteByPrimaryKeyMethodGenerator();
/* 196 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 203 */     if (this.introspectedTable.getRules().generateInsert()) {
/* 204 */       AbstractDAOElementGenerator methodGenerator = new InsertMethodGenerator();
/* 205 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addInsertSelectiveMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 212 */     if (this.introspectedTable.getRules().generateInsertSelective()) {
/* 213 */       AbstractDAOElementGenerator methodGenerator = new InsertSelectiveMethodGenerator();
/* 214 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithBLOBsMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 221 */     if (this.introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
/* 222 */       AbstractDAOElementGenerator methodGenerator = new SelectByExampleWithBLOBsMethodGenerator(this.generateForJava5);
/*     */ 
/* 224 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByExampleWithoutBLOBsMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 231 */     if (this.introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
/* 232 */       AbstractDAOElementGenerator methodGenerator = new SelectByExampleWithoutBLOBsMethodGenerator(this.generateForJava5);
/*     */ 
/* 234 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addSelectByPrimaryKeyMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 241 */     if (this.introspectedTable.getRules().generateSelectByPrimaryKey()) {
/* 242 */       AbstractDAOElementGenerator methodGenerator = new SelectByPrimaryKeyMethodGenerator();
/* 243 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleParmsInnerclass(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 250 */     Rules rules = this.introspectedTable.getRules();
/* 251 */     if ((rules.generateUpdateByExampleSelective()) || (rules.generateUpdateByExampleWithBLOBs()) || (rules.generateUpdateByExampleWithoutBLOBs()))
/*     */     {
/* 254 */       AbstractDAOElementGenerator methodGenerator = new UpdateByExampleParmsInnerclassGenerator();
/* 255 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleSelectiveMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 262 */     if (this.introspectedTable.getRules().generateUpdateByExampleSelective()) {
/* 263 */       AbstractDAOElementGenerator methodGenerator = new UpdateByExampleSelectiveMethodGenerator();
/* 264 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithBLOBsMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 271 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
/* 272 */       AbstractDAOElementGenerator methodGenerator = new UpdateByExampleWithBLOBsMethodGenerator();
/* 273 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByExampleWithoutBLOBsMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 280 */     if (this.introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
/* 281 */       AbstractDAOElementGenerator methodGenerator = new UpdateByExampleWithoutBLOBsMethodGenerator();
/* 282 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeySelectiveMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 289 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
/* 290 */       AbstractDAOElementGenerator methodGenerator = new UpdateByPrimaryKeySelectiveMethodGenerator();
/* 291 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithBLOBsMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 298 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
/* 299 */       AbstractDAOElementGenerator methodGenerator = new UpdateByPrimaryKeyWithBLOBsMethodGenerator();
/* 300 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void addUpdateByPrimaryKeyWithoutBLOBsMethod(TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 307 */     if (this.introspectedTable.getRules().generateUpdateByPrimaryKeyWithoutBLOBs())
/*     */     {
/* 309 */       AbstractDAOElementGenerator methodGenerator = new UpdateByPrimaryKeyWithoutBLOBsMethodGenerator();
/* 310 */       initializeAndExecuteGenerator(methodGenerator, topLevelClass, interfaze);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initializeAndExecuteGenerator(AbstractDAOElementGenerator methodGenerator, TopLevelClass topLevelClass, Interface interfaze)
/*     */   {
/* 318 */     methodGenerator.setDAOTemplate(this.daoTemplate);
/* 319 */     methodGenerator.setContext(this.context);
/* 320 */     methodGenerator.setIntrospectedTable(this.introspectedTable);
/* 321 */     methodGenerator.setProgressCallback(this.progressCallback);
/* 322 */     methodGenerator.setWarnings(this.warnings);
/* 323 */     methodGenerator.addImplementationElements(topLevelClass);
/* 324 */     methodGenerator.addInterfaceElements(interfaze);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.DAOGenerator
 * JD-Core Version:    0.6.0
 */