/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ 
/*     */ public class Method extends JavaElement
/*     */ {
/*     */   private List<String> bodyLines;
/*     */   private boolean constructor;
/*     */   private FullyQualifiedJavaType returnType;
/*     */   private String name;
/*     */   private List<Parameter> parameters;
/*     */   private List<FullyQualifiedJavaType> exceptions;
/*     */ 
/*     */   public Method()
/*     */   {
/*  47 */     this.bodyLines = new ArrayList();
/*  48 */     this.parameters = new ArrayList();
/*  49 */     this.exceptions = new ArrayList();
/*     */   }
/*     */ 
/*     */   public List<String> getBodyLines()
/*     */   {
/*  56 */     return this.bodyLines;
/*     */   }
/*     */ 
/*     */   public void addBodyLine(String line) {
/*  60 */     this.bodyLines.add(line);
/*     */   }
/*     */ 
/*     */   public void addBodyLine(int index, String line) {
/*  64 */     this.bodyLines.add(index, line);
/*     */   }
/*     */ 
/*     */   public void addBodyLines(Collection<String> lines) {
/*  68 */     this.bodyLines.addAll(lines);
/*     */   }
/*     */ 
/*     */   public void addBodyLines(int index, Collection<String> lines) {
/*  72 */     this.bodyLines.addAll(index, lines);
/*     */   }
/*     */ 
/*     */   public String getFormattedContent(int indentLevel, boolean interfaceMethod) {
/*  76 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  78 */     addFormattedJavadoc(sb, indentLevel);
/*  79 */     addFormattedAnnotations(sb, indentLevel);
/*     */ 
/*  81 */     OutputUtilities.javaIndent(sb, indentLevel);
/*     */ 
/*  83 */     if (!interfaceMethod) {
/*  84 */       sb.append(getVisibility().getValue());
/*     */ 
/*  86 */       if (isStatic()) {
/*  87 */         sb.append("static ");
/*     */       }
/*     */ 
/*  90 */       if (isFinal()) {
/*  91 */         sb.append("final ");
/*     */       }
/*     */ 
/*  94 */       if (this.bodyLines.size() == 0) {
/*  95 */         sb.append("abstract ");
/*     */       }
/*     */     }
/*     */ 
/*  99 */     if (!this.constructor) {
/* 100 */       if (getReturnType() == null)
/* 101 */         sb.append("void");
/*     */       else {
/* 103 */         sb.append(getReturnType().getShortName());
/*     */       }
/* 105 */       sb.append(' ');
/*     */     }
/*     */ 
/* 108 */     sb.append(getName());
/* 109 */     sb.append('(');
/*     */ 
/* 111 */     boolean comma = false;
/* 112 */     for (Parameter parameter : getParameters()) {
/* 113 */       if (comma)
/* 114 */         sb.append(", ");
/*     */       else {
/* 116 */         comma = true;
/*     */       }
/*     */ 
/* 119 */       sb.append(parameter.getFormattedContent());
/*     */     }
/*     */ 
/* 122 */     sb.append(')');
/*     */ 
/* 124 */     if (getExceptions().size() > 0) {
/* 125 */       sb.append(" throws ");
/* 126 */       comma = false;
/* 127 */       for (FullyQualifiedJavaType fqjt : getExceptions()) {
/* 128 */         if (comma)
/* 129 */           sb.append(", ");
/*     */         else {
/* 131 */           comma = true;
/*     */         }
/*     */ 
/* 134 */         sb.append(fqjt.getShortName());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 139 */     if (this.bodyLines.size() == 0) {
/* 140 */       sb.append(';');
/*     */     } else {
/* 142 */       sb.append(" {");
/* 143 */       indentLevel++;
/*     */ 
/* 145 */       ListIterator listIter = this.bodyLines.listIterator();
/* 146 */       while (listIter.hasNext()) {
/* 147 */         String line = (String)listIter.next();
/* 148 */         if (line.startsWith("}")) {
/* 149 */           indentLevel--;
/*     */         }
/*     */ 
/* 152 */         OutputUtilities.newLine(sb);
/* 153 */         OutputUtilities.javaIndent(sb, indentLevel);
/* 154 */         sb.append(line);
/*     */ 
/* 156 */         if (((line.endsWith("{")) && (!line.startsWith("switch"))) || (line.endsWith(":")))
/*     */         {
/* 158 */           indentLevel++;
/*     */         }
/*     */ 
/* 161 */         if (line.startsWith("break"))
/*     */         {
/* 163 */           if (listIter.hasNext()) {
/* 164 */             String nextLine = (String)listIter.next();
/* 165 */             if (nextLine.startsWith("}")) {
/* 166 */               indentLevel++;
/*     */             }
/*     */ 
/* 170 */             listIter.previous();
/*     */           }
/* 172 */           indentLevel--;
/*     */         }
/*     */       }
/*     */ 
/* 176 */       indentLevel--;
/* 177 */       OutputUtilities.newLine(sb);
/* 178 */       OutputUtilities.javaIndent(sb, indentLevel);
/* 179 */       sb.append('}');
/*     */     }
/*     */ 
/* 182 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public boolean isConstructor()
/*     */   {
/* 189 */     return this.constructor;
/*     */   }
/*     */ 
/*     */   public void setConstructor(boolean constructor)
/*     */   {
/* 197 */     this.constructor = constructor;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 204 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 212 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public List<Parameter> getParameters() {
/* 216 */     return this.parameters;
/*     */   }
/*     */ 
/*     */   public void addParameter(Parameter parameter) {
/* 220 */     this.parameters.add(parameter);
/*     */   }
/*     */ 
/*     */   public void addParameter(int index, Parameter parameter) {
/* 224 */     this.parameters.add(index, parameter);
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getReturnType()
/*     */   {
/* 231 */     return this.returnType;
/*     */   }
/*     */ 
/*     */   public void setReturnType(FullyQualifiedJavaType returnType)
/*     */   {
/* 239 */     this.returnType = returnType;
/*     */   }
/*     */ 
/*     */   public List<FullyQualifiedJavaType> getExceptions()
/*     */   {
/* 246 */     return this.exceptions;
/*     */   }
/*     */ 
/*     */   public void addException(FullyQualifiedJavaType exception) {
/* 250 */     this.exceptions.add(exception);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.Method
 * JD-Core Version:    0.6.0
 */