/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class JavaModelGeneratorConfiguration extends PropertyHolder
/*    */ {
/*    */   private String targetPackage;
/*    */   private String targetProject;
/*    */ 
/*    */   public String getTargetProject()
/*    */   {
/* 42 */     return this.targetProject;
/*    */   }
/*    */ 
/*    */   public void setTargetProject(String targetProject) {
/* 46 */     this.targetProject = targetProject;
/*    */   }
/*    */ 
/*    */   public String getTargetPackage() {
/* 50 */     return this.targetPackage;
/*    */   }
/*    */ 
/*    */   public void setTargetPackage(String targetPackage) {
/* 54 */     this.targetPackage = targetPackage;
/*    */   }
/*    */ 
/*    */   public XmlElement toXmlElement() {
/* 58 */     XmlElement answer = new XmlElement("javaModelGenerator");
/*    */ 
/* 60 */     if (this.targetPackage != null) {
/* 61 */       answer.addAttribute(new Attribute("targetPackage", this.targetPackage));
/*    */     }
/*    */ 
/* 64 */     if (this.targetProject != null) {
/* 65 */       answer.addAttribute(new Attribute("targetProject", this.targetProject));
/*    */     }
/*    */ 
/* 68 */     addPropertyXmlElements(answer);
/*    */ 
/* 70 */     return answer;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors, String contextId) {
/* 74 */     if (!StringUtility.stringHasValue(this.targetProject)) {
/* 75 */       errors.add(Messages.getString("ValidationError.0", contextId));
/*    */     }
/*    */ 
/* 78 */     if (!StringUtility.stringHasValue(this.targetPackage))
/* 79 */       errors.add(Messages.getString("ValidationError.12", "JavaModelGenerator", contextId));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.JavaModelGeneratorConfiguration
 * JD-Core Version:    0.6.0
 */