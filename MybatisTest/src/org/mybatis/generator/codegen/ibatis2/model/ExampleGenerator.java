/*      */ package org.mybatis.generator.codegen.ibatis2.model;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.mybatis.generator.api.CommentGenerator;
/*      */ import org.mybatis.generator.api.FullyQualifiedTable;
/*      */ import org.mybatis.generator.api.IntrospectedColumn;
/*      */ import org.mybatis.generator.api.IntrospectedTable;
/*      */ import org.mybatis.generator.api.Plugin;
/*      */ import org.mybatis.generator.api.ProgressCallback;
/*      */ import org.mybatis.generator.api.dom.OutputUtilities;
/*      */ import org.mybatis.generator.api.dom.java.CompilationUnit;
/*      */ import org.mybatis.generator.api.dom.java.Field;
/*      */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*      */ import org.mybatis.generator.api.dom.java.InnerClass;
/*      */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*      */ import org.mybatis.generator.api.dom.java.Method;
/*      */ import org.mybatis.generator.api.dom.java.Parameter;
/*      */ import org.mybatis.generator.api.dom.java.PrimitiveTypeWrapper;
/*      */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*      */ import org.mybatis.generator.codegen.AbstractJavaGenerator;
/*      */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*      */ import org.mybatis.generator.config.Context;
/*      */ import org.mybatis.generator.internal.rules.Rules;
/*      */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*      */ import org.mybatis.generator.internal.util.StringUtility;
/*      */ import org.mybatis.generator.internal.util.messages.Messages;
/*      */ 
/*      */ public class ExampleGenerator extends AbstractJavaGenerator
/*      */ {
/*      */   private boolean generateForJava5;
/*      */ 
/*      */   public ExampleGenerator(boolean generateForJava5)
/*      */   {
/*   52 */     this.generateForJava5 = generateForJava5;
/*      */   }
/*      */ 
/*      */   public List<CompilationUnit> getCompilationUnits()
/*      */   {
/*   57 */     FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
/*   58 */     this.progressCallback.startTask(Messages.getString("Progress.6", table.toString()));
/*      */ 
/*   60 */     CommentGenerator commentGenerator = this.context.getCommentGenerator();
/*      */ 
/*   62 */     FullyQualifiedJavaType type = new FullyQualifiedJavaType(this.introspectedTable.getExampleType());
/*      */ 
/*   64 */     TopLevelClass topLevelClass = new TopLevelClass(type);
/*   65 */     topLevelClass.setVisibility(JavaVisibility.PUBLIC);
/*   66 */     commentGenerator.addJavaFileComment(topLevelClass);
/*      */ 
/*   69 */     Method method = new Method();
/*   70 */     method.setVisibility(JavaVisibility.PUBLIC);
/*   71 */     method.setConstructor(true);
/*   72 */     method.setName(type.getShortName());
/*   73 */     if (this.generateForJava5)
/*   74 */       method.addBodyLine("oredCriteria = new ArrayList<Criteria>();");
/*      */     else {
/*   76 */       method.addBodyLine("oredCriteria = new ArrayList();");
/*      */     }
/*      */ 
/*   79 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*   80 */     topLevelClass.addMethod(method);
/*      */ 
/*   85 */     Rules rules = this.introspectedTable.getRules();
/*   86 */     if ((rules.generateUpdateByExampleSelective()) || (rules.generateUpdateByExampleWithBLOBs()) || (rules.generateUpdateByExampleWithoutBLOBs()))
/*      */     {
/*   89 */       method = new Method();
/*   90 */       method.setVisibility(JavaVisibility.PROTECTED);
/*   91 */       method.setConstructor(true);
/*   92 */       method.setName(type.getShortName());
/*   93 */       method.addParameter(new Parameter(type, "example"));
/*   94 */       method.addBodyLine("this.orderByClause = example.orderByClause;");
/*   95 */       method.addBodyLine("this.oredCriteria = example.oredCriteria;");
/*   96 */       method.addBodyLine("this.distinct = example.distinct;");
/*   97 */       commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*   98 */       topLevelClass.addMethod(method);
/*      */     }
/*      */ 
/*  102 */     Field field = new Field();
/*  103 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  104 */     field.setType(FullyQualifiedJavaType.getStringInstance());
/*  105 */     field.setName("orderByClause");
/*  106 */     commentGenerator.addFieldComment(field, this.introspectedTable);
/*  107 */     topLevelClass.addField(field);
/*      */ 
/*  109 */     method = new Method();
/*  110 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  111 */     method.setName("setOrderByClause");
/*  112 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "orderByClause"));
/*      */ 
/*  114 */     method.addBodyLine("this.orderByClause = orderByClause;");
/*  115 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  116 */     topLevelClass.addMethod(method);
/*      */ 
/*  118 */     method = new Method();
/*  119 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  120 */     method.setReturnType(FullyQualifiedJavaType.getStringInstance());
/*  121 */     method.setName("getOrderByClause");
/*  122 */     method.addBodyLine("return orderByClause;");
/*  123 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  124 */     topLevelClass.addMethod(method);
/*      */ 
/*  127 */     field = new Field();
/*  128 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  129 */     field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/*  130 */     field.setName("distinct");
/*  131 */     commentGenerator.addFieldComment(field, this.introspectedTable);
/*  132 */     topLevelClass.addField(field);
/*      */ 
/*  134 */     method = new Method();
/*  135 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  136 */     method.setName("setDistinct");
/*  137 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getBooleanPrimitiveInstance(), "distinct"));
/*      */ 
/*  139 */     method.addBodyLine("this.distinct = distinct;");
/*  140 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  141 */     topLevelClass.addMethod(method);
/*      */ 
/*  143 */     method = new Method();
/*  144 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  145 */     method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/*      */ 
/*  147 */     method.setName("isDistinct");
/*  148 */     method.addBodyLine("return distinct;");
/*  149 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  150 */     topLevelClass.addMethod(method);
/*      */ 
/*  153 */     field = new Field();
/*  154 */     field.setVisibility(JavaVisibility.PROTECTED);
/*      */     FullyQualifiedJavaType fqjt;
/*  157 */     if (this.generateForJava5)
/*  158 */       fqjt = new FullyQualifiedJavaType("java.util.List<Criteria>");
/*      */     else {
/*  160 */       fqjt = new FullyQualifiedJavaType("java.util.List");
/*      */     }
/*      */ 
/*  163 */     field.setType(fqjt);
/*  164 */     field.setName("oredCriteria");
/*  165 */     commentGenerator.addFieldComment(field, this.introspectedTable);
/*  166 */     topLevelClass.addField(field);
/*      */ 
/*  168 */     method = new Method();
/*  169 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  170 */     method.setReturnType(fqjt);
/*  171 */     method.setName("getOredCriteria");
/*  172 */     method.addBodyLine("return oredCriteria;");
/*  173 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  174 */     topLevelClass.addMethod(method);
/*      */ 
/*  176 */     method = new Method();
/*  177 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  178 */     method.setName("or");
/*  179 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getCriteriaInstance(), "criteria"));
/*      */ 
/*  181 */     method.addBodyLine("oredCriteria.add(criteria);");
/*  182 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  183 */     topLevelClass.addMethod(method);
/*      */ 
/*  185 */     method = new Method();
/*  186 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  187 */     method.setName("or");
/*  188 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/*  189 */     method.addBodyLine("Criteria criteria = createCriteriaInternal();");
/*  190 */     method.addBodyLine("oredCriteria.add(criteria);");
/*  191 */     method.addBodyLine("return criteria;");
/*  192 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  193 */     topLevelClass.addMethod(method);
/*      */ 
/*  195 */     method = new Method();
/*  196 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  197 */     method.setName("createCriteria");
/*  198 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/*  199 */     method.addBodyLine("Criteria criteria = createCriteriaInternal();");
/*  200 */     method.addBodyLine("if (oredCriteria.size() == 0) {");
/*  201 */     method.addBodyLine("oredCriteria.add(criteria);");
/*  202 */     method.addBodyLine("}");
/*  203 */     method.addBodyLine("return criteria;");
/*  204 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  205 */     topLevelClass.addMethod(method);
/*      */ 
/*  207 */     method = new Method();
/*  208 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  209 */     method.setName("createCriteriaInternal");
/*  210 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/*  211 */     method.addBodyLine("Criteria criteria = new Criteria();");
/*  212 */     method.addBodyLine("return criteria;");
/*  213 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  214 */     topLevelClass.addMethod(method);
/*      */ 
/*  216 */     method = new Method();
/*  217 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  218 */     method.setName("clear");
/*  219 */     method.addBodyLine("oredCriteria.clear();");
/*  220 */     method.addBodyLine("orderByClause = null;");
/*  221 */     method.addBodyLine("distinct = false;");
/*  222 */     commentGenerator.addGeneralMethodComment(method, this.introspectedTable);
/*  223 */     topLevelClass.addMethod(method);
/*      */ 
/*  226 */     topLevelClass.addInnerClass(getGeneratedCriteriaInnerClass(topLevelClass));
/*      */ 
/*  229 */     topLevelClass.addInnerClass(getCriteriaInnerClass(topLevelClass));
/*      */ 
/*  231 */     List answer = new ArrayList();
/*  232 */     if (this.context.getPlugins().modelExampleClassGenerated(topLevelClass, this.introspectedTable))
/*      */     {
/*  234 */       answer.add(topLevelClass);
/*      */     }
/*  236 */     return answer;
/*      */   }
/*      */ 
/*      */   private InnerClass getCriteriaInnerClass(TopLevelClass topLevelClass)
/*      */   {
/*  242 */     InnerClass answer = new InnerClass(FullyQualifiedJavaType.getCriteriaInstance());
/*      */ 
/*  245 */     answer.setVisibility(JavaVisibility.PUBLIC);
/*  246 */     answer.setStatic(true);
/*  247 */     answer.setSuperClass(FullyQualifiedJavaType.getGeneratedCriteriaInstance());
/*      */ 
/*  250 */     this.context.getCommentGenerator().addClassComment(answer, this.introspectedTable, true);
/*      */ 
/*  253 */     Method method = new Method();
/*  254 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  255 */     method.setName("Criteria");
/*  256 */     method.setConstructor(true);
/*  257 */     method.addBodyLine("super();");
/*  258 */     answer.addMethod(method);
/*      */ 
/*  260 */     return answer;
/*      */   }
/*      */ 
/*      */   private InnerClass getGeneratedCriteriaInnerClass(TopLevelClass topLevelClass)
/*      */   {
/*  268 */     InnerClass answer = new InnerClass(FullyQualifiedJavaType.getGeneratedCriteriaInstance());
/*      */ 
/*  271 */     answer.setVisibility(JavaVisibility.PROTECTED);
/*  272 */     answer.setStatic(true);
/*  273 */     answer.setAbstract(true);
/*  274 */     this.context.getCommentGenerator().addClassComment(answer, this.introspectedTable);
/*      */ 
/*  277 */     Method method = new Method();
/*  278 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  279 */     method.setName("GeneratedCriteria");
/*  280 */     method.setConstructor(true);
/*  281 */     method.addBodyLine("super();");
/*  282 */     if (this.generateForJava5) {
/*  283 */       method.addBodyLine("criteriaWithoutValue = new ArrayList<String>();");
/*      */ 
/*  285 */       method.addBodyLine("criteriaWithSingleValue = new ArrayList<Map<String, Object>>();");
/*      */ 
/*  287 */       method.addBodyLine("criteriaWithListValue = new ArrayList<Map<String, Object>>();");
/*      */ 
/*  289 */       method.addBodyLine("criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();");
/*      */     }
/*      */     else
/*      */     {
/*  293 */       method.addBodyLine("criteriaWithoutValue = new ArrayList();");
/*  294 */       method.addBodyLine("criteriaWithSingleValue = new ArrayList();");
/*  295 */       method.addBodyLine("criteriaWithListValue = new ArrayList();");
/*  296 */       method.addBodyLine("criteriaWithBetweenValue = new ArrayList();");
/*      */     }
/*  298 */     answer.addMethod(method);
/*      */ 
/*  300 */     List criteriaLists = new ArrayList();
/*  301 */     criteriaLists.add("criteriaWithoutValue");
/*  302 */     criteriaLists.add("criteriaWithSingleValue");
/*  303 */     criteriaLists.add("criteriaWithListValue");
/*  304 */     criteriaLists.add("criteriaWithBetweenValue");
/*      */ 
/*  306 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*      */     {
/*  308 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*      */       {
/*  310 */         criteriaLists.addAll(addtypeHandledObjectsAndMethods(introspectedColumn, method, answer));
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  316 */     method = new Method();
/*  317 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  318 */     method.setName("isValid");
/*  319 */     method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/*      */ 
/*  321 */     StringBuilder sb = new StringBuilder();
/*  322 */     Iterator strIter = criteriaLists.iterator();
/*  323 */     sb.append("return ");
/*  324 */     sb.append((String)strIter.next());
/*  325 */     sb.append(".size() > 0");
/*  326 */     method.addBodyLine(sb.toString());
/*  327 */     while (strIter.hasNext()) {
/*  328 */       sb.setLength(0);
/*  329 */       OutputUtilities.javaIndent(sb, 1);
/*  330 */       sb.append("|| ");
/*  331 */       sb.append((String)strIter.next());
/*  332 */       sb.append(".size() > 0");
/*  333 */       if (!strIter.hasNext()) {
/*  334 */         sb.append(';');
/*      */       }
/*  336 */       method.addBodyLine(sb.toString());
/*      */     }
/*  338 */     answer.addMethod(method);
/*      */ 
/*  342 */     topLevelClass.addImportedType(FullyQualifiedJavaType.getNewMapInstance());
/*      */ 
/*  344 */     topLevelClass.addImportedType(FullyQualifiedJavaType.getNewListInstance());
/*      */ 
/*  346 */     topLevelClass.addImportedType(FullyQualifiedJavaType.getNewHashMapInstance());
/*      */ 
/*  348 */     topLevelClass.addImportedType(FullyQualifiedJavaType.getNewArrayListInstance());
/*      */ 
/*  351 */     Field field = new Field();
/*  352 */     field.setVisibility(JavaVisibility.PROTECTED);
/*      */     FullyQualifiedJavaType listOfStrings;
/*  354 */     if (this.generateForJava5) {
/*  355 */       listOfStrings = new FullyQualifiedJavaType("java.util.List<java.lang.String>");
/*      */     }
/*      */     else {
/*  358 */       listOfStrings = new FullyQualifiedJavaType("java.util.List");
/*      */     }
/*  360 */     field.setType(listOfStrings);
/*  361 */     field.setName("criteriaWithoutValue");
/*  362 */     answer.addField(field);
/*      */ 
/*  364 */     method = new Method();
/*  365 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  366 */     method.setReturnType(field.getType());
/*  367 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  369 */     method.addBodyLine("return criteriaWithoutValue;");
/*  370 */     answer.addMethod(method);
/*      */     FullyQualifiedJavaType listOfMaps;
/*  373 */     if (this.generateForJava5) {
/*  374 */       listOfMaps = new FullyQualifiedJavaType("java.util.List<java.util.Map<java.lang.String, java.lang.Object>>");
/*      */     }
/*      */     else {
/*  377 */       listOfMaps = new FullyQualifiedJavaType("java.util.List");
/*      */     }
/*      */ 
/*  380 */     field = new Field();
/*  381 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  382 */     field.setType(listOfMaps);
/*  383 */     field.setName("criteriaWithSingleValue");
/*  384 */     answer.addField(field);
/*      */ 
/*  386 */     method = new Method();
/*  387 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  388 */     method.setReturnType(field.getType());
/*  389 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  391 */     method.addBodyLine("return criteriaWithSingleValue;");
/*  392 */     answer.addMethod(method);
/*      */ 
/*  394 */     field = new Field();
/*  395 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  396 */     field.setType(listOfMaps);
/*  397 */     field.setName("criteriaWithListValue");
/*  398 */     answer.addField(field);
/*      */ 
/*  400 */     method = new Method();
/*  401 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  402 */     method.setReturnType(field.getType());
/*  403 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  405 */     method.addBodyLine("return criteriaWithListValue;");
/*  406 */     answer.addMethod(method);
/*      */ 
/*  408 */     field = new Field();
/*  409 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  410 */     field.setType(listOfMaps);
/*  411 */     field.setName("criteriaWithBetweenValue");
/*  412 */     answer.addField(field);
/*      */ 
/*  414 */     method = new Method();
/*  415 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  416 */     method.setReturnType(field.getType());
/*  417 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  419 */     method.addBodyLine("return criteriaWithBetweenValue;");
/*  420 */     answer.addMethod(method);
/*      */ 
/*  423 */     method = new Method();
/*  424 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  425 */     method.setName("addCriterion");
/*  426 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  428 */     method.addBodyLine("if (condition == null) {");
/*  429 */     method.addBodyLine("throw new RuntimeException(\"Value for condition cannot be null\");");
/*      */ 
/*  431 */     method.addBodyLine("}");
/*  432 */     method.addBodyLine("criteriaWithoutValue.add(condition);");
/*  433 */     answer.addMethod(method);
/*      */ 
/*  435 */     method = new Method();
/*  436 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  437 */     method.setName("addCriterion");
/*  438 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  440 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value"));
/*      */ 
/*  442 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  444 */     method.addBodyLine("if (value == null) {");
/*  445 */     method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*      */ 
/*  447 */     method.addBodyLine("}");
/*  448 */     if (this.generateForJava5) {
/*  449 */       method.addBodyLine("Map<String, Object> map = new HashMap<String, Object>();");
/*      */     }
/*      */     else {
/*  452 */       method.addBodyLine("Map map = new HashMap();");
/*      */     }
/*      */ 
/*  455 */     method.addBodyLine("map.put(\"condition\", condition);");
/*  456 */     method.addBodyLine("map.put(\"value\", value);");
/*  457 */     method.addBodyLine("criteriaWithSingleValue.add(map);");
/*  458 */     answer.addMethod(method);
/*      */     FullyQualifiedJavaType listOfObjects;
/*  461 */     if (this.generateForJava5) {
/*  462 */       listOfObjects = new FullyQualifiedJavaType("java.util.List<? extends java.lang.Object>");
/*      */     }
/*      */     else {
/*  465 */       listOfObjects = new FullyQualifiedJavaType("java.util.List");
/*      */     }
/*      */ 
/*  468 */     method = new Method();
/*  469 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  470 */     method.setName("addCriterion");
/*  471 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  473 */     method.addParameter(new Parameter(listOfObjects, "values"));
/*  474 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  476 */     method.addBodyLine("if (values == null || values.size() == 0) {");
/*  477 */     method.addBodyLine("throw new RuntimeException(\"Value list for \" + property + \" cannot be null or empty\");");
/*      */ 
/*  479 */     method.addBodyLine("}");
/*  480 */     if (this.generateForJava5) {
/*  481 */       method.addBodyLine("Map<String, Object> map = new HashMap<String, Object>();");
/*      */     }
/*      */     else {
/*  484 */       method.addBodyLine("Map map = new HashMap();");
/*      */     }
/*      */ 
/*  487 */     method.addBodyLine("map.put(\"condition\", condition);");
/*  488 */     method.addBodyLine("map.put(\"values\", values);");
/*  489 */     method.addBodyLine("criteriaWithListValue.add(map);");
/*  490 */     answer.addMethod(method);
/*      */ 
/*  492 */     method = new Method();
/*  493 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  494 */     method.setName("addCriterion");
/*  495 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  497 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value1"));
/*      */ 
/*  499 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "value2"));
/*      */ 
/*  501 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  503 */     method.addBodyLine("if (value1 == null || value2 == null) {");
/*  504 */     method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*      */ 
/*  506 */     method.addBodyLine("}");
/*  507 */     if (this.generateForJava5)
/*  508 */       method.addBodyLine("List<Object> list = new ArrayList<Object>();");
/*      */     else {
/*  510 */       method.addBodyLine("List list = new ArrayList();");
/*      */     }
/*      */ 
/*  513 */     method.addBodyLine("list.add(value1);");
/*  514 */     method.addBodyLine("list.add(value2);");
/*  515 */     if (this.generateForJava5) {
/*  516 */       method.addBodyLine("Map<String, Object> map = new HashMap<String, Object>();");
/*      */     }
/*      */     else {
/*  519 */       method.addBodyLine("Map map = new HashMap();");
/*      */     }
/*  521 */     method.addBodyLine("map.put(\"condition\", condition);");
/*  522 */     method.addBodyLine("map.put(\"values\", list);");
/*  523 */     method.addBodyLine("criteriaWithBetweenValue.add(map);");
/*  524 */     answer.addMethod(method);
/*      */     FullyQualifiedJavaType listOfDates;
/*  527 */     if (this.generateForJava5) {
/*  528 */       listOfDates = new FullyQualifiedJavaType("java.util.List<java.util.Date>");
/*      */     }
/*      */     else {
/*  531 */       listOfDates = new FullyQualifiedJavaType("java.util.List");
/*      */     }
/*      */ 
/*  534 */     if (this.introspectedTable.hasJDBCDateColumns()) {
/*  535 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getDateInstance());
/*      */ 
/*  537 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getNewIteratorInstance());
/*      */ 
/*  539 */       method = new Method();
/*  540 */       method.setVisibility(JavaVisibility.PROTECTED);
/*  541 */       method.setName("addCriterionForJDBCDate");
/*  542 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  544 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value"));
/*      */ 
/*  546 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  548 */       method.addBodyLine("if (value == null) {");
/*  549 */       method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*      */ 
/*  551 */       method.addBodyLine("}");
/*  552 */       method.addBodyLine("addCriterion(condition, new java.sql.Date(value.getTime()), property);");
/*      */ 
/*  554 */       answer.addMethod(method);
/*      */ 
/*  556 */       method = new Method();
/*  557 */       method.setVisibility(JavaVisibility.PROTECTED);
/*  558 */       method.setName("addCriterionForJDBCDate");
/*  559 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  561 */       method.addParameter(new Parameter(listOfDates, "values"));
/*  562 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  564 */       method.addBodyLine("if (values == null || values.size() == 0) {");
/*  565 */       method.addBodyLine("throw new RuntimeException(\"Value list for \" + property + \" cannot be null or empty\");");
/*      */ 
/*  567 */       method.addBodyLine("}");
/*  568 */       if (this.generateForJava5) {
/*  569 */         method.addBodyLine("List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();");
/*      */ 
/*  571 */         method.addBodyLine("Iterator<Date> iter = values.iterator();");
/*  572 */         method.addBodyLine("while (iter.hasNext()) {");
/*  573 */         method.addBodyLine("dateList.add(new java.sql.Date(iter.next().getTime()));");
/*      */ 
/*  575 */         method.addBodyLine("}");
/*      */       } else {
/*  577 */         method.addBodyLine("List dateList = new ArrayList();");
/*  578 */         method.addBodyLine("Iterator iter = values.iterator();");
/*  579 */         method.addBodyLine("while (iter.hasNext()) {");
/*  580 */         method.addBodyLine("dateList.add(new java.sql.Date(((Date)iter.next()).getTime()));");
/*      */ 
/*  582 */         method.addBodyLine("}");
/*      */       }
/*  584 */       method.addBodyLine("addCriterion(condition, dateList, property);");
/*  585 */       answer.addMethod(method);
/*      */ 
/*  587 */       method = new Method();
/*  588 */       method.setVisibility(JavaVisibility.PROTECTED);
/*  589 */       method.setName("addCriterionForJDBCDate");
/*  590 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  592 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value1"));
/*      */ 
/*  594 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value2"));
/*      */ 
/*  596 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  598 */       method.addBodyLine("if (value1 == null || value2 == null) {");
/*  599 */       method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*      */ 
/*  601 */       method.addBodyLine("}");
/*  602 */       method.addBodyLine("addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);");
/*      */ 
/*  604 */       answer.addMethod(method);
/*      */     }
/*      */ 
/*  607 */     if (this.introspectedTable.hasJDBCTimeColumns()) {
/*  608 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getDateInstance());
/*      */ 
/*  610 */       topLevelClass.addImportedType(FullyQualifiedJavaType.getNewIteratorInstance());
/*      */ 
/*  612 */       method = new Method();
/*  613 */       method.setVisibility(JavaVisibility.PROTECTED);
/*  614 */       method.setName("addCriterionForJDBCTime");
/*  615 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  617 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value"));
/*      */ 
/*  619 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  621 */       method.addBodyLine("if (value == null) {");
/*  622 */       method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*      */ 
/*  624 */       method.addBodyLine("}");
/*  625 */       method.addBodyLine("addCriterion(condition, new java.sql.Time(value.getTime()), property);");
/*      */ 
/*  627 */       answer.addMethod(method);
/*      */ 
/*  629 */       method = new Method();
/*  630 */       method.setVisibility(JavaVisibility.PROTECTED);
/*  631 */       method.setName("addCriterionForJDBCTime");
/*  632 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  634 */       method.addParameter(new Parameter(listOfDates, "values"));
/*  635 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  637 */       method.addBodyLine("if (values == null || values.size() == 0) {");
/*  638 */       method.addBodyLine("throw new RuntimeException(\"Value list for \" + property + \" cannot be null or empty\");");
/*      */ 
/*  640 */       method.addBodyLine("}");
/*  641 */       if (this.generateForJava5) {
/*  642 */         method.addBodyLine("List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();");
/*      */ 
/*  644 */         method.addBodyLine("Iterator<Date> iter = values.iterator();");
/*  645 */         method.addBodyLine("while (iter.hasNext()) {");
/*  646 */         method.addBodyLine("timeList.add(new java.sql.Time(iter.next().getTime()));");
/*      */ 
/*  648 */         method.addBodyLine("}");
/*      */       } else {
/*  650 */         method.addBodyLine("List timeList = new ArrayList();");
/*  651 */         method.addBodyLine("Iterator iter = values.iterator();");
/*  652 */         method.addBodyLine("while (iter.hasNext()) {");
/*  653 */         method.addBodyLine("timeList.add(new java.sql.Time(((Date)iter.next()).getTime()));");
/*      */ 
/*  655 */         method.addBodyLine("}");
/*      */       }
/*  657 */       method.addBodyLine("addCriterion(condition, timeList, property);");
/*  658 */       answer.addMethod(method);
/*      */ 
/*  660 */       method = new Method();
/*  661 */       method.setVisibility(JavaVisibility.PROTECTED);
/*  662 */       method.setName("addCriterionForJDBCTime");
/*  663 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  665 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value1"));
/*      */ 
/*  667 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getDateInstance(), "value2"));
/*      */ 
/*  669 */       method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  671 */       method.addBodyLine("if (value1 == null || value2 == null) {");
/*  672 */       method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*      */ 
/*  674 */       method.addBodyLine("}");
/*  675 */       method.addBodyLine("addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);");
/*      */ 
/*  677 */       answer.addMethod(method);
/*      */     }
/*      */ 
/*  680 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*      */     {
/*  682 */       topLevelClass.addImportedType(introspectedColumn.getFullyQualifiedJavaType());
/*      */ 
/*  687 */       answer.addMethod(getSetNullMethod(introspectedColumn));
/*  688 */       answer.addMethod(getSetNotNullMethod(introspectedColumn));
/*  689 */       answer.addMethod(getSetEqualMethod(introspectedColumn));
/*  690 */       answer.addMethod(getSetNotEqualMethod(introspectedColumn));
/*  691 */       answer.addMethod(getSetGreaterThanMethod(introspectedColumn));
/*  692 */       answer.addMethod(getSetGreaterThenOrEqualMethod(introspectedColumn));
/*      */ 
/*  694 */       answer.addMethod(getSetLessThanMethod(introspectedColumn));
/*  695 */       answer.addMethod(getSetLessThanOrEqualMethod(introspectedColumn));
/*      */ 
/*  697 */       if (introspectedColumn.isJdbcCharacterColumn()) {
/*  698 */         answer.addMethod(getSetLikeMethod(introspectedColumn));
/*  699 */         answer.addMethod(getSetNotLikeMethod(introspectedColumn));
/*      */       }
/*      */ 
/*  702 */       answer.addMethod(getSetInOrNotInMethod(introspectedColumn, true));
/*  703 */       answer.addMethod(getSetInOrNotInMethod(introspectedColumn, false));
/*  704 */       answer.addMethod(getSetBetweenOrNotBetweenMethod(introspectedColumn, true));
/*      */ 
/*  706 */       answer.addMethod(getSetBetweenOrNotBetweenMethod(introspectedColumn, false));
/*      */     }
/*      */ 
/*  710 */     return answer;
/*      */   }
/*      */ 
/*      */   private List<String> addtypeHandledObjectsAndMethods(IntrospectedColumn introspectedColumn, Method constructor, InnerClass innerClass)
/*      */   {
/*  726 */     List answer = new ArrayList();
/*  727 */     StringBuilder sb = new StringBuilder();
/*      */     FullyQualifiedJavaType listOfMaps;
/*  731 */     if (this.generateForJava5) {
/*  732 */       listOfMaps = new FullyQualifiedJavaType("java.util.List<java.util.Map<java.lang.String, java.lang.Object>>");
/*      */     }
/*      */     else {
/*  735 */       listOfMaps = new FullyQualifiedJavaType("java.util.List");
/*      */     }
/*      */ 
/*  738 */     sb.setLength(0);
/*  739 */     sb.append(introspectedColumn.getJavaProperty());
/*  740 */     sb.append("CriteriaWithSingleValue");
/*  741 */     answer.add(sb.toString());
/*      */ 
/*  743 */     Field field = new Field();
/*  744 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  745 */     field.setType(listOfMaps);
/*  746 */     field.setName(sb.toString());
/*  747 */     innerClass.addField(field);
/*      */ 
/*  749 */     Method method = new Method();
/*  750 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  751 */     method.setReturnType(field.getType());
/*  752 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  754 */     sb.insert(0, "return ");
/*  755 */     sb.append(';');
/*  756 */     method.addBodyLine(sb.toString());
/*  757 */     innerClass.addMethod(method);
/*      */ 
/*  759 */     sb.setLength(0);
/*  760 */     sb.append(introspectedColumn.getJavaProperty());
/*  761 */     sb.append("CriteriaWithListValue");
/*  762 */     answer.add(sb.toString());
/*      */ 
/*  764 */     field = new Field();
/*  765 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  766 */     field.setType(listOfMaps);
/*  767 */     field.setName(sb.toString());
/*  768 */     innerClass.addField(field);
/*      */ 
/*  770 */     method = new Method();
/*  771 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  772 */     method.setReturnType(field.getType());
/*  773 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  775 */     sb.insert(0, "return ");
/*  776 */     sb.append(';');
/*  777 */     method.addBodyLine(sb.toString());
/*  778 */     innerClass.addMethod(method);
/*      */ 
/*  780 */     sb.setLength(0);
/*  781 */     sb.append(introspectedColumn.getJavaProperty());
/*  782 */     sb.append("CriteriaWithBetweenValue");
/*  783 */     answer.add(sb.toString());
/*      */ 
/*  785 */     field = new Field();
/*  786 */     field.setVisibility(JavaVisibility.PROTECTED);
/*  787 */     field.setType(listOfMaps);
/*  788 */     field.setName(sb.toString());
/*  789 */     innerClass.addField(field);
/*      */ 
/*  791 */     method = new Method();
/*  792 */     method.setVisibility(JavaVisibility.PUBLIC);
/*  793 */     method.setReturnType(field.getType());
/*  794 */     method.setName(JavaBeansUtil.getGetterMethodName(field.getName(), field.getType()));
/*      */ 
/*  796 */     sb.insert(0, "return ");
/*  797 */     sb.append(';');
/*  798 */     method.addBodyLine(sb.toString());
/*  799 */     innerClass.addMethod(method);
/*      */ 
/*  802 */     sb.setLength(0);
/*  803 */     sb.append(introspectedColumn.getJavaProperty());
/*  804 */     if (this.generateForJava5) {
/*  805 */       sb.append("CriteriaWithSingleValue = new ArrayList<Map<String, Object>>();");
/*      */     }
/*      */     else {
/*  808 */       sb.append("CriteriaWithSingleValue = new ArrayList();");
/*      */     }
/*  810 */     constructor.addBodyLine(sb.toString());
/*      */ 
/*  812 */     sb.setLength(0);
/*  813 */     sb.append(introspectedColumn.getJavaProperty());
/*  814 */     if (this.generateForJava5) {
/*  815 */       sb.append("CriteriaWithListValue = new ArrayList<Map<String, Object>>();");
/*      */     }
/*      */     else {
/*  818 */       sb.append("CriteriaWithListValue = new ArrayList();");
/*      */     }
/*  820 */     constructor.addBodyLine(sb.toString());
/*      */ 
/*  822 */     sb.setLength(0);
/*  823 */     sb.append(introspectedColumn.getJavaProperty());
/*  824 */     if (this.generateForJava5) {
/*  825 */       sb.append("CriteriaWithBetweenValue = new ArrayList<Map<String, Object>>();");
/*      */     }
/*      */     else {
/*  828 */       sb.append("CriteriaWithBetweenValue = new ArrayList();");
/*      */     }
/*  830 */     constructor.addBodyLine(sb.toString());
/*      */ 
/*  833 */     method = new Method();
/*  834 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  835 */     sb.setLength(0);
/*  836 */     sb.append("add");
/*  837 */     sb.append(introspectedColumn.getJavaProperty());
/*  838 */     sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/*  839 */     sb.append("Criterion");
/*      */ 
/*  841 */     method.setName(sb.toString());
/*  842 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  844 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value"));
/*      */ 
/*  846 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  848 */     method.addBodyLine("if (value == null) {");
/*  849 */     method.addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");");
/*      */ 
/*  851 */     method.addBodyLine("}");
/*  852 */     if (this.generateForJava5) {
/*  853 */       method.addBodyLine("Map<String, Object> map = new HashMap<String, Object>();");
/*      */     }
/*      */     else {
/*  856 */       method.addBodyLine("Map map = new HashMap();");
/*      */     }
/*  858 */     method.addBodyLine("map.put(\"condition\", condition);");
/*  859 */     method.addBodyLine("map.put(\"value\", value);");
/*      */ 
/*  861 */     sb.setLength(0);
/*  862 */     sb.append(introspectedColumn.getJavaProperty());
/*  863 */     sb.append("CriteriaWithSingleValue.add(map);");
/*  864 */     method.addBodyLine(sb.toString());
/*  865 */     innerClass.addMethod(method);
/*      */ 
/*  867 */     FullyQualifiedJavaType listOfObjects = FullyQualifiedJavaType.getNewListInstance();
/*      */ 
/*  869 */     if (this.generateForJava5) {
/*  870 */       listOfObjects.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType());
/*      */     }
/*      */ 
/*  874 */     sb.setLength(0);
/*  875 */     sb.append("add");
/*  876 */     sb.append(introspectedColumn.getJavaProperty());
/*  877 */     sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/*  878 */     sb.append("Criterion");
/*      */ 
/*  880 */     method = new Method();
/*  881 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  882 */     method.setName(sb.toString());
/*  883 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  885 */     method.addParameter(new Parameter(listOfObjects, "values"));
/*  886 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  888 */     method.addBodyLine("if (values == null || values.size() == 0) {");
/*  889 */     method.addBodyLine("throw new RuntimeException(\"Value list for \" + property + \" cannot be null or empty\");");
/*      */ 
/*  891 */     method.addBodyLine("}");
/*  892 */     if (this.generateForJava5) {
/*  893 */       method.addBodyLine("Map<String, Object> map = new HashMap<String, Object>();");
/*      */     }
/*      */     else {
/*  896 */       method.addBodyLine("Map map = new HashMap();");
/*      */     }
/*  898 */     method.addBodyLine("map.put(\"condition\", condition);");
/*  899 */     method.addBodyLine("map.put(\"values\", values);");
/*      */ 
/*  901 */     sb.setLength(0);
/*  902 */     sb.append(introspectedColumn.getJavaProperty());
/*  903 */     sb.append("CriteriaWithListValue.add(map);");
/*  904 */     method.addBodyLine(sb.toString());
/*  905 */     innerClass.addMethod(method);
/*      */ 
/*  907 */     sb.setLength(0);
/*  908 */     sb.append("add");
/*  909 */     sb.append(introspectedColumn.getJavaProperty());
/*  910 */     sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/*  911 */     sb.append("Criterion");
/*      */ 
/*  913 */     method = new Method();
/*  914 */     method.setVisibility(JavaVisibility.PROTECTED);
/*  915 */     method.setName(sb.toString());
/*  916 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "condition"));
/*      */ 
/*  918 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value1"));
/*      */ 
/*  920 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value2"));
/*      */ 
/*  922 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getStringInstance(), "property"));
/*      */ 
/*  924 */     method.addBodyLine("if (value1 == null || value2 == null) {");
/*  925 */     method.addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");");
/*      */ 
/*  927 */     method.addBodyLine("}");
/*  928 */     if (this.generateForJava5) {
/*  929 */       sb.setLength(0);
/*  930 */       sb.append("List<");
/*  931 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getShortName());
/*      */ 
/*  933 */       sb.append("> list = new ArrayList<");
/*  934 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getShortName());
/*      */ 
/*  936 */       sb.append(">();");
/*  937 */       method.addBodyLine(sb.toString());
/*      */     } else {
/*  939 */       method.addBodyLine("List list = new ArrayList();");
/*      */     }
/*  941 */     method.addBodyLine("list.add(value1);");
/*  942 */     method.addBodyLine("list.add(value2);");
/*  943 */     if (this.generateForJava5) {
/*  944 */       method.addBodyLine("Map<String, Object> map = new HashMap<String, Object>();");
/*      */     }
/*      */     else {
/*  947 */       method.addBodyLine("Map map = new HashMap();");
/*      */     }
/*  949 */     method.addBodyLine("map.put(\"condition\", condition);");
/*  950 */     method.addBodyLine("map.put(\"values\", list);");
/*      */ 
/*  952 */     sb.setLength(0);
/*  953 */     sb.append(introspectedColumn.getJavaProperty());
/*  954 */     sb.append("CriteriaWithBetweenValue.add(map);");
/*  955 */     method.addBodyLine(sb.toString());
/*  956 */     innerClass.addMethod(method);
/*      */ 
/*  958 */     return answer;
/*      */   }
/*      */ 
/*      */   private Method getSetNullMethod(IntrospectedColumn introspectedColumn) {
/*  962 */     return getNoValueMethod(introspectedColumn, "IsNull", "is null");
/*      */   }
/*      */ 
/*      */   private Method getSetNotNullMethod(IntrospectedColumn introspectedColumn) {
/*  966 */     return getNoValueMethod(introspectedColumn, "IsNotNull", "is not null");
/*      */   }
/*      */ 
/*      */   private Method getSetEqualMethod(IntrospectedColumn introspectedColumn) {
/*  970 */     return getSingleValueMethod(introspectedColumn, "EqualTo", "=");
/*      */   }
/*      */ 
/*      */   private Method getSetNotEqualMethod(IntrospectedColumn introspectedColumn) {
/*  974 */     return getSingleValueMethod(introspectedColumn, "NotEqualTo", "<>");
/*      */   }
/*      */ 
/*      */   private Method getSetGreaterThanMethod(IntrospectedColumn introspectedColumn) {
/*  978 */     return getSingleValueMethod(introspectedColumn, "GreaterThan", ">");
/*      */   }
/*      */ 
/*      */   private Method getSetGreaterThenOrEqualMethod(IntrospectedColumn introspectedColumn)
/*      */   {
/*  983 */     return getSingleValueMethod(introspectedColumn, "GreaterThanOrEqualTo", ">=");
/*      */   }
/*      */ 
/*      */   private Method getSetLessThanMethod(IntrospectedColumn introspectedColumn)
/*      */   {
/*  988 */     return getSingleValueMethod(introspectedColumn, "LessThan", "<");
/*      */   }
/*      */ 
/*      */   private Method getSetLessThanOrEqualMethod(IntrospectedColumn introspectedColumn)
/*      */   {
/*  993 */     return getSingleValueMethod(introspectedColumn, "LessThanOrEqualTo", "<=");
/*      */   }
/*      */ 
/*      */   private Method getSetLikeMethod(IntrospectedColumn introspectedColumn)
/*      */   {
/*  998 */     return getSingleValueMethod(introspectedColumn, "Like", "like");
/*      */   }
/*      */ 
/*      */   private Method getSetNotLikeMethod(IntrospectedColumn introspectedColumn) {
/* 1002 */     return getSingleValueMethod(introspectedColumn, "NotLike", "not like");
/*      */   }
/*      */ 
/*      */   private Method getSingleValueMethod(IntrospectedColumn introspectedColumn, String nameFragment, String operator)
/*      */   {
/* 1007 */     Method method = new Method();
/* 1008 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 1009 */     method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value"));
/*      */ 
/* 1011 */     StringBuilder sb = new StringBuilder();
/* 1012 */     sb.append(introspectedColumn.getJavaProperty());
/* 1013 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 1014 */     sb.insert(0, "and");
/* 1015 */     sb.append(nameFragment);
/* 1016 */     method.setName(sb.toString());
/* 1017 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 1018 */     sb.setLength(0);
/*      */ 
/* 1020 */     if (introspectedColumn.isJDBCDateColumn()) {
/* 1021 */       sb.append("addCriterionForJDBCDate(\"");
/* 1022 */     } else if (introspectedColumn.isJDBCTimeColumn()) {
/* 1023 */       sb.append("addCriterionForJDBCTime(\"");
/* 1024 */     } else if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*      */     {
/* 1026 */       sb.append("add");
/* 1027 */       sb.append(introspectedColumn.getJavaProperty());
/* 1028 */       sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 1029 */       sb.append("Criterion(\"");
/*      */     } else {
/* 1031 */       sb.append("addCriterion(\"");
/*      */     }
/*      */ 
/* 1034 */     sb.append(Ibatis2FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*      */ 
/* 1036 */     sb.append(' ');
/* 1037 */     sb.append(operator);
/* 1038 */     sb.append("\", ");
/*      */ 
/* 1040 */     if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 1041 */       sb.append("new ");
/* 1042 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper().getShortName());
/*      */ 
/* 1044 */       sb.append("(value)");
/*      */     } else {
/* 1046 */       sb.append("value");
/*      */     }
/*      */ 
/* 1049 */     sb.append(", \"");
/* 1050 */     sb.append(introspectedColumn.getJavaProperty());
/* 1051 */     sb.append("\");");
/* 1052 */     method.addBodyLine(sb.toString());
/* 1053 */     method.addBodyLine("return (Criteria) this;");
/*      */ 
/* 1055 */     return method;
/*      */   }
/*      */ 
/*      */   private Method getSetBetweenOrNotBetweenMethod(IntrospectedColumn introspectedColumn, boolean betweenMethod)
/*      */   {
/* 1067 */     Method method = new Method();
/* 1068 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 1069 */     FullyQualifiedJavaType type = introspectedColumn.getFullyQualifiedJavaType();
/*      */ 
/* 1072 */     method.addParameter(new Parameter(type, "value1"));
/* 1073 */     method.addParameter(new Parameter(type, "value2"));
/* 1074 */     StringBuilder sb = new StringBuilder();
/* 1075 */     sb.append(introspectedColumn.getJavaProperty());
/* 1076 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 1077 */     sb.insert(0, "and");
/* 1078 */     if (betweenMethod)
/* 1079 */       sb.append("Between");
/*      */     else {
/* 1081 */       sb.append("NotBetween");
/*      */     }
/* 1083 */     method.setName(sb.toString());
/* 1084 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 1085 */     sb.setLength(0);
/*      */ 
/* 1087 */     if (introspectedColumn.isJDBCDateColumn()) {
/* 1088 */       sb.append("addCriterionForJDBCDate(\"");
/* 1089 */     } else if (introspectedColumn.isJDBCTimeColumn()) {
/* 1090 */       sb.append("addCriterionForJDBCTime(\"");
/* 1091 */     } else if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*      */     {
/* 1093 */       sb.append("add");
/* 1094 */       sb.append(introspectedColumn.getJavaProperty());
/* 1095 */       sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 1096 */       sb.append("Criterion(\"");
/*      */     } else {
/* 1098 */       sb.append("addCriterion(\"");
/*      */     }
/*      */ 
/* 1101 */     sb.append(Ibatis2FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*      */ 
/* 1103 */     if (betweenMethod)
/* 1104 */       sb.append(" between");
/*      */     else {
/* 1106 */       sb.append(" not between");
/*      */     }
/* 1108 */     sb.append("\", ");
/* 1109 */     if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 1110 */       sb.append("new ");
/* 1111 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper().getShortName());
/*      */ 
/* 1113 */       sb.append("(value1), ");
/* 1114 */       sb.append("new ");
/* 1115 */       sb.append(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper().getShortName());
/*      */ 
/* 1117 */       sb.append("(value2)");
/*      */     } else {
/* 1119 */       sb.append("value1, value2");
/*      */     }
/*      */ 
/* 1122 */     sb.append(", \"");
/* 1123 */     sb.append(introspectedColumn.getJavaProperty());
/* 1124 */     sb.append("\");");
/* 1125 */     method.addBodyLine(sb.toString());
/* 1126 */     method.addBodyLine("return (Criteria) this;");
/*      */ 
/* 1128 */     return method;
/*      */   }
/*      */ 
/*      */   private Method getSetInOrNotInMethod(IntrospectedColumn introspectedColumn, boolean inMethod)
/*      */   {
/* 1141 */     Method method = new Method();
/* 1142 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 1143 */     FullyQualifiedJavaType type = FullyQualifiedJavaType.getNewListInstance();
/*      */ 
/* 1145 */     if (this.generateForJava5) {
/* 1146 */       if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 1147 */         type.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType().getPrimitiveTypeWrapper());
/*      */       }
/*      */       else {
/* 1150 */         type.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType());
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1155 */     method.addParameter(new Parameter(type, "values"));
/* 1156 */     StringBuilder sb = new StringBuilder();
/* 1157 */     sb.append(introspectedColumn.getJavaProperty());
/* 1158 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 1159 */     sb.insert(0, "and");
/* 1160 */     if (inMethod)
/* 1161 */       sb.append("In");
/*      */     else {
/* 1163 */       sb.append("NotIn");
/*      */     }
/* 1165 */     method.setName(sb.toString());
/* 1166 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 1167 */     sb.setLength(0);
/*      */ 
/* 1169 */     if (introspectedColumn.isJDBCDateColumn()) {
/* 1170 */       sb.append("addCriterionForJDBCDate(\"");
/* 1171 */     } else if (introspectedColumn.isJDBCTimeColumn()) {
/* 1172 */       sb.append("addCriterionForJDBCTime(\"");
/* 1173 */     } else if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*      */     {
/* 1175 */       sb.append("add");
/* 1176 */       sb.append(introspectedColumn.getJavaProperty());
/* 1177 */       sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
/* 1178 */       sb.append("Criterion(\"");
/*      */     } else {
/* 1180 */       sb.append("addCriterion(\"");
/*      */     }
/*      */ 
/* 1183 */     sb.append(Ibatis2FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*      */ 
/* 1185 */     if (inMethod)
/* 1186 */       sb.append(" in");
/*      */     else {
/* 1188 */       sb.append(" not in");
/*      */     }
/* 1190 */     sb.append("\", values, \"");
/* 1191 */     sb.append(introspectedColumn.getJavaProperty());
/* 1192 */     sb.append("\");");
/* 1193 */     method.addBodyLine(sb.toString());
/* 1194 */     method.addBodyLine("return (Criteria) this;");
/*      */ 
/* 1196 */     return method;
/*      */   }
/*      */ 
/*      */   private Method getNoValueMethod(IntrospectedColumn introspectedColumn, String nameFragment, String operator)
/*      */   {
/* 1201 */     Method method = new Method();
/* 1202 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 1203 */     StringBuilder sb = new StringBuilder();
/* 1204 */     sb.append(introspectedColumn.getJavaProperty());
/* 1205 */     sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/* 1206 */     sb.insert(0, "and");
/* 1207 */     sb.append(nameFragment);
/* 1208 */     method.setName(sb.toString());
/* 1209 */     method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/* 1210 */     sb.setLength(0);
/* 1211 */     sb.append("addCriterion(\"");
/* 1212 */     sb.append(Ibatis2FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*      */ 
/* 1214 */     sb.append(' ');
/* 1215 */     sb.append(operator);
/* 1216 */     sb.append("\");");
/* 1217 */     method.addBodyLine(sb.toString());
/* 1218 */     method.addBodyLine("return (Criteria) this;");
/*      */ 
/* 1220 */     return method;
/*      */   }
/*      */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator
 * JD-Core Version:    0.6.0
 */