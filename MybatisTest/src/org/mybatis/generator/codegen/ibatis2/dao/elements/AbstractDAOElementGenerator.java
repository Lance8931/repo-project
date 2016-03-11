/*     */ package org.mybatis.generator.codegen.ibatis2.dao.elements;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.DAOMethodNameCalculator;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractGenerator;
/*     */ import org.mybatis.generator.codegen.ibatis2.dao.templates.AbstractDAOTemplate;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*     */ import org.mybatis.generator.internal.DefaultDAOMethodNameCalculator;
/*     */ import org.mybatis.generator.internal.ExtendedDAOMethodNameCalculator;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public abstract class AbstractDAOElementGenerator extends AbstractGenerator
/*     */ {
/*     */   protected AbstractDAOTemplate daoTemplate;
/*     */   private DAOMethodNameCalculator dAOMethodNameCalculator;
/*     */   private JavaVisibility exampleMethodVisibility;
/*     */ 
/*     */   public abstract void addInterfaceElements(Interface paramInterface);
/*     */ 
/*     */   public abstract void addImplementationElements(TopLevelClass paramTopLevelClass);
/*     */ 
/*     */   public void setDAOTemplate(AbstractDAOTemplate abstractDAOTemplate)
/*     */   {
/*  49 */     this.daoTemplate = abstractDAOTemplate;
/*     */   }
/*     */ 
/*     */   public DAOMethodNameCalculator getDAOMethodNameCalculator() {
/*  53 */     if (this.dAOMethodNameCalculator == null) {
/*  54 */       String type = this.context.getJavaClientGeneratorConfiguration().getProperty("methodNameCalculator");
/*     */ 
/*  56 */       if (StringUtility.stringHasValue(type)) {
/*  57 */         if ("extended".equalsIgnoreCase(type))
/*  58 */           type = ExtendedDAOMethodNameCalculator.class.getName();
/*  59 */         else if ("default".equalsIgnoreCase(type))
/*  60 */           type = DefaultDAOMethodNameCalculator.class.getName();
/*     */       }
/*     */       else {
/*  63 */         type = DefaultDAOMethodNameCalculator.class.getName();
/*     */       }
/*     */       try
/*     */       {
/*  67 */         this.dAOMethodNameCalculator = ((DAOMethodNameCalculator)ObjectFactory.createInternalObject(type));
/*     */       }
/*     */       catch (Exception e) {
/*  70 */         this.dAOMethodNameCalculator = new DefaultDAOMethodNameCalculator();
/*  71 */         this.warnings.add(Messages.getString("Warning.17", type, e.getMessage()));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  76 */     return this.dAOMethodNameCalculator;
/*     */   }
/*     */ 
/*     */   public JavaVisibility getExampleMethodVisibility() {
/*  80 */     if (this.exampleMethodVisibility == null) {
/*  81 */       String type = this.context.getJavaClientGeneratorConfiguration().getProperty("exampleMethodVisibility");
/*     */ 
/*  84 */       if (StringUtility.stringHasValue(type)) {
/*  85 */         if ("public".equalsIgnoreCase(type)) {
/*  86 */           this.exampleMethodVisibility = JavaVisibility.PUBLIC;
/*  87 */         } else if ("private".equalsIgnoreCase(type)) {
/*  88 */           this.exampleMethodVisibility = JavaVisibility.PRIVATE;
/*  89 */         } else if ("protected".equalsIgnoreCase(type)) {
/*  90 */           this.exampleMethodVisibility = JavaVisibility.PROTECTED;
/*  91 */         } else if ("default".equalsIgnoreCase(type)) {
/*  92 */           this.exampleMethodVisibility = JavaVisibility.DEFAULT;
/*     */         } else {
/*  94 */           this.exampleMethodVisibility = JavaVisibility.PUBLIC;
/*  95 */           this.warnings.add(Messages.getString("Warning.16", type));
/*     */         }
/*     */       }
/*  98 */       else this.exampleMethodVisibility = JavaVisibility.PUBLIC;
/*     */ 
/*     */     }
/*     */ 
/* 102 */     return this.exampleMethodVisibility;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.dao.elements.AbstractDAOElementGenerator
 * JD-Core Version:    0.6.0
 */