/*     */ package org.mybatis.generator.api.dom.xml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ 
/*     */ public class XmlElement extends Element
/*     */ {
/*     */   private List<Attribute> attributes;
/*     */   private List<Element> elements;
/*     */   private String name;
/*     */ 
/*     */   public XmlElement(String name)
/*     */   {
/*  38 */     this.attributes = new ArrayList();
/*  39 */     this.elements = new ArrayList();
/*  40 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public List<Attribute> getAttributes()
/*     */   {
/*  47 */     return this.attributes;
/*     */   }
/*     */ 
/*     */   public void addAttribute(Attribute attribute) {
/*  51 */     this.attributes.add(attribute);
/*     */   }
/*     */ 
/*     */   public List<Element> getElements()
/*     */   {
/*  58 */     return this.elements;
/*     */   }
/*     */ 
/*     */   public void addElement(Element element) {
/*  62 */     this.elements.add(element);
/*     */   }
/*     */ 
/*     */   public void addElement(int index, Element element) {
/*  66 */     this.elements.add(index, element);
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  73 */     return this.name;
/*     */   }
/*     */ 
/*     */   public String getFormattedContent(int indentLevel)
/*     */   {
/*  78 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  80 */     OutputUtilities.xmlIndent(sb, indentLevel);
/*  81 */     sb.append('<');
/*  82 */     sb.append(this.name);
/*     */ 
/*  84 */     for (Attribute att : this.attributes) {
/*  85 */       sb.append(' ');
/*  86 */       sb.append(att.getFormattedContent());
/*     */     }
/*     */ 
/*  89 */     if (this.elements.size() > 0) {
/*  90 */       sb.append(" >");
/*  91 */       for (Element element : this.elements) {
/*  92 */         OutputUtilities.newLine(sb);
/*  93 */         sb.append(element.getFormattedContent(indentLevel + 1));
/*     */       }
/*  95 */       OutputUtilities.newLine(sb);
/*  96 */       OutputUtilities.xmlIndent(sb, indentLevel);
/*  97 */       sb.append("</");
/*  98 */       sb.append(this.name);
/*  99 */       sb.append('>');
/*     */     }
/*     */     else {
/* 102 */       sb.append(" />");
/*     */     }
/*     */ 
/* 105 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 109 */     this.name = name;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.xml.XmlElement
 * JD-Core Version:    0.6.0
 */