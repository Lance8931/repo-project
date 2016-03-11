/*     */ package org.mybatis.generator.codegen.ibatis2;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.GeneratedJavaFile;
/*     */ import org.mybatis.generator.api.GeneratedXmlFile;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.IntrospectedTable.TargetRuntime;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.xml.Document;
/*     */ import org.mybatis.generator.codegen.AbstractGenerator;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.AbstractXmlGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.DAOGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.GenericCIDAOTemplate;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.GenericSIDAOTemplate;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.IbatisDAOTemplate;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.SpringDAOTemplate;
/*     */ import org.mybatis.generator.codegen.ibatis2.model.BaseRecordGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.model.PrimaryKeyGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.model.RecordWithBLOBsGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.sqlmap.SqlMapGenerator;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class IntrospectedTableIbatis2Java2Impl extends IntrospectedTable
/*     */ {
/*     */   protected List<AbstractJavaGenerator> javaModelGenerators;
/*     */   protected List<AbstractJavaGenerator> daoGenerators;
/*     */   protected AbstractXmlGenerator sqlMapGenerator;
/*     */ 
/*     */   public IntrospectedTableIbatis2Java2Impl()
/*     */   {
/*  53 */     super(IntrospectedTable.TargetRuntime.IBATIS2);
/*  54 */     this.javaModelGenerators = new ArrayList();
/*  55 */     this.daoGenerators = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void calculateGenerators(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  61 */     calculateJavaModelGenerators(warnings, progressCallback);
/*  62 */     calculateDAOGenerators(warnings, progressCallback);
/*  63 */     calculateSqlMapGenerator(warnings, progressCallback);
/*     */   }
/*     */ 
/*     */   protected void calculateSqlMapGenerator(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  68 */     this.sqlMapGenerator = new SqlMapGenerator();
/*  69 */     initializeAbstractGenerator(this.sqlMapGenerator, warnings, progressCallback);
/*     */   }
/*     */ 
/*     */   protected void calculateDAOGenerators(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  74 */     if (this.context.getJavaClientGeneratorConfiguration() == null) {
/*  75 */       return;
/*     */     }
/*     */ 
/*  78 */     String type = this.context.getJavaClientGeneratorConfiguration().getConfigurationType();
/*     */     AbstractJavaGenerator javaGenerator;
/*  82 */     if ("IBATIS".equalsIgnoreCase(type)) {
/*  83 */       javaGenerator = new DAOGenerator(new IbatisDAOTemplate(), isJava5Targeted());
/*     */     }
/*     */     else
/*     */     {
/*  85 */       if ("SPRING".equalsIgnoreCase(type)) {
/*  86 */         javaGenerator = new DAOGenerator(new SpringDAOTemplate(), isJava5Targeted());
/*     */       }
/*     */       else
/*     */       {
/*  88 */         if ("GENERIC-CI".equalsIgnoreCase(type)) {
/*  89 */           javaGenerator = new DAOGenerator(new GenericCIDAOTemplate(), isJava5Targeted());
/*     */         }
/*     */         else
/*     */         {
/*  91 */           if ("GENERIC-SI".equalsIgnoreCase(type)) {
/*  92 */             javaGenerator = new DAOGenerator(new GenericSIDAOTemplate(), isJava5Targeted());
/*     */           }
/*     */           else
/*  95 */             javaGenerator = (AbstractJavaGenerator)ObjectFactory.createInternalObject(type);
/*     */         }
/*     */       }
/*     */     }
/*  99 */     initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/* 100 */     this.daoGenerators.add(javaGenerator);
/*     */   }
/*     */ 
/*     */   protected void calculateJavaModelGenerators(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/* 105 */     if (getRules().generateExampleClass()) {
/* 106 */       AbstractJavaGenerator javaGenerator = new ExampleGenerator(isJava5Targeted());
/*     */ 
/* 108 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 110 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */ 
/* 113 */     if (getRules().generatePrimaryKeyClass()) {
/* 114 */       AbstractJavaGenerator javaGenerator = new PrimaryKeyGenerator();
/* 115 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 117 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */ 
/* 120 */     if (getRules().generateBaseRecordClass()) {
/* 121 */       AbstractJavaGenerator javaGenerator = new BaseRecordGenerator();
/* 122 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 124 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */ 
/* 127 */     if (getRules().generateRecordWithBLOBsClass()) {
/* 128 */       AbstractJavaGenerator javaGenerator = new RecordWithBLOBsGenerator();
/* 129 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 131 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initializeAbstractGenerator(AbstractGenerator abstractGenerator, List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/* 138 */     abstractGenerator.setContext(this.context);
/* 139 */     abstractGenerator.setIntrospectedTable(this);
/* 140 */     abstractGenerator.setProgressCallback(progressCallback);
/* 141 */     abstractGenerator.setWarnings(warnings);
/*     */   }
/*     */ 
/*     */   public List<GeneratedJavaFile> getGeneratedJavaFiles()
/*     */   {
/* 146 */     List answer = new ArrayList();
/*     */ 
/* 148 */     for (AbstractJavaGenerator javaGenerator : this.javaModelGenerators) {
/* 149 */       List<CompilationUnit> compilationUnits = javaGenerator.getCompilationUnits();
/*     */ 
/* 151 */       for (CompilationUnit compilationUnit : compilationUnits) {
/* 152 */         GeneratedJavaFile gjf = new GeneratedJavaFile(compilationUnit, this.context.getJavaModelGeneratorConfiguration().getTargetProject());
/*     */ 
/* 155 */         answer.add(gjf);
/*     */       }
/*     */     }
/*     */ 
/* 159 */     for (AbstractJavaGenerator javaGenerator : this.daoGenerators) {
/* 160 */       List<CompilationUnit> compilationUnits = javaGenerator.getCompilationUnits();
/*     */ 
/* 162 */       for (CompilationUnit compilationUnit : compilationUnits) {
/* 163 */         GeneratedJavaFile gjf = new GeneratedJavaFile(compilationUnit, this.context.getJavaClientGeneratorConfiguration().getTargetProject());
/*     */ 
/* 166 */         answer.add(gjf);
/*     */       }
/*     */     }
/*     */ 
/* 170 */     return answer;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> getGeneratedXmlFiles()
/*     */   {
/* 175 */     List answer = new ArrayList();
/*     */ 
/* 177 */     Document document = this.sqlMapGenerator.getDocument();
/* 178 */     GeneratedXmlFile gxf = new GeneratedXmlFile(document, getIbatis2SqlMapFileName(), getIbatis2SqlMapPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), true);
/*     */ 
/* 182 */     if (this.context.getPlugins().sqlMapGenerated(gxf, this)) {
/* 183 */       answer.add(gxf);
/*     */     }
/*     */ 
/* 186 */     return answer;
/*     */   }
/*     */ 
/*     */   public boolean isJava5Targeted()
/*     */   {
/* 191 */     return false;
/*     */   }
/*     */ 
/*     */   public int getGenerationSteps()
/*     */   {
/* 196 */     return this.javaModelGenerators.size() + this.daoGenerators.size() + 1;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.IntrospectedTableIbatis2Java2Impl
 * JD-Core Version:    0.6.0
 */