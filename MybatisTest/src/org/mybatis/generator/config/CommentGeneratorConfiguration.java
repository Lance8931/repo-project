/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ 
/*    */ public class CommentGeneratorConfiguration extends TypedPropertyHolder
/*    */ {
/*    */   public XmlElement toXmlElement()
/*    */   {
/* 35 */     XmlElement answer = new XmlElement("commentGenerator");
/* 36 */     if (getConfigurationType() != null) {
/* 37 */       answer.addAttribute(new Attribute("type", getConfigurationType()));
/*    */     }
/*    */ 
/* 40 */     addPropertyXmlElements(answer);
/*    */ 
/* 42 */     return answer;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.CommentGeneratorConfiguration
 * JD-Core Version:    0.6.0
 */