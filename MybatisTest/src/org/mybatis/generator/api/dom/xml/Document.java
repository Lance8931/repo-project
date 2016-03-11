/*    */ package org.mybatis.generator.api.dom.xml;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.OutputUtilities;
/*    */ 
/*    */ public class Document
/*    */ {
/*    */   private String publicId;
/*    */   private String systemId;
/*    */   private XmlElement rootElement;
/*    */ 
/*    */   public Document(String publicId, String systemId)
/*    */   {
/* 35 */     this.publicId = publicId;
/* 36 */     this.systemId = systemId;
/*    */   }
/*    */ 
/*    */   public Document()
/*    */   {
/*    */   }
/*    */ 
/*    */   public XmlElement getRootElement()
/*    */   {
/* 47 */     return this.rootElement;
/*    */   }
/*    */ 
/*    */   public void setRootElement(XmlElement rootElement)
/*    */   {
/* 55 */     this.rootElement = rootElement;
/*    */   }
/*    */ 
/*    */   public String getPublicId()
/*    */   {
/* 62 */     return this.publicId;
/*    */   }
/*    */ 
/*    */   public String getSystemId()
/*    */   {
/* 69 */     return this.systemId;
/*    */   }
/*    */ 
/*    */   public String getFormattedContent() {
/* 73 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 75 */     sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
/*    */ 
/* 77 */     if ((this.publicId != null) && (this.systemId != null)) {
/* 78 */       OutputUtilities.newLine(sb);
/* 79 */       sb.append("<!DOCTYPE ");
/* 80 */       sb.append(this.rootElement.getName());
/* 81 */       sb.append(" PUBLIC \"");
/* 82 */       sb.append(this.publicId);
/* 83 */       sb.append("\" \"");
/* 84 */       sb.append(this.systemId);
/* 85 */       sb.append("\" >");
/*    */     }
/*    */ 
/* 88 */     OutputUtilities.newLine(sb);
/* 89 */     sb.append(this.rootElement.getFormattedContent(0));
/*    */ 
/* 91 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.xml.Document
 * JD-Core Version:    0.6.0
 */