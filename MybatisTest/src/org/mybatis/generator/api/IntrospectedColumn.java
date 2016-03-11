/*     */ package org.mybatis.generator.api;
/*     */ 
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class IntrospectedColumn
/*     */ {
/*     */   protected String actualColumnName;
/*     */   protected int jdbcType;
/*     */   protected String jdbcTypeName;
/*     */   protected boolean nullable;
/*     */   protected int length;
/*     */   protected int scale;
/*     */   protected boolean identity;
/*     */   protected String javaProperty;
/*     */   protected FullyQualifiedJavaType fullyQualifiedJavaType;
/*     */   protected String tableAlias;
/*     */   protected String typeHandler;
/*     */   protected Context context;
/*     */   protected boolean isColumnNameDelimited;
/*     */   protected IntrospectedTable introspectedTable;
/*     */   protected Properties properties;
/*     */   protected String remarks;
/*     */   protected String defaultValue;
/*     */ 
/*     */   public IntrospectedColumn()
/*     */   {
/*  73 */     this.properties = new Properties();
/*     */   }
/*     */ 
/*     */   public int getJdbcType() {
/*  77 */     return this.jdbcType;
/*     */   }
/*     */ 
/*     */   public void setJdbcType(int jdbcType) {
/*  81 */     this.jdbcType = jdbcType;
/*     */   }
/*     */ 
/*     */   public int getLength() {
/*  85 */     return this.length;
/*     */   }
/*     */ 
/*     */   public void setLength(int length) {
/*  89 */     this.length = length;
/*     */   }
/*     */ 
/*     */   public boolean isNullable() {
/*  93 */     return this.nullable;
/*     */   }
/*     */ 
/*     */   public void setNullable(boolean nullable) {
/*  97 */     this.nullable = nullable;
/*     */   }
/*     */ 
/*     */   public int getScale() {
/* 101 */     return this.scale;
/*     */   }
/*     */ 
/*     */   public void setScale(int scale) {
/* 105 */     this.scale = scale;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 114 */     StringBuilder sb = new StringBuilder();
/*     */ 
/* 116 */     sb.append("Actual Column Name: ");
/* 117 */     sb.append(this.actualColumnName);
/* 118 */     sb.append(", JDBC Type: ");
/* 119 */     sb.append(this.jdbcType);
/* 120 */     sb.append(", Nullable: ");
/* 121 */     sb.append(this.nullable);
/* 122 */     sb.append(", Length: ");
/* 123 */     sb.append(this.length);
/* 124 */     sb.append(", Scale: ");
/* 125 */     sb.append(this.scale);
/* 126 */     sb.append(", Identity: ");
/* 127 */     sb.append(this.identity);
/*     */ 
/* 129 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public void setActualColumnName(String actualColumnName) {
/* 133 */     this.actualColumnName = actualColumnName;
/* 134 */     this.isColumnNameDelimited = StringUtility.stringContainsSpace(actualColumnName);
/*     */   }
/*     */ 
/*     */   public boolean isIdentity()
/*     */   {
/* 142 */     return this.identity;
/*     */   }
/*     */ 
/*     */   public void setIdentity(boolean identity)
/*     */   {
/* 150 */     this.identity = identity;
/*     */   }
/*     */ 
/*     */   public boolean isBLOBColumn() {
/* 154 */     String typeName = getJdbcTypeName();
/*     */ 
/* 156 */     return ("BINARY".equals(typeName)) || ("BLOB".equals(typeName)) || ("CLOB".equals(typeName)) || ("LONGVARBINARY".equals(typeName)) || ("LONGVARCHAR".equals(typeName)) || ("VARBINARY".equals(typeName));
/*     */   }
/*     */ 
/*     */   public boolean isStringColumn()
/*     */   {
/* 162 */     return this.fullyQualifiedJavaType.equals(FullyQualifiedJavaType.getStringInstance());
/*     */   }
/*     */ 
/*     */   public boolean isJdbcCharacterColumn()
/*     */   {
/* 167 */     return (this.jdbcType == 1) || (this.jdbcType == 2005) || (this.jdbcType == -1) || (this.jdbcType == 12);
/*     */   }
/*     */ 
/*     */   public String getJavaProperty()
/*     */   {
/* 172 */     return getJavaProperty(null);
/*     */   }
/*     */ 
/*     */   public String getJavaProperty(String prefix) {
/* 176 */     if (prefix == null) {
/* 177 */       return this.javaProperty;
/*     */     }
/*     */ 
/* 180 */     StringBuilder sb = new StringBuilder();
/* 181 */     sb.append(prefix);
/* 182 */     sb.append(this.javaProperty);
/*     */ 
/* 184 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public void setJavaProperty(String javaProperty) {
/* 188 */     this.javaProperty = javaProperty;
/*     */   }
/*     */ 
/*     */   public boolean isJDBCDateColumn() {
/* 192 */     return (this.fullyQualifiedJavaType.equals(FullyQualifiedJavaType.getDateInstance())) && ("DATE".equalsIgnoreCase(this.jdbcTypeName));
/*     */   }
/*     */ 
/*     */   public boolean isJDBCTimeColumn()
/*     */   {
/* 198 */     return (this.fullyQualifiedJavaType.equals(FullyQualifiedJavaType.getDateInstance())) && ("TIME".equalsIgnoreCase(this.jdbcTypeName));
/*     */   }
/*     */ 
/*     */   public String getTypeHandler()
/*     */   {
/* 204 */     return this.typeHandler;
/*     */   }
/*     */ 
/*     */   public void setTypeHandler(String typeHandler) {
/* 208 */     this.typeHandler = typeHandler;
/*     */   }
/*     */ 
/*     */   public String getActualColumnName() {
/* 212 */     return this.actualColumnName;
/*     */   }
/*     */ 
/*     */   public void setColumnNameDelimited(boolean isColumnNameDelimited) {
/* 216 */     this.isColumnNameDelimited = isColumnNameDelimited;
/*     */   }
/*     */ 
/*     */   public boolean isColumnNameDelimited() {
/* 220 */     return this.isColumnNameDelimited;
/*     */   }
/*     */ 
/*     */   public String getJdbcTypeName() {
/* 224 */     if (this.jdbcTypeName == null) {
/* 225 */       return "OTHER";
/*     */     }
/*     */ 
/* 228 */     return this.jdbcTypeName;
/*     */   }
/*     */ 
/*     */   public void setJdbcTypeName(String jdbcTypeName) {
/* 232 */     this.jdbcTypeName = jdbcTypeName;
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getFullyQualifiedJavaType() {
/* 236 */     return this.fullyQualifiedJavaType;
/*     */   }
/*     */ 
/*     */   public void setFullyQualifiedJavaType(FullyQualifiedJavaType fullyQualifiedJavaType)
/*     */   {
/* 241 */     this.fullyQualifiedJavaType = fullyQualifiedJavaType;
/*     */   }
/*     */ 
/*     */   public String getTableAlias() {
/* 245 */     return this.tableAlias;
/*     */   }
/*     */ 
/*     */   public void setTableAlias(String tableAlias) {
/* 249 */     this.tableAlias = tableAlias;
/*     */   }
/*     */ 
/*     */   public Context getContext() {
/* 253 */     return this.context;
/*     */   }
/*     */ 
/*     */   public void setContext(Context context) {
/* 257 */     this.context = context;
/*     */   }
/*     */ 
/*     */   public IntrospectedTable getIntrospectedTable() {
/* 261 */     return this.introspectedTable;
/*     */   }
/*     */ 
/*     */   public void setIntrospectedTable(IntrospectedTable introspectedTable) {
/* 265 */     this.introspectedTable = introspectedTable;
/*     */   }
/*     */ 
/*     */   public Properties getProperties() {
/* 269 */     return this.properties;
/*     */   }
/*     */ 
/*     */   public void setProperties(Properties properties) {
/* 273 */     this.properties.putAll(properties);
/*     */   }
/*     */ 
/*     */   public String getRemarks() {
/* 277 */     return this.remarks;
/*     */   }
/*     */ 
/*     */   public void setRemarks(String remarks) {
/* 281 */     this.remarks = remarks;
/*     */   }
/*     */ 
/*     */   public String getDefaultValue() {
/* 285 */     return this.defaultValue;
/*     */   }
/*     */ 
/*     */   public void setDefaultValue(String defaultValue) {
/* 289 */     this.defaultValue = defaultValue;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.IntrospectedColumn
 * JD-Core Version:    0.6.0
 */