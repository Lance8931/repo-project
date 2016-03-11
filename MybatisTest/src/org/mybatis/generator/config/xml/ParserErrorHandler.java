/*    */ package org.mybatis.generator.config.xml;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ import org.xml.sax.ErrorHandler;
/*    */ import org.xml.sax.SAXException;
/*    */ import org.xml.sax.SAXParseException;
/*    */ 
/*    */ public class ParserErrorHandler
/*    */   implements ErrorHandler
/*    */ {
/*    */   private List<String> warnings;
/*    */   private List<String> errors;
/*    */ 
/*    */   public ParserErrorHandler(List<String> warnings, List<String> errors)
/*    */   {
/* 38 */     this.warnings = warnings;
/* 39 */     this.errors = errors;
/*    */   }
/*    */ 
/*    */   public void warning(SAXParseException exception)
/*    */     throws SAXException
/*    */   {
/* 48 */     this.warnings.add(Messages.getString("Warning.7", Integer.toString(exception.getLineNumber()), exception.getMessage()));
/*    */   }
/*    */ 
/*    */   public void error(SAXParseException exception)
/*    */     throws SAXException
/*    */   {
/* 59 */     this.errors.add(Messages.getString("RuntimeError.4", Integer.toString(exception.getLineNumber()), exception.getMessage()));
/*    */   }
/*    */ 
/*    */   public void fatalError(SAXParseException exception)
/*    */     throws SAXException
/*    */   {
/* 70 */     this.errors.add(Messages.getString("RuntimeError.4", Integer.toString(exception.getLineNumber()), exception.getMessage()));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.xml.ParserErrorHandler
 * JD-Core Version:    0.6.0
 */