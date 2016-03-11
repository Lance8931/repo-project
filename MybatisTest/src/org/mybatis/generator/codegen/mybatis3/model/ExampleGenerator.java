/*     */ package org.mybatis.generator.codegen.mybatis3.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.InnerClass;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*     */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class ExampleGenerator extends AbstractJavaGenerator
/*     */ {
/*     */   public List<CompilationUnit> getCompilationUnits()
/*     */   {
/*  53 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*  54 */     this.progressCallback.startTask(Messages.getString("Progress.6", table.toString()));
/*     */ 
/*  56 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*     */ 
/*  58 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*     */ 
/*  60 */     TopLevelClass topLevelClass = new TopLevelClass(type);
/*  61 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*  62 */     commentGenerator.addJavaFileComment(topLevelClass);
/*     */ 
/*  65 */     Method method = new Method();
/*  66 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  67 */     method.setConstructor(true);
/*  68 */     method.setName(type.getShortName());
/*  69 */     method.addBodyLine("oredCriteria = new ArrayList<Criteria>();");
/*     */ 
/*  71 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  72 */     topLevelClass.addMethod(method);
/*     */ 
/*  75 */     Field field = new Field();
/*  76 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  77 */     field.setType(FullyQualifiedJavaType.getStringInstance());
/*  78 */     field.setName("orderByClause");
/*  79 */     commentGenerator.addFieldComment(field, this.introspectedTable);
/*  80 */     topLevelClass.addField(field);
/*     */ 
/*  82 */     method = new Method();
/*  83 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  84 */     method.setName("setOrderByClause");
/*  85 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "orderByClause"));
/*     */ 
/*  87 */     method.addBodyLine("this.orderByClause = orderByClause;");
/*  88 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  89 */     topLevelClass.addMethod(method);
/*     */ 
/*  91 */     method = new Method();
/*  92 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  93 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  94 */     method.setName("getOrderByClause");
/*  95 */     method.addBodyLine("return orderByClause;");
/*  96 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  97 */     topLevelClass.addMethod(method);
/*     */ 
/* 100 */     field = new Field();
/* 101 */     field.setVisibility(JavaVisibility.PROTECTED);
/* 102 */     field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/* 103 */     field.setName("distinct");
/* 104 */     commentGenerator.addFieldComment(field, this.introspectedTable);
/* 105 */     topLevelClass.addField(field);
/*     */ 
/* 107 */     method = new Method();
/* 108 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 109 */     method.setName("setDistinct");
/* 110 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getBooleanPrimitiveInstance(), "distinct"));
/*     */ 
/* 112 */     method.addBodyLine("this.distinct = distinct;");
/* 113 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 114 */     topLevelClass.addMethod(method);
/*     */ 
/* 116 */     method = new Method();
/* 117 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 118 */     method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/*     */ 
/* 120 */     method.setName("isDistinct");
/* 121 */     method.addBodyLine("return distinct;");
/* 122 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 123 */     topLevelClass.addMethod(method);
/*     */ 
/* 126 */     field = new Field();
/* 127 */     field.setVisibility(JavaVisibility.PROTECTED);
/*     */ 
/* 129 */     FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("java.util.List<Criteria>");
/*     */ 
/* 131 */     field.setType(fqjt);
/* 132 */     field.setName("oredCriteria");
/* 133 */     commentGenerator.addFieldComment(field, this.introspectedTable);
/* 134 */     topLevelClass.addField(field);
/*     */ 
/* 136 */     method = new Method();
/* 137 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 138 */     method.setReturnType(fqjt);
/* 139 */     method.setName("getOredCriteria");
/* 140 */     method.addBodyLine("return oredCriteria;");
/* 141 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 142 */     topLevelClass.addMethod(method);
/*     */ 
/* 144 */     method = new Method();
/* 145 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 146 */     method.setName("or");
/* 147 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getCriteriaInstance(), "criteria"));
/*     */ 
/* 149 */     method.addBodyLine("oredCriteria.add(criteria);");
/* 150 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 151 */     topLevelClass.addMethod(method);
/*     */ 
/* 153 */     method = new Method();
/* 154 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 155 */     method.setName("or");
/* 156 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 157 */     method.addBodyLine("Criteria criteria = createCriteriaInternal();");
/* 158 */     method.addBodyLine("oredCriteria.add(criteria);");
/* 159 */     method.addBodyLine("return criteria;");
/* 160 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 161 */     topLevelClass.addMethod(method);
/*     */ 
/* 163 */     method = new Method();
/* 164 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 165 */     method.setName("createCriteria");
/* 166 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 167 */     method.addBodyLine("Criteria criteria = createCriteriaInternal();");
/* 168 */     method.addBodyLine("if (oredCriteria.size() == 0) {");
/* 169 */     method.addBodyLine("oredCriteria.add(criteria);");
/* 170 */     method.addBodyLine("}");
/* 171 */     method.addBodyLine("return criteria;");
/* 172 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 173 */     topLevelClass.addMethod(method);
/*     */ 
/* 175 */     method = new Method();
/* 176 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 177 */     method.setName("createCriteriaInternal");
/* 178 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 179 */     method.addBodyLine("Criteria criteria = new Criteria();");
/* 180 */     method.addBodyLine("return criteria;");
/* 181 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 182 */     topLevelClass.addMethod(method);
/*     */ 
/* 184 */     method = new Method();
/* 185 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 186 */     method.setName("clear");
/* 187 */     method.addBodyLine("oredCriteria.clear();");
/* 188 */     method.addBodyLine("orderByClause = null;");
/* 189 */     method.addBodyLine("distinct = false;");
/* 190 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/* 191 */     topLevelClass.addMethod(method);
/*     */ 
/* 194 */     topLevelClass.addInnerClass(getGeneratedCriteriaInnerClass(topLevelClass));
/*     */ 
/* 197 */     topLevelClass.addInnerClass(getCriteriaInnerClass(topLevelClass));
/*     */ 
/* 199 */     topLevelClass.addInnerClass(getCriterionInnerClass(topLevelClass));
/*     */ 
/* 201 */     List answer = new ArrayList();
/* 202 */     if (this.context.getPlugins().modelExampleClassGenerated(topLevelClass, this.introspectedTable))
/*     */     {
/* 204 */       answer.add(topLevelClass);
/*     */     }
/* 206 */     return answer;
/*     */   }
/*     */ 
/*     */   private InnerClass getCriterionInnerClass(TopLevelClass topLevelClass)
/*     */   {
/* 213 */     InnerClass answer = new InnerClass(new FullyQualifiedJavaType("Criterion"));
/*     */ 
/* 215 */     answer.setVisibility(JavaVisibility.PUBLIC);
/* 216 */     answer.setStatic(true);
/* 217 */     this.context.getCommentGenerator().addClassComment(answer, this.introspectedTable);
/*     */ 
/* 220 */     Field field = new Field();
/* 221 */     field.setName("condition");
/* 222 */     field.setType(FullyQualifiedJavaType.getStringInstance());
/* 223 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 224 */     answer.addField(field);
/* 225 */     answer.addMethod(getGetter(field));
/*     */ 
/* 227 */     field = new Field();
/* 228 */     field.setName("value");
/* 229 */     field.setType(FullyQualifiedJavaType.getObjectInstance());
/* 230 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 231 */     answer.addField(field);
/* 232 */     answer.addMethod(getGetter(field));
/*     */ 
/* 234 */     field = new Field();
/* 235 */     field.setName("secondValue");
/* 236 */     field.setType(FullyQualifiedJavaType.getObjectInstance());
/* 237 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 238 */     answer.addField(field);
/* 239 */     answer.addMethod(getGetter(field));
/*     */ 
/* 241 */     field = new Field();
/* 242 */     field.setName("noValue");
/* 243 */     field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/* 244 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 245 */     answer.addField(field);
/* 246 */     answer.addMethod(getGetter(field));
/*     */ 
/* 248 */     field = new Field();
/* 249 */     field.setName("singleValue");
/* 250 */     field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/* 251 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 252 */     answer.addField(field);
/* 253 */     answer.addMethod(getGetter(field));
/*     */ 
/* 255 */     field = new Field();
/* 256 */     field.setName("betweenValue");
/* 257 */     field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/* 258 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 259 */     answer.addField(field);
/* 260 */     answer.addMethod(getGetter(field));
/*     */ 
/* 262 */     field = new Field();
/* 263 */     field.setName("listValue");
/* 264 */     field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/* 265 */     field.setVisibility(JavaVisibility.PRIVATE);
/* 266 */     answer.addField(field);
/* 267 */     answer.addMethod(getGetter(field));
/*     */ 
/* 269 */     Method method = new Method();
/* 270 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 271 */     method.setName("Criterion");
/* 272 */     method.setConstructor(true);
/* 273 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 275 */     method.addBodyLine("super();");
/* 276 */     method.addBodyLine("this.condition = condition;");
/* 277 */     method.addBodyLine("this.noValue = true;");
/* 278 */     answer.addMethod(method);
/*     */ 
/* 280 */     method = new Method();
/* 281 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 282 */     method.setName("Criterion");
/* 283 */     method.setConstructor(true);
/* 284 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 286 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value"));
/*     */ 
/* 288 */     method.addBodyLine("super();");
/* 289 */     method.addBodyLine("this.condition = condition;");
/* 290 */     method.addBodyLine("this.value = value;");
/* 291 */     method.addBodyLine("if (value instanceof List<?>) {");
/* 292 */     method.addBodyLine("this.listValue = true;");
/* 293 */     method.addBodyLine("} else {");
/* 294 */     method.addBodyLine("this.singleValue = true;");
/* 295 */     method.addBodyLine("}");
/* 296 */     answer.addMethod(method);
/*     */ 
/* 298 */     method = new Method();
/* 299 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 300 */     method.setName("Criterion");
/* 301 */     method.setConstructor(true);
/* 302 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 304 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value"));
/*     */ 
/* 306 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "secondValue"));
/*     */ 
/* 308 */     method.addBodyLine("super();");
/* 309 */     method.addBodyLine("this.condition = condition;");
/* 310 */     method.addBodyLine("this.value = value;");
/* 311 */     method.addBodyLine("this.secondValue = secondValue;");
/* 312 */     method.addBodyLine("this.betweenValue = true;");
/* 313 */     answer.addMethod(method);
/*     */ 
/* 315 */     return answer;
/*     */   }
/*     */ 
/*     */   private InnerClass getCriteriaInnerClass(TopLevelClass topLevelClass)
/*     */   {
/* 321 */     InnerClass answer = new InnerClass(FullyQualifiedJavaType.getCriteriaInstance());
/*     */ 
/* 324 */     answer.setVisibility(JavaVisibility.PUBLIC);
/* 325 */     answer.setStatic(true);
/* 326 */     answer.setSuperClass(FullyQualifiedJavaType.getGeneratedCriteriaInstance());
/*     */ 
/* 329 */     this.context.getCommentGenerator().addClassComment(answer, this.introspectedTable, true);
/*     */ 
/* 332 */     Method method = new Method();
/* 333 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 334 */     method.setName("Criteria");
/* 335 */     method.setConstructor(true);
/* 336 */     method.addBodyLine("super();");
/* 337 */     answer.addMethod(method);
/*     */ 
/* 339 */     return answer;
/*     */   }
/*     */ 
/*     */   private InnerClass getGeneratedCriteriaInnerClass(TopLevelClass topLevelClass)
/*     */   {
/* 347 */     InnerClass answer = new InnerClass(FullyQualifiedJavaType.getGeneratedCriteriaInstance());
/*     */ 
/* 350 */     answer.setVisibility(JavaVisibility.PROTECTED);
/* 351 */     answer.setStatic(true);
/* 352 */     answer.setAbstract(true);
/* 353 */     this.context.getCommentGenerator().addClassComment(answer, this.introspectedTable);
/*     */ 
/* 356 */     Method method = new Method();
/* 357 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 358 */     method.setName("GeneratedCriteria");
/* 359 */     method.setConstructor(true);
/* 360 */     method.addBodyLine("super();");
/* 361 */     method.addBodyLine("criteria = new ArrayList<Criterion>();");
/* 362 */     answer.addMethod(method);
/*     */ 
/* 364 */     List criteriaLists = new ArrayList();
/* 365 */     criteriaLists.add("criteria");
/*     */ 
/* 367 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*     */     {
/* 369 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */       {
/* 371 */         String name = addtypeHandledObjectsAndMethods(introspectedColumn, method, answer);
/*     */ 
/* 373 */         criteriaLists.add(name);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 378 */     method = new Method();
/* 379 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 380 */     method.setName("isValid");
/* 381 */     method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/*     */ 
/* 383 */     StringBuilder sb = new StringBuilder();
/* 384 */     Iterator strIter = criteriaLists.iterator();
/* 385 */     sb.append("return ");
/* 386 */     sb.append((String)strIter.next());
/* 387 */     sb.append(".size() > 0");
/* 388 */     if (!strIter.hasNext()) {
/* 389 */       sb.append(';');
/*     */     }
/* 391 */     method.addBodyLine(sb.toString());
/* 392 */     while (strIter.hasNext()) {
/* 393 */       sb.setLength(0);
/* 394 */       OutputUtilities.javaIndent(sb, 1);
/* 395 */       sb.append("|| ");
/* 396 */       sb.append((String)strIter.next());
/* 397 */       sb.append(".size() > 0");
/* 398 */       if (!strIter.hasNext()) {
/* 399 */         sb.append(';');
/*     */       }
/* 401 */       method.addBodyLine(sb.toString());
/*     */     }
/* 403 */     answer.addMethod(method);
/*     */ 
/* 407 */     topLevelClass.addImportedType(FullyQualifiedJavaType.getNewListInstance());
/*     */ 
/* 409 */     topLevelClass.addImportedType(FullyQualifiedJavaType.getNewArrayListInstance());
/*     */ 
/* 412 */     Field field = new Field();
/* 413 */     field.setVisibility(JavaVisibility.PROTECTED);
/* 414 */     FullyQualifiedJavaType listOfCriterion = new FullyQualifiedJavaType("java.util.List<Criterion>");
/*     */ 
/* 416 */     field.setType(listOfCriterion);
/* 417 */     field.setName("criteria");
/* 418 */     answer.addField(field);
/*     */ 
/* 420 */     method = new Method();
/* 421 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 422 */     method.setReturnType(field.getType());
/* 423 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*     */ 
/* 425 */     method.addBodyLine("return criteria;");
/* 426 */     answer.addMethod(method);
/*     */ 
/* 429 */     method = new Method();
/* 430 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 431 */     method.setName("addCriterion");
/* 432 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 434 */     method.addBodyLine("if (condition == null) {");
/* 435 */     method.addBodyLine("throw new RuntimeException(\"Value for condition cannot be null\");");
/*     */ 
/* 437 */     method.addBodyLine("}");
/* 438 */     method.addBodyLine("criteria.add(new Criterion(condition));");
/* 439 */     answer.addMethod(method);
/*     */ 
/* 441 */     method = new Method();
/* 442 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 443 */     method.setName("addCriterion");
/* 444 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 446 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value"));
/*     */ 
/* 448 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 450 */     method.addBodyLine("if (value == null) {");
/* 451 */     method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*     */ 
/* 453 */     method.addBodyLine("}");
/* 454 */     method.addBodyLine("criteria.add(new Criterion(condition, value));");
/* 455 */     answer.addMethod(method);
/*     */ 
/* 457 */     method = new Method();
/* 458 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 459 */     method.setName("addCriterion");
/* 460 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 462 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value1"));
/*     */ 
/* 464 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value2"));
/*     */ 
/* 466 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 468 */     method.addBodyLine("if (value1 == null || value2 == null) {");
/* 469 */     method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*     */ 
/* 471 */     method.addBodyLine("}");
/* 472 */     method.addBodyLine("criteria.add(new Criterion(condition, value1, value2));");
/*     */ 
/* 474 */     answer.addMethod(method);
/*     */ 
/* 476 */     FullyQualifiedJavaType listOfDates = new FullyQualifiedJavaType("java.util.List<java.util.Date>");
/*     */ 
/* 479 */     if (this.introspectedTable.hasJDBCDateColumns()) {
/* 480 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getDateInstance());
/*     */ 
/* 482 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getNewIteratorInstance());
/*     */ 
/* 484 */       method = new Method();
/* 485 */       method.setVisibility(JavaVisibility.PROTECTED);
/* 486 */       method.setName("addCriterionForJDBCDate");
/* 487 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 489 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value"));
/*     */ 
/* 491 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 493 */       method.addBodyLine("if (value == null) {");
/* 494 */       method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*     */ 
/* 496 */       method.addBodyLine("}");
/* 497 */       method.addBodyLine("addCriterion(condition, new java.sql.Date(value.getTime()), property);");
/*     */ 
/* 499 */       answer.addMethod(method);
/*     */ 
/* 501 */       method = new Method();
/* 502 */       method.setVisibility(JavaVisibility.PROTECTED);
/* 503 */       method.setName("addCriterionForJDBCDate");
/* 504 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 506 */       method.addParameter(new Parameter(listOfDates, "values"));
/* 507 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 509 */       method.addBodyLine("if (values == null || values.size() == 0) {");
/* 510 */       method.addBodyLine("throw new RuntimeException(\"Value list for \" + property + \" cannot be null or empty\");");
/*     */ 
/* 512 */       method.addBodyLine("}");
/* 513 */       method.addBodyLine("List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();");
/*     */ 
/* 515 */       method.addBodyLine("Iterator<Date> iter = values.iterator();");
/* 516 */       method.addBodyLine("while (iter.hasNext()) {");
/* 517 */       method.addBodyLine("dateList.add(new java.sql.Date(iter.next().getTime()));");
/*     */ 
/* 519 */       method.addBodyLine("}");
/* 520 */       method.addBodyLine("addCriterion(condition, dateList, property);");
/* 521 */       answer.addMethod(method);
/*     */ 
/* 523 */       method = new Method();
/* 524 */       method.setVisibility(JavaVisibility.PROTECTED);
/* 525 */       method.setName("addCriterionForJDBCDate");
/* 526 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 528 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value1"));
/*     */ 
/* 530 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value2"));
/*     */ 
/* 532 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 534 */       method.addBodyLine("if (value1 == null || value2 == null) {");
/* 535 */       method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*     */ 
/* 537 */       method.addBodyLine("}");
/* 538 */       method.addBodyLine("addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);");
/*     */ 
/* 540 */       answer.addMethod(method);
/*     */     }
/*     */ 
/* 543 */     if (this.introspectedTable.hasJDBCTimeColumns()) {
/* 544 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getDateInstance());
/*     */ 
/* 546 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getNewIteratorInstance());
/*     */ 
/* 548 */       method = new Method();
/* 549 */       method.setVisibility(JavaVisibility.PROTECTED);
/* 550 */       method.setName("addCriterionForJDBCTime");
/* 551 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 553 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value"));
/*     */ 
/* 555 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 557 */       method.addBodyLine("if (value == null) {");
/* 558 */       method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*     */ 
/* 560 */       method.addBodyLine("}");
/* 561 */       method.addBodyLine("addCriterion(condition, new java.sql.Time(value.getTime()), property);");
/*     */ 
/* 563 */       answer.addMethod(method);
/*     */ 
/* 565 */       method = new Method();
/* 566 */       method.setVisibility(JavaVisibility.PROTECTED);
/* 567 */       method.setName("addCriterionForJDBCTime");
/* 568 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 570 */       method.addParameter(new Parameter(listOfDates, "values"));
/* 571 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 573 */       method.addBodyLine("if (values == null || values.size() == 0) {");
/* 574 */       method.addBodyLine("throw new RuntimeException(\"Value list for \" + property + \" cannot be null or empty\");");
/*     */ 
/* 576 */       method.addBodyLine("}");
/* 577 */       method.addBodyLine("List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();");
/*     */ 
/* 579 */       method.addBodyLine("Iterator<Date> iter = values.iterator();");
/* 580 */       method.addBodyLine("while (iter.hasNext()) {");
/* 581 */       method.addBodyLine("timeList.add(new java.sql.Time(iter.next().getTime()));");
/*     */ 
/* 583 */       method.addBodyLine("}");
/* 584 */       method.addBodyLine("addCriterion(condition, timeList, property);");
/* 585 */       answer.addMethod(method);
/*     */ 
/* 587 */       method = new Method();
/* 588 */       method.setVisibility(JavaVisibility.PROTECTED);
/* 589 */       method.setName("addCriterionForJDBCTime");
/* 590 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 592 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value1"));
/*     */ 
/* 594 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value2"));
/*     */ 
/* 596 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 598 */       method.addBodyLine("if (value1 == null || value2 == null) {");
/* 599 */       method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*     */ 
/* 601 */       method.addBodyLine("}");
/* 602 */       method.addBodyLine("addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);");
/*     */ 
/* 604 */       answer.addMethod(method);
/*     */     }
/*     */ 
/* 607 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*     */     {
/* 609 */       topLevelClass.addImportedType(introspectedColumn.getFullyQualifiedJavaType());
/*     */ 
/* 614 */       answer.addMethod(getSetNullMethod(introspectedColumn));
/* 615 */       answer.addMethod(getSetNotNullMethod(introspectedColumn));
/* 616 */       answer.addMethod(getSetEqualMethod(introspectedColumn));
/* 617 */       answer.addMethod(getSetNotEqualMethod(introspectedColumn));
/* 618 */       answer.addMethod(getSetGreaterThanMethod(introspectedColumn));
/* 619 */       answer.addMethod(getSetGreaterThenOrEqualMethod(introspectedColumn));
/*     */ 
/* 621 */       answer.addMethod(getSetLessThanMethod(introspectedColumn));
/* 622 */       answer.addMethod(getSetLessThanOrEqualMethod(introspectedColumn));
/*     */ 
/* 624 */       if (introspectedColumn.isJdbcCharacterColumn()) {
/* 625 */         answer.addMethod(getSetLikeMethod(introspectedColumn));
/* 626 */         answer.addMethod(getSetNotLikeMethod(introspectedColumn));
/*     */       }
/*     */ 
/* 629 */       answer.addMethod(getSetInOrNotInMethod(introspectedColumn, true));
/* 630 */       answer.addMethod(getSetInOrNotInMethod(introspectedColumn, false));
/* 631 */       answer.addMethod(getSetBetweenOrNotBetweenMethod(introspectedColumn, true));
/*     */ 
/* 633 */       answer.addMethod(getSetBetweenOrNotBetweenMethod(introspectedColumn, false));
/*     */     }
/*     */ 
/* 637 */     return answer;
/*     */   }
/*     */ 
/*     */   private Method getSetNullMethod(IntrospectedColumn introspectedColumn) {
/* 641 */     return getNoValueMethod(introspectedColumn, "IsNull", "is null");
/*     */   }
/*     */ 
/*     */   private Method getSetNotNullMethod(IntrospectedColumn introspectedColumn) {
/* 645 */     return getNoValueMethod(introspectedColumn, "IsNotNull", "is not null");
/*     */   }
/*     */ 
/*     */   private Method getSetEqualMethod(IntrospectedColumn introspectedColumn) {
/* 649 */     return getSingleValueMethod(introspectedColumn, "EqualTo", "=");
/*     */   }
/*     */ 
/*     */   private Method getSetNotEqualMethod(IntrospectedColumn introspectedColumn) {
/* 653 */     return getSingleValueMethod(introspectedColumn, "NotEqualTo", "<>");
/*     */   }
/*     */ 
/*     */   private Method getSetGreaterThanMethod(IntrospectedColumn introspectedColumn) {
/* 657 */     return getSingleValueMethod(introspectedColumn, "GreaterThan", ">");
/*     */   }
/*     */ 
/*     */   private Method getSetGreaterThenOrEqualMethod(IntrospectedColumn introspectedColumn)
/*     */   {
/* 662 */     return getSingleValueMethod(introspectedColumn, "GreaterThanOrEqualTo", ">=");
/*     */   }
/*     */ 
/*     */   private Method getSetLessThanMethod(IntrospectedColumn introspectedColumn)
/*     */   {
/* 667 */     return getSingleValueMethod(introspectedColumn, "LessThan", "<");
/*     */   }
/*     */ 
/*     */   private Method getSetLessThanOrEqualMethod(IntrospectedColumn introspectedColumn)
/*     */   {
/* 672 */     return getSingleValueMethod(introspectedColumn, "LessThanOrEqualTo", "<=");
/*     */   }
/*     */ 
/*     */   private Method getSetLikeMethod(IntrospectedColumn introspectedColumn)
/*     */   {
/* 677 */     return getSingleValueMethod(introspectedColumn, "Like", "like");
/*     */   }
/*     */ 
/*     */   private Method getSetNotLikeMethod(IntrospectedColumn introspectedColumn) {
/* 681 */     return getSingleValueMethod(introspectedColumn, "NotLike", "not like");
/*     */   }
/*     */ 
/*     */   private Method getSingleValueMethod(IntrospectedColumn introspectedColumn, String nameFragment, String operator)
/*     */   {
/* 686 */     Method method = new Method();
/* 687 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 688 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value"));
/*     */ 
/* 690 */     StringBuilder sb = new StringBuilder();
/* 691 */     sb.append(introspectedColumn.getJavaProperty());
/* 692 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 693 */     sb.insert(0, "and");
/* 694 */     sb.append(nameFragment);
/* 695 */     method.setName(sb.toString());
/* 696 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 697 */     sb.setLength(0);
/*     */ 
/* 699 */     if (introspectedColumn.isJDBCDateColumn()) {
/* 700 */       sb.append("addCriterionForJDBCDate(\"");
/* 701 */     } else if (introspectedColumn.isJDBCTimeColumn()) {
/* 702 */       sb.append("addCriterionForJDBCTime(\"");
/* 703 */     } else if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */     {
/* 705 */       sb.append("add");
/* 706 */       sb.append(introspectedColumn.getJavaProperty());
/* 707 */       sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 708 */       sb.append("Criterion(\"");
/*     */     } else {
/* 710 */       sb.append("addCriterion(\"");
/*     */     }
/*     */ 
/* 713 */     sb.append(MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*     */ 
/* 715 */     sb.append(' ');
/* 716 */     sb.append(operator);
/* 717 */     sb.append("\", ");
/*     */ 
/* 719 */     if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 720 */       sb.append("new ");
/* 721 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper().getShortName());
/*     */ 
/* 723 */       sb.append("(value)");
/*     */     } else {
/* 725 */       sb.append("value");
/*     */     }
/*     */ 
/* 728 */     sb.append(", \"");
/* 729 */     sb.append(introspectedColumn.getJavaProperty());
/* 730 */     sb.append("\");");
/* 731 */     method.addBodyLine(sb.toString());
/* 732 */     method.addBodyLine("return (Criteria) this;");
/*     */ 
/* 734 */     return method;
/*     */   }
/*     */ 
/*     */   private Method getSetBetweenOrNotBetweenMethod(IntrospectedColumn introspectedColumn, boolean betweenMethod)
/*     */   {
/* 746 */     Method method = new Method();
/* 747 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 748 */     FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/* 751 */     method.addParameter(new Parameter(type, "value1"));
/* 752 */     method.addParameter(new Parameter(type, "value2"));
/* 753 */     StringBuilder sb = new StringBuilder();
/* 754 */     sb.append(introspectedColumn.getJavaProperty());
/* 755 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 756 */     sb.insert(0, "and");
/* 757 */     if (betweenMethod)
/* 758 */       sb.append("Between");
/*     */     else {
/* 760 */       sb.append("NotBetween");
/*     */     }
/* 762 */     method.setName(sb.toString());
/* 763 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 764 */     sb.setLength(0);
/*     */ 
/* 766 */     if (introspectedColumn.isJDBCDateColumn()) {
/* 767 */       sb.append("addCriterionForJDBCDate(\"");
/* 768 */     } else if (introspectedColumn.isJDBCTimeColumn()) {
/* 769 */       sb.append("addCriterionForJDBCTime(\"");
/* 770 */     } else if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */     {
/* 772 */       sb.append("add");
/* 773 */       sb.append(introspectedColumn.getJavaProperty());
/* 774 */       sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 775 */       sb.append("Criterion(\"");
/*     */     } else {
/* 777 */       sb.append("addCriterion(\"");
/*     */     }
/*     */ 
/* 780 */     sb.append(MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*     */ 
/* 782 */     if (betweenMethod)
/* 783 */       sb.append(" between");
/*     */     else {
/* 785 */       sb.append(" not between");
/*     */     }
/* 787 */     sb.append("\", ");
/* 788 */     if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 789 */       sb.append("new ");
/* 790 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper().getShortName());
/*     */ 
/* 792 */       sb.append("(value1), ");
/* 793 */       sb.append("new ");
/* 794 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper().getShortName());
/*     */ 
/* 796 */       sb.append("(value2)");
/*     */     } else {
/* 798 */       sb.append("value1, value2");
/*     */     }
/*     */ 
/* 801 */     sb.append(", \"");
/* 802 */     sb.append(introspectedColumn.getJavaProperty());
/* 803 */     sb.append("\");");
/* 804 */     method.addBodyLine(sb.toString());
/* 805 */     method.addBodyLine("return (Criteria) this;");
/*     */ 
/* 807 */     return method;
/*     */   }
/*     */ 
/*     */   private Method getSetInOrNotInMethod(IntrospectedColumn introspectedColumn, boolean inMethod)
/*     */   {
/* 820 */     Method method = new Method();
/* 821 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 822 */     FullyQualifiedJavaType type = FullyQualifiedJavaType.getNewListInstance();
/*     */ 
/* 824 */     if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 825 */       type.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper());
/*     */     }
/*     */     else {
/* 828 */       type.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType());
/*     */     }
/*     */ 
/* 833 */     method.addParameter(new Parameter(type, "values"));
/* 834 */     StringBuilder sb = new StringBuilder();
/* 835 */     sb.append(introspectedColumn.getJavaProperty());
/* 836 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 837 */     sb.insert(0, "and");
/* 838 */     if (inMethod)
/* 839 */       sb.append("In");
/*     */     else {
/* 841 */       sb.append("NotIn");
/*     */     }
/* 843 */     method.setName(sb.toString());
/* 844 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 845 */     sb.setLength(0);
/*     */ 
/* 847 */     if (introspectedColumn.isJDBCDateColumn()) {
/* 848 */       sb.append("addCriterionForJDBCDate(\"");
/* 849 */     } else if (introspectedColumn.isJDBCTimeColumn()) {
/* 850 */       sb.append("addCriterionForJDBCTime(\"");
/* 851 */     } else if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */     {
/* 853 */       sb.append("add");
/* 854 */       sb.append(introspectedColumn.getJavaProperty());
/* 855 */       sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 856 */       sb.append("Criterion(\"");
/*     */     } else {
/* 858 */       sb.append("addCriterion(\"");
/*     */     }
/*     */ 
/* 861 */     sb.append(MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*     */ 
/* 863 */     if (inMethod)
/* 864 */       sb.append(" in");
/*     */     else {
/* 866 */       sb.append(" not in");
/*     */     }
/* 868 */     sb.append("\", values, \"");
/* 869 */     sb.append(introspectedColumn.getJavaProperty());
/* 870 */     sb.append("\");");
/* 871 */     method.addBodyLine(sb.toString());
/* 872 */     method.addBodyLine("return (Criteria) this;");
/*     */ 
/* 874 */     return method;
/*     */   }
/*     */ 
/*     */   private Method getNoValueMethod(IntrospectedColumn introspectedColumn, String nameFragment, String operator)
/*     */   {
/* 879 */     Method method = new Method();
/* 880 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 881 */     StringBuilder sb = new StringBuilder();
/* 882 */     sb.append(introspectedColumn.getJavaProperty());
/* 883 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 884 */     sb.insert(0, "and");
/* 885 */     sb.append(nameFragment);
/* 886 */     method.setName(sb.toString());
/* 887 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 888 */     sb.setLength(0);
/* 889 */     sb.append("addCriterion(\"");
/* 890 */     sb.append(MyBatis3FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*     */ 
/* 892 */     sb.append(' ');
/* 893 */     sb.append(operator);
/* 894 */     sb.append("\");");
/* 895 */     method.addBodyLine(sb.toString());
/* 896 */     method.addBodyLine("return (Criteria) this;");
/*     */ 
/* 898 */     return method;
/*     */   }
/*     */ 
/*     */   private String addtypeHandledObjectsAndMethods(IntrospectedColumn introspectedColumn, Method constructor, InnerClass innerClass)
/*     */   {
/* 914 */     StringBuilder sb = new StringBuilder();
/*     */ 
/* 917 */     sb.setLength(0);
/* 918 */     sb.append(introspectedColumn.getJavaProperty());
/* 919 */     sb.append("Criteria");
/* 920 */     String answer = sb.toString();
/*     */ 
/* 922 */     Field field = new Field();
/* 923 */     field.setVisibility(JavaVisibility.PROTECTED);
/* 924 */     field.setType(new FullyQualifiedJavaType("java.util.List<Criterion>"));
/* 925 */     field.setName(answer);
/* 926 */     innerClass.addField(field);
/*     */ 
/* 928 */     Method method = new Method();
/* 929 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 930 */     method.setReturnType(field.getType());
/* 931 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*     */ 
/* 933 */     sb.insert(0, "return ");
/* 934 */     sb.append(';');
/* 935 */     method.addBodyLine(sb.toString());
/* 936 */     innerClass.addMethod(method);
/*     */ 
/* 939 */     sb.setLength(0);
/* 940 */     sb.append(field.getName());
/* 941 */     sb.append(" = new ArrayList<Criterion>();");
/* 942 */     constructor.addBodyLine(sb.toString());
/*     */ 
/* 945 */     method = new Method();
/* 946 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 947 */     sb.setLength(0);
/* 948 */     sb.append("add");
/* 949 */     sb.append(introspectedColumn.getJavaProperty());
/* 950 */     sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 951 */     sb.append("Criterion");
/*     */ 
/* 953 */     method.setName(sb.toString());
/* 954 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 956 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value"));
/*     */ 
/* 958 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 960 */     method.addBodyLine("if (value == null) {");
/* 961 */     method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*     */ 
/* 963 */     method.addBodyLine("}");
/*     */ 
/* 965 */     sb.setLength(0);
/* 966 */     sb.append(field.getName());
/* 967 */     sb.append(".add(new Criterion(condition, value));");
/* 968 */     method.addBodyLine(sb.toString());
/* 969 */     innerClass.addMethod(method);
/*     */ 
/* 971 */     sb.setLength(0);
/* 972 */     sb.append("add");
/* 973 */     sb.append(introspectedColumn.getJavaProperty());
/* 974 */     sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 975 */     sb.append("Criterion");
/*     */ 
/* 977 */     method = new Method();
/* 978 */     method.setVisibility(JavaVisibility.PROTECTED);
/* 979 */     method.setName(sb.toString());
/* 980 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*     */ 
/* 982 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value1"));
/*     */ 
/* 984 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value2"));
/*     */ 
/* 986 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*     */ 
/* 988 */     method.addBodyLine("if (value1 == null || value2 == null) {");
/* 989 */     method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*     */ 
/* 991 */     method.addBodyLine("}");
/*     */ 
/* 993 */     sb.setLength(0);
/* 994 */     sb.append(field.getName());
/* 995 */     sb.append(".add(new Criterion(condition, value1, value2));");
/* 996 */     method.addBodyLine(sb.toString());
/* 997 */     innerClass.addMethod(method);
/*     */ 
/* 999 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.model.ExampleGenerator
 * JD-Core Version:    0.6.0
 */