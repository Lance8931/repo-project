/*     */ package org.mybatis.generator.config;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.db.DatabaseDialects;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class GeneratedKey
/*     */ {
/*     */   private String column;
/*     */   private String configuredSqlStatement;
/*     */   private String runtimeSqlStatement;
/*     */   private boolean isIdentity;
/*     */   private String type;
/*     */ 
/*     */   public GeneratedKey(String column, String configuredSqlStatement, boolean isIdentity, String type)
/*     */   {
/*  49 */     this.column = column;
/*  50 */     this.type = type;
/*  51 */     this.isIdentity = isIdentity;
/*  52 */     this.configuredSqlStatement = configuredSqlStatement;
/*     */ 
/*  54 */     DatabaseDialects dialect = DatabaseDialects.getDatabaseDialect(configuredSqlStatement);
/*     */ 
/*  56 */     if (dialect == null)
/*  57 */       this.runtimeSqlStatement = configuredSqlStatement;
/*     */     else
/*  59 */       this.runtimeSqlStatement = dialect.getIdentityRetrievalStatement();
/*     */   }
/*     */ 
/*     */   public String getColumn()
/*     */   {
/*  64 */     return this.column;
/*     */   }
/*     */ 
/*     */   public boolean isIdentity() {
/*  68 */     return this.isIdentity;
/*     */   }
/*     */ 
/*     */   public String getRuntimeSqlStatement() {
/*  72 */     return this.runtimeSqlStatement;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  76 */     return this.type;
/*     */   }
/*     */ 
/*     */   public boolean isBeforeInsert()
/*     */   {
/*     */     boolean rc;
/*  81 */     if (StringUtility.stringHasValue(this.type)) {
/*  82 */       rc = true;
/*     */     }
/*     */     else
/*     */     {
/*  84 */       if (this.isIdentity)
/*  85 */         rc = false;
/*     */       else {
/*  87 */         rc = true;
/*     */       }
/*     */     }
/*     */ 
/*  91 */     return rc;
/*     */   }
/*     */ 
/*     */   public XmlElement toXmlElement() {
/*  95 */     XmlElement xmlElement = new XmlElement("generatedKey");
/*  96 */     xmlElement.addAttribute(new Attribute("column", this.column));
/*  97 */     xmlElement.addAttribute(new Attribute("sqlStatement", this.configuredSqlStatement));
/*     */ 
/*  99 */     xmlElement.addAttribute(new Attribute("type", this.type));
/* 100 */     xmlElement.addAttribute(new Attribute("identity", this.isIdentity ? "true" : "false"));
/*     */ 
/* 103 */     return xmlElement;
/*     */   }
/*     */ 
/*     */   public void validate(List<String> errors, String tableName) {
/* 107 */     if (!StringUtility.stringHasValue(this.runtimeSqlStatement)) {
/* 108 */       errors.add(Messages.getString("ValidationError.7", tableName));
/*     */     }
/*     */ 
/* 112 */     if ((StringUtility.stringHasValue(this.type)) && 
/* 113 */       (!"pre".equals(this.type)) && (!"post".equals(this.type)))
/* 114 */       errors.add(Messages.getString("ValidationError.15", tableName));
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.GeneratedKey
 * JD-Core Version:    0.6.0
 */