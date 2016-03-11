/*    */ package org.mybatis.generator.api;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.xml.Document;
/*    */ 
/*    */ public class GeneratedXmlFile extends GeneratedFile
/*    */ {
/*    */   private Document document;
/*    */   private String fileName;
/*    */   private String targetPackage;
/*    */   private boolean isMergeable;
/*    */ 
/*    */   public GeneratedXmlFile(Document document, String fileName, String targetPackage, String targetProject, boolean isMergeable)
/*    */   {
/* 44 */     super(targetProject);
/* 45 */     this.document = document;
/* 46 */     this.fileName = fileName;
/* 47 */     this.targetPackage = targetPackage;
/* 48 */     this.isMergeable = isMergeable;
/*    */   }
/*    */ 
/*    */   public String getFormattedContent()
/*    */   {
/* 53 */     return this.document.getFormattedContent();
/*    */   }
/*    */ 
/*    */   public String getFileName()
/*    */   {
/* 61 */     return this.fileName;
/*    */   }
/*    */ 
/*    */   public String getTargetPackage()
/*    */   {
/* 69 */     return this.targetPackage;
/*    */   }
/*    */ 
/*    */   public boolean isMergeable()
/*    */   {
/* 74 */     return this.isMergeable;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.GeneratedXmlFile
 * JD-Core Version:    0.6.0
 */