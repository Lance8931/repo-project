/*    */ package org.mybatis.generator.config.xml;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.xml.sax.EntityResolver;
/*    */ import org.xml.sax.InputSource;
/*    */ import org.xml.sax.SAXException;
/*    */ 
/*    */ public class ParserEntityResolver
/*    */   implements EntityResolver
/*    */ {
/*    */   public InputSource resolveEntity(String publicId, String systemId)
/*    */     throws SAXException, IOException
/*    */   {
/* 46 */     if ("-//Apache Software Foundation//DTD Apache iBATIS Ibator Configuration 1.0//EN".equalsIgnoreCase(publicId)) {
/* 47 */       InputStream is = getClass().getClassLoader().getResourceAsStream("org/mybatis/generator/config/xml/ibator-config_1_0.dtd");
/*    */ 
/* 49 */       InputSource ins = new InputSource(is);
/*    */ 
/* 51 */       return ins;
/* 52 */     }if ("-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN".equalsIgnoreCase(publicId))
/*    */     {
/* 54 */       InputStream is = getClass().getClassLoader().getResourceAsStream("org/mybatis/generator/config/xml/mybatis-generator-config_1_0.dtd");
/*    */ 
/* 58 */       InputSource ins = new InputSource(is);
/*    */ 
/* 60 */       return ins;
/*    */     }
/* 62 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.xml.ParserEntityResolver
 * JD-Core Version:    0.6.0
 */