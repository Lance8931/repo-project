/*     */ package org.mybatis.generator.internal.types;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.JavaTypeResolver;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class JavaTypeResolverDefaultImpl
/*     */   implements JavaTypeResolver
/*     */ {
/*     */   protected List<String> warnings;
/*     */   protected Properties properties;
/*     */   protected Context context;
/*     */   protected boolean forceBigDecimals;
/*     */   protected Map<Integer, JdbcTypeInformation> typeMap;
/*     */ 
/*     */   public JavaTypeResolverDefaultImpl()
/*     */   {
/*  51 */     this.properties = new Properties();
/*  52 */     this.typeMap = new HashMap();
/*     */ 
/*  54 */     this.typeMap.put(Integer.valueOf(2003), new JdbcTypeInformation("ARRAY", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  56 */     this.typeMap.put(Integer.valueOf(-5), new JdbcTypeInformation("BIGINT", new FullyQualifiedJavaType(Long.class.getName())));
/*     */ 
/*  58 */     this.typeMap.put(Integer.valueOf(-2), new JdbcTypeInformation("BINARY", new FullyQualifiedJavaType("byte[]")));
/*     */ 
/*  60 */     this.typeMap.put(Integer.valueOf(-7), new JdbcTypeInformation("BIT", new FullyQualifiedJavaType(Boolean.class.getName())));
/*     */ 
/*  62 */     this.typeMap.put(Integer.valueOf(2004), new JdbcTypeInformation("BLOB", new FullyQualifiedJavaType("byte[]")));
/*     */ 
/*  64 */     this.typeMap.put(Integer.valueOf(16), new JdbcTypeInformation("BOOLEAN", new FullyQualifiedJavaType(Boolean.class.getName())));
/*     */ 
/*  66 */     this.typeMap.put(Integer.valueOf(1), new JdbcTypeInformation("CHAR", new FullyQualifiedJavaType(String.class.getName())));
/*     */ 
/*  68 */     this.typeMap.put(Integer.valueOf(2005), new JdbcTypeInformation("CLOB", new FullyQualifiedJavaType(String.class.getName())));
/*     */ 
/*  70 */     this.typeMap.put(Integer.valueOf(70), new JdbcTypeInformation("DATALINK", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  72 */     this.typeMap.put(Integer.valueOf(91), new JdbcTypeInformation("DATE", new FullyQualifiedJavaType(Date.class.getName())));
/*     */ 
/*  74 */     this.typeMap.put(Integer.valueOf(2001), new JdbcTypeInformation("DISTINCT", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  76 */     this.typeMap.put(Integer.valueOf(8), new JdbcTypeInformation("DOUBLE", new FullyQualifiedJavaType(Double.class.getName())));
/*     */ 
/*  78 */     this.typeMap.put(Integer.valueOf(6), new JdbcTypeInformation("FLOAT", new FullyQualifiedJavaType(Double.class.getName())));
/*     */ 
/*  80 */     this.typeMap.put(Integer.valueOf(4), new JdbcTypeInformation("INTEGER", new FullyQualifiedJavaType(Integer.class.getName())));
/*     */ 
/*  82 */     this.typeMap.put(Integer.valueOf(2000), new JdbcTypeInformation("JAVA_OBJECT", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  84 */     this.typeMap.put(Integer.valueOf(-4), new JdbcTypeInformation("LONGVARBINARY", new FullyQualifiedJavaType("byte[]")));
/*     */ 
/*  87 */     this.typeMap.put(Integer.valueOf(-1), new JdbcTypeInformation("LONGVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
/*     */ 
/*  89 */     this.typeMap.put(Integer.valueOf(0), new JdbcTypeInformation("NULL", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  91 */     this.typeMap.put(Integer.valueOf(1111), new JdbcTypeInformation("OTHER", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  93 */     this.typeMap.put(Integer.valueOf(7), new JdbcTypeInformation("REAL", new FullyQualifiedJavaType(Float.class.getName())));
/*     */ 
/*  95 */     this.typeMap.put(Integer.valueOf(2006), new JdbcTypeInformation("REF", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/*  97 */     this.typeMap.put(Integer.valueOf(5), new JdbcTypeInformation("SMALLINT", new FullyQualifiedJavaType(Short.class.getName())));
/*     */ 
/*  99 */     this.typeMap.put(Integer.valueOf(2002), new JdbcTypeInformation("STRUCT", new FullyQualifiedJavaType(Object.class.getName())));
/*     */ 
/* 101 */     this.typeMap.put(Integer.valueOf(92), new JdbcTypeInformation("TIME", new FullyQualifiedJavaType(Date.class.getName())));
/*     */ 
/* 103 */     this.typeMap.put(Integer.valueOf(93), new JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(Date.class.getName())));
/*     */ 
/* 105 */     this.typeMap.put(Integer.valueOf(-6), new JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Byte.class.getName())));
/*     */ 
/* 107 */     this.typeMap.put(Integer.valueOf(-3), new JdbcTypeInformation("VARBINARY", new FullyQualifiedJavaType("byte[]")));
/*     */ 
/* 109 */     this.typeMap.put(Integer.valueOf(12), new JdbcTypeInformation("VARCHAR", new FullyQualifiedJavaType(String.class.getName())));
/*     */   }
/*     */ 
/*     */   public void addConfigurationProperties(Properties properties)
/*     */   {
/* 114 */     this.properties.putAll(properties);
/* 115 */     this.forceBigDecimals = StringUtility.isTrue(properties.getProperty("forceBigDecimals"));
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn)
/*     */   {
/* 123 */     JdbcTypeInformation jdbcTypeInformation = (JdbcTypeInformation)this.typeMap.get(Integer.valueOf(introspectedColumn.getJdbcType()));
/*     */     FullyQualifiedJavaType answer;
/* 126 */     if (jdbcTypeInformation == null)
/*     */     {
/* 127 */       switch (introspectedColumn.getJdbcType()) {
/*     */       case 2:
/*     */       case 3:
/* 130 */         if ((introspectedColumn.getScale() > 0) || (introspectedColumn.getLength() > 18) || (this.forceBigDecimals))
/*     */         {
/* 133 */           answer = new FullyQualifiedJavaType(BigDecimal.class.getName()); break;
/*     */         }
/* 135 */         if (introspectedColumn.getLength() > 9) {
/* 136 */           answer = new FullyQualifiedJavaType(Long.class.getName()); break;
/* 137 */         }if (introspectedColumn.getLength() > 4) {
/* 138 */           answer = new FullyQualifiedJavaType(Integer.class.getName()); break;
/*     */         }
/* 140 */         answer = new FullyQualifiedJavaType(Short.class.getName());
/*     */ 
/* 142 */         break;
/*     */       default:
/* 145 */         answer = null;
/* 146 */         break;
/*     */       }
/*     */     } else {
/* 149 */       answer = jdbcTypeInformation.getFullyQualifiedJavaType();
/*     */     }
/*     */ 
/* 152 */     return answer;
/*     */   }
/*     */ 
/*     */   public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn)
/*     */   {
/* 157 */     JdbcTypeInformation jdbcTypeInformation = (JdbcTypeInformation)this.typeMap.get(Integer.valueOf(introspectedColumn.getJdbcType()));
/*     */     String answer;
/* 160 */     if (jdbcTypeInformation == null)
/*     */     {
/* 161 */       switch (introspectedColumn.getJdbcType()) {
/*     */       case 3:
/* 163 */         answer = "DECIMAL";
/* 164 */         break;
/*     */       case 2:
/* 166 */         answer = "NUMERIC";
/* 167 */         break;
/*     */       default:
/* 169 */         answer = null;
/* 170 */         break;
/*     */       }
/*     */     } else {
/* 173 */       answer = jdbcTypeInformation.getJdbcTypeName();
/*     */     }
/*     */ 
/* 176 */     return answer;
/*     */   }
/*     */ 
/*     */   public void setWarnings(List<String> warnings) {
/* 180 */     this.warnings = warnings;
/*     */   }
/*     */ 
/*     */   public void setContext(Context context) {
/* 184 */     this.context = context;
/*     */   }
/*     */ 
/*     */   private static class JdbcTypeInformation {
/*     */     private String jdbcTypeName;
/*     */     private FullyQualifiedJavaType fullyQualifiedJavaType;
/*     */ 
/*     */     public JdbcTypeInformation(String jdbcTypeName, FullyQualifiedJavaType fullyQualifiedJavaType) {
/* 194 */       this.jdbcTypeName = jdbcTypeName;
/* 195 */       this.fullyQualifiedJavaType = fullyQualifiedJavaType;
/*     */     }
/*     */ 
/*     */     public String getJdbcTypeName() {
/* 199 */       return this.jdbcTypeName;
/*     */     }
/*     */ 
/*     */     public FullyQualifiedJavaType getFullyQualifiedJavaType() {
/* 203 */       return this.fullyQualifiedJavaType;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl
 * JD-Core Version:    0.6.0
 */