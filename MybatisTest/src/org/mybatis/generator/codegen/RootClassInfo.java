/*     */ package org.mybatis.generator.codegen;
/*     */ 
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class RootClassInfo
/*     */ {
/*  40 */   private static Map<String, RootClassInfo> rootClassInfoMap = Collections.synchronizedMap(new HashMap());
/*     */   private PropertyDescriptor[] propertyDescriptors;
/*     */   private String className;
/*     */   private List<String> warnings;
/*     */ 
/*     */   public static RootClassInfo getInstance(String className, List<String> warnings)
/*     */   {
/*  46 */     RootClassInfo classInfo = (RootClassInfo)rootClassInfoMap.get(className);
/*  47 */     if (classInfo == null) {
/*  48 */       classInfo = new RootClassInfo(className, warnings);
/*  49 */       rootClassInfoMap.put(className, classInfo);
/*     */     }
/*     */ 
/*  52 */     return classInfo;
/*     */   }
/*     */ 
/*     */   private RootClassInfo(String className, List<String> warnings)
/*     */   {
/*  61 */     this.className = className;
/*  62 */     this.warnings = warnings;
/*     */ 
/*  64 */     if (className == null) {
/*  65 */       return;
/*     */     }
/*     */     try
/*     */     {
/*  69 */       Class clazz = ObjectFactory.externalClassForName(className);
/*  70 */       BeanInfo bi = Introspector.getBeanInfo(clazz);
/*  71 */       this.propertyDescriptors = bi.getPropertyDescriptors();
/*     */     } catch (Exception e) {
/*  73 */       this.propertyDescriptors = null;
/*  74 */       warnings.add(Messages.getString("Warning.20", className));
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean containsProperty(IntrospectedColumn introspectedColumn) {
/*  79 */     if (this.propertyDescriptors == null) {
/*  80 */       return false;
/*     */     }
/*     */ 
/*  83 */     boolean found = false;
/*  84 */     String propertyName = introspectedColumn.getJavaProperty();
/*  85 */     String propertyType = introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName();
/*     */ 
/*  90 */     for (int i = 0; i < this.propertyDescriptors.length; i++) {
/*  91 */       PropertyDescriptor propertyDescriptor = this.propertyDescriptors[i];
/*     */ 
/*  93 */       if (!propertyDescriptor.getName().equals(propertyName))
/*     */       {
/*     */         continue;
/*     */       }
/*  97 */       if (!propertyDescriptor.getPropertyType().getName().equals(propertyType))
/*     */       {
/*  99 */         this.warnings.add(Messages.getString("Warning.21", propertyName, this.className, propertyType));
/*     */ 
/* 101 */         break;
/*     */       }
/*     */ 
/* 105 */       if (propertyDescriptor.getReadMethod() == null) {
/* 106 */         this.warnings.add(Messages.getString("Warning.22", propertyName, this.className));
/*     */ 
/* 108 */         break;
/*     */       }
/*     */ 
/* 112 */       if (propertyDescriptor.getWriteMethod() == null) {
/* 113 */         this.warnings.add(Messages.getString("Warning.23", propertyName, this.className));
/*     */ 
/* 115 */         break;
/*     */       }
/*     */ 
/* 118 */       found = true;
/* 119 */       break;
/*     */     }
/*     */ 
/* 123 */     return found;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.RootClassInfo
 * JD-Core Version:    0.6.0
 */