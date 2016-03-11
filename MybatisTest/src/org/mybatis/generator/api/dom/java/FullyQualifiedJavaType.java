/*     */ package org.mybatis.generator.api.dom.java;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class FullyQualifiedJavaType
/*     */   implements Comparable<FullyQualifiedJavaType>
/*     */ {
/*  30 */   private static FullyQualifiedJavaType intInstance = null;
/*  31 */   private static FullyQualifiedJavaType stringInstance = null;
/*  32 */   private static FullyQualifiedJavaType booleanPrimitiveInstance = null;
/*  33 */   private static FullyQualifiedJavaType objectInstance = null;
/*  34 */   private static FullyQualifiedJavaType dateInstance = null;
/*  35 */   private static FullyQualifiedJavaType criteriaInstance = null;
/*  36 */   private static FullyQualifiedJavaType generatedCriteriaInstance = null;
/*     */   private String baseShortName;
/*     */   private String baseQualifiedName;
/*     */   private boolean explicitlyImported;
/*     */   private String packageName;
/*     */   private boolean primitive;
/*     */   private PrimitiveTypeWrapper primitiveTypeWrapper;
/*     */   private List<FullyQualifiedJavaType> typeArguments;
/*     */   private boolean wildcardType;
/*     */   private boolean boundedWildcard;
/*     */   private boolean extendsBoundedWildcard;
/*     */ 
/*     */   public FullyQualifiedJavaType(String fullTypeSpecification)
/*     */   {
/*  67 */     this.typeArguments = new ArrayList();
/*  68 */     parse(fullTypeSpecification);
/*     */   }
/*     */ 
/*     */   public boolean isExplicitlyImported()
/*     */   {
/*  75 */     return this.explicitlyImported;
/*     */   }
/*     */ 
/*     */   public String getFullyQualifiedName()
/*     */   {
/*  85 */     StringBuilder sb = new StringBuilder();
/*  86 */     if (this.wildcardType) {
/*  87 */       sb.append('?');
/*  88 */       if (this.boundedWildcard) {
/*  89 */         if (this.extendsBoundedWildcard)
/*  90 */           sb.append(" extends ");
/*     */         else {
/*  92 */           sb.append(" super ");
/*     */         }
/*     */ 
/*  95 */         sb.append(this.baseQualifiedName);
/*     */       }
/*     */     } else {
/*  98 */       sb.append(this.baseQualifiedName);
/*     */     }
/*     */ 
/* 101 */     if (this.typeArguments.size() > 0) {
/* 102 */       boolean first = true;
/* 103 */       sb.append('<');
/* 104 */       for (FullyQualifiedJavaType fqjt : this.typeArguments) {
/* 105 */         if (first)
/* 106 */           first = false;
/*     */         else {
/* 108 */           sb.append(", ");
/*     */         }
/* 110 */         sb.append(fqjt.getFullyQualifiedName());
/*     */       }
/*     */ 
/* 113 */       sb.append('>');
/*     */     }
/*     */ 
/* 116 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public List<String> getImportList()
/*     */   {
/* 124 */     List answer = new ArrayList();
/* 125 */     if (isExplicitlyImported()) {
/* 126 */       int index = this.baseShortName.indexOf('.');
/* 127 */       if (index == -1) {
/* 128 */         answer.add(this.baseQualifiedName);
/*     */       }
/*     */       else
/*     */       {
/* 132 */         StringBuilder sb = new StringBuilder();
/* 133 */         sb.append(this.packageName);
/* 134 */         sb.append('.');
/* 135 */         sb.append(this.baseShortName.substring(0, index));
/* 136 */         answer.add(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/* 140 */     for (FullyQualifiedJavaType fqjt : this.typeArguments) {
/* 141 */       answer.addAll(fqjt.getImportList());
/*     */     }
/*     */ 
/* 144 */     return answer;
/*     */   }
/*     */ 
/*     */   public String getPackageName()
/*     */   {
/* 151 */     return this.packageName;
/*     */   }
/*     */ 
/*     */   public String getShortName()
/*     */   {
/* 158 */     StringBuilder sb = new StringBuilder();
/* 159 */     if (this.wildcardType) {
/* 160 */       sb.append('?');
/* 161 */       if (this.boundedWildcard) {
/* 162 */         if (this.extendsBoundedWildcard)
/* 163 */           sb.append(" extends ");
/*     */         else {
/* 165 */           sb.append(" super ");
/*     */         }
/*     */ 
/* 168 */         sb.append(this.baseShortName);
/*     */       }
/*     */     } else {
/* 171 */       sb.append(this.baseShortName);
/*     */     }
/*     */ 
/* 174 */     if (this.typeArguments.size() > 0) {
/* 175 */       boolean first = true;
/* 176 */       sb.append('<');
/* 177 */       for (FullyQualifiedJavaType fqjt : this.typeArguments) {
/* 178 */         if (first)
/* 179 */           first = false;
/*     */         else {
/* 181 */           sb.append(", ");
/*     */         }
/* 183 */         sb.append(fqjt.getShortName());
/*     */       }
/*     */ 
/* 186 */       sb.append('>');
/*     */     }
/*     */ 
/* 189 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 199 */     if (this == obj) {
/* 200 */       return true;
/*     */     }
/*     */ 
/* 203 */     if (!(obj instanceof FullyQualifiedJavaType)) {
/* 204 */       return false;
/*     */     }
/*     */ 
/* 207 */     FullyQualifiedJavaType other = (FullyQualifiedJavaType)obj;
/*     */ 
/* 209 */     return getFullyQualifiedName().equals(other.getFullyQualifiedName());
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 219 */     return getFullyQualifiedName().hashCode();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 229 */     return getFullyQualifiedName();
/*     */   }
/*     */ 
/*     */   public boolean isPrimitive()
/*     */   {
/* 236 */     return this.primitive;
/*     */   }
/*     */ 
/*     */   public PrimitiveTypeWrapper getPrimitiveTypeWrapper()
/*     */   {
/* 243 */     return this.primitiveTypeWrapper;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getIntInstance() {
/* 247 */     if (intInstance == null) {
/* 248 */       intInstance = new FullyQualifiedJavaType("int");
/*     */     }
/*     */ 
/* 251 */     return intInstance;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getNewMapInstance()
/*     */   {
/* 256 */     return new FullyQualifiedJavaType("java.util.Map");
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getNewListInstance()
/*     */   {
/* 261 */     return new FullyQualifiedJavaType("java.util.List");
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getNewHashMapInstance()
/*     */   {
/* 266 */     return new FullyQualifiedJavaType("java.util.HashMap");
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getNewArrayListInstance()
/*     */   {
/* 271 */     return new FullyQualifiedJavaType("java.util.ArrayList");
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getNewIteratorInstance()
/*     */   {
/* 276 */     return new FullyQualifiedJavaType("java.util.Iterator");
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getStringInstance() {
/* 280 */     if (stringInstance == null) {
/* 281 */       stringInstance = new FullyQualifiedJavaType("java.lang.String");
/*     */     }
/*     */ 
/* 284 */     return stringInstance;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getBooleanPrimitiveInstance() {
/* 288 */     if (booleanPrimitiveInstance == null) {
/* 289 */       booleanPrimitiveInstance = new FullyQualifiedJavaType("boolean");
/*     */     }
/*     */ 
/* 292 */     return booleanPrimitiveInstance;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getObjectInstance() {
/* 296 */     if (objectInstance == null) {
/* 297 */       objectInstance = new FullyQualifiedJavaType("java.lang.Object");
/*     */     }
/*     */ 
/* 300 */     return objectInstance;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getDateInstance() {
/* 304 */     if (dateInstance == null) {
/* 305 */       dateInstance = new FullyQualifiedJavaType("java.util.Date");
/*     */     }
/*     */ 
/* 308 */     return dateInstance;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getCriteriaInstance() {
/* 312 */     if (criteriaInstance == null) {
/* 313 */       criteriaInstance = new FullyQualifiedJavaType("Criteria");
/*     */     }
/*     */ 
/* 316 */     return criteriaInstance;
/*     */   }
/*     */ 
/*     */   public static final FullyQualifiedJavaType getGeneratedCriteriaInstance() {
/* 320 */     if (generatedCriteriaInstance == null) {
/* 321 */       generatedCriteriaInstance = new FullyQualifiedJavaType("GeneratedCriteria");
/*     */     }
/*     */ 
/* 325 */     return generatedCriteriaInstance;
/*     */   }
/*     */ 
/*     */   public int compareTo(FullyQualifiedJavaType other)
/*     */   {
/* 334 */     return getFullyQualifiedName().compareTo(other.getFullyQualifiedName());
/*     */   }
/*     */ 
/*     */   public void addTypeArgument(FullyQualifiedJavaType type) {
/* 338 */     this.typeArguments.add(type);
/*     */   }
/*     */ 
/*     */   private void parse(String fullTypeSpecification) {
/* 342 */     String spec = fullTypeSpecification.trim();
/*     */ 
/* 344 */     if (spec.startsWith("?")) {
/* 345 */       this.wildcardType = true;
/* 346 */       spec = spec.substring(1).trim();
/* 347 */       if (spec.startsWith("extends ")) {
/* 348 */         this.boundedWildcard = true;
/* 349 */         this.extendsBoundedWildcard = true;
/* 350 */         spec = spec.substring(8);
/* 351 */       } else if (spec.startsWith("super ")) {
/* 352 */         this.boundedWildcard = true;
/* 353 */         this.extendsBoundedWildcard = false;
/* 354 */         spec = spec.substring(6);
/*     */       } else {
/* 356 */         this.boundedWildcard = false;
/*     */       }
/* 358 */       parse(spec);
/*     */     } else {
/* 360 */       int index = fullTypeSpecification.indexOf('<');
/* 361 */       if (index == -1) {
/* 362 */         simpleParse(fullTypeSpecification);
/*     */       } else {
/* 364 */         simpleParse(fullTypeSpecification.substring(0, index));
/* 365 */         genericParse(fullTypeSpecification.substring(index));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void simpleParse(String typeSpecification) {
/* 371 */     this.baseQualifiedName = typeSpecification.trim();
/* 372 */     if (this.baseQualifiedName.contains(".")) {
/* 373 */       this.packageName = getPackage(this.baseQualifiedName);
/* 374 */       this.baseShortName = this.baseQualifiedName.substring(this.packageName.length() + 1);
/*     */ 
/* 376 */       if ("java.lang".equals(this.packageName))
/* 377 */         this.explicitlyImported = false;
/*     */       else
/* 379 */         this.explicitlyImported = true;
/*     */     }
/*     */     else {
/* 382 */       this.baseShortName = this.baseQualifiedName;
/* 383 */       this.explicitlyImported = false;
/* 384 */       this.packageName = "";
/*     */ 
/* 386 */       if ("byte".equals(this.baseQualifiedName)) {
/* 387 */         this.primitive = true;
/* 388 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getByteInstance();
/* 389 */       } else if ("short".equals(this.baseQualifiedName)) {
/* 390 */         this.primitive = true;
/* 391 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getShortInstance();
/* 392 */       } else if ("int".equals(this.baseQualifiedName)) {
/* 393 */         this.primitive = true;
/* 394 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getIntegerInstance();
/*     */       }
/* 396 */       else if ("long".equals(this.baseQualifiedName)) {
/* 397 */         this.primitive = true;
/* 398 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getLongInstance();
/* 399 */       } else if ("char".equals(this.baseQualifiedName)) {
/* 400 */         this.primitive = true;
/* 401 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getCharacterInstance();
/*     */       }
/* 403 */       else if ("float".equals(this.baseQualifiedName)) {
/* 404 */         this.primitive = true;
/* 405 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getFloatInstance();
/* 406 */       } else if ("double".equals(this.baseQualifiedName)) {
/* 407 */         this.primitive = true;
/* 408 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getDoubleInstance();
/* 409 */       } else if ("boolean".equals(this.baseQualifiedName)) {
/* 410 */         this.primitive = true;
/* 411 */         this.primitiveTypeWrapper = PrimitiveTypeWrapper.getBooleanInstance();
/*     */       }
/*     */       else {
/* 414 */         this.primitive = false;
/* 415 */         this.primitiveTypeWrapper = null;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void genericParse(String genericSpecification) {
/* 421 */     int lastIndex = genericSpecification.lastIndexOf('>');
/* 422 */     if (lastIndex == -1) {
/* 423 */       throw new RuntimeException(Messages.getString("RuntimeError.22", genericSpecification));
/*     */     }
/*     */ 
/* 426 */     String argumentString = genericSpecification.substring(1, lastIndex);
/*     */ 
/* 428 */     StringTokenizer st = new StringTokenizer(argumentString, ",<>", true);
/* 429 */     int openCount = 0;
/* 430 */     StringBuilder sb = new StringBuilder();
/* 431 */     while (st.hasMoreTokens()) {
/* 432 */       String token = st.nextToken();
/* 433 */       if ("<".equals(token)) {
/* 434 */         sb.append(token);
/* 435 */         openCount++;
/* 436 */       } else if (">".equals(token)) {
/* 437 */         sb.append(token);
/* 438 */         openCount--;
/* 439 */       } else if (",".equals(token)) {
/* 440 */         if (openCount == 0) {
/* 441 */           this.typeArguments.add(new FullyQualifiedJavaType(sb.toString()));
/*     */ 
/* 443 */           sb.setLength(0);
/*     */         } else {
/* 445 */           sb.append(token);
/*     */         }
/*     */       } else {
/* 448 */         sb.append(token);
/*     */       }
/*     */     }
/*     */ 
/* 452 */     if (openCount != 0) {
/* 453 */       throw new RuntimeException(Messages.getString("RuntimeError.22", genericSpecification));
/*     */     }
/*     */ 
/* 457 */     String finalType = sb.toString();
/* 458 */     if (StringUtility.stringHasValue(finalType))
/* 459 */       this.typeArguments.add(new FullyQualifiedJavaType(finalType));
/*     */   }
/*     */ 
/*     */   private static String getPackage(String baseQualifiedName)
/*     */   {
/* 473 */     StringBuilder sb = new StringBuilder();
/* 474 */     StringTokenizer st = new StringTokenizer(baseQualifiedName, ".");
/* 475 */     while (st.hasMoreTokens()) {
/* 476 */       String s = st.nextToken();
/* 477 */       if (Character.isUpperCase(s.charAt(0))) {
/*     */         break;
/*     */       }
/* 480 */       if (sb.length() > 0) {
/* 481 */         sb.append('.');
/*     */       }
/* 483 */       sb.append(s);
/*     */     }
/*     */ 
/* 487 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.dom.java.FullyQualifiedJavaType
 * JD-Core Version:    0.6.0
 */