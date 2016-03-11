/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class PluginConfiguration extends TypedPropertyHolder
/*    */ {
/*    */   public XmlElement toXmlElement()
/*    */   {
/* 35 */     XmlElement answer = new XmlElement("plugin");
/* 36 */     if (getConfigurationType() != null) {
/* 37 */       answer.addAttribute(new Attribute("type", getConfigurationType()));
/*    */     }
/*    */ 
/* 40 */     addPropertyXmlElements(answer);
/*    */ 
/* 42 */     return answer;
/*    */   }
/*    */ 
/*    */   public void validate(List<String> errors, String contextId) {
/* 46 */     if (!StringUtility.stringHasValue(getConfigurationType()))
/* 47 */       errors.add(Messages.getString("ValidationError.17", contextId));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.PluginConfiguration
 * JD-Core Version:    0.6.0
 */