/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class Interface extends JavaElement
/*     */   implements CompilationUnit
/*     */ {
/*     */   private Set<FullyQualifiedJavaType> importedTypes;
/*     */   private FullyQualifiedJavaType type;
/*     */   private Set<FullyQualifiedJavaType> superInterfaceTypes;
/*     */   private List<Method> methods;
/*     */   private List<String> fileCommentLines;
/*     */ 
/*     */   public Interface(FullyQualifiedJavaType type)
/*     */   {
/*  48 */     this.type = type;
/*  49 */     this.superInterfaceTypes = new LinkedHashSet();
/*  50 */     this.methods = new ArrayList();
/*  51 */     this.importedTypes = new TreeSet();
/*  52 */     this.fileCommentLines = new ArrayList();
/*     */   }
/*     */ 
/*     */   public Interface(String type) {
/*  56 */     this(new FullyQualifiedJavaType(type));
/*     */   }
/*     */ 
/*     */   public Set<FullyQualifiedJavaType> getImportedTypes() {
/*  60 */     return Collections.unmodifiableSet(this.importedTypes);
/*     */   }
/*     */ 
/*     */   public void addImportedType(FullyQualifiedJavaType importedType) {
/*  64 */     if ((importedType.isExplicitlyImported()) && (!importedType.getPackageName().equals(this.type.getPackageName())))
/*     */     {
/*  66 */       this.importedTypes.add(importedType);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getFormattedContent() {
/*  71 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  73 */     for (String commentLine : this.fileCommentLines) {
/*  74 */       sb.append(commentLine);
/*  75 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  78 */     if (StringUtility.stringHasValue(getType().getPackageName())) {
/*  79 */       sb.append("package ");
/*  80 */       sb.append(getType().getPackageName());
/*  81 */       sb.append(';');
/*  82 */       OutputUtilities.newLine(sb);
/*  83 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  86 */     Set<String> importStrings = OutputUtilities.calculateImports(this.importedTypes);
/*     */ 
/*  88 */     for (String importString : importStrings) {
/*  89 */       sb.append(importString);
/*  90 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  93 */     if (importStrings.size() > 0) {
/*  94 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/*  97 */     int indentLevel = 0;
/*     */ 
/*  99 */     addFormattedJavadoc(sb, indentLevel);
/* 100 */     addFormattedAnnotations(sb, indentLevel);
/*     */ 
/* 102 */     sb.append(getVisibility().getValue());
/*     */ 
/* 104 */     if (isStatic()) {
/* 105 */       sb.append("static ");
/*     */     }
/*     */ 
/* 108 */     if (isFinal()) {
/* 109 */       sb.append("final ");
/*     */     }
/*     */ 
/* 112 */     sb.append("interface ");
/* 113 */     sb.append(getType().getShortName());
/*     */     boolean comma;
/* 115 */     if (getSuperInterfaceTypes().size() > 0) {
/* 116 */       sb.append(" extends ");
/*     */ 
/* 118 */       comma = false;
/* 119 */       for (FullyQualifiedJavaType fqjt : getSuperInterfaceTypes()) {
/* 120 */         if (comma)
/* 121 */           sb.append(", ");
/*     */         else {
/* 123 */           comma = true;
/*     */         }
/*     */ 
/* 126 */         sb.append(fqjt.getShortName());
/*     */       }
/*     */     }
/*     */ 
/* 130 */     sb.append(" {");
/* 131 */     indentLevel++;
/*     */ 
/* 133 */     Iterator mtdIter = getMethods().iterator();
/* 134 */     while (mtdIter.hasNext()) {
/* 135 */       OutputUtilities.newLine(sb);
/* 136 */       Method method = (Method)mtdIter.next();
/* 137 */       sb.append(method.getFormattedContent(indentLevel, true));
/* 138 */       if (mtdIter.hasNext()) {
/* 139 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */ 
/* 143 */     indentLevel--;
/* 144 */     OutputUtilities.newLine(sb);
/* 145 */     OutputUtilities.javaIndent(sb, indentLevel);
/* 146 */     sb.append('}');
/*     */ 
/* 148 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public void addSuperInterface(FullyQualifiedJavaType superInterface) {
/* 152 */     this.superInterfaceTypes.add(superInterface);
/*     */   }
/*     */ 
/*     */   public List<Method> getMethods()
/*     */   {
/* 159 */     return this.methods;
/*     */   }
/*     */ 
/*     */   public void addMethod(Method method) {
/* 163 */     this.methods.add(method);
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getType()
/*     */   {
/* 170 */     return this.type;
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getSuperClass()
/*     */   {
/* 175 */     return null;
/*     */   }
/*     */ 
/*     */   public Set<FullyQualifiedJavaType> getSuperInterfaceTypes() {
/* 179 */     return this.superInterfaceTypes;
/*     */   }
/*     */ 
/*     */   public boolean isJavaInterface() {
/* 183 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean isJavaEnumeration() {
/* 187 */     return false;
/*     */   }
/*     */ 
/*     */   public void addFileCommentLine(String commentLine) {
/* 191 */     this.fileCommentLines.add(commentLine);
/*     */   }
/*     */ 
/*     */   public List<String> getFileCommentLines() {
/* 195 */     return this.fileCommentLines;
/*     */   }
/*     */ 
/*     */   public void addImportedTypes(Set<FullyQualifiedJavaType> importedTypes) {
/* 199 */     this.importedTypes.addAll(importedTypes);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.Interface
 * JD-Core Version:    0.6.0
 */