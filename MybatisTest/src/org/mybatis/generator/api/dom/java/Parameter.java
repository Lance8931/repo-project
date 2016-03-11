/*    */ package org.mybatis.generator.api.dom.java;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Parameter
/*    */ {
/*    */   private String name;
/*    */   private FullyQualifiedJavaType type;
/*    */   private List<String> annotations;
/*    */ 
/*    */   public Parameter(FullyQualifiedJavaType type, String name)
/*    */   {
/* 32 */     this.name = name;
/* 33 */     this.type = type;
/* 34 */     this.annotations = new ArrayList();
/*    */   }
/*    */ 
/*    */   public Parameter(FullyQualifiedJavaType type, String name, String annotation) {
/* 38 */     this(type, name);
/* 39 */     addAnnotation(annotation);
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 46 */     return this.name;
/*    */   }
/*    */ 
/*    */   public FullyQualifiedJavaType getType()
/*    */   {
/* 53 */     return this.type;
/*    */   }
/*    */ 
/*    */   public List<String> getAnnotations() {
/* 57 */     return this.annotations;
/*    */   }
/*    */ 
/*    */   public void addAnnotation(String annotation) {
/* 61 */     this.annotations.add(annotation);
/*    */   }
/*    */ 
/*    */   public String getFormattedContent() {
/* 65 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 67 */     for (String annotation : this.annotations) {
/* 68 */       sb.append(annotation);
/* 69 */       sb.append(' ');
/*    */     }
/*    */ 
/* 72 */     sb.append(this.type.getShortName());
/* 73 */     sb.append(' ');
/* 74 */     sb.append(this.name);
/*    */ 
/* 76 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 81 */     return getFormattedContent();
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.Parameter
 * JD-Core Version:    0.6.0
 */