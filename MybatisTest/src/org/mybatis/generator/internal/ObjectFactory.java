/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.JavaTypeResolver;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.codegen.ibatis2.IntrospectedTableIbatis2Java2Impl;
/*     */ import org.mybatis.generator.codegen.ibatis2.IntrospectedTableIbatis2Java5Impl;
/*     */ import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;
/*     */ import org.mybatis.generator.config.CommentGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JavaTypeResolverConfiguration;
/*     */ import org.mybatis.generator.config.PluginConfiguration;
/*     */ import org.mybatis.generator.config.TableConfiguration;
/*     */ import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class ObjectFactory
/*     */ {
/*     */   private static ClassLoader externalClassLoader;
/*     */ 
/*     */   private static ClassLoader getClassLoader()
/*     */   {
/*  54 */     if (externalClassLoader != null) {
/*  55 */       return externalClassLoader;
/*     */     }
/*  57 */     return Thread.currentThread().getContextClassLoader();
/*     */   }
/*     */ 
/*     */   public static synchronized void setExternalClassLoader(ClassLoader classLoader)
/*     */   {
/*  63 */     externalClassLoader = classLoader;
/*     */   }
/*     */ 
/*     */   public static Class<?> externalClassForName(String type)
/*     */     throws ClassNotFoundException
/*     */   {
/*     */     Class clazz;
/*     */     try
/*     */     {
/*  82 */       clazz = getClassLoader().loadClass(type);
/*     */     }
/*     */     catch (Throwable e) {
/*  85 */       clazz = null;
/*     */     }
/*     */ 
/*  88 */     if (clazz == null) {
/*  89 */       clazz = Class.forName(type);
/*     */     }
/*     */ 
/*  92 */     return clazz;
/*     */   }
/*     */ 
/*     */   public static Object createExternalObject(String type) {
/*     */     Object answer;
/*     */     try {
/*  99 */       Class clazz = externalClassForName(type);
/*     */ 
/* 101 */       answer = clazz.newInstance();
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException(Messages.getString("RuntimeError.6", type), e);
/*     */     }
/*     */ 
/* 107 */     return answer;
/*     */   }
/*     */ 
/*     */   public static Class<?> internalClassForName(String type) throws ClassNotFoundException
/*     */   {
/* 112 */     Class clazz = null;
/*     */     try
/*     */     {
/* 115 */       ClassLoader cl = Thread.currentThread().getContextClassLoader();
/* 116 */       clazz = cl.loadClass(type);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/* 121 */     if (clazz == null) {
/* 122 */       clazz = Class.forName(type);
/*     */     }
/*     */ 
/* 125 */     return clazz;
/*     */   }
/*     */ 
/*     */   public static Object createInternalObject(String type) {
/*     */     Object answer;
/*     */     try {
/* 132 */       Class clazz = internalClassForName(type);
/*     */ 
/* 134 */       answer = clazz.newInstance();
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException(Messages.getString("RuntimeError.6", type), e);
/*     */     }
/*     */ 
/* 141 */     return answer;
/*     */   }
/*     */ 
/*     */   public static JavaTypeResolver createJavaTypeResolver(Context context, List<String> warnings)
/*     */   {
/* 146 */     JavaTypeResolverConfiguration config = context.getJavaTypeResolverConfiguration();
/*     */     String type;
/* 150 */     if ((config != null) && (config.getConfigurationType() != null)) {
/* 151 */       type = config.getConfigurationType();
/* 152 */       if ("DEFAULT".equalsIgnoreCase(type))
/* 153 */         type = JavaTypeResolverDefaultImpl.class.getName();
/*     */     }
/*     */     else {
/* 156 */       type = JavaTypeResolverDefaultImpl.class.getName();
/*     */     }
/*     */ 
/* 159 */     JavaTypeResolver answer = (JavaTypeResolver)createInternalObject(type);
/* 160 */     answer.setWarnings(warnings);
/*     */ 
/* 162 */     if (config != null) {
/* 163 */       answer.addConfigurationProperties(config.getProperties());
/*     */     }
/*     */ 
/* 166 */     answer.setContext(context);
/*     */ 
/* 168 */     return answer;
/*     */   }
/*     */ 
/*     */   public static Plugin createPlugin(Context context, PluginConfiguration pluginConfiguration)
/*     */   {
/* 173 */     Plugin plugin = (Plugin)createInternalObject(pluginConfiguration.getConfigurationType());
/*     */ 
/* 175 */     plugin.setContext(context);
/* 176 */     plugin.setProperties(pluginConfiguration.getProperties());
/* 177 */     return plugin;
/*     */   }
/*     */ 
/*     */   public static CommentGenerator createCommentGenerator(Context context)
/*     */   {
/* 182 */     CommentGeneratorConfiguration config = context.getCommentGeneratorConfiguration();
/*     */     String type;
/* 187 */     if ((config == null) || (config.getConfigurationType() == null))
/* 188 */       type = DefaultCommentGenerator.class.getName();
/*     */     else {
/* 190 */       type = config.getConfigurationType();
/*     */     }
/*     */ 
/* 193 */     CommentGenerator answer = (CommentGenerator)createInternalObject(type);
/*     */ 
/* 195 */     if (config != null) {
/* 196 */       answer.addConfigurationProperties(config.getProperties());
/*     */     }
/*     */ 
/* 199 */     return answer;
/*     */   }
/*     */ 
/*     */   public static IntrospectedTable createIntrospectedTable(TableConfiguration tableConfiguration, FullyQualifiedTable table, Context context)
/*     */   {
/* 206 */     String type = context.getTargetRuntime();
/* 207 */     if (!StringUtility.stringHasValue(type))
/* 208 */       type = IntrospectedTableMyBatis3Impl.class.getName();
/* 209 */     else if ("Ibatis2Java2".equalsIgnoreCase(type))
/* 210 */       type = IntrospectedTableIbatis2Java2Impl.class.getName();
/* 211 */     else if ("Ibatis2Java5".equalsIgnoreCase(type))
/* 212 */       type = IntrospectedTableIbatis2Java5Impl.class.getName();
/* 213 */     else if ("Ibatis3".equalsIgnoreCase(type))
/* 214 */       type = IntrospectedTableMyBatis3Impl.class.getName();
/* 215 */     else if ("MyBatis3".equalsIgnoreCase(type)) {
/* 216 */       type = IntrospectedTableMyBatis3Impl.class.getName();
/*     */     }
/*     */ 
/* 219 */     IntrospectedTable answer = (IntrospectedTable)createInternalObject(type);
/* 220 */     answer.setFullyQualifiedTable(table);
/* 221 */     answer.setContext(context);
/* 222 */     answer.setTableConfiguration(tableConfiguration);
/*     */ 
/* 224 */     return answer;
/*     */   }
/*     */ 
/*     */   public static IntrospectedColumn createIntrospectedColumn(Context context) {
/* 228 */     String type = context.getIntrospectedColumnImpl();
/* 229 */     if (!StringUtility.stringHasValue(type)) {
/* 230 */       type = IntrospectedColumn.class.getName();
/*     */     }
/*     */ 
/* 233 */     IntrospectedColumn answer = (IntrospectedColumn)createInternalObject(type);
/* 234 */     answer.setContext(context);
/*     */ 
/* 236 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.ObjectFactory
 * JD-Core Version:    0.6.0
 */