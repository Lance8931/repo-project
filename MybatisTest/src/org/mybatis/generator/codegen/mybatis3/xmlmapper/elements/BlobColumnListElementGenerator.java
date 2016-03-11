/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class BlobColumnListElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 39 */     XmlElement answer = new XmlElement("sql");
/*    */ 
/* 41 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getBlobColumnListId()));
/*    */ 
/* 44 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 46 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 48 */     Iterator iter = this.introspectedTable.getBLOBColumns().iterator();
/*    */ 
/* 50 */     while (iter.hasNext()) {
/* 51 */       sb.append(MyBatis3FormattingUtilities.getSelectListPhrase((IntrospectedColumn)iter.next()));
/*    */ 
/* 54 */       if (iter.hasNext()) {
/* 55 */         sb.append(", ");
/*    */       }
/*    */ 
/* 58 */       if (sb.length() > 80) {
/* 59 */         answer.addElement(new TextElement(sb.toString()));
/* 60 */         sb.setLength(0);
/*    */       }
/*    */     }
/*    */ 
/* 64 */     if (sb.length() > 0) {
/* 65 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 68 */     if (this.context.getPlugins().sqlMapBlobColumnListElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 70 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.BlobColumnListElementGenerator
 * JD-Core Version:    0.6.0
 */