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
/*     */ public class MyBatisGeneratorConfigurationParser
/*     */ {
/*     */   private Properties properties;
/*     */ 
/*     */   public MyBatisGeneratorConfigurationParser(Properties properties)
/*     */   {
/*  55 */     if (properties == null)
/*  56 */       this.properties = System.getProperties();
/*     */     else
/*  58 */       this.properties = properties;
/*     */   }
/*     */ 
/*     */   public Configuration parseConfiguration(Element rootNode)
/*     */     throws XMLParserException
/*     */   {
/*  65 */     Configuration configuration = new Configuration();
/*     */ 
/*  67 */     NodeList nodeList = rootNode.getChildNodes();
/*  68 */     for (int i = 0; i < nodeList.getLength(); i++) {
/*  69 */       Node childNode = nodeList.item(i);
/*     */ 
/*  71 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/*  75 */       if ("properties".equals(childNode.getNodeName()))
/*  76 */         parseProperties(configuration, childNode);
/*  77 */       else if ("classPathEntry".equals(childNode.getNodeName()))
/*  78 */         parseClassPathEntry(configuration, childNode);
/*  79 */       else if ("context".equals(childNode.getNodeName())) {
/*  80 */         parseContext(configuration, childNode);
/*     */       }
/*     */     }
/*     */ 
/*  84 */     return configuration;
/*     */   }
/*     */ 
/*     */   private void parseProperties(Configuration configuration, Node node) throws XMLParserException
/*     */   {
/*  89 */     Properties attributes = parseAttributes(node);
/*  90 */     String resource = attributes.getProperty("resource");
/*  91 */     String url = attributes.getProperty("url");
/*     */ 
/*  93 */     if ((!StringUtility.stringHasValue(resource)) && (!StringUtility.stringHasValue(url)))
/*     */     {
/*  95 */       throw new XMLParserException(Messages.getString("RuntimeError.14"));
/*     */     }
/*     */ 
/*  98 */     if ((StringUtility.stringHasValue(resource)) && (StringUtility.stringHasValue(url)))
/*     */     {
/* 100 */       throw new XMLParserException(Messages.getString("RuntimeError.14"));
/*     */     }
/*     */     try
/*     */     {
/*     */       URL resourceUrl;
/* 106 */       if (StringUtility.stringHasValue(resource)) {
/* 107 */         resourceUrl = Thread.currentThread().getContextClassLoader().getResource(resource);
/*     */ 
/* 109 */         if (resourceUrl == null)
/* 110 */           throw new XMLParserException(Messages.getString("RuntimeError.15", resource));
/*     */       }
/*     */       else
/*     */       {
/* 114 */         resourceUrl = new URL(url);
/*     */       }
/*     */ 
/* 117 */       InputStream inputStream = resourceUrl.openConnection().getInputStream();
/*     */ 
/* 120 */       this.properties.load(inputStream);
/* 121 */       inputStream.close();
/*     */     } catch (IOException e) {
/* 123 */       if (StringUtility.stringHasValue(resource)) {
/* 124 */         throw new XMLParserException(Messages.getString("RuntimeError.16", resource));
/*     */       }
/*     */ 
/* 127 */       throw new XMLParserException(Messages.getString("RuntimeError.17", url));
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseContext(Configuration configuration, Node node)
/*     */   {
/* 135 */     Properties attributes = parseAttributes(node);
/* 136 */     String defaultModelType = attributes.getProperty("defaultModelType");
/* 137 */     String targetRuntime = attributes.getProperty("targetRuntime");
/* 138 */     String introspectedColumnImpl = attributes.getProperty("introspectedColumnImpl");
/*     */ 
/* 140 */     String id = attributes.getProperty("id");
/*     */ 
/* 142 */     ModelType mt = defaultModelType == null ? null : ModelType.getModelType(defaultModelType);
/*     */ 
/* 145 */     Context context = new Context(mt);
/* 146 */     context.setId(id);
/* 147 */     if (StringUtility.stringHasValue(introspectedColumnImpl)) {
/* 148 */       context.setIntrospectedColumnImpl(introspectedColumnImpl);
/*     */     }
/* 150 */     if (StringUtility.stringHasValue(targetRuntime)) {
/* 151 */       context.setTargetRuntime(targetRuntime);
/*     */     }
/*     */ 
/* 154 */     configuration.addContext(context);
/*     */ 
/* 156 */     NodeList nodeList = node.getChildNodes();
/* 157 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 158 */       Node childNode = nodeList.item(i);
/*     */ 
/* 160 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 164 */       if ("property".equals(childNode.getNodeName()))
/* 165 */         parseProperty(context, childNode);
/* 166 */       else if ("plugin".equals(childNode.getNodeName()))
/* 167 */         parsePlugin(context, childNode);
/* 168 */       else if ("commentGenerator".equals(childNode.getNodeName()))
/* 169 */         parseCommentGenerator(context, childNode);
/* 170 */       else if ("jdbcConnection".equals(childNode.getNodeName()))
/* 171 */         parseJdbcConnection(context, childNode);
/* 172 */       else if ("javaModelGenerator".equals(childNode.getNodeName()))
/* 173 */         parseJavaModelGenerator(context, childNode);
/* 174 */       else if ("javaTypeResolver".equals(childNode.getNodeName()))
/* 175 */         parseJavaTypeResolver(context, childNode);
/* 176 */       else if ("sqlMapGenerator".equals(childNode.getNodeName()))
/* 177 */         parseSqlMapGenerator(context, childNode);
/* 178 */       else if ("javaClientGenerator".equals(childNode.getNodeName()))
/* 179 */         parseJavaClientGenerator(context, childNode);
/* 180 */       else if ("table".equals(childNode.getNodeName()))
/* 181 */         parseTable(context, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseSqlMapGenerator(Context context, Node node)
/*     */   {
/* 187 */     SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
/*     */ 
/* 189 */     context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
/*     */ 
/* 191 */     Properties attributes = parseAttributes(node);
/* 192 */     String targetPackage = attributes.getProperty("targetPackage");
/* 193 */     String targetProject = attributes.getProperty("targetProject");
/*     */ 
/* 195 */     sqlMapGeneratorConfiguration.setTargetPackage(targetPackage);
/* 196 */     sqlMapGeneratorConfiguration.setTargetProject(targetProject);
/*     */ 
/* 198 */     NodeList nodeList = node.getChildNodes();
/* 199 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 200 */       Node childNode = nodeList.item(i);
/*     */ 
/* 202 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 206 */       if ("property".equals(childNode.getNodeName()))
/* 207 */         parseProperty(sqlMapGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseTable(Context context, Node node)
/*     */   {
/* 213 */     TableConfiguration tc = new TableConfiguration(context);
/* 214 */     context.addTableConfiguration(tc);
/*     */ 
/* 216 */     Properties attributes = parseAttributes(node);
/* 217 */     String catalog = attributes.getProperty("catalog");
/* 218 */     String schema = attributes.getProperty("schema");
/* 219 */     String tableName = attributes.getProperty("tableName");
/* 220 */     String domainObjectName = attributes.getProperty("domainObjectName");
/* 221 */     String alias = attributes.getProperty("alias");
/* 222 */     String enableInsert = attributes.getProperty("enableInsert");
/* 223 */     String enableSelectByPrimaryKey = attributes.getProperty("enableSelectByPrimaryKey");
/*     */ 
/* 225 */     String enableSelectByExample = attributes.getProperty("enableSelectByExample");
/*     */ 
/* 227 */     String enableUpdateByPrimaryKey = attributes.getProperty("enableUpdateByPrimaryKey");
/*     */ 
/* 229 */     String enableDeleteByPrimaryKey = attributes.getProperty("enableDeleteByPrimaryKey");
/*     */ 
/* 231 */     String enableDeleteByExample = attributes.getProperty("enableDeleteByExample");
/*     */ 
/* 233 */     String enableCountByExample = attributes.getProperty("enableCountByExample");
/*     */ 
/* 235 */     String enableUpdateByExample = attributes.getProperty("enableUpdateByExample");
/*     */ 
/* 237 */     String selectByPrimaryKeyQueryId = attributes.getProperty("selectByPrimaryKeyQueryId");
/*     */ 
/* 239 */     String selectByExampleQueryId = attributes.getProperty("selectByExampleQueryId");
/*     */ 
/* 241 */     String modelType = attributes.getProperty("modelType");
/* 242 */     String escapeWildcards = attributes.getProperty("escapeWildcards");
/* 243 */     String delimitIdentifiers = attributes.getProperty("delimitIdentifiers");
/*     */ 
/* 245 */     String delimitAllColumns = attributes.getProperty("delimitAllColumns");
/*     */ 
/* 247 */     if (StringUtility.stringHasValue(catalog)) {
/* 248 */       tc.setCatalog(catalog);
/*     */     }
/*     */ 
/* 251 */     if (StringUtility.stringHasValue(schema)) {
/* 252 */       tc.setSchema(schema);
/*     */     }
/*     */ 
/* 255 */     if (StringUtility.stringHasValue(tableName)) {
/* 256 */       tc.setTableName(tableName);
/*     */     }
/*     */ 
/* 259 */     if (StringUtility.stringHasValue(domainObjectName)) {
/* 260 */       tc.setDomainObjectName(domainObjectName);
/*     */     }
/*     */ 
/* 263 */     if (StringUtility.stringHasValue(alias)) {
/* 264 */       tc.setAlias(alias);
/*     */     }
/*     */ 
/* 267 */     if (StringUtility.stringHasValue(enableInsert)) {
/* 268 */       tc.setInsertStatementEnabled(StringUtility.isTrue(enableInsert));
/*     */     }
/*     */ 
/* 271 */     if (StringUtility.stringHasValue(enableSelectByPrimaryKey)) {
/* 272 */       tc.setSelectByPrimaryKeyStatementEnabled(StringUtility.isTrue(enableSelectByPrimaryKey));
/*     */     }
/*     */ 
/* 276 */     if (StringUtility.stringHasValue(enableSelectByExample)) {
/* 277 */       tc.setSelectByExampleStatementEnabled(StringUtility.isTrue(enableSelectByExample));
/*     */     }
/*     */ 
/* 281 */     if (StringUtility.stringHasValue(enableUpdateByPrimaryKey)) {
/* 282 */       tc.setUpdateByPrimaryKeyStatementEnabled(StringUtility.isTrue(enableUpdateByPrimaryKey));
/*     */     }
/*     */ 
/* 286 */     if (StringUtility.stringHasValue(enableDeleteByPrimaryKey)) {
/* 287 */       tc.setDeleteByPrimaryKeyStatementEnabled(StringUtility.isTrue(enableDeleteByPrimaryKey));
/*     */     }
/*     */ 
/* 291 */     if (StringUtility.stringHasValue(enableDeleteByExample)) {
/* 292 */       tc.setDeleteByExampleStatementEnabled(StringUtility.isTrue(enableDeleteByExample));
/*     */     }
/*     */ 
/* 296 */     if (StringUtility.stringHasValue(enableCountByExample)) {
/* 297 */       tc.setCountByExampleStatementEnabled(StringUtility.isTrue(enableCountByExample));
/*     */     }
/*     */ 
/* 301 */     if (StringUtility.stringHasValue(enableUpdateByExample)) {
/* 302 */       tc.setUpdateByExampleStatementEnabled(StringUtility.isTrue(enableUpdateByExample));
/*     */     }
/*     */ 
/* 306 */     if (StringUtility.stringHasValue(selectByPrimaryKeyQueryId)) {
/* 307 */       tc.setSelectByPrimaryKeyQueryId(selectByPrimaryKeyQueryId);
/*     */     }
/*     */ 
/* 310 */     if (StringUtility.stringHasValue(selectByExampleQueryId)) {
/* 311 */       tc.setSelectByExampleQueryId(selectByExampleQueryId);
/*     */     }
/*     */ 
/* 314 */     if (StringUtility.stringHasValue(modelType)) {
/* 315 */       tc.setConfiguredModelType(modelType);
/*     */     }
/*     */ 
/* 318 */     if (StringUtility.stringHasValue(escapeWildcards)) {
/* 319 */       tc.setWildcardEscapingEnabled(StringUtility.isTrue(escapeWildcards));
/*     */     }
/*     */ 
/* 324 */     if (StringUtility.stringHasValue(delimitIdentifiers)) {
/* 325 */       tc.setDelimitIdentifiers(StringUtility.isTrue(delimitIdentifiers));
/*     */     }
/*     */ 
/* 328 */     if (StringUtility.stringHasValue(delimitAllColumns)) {
/* 329 */       tc.setAllColumnDelimitingEnabled(StringUtility.isTrue(delimitAllColumns));
/*     */     }
/*     */ 
/* 333 */     NodeList nodeList = node.getChildNodes();
/* 334 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 335 */       Node childNode = nodeList.item(i);
/*     */ 
/* 337 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 341 */       if ("property".equals(childNode.getNodeName()))
/* 342 */         parseProperty(tc, childNode);
/* 343 */       else if ("columnOverride".equals(childNode.getNodeName()))
/* 344 */         parseColumnOverride(tc, childNode);
/* 345 */       else if ("ignoreColumn".equals(childNode.getNodeName()))
/* 346 */         parseIgnoreColumn(tc, childNode);
/* 347 */       else if ("generatedKey".equals(childNode.getNodeName()))
/* 348 */         parseGeneratedKey(tc, childNode);
/* 349 */       else if ("columnRenamingRule".equals(childNode.getNodeName()))
/* 350 */         parseColumnRenamingRule(tc, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseColumnOverride(TableConfiguration tc, Node node)
/*     */   {
/* 356 */     Properties attributes = parseAttributes(node);
/* 357 */     String column = attributes.getProperty("column");
/* 358 */     String property = attributes.getProperty("property");
/* 359 */     String javaType = attributes.getProperty("javaType");
/* 360 */     String jdbcType = attributes.getProperty("jdbcType");
/* 361 */     String typeHandler = attributes.getProperty("typeHandler");
/* 362 */     String delimitedColumnName = attributes.getProperty("delimitedColumnName");
/*     */ 
/* 365 */     ColumnOverride co = new ColumnOverride(column);
/*     */ 
/* 367 */     if (StringUtility.stringHasValue(property)) {
/* 368 */       co.setJavaProperty(property);
/*     */     }
/*     */ 
/* 371 */     if (StringUtility.stringHasValue(javaType)) {
/* 372 */       co.setJavaType(javaType);
/*     */     }
/*     */ 
/* 375 */     if (StringUtility.stringHasValue(jdbcType)) {
/* 376 */       co.setJdbcType(jdbcType);
/*     */     }
/*     */ 
/* 379 */     if (StringUtility.stringHasValue(typeHandler)) {
/* 380 */       co.setTypeHandler(typeHandler);
/*     */     }
/*     */ 
/* 383 */     if (StringUtility.stringHasValue(delimitedColumnName)) {
/* 384 */       co.setColumnNameDelimited(StringUtility.isTrue(delimitedColumnName));
/*     */     }
/*     */ 
/* 389 */     NodeList nodeList = node.getChildNodes();
/* 390 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 391 */       Node childNode = nodeList.item(i);
/*     */ 
/* 393 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 397 */       if ("property".equals(childNode.getNodeName())) {
/* 398 */         parseProperty(co, childNode);
/*     */       }
/*     */     }
/*     */ 
/* 402 */     tc.addColumnOverride(co);
/*     */   }
/*     */ 
/*     */   private void parseGeneratedKey(TableConfiguration tc, Node node) {
/* 406 */     Properties attributes = parseAttributes(node);
/*     */ 
/* 408 */     String column = attributes.getProperty("column");
/* 409 */     boolean identity = StringUtility.isTrue(attributes.getProperty("identity"));
/*     */ 
/* 411 */     String sqlStatement = attributes.getProperty("sqlStatement");
/* 412 */     String type = attributes.getProperty("type");
/*     */ 
/* 414 */     GeneratedKey gk = new GeneratedKey(column, sqlStatement, identity, type);
/*     */ 
/* 416 */     tc.setGeneratedKey(gk);
/*     */   }
/*     */ 
/*     */   private void parseIgnoreColumn(TableConfiguration tc, Node node) {
/* 420 */     Properties attributes = parseAttributes(node);
/* 421 */     String column = attributes.getProperty("column");
/* 422 */     String delimitedColumnName = attributes.getProperty("delimitedColumnName");
/*     */ 
/* 425 */     IgnoredColumn ic = new IgnoredColumn(column);
/*     */ 
/* 427 */     if (StringUtility.stringHasValue(delimitedColumnName)) {
/* 428 */       ic.setColumnNameDelimited(StringUtility.isTrue(delimitedColumnName));
/*     */     }
/*     */ 
/* 433 */     tc.addIgnoredColumn(ic);
/*     */   }
/*     */ 
/*     */   private void parseColumnRenamingRule(TableConfiguration tc, Node node) {
/* 437 */     Properties attributes = parseAttributes(node);
/* 438 */     String searchString = attributes.getProperty("searchString");
/* 439 */     String replaceString = attributes.getProperty("replaceString");
/*     */ 
/* 441 */     ColumnRenamingRule crr = new ColumnRenamingRule();
/*     */ 
/* 443 */     crr.setSearchString(searchString);
/*     */ 
/* 445 */     if (StringUtility.stringHasValue(replaceString)) {
/* 446 */       crr.setReplaceString(replaceString);
/*     */     }
/*     */ 
/* 449 */     tc.setColumnRenamingRule(crr);
/*     */   }
/*     */ 
/*     */   private void parseJavaTypeResolver(Context context, Node node) {
/* 453 */     JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
/*     */ 
/* 455 */     context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);
/*     */ 
/* 457 */     Properties attributes = parseAttributes(node);
/* 458 */     String type = attributes.getProperty("type");
/*     */ 
/* 460 */     if (StringUtility.stringHasValue(type)) {
/* 461 */       javaTypeResolverConfiguration.setConfigurationType(type);
/*     */     }
/*     */ 
/* 464 */     NodeList nodeList = node.getChildNodes();
/* 465 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 466 */       Node childNode = nodeList.item(i);
/*     */ 
/* 468 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 472 */       if ("property".equals(childNode.getNodeName()))
/* 473 */         parseProperty(javaTypeResolverConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parsePlugin(Context context, Node node)
/*     */   {
/* 479 */     PluginConfiguration pluginConfiguration = new PluginConfiguration();
/*     */ 
/* 481 */     context.addPluginConfiguration(pluginConfiguration);
/*     */ 
/* 483 */     Properties attributes = parseAttributes(node);
/* 484 */     String type = attributes.getProperty("type");
/*     */ 
/* 486 */     pluginConfiguration.setConfigurationType(type);
/*     */ 
/* 488 */     NodeList nodeList = node.getChildNodes();
/* 489 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 490 */       Node childNode = nodeList.item(i);
/*     */ 
/* 492 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 496 */       if ("property".equals(childNode.getNodeName()))
/* 497 */         parseProperty(pluginConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseJavaModelGenerator(Context context, Node node)
/*     */   {
/* 503 */     JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
/*     */ 
/* 505 */     context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
/*     */ 
/* 508 */     Properties attributes = parseAttributes(node);
/* 509 */     String targetPackage = attributes.getProperty("targetPackage");
/* 510 */     String targetProject = attributes.getProperty("targetProject");
/*     */ 
/* 512 */     javaModelGeneratorConfiguration.setTargetPackage(targetPackage);
/* 513 */     javaModelGeneratorConfiguration.setTargetProject(targetProject);
/*     */ 
/* 515 */     NodeList nodeList = node.getChildNodes();
/* 516 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 517 */       Node childNode = nodeList.item(i);
/*     */ 
/* 519 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 523 */       if ("property".equals(childNode.getNodeName()))
/* 524 */         parseProperty(javaModelGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseJavaClientGenerator(Context context, Node node)
/*     */   {
/* 530 */     JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
/*     */ 
/* 532 */     context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
/*     */ 
/* 534 */     Properties attributes = parseAttributes(node);
/* 535 */     String type = attributes.getProperty("type");
/* 536 */     String targetPackage = attributes.getProperty("targetPackage");
/* 537 */     String targetProject = attributes.getProperty("targetProject");
/* 538 */     String implementationPackage = attributes.getProperty("implementationPackage");
/*     */ 
/* 541 */     javaClientGeneratorConfiguration.setConfigurationType(type);
/* 542 */     javaClientGeneratorConfiguration.setTargetPackage(targetPackage);
/* 543 */     javaClientGeneratorConfiguration.setTargetProject(targetProject);
/* 544 */     javaClientGeneratorConfiguration.setImplementationPackage(implementationPackage);
/*     */ 
/* 547 */     NodeList nodeList = node.getChildNodes();
/* 548 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 549 */       Node childNode = nodeList.item(i);
/*     */ 
/* 551 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 555 */       if ("property".equals(childNode.getNodeName()))
/* 556 */         parseProperty(javaClientGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseJdbcConnection(Context context, Node node)
/*     */   {
/* 562 */     JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
/*     */ 
/* 564 */     context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
/*     */ 
/* 566 */     Properties attributes = parseAttributes(node);
/* 567 */     String driverClass = attributes.getProperty("driverClass");
/* 568 */     String connectionURL = attributes.getProperty("connectionURL");
/* 569 */     String userId = attributes.getProperty("userId");
/* 570 */     String password = attributes.getProperty("password");
/*     */ 
/* 572 */     jdbcConnectionConfiguration.setDriverClass(driverClass);
/* 573 */     jdbcConnectionConfiguration.setConnectionURL(connectionURL);
/*     */ 
/* 575 */     if (StringUtility.stringHasValue(userId)) {
/* 576 */       jdbcConnectionConfiguration.setUserId(userId);
/*     */     }
/*     */ 
/* 579 */     if (StringUtility.stringHasValue(password)) {
/* 580 */       jdbcConnectionConfiguration.setPassword(password);
/*     */     }
/*     */ 
/* 583 */     NodeList nodeList = node.getChildNodes();
/* 584 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 585 */       Node childNode = nodeList.item(i);
/*     */ 
/* 587 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 591 */       if ("property".equals(childNode.getNodeName()))
/* 592 */         parseProperty(jdbcConnectionConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void parseClassPathEntry(Configuration configuration, Node node)
/*     */   {
/* 598 */     Properties attributes = parseAttributes(node);
/*     */ 
/* 600 */     configuration.addClasspathEntry(attributes.getProperty("location"));
/*     */   }
/*     */ 
/*     */   private void parseProperty(PropertyHolder propertyHolder, Node node) {
/* 604 */     Properties attributes = parseAttributes(node);
/*     */ 
/* 606 */     String name = attributes.getProperty("name");
/* 607 */     String value = attributes.getProperty("value");
/*     */ 
/* 609 */     propertyHolder.addProperty(name, value);
/*     */   }
/*     */ 
/*     */   private Properties parseAttributes(Node node) {
/* 613 */     Properties attributes = new Properties();
/* 614 */     NamedNodeMap nnm = node.getAttributes();
/* 615 */     for (int i = 0; i < nnm.getLength(); i++) {
/* 616 */       Node attribute = nnm.item(i);
/* 617 */       String value = parsePropertyTokens(attribute.getNodeValue());
/* 618 */       attributes.put(attribute.getNodeName(), value);
/*     */     }
/*     */ 
/* 621 */     return attributes;
/*     */   }
/*     */ 
/*     */   private String parsePropertyTokens(String string) {
/* 625 */     String OPEN = "${";
/* 626 */     String CLOSE = "}";
/*     */ 
/* 628 */     String newString = string;
/* 629 */     if (newString != null) {
/* 630 */       int start = newString.indexOf("${");
/* 631 */       int end = newString.indexOf("}");
/*     */ 
/* 633 */       while ((start > -1) && (end > start)) {
/* 634 */         String prepend = newString.substring(0, start);
/* 635 */         String append = newString.substring(end + "}".length());
/* 636 */         String propName = newString.substring(start + "${".length(), end);
/*     */ 
/* 638 */         String propValue = this.properties.getProperty(propName);
/* 639 */         if (propValue != null) {
/* 640 */           newString = prepend + propValue + append;
/*     */         }
/*     */ 
/* 643 */         start = newString.indexOf("${", end);
/* 644 */         end = newString.indexOf("}", end);
/*     */       }
/*     */     }
/*     */ 
/* 648 */     return newString;
/*     */   }
/*     */ 
/*     */   private void parseCommentGenerator(Context context, Node node) {
/* 652 */     CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
/*     */ 
/* 654 */     context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);
/*     */ 
/* 656 */     Properties attributes = parseAttributes(node);
/* 657 */     String type = attributes.getProperty("type");
/*     */ 
/* 659 */     if (StringUtility.stringHasValue(type)) {
/* 660 */       commentGeneratorConfiguration.setConfigurationType(type);
/*     */     }
/*     */ 
/* 663 */     NodeList nodeList = node.getChildNodes();
/* 664 */     for (int i = 0; i < nodeList.getLength(); i++) {
/* 665 */       Node childNode = nodeList.item(i);
/*     */ 
/* 667 */       if (childNode.getNodeType() != 1)
/*     */       {
/*     */         continue;
/*     */       }
/* 671 */       if ("property".equals(childNode.getNodeName()))
/* 672 */         parseProperty(commentGeneratorConfiguration, childNode);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.xml.MyBatisGeneratorConfigurationParser
 * JD-Core Version:    0.6.0
 */