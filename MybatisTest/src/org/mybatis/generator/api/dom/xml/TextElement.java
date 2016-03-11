/*    */ package org.mybatis.generator.api.dom.xml;
/*    */ 
/*    */ import org.mybatis.generator.api.dom.OutputUtilities;
/*    */ 
/*    */ public class TextElement extends Element
/*    */ {
/*    */   private String content;
/*    */ 
/*    */   public TextElement(String content)
/*    */   {
/* 31 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public String getFormattedContent(int indentLevel)
/*    */   {
/* 36 */     StringBuilder sb = new StringBuilder();
/* 37 */     OutputUtilities.xmlIndent(sb, indentLevel);
/* 38 */     sb.append(this.content);
/* 39 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.xml.TextElement
 * JD-Core Version:    0.6.0
 */