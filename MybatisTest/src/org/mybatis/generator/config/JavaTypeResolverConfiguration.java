/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ 
/*    */ public class JavaTypeResolverConfiguration extends TypedPropertyHolder
/*    */ {
/*    */   public XmlElement toXmlElement()
/*    */   {
/* 34 */     XmlElement answer = new XmlElement("javaTypeResolver");
/* 35 */     if (getConfigurationType() != null) {
/* 36 */       answer.addAttribute(new Attribute("type", getConfigurationType()));
/*    */     }
/*    */ 
/* 39 */     addPropertyXmlElements(answer);
/*    */ 
/* 41 */     return answer;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.JavaTypeResolverConfiguration
 * JD-Core Version:    0.6.0
 */