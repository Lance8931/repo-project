/*     */ package org.mybatis.generator.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.Document;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.exception.InvalidConfigurationException;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class Configuration
/*     */ {
/*     */   private List<Context> contexts;
/*     */   private List<String> classPathEntries;
/*     */ 
/*     */   public Configuration()
/*     */   {
/*  40 */     this.contexts = new ArrayList();
/*  41 */     this.classPathEntries = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void addClasspathEntry(String entry) {
/*  45 */     this.classPathEntries.add(entry);
/*     */   }
/*     */ 
/*     */   public List<String> getClassPathEntries()
/*     */   {
/*  52 */     return this.classPathEntries;
/*     */   }
/*     */ 
/*     */   public void validate()
/*     */     throws InvalidConfigurationException
/*     */   {
/*  63 */     List errors = new ArrayList();
/*     */ 
/*  65 */     for (String classPathEntry : this.classPathEntries) {
/*  66 */       if (!StringUtility.stringHasValue(classPathEntry)) {
/*  67 */         errors.add(Messages.getString("ValidationError.19"));
/*     */ 
/*  69 */         break;
/*     */       }
/*     */     }
/*     */ 
/*  73 */     if (this.contexts.size() == 0)
/*  74 */       errors.add(Messages.getString("ValidationError.11"));
/*     */     else {
/*  76 */       for (Context context : this.contexts) {
/*  77 */         context.validate(errors);
/*     */       }
/*     */     }
/*     */ 
/*  81 */     if (errors.size() > 0)
/*  82 */       throw new InvalidConfigurationException(errors);
/*     */   }
/*     */ 
/*     */   public List<Context> getContexts()
/*     */   {
/*  87 */     return this.contexts;
/*     */   }
/*     */ 
/*     */   public void addContext(Context context) {
/*  91 */     this.contexts.add(context);
/*     */   }
/*     */ 
/*     */   public Context getContext(String id) {
/*  95 */     for (Context context : this.contexts) {
/*  96 */       if (id.equals(context.getId())) {
/*  97 */         return context;
/*     */       }
/*     */     }
/*     */ 
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */   public Document toDocument()
/*     */   {
/* 114 */     Document document = new Document("-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN", "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd");
/*     */ 
/* 117 */     XmlElement rootElement = new XmlElement("generatorConfiguration");
/* 118 */     document.setRootElement(rootElement);
/*     */ 
/* 120 */     for (String classPathEntry : this.classPathEntries) {
/* 121 */       XmlElement cpeElement = new XmlElement("classPathEntry");
/* 122 */       cpeElement.addAttribute(new Attribute("location", classPathEntry));
/* 123 */       rootElement.addElement(cpeElement);
/*     */     }
/*     */ 
/* 126 */     for (Context context : this.contexts) {
/* 127 */       rootElement.addElement(context.toXmlElement());
/*     */     }
/*     */ 
/* 130 */     return document;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.Configuration
 * JD-Core Version:    0.6.0
 */