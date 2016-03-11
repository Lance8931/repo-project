/*     */ package org.mybatis.generator.codegen.ibatis2.dao.templates;
/*     */ 
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ 
/*     */ public abstract class AbstractDAOTemplate
/*     */ {
/*     */   private List<FullyQualifiedJavaType> interfaceImports;
/*     */   private List<FullyQualifiedJavaType> implementationImports;
/*     */   private FullyQualifiedJavaType superClass;
/*     */   private List<FullyQualifiedJavaType> checkedExceptions;
/*     */   private List<Field> fields;
/*     */   private List<Method> methods;
/*     */   private Method constructorTemplate;
/*     */   private String deleteMethodTemplate;
/*     */   private String insertMethodTemplate;
/*     */   private String updateMethodTemplate;
/*     */   private String queryForObjectMethodTemplate;
/*     */   private String queryForListMethodTemplate;
/*     */   private boolean configured;
/*     */ 
/*     */   public AbstractDAOTemplate()
/*     */   {
/*  68 */     this.interfaceImports = new ArrayList();
/*  69 */     this.implementationImports = new ArrayList();
/*  70 */     this.fields = new ArrayList();
/*  71 */     this.methods = new ArrayList();
/*  72 */     this.checkedExceptions = new ArrayList();
/*  73 */     this.configured = false;
/*     */   }
/*     */ 
/*     */   public final Method getConstructorClone(CommentGenerator commentGenerator, FullyQualifiedJavaType type, IntrospectedTable introspectedTable)
/*     */   {
/*  78 */     configure();
/*  79 */     Method answer = new Method();
/*  80 */     answer.setConstructor(true);
/*  81 */     answer.setName(type.getShortName());
/*  82 */     answer.setVisibility(this.constructorTemplate.getVisibility());
/*  83 */     for (Parameter parm : this.constructorTemplate.getParameters()) {
/*  84 */       answer.addParameter(parm);
/*     */     }
/*     */ 
/*  87 */     for (String bodyLine : this.constructorTemplate.getBodyLines()) {
/*  88 */       answer.addBodyLine(bodyLine);
/*     */     }
/*     */ 
/*  91 */     for (FullyQualifiedJavaType fqjt : this.constructorTemplate.getExceptions()) {
/*  92 */       answer.addException(fqjt);
/*     */     }
/*     */ 
/*  95 */     commentGenerator.addGeneralMethodComment(answer, introspectedTable);
/*     */ 
/*  97 */     return answer;
/*     */   }
/*     */ 
/*     */   public final String getDeleteMethod(String sqlMapNamespace, String statementId, String parameter)
/*     */   {
/* 102 */     configure();
/* 103 */     String answer = MessageFormat.format(this.deleteMethodTemplate, new Object[] { sqlMapNamespace, statementId, parameter });
/*     */ 
/* 106 */     return answer;
/*     */   }
/*     */ 
/*     */   public final List<FullyQualifiedJavaType> getInterfaceImports() {
/* 110 */     configure();
/* 111 */     return this.interfaceImports;
/*     */   }
/*     */ 
/*     */   public final List<FullyQualifiedJavaType> getImplementationImports() {
/* 115 */     configure();
/* 116 */     return this.implementationImports;
/*     */   }
/*     */ 
/*     */   public final String getInsertMethod(String sqlMapNamespace, String statementId, String parameter)
/*     */   {
/* 121 */     configure();
/* 122 */     String answer = MessageFormat.format(this.insertMethodTemplate, new Object[] { sqlMapNamespace, statementId, parameter });
/*     */ 
/* 125 */     return answer;
/*     */   }
/*     */ 
/*     */   public final String getQueryForListMethod(String sqlMapNamespace, String statementId, String parameter)
/*     */   {
/* 130 */     configure();
/* 131 */     String answer = MessageFormat.format(this.queryForListMethodTemplate, new Object[] { sqlMapNamespace, statementId, parameter });
/*     */ 
/* 134 */     return answer;
/*     */   }
/*     */ 
/*     */   public final String getQueryForObjectMethod(String sqlMapNamespace, String statementId, String parameter)
/*     */   {
/* 139 */     configure();
/* 140 */     String answer = MessageFormat.format(this.queryForObjectMethodTemplate, new Object[] { sqlMapNamespace, statementId, parameter });
/*     */ 
/* 143 */     return answer;
/*     */   }
/*     */ 
/*     */   public final FullyQualifiedJavaType getSuperClass() {
/* 147 */     configure();
/* 148 */     return this.superClass;
/*     */   }
/*     */ 
/*     */   public final String getUpdateMethod(String sqlMapNamespace, String statementId, String parameter)
/*     */   {
/* 153 */     configure();
/* 154 */     String answer = MessageFormat.format(this.updateMethodTemplate, new Object[] { sqlMapNamespace, statementId, parameter });
/*     */ 
/* 157 */     return answer;
/*     */   }
/*     */ 
/*     */   public final List<FullyQualifiedJavaType> getCheckedExceptions() {
/* 161 */     configure();
/* 162 */     return this.checkedExceptions;
/*     */   }
/*     */ 
/*     */   public final List<Field> getFieldClones(CommentGenerator commentGenerator, IntrospectedTable introspectedTable)
/*     */   {
/* 167 */     configure();
/* 168 */     List answer = new ArrayList();
/* 169 */     for (Field oldField : this.fields) {
/* 170 */       Field field = new Field();
/*     */ 
/* 172 */       field.setInitializationString(oldField.getInitializationString());
/* 173 */       field.setFinal(oldField.isFinal());
/* 174 */       field.setStatic(oldField.isStatic());
/* 175 */       field.setName(oldField.getName());
/* 176 */       field.setType(oldField.getType());
/* 177 */       field.setVisibility(oldField.getVisibility());
/* 178 */       commentGenerator.addFieldComment(field, introspectedTable);
/* 179 */       answer.add(field);
/*     */     }
/*     */ 
/* 182 */     return answer;
/*     */   }
/*     */ 
/*     */   public final List<Method> getMethodClones(CommentGenerator commentGenerator, IntrospectedTable introspectedTable)
/*     */   {
/* 188 */     configure();
/* 189 */     List answer = new ArrayList();
/* 190 */     for (Method oldMethod : this.methods) {
/* 191 */       Method method = new Method();
/*     */ 
/* 193 */       for (String bodyLine : oldMethod.getBodyLines()) {
/* 194 */         method.addBodyLine(bodyLine);
/*     */       }
/*     */ 
/* 197 */       for (FullyQualifiedJavaType fqjt : oldMethod.getExceptions()) {
/* 198 */         method.addException(fqjt);
/*     */       }
/*     */ 
/* 201 */       for (Parameter parm : oldMethod.getParameters()) {
/* 202 */         method.addParameter(parm);
/*     */       }
/*     */ 
/* 205 */       method.setConstructor(oldMethod.isConstructor());
/* 206 */       method.setFinal(oldMethod.isFinal());
/* 207 */       method.setStatic(oldMethod.isStatic());
/* 208 */       method.setName(oldMethod.getName());
/* 209 */       method.setReturnType(oldMethod.getReturnType());
/* 210 */       method.setVisibility(oldMethod.getVisibility());
/*     */ 
/* 212 */       commentGenerator.addGeneralMethodComment(method, introspectedTable);
/*     */ 
/* 214 */       answer.add(method);
/*     */     }
/*     */ 
/* 217 */     return answer;
/*     */   }
/*     */ 
/*     */   protected void setConstructorTemplate(Method constructorTemplate) {
/* 221 */     this.constructorTemplate = constructorTemplate;
/*     */   }
/*     */ 
/*     */   protected void setDeleteMethodTemplate(String deleteMethodTemplate) {
/* 225 */     this.deleteMethodTemplate = deleteMethodTemplate;
/*     */   }
/*     */ 
/*     */   protected void addField(Field field) {
/* 229 */     this.fields.add(field);
/*     */   }
/*     */ 
/*     */   protected void setInsertMethodTemplate(String insertMethodTemplate) {
/* 233 */     this.insertMethodTemplate = insertMethodTemplate;
/*     */   }
/*     */ 
/*     */   protected void addMethod(Method method) {
/* 237 */     this.methods.add(method);
/*     */   }
/*     */ 
/*     */   protected void setQueryForListMethodTemplate(String queryForListMethodTemplate)
/*     */   {
/* 242 */     this.queryForListMethodTemplate = queryForListMethodTemplate;
/*     */   }
/*     */ 
/*     */   protected void setQueryForObjectMethodTemplate(String queryForObjectMethodTemplate)
/*     */   {
/* 247 */     this.queryForObjectMethodTemplate = queryForObjectMethodTemplate;
/*     */   }
/*     */ 
/*     */   protected void setSuperClass(FullyQualifiedJavaType superClass) {
/* 251 */     this.superClass = superClass;
/*     */   }
/*     */ 
/*     */   protected void setUpdateMethodTemplate(String updateMethodTemplate) {
/* 255 */     this.updateMethodTemplate = updateMethodTemplate;
/*     */   }
/*     */ 
/*     */   protected void addInterfaceImport(FullyQualifiedJavaType type) {
/* 259 */     this.interfaceImports.add(type);
/*     */   }
/*     */ 
/*     */   protected void addImplementationImport(FullyQualifiedJavaType type) {
/* 263 */     this.implementationImports.add(type);
/*     */   }
/*     */ 
/*     */   protected void addCheckedException(FullyQualifiedJavaType type) {
/* 267 */     this.checkedExceptions.add(type);
/*     */   }
/*     */ 
/*     */   private void configure()
/*     */   {
/* 277 */     if (!this.configured) {
/* 278 */       configureCheckedExceptions();
/* 279 */       configureConstructorTemplate();
/* 280 */       configureDeleteMethodTemplate();
/* 281 */       configureFields();
/* 282 */       configureImplementationImports();
/* 283 */       configureInsertMethodTemplate();
/* 284 */       configureInterfaceImports();
/* 285 */       configureMethods();
/* 286 */       configureQueryForListMethodTemplate();
/* 287 */       configureQueryForObjectMethodTemplate();
/* 288 */       configureSuperClass();
/* 289 */       configureUpdateMethodTemplate();
/* 290 */       this.configured = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void configureCheckedExceptions()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void configureFields()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void configureImplementationImports()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void configureInterfaceImports()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void configureMethods()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void configureSuperClass()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected abstract void configureConstructorTemplate();
/*     */ 
/*     */   protected abstract void configureInsertMethodTemplate();
/*     */ 
/*     */   protected abstract void configureQueryForListMethodTemplate();
/*     */ 
/*     */   protected abstract void configureQueryForObjectMethodTemplate();
/*     */ 
/*     */   protected abstract void configureUpdateMethodTemplate();
/*     */ 
/*     */   protected abstract void configureDeleteMethodTemplate();
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate
 * JD-Core Version:    0.6.0
 */