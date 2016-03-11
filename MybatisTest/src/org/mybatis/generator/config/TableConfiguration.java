/*     */ package org.mybatis.generator.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.util.EqualsUtil;
/*     */ import org.mybatis.generator.internal.util.HashCodeUtil;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class TableConfiguration extends PropertyHolder
/*     */ {
/*     */   private boolean insertStatementEnabled;
/*     */   private boolean selectByPrimaryKeyStatementEnabled;
/*     */   private boolean selectByExampleStatementEnabled;
/*     */   private boolean updateByPrimaryKeyStatementEnabled;
/*     */   private boolean deleteByPrimaryKeyStatementEnabled;
/*     */   private boolean deleteByExampleStatementEnabled;
/*     */   private boolean countByExampleStatementEnabled;
/*     */   private boolean updateByExampleStatementEnabled;
/*     */   private List<ColumnOverride> columnOverrides;
/*     */   private Map<IgnoredColumn, Boolean> ignoredColumns;
/*     */   private GeneratedKey generatedKey;
/*     */   private String selectByPrimaryKeyQueryId;
/*     */   private String selectByExampleQueryId;
/*     */   private String catalog;
/*     */   private String schema;
/*     */   private String tableName;
/*     */   private String domainObjectName;
/*     */   private String alias;
/*     */   private ModelType modelType;
/*     */   private boolean wildcardEscapingEnabled;
/*     */   private String configuredModelType;
/*     */   private boolean delimitIdentifiers;
/*     */   private ColumnRenamingRule columnRenamingRule;
/*     */   private boolean isAllColumnDelimitingEnabled;
/*     */ 
/*     */   public TableConfiguration(Context context)
/*     */   {
/*  77 */     this.modelType = context.getDefaultModelType();
/*     */ 
/*  79 */     this.columnOverrides = new ArrayList();
/*  80 */     this.ignoredColumns = new HashMap();
/*     */ 
/*  82 */     this.insertStatementEnabled = true;
/*  83 */     this.selectByPrimaryKeyStatementEnabled = true;
/*  84 */     this.selectByExampleStatementEnabled = true;
/*  85 */     this.updateByPrimaryKeyStatementEnabled = true;
/*  86 */     this.deleteByPrimaryKeyStatementEnabled = true;
/*  87 */     this.deleteByExampleStatementEnabled = true;
/*  88 */     this.countByExampleStatementEnabled = true;
/*  89 */     this.updateByExampleStatementEnabled = true;
/*     */   }
/*     */ 
/*     */   public boolean isDeleteByPrimaryKeyStatementEnabled() {
/*  93 */     return this.deleteByPrimaryKeyStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setDeleteByPrimaryKeyStatementEnabled(boolean deleteByPrimaryKeyStatementEnabled)
/*     */   {
/*  98 */     this.deleteByPrimaryKeyStatementEnabled = deleteByPrimaryKeyStatementEnabled;
/*     */   }
/*     */ 
/*     */   public boolean isInsertStatementEnabled() {
/* 102 */     return this.insertStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setInsertStatementEnabled(boolean insertStatementEnabled) {
/* 106 */     this.insertStatementEnabled = insertStatementEnabled;
/*     */   }
/*     */ 
/*     */   public boolean isSelectByPrimaryKeyStatementEnabled() {
/* 110 */     return this.selectByPrimaryKeyStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setSelectByPrimaryKeyStatementEnabled(boolean selectByPrimaryKeyStatementEnabled)
/*     */   {
/* 115 */     this.selectByPrimaryKeyStatementEnabled = selectByPrimaryKeyStatementEnabled;
/*     */   }
/*     */ 
/*     */   public boolean isUpdateByPrimaryKeyStatementEnabled() {
/* 119 */     return this.updateByPrimaryKeyStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setUpdateByPrimaryKeyStatementEnabled(boolean updateByPrimaryKeyStatementEnabled)
/*     */   {
/* 124 */     this.updateByPrimaryKeyStatementEnabled = updateByPrimaryKeyStatementEnabled;
/*     */   }
/*     */ 
/*     */   public boolean isColumnIgnored(String columnName) {
/* 128 */     for (Map.Entry entry : this.ignoredColumns.entrySet())
/*     */     {
/* 130 */       IgnoredColumn ic = (IgnoredColumn)entry.getKey();
/* 131 */       if (ic.isColumnNameDelimited()) {
/* 132 */         if (columnName.equals(ic.getColumnName())) {
/* 133 */           entry.setValue(Boolean.TRUE);
/* 134 */           return true;
/*     */         }
/*     */       }
/* 137 */       else if (columnName.equalsIgnoreCase(ic.getColumnName())) {
/* 138 */         entry.setValue(Boolean.TRUE);
/* 139 */         return true;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 144 */     return false;
/*     */   }
/*     */ 
/*     */   public void addIgnoredColumn(IgnoredColumn ignoredColumn) {
/* 148 */     this.ignoredColumns.put(ignoredColumn, Boolean.FALSE);
/*     */   }
/*     */ 
/*     */   public void addColumnOverride(ColumnOverride columnOverride) {
/* 152 */     this.columnOverrides.add(columnOverride);
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 157 */     if (this == obj) {
/* 158 */       return true;
/*     */     }
/*     */ 
/* 161 */     if (!(obj instanceof TableConfiguration)) {
/* 162 */       return false;
/*     */     }
/*     */ 
/* 165 */     TableConfiguration other = (TableConfiguration)obj;
/*     */ 
/* 167 */     return (EqualsUtil.areEqual(this.catalog, other.catalog)) && (EqualsUtil.areEqual(this.schema, other.schema)) && (EqualsUtil.areEqual(this.tableName, other.tableName));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 174 */     int result = 23;
/* 175 */     result = HashCodeUtil.hash(result, this.catalog);
/* 176 */     result = HashCodeUtil.hash(result, this.schema);
/* 177 */     result = HashCodeUtil.hash(result, this.tableName);
/*     */ 
/* 179 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean isSelectByExampleStatementEnabled() {
/* 183 */     return this.selectByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setSelectByExampleStatementEnabled(boolean selectByExampleStatementEnabled)
/*     */   {
/* 188 */     this.selectByExampleStatementEnabled = selectByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public ColumnOverride getColumnOverride(String columnName)
/*     */   {
/* 198 */     for (ColumnOverride co : this.columnOverrides) {
/* 199 */       if (co.isColumnNameDelimited()) {
/* 200 */         if (columnName.equals(co.getColumnName())) {
/* 201 */           return co;
/*     */         }
/*     */       }
/* 204 */       else if (columnName.equalsIgnoreCase(co.getColumnName())) {
/* 205 */         return co;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 210 */     return null;
/*     */   }
/*     */ 
/*     */   public GeneratedKey getGeneratedKey() {
/* 214 */     return this.generatedKey;
/*     */   }
/*     */ 
/*     */   public String getSelectByExampleQueryId() {
/* 218 */     return this.selectByExampleQueryId;
/*     */   }
/*     */ 
/*     */   public void setSelectByExampleQueryId(String selectByExampleQueryId) {
/* 222 */     this.selectByExampleQueryId = selectByExampleQueryId;
/*     */   }
/*     */ 
/*     */   public String getSelectByPrimaryKeyQueryId() {
/* 226 */     return this.selectByPrimaryKeyQueryId;
/*     */   }
/*     */ 
/*     */   public void setSelectByPrimaryKeyQueryId(String selectByPrimaryKeyQueryId) {
/* 230 */     this.selectByPrimaryKeyQueryId = selectByPrimaryKeyQueryId;
/*     */   }
/*     */ 
/*     */   public boolean isDeleteByExampleStatementEnabled() {
/* 234 */     return this.deleteByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setDeleteByExampleStatementEnabled(boolean deleteByExampleStatementEnabled)
/*     */   {
/* 239 */     this.deleteByExampleStatementEnabled = deleteByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public boolean areAnyStatementsEnabled() {
/* 243 */     return (this.selectByExampleStatementEnabled) || (this.selectByPrimaryKeyStatementEnabled) || (this.insertStatementEnabled) || (this.updateByPrimaryKeyStatementEnabled) || (this.deleteByExampleStatementEnabled) || (this.deleteByPrimaryKeyStatementEnabled) || (this.countByExampleStatementEnabled) || (this.updateByExampleStatementEnabled);
/*     */   }
/*     */ 
/*     */   public void setGeneratedKey(GeneratedKey generatedKey)
/*     */   {
/* 253 */     this.generatedKey = generatedKey;
/*     */   }
/*     */ 
/*     */   public String getAlias() {
/* 257 */     return this.alias;
/*     */   }
/*     */ 
/*     */   public void setAlias(String alias) {
/* 261 */     this.alias = alias;
/*     */   }
/*     */ 
/*     */   public String getCatalog() {
/* 265 */     return this.catalog;
/*     */   }
/*     */ 
/*     */   public void setCatalog(String catalog) {
/* 269 */     this.catalog = catalog;
/*     */   }
/*     */ 
/*     */   public String getDomainObjectName() {
/* 273 */     return this.domainObjectName;
/*     */   }
/*     */ 
/*     */   public void setDomainObjectName(String domainObjectName) {
/* 277 */     this.domainObjectName = domainObjectName;
/*     */   }
/*     */ 
/*     */   public String getSchema() {
/* 281 */     return this.schema;
/*     */   }
/*     */ 
/*     */   public void setSchema(String schema) {
/* 285 */     this.schema = schema;
/*     */   }
/*     */ 
/*     */   public String getTableName() {
/* 289 */     return this.tableName;
/*     */   }
/*     */ 
/*     */   public void setTableName(String tableName) {
/* 293 */     this.tableName = tableName;
/*     */   }
/*     */ 
/*     */   public List<ColumnOverride> getColumnOverrides() {
/* 297 */     return this.columnOverrides;
/*     */   }
/*     */ 
/*     */   public List<String> getIgnoredColumnsInError()
/*     */   {
/* 309 */     List answer = new ArrayList();
/*     */ 
/* 311 */     for (Map.Entry entry : this.ignoredColumns.entrySet())
/*     */     {
/* 313 */       if (Boolean.FALSE.equals(entry.getValue())) {
/* 314 */         answer.add(((IgnoredColumn)entry.getKey()).getColumnName());
/*     */       }
/*     */     }
/*     */ 
/* 318 */     return answer;
/*     */   }
/*     */ 
/*     */   public ModelType getModelType() {
/* 322 */     return this.modelType;
/*     */   }
/*     */ 
/*     */   public void setConfiguredModelType(String configuredModelType) {
/* 326 */     this.configuredModelType = configuredModelType;
/* 327 */     this.modelType = ModelType.getModelType(configuredModelType);
/*     */   }
/*     */ 
/*     */   public boolean isWildcardEscapingEnabled() {
/* 331 */     return this.wildcardEscapingEnabled;
/*     */   }
/*     */ 
/*     */   public void setWildcardEscapingEnabled(boolean wildcardEscapingEnabled) {
/* 335 */     this.wildcardEscapingEnabled = wildcardEscapingEnabled;
/*     */   }
/*     */ 
/*     */   public XmlElement toXmlElement() {
/* 339 */     XmlElement xmlElement = new XmlElement("table");
/* 340 */     xmlElement.addAttribute(new Attribute("tableName", this.tableName));
/*     */ 
/* 342 */     if (StringUtility.stringHasValue(this.catalog)) {
/* 343 */       xmlElement.addAttribute(new Attribute("catalog", this.catalog));
/*     */     }
/*     */ 
/* 346 */     if (StringUtility.stringHasValue(this.schema)) {
/* 347 */       xmlElement.addAttribute(new Attribute("schema", this.schema));
/*     */     }
/*     */ 
/* 350 */     if (StringUtility.stringHasValue(this.alias)) {
/* 351 */       xmlElement.addAttribute(new Attribute("alias", this.alias));
/*     */     }
/*     */ 
/* 354 */     if (StringUtility.stringHasValue(this.domainObjectName)) {
/* 355 */       xmlElement.addAttribute(new Attribute("domainObjectName", this.domainObjectName));
/*     */     }
/*     */ 
/* 359 */     if (!this.insertStatementEnabled) {
/* 360 */       xmlElement.addAttribute(new Attribute("enableInsert", "false"));
/*     */     }
/*     */ 
/* 363 */     if (!this.selectByPrimaryKeyStatementEnabled) {
/* 364 */       xmlElement.addAttribute(new Attribute("enableSelectByPrimaryKey", "false"));
/*     */     }
/*     */ 
/* 368 */     if (!this.selectByExampleStatementEnabled) {
/* 369 */       xmlElement.addAttribute(new Attribute("enableSelectByExample", "false"));
/*     */     }
/*     */ 
/* 373 */     if (!this.updateByPrimaryKeyStatementEnabled) {
/* 374 */       xmlElement.addAttribute(new Attribute("enableUpdateByPrimaryKey", "false"));
/*     */     }
/*     */ 
/* 378 */     if (!this.deleteByPrimaryKeyStatementEnabled) {
/* 379 */       xmlElement.addAttribute(new Attribute("enableDeleteByPrimaryKey", "false"));
/*     */     }
/*     */ 
/* 383 */     if (!this.deleteByExampleStatementEnabled) {
/* 384 */       xmlElement.addAttribute(new Attribute("enableDeleteByExample", "false"));
/*     */     }
/*     */ 
/* 388 */     if (!this.countByExampleStatementEnabled) {
/* 389 */       xmlElement.addAttribute(new Attribute("enableCountByExample", "false"));
/*     */     }
/*     */ 
/* 393 */     if (!this.updateByExampleStatementEnabled) {
/* 394 */       xmlElement.addAttribute(new Attribute("enableUpdateByExample", "false"));
/*     */     }
/*     */ 
/* 398 */     if (StringUtility.stringHasValue(this.selectByPrimaryKeyQueryId)) {
/* 399 */       xmlElement.addAttribute(new Attribute("selectByPrimaryKeyQueryId", this.selectByPrimaryKeyQueryId));
/*     */     }
/*     */ 
/* 403 */     if (StringUtility.stringHasValue(this.selectByExampleQueryId)) {
/* 404 */       xmlElement.addAttribute(new Attribute("selectByExampleQueryId", this.selectByExampleQueryId));
/*     */     }
/*     */ 
/* 408 */     if (this.configuredModelType != null) {
/* 409 */       xmlElement.addAttribute(new Attribute("modelType", this.configuredModelType));
/*     */     }
/*     */ 
/* 413 */     if (this.wildcardEscapingEnabled) {
/* 414 */       xmlElement.addAttribute(new Attribute("escapeWildcards", "true"));
/*     */     }
/*     */ 
/* 417 */     if (this.isAllColumnDelimitingEnabled) {
/* 418 */       xmlElement.addAttribute(new Attribute("delimitAllColumns", "true"));
/*     */     }
/*     */ 
/* 421 */     if (this.delimitIdentifiers) {
/* 422 */       xmlElement.addAttribute(new Attribute("delimitIdentifiers", "true"));
/*     */     }
/*     */ 
/* 426 */     addPropertyXmlElements(xmlElement);
/*     */ 
/* 428 */     if (this.generatedKey != null) {
/* 429 */       xmlElement.addElement(this.generatedKey.toXmlElement());
/*     */     }
/*     */ 
/* 432 */     if (this.columnRenamingRule != null) {
/* 433 */       xmlElement.addElement(this.columnRenamingRule.toXmlElement());
/*     */     }
/*     */ 
/* 436 */     if (this.ignoredColumns.size() > 0) {
/* 437 */       for (IgnoredColumn ignoredColumn : this.ignoredColumns.keySet()) {
/* 438 */         xmlElement.addElement(ignoredColumn.toXmlElement());
/*     */       }
/*     */     }
/*     */ 
/* 442 */     if (this.columnOverrides.size() > 0) {
/* 443 */       for (ColumnOverride columnOverride : this.columnOverrides) {
/* 444 */         xmlElement.addElement(columnOverride.toXmlElement());
/*     */       }
/*     */     }
/*     */ 
/* 448 */     return xmlElement;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 453 */     return StringUtility.composeFullyQualifiedTableName(this.catalog, this.schema, this.tableName, '.');
/*     */   }
/*     */ 
/*     */   public boolean isDelimitIdentifiers()
/*     */   {
/* 458 */     return this.delimitIdentifiers;
/*     */   }
/*     */ 
/*     */   public void setDelimitIdentifiers(boolean delimitIdentifiers) {
/* 462 */     this.delimitIdentifiers = delimitIdentifiers;
/*     */   }
/*     */ 
/*     */   public boolean isCountByExampleStatementEnabled() {
/* 466 */     return this.countByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setCountByExampleStatementEnabled(boolean countByExampleStatementEnabled)
/*     */   {
/* 471 */     this.countByExampleStatementEnabled = countByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public boolean isUpdateByExampleStatementEnabled() {
/* 475 */     return this.updateByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void setUpdateByExampleStatementEnabled(boolean updateByExampleStatementEnabled)
/*     */   {
/* 480 */     this.updateByExampleStatementEnabled = updateByExampleStatementEnabled;
/*     */   }
/*     */ 
/*     */   public void validate(List<String> errors, int listPosition) {
/* 484 */     if (!StringUtility.stringHasValue(this.tableName)) {
/* 485 */       errors.add(Messages.getString("ValidationError.6", Integer.toString(listPosition)));
/*     */     }
/*     */ 
/* 489 */     String fqTableName = StringUtility.composeFullyQualifiedTableName(this.catalog, this.schema, this.tableName, '.');
/*     */ 
/* 492 */     if (this.generatedKey != null) {
/* 493 */       this.generatedKey.validate(errors, fqTableName);
/*     */     }
/*     */ 
/* 496 */     if (StringUtility.isTrue(getProperty("useColumnIndexes")))
/*     */     {
/* 500 */       if ((this.selectByExampleStatementEnabled) && (this.selectByPrimaryKeyStatementEnabled))
/*     */       {
/* 502 */         boolean queryId1Set = StringUtility.stringHasValue(this.selectByExampleQueryId);
/*     */ 
/* 504 */         boolean queryId2Set = StringUtility.stringHasValue(this.selectByPrimaryKeyQueryId);
/*     */ 
/* 507 */         if (queryId1Set != queryId2Set) {
/* 508 */           errors.add(Messages.getString("ValidationError.13", fqTableName));
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 514 */     if (this.columnRenamingRule != null) {
/* 515 */       this.columnRenamingRule.validate(errors, fqTableName);
/*     */     }
/*     */ 
/* 518 */     for (ColumnOverride columnOverride : this.columnOverrides) {
/* 519 */       columnOverride.validate(errors, fqTableName);
/*     */     }
/*     */ 
/* 522 */     for (IgnoredColumn ignoredColumn : this.ignoredColumns.keySet())
/* 523 */       ignoredColumn.validate(errors, fqTableName);
/*     */   }
/*     */ 
/*     */   public ColumnRenamingRule getColumnRenamingRule()
/*     */   {
/* 528 */     return this.columnRenamingRule;
/*     */   }
/*     */ 
/*     */   public void setColumnRenamingRule(ColumnRenamingRule columnRenamingRule) {
/* 532 */     this.columnRenamingRule = columnRenamingRule;
/*     */   }
/*     */ 
/*     */   public boolean isAllColumnDelimitingEnabled() {
/* 536 */     return this.isAllColumnDelimitingEnabled;
/*     */   }
/*     */ 
/*     */   public void setAllColumnDelimitingEnabled(boolean isAllColumnDelimitingEnabled)
/*     */   {
/* 541 */     this.isAllColumnDelimitingEnabled = isAllColumnDelimitingEnabled;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.TableConfiguration
 * JD-Core Version:    0.6.0
 */