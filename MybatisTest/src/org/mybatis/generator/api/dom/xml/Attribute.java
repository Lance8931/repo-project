/*    */ package org.mybatis.generator.api.dom.xml;
/*    */ 
/*    */ public class Attribute
/*    */ {
/*    */   private String name;
/*    */   private String value;
/*    */ 
/*    */   public Attribute(String name, String value)
/*    */   {
/* 30 */     this.name = name;
/* 31 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 38 */     return this.name;
/*    */   }
/*    */ 
/*    */   public String getValue()
/*    */   {
/* 45 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getFormattedContent() {
/* 49 */     StringBuilder sb = new StringBuilder();
/* 50 */     sb.append(this.name);
/* 51 */     sb.append("=\"");
/* 52 */     sb.append(this.value);
/* 53 */     sb.append('"');
/*    */ 
/* 55 */     return sb.toString();
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.xml.Attribute
 * JD-Core Version:    0.6.0
 */