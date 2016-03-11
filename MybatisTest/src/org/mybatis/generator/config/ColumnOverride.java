/*     */ package org.mybatis.generator.config;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class ColumnOverride extends PropertyHolder
/*     */ {
/*     */   private String columnName;
/*     */   private String javaProperty;
/*     */   private String jdbcType;
/*     */   private String javaType;
/*     */   private String typeHandler;
/*     */   private boolean isColumnNameDelimited;
/*     */   private String configuredDelimitedColumnName;
/*     */ 
/*     */   public ColumnOverride(String columnName)
/*     */   {
/*  50 */     this.columnName = columnName;
/*  51 */     this.isColumnNameDelimited = StringUtility.stringContainsSpace(columnName);
/*     */   }
/*     */ 
/*     */   public String getColumnName() {
/*  55 */     return this.columnName;
/*     */   }
/*     */ 
/*     */   public String getJavaProperty() {
/*  59 */     return this.javaProperty;
/*     */   }
/*     */ 
/*     */   public void setJavaProperty(String javaProperty) {
/*  63 */     this.javaProperty = javaProperty;
/*     */   }
/*     */ 
/*     */   public String getJavaType() {
/*  67 */     return this.javaType;
/*     */   }
/*     */ 
/*     */   public void setJavaType(String javaType) {
/*  71 */     this.javaType = javaType;
/*     */   }
/*     */ 
/*     */   public String getJdbcType() {
/*  75 */     return this.jdbcType;
/*     */   }
/*     */ 
/*     */   public void setJdbcType(String jdbcType) {
/*  79 */     this.jdbcType = jdbcType;
/*     */   }
/*     */ 
/*     */   public String getTypeHandler() {
/*  83 */     return this.typeHandler;
/*     */   }
/*     */ 
/*     */   public void setTypeHandler(String typeHandler) {
/*  87 */     this.typeHandler = typeHandler;
/*     */   }
/*     */ 
/*     */   public XmlElement toXmlElement() {
/*  91 */     XmlElement xmlElement = new XmlElement("columnOverride");
/*  92 */     xmlElement.addAttribute(new Attribute("column", this.columnName));
/*     */ 
/*  94 */     if (StringUtility.stringHasValue(this.javaProperty)) {
/*  95 */       xmlElement.addAttribute(new Attribute("property", this.javaProperty));
/*     */     }
/*     */ 
/*  98 */     if (StringUtility.stringHasValue(this.javaType)) {
/*  99 */       xmlElement.addAttribute(new Attribute("javaType", this.javaType));
/*     */     }
/*     */ 
/* 102 */     if (StringUtility.stringHasValue(this.jdbcType)) {
/* 103 */       xmlElement.addAttribute(new Attribute("jdbcType", this.jdbcType));
/*     */     }
/*     */ 
/* 106 */     if (StringUtility.stringHasValue(this.typeHandler)) {
/* 107 */       xmlElement.addAttribute(new Attribute("typeHandler", this.typeHandler));
/*     */     }
/*     */ 
/* 110 */     if (StringUtility.stringHasValue(this.configuredDelimitedColumnName)) {
/* 111 */       xmlElement.addAttribute(new Attribute("delimitedColumnName", this.configuredDelimitedColumnName));
/*     */     }
/*     */ 
/* 115 */     addPropertyXmlElements(xmlElement);
/*     */ 
/* 117 */     return xmlElement;
/*     */   }
/*     */ 
/*     */   public boolean isColumnNameDelimited() {
/* 121 */     return this.isColumnNameDelimited;
/*     */   }
/*     */ 
/*     */   public void setColumnNameDelimited(boolean isColumnNameDelimited) {
/* 125 */     this.isColumnNameDelimited = isColumnNameDelimited;
/*     */ 
/* 127 */     this.configuredDelimitedColumnName = (isColumnNameDelimited ? "true" : "false");
/*     */   }
/*     */ 
/*     */   public void validate(List<String> errors, String tableName) {
/* 131 */     if (!StringUtility.stringHasValue(this.columnName))
/* 132 */       errors.add(Messages.getString("ValidationError.22", tableName));
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.ColumnOverride
 * JD-Core Version:    0.6.0
 */