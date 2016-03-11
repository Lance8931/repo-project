/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class JavaClientGeneratorConfiguration extends TypedPropertyHolder
/*    */ {
/*    */   private String targetPackage;
/*    */   private String implementationPackage;
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
/* 57 */     XmlElement answer = new XmlElement("javaClientGenerator");
/* 58 */     if (getConfigurationType() != null) {
/* 59 */       answer.addAttribute(new Attribute("type", getConfigurationType()));
/*    */     }
/*    */ 
/* 62 */     if (this.targetPackage != null) {
/* 63 */       answer.addAttribute(new Attribute("targetPackage", this.targetPackage));
/*    */     }
/*    */ 
/* 66 */     if (this.targetProject != null) {
/* 67 */       answer.addAttribute(new Attribute("targetProject", this.targetProject));
/*    */     }
/*    */ 
/* 70 */     if (this.implementationPackage != null) {
/* 71 */       answer.addAttribute(new Attribute("implementationPackage", this.targetProject));
/*    */     }
/*    */ 
/* 75 */     addPropertyXmlElements(answer);
/*    */ 
/* 77 */     return answer;
/*    */   }
/*    */ 
/*    */   public String getImplementationPackage() {
/* 81 */     return this.implementationPackage;
/*    */   }
/*    */ 
/*    */   public void setImplementationPackage(String implementationPackage) {
/* 85 */     this.implementationPackage = implementationPackage;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors, String contextId) {
/* 89 */     if (!StringUtility.stringHasValue(this.targetProject)) {
/* 90 */       errors.add(Messages.getString("ValidationError.2", contextId));
/*    */     }
/*    */ 
/* 93 */     if (!StringUtility.stringHasValue(this.targetPackage)) {
/* 94 */       errors.add(Messages.getString("ValidationError.12", "javaClientGenerator", contextId));
/*    */     }
/*    */ 
/* 98 */     if (!StringUtility.stringHasValue(getConfigurationType()))
/* 99 */       errors.add(Messages.getString("ValidationError.20", contextId));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.JavaClientGeneratorConfiguration
 * JD-Core Version:    0.6.0
 */