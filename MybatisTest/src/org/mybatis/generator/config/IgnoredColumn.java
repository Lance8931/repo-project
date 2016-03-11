/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class IgnoredColumn
/*    */ {
/*    */   private String columnName;
/*    */   private boolean isColumnNameDelimited;
/*    */   private String configuredDelimitedColumnName;
/*    */ 
/*    */   public IgnoredColumn(String columnName)
/*    */   {
/* 43 */     this.columnName = columnName;
/* 44 */     this.isColumnNameDelimited = StringUtility.stringContainsSpace(columnName);
/*    */   }
/*    */ 
/*    */   public String getColumnName() {
/* 48 */     return this.columnName;
/*    */   }
/*    */ 
/*    */   public boolean isColumnNameDelimited() {
/* 52 */     return this.isColumnNameDelimited;
/*    */   }
/*    */ 
/*    */   public void setColumnNameDelimited(boolean isColumnNameDelimited) {
/* 56 */     this.isColumnNameDelimited = isColumnNameDelimited;
/* 57 */     this.configuredDelimitedColumnName = (isColumnNameDelimited ? "true" : "false");
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj) {
/* 61 */     if ((obj == null) || (!(obj instanceof IgnoredColumn))) {
/* 62 */       return false;
/*    */     }
/*    */ 
/* 65 */     return this.columnName.equals(((IgnoredColumn)obj).getColumnName());
/*    */   }
/*    */ 
/*    */   public int hashCode() {
/* 69 */     return this.columnName.hashCode();
/*    */   }
/*    */ 
/*    */   public XmlElement toXmlElement() {
/* 73 */     XmlElement xmlElement = new XmlElement("ignoreColumn");
/* 74 */     xmlElement.addAttribute(new Attribute("column", this.columnName));
/*    */ 
/* 76 */     if (StringUtility.stringHasValue(this.configuredDelimitedColumnName)) {
/* 77 */       xmlElement.addAttribute(new Attribute("delimitedColumnName", this.configuredDelimitedColumnName));
/*    */     }
/*    */ 
/* 81 */     return xmlElement;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors, String tableName) {
/* 85 */     if (!StringUtility.stringHasValue(this.columnName))
/* 86 */       errors.add(Messages.getString("ValidationError.21", tableName));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.IgnoredColumn
 * JD-Core Version:    0.6.0
 */