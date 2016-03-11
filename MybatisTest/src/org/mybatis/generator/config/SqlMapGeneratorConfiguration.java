/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class SqlMapGeneratorConfiguration extends PropertyHolder
/*    */ {
/*    */   private String targetPackage;
/*    */   private String targetProject;
/*    */ 
/*    */   public String getTargetProject()
/*    */   {
/* 41 */     return this.targetProject;
/*    */   }
/*    */ 
/*    */   public void setTargetProject(String targetProject) {
/* 45 */     this.targetProject = targetProject;
/*    */   }
/*    */ 
/*    */   public String getTargetPackage() {
/* 49 */     return this.targetPackage;
/*    */   }
/*    */ 
/*    */   public void setTargetPackage(String targetPackage) {
/* 53 */     this.targetPackage = targetPackage;
/*    */   }
/*    */ 
/*    */   public XmlElement toXmlElement() {
/* 57 */     XmlElement answer = new XmlElement("sqlMapGenerator");
/*    */ 
/* 59 */     if (this.targetPackage != null) {
/* 60 */       answer.addAttribute(new Attribute("targetPackage", this.targetPackage));
/*    */     }
/*    */ 
/* 63 */     if (this.targetProject != null) {
/* 64 */       answer.addAttribute(new Attribute("targetProject", this.targetProject));
/*    */     }
/*    */ 
/* 67 */     addPropertyXmlElements(answer);
/*    */ 
/* 69 */     return answer;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors, String contextId) {
/* 73 */     if (!StringUtility.stringHasValue(this.targetProject)) {
/* 74 */       errors.add(Messages.getString("ValidationError.1", contextId));
/*    */     }
/*    */ 
/* 77 */     if (!StringUtility.stringHasValue(this.targetPackage))
/* 78 */       errors.add(Messages.getString("ValidationError.12", "SQLMapGenerator", contextId));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.SqlMapGeneratorConfiguration
 * JD-Core Version:    0.6.0
 */