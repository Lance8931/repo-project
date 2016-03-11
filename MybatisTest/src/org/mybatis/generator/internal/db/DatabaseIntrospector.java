/*     */ package org.mybatis.generator.internal.db;
/*     */ 
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.mybatis.generator.api.FullyQualifiedTable;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.JavaTypeResolver;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.config.ColumnOverride;
/*     */ import org.mybatis.generator.config.ColumnRenamingRule;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.GeneratedKey;
/*     */ import org.mybatis.generator.config.TableConfiguration;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.mybatis.generator.logging.Log;
/*     */ import org.mybatis.generator.logging.LogFactory;
/*     */ 
/*     */ public class DatabaseIntrospector
/*     */ {
/*     */   private DatabaseMetaData databaseMetaData;
/*     */   private JavaTypeResolver javaTypeResolver;
/*     */   private List<String> warnings;
/*     */   private Context context;
/*     */   private Log logger;
/*     */ 
/*     */   public DatabaseIntrospector(Context context, DatabaseMetaData databaseMetaData, JavaTypeResolver javaTypeResolver, List<String> warnings)
/*     */   {
/*  63 */     this.context = context;
/*  64 */     this.databaseMetaData = databaseMetaData;
/*  65 */     this.javaTypeResolver = javaTypeResolver;
/*  66 */     this.warnings = warnings;
/*  67 */     this.logger = LogFactory.getLog(getClass());
/*     */   }
/*     */ 
/*     */   private void calculatePrimaryKey(FullyQualifiedTable table, IntrospectedTable introspectedTable)
/*     */   {
/*  72 */     ResultSet rs = null;
/*     */     try
/*     */     {
/*  75 */       rs = this.databaseMetaData.getPrimaryKeys(table.getIntrospectedCatalog(), table.getIntrospectedSchema(), table.getIntrospectedTableName());
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  80 */       closeResultSet(rs);
/*  81 */       this.warnings.add(Messages.getString("Warning.15"));
/*  82 */       return;
/*     */     }
/*     */     try
/*     */     {
/*  86 */       while (rs.next()) {
/*  87 */         String columnName = rs.getString("COLUMN_NAME");
/*     */ 
/*  89 */         introspectedTable.addPrimaryKeyColumn(columnName);
/*     */       }
/*     */     } catch (SQLException e) {
/*     */     }
/*     */     finally {
/*  94 */       closeResultSet(rs);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void closeResultSet(ResultSet rs) {
/*  99 */     if (rs != null)
/*     */       try {
/* 101 */         rs.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   private void reportIntrospectionWarnings(IntrospectedTable introspectedTable, TableConfiguration tableConfiguration, FullyQualifiedTable table)
/*     */   {
/* 114 */     for (ColumnOverride columnOverride : tableConfiguration.getColumnOverrides())
/*     */     {
/* 116 */       if (introspectedTable.getColumn(columnOverride.getColumnName()) == null) {
/* 117 */         this.warnings.add(Messages.getString("Warning.3", columnOverride.getColumnName(), table.toString()));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 124 */     for (String string : tableConfiguration.getIgnoredColumnsInError()) {
/* 125 */       this.warnings.add(Messages.getString("Warning.4", string, table.toString()));
/*     */     }
/*     */ 
/* 129 */     GeneratedKey generatedKey = tableConfiguration.getGeneratedKey();
/* 130 */     if ((generatedKey != null) && (introspectedTable.getColumn(generatedKey.getColumn()) == null))
/*     */     {
/* 132 */       if (generatedKey.isIdentity()) {
/* 133 */         this.warnings.add(Messages.getString("Warning.5", generatedKey.getColumn(), table.toString()));
/*     */       }
/*     */       else
/* 136 */         this.warnings.add(Messages.getString("Warning.6", generatedKey.getColumn(), table.toString()));
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<IntrospectedTable> introspectTables(TableConfiguration tc)
/*     */     throws SQLException
/*     */   {
/* 154 */     Map columns = getColumns(tc);
/*     */ 
/* 156 */     if (columns.isEmpty()) {
/* 157 */       this.warnings.add(Messages.getString("Warning.19", tc.getCatalog(), tc.getSchema(), tc.getTableName()));
/*     */ 
/* 159 */       return null;
/*     */     }
/*     */ 
/* 162 */     removeIgnoredColumns(tc, columns);
/* 163 */     calculateExtraColumnInformation(tc, columns);
/* 164 */     applyColumnOverrides(tc, columns);
/* 165 */     calculateIdentityColumns(tc, columns);
/*     */ 
/* 167 */     List introspectedTables = calculateIntrospectedTables(tc, columns);
/*     */ 
/* 173 */     Iterator iter = introspectedTables.iterator();
/* 174 */     while (iter.hasNext()) {
/* 175 */       IntrospectedTable introspectedTable = (IntrospectedTable)iter.next();
/*     */ 
/* 177 */       if (!introspectedTable.hasAnyColumns())
/*     */       {
/* 180 */         String warning = Messages.getString("Warning.1", introspectedTable.getFullyQualifiedTable().toString());
/*     */ 
/* 183 */         this.warnings.add(warning);
/* 184 */         iter.remove();
/* 185 */       } else if ((!introspectedTable.hasPrimaryKeyColumns()) && (!introspectedTable.hasBaseColumns()))
/*     */       {
/* 189 */         String warning = Messages.getString("Warning.18", introspectedTable.getFullyQualifiedTable().toString());
/*     */ 
/* 192 */         this.warnings.add(warning);
/* 193 */         iter.remove();
/*     */       }
/*     */       else
/*     */       {
/* 198 */         reportIntrospectionWarnings(introspectedTable, tc, introspectedTable.getFullyQualifiedTable());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 203 */     return introspectedTables;
/*     */   }
/*     */ 
/*     */   private void removeIgnoredColumns(TableConfiguration tc, Map<ActualTableName, List<IntrospectedColumn>> columns)
/*     */   {
/* 212 */     for (Map.Entry entry : columns.entrySet())
/*     */     {
/* 214 */       Iterator tableColumns = ((List)entry.getValue()).iterator();
/*     */ 
/* 216 */       while (tableColumns.hasNext()) {
/* 217 */         IntrospectedColumn introspectedColumn = (IntrospectedColumn)tableColumns.next();
/* 218 */         if (tc.isColumnIgnored(introspectedColumn.getActualColumnName()))
/*     */         {
/* 221 */           tableColumns.remove();
/* 222 */           if (this.logger.isDebugEnabled())
/* 223 */             this.logger.debug(Messages.getString("Tracing.3", introspectedColumn.getActualColumnName(), ((ActualTableName)entry.getKey()).toString()));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private void calculateExtraColumnInformation(TableConfiguration tc, Map<ActualTableName, List<IntrospectedColumn>> columns)
/*     */   {
/* 234 */     StringBuilder sb = new StringBuilder();
/* 235 */     Pattern pattern = null;
/* 236 */     String replaceString = null;
/* 237 */     if (tc.getColumnRenamingRule() != null) {
/* 238 */       pattern = Pattern.compile(tc.getColumnRenamingRule().getSearchString());
/*     */ 
/* 240 */       replaceString = tc.getColumnRenamingRule().getReplaceString();
/* 241 */       replaceString = replaceString == null ? "" : replaceString;
/*     */     }
/*     */ 
/* 244 */     for (Iterator i$ = columns.entrySet().iterator(); i$.hasNext(); ) { Entry entry = (Map.Entry)i$.next();
/*     */ 
/* 246 */       for (IntrospectedColumn introspectedColumn : (List<IntrospectedColumn>)entry.getValue())
/*     */       {
/*     */         String calculatedColumnName;
/* 248 */         if (pattern == null) {
/* 249 */           calculatedColumnName = introspectedColumn.getActualColumnName();
/*     */         }
/*     */         else {
/* 252 */           Matcher matcher = pattern.matcher(introspectedColumn.getActualColumnName());
/*     */ 
/* 254 */           calculatedColumnName = matcher.replaceAll(replaceString);
/*     */         }
/*     */ 
/* 257 */         if (StringUtility.isTrue(tc.getProperty("useActualColumnNames")))
/*     */         {
/* 260 */           introspectedColumn.setJavaProperty(JavaBeansUtil.getValidPropertyName(calculatedColumnName));
/*     */         }
/* 262 */         else if (StringUtility.isTrue(tc.getProperty("useCompoundPropertyNames")))
/*     */         {
/* 265 */           sb.setLength(0);
/* 266 */           sb.append(calculatedColumnName);
/* 267 */           sb.append('_');
/* 268 */           sb.append(JavaBeansUtil.getCamelCaseString(introspectedColumn.getRemarks(), true));
/*     */ 
/* 270 */           introspectedColumn.setJavaProperty(JavaBeansUtil.getValidPropertyName(sb.toString()));
/*     */         }
/*     */         else {
/* 273 */           introspectedColumn.setJavaProperty(JavaBeansUtil.getCamelCaseString(calculatedColumnName, false));
/*     */         }
/*     */ 
/* 277 */         FullyQualifiedJavaType fullyQualifiedJavaType = this.javaTypeResolver.calculateJavaType(introspectedColumn);
/*     */ 
/* 280 */         if (fullyQualifiedJavaType != null) {
/* 281 */           introspectedColumn.setFullyQualifiedJavaType(fullyQualifiedJavaType);
/*     */ 
/* 283 */           introspectedColumn.setJdbcTypeName(this.javaTypeResolver.calculateJdbcTypeName(introspectedColumn));
/*     */         }
/*     */         else
/*     */         {
/* 287 */           boolean warn = true;
/* 288 */           if (tc.isColumnIgnored(introspectedColumn.getActualColumnName()))
/*     */           {
/* 290 */             warn = false;
/*     */           }
/*     */ 
/* 293 */           ColumnOverride co = tc.getColumnOverride(introspectedColumn.getActualColumnName());
/*     */ 
/* 295 */           if ((co != null) && 
/* 296 */             (StringUtility.stringHasValue(co.getJavaType())) && (StringUtility.stringHasValue(co.getJavaType())))
/*     */           {
/* 299 */             warn = false;
/*     */           }
/*     */ 
/* 304 */           if (warn) {
/* 305 */             introspectedColumn.setFullyQualifiedJavaType(FullyQualifiedJavaType.getObjectInstance());
/*     */ 
/* 308 */             introspectedColumn.setJdbcTypeName("OTHER");
/*     */ 
/* 310 */             String warning = Messages.getString("Warning.14", ((ActualTableName)entry.getKey()).toString(), introspectedColumn.getActualColumnName());
/*     */ 
/* 314 */             this.warnings.add(warning);
/*     */           }
/*     */         }
/*     */ 
/* 318 */         if ((this.context.autoDelimitKeywords()) && 
/* 319 */           (SqlReservedWords.containsWord(introspectedColumn.getActualColumnName())))
/*     */         {
/* 321 */           introspectedColumn.setColumnNameDelimited(true);
/*     */         }
/*     */ 
/* 325 */         if (tc.isAllColumnDelimitingEnabled())
/* 326 */           introspectedColumn.setColumnNameDelimited(true);
/*     */       } }
/*     */     Map.Entry entry;
/*     */   }
/*     */ 
/*     */   private void calculateIdentityColumns(TableConfiguration tc, Map<ActualTableName, List<IntrospectedColumn>> columns)
/*     */   {
/* 334 */     for (Map.Entry entry : columns.entrySet())
/*     */     {
/* 336 */       for (IntrospectedColumn introspectedColumn : (List<IntrospectedColumn>)entry.getValue())
/* 337 */         if ((tc.getGeneratedKey() != null) && (tc.getGeneratedKey().isIdentity()))
/*     */         {
/* 339 */           if (introspectedColumn.isColumnNameDelimited()) {
/* 340 */             if (introspectedColumn.getActualColumnName().equals(tc.getGeneratedKey().getColumn()))
/*     */             {
/* 342 */               introspectedColumn.setIdentity(true);
/*     */             }
/*     */           }
/* 345 */           else if (introspectedColumn.getActualColumnName().equalsIgnoreCase(tc.getGeneratedKey().getColumn()))
/*     */           {
/* 348 */             introspectedColumn.setIdentity(true);
/*     */           }
/*     */         }
/*     */         else
/* 352 */           introspectedColumn.setIdentity(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void applyColumnOverrides(TableConfiguration tc, Map<ActualTableName, List<IntrospectedColumn>> columns)
/*     */   {
/* 360 */     for (Iterator i$ = columns.entrySet().iterator(); i$.hasNext(); ) { Entry entry = (Map.Entry)i$.next();
/*     */ 
/* 362 */       for (IntrospectedColumn introspectedColumn : (List<IntrospectedColumn>)entry.getValue()) {
/* 363 */         ColumnOverride columnOverride = tc.getColumnOverride(introspectedColumn.getActualColumnName());
/*     */ 
/* 367 */         if (columnOverride != null) {
/* 368 */           if (this.logger.isDebugEnabled()) {
/* 369 */             this.logger.debug(Messages.getString("Tracing.4", introspectedColumn.getActualColumnName(), ((ActualTableName)entry.getKey()).toString()));
/*     */           }
/*     */ 
/* 374 */           if (StringUtility.stringHasValue(columnOverride.getJavaProperty()))
/*     */           {
/* 376 */             introspectedColumn.setJavaProperty(columnOverride.getJavaProperty());
/*     */           }
/*     */ 
/* 380 */           if (StringUtility.stringHasValue(columnOverride.getJavaType()))
/*     */           {
/* 382 */             introspectedColumn.setFullyQualifiedJavaType(new FullyQualifiedJavaType(columnOverride.getJavaType()));
/*     */           }
/*     */ 
/* 387 */           if (StringUtility.stringHasValue(columnOverride.getJdbcType()))
/*     */           {
/* 389 */             introspectedColumn.setJdbcTypeName(columnOverride.getJdbcType());
/*     */           }
/*     */ 
/* 393 */           if (StringUtility.stringHasValue(columnOverride.getTypeHandler()))
/*     */           {
/* 395 */             introspectedColumn.setTypeHandler(columnOverride.getTypeHandler());
/*     */           }
/*     */ 
/* 399 */           if (columnOverride.isColumnNameDelimited()) {
/* 400 */             introspectedColumn.setColumnNameDelimited(true);
/*     */           }
/*     */ 
/* 403 */           introspectedColumn.setProperties(columnOverride.getProperties());
/*     */         }
/*     */       }
/*     */     }
/*     */     Map.Entry entry;
/*     */   }
/*     */ 
/*     */   private Map<ActualTableName, List<IntrospectedColumn>> getColumns(TableConfiguration tc)
/*     */     throws SQLException
/*     */   {
/* 424 */     boolean delimitIdentifiers = (tc.isDelimitIdentifiers()) || (StringUtility.stringContainsSpace(tc.getCatalog())) || (StringUtility.stringContainsSpace(tc.getSchema())) || (StringUtility.stringContainsSpace(tc.getTableName()));
/*     */     String localTableName;
/*     */     String localCatalog;
/*     */     String localSchema;
/* 429 */     if (delimitIdentifiers) {
/* 430 */       localCatalog = tc.getCatalog();
/* 431 */       localSchema = tc.getSchema();
/* 432 */       localTableName = tc.getTableName();
/*     */     }
/*     */     else
/*     */     {
/* 433 */       if (this.databaseMetaData.storesLowerCaseIdentifiers()) {
/* 434 */         localCatalog = tc.getCatalog() == null ? null : tc.getCatalog().toLowerCase();
/*     */ 
/* 436 */         localSchema = tc.getSchema() == null ? null : tc.getSchema().toLowerCase();
/*     */ 
/* 438 */         localTableName = tc.getTableName() == null ? null : tc.getTableName().toLowerCase();
/*     */       }
/*     */       else
/*     */       {
/* 440 */         if (this.databaseMetaData.storesUpperCaseIdentifiers()) {
/* 441 */           localCatalog = tc.getCatalog() == null ? null : tc.getCatalog().toUpperCase();
/*     */ 
/* 443 */           localSchema = tc.getSchema() == null ? null : tc.getSchema().toUpperCase();
/*     */ 
/* 445 */           localTableName = tc.getTableName() == null ? null : tc.getTableName().toUpperCase();
/*     */         }
/*     */         else {
/* 448 */           localCatalog = tc.getCatalog();
/* 449 */           localSchema = tc.getSchema();
/* 450 */           localTableName = tc.getTableName();
/*     */         }
/*     */       }
/*     */     }
/* 453 */     if (tc.isWildcardEscapingEnabled()) {
/* 454 */       String escapeString = this.databaseMetaData.getSearchStringEscape();
/*     */ 
/* 456 */       StringBuilder sb = new StringBuilder();
/*     */ 
/* 458 */       if (localSchema != null) {
/* 459 */         StringTokenizer st = new StringTokenizer(localSchema, "_%", true);
/* 460 */         while (st.hasMoreTokens()) {
/* 461 */           String token = st.nextToken();
/* 462 */           if ((token.equals("_")) || (token.equals("%")))
/*     */           {
/* 464 */             sb.append(escapeString);
/*     */           }
/* 466 */           sb.append(token);
/*     */         }
/* 468 */         localSchema = sb.toString();
/*     */       }
/*     */ 
/* 471 */       sb.setLength(0);
/* 472 */       StringTokenizer st = new StringTokenizer(localTableName, "_%", true);
/* 473 */       while (st.hasMoreTokens()) {
/* 474 */         String token = st.nextToken();
/* 475 */         if ((token.equals("_")) || (token.equals("%")))
/*     */         {
/* 477 */           sb.append(escapeString);
/*     */         }
/* 479 */         sb.append(token);
/*     */       }
/* 481 */       localTableName = sb.toString();
/*     */     }
/*     */ 
/* 484 */     Map<ActualTableName, List<IntrospectedColumn>> answer = new HashMap<ActualTableName, List<IntrospectedColumn>>();
/*     */ 
/* 486 */     if (this.logger.isDebugEnabled()) {
/* 487 */       String fullTableName = StringUtility.composeFullyQualifiedTableName(localCatalog, localSchema, localTableName, '.');
/*     */ 
/* 490 */       this.logger.debug(Messages.getString("Tracing.1", fullTableName));
/*     */     }
/*     */ 
/* 493 */     ResultSet rs = this.databaseMetaData.getColumns(localCatalog, localSchema, localTableName, null);
/*     */ 
/* 496 */     while (rs.next()) {
/* 497 */       IntrospectedColumn introspectedColumn = ObjectFactory.createIntrospectedColumn(this.context);
/*     */ 
/* 500 */       introspectedColumn.setTableAlias(tc.getAlias());
/* 501 */       introspectedColumn.setJdbcType(rs.getInt("DATA_TYPE"));
/* 502 */       introspectedColumn.setLength(rs.getInt("COLUMN_SIZE"));
/* 503 */       introspectedColumn.setActualColumnName(rs.getString("COLUMN_NAME"));
/* 504 */       introspectedColumn.setNullable(rs.getInt("NULLABLE") == 1);
/*     */ 
/* 506 */       introspectedColumn.setScale(rs.getInt("DECIMAL_DIGITS"));
/* 507 */       introspectedColumn.setRemarks(rs.getString("REMARKS"));
/* 508 */       introspectedColumn.setDefaultValue(rs.getString("COLUMN_DEF"));
/*     */ 
/* 510 */       ActualTableName atn = new ActualTableName(rs.getString("TABLE_CAT"), rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"));
/*     */ 
/* 515 */       List columns = (List)answer.get(atn);
/* 516 */       if (columns == null) {
/* 517 */         columns = new ArrayList();
/* 518 */         answer.put(atn, columns);
/*     */       }
/*     */ 
/* 521 */       columns.add(introspectedColumn);
/*     */ 
/* 523 */       if (this.logger.isDebugEnabled()) {
/* 524 */         this.logger.debug(Messages.getString("Tracing.2", introspectedColumn.getActualColumnName(), Integer.toString(introspectedColumn.getJdbcType()), atn.toString()));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 532 */     closeResultSet(rs);
/*     */ 
/* 534 */     if ((answer.size() > 1) && (!StringUtility.stringContainsSQLWildcard(localSchema)) && (!StringUtility.stringContainsSQLWildcard(localTableName)))
/*     */     {
/* 539 */       ActualTableName inputAtn = new ActualTableName(tc.getCatalog(), tc.getSchema(), tc.getTableName());
/*     */ 
/* 542 */       StringBuilder sb = new StringBuilder();
/* 543 */       boolean comma = false;
/* 544 */       for (ActualTableName atn : answer.keySet()) {
/* 545 */         if (comma)
/* 546 */           sb.append(',');
/*     */         else {
/* 548 */           comma = true;
/*     */         }
/* 550 */         sb.append(atn.toString());
/*     */       }
/*     */ 
/* 553 */       this.warnings.add(Messages.getString("Warning.25", inputAtn.toString(), sb.toString()));
/*     */     }
/*     */ 
/* 557 */     return answer;
/*     */   }
/*     */ 
/*     */   private List<IntrospectedTable> calculateIntrospectedTables(TableConfiguration tc, Map<ActualTableName, List<IntrospectedColumn>> columns)
/*     */   {
/* 563 */     boolean delimitIdentifiers = (tc.isDelimitIdentifiers()) || (StringUtility.stringContainsSpace(tc.getCatalog())) || (StringUtility.stringContainsSpace(tc.getSchema())) || (StringUtility.stringContainsSpace(tc.getTableName()));
/*     */ 
/* 568 */     List<IntrospectedTable> answer = new ArrayList<IntrospectedTable>();
/*     */ 
/* 570 */     for (Map.Entry entry : columns.entrySet())
/*     */     {
/* 572 */       ActualTableName atn = (ActualTableName)entry.getKey();
/*     */ 
/* 581 */       FullyQualifiedTable table = new FullyQualifiedTable(StringUtility.stringHasValue(tc.getCatalog()) ? atn.getCatalog() : null, StringUtility.stringHasValue(tc.getSchema()) ? atn.getSchema() : null, atn.getTableName(), tc.getDomainObjectName(), tc.getAlias(), StringUtility.isTrue(tc.getProperty("ignoreQualifiersAtRuntime")), tc.getProperty("runtimeCatalog"), tc.getProperty("runtimeSchema"), tc.getProperty("runtimeTableName"), delimitIdentifiers, this.context);
/*     */ 
/* 597 */       IntrospectedTable introspectedTable = ObjectFactory.createIntrospectedTable(tc, table, this.context);
/*     */ 
/* 600 */       for (IntrospectedColumn introspectedColumn : (List<IntrospectedColumn>)entry.getValue()) {
/* 601 */         introspectedTable.addColumn(introspectedColumn);
/*     */       }
/*     */ 
/* 604 */       calculatePrimaryKey(table, introspectedTable);
/*     */ 
/* 606 */       answer.add(introspectedTable);
/*     */     }
/*     */ 
/* 609 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.db.DatabaseIntrospector
 * JD-Core Version:    0.6.0
 */