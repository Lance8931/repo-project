/*     */ package org.mybatis.generator.api;
/*     */ 
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.EqualsUtil;
/*     */ import org.mybatis.generator.internal.util.HashCodeUtil;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class FullyQualifiedTable
/*     */ {
/*     */   private String introspectedCatalog;
/*     */   private String introspectedSchema;
/*     */   private String introspectedTableName;
/*     */   private String runtimeCatalog;
/*     */   private String runtimeSchema;
/*     */   private String runtimeTableName;
/*     */   private String domainObjectName;
/*     */   private String alias;
/*     */   private boolean ignoreQualifiersAtRuntime;
/*     */   private String beginningDelimiter;
/*     */   private String endingDelimiter;
/*     */ 
/*     */   public FullyQualifiedTable(String introspectedCatalog, String introspectedSchema, String introspectedTableName, String domainObjectName, String alias, boolean ignoreQualifiersAtRuntime, String runtimeCatalog, String runtimeSchema, String runtimeTableName, boolean delimitIdentifiers, Context context)
/*     */   {
/* 117 */     this.introspectedCatalog = introspectedCatalog;
/* 118 */     this.introspectedSchema = introspectedSchema;
/* 119 */     this.introspectedTableName = introspectedTableName;
/* 120 */     this.domainObjectName = domainObjectName;
/* 121 */     this.ignoreQualifiersAtRuntime = ignoreQualifiersAtRuntime;
/* 122 */     this.runtimeCatalog = runtimeCatalog;
/* 123 */     this.runtimeSchema = runtimeSchema;
/* 124 */     this.runtimeTableName = runtimeTableName;
/*     */ 
/* 126 */     if (alias == null)
/* 127 */       this.alias = null;
/*     */     else {
/* 129 */       this.alias = alias.trim();
/*     */     }
/*     */ 
/* 132 */     this.beginningDelimiter = (delimitIdentifiers ? context.getBeginningDelimiter() : "");
/*     */ 
/* 134 */     this.endingDelimiter = (delimitIdentifiers ? context.getEndingDelimiter() : "");
/*     */   }
/*     */ 
/*     */   public String getIntrospectedCatalog()
/*     */   {
/* 139 */     return this.introspectedCatalog;
/*     */   }
/*     */ 
/*     */   public String getIntrospectedSchema() {
/* 143 */     return this.introspectedSchema;
/*     */   }
/*     */ 
/*     */   public String getIntrospectedTableName() {
/* 147 */     return this.introspectedTableName;
/*     */   }
/*     */ 
/*     */   public String getFullyQualifiedTableNameAtRuntime()
/*     */   {
/* 154 */     StringBuilder localCatalog = new StringBuilder();
/* 155 */     if (!this.ignoreQualifiersAtRuntime) {
/* 156 */       if (StringUtility.stringHasValue(this.runtimeCatalog))
/* 157 */         localCatalog.append(this.runtimeCatalog);
/* 158 */       else if (StringUtility.stringHasValue(this.introspectedCatalog)) {
/* 159 */         localCatalog.append(this.introspectedCatalog);
/*     */       }
/*     */     }
/* 162 */     if (localCatalog.length() > 0) {
/* 163 */       addDelimiters(localCatalog);
/*     */     }
/*     */ 
/* 166 */     StringBuilder localSchema = new StringBuilder();
/* 167 */     if (!this.ignoreQualifiersAtRuntime) {
/* 168 */       if (StringUtility.stringHasValue(this.runtimeSchema))
/* 169 */         localSchema.append(this.runtimeSchema);
/* 170 */       else if (StringUtility.stringHasValue(this.introspectedSchema)) {
/* 171 */         localSchema.append(this.introspectedSchema);
/*     */       }
/*     */     }
/* 174 */     if (localSchema.length() > 0) {
/* 175 */       addDelimiters(localSchema);
/*     */     }
/*     */ 
/* 178 */     StringBuilder localTableName = new StringBuilder();
/* 179 */     if (StringUtility.stringHasValue(this.runtimeTableName))
/* 180 */       localTableName.append(this.runtimeTableName);
/*     */     else {
/* 182 */       localTableName.append(this.introspectedTableName);
/*     */     }
/* 184 */     addDelimiters(localTableName);
/*     */ 
/* 186 */     return StringUtility.composeFullyQualifiedTableName(localCatalog.toString(), localSchema.toString(), localTableName.toString(), '.');
/*     */   }
/*     */ 
/*     */   public String getAliasedFullyQualifiedTableNameAtRuntime()
/*     */   {
/* 195 */     StringBuilder sb = new StringBuilder();
/*     */ 
/* 197 */     sb.append(getFullyQualifiedTableNameAtRuntime());
/*     */ 
/* 199 */     if (StringUtility.stringHasValue(this.alias)) {
/* 200 */       sb.append(' ');
/* 201 */       sb.append(this.alias);
/*     */     }
/*     */ 
/* 204 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String getIbatis2SqlMapNamespace()
/*     */   {
/* 214 */     String localCatalog = StringUtility.stringHasValue(this.runtimeCatalog) ? this.runtimeCatalog : this.introspectedCatalog;
/*     */ 
/* 216 */     String localSchema = StringUtility.stringHasValue(this.runtimeSchema) ? this.runtimeSchema : this.introspectedSchema;
/*     */ 
/* 218 */     String localTable = StringUtility.stringHasValue(this.runtimeTableName) ? this.runtimeTableName : this.introspectedTableName;
/*     */ 
/* 221 */     return StringUtility.composeFullyQualifiedTableName(this.ignoreQualifiersAtRuntime ? null : localCatalog, this.ignoreQualifiersAtRuntime ? null : localSchema, localTable, '_');
/*     */   }
/*     */ 
/*     */   public String getDomainObjectName()
/*     */   {
/* 229 */     if (StringUtility.stringHasValue(this.domainObjectName))
/* 230 */       return this.domainObjectName;
/* 231 */     if (StringUtility.stringHasValue(this.runtimeTableName)) {
/* 232 */       return JavaBeansUtil.getCamelCaseString(this.runtimeTableName, true);
/*     */     }
/* 234 */     return JavaBeansUtil.getCamelCaseString(this.introspectedTableName, true);
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 241 */     if (this == obj) {
/* 242 */       return true;
/*     */     }
/*     */ 
/* 245 */     if (!(obj instanceof FullyQualifiedTable)) {
/* 246 */       return false;
/*     */     }
/*     */ 
/* 249 */     FullyQualifiedTable other = (FullyQualifiedTable)obj;
/*     */ 
/* 251 */     return (EqualsUtil.areEqual(this.introspectedTableName, other.introspectedTableName)) && (EqualsUtil.areEqual(this.introspectedCatalog, other.introspectedCatalog)) && (EqualsUtil.areEqual(this.introspectedSchema, other.introspectedSchema));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 261 */     int result = 23;
/* 262 */     result = HashCodeUtil.hash(result, this.introspectedTableName);
/* 263 */     result = HashCodeUtil.hash(result, this.introspectedCatalog);
/* 264 */     result = HashCodeUtil.hash(result, this.introspectedSchema);
/*     */ 
/* 266 */     return result;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 271 */     return StringUtility.composeFullyQualifiedTableName(this.introspectedCatalog, this.introspectedSchema, this.introspectedTableName, '.');
/*     */   }
/*     */ 
/*     */   public String getAlias()
/*     */   {
/* 277 */     return this.alias;
/*     */   }
/*     */ 
/*     */   public String getSubPackage()
/*     */   {
/* 287 */     StringBuilder sb = new StringBuilder();
/* 288 */     if (!this.ignoreQualifiersAtRuntime) {
/* 289 */       if (StringUtility.stringHasValue(this.runtimeCatalog)) {
/* 290 */         sb.append('.');
/* 291 */         sb.append(this.runtimeCatalog.toLowerCase());
/* 292 */       } else if (StringUtility.stringHasValue(this.introspectedCatalog)) {
/* 293 */         sb.append('.');
/* 294 */         sb.append(this.introspectedCatalog.toLowerCase());
/*     */       }
/*     */ 
/* 297 */       if (StringUtility.stringHasValue(this.runtimeSchema)) {
/* 298 */         sb.append('.');
/* 299 */         sb.append(this.runtimeSchema.toLowerCase());
/* 300 */       } else if (StringUtility.stringHasValue(this.introspectedSchema)) {
/* 301 */         sb.append('.');
/* 302 */         sb.append(this.introspectedSchema.toLowerCase());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 307 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   private void addDelimiters(StringBuilder sb) {
/* 311 */     if (StringUtility.stringHasValue(this.beginningDelimiter)) {
/* 312 */       sb.insert(0, this.beginningDelimiter);
/*     */     }
/*     */ 
/* 315 */     if (StringUtility.stringHasValue(this.endingDelimiter))
/* 316 */       sb.append(this.endingDelimiter);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.FullyQualifiedTable
 * JD-Core Version:    0.6.0
 */