/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ 
/*     */ public class Field extends JavaElement
/*     */ {
/*     */   private FullyQualifiedJavaType type;
/*     */   private String name;
/*     */   private String initializationString;
/*     */ 
/*     */   public String getName()
/*     */   {
/*  40 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  48 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getType()
/*     */   {
/*  55 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(FullyQualifiedJavaType type)
/*     */   {
/*  63 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getInitializationString()
/*     */   {
/*  70 */     return this.initializationString;
/*     */   }
/*     */ 
/*     */   public void setInitializationString(String initializationString)
/*     */   {
/*  78 */     this.initializationString = initializationString;
/*     */   }
/*     */ 
/*     */   public String getFormattedContent(int indentLevel) {
/*  82 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  84 */     addFormattedJavadoc(sb, indentLevel);
/*  85 */     addFormattedAnnotations(sb, indentLevel);
/*     */ 
/*  87 */     OutputUtilities.javaIndent(sb, indentLevel);
/*  88 */     sb.append(getVisibility().getValue());
/*     */ 
/*  90 */     if (isStatic()) {
/*  91 */       sb.append("static ");
/*     */     }
/*     */ 
/*  94 */     if (isFinal()) {
/*  95 */       sb.append("final ");
/*     */     }
/*     */ 
/*  98 */     sb.append(this.type.getShortName());
/*     */ 
/* 100 */     sb.append(' ');
/* 101 */     sb.append(this.name);
/*     */ 
/* 103 */     if ((this.initializationString != null) && (this.initializationString.length() > 0)) {
/* 104 */       sb.append(" = ");
/* 105 */       sb.append(this.initializationString);
/*     */     }
/*     */ 
/* 108 */     sb.append(';');
/*     */ 
/* 110 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.Field
 * JD-Core Version:    0.6.0
 */