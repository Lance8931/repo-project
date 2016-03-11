/*     */ package org.mybatis.generator.codegen.mybatis3;
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
/*     */ import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.model.BaseRecordGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.model.ExampleGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.model.PrimaryKeyGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.model.RecordWithBLOBsGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ 
/*     */ public class IntrospectedTableMyBatis3Impl extends IntrospectedTable
/*     */ {
/*     */   protected List<AbstractJavaGenerator> javaModelGenerators;
/*     */   protected List<AbstractJavaGenerator> daoGenerators;
/*     */   protected AbstractXmlGenerator xmlMapperGenerator;
/*     */ 
/*     */   public IntrospectedTableMyBatis3Impl()
/*     */   {
/*  49 */     super(IntrospectedTable.TargetRuntime.MYBATIS3);
/*  50 */     this.javaModelGenerators = new ArrayList();
/*  51 */     this.daoGenerators = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void calculateGenerators(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  57 */     calculateJavaModelGenerators(warnings, progressCallback);
/*  58 */     calculateDAOGenerators(warnings, progressCallback);
/*  59 */     calculateXmlMapperGenerator(warnings, progressCallback);
/*     */   }
/*     */ 
/*     */   protected void calculateXmlMapperGenerator(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  64 */     this.xmlMapperGenerator = new XMLMapperGenerator();
/*  65 */     initializeAbstractGenerator(this.xmlMapperGenerator, warnings, progressCallback);
/*     */   }
/*     */ 
/*     */   protected void calculateDAOGenerators(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  71 */     if (this.context.getJavaClientGeneratorConfiguration() == null) {
/*  72 */       return;
/*     */     }
/*     */ 
/*  75 */     String type = this.context.getJavaClientGeneratorConfiguration().getConfigurationType();
/*     */     AbstractJavaGenerator javaGenerator;
/*  79 */     if ("XMLMAPPER".equalsIgnoreCase(type)) {
/*  80 */       javaGenerator = new JavaMapperGenerator();
/*     */     }
/*     */     else
/*     */     {
/*  81 */       if ("MAPPER".equalsIgnoreCase(type))
/*  82 */         javaGenerator = new JavaMapperGenerator();
/*     */       else {
/*  84 */         javaGenerator = (AbstractJavaGenerator)ObjectFactory.createInternalObject(type);
/*     */       }
/*     */     }
/*     */ 
/*  88 */     initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*  89 */     this.daoGenerators.add(javaGenerator);
/*     */   }
/*     */ 
/*     */   protected void calculateJavaModelGenerators(List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/*  94 */     if (getRules().generateExampleClass()) {
/*  95 */       AbstractJavaGenerator javaGenerator = new ExampleGenerator();
/*  96 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/*  98 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */ 
/* 101 */     if (getRules().generatePrimaryKeyClass()) {
/* 102 */       AbstractJavaGenerator javaGenerator = new PrimaryKeyGenerator();
/* 103 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 105 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */ 
/* 108 */     if (getRules().generateBaseRecordClass()) {
/* 109 */       AbstractJavaGenerator javaGenerator = new BaseRecordGenerator();
/* 110 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 112 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */ 
/* 115 */     if (getRules().generateRecordWithBLOBsClass()) {
/* 116 */       AbstractJavaGenerator javaGenerator = new RecordWithBLOBsGenerator();
/* 117 */       initializeAbstractGenerator(javaGenerator, warnings, progressCallback);
/*     */ 
/* 119 */       this.javaModelGenerators.add(javaGenerator);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void initializeAbstractGenerator(AbstractGenerator abstractGenerator, List<String> warnings, ProgressCallback progressCallback)
/*     */   {
/* 126 */     abstractGenerator.setContext(this.context);
/* 127 */     abstractGenerator.setIntrospectedTable(this);
/* 128 */     abstractGenerator.setProgressCallback(progressCallback);
/* 129 */     abstractGenerator.setWarnings(warnings);
/*     */   }
/*     */ 
/*     */   public List<GeneratedJavaFile> getGeneratedJavaFiles()
/*     */   {
/* 134 */     List answer = new ArrayList();
/*     */ 
/* 136 */     for (AbstractJavaGenerator javaGenerator : this.javaModelGenerators) {
/* 137 */       List<CompilationUnit> compilationUnits = javaGenerator.getCompilationUnits();
/*     */ 
/* 139 */       for (CompilationUnit compilationUnit : compilationUnits) {
/* 140 */         GeneratedJavaFile gjf = new GeneratedJavaFile(compilationUnit, this.context.getJavaModelGeneratorConfiguration().getTargetProject());
/*     */ 
/* 143 */         answer.add(gjf);
/*     */       }
/*     */     }
/*     */ 
/* 147 */     for (AbstractJavaGenerator javaGenerator : this.daoGenerators) {
/* 148 */       List<CompilationUnit> compilationUnits = javaGenerator.getCompilationUnits();
/*     */ 
/* 150 */       for (CompilationUnit compilationUnit : compilationUnits) {
/* 151 */         GeneratedJavaFile gjf = new GeneratedJavaFile(compilationUnit, this.context.getJavaClientGeneratorConfiguration().getTargetProject());
/*     */ 
/* 154 */         answer.add(gjf);
/*     */       }
/*     */     }
/*     */ 
/* 158 */     return answer;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> getGeneratedXmlFiles()
/*     */   {
/* 163 */     List answer = new ArrayList();
/*     */ 
/* 165 */     Document document = this.xmlMapperGenerator.getDocument();
/* 166 */     GeneratedXmlFile gxf = new GeneratedXmlFile(document, getMyBatis3XmlMapperFileName(), getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), true);
/*     */ 
/* 170 */     if (this.context.getPlugins().sqlMapGenerated(gxf, this)) {
/* 171 */       answer.add(gxf);
/*     */     }
/*     */ 
/* 174 */     return answer;
/*     */   }
/*     */ 
/*     */   public int getGenerationSteps()
/*     */   {
/* 179 */     return this.javaModelGenerators.size() + this.daoGenerators.size() + 1;
/*     */   }
/*     */ 
/*     */   public boolean isJava5Targeted()
/*     */   {
/* 186 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl
 * JD-Core Version:    0.6.0
 */