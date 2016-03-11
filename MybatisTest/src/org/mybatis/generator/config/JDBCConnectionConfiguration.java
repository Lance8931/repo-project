/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class JDBCConnectionConfiguration extends PropertyHolder
/*    */ {
/*    */   private String driverClass;
/*    */   private String connectionURL;
/*    */   private String userId;
/*    */   private String password;
/*    */ 
/*    */   public String getConnectionURL()
/*    */   {
/* 44 */     return this.connectionURL;
/*    */   }
/*    */ 
/*    */   public void setConnectionURL(String connectionURL) {
/* 48 */     this.connectionURL = connectionURL;
/*    */   }
/*    */ 
/*    */   public String getPassword() {
/* 52 */     return this.password;
/*    */   }
/*    */ 
/*    */   public void setPassword(String password) {
/* 56 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public String getUserId() {
/* 60 */     return this.userId;
/*    */   }
/*    */ 
/*    */   public void setUserId(String userId) {
/* 64 */     this.userId = userId;
/*    */   }
/*    */ 
/*    */   public String getDriverClass() {
/* 68 */     return this.driverClass;
/*    */   }
/*    */ 
/*    */   public void setDriverClass(String driverClass) {
/* 72 */     this.driverClass = driverClass;
/*    */   }
/*    */ 
/*    */   public XmlElement toXmlElement() {
/* 76 */     XmlElement xmlElement = new XmlElement("jdbcConnection");
/* 77 */     xmlElement.addAttribute(new Attribute("driverClass", this.driverClass));
/* 78 */     xmlElement.addAttribute(new Attribute("connectionURL", this.connectionURL));
/*    */ 
/* 80 */     if (StringUtility.stringHasValue(this.userId)) {
/* 81 */       xmlElement.addAttribute(new Attribute("userId", this.userId));
/*    */     }
/*    */ 
/* 84 */     if (StringUtility.stringHasValue(this.password)) {
/* 85 */       xmlElement.addAttribute(new Attribute("password", this.password));
/*    */     }
/*    */ 
/* 88 */     addPropertyXmlElements(xmlElement);
/*    */ 
/* 90 */     return xmlElement;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors) {
/* 94 */     if (!StringUtility.stringHasValue(this.driverClass)) {
/* 95 */       errors.add(Messages.getString("ValidationError.4"));
/*    */     }
/*    */ 
/* 98 */     if (!StringUtility.stringHasValue(this.connectionURL))
/* 99 */       errors.add(Messages.getString("ValidationError.5"));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.JDBCConnectionConfiguration
 * JD-Core Version:    0.6.0
 */