/*     */ package org.mybatis.generator.api;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.api.dom.xml.Document;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.config.Context;
/*     */ 
/*     */ public abstract class PluginAdapter
/*     */   implements Plugin
/*     */ {
/*     */   protected Context context;
/*     */   protected Properties properties;
/*     */ 
/*     */   public PluginAdapter()
/*     */   {
/*  45 */     this.properties = new Properties();
/*     */   }
/*     */ 
/*     */   public Context getContext() {
/*  49 */     return this.context;
/*     */   }
/*     */ 
/*     */   public void setContext(Context context) {
/*  53 */     this.context = context;
/*     */   }
/*     */ 
/*     */   public Properties getProperties() {
/*  57 */     return this.properties;
/*     */   }
/*     */ 
/*     */   public void setProperties(Properties properties) {
/*  61 */     this.properties.putAll(properties);
/*     */   }
/*     */ 
/*     */   public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles() {
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */   public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable)
/*     */   {
/*  70 */     return null;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles() {
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable)
/*     */   {
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientCountByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 140 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 165 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 170 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 175 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 180 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 185 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 195 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 200 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 205 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 222 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 227 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType)
/*     */   {
/* 234 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType)
/*     */   {
/* 241 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 246 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 251 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType)
/*     */   {
/* 258 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapResultMapWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 268 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 273 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 278 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable)
/*     */   {
/* 283 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 288 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable)
/*     */   {
/* 293 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 298 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 303 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 308 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 313 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 318 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 333 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 338 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 343 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 348 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 353 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 358 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 363 */     return true;
/*     */   }
/*     */ 
/*     */   public void initialized(IntrospectedTable introspectedTable)
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
/* 371 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapBlobColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 376 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.PluginAdapter
 * JD-Core Version:    0.6.0
 */