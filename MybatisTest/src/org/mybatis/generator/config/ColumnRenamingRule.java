/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class ColumnRenamingRule
/*    */ {
/*    */   private String searchString;
/*    */   private String replaceString;
/*    */ 
/*    */   public String getReplaceString()
/*    */   {
/* 61 */     return this.replaceString;
/*    */   }
/*    */ 
/*    */   public void setReplaceString(String replaceString) {
/* 65 */     this.replaceString = replaceString;
/*    */   }
/*    */ 
/*    */   public String getSearchString() {
/* 69 */     return this.searchString;
/*    */   }
/*    */ 
/*    */   public void setSearchString(String searchString) {
/* 73 */     this.searchString = searchString;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors, String tableName) {
/* 77 */     if (!StringUtility.stringHasValue(this.searchString))
/* 78 */       errors.add(Messages.getString("ValidationError.14", tableName));
/*    */   }
/*    */ 
/*    */   public XmlElement toXmlElement()
/*    */   {
/* 83 */     XmlElement xmlElement = new XmlElement("columnRenamingRule");
/* 84 */     xmlElement.addAttribute(new Attribute("searchString", this.searchString));
/*    */ 
/* 86 */     if (this.replaceString != null) {
/* 87 */       xmlElement.addAttribute(new Attribute("replaceString", this.replaceString));
/*    */     }
/*    */ 
/* 91 */     return xmlElement;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.ColumnRenamingRule
 * JD-Core Version:    0.6.0
 */