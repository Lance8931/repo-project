/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ 
/*     */ public class InnerClass extends JavaElement
/*     */ {
/*     */   private List<Field> fields;
/*     */   private List<InnerClass> innerClasses;
/*     */   private List<InnerEnum> innerEnums;
/*     */   private FullyQualifiedJavaType superClass;
/*     */   private FullyQualifiedJavaType type;
/*     */   private Set<FullyQualifiedJavaType> superInterfaceTypes;
/*     */   private List<Method> methods;
/*     */   private boolean isAbstract;
/*     */ 
/*     */   public InnerClass(FullyQualifiedJavaType type)
/*     */   {
/*  54 */     this.type = type;
/*  55 */     this.fields = new ArrayList();
/*  56 */     this.innerClasses = new ArrayList();
/*  57 */     this.innerEnums = new ArrayList();
/*  58 */     this.superInterfaceTypes = new HashSet();
/*  59 */     this.methods = new ArrayList();
/*     */   }
/*     */ 
/*     */   public InnerClass(String typeName) {
/*  63 */     this(new FullyQualifiedJavaType(typeName));
/*     */   }
/*     */ 
/*     */   public List<Field> getFields()
/*     */   {
/*  70 */     return this.fields;
/*     */   }
/*     */ 
/*     */   public void addField(Field field) {
/*  74 */     this.fields.add(field);
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getSuperClass()
/*     */   {
/*  81 */     return this.superClass;
/*     */   }
/*     */ 
/*     */   public void setSuperClass(FullyQualifiedJavaType superClass)
/*     */   {
/*  89 */     this.superClass = superClass;
/*     */   }
/*     */ 
/*     */   public void setSuperClass(String superClassType) {
/*  93 */     this.superClass = new FullyQualifiedJavaType(superClassType);
/*     */   }
/*     */ 
/*     */   public List<InnerClass> getInnerClasses()
/*     */   {
/* 100 */     return this.innerClasses;
/*     */   }
/*     */ 
/*     */   public void addInnerClass(InnerClass innerClass) {
/* 104 */     this.innerClasses.add(innerClass);
/*     */   }
/*     */ 
/*     */   public List<InnerEnum> getInnerEnums() {
/* 108 */     return this.innerEnums;
/*     */   }
/*     */ 
/*     */   public void addInnerEnum(InnerEnum innerEnum) {
/* 112 */     this.innerEnums.add(innerEnum);
/*     */   }
/*     */ 
/*     */   public String getFormattedContent(int indentLevel) {
/* 116 */     StringBuilder sb = new StringBuilder();
/*     */ 
/* 118 */     addFormattedJavadoc(sb, indentLevel);
/* 119 */     addFormattedAnnotations(sb, indentLevel);
/*     */ 
/* 121 */     OutputUtilities.javaIndent(sb, indentLevel);
/* 122 */     sb.append(getVisibility().getValue());
/*     */ 
/* 124 */     if (isAbstract()) {
/* 125 */       sb.append("abstract ");
/*     */     }
/*     */ 
/* 128 */     if (isStatic()) {
/* 129 */       sb.append("static ");
/*     */     }
/*     */ 
/* 132 */     if (isFinal()) {
/* 133 */       sb.append("final ");
/*     */     }
/*     */ 
/* 136 */     sb.append("class ");
/* 137 */     sb.append(getType().getShortName());
/*     */ 
/* 139 */     if (this.superClass != null) {
/* 140 */       sb.append(" extends ");
/* 141 */       sb.append(this.superClass.getShortName());
/*     */     }
/*     */     boolean comma;
/* 144 */     if (this.superInterfaceTypes.size() > 0) {
/* 145 */       sb.append(" implements ");
/*     */ 
/* 147 */       comma = false;
/* 148 */       for (FullyQualifiedJavaType fqjt : this.superInterfaceTypes) {
/* 149 */         if (comma)
/* 150 */           sb.append(", ");
/*     */         else {
/* 152 */           comma = true;
/*     */         }
/*     */ 
/* 155 */         sb.append(fqjt.getShortName());
/*     */       }
/*     */     }
/*     */ 
/* 159 */     sb.append(" {");
/* 160 */     indentLevel++;
/*     */ 
/* 162 */     Iterator fldIter = this.fields.iterator();
/* 163 */     while (fldIter.hasNext()) {
/* 164 */       OutputUtilities.newLine(sb);
/* 165 */       Field field = (Field)fldIter.next();
/* 166 */       sb.append(field.getFormattedContent(indentLevel));
/* 167 */       if (fldIter.hasNext()) {
/* 168 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */ 
/* 172 */     if (this.methods.size() > 0) {
/* 173 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/* 176 */     Iterator mtdIter = this.methods.iterator();
/* 177 */     while (mtdIter.hasNext()) {
/* 178 */       OutputUtilities.newLine(sb);
/* 179 */       Method method = (Method)mtdIter.next();
/* 180 */       sb.append(method.getFormattedContent(indentLevel, false));
/* 181 */       if (mtdIter.hasNext()) {
/* 182 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */ 
/* 186 */     if (this.innerClasses.size() > 0) {
/* 187 */       OutputUtilities.newLine(sb);
/*     */     }
/* 189 */     Iterator icIter = this.innerClasses.iterator();
/* 190 */     while (icIter.hasNext()) {
/* 191 */       OutputUtilities.newLine(sb);
/* 192 */       InnerClass innerClass = (InnerClass)icIter.next();
/* 193 */       sb.append(innerClass.getFormattedContent(indentLevel));
/* 194 */       if (icIter.hasNext()) {
/* 195 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */ 
/* 199 */     if (this.innerEnums.size() > 0) {
/* 200 */       OutputUtilities.newLine(sb);
/*     */     }
/*     */ 
/* 203 */     Iterator ieIter = this.innerEnums.iterator();
/* 204 */     while (ieIter.hasNext()) {
/* 205 */       OutputUtilities.newLine(sb);
/* 206 */       InnerEnum innerEnum = (InnerEnum)ieIter.next();
/* 207 */       sb.append(innerEnum.getFormattedContent(indentLevel));
/* 208 */       if (ieIter.hasNext()) {
/* 209 */         OutputUtilities.newLine(sb);
/*     */       }
/*     */     }
/*     */ 
/* 213 */     indentLevel--;
/* 214 */     OutputUtilities.newLine(sb);
/* 215 */     OutputUtilities.javaIndent(sb, indentLevel);
/* 216 */     sb.append('}');
/*     */ 
/* 218 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Set<FullyQualifiedJavaType> getSuperInterfaceTypes()
/*     */   {
/* 225 */     return this.superInterfaceTypes;
/*     */   }
/*     */ 
/*     */   public void addSuperInterface(FullyQualifiedJavaType superInterface) {
/* 229 */     this.superInterfaceTypes.add(superInterface);
/*     */   }
/*     */ 
/*     */   public List<Method> getMethods()
/*     */   {
/* 236 */     return this.methods;
/*     */   }
/*     */ 
/*     */   public void addMethod(Method method) {
/* 240 */     this.methods.add(method);
/*     */   }
/*     */ 
/*     */   public FullyQualifiedJavaType getType()
/*     */   {
/* 247 */     return this.type;
/*     */   }
/*     */ 
/*     */   public boolean isAbstract() {
/* 251 */     return this.isAbstract;
/*     */   }
/*     */ 
/*     */   public void setAbstract(boolean isAbtract) {
/* 255 */     this.isAbstract = isAbtract;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.InnerClass
 * JD-Core Version:    0.6.0
 */