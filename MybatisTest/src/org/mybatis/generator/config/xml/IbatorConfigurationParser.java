/*     */ package org.mybatis.generator.config.xml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.config.ColumnOverride;
/*     */ import org.mybatis.generator.config.ColumnRenamingRule;
/*     */ import org.mybatis.generator.config.CommentGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.config.IgnoredColumn;
/*     */ import org.mybatis.generator.config.JDBCConnectionConfiguration;
/*     */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.JavaTypeResolverConfiguration;
/*     */ import org.mybatis.generator.config.ModelType;
/*     */ import org.mybatis.generator.config.PluginConfiguration;
/*     */ import org.mybatis.generator.config.PropertyHolder;
/*     */ import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
/*     */ import org.mybatis.generator.config.TableConfiguration;
/*     */ import org.mybatis.generator.exception.XMLParserException;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class IbatorConfigurationParser
/*     */ {
/*     */   private Properties properties;
/*     */ 
/*     */   public IbatorConfigurationParser(Properties properties)
/*     */   {
/*  58 */     if (properties == null)
/*  59 */       this.properties = System.getProperties();
/*     */     else
/*  61 */       this.properties = properties;
/*     */   }
/*     */ 
/*     */   public Configuration parseIbatorConfiguration(Element rootNode)
/*     */     throws XMLParserException
/*     */   {
/*  68 */     Configuration configuration = new Configuration();
/*     */ 
/*  70 */     NodeList nodeList = rootNode.getChildNodes();
/*  71 */     for (int i = 0; i < nodeList.getLength(); i++) {
/*  72 */       Node childNode = nodeList.item(i);
/*     */ 
/*  74 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/*  78 */       if ("properties".equals(childNode.getNodeName()))
/*  79 */         parseProperties(configuration, childNode);
/*  80 */       else if ("classPathEntry".equals(childNode.getNodeName()))
/*  81 */         parseClassPathEntry(configuration, childNode);
/*  82 */       else if ("ibatorContext".equals(childNode.getNodeName())) {
/*  83 */         parseIbatorContext(configuration, childNode);
/*     */       }
/*     */     }
/*     */ 
/*  87 */     return configuration;
/*     */   }
/*     */ 
/*     */   private void parseProperties(Configuration configuration, Node node) throws XMLParserException
/*     */   {
/*  92 */     Properties attributes = parseAttributes(node);
/*  93 */     String resource = attributes.getProperty("resource");
/*  94 */     String url = attributes.getProperty("url");
/*     */ 
/*  96 */     if ((!StringUtility.stringHasValue(resource)) && (!StringUtility.stringHasValue(url)))
/*     */     {
/*  98 */       throw new XMLParserException(Messages.getString("RuntimeError.14"));
/*     */     }
/*     */ 
/* 101 */     if ((StringUtility.stringHasValue(resource)) && (StringUtility.stringHasValue(url)))
/*     */     {
/* 103 */       throw new XMLParserException(Messages.getString("RuntimeError.14"));
/*     */     }
/*     */     try
/*     */     {
/*     */       URL resourceUrl;
/* 109 */       if (StringUtility.stringHasValue(resource)) {
/* 110 */         resourceUrl = Thread.currentThread().getContextClassLoader().getResource(resource);
/*     */ 
/* 112 */         if (resourceUrl == null)
/* 113 */           throw new XMLParserException(Messages.getString("RuntimeError.15", resource));
/*     */       }
/*     */       else
/*     */       {
/* 117 */         resourceUrl = new URL(url);
/*     */       }
/*     */ 
/* 120 */       InputStream inputStream = resourceUrl.openConnection().getInputStream();
/*     */ 
/* 123 */       this.properties.load(inputStream);
/* 124 */       inputStream.close();
/*     */     } catch (IOException e) {
/* 126 */       if (StringUtility.stringHasValue(resource)) {
/* 127 */         throw new XMLParserException(Messages.getString("RuntimeError.16", resource));
/*     */       }
/*     */ 
/* 130 */       throw new XMLParserException(Messages.getString("RuntimeError.17", url));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseIbatorContext(Configuration configuration, Node node)
/*     */   {
/* 138 */     Properties attributes = parseAttributes(node);
/* 139 */     String defaultModelType = attributes.getProperty("defaultModelType");
/* 140 */     String targetRuntime = attributes.getProperty("targetRuntime");
/* 141 */     String introspectedColumnImpl = attributes.getProperty("introspectedColumnImpl");
/*     */ 
/* 143 */     String id = attributes.getProperty("id");
/*     */ 
/* 145 */     ModelType mt = defaultModelType == null ? null : ModelType.getModelType(defaultModelType);
/*     */ 
/* 148 */     Context context = new Context(mt);
/* 149 */     context.setId(id);
/* 150 */     if (StringUtility.stringHasValue(introspectedColumnImpl)) {
/* 151 */       context.setIntrospectedColumnImpl(introspectedColumnImpl);
/*     */     }
/* 153 */     if (StringUtility.stringHasValue(targetRuntime)) {
/* 154 */       context.setTargetRuntime(targetRuntime);
/*     */     }
/*     */ 
/* 157 */     configuration.addContext(context);
/*     */ 
/* 159 */     NodeList nodeList = node.getChildNodes();
/* 160 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 161 */       Node childNode = nodeList.item(i);
/*     */ 
/* 163 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 167 */       if ("property".equals(childNode.getNodeName()))
/* 168 */         parseProperty(context, childNode);
/* 169 */       else if ("ibatorPlugin".equals(childNode.getNodeName()))
/* 170 */         parseIbatorPlugin(context, childNode);
/* 171 */       else if ("commentGenerator".equals(childNode.getNodeName()))
/* 172 */         parseCommentGenerator(context, childNode);
/* 173 */       else if ("jdbcConnection".equals(childNode.getNodeName()))
/* 174 */         parseJdbcConnection(context, childNode);
/* 175 */       else if ("javaModelGenerator".equals(childNode.getNodeName()))
/* 176 */         parseJavaModelGenerator(context, childNode);
/* 177 */       else if ("javaTypeResolver".equals(childNode.getNodeName()))
/* 178 */         parseJavaTypeResolver(context, childNode);
/* 179 */       else if ("sqlMapGenerator".equals(childNode.getNodeName()))
/* 180 */         parseSqlMapGenerator(context, childNode);
/* 181 */       else if ("daoGenerator".equals(childNode.getNodeName()))
/* 182 */         parseDaoGenerator(context, childNode);
/* 183 */       else if ("table".equals(childNode.getNodeName()))
/* 184 */         parseTable(context, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseSqlMapGenerator(Context context, Node node)
/*     */   {
/* 190 */     SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
/*     */ 
/* 192 */     context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
/*     */ 
/* 194 */     Properties attributes = parseAttributes(node);
/* 195 */     String targetPackage = attributes.getProperty("targetPackage");
/* 196 */     String targetProject = attributes.getProperty("targetProject");
/*     */ 
/* 198 */     sqlMapGeneratorConfiguration.setTargetPackage(targetPackage);
/* 199 */     sqlMapGeneratorConfiguration.setTargetProject(targetProject);
/*     */ 
/* 201 */     NodeList nodeList = node.getChildNodes();
/* 202 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 203 */       Node childNode = nodeList.item(i);
/*     */ 
/* 205 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 209 */       if ("property".equals(childNode.getNodeName()))
/* 210 */         parseProperty(sqlMapGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseTable(Context context, Node node)
/*     */   {
/* 216 */     TableConfiguration tc = new TableConfiguration(context);
/* 217 */     context.addTableConfiguration(tc);
/*     */ 
/* 219 */     Properties attributes = parseAttributes(node);
/* 220 */     String catalog = attributes.getProperty("catalog");
/* 221 */     String schema = attributes.getProperty("schema");
/* 222 */     String tableName = attributes.getProperty("tableName");
/* 223 */     String domainObjectName = attributes.getProperty("domainObjectName");
/* 224 */     String alias = attributes.getProperty("alias");
/* 225 */     String enableInsert = attributes.getProperty("enableInsert");
/* 226 */     String enableSelectByPrimaryKey = attributes.getProperty("enableSelectByPrimaryKey");
/*     */ 
/* 228 */     String enableSelectByExample = attributes.getProperty("enableSelectByExample");
/*     */ 
/* 230 */     String enableUpdateByPrimaryKey = attributes.getProperty("enableUpdateByPrimaryKey");
/*     */ 
/* 232 */     String enableDeleteByPrimaryKey = attributes.getProperty("enableDeleteByPrimaryKey");
/*     */ 
/* 234 */     String enableDeleteByExample = attributes.getProperty("enableDeleteByExample");
/*     */ 
/* 236 */     String enableCountByExample = attributes.getProperty("enableCountByExample");
/*     */ 
/* 238 */     String enableUpdateByExample = attributes.getProperty("enableUpdateByExample");
/*     */ 
/* 240 */     String selectByPrimaryKeyQueryId = attributes.getProperty("selectByPrimaryKeyQueryId");
/*     */ 
/* 242 */     String selectByExampleQueryId = attributes.getProperty("selectByExampleQueryId");
/*     */ 
/* 244 */     String modelType = attributes.getProperty("modelType");
/* 245 */     String escapeWildcards = attributes.getProperty("escapeWildcards");
/* 246 */     String delimitIdentifiers = attributes.getProperty("delimitIdentifiers");
/*     */ 
/* 248 */     String delimitAllColumns = attributes.getProperty("delimitAllColumns");
/*     */ 
/* 250 */     if (StringUtility.stringHasValue(catalog)) {
/* 251 */       tc.setCatalog(catalog);
/*     */     }
/*     */ 
/* 254 */     if (StringUtility.stringHasValue(schema)) {
/* 255 */       tc.setSchema(schema);
/*     */     }
/*     */ 
/* 258 */     if (StringUtility.stringHasValue(tableName)) {
/* 259 */       tc.setTableName(tableName);
/*     */     }
/*     */ 
/* 262 */     if (StringUtility.stringHasValue(domainObjectName)) {
/* 263 */       tc.setDomainObjectName(domainObjectName);
/*     */     }
/*     */ 
/* 266 */     if (StringUtility.stringHasValue(alias)) {
/* 267 */       tc.setAlias(alias);
/*     */     }
/*     */ 
/* 270 */     if (StringUtility.stringHasValue(enableInsert)) {
/* 271 */       tc.setInsertStatementEnabled(StringUtility.isTrue(enableInsert));
/*     */     }
/*     */ 
/* 274 */     if (StringUtility.stringHasValue(enableSelectByPrimaryKey)) {
/* 275 */       tc.setSelectByPrimaryKeyStatementEnabled(StringUtility.isTrue(enableSelectByPrimaryKey));
/*     */     }
/*     */ 
/* 279 */     if (StringUtility.stringHasValue(enableSelectByExample)) {
/* 280 */       tc.setSelectByExampleStatementEnabled(StringUtility.isTrue(enableSelectByExample));
/*     */     }
/*     */ 
/* 284 */     if (StringUtility.stringHasValue(enableUpdateByPrimaryKey)) {
/* 285 */       tc.setUpdateByPrimaryKeyStatementEnabled(StringUtility.isTrue(enableUpdateByPrimaryKey));
/*     */     }
/*     */ 
/* 289 */     if (StringUtility.stringHasValue(enableDeleteByPrimaryKey)) {
/* 290 */       tc.setDeleteByPrimaryKeyStatementEnabled(StringUtility.isTrue(enableDeleteByPrimaryKey));
/*     */     }
/*     */ 
/* 294 */     if (StringUtility.stringHasValue(enableDeleteByExample)) {
/* 295 */       tc.setDeleteByExampleStatementEnabled(StringUtility.isTrue(enableDeleteByExample));
/*     */     }
/*     */ 
/* 299 */     if (StringUtility.stringHasValue(enableCountByExample)) {
/* 300 */       tc.setCountByExampleStatementEnabled(StringUtility.isTrue(enableCountByExample));
/*     */     }
/*     */ 
/* 304 */     if (StringUtility.stringHasValue(enableUpdateByExample)) {
/* 305 */       tc.setUpdateByExampleStatementEnabled(StringUtility.isTrue(enableUpdateByExample));
/*     */     }
/*     */ 
/* 309 */     if (StringUtility.stringHasValue(selectByPrimaryKeyQueryId)) {
/* 310 */       tc.setSelectByPrimaryKeyQueryId(selectByPrimaryKeyQueryId);
/*     */     }
/*     */ 
/* 313 */     if (StringUtility.stringHasValue(selectByExampleQueryId)) {
/* 314 */       tc.setSelectByExampleQueryId(selectByExampleQueryId);
/*     */     }
/*     */ 
/* 317 */     if (StringUtility.stringHasValue(modelType)) {
/* 318 */       tc.setConfiguredModelType(modelType);
/*     */     }
/*     */ 
/* 321 */     if (StringUtility.stringHasValue(escapeWildcards)) {
/* 322 */       tc.setWildcardEscapingEnabled(StringUtility.isTrue(escapeWildcards));
/*     */     }
/*     */ 
/* 327 */     if (StringUtility.stringHasValue(delimitIdentifiers)) {
/* 328 */       tc.setDelimitIdentifiers(StringUtility.isTrue(delimitIdentifiers));
/*     */     }
/*     */ 
/* 331 */     if (StringUtility.stringHasValue(delimitAllColumns)) {
/* 332 */       tc.setAllColumnDelimitingEnabled(StringUtility.isTrue(delimitAllColumns));
/*     */     }
/*     */ 
/* 336 */     NodeList nodeList = node.getChildNodes();
/* 337 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 338 */       Node childNode = nodeList.item(i);
/*     */ 
/* 340 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 344 */       if ("property".equals(childNode.getNodeName()))
/* 345 */         parseProperty(tc, childNode);
/* 346 */       else if ("columnOverride".equals(childNode.getNodeName()))
/* 347 */         parseColumnOverride(tc, childNode);
/* 348 */       else if ("ignoreColumn".equals(childNode.getNodeName()))
/* 349 */         parseIgnoreColumn(tc, childNode);
/* 350 */       else if ("generatedKey".equals(childNode.getNodeName()))
/* 351 */         parseGeneratedKey(tc, childNode);
/* 352 */       else if ("columnRenamingRule".equals(childNode.getNodeName()))
/* 353 */         parseColumnRenamingRule(tc, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseColumnOverride(TableConfiguration tc, Node node)
/*     */   {
/* 359 */     Properties attributes = parseAttributes(node);
/* 360 */     String column = attributes.getProperty("column");
/* 361 */     String property = attributes.getProperty("property");
/* 362 */     String javaType = attributes.getProperty("javaType");
/* 363 */     String jdbcType = attributes.getProperty("jdbcType");
/* 364 */     String typeHandler = attributes.getProperty("typeHandler");
/* 365 */     String delimitedColumnName = attributes.getProperty("delimitedColumnName");
/*     */ 
/* 368 */     ColumnOverride co = new ColumnOverride(column);
/*     */ 
/* 370 */     if (StringUtility.stringHasValue(property)) {
/* 371 */       co.setJavaProperty(property);
/*     */     }
/*     */ 
/* 374 */     if (StringUtility.stringHasValue(javaType)) {
/* 375 */       co.setJavaType(javaType);
/*     */     }
/*     */ 
/* 378 */     if (StringUtility.stringHasValue(jdbcType)) {
/* 379 */       co.setJdbcType(jdbcType);
/*     */     }
/*     */ 
/* 382 */     if (StringUtility.stringHasValue(typeHandler)) {
/* 383 */       co.setTypeHandler(typeHandler);
/*     */     }
/*     */ 
/* 386 */     if (StringUtility.stringHasValue(delimitedColumnName)) {
/* 387 */       co.setColumnNameDelimited(StringUtility.isTrue(delimitedColumnName));
/*     */     }
/*     */ 
/* 392 */     NodeList nodeList = node.getChildNodes();
/* 393 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 394 */       Node childNode = nodeList.item(i);
/*     */ 
/* 396 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 400 */       if ("property".equals(childNode.getNodeName())) {
/* 401 */         parseProperty(co, childNode);
/*     */       }
/*     */     }
/*     */ 
/* 405 */     tc.addColumnOverride(co);
/*     */   }
/*     */ 
/*     */   private void parseGeneratedKey(TableConfiguration tc, Node node) {
/* 409 */     Properties attributes = parseAttributes(node);
/*     */ 
/* 411 */     String column = attributes.getProperty("column");
/* 412 */     boolean identity = StringUtility.isTrue(attributes.getProperty("identity"));
/*     */ 
/* 414 */     String sqlStatement = attributes.getProperty("sqlStatement");
/* 415 */     String type = attributes.getProperty("type");
/*     */ 
/* 417 */     GeneratedKey gk = new GeneratedKey(column, sqlStatement, identity, type);
/*     */ 
/* 419 */     tc.setGeneratedKey(gk);
/*     */   }
/*     */ 
/*     */   private void parseIgnoreColumn(TableConfiguration tc, Node node) {
/* 423 */     Properties attributes = parseAttributes(node);
/* 424 */     String column = attributes.getProperty("column");
/* 425 */     String delimitedColumnName = attributes.getProperty("delimitedColumnName");
/*     */ 
/* 428 */     IgnoredColumn ic = new IgnoredColumn(column);
/*     */ 
/* 430 */     if (StringUtility.stringHasValue(delimitedColumnName)) {
/* 431 */       ic.setColumnNameDelimited(StringUtility.isTrue(delimitedColumnName));
/*     */     }
/*     */ 
/* 436 */     tc.addIgnoredColumn(ic);
/*     */   }
/*     */ 
/*     */   private void parseColumnRenamingRule(TableConfiguration tc, Node node) {
/* 440 */     Properties attributes = parseAttributes(node);
/* 441 */     String searchString = attributes.getProperty("searchString");
/* 442 */     String replaceString = attributes.getProperty("replaceString");
/*     */ 
/* 444 */     ColumnRenamingRule crr = new ColumnRenamingRule();
/*     */ 
/* 446 */     crr.setSearchString(searchString);
/*     */ 
/* 448 */     if (StringUtility.stringHasValue(replaceString)) {
/* 449 */       crr.setReplaceString(replaceString);
/*     */     }
/*     */ 
/* 452 */     tc.setColumnRenamingRule(crr);
/*     */   }
/*     */ 
/*     */   private void parseJavaTypeResolver(Context context, Node node) {
/* 456 */     JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
/*     */ 
/* 458 */     context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
/*     */ 
/* 460 */     Properties attributes = parseAttributes(node);
/* 461 */     String type = attributes.getProperty("type");
/*     */ 
/* 463 */     if (StringUtility.stringHasValue(type)) {
/* 464 */       javaTypeResolverConfiguration.setConfigurationType(type);
/*     */     }
/*     */ 
/* 467 */     NodeList nodeList = node.getChildNodes();
/* 468 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 469 */       Node childNode = nodeList.item(i);
/*     */ 
/* 471 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 475 */       if ("property".equals(childNode.getNodeName()))
/* 476 */         parseProperty(javaTypeResolverConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseIbatorPlugin(Context context, Node node)
/*     */   {
/* 482 */     PluginConfiguration pluginConfiguration = new PluginConfiguration();
/*     */ 
/* 484 */     context.addPluginConfiguration(pluginConfiguration);
/*     */ 
/* 486 */     Properties attributes = parseAttributes(node);
/* 487 */     String type = attributes.getProperty("type");
/*     */ 
/* 489 */     pluginConfiguration.setConfigurationType(type);
/*     */ 
/* 491 */     NodeList nodeList = node.getChildNodes();
/* 492 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 493 */       Node childNode = nodeList.item(i);
/*     */ 
/* 495 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 499 */       if ("property".equals(childNode.getNodeName()))
/* 500 */         parseProperty(pluginConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseJavaModelGenerator(Context context, Node node)
/*     */   {
/* 506 */     JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
/*     */ 
/* 508 */     context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
/*     */ 
/* 511 */     Properties attributes = parseAttributes(node);
/* 512 */     String targetPackage = attributes.getProperty("targetPackage");
/* 513 */     String targetProject = attributes.getProperty("targetProject");
/*     */ 
/* 515 */     javaModelGeneratorConfiguration.setTargetPackage(targetPackage);
/* 516 */     javaModelGeneratorConfiguration.setTargetProject(targetProject);
/*     */ 
/* 518 */     NodeList nodeList = node.getChildNodes();
/* 519 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 520 */       Node childNode = nodeList.item(i);
/*     */ 
/* 522 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 526 */       if ("property".equals(childNode.getNodeName()))
/* 527 */         parseProperty(javaModelGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseDaoGenerator(Context context, Node node)
/*     */   {
/* 533 */     JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
/*     */ 
/* 535 */     context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
/*     */ 
/* 537 */     Properties attributes = parseAttributes(node);
/* 538 */     String type = attributes.getProperty("type");
/* 539 */     String targetPackage = attributes.getProperty("targetPackage");
/* 540 */     String targetProject = attributes.getProperty("targetProject");
/* 541 */     String implementationPackage = attributes.getProperty("implementationPackage");
/*     */ 
/* 544 */     javaClientGeneratorConfiguration.setConfigurationType(type);
/* 545 */     javaClientGeneratorConfiguration.setTargetPackage(targetPackage);
/* 546 */     javaClientGeneratorConfiguration.setTargetProject(targetProject);
/* 547 */     javaClientGeneratorConfiguration.setImplementationPackage(implementationPackage);
/*     */ 
/* 550 */     NodeList nodeList = node.getChildNodes();
/* 551 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 552 */       Node childNode = nodeList.item(i);
/*     */ 
/* 554 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 558 */       if ("property".equals(childNode.getNodeName()))
/* 559 */         parseProperty(javaClientGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseJdbcConnection(Context context, Node node)
/*     */   {
/* 565 */     JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
/*     */ 
/* 567 */     context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
/*     */ 
/* 569 */     Properties attributes = parseAttributes(node);
/* 570 */     String driverClass = attributes.getProperty("driverClass");
/* 571 */     String connectionURL = attributes.getProperty("connectionURL");
/* 572 */     String userId = attributes.getProperty("userId");
/* 573 */     String password = attributes.getProperty("password");
/*     */ 
/* 575 */     jdbcConnectionConfiguration.setDriverClass(driverClass);
/* 576 */     jdbcConnectionConfiguration.setConnectionURL(connectionURL);
/*     */ 
/* 578 */     if (StringUtility.stringHasValue(userId)) {
/* 579 */       jdbcConnectionConfiguration.setUserId(userId);
/*     */     }
/*     */ 
/* 582 */     if (StringUtility.stringHasValue(password)) {
/* 583 */       jdbcConnectionConfiguration.setPassword(password);
/*     */     }
/*     */ 
/* 586 */     NodeList nodeList = node.getChildNodes();
/* 587 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 588 */       Node childNode = nodeList.item(i);
/*     */ 
/* 590 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 594 */       if ("property".equals(childNode.getNodeName()))
/* 595 */         parseProperty(jdbcConnectionConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseClassPathEntry(Configuration configuration, Node node)
/*     */   {
/* 601 */     Properties attributes = parseAttributes(node);
/*     */ 
/* 603 */     configuration.addClasspathEntry(attributes.getProperty("location"));
/*     */   }
/*     */ 
/*     */   private void parseProperty(PropertyHolder propertyHolder, Node node) {
/* 607 */     Properties attributes = parseAttributes(node);
/*     */ 
/* 609 */     String name = attributes.getProperty("name");
/* 610 */     String value = attributes.getProperty("value");
/*     */ 
/* 612 */     propertyHolder.addProperty(name, value);
/*     */   }
/*     */ 
/*     */   private Properties parseAttributes(Node node) {
/* 616 */     Properties attributes = new Properties();
/* 617 */     NamedNodeMap nnm = node.getAttributes();
/* 618 */     for (int i = 0; i < nnm.getLength(); i++) {
/* 619 */       Node attribute = nnm.item(i);
/* 620 */       String value = parsePropertyTokens(attribute.getNodeValue());
/* 621 */       attributes.put(attribute.getNodeName(), value);
/*     */     }
/*     */ 
/* 624 */     return attributes;
/*     */   }
/*     */ 
/*     */   private String parsePropertyTokens(String string) {
/* 628 */     String OPEN = "${";
/* 629 */     String CLOSE = "}";
/*     */ 
/* 631 */     String newString = string;
/* 632 */     if (newString != null) {
/* 633 */       int start = newString.indexOf("${");
/* 634 */       int end = newString.indexOf("}");
/*     */ 
/* 636 */       while ((start > -1) && (end > start)) {
/* 637 */         String prepend = newString.substring(0, start);
/* 638 */         String append = newString.substring(end + "}".length());
/* 639 */         String propName = newString.substring(start + "${".length(), end);
/*     */ 
/* 641 */         String propValue = this.properties.getProperty(propName);
/* 642 */         if (propValue != null) {
/* 643 */           newString = prepend + propValue + append;
/*     */         }
/*     */ 
/* 646 */         start = newString.indexOf("${", end);
/* 647 */         end = newString.indexOf("}", end);
/*     */       }
/*     */     }
/*     */ 
/* 651 */     return newString;
/*     */   }
/*     */ 
/*     */   private void parseCommentGenerator(Context context, Node node) {
/* 655 */     CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
/*     */ 
/* 657 */     context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
/*     */ 
/* 659 */     Properties attributes = parseAttributes(node);
/* 660 */     String type = attributes.getProperty("type");
/*     */ 
/* 662 */     if (StringUtility.stringHasValue(type)) {
/* 663 */       commentGeneratorConfiguration.setConfigurationType(type);
/*     */     }
/*     */ 
/* 666 */     NodeList nodeList = node.getChildNodes();
/* 667 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 668 */       Node childNode = nodeList.item(i);
/*     */ 
/* 670 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 674 */       if ("property".equals(childNode.getNodeName()))
/* 675 */         parseProperty(commentGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.xml.IbatorConfigurationParser
 * JD-Core Version:    0.6.0
 */