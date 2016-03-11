/*      */ package org.mybatis.generator.api;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.mybatis.generator.config.Context;
/*      */ import org.mybatis.generator.config.GeneratedKey;
/*      */ import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
/*      */ import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
/*      */ import org.mybatis.generator.config.ModelType;
/*      */ import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
/*      */ import org.mybatis.generator.config.TableConfiguration;
/*      */ import org.mybatis.generator.internal.rules.ConditionalModelRules;
/*      */ import org.mybatis.generator.internal.rules.FlatModelRules;
/*      */ import org.mybatis.generator.internal.rules.HierarchicalModelRules;
/*      */ import org.mybatis.generator.internal.rules.Rules;
/*      */ import org.mybatis.generator.internal.util.StringUtility;
/*      */ 
/*      */ public abstract class IntrospectedTable
/*      */ {
/*      */   protected TableConfiguration tableConfiguration;
/*      */   protected FullyQualifiedTable fullyQualifiedTable;
/*      */   protected Context context;
/*      */   protected Rules rules;
/*      */   protected List<IntrospectedColumn> primaryKeyColumns;
/*      */   protected List<IntrospectedColumn> baseColumns;
/*      */   protected List<IntrospectedColumn> blobColumns;
/*      */   protected TargetRuntime targetRuntime;
/*      */   protected Map<String, Object> attributes;
/*      */   protected Map<InternalAttribute, String> internalAttributes;
/*      */ 
/*      */   public IntrospectedTable(TargetRuntime targetRuntime)
/*      */   {
/*   81 */     this.targetRuntime = targetRuntime;
/*   82 */     this.primaryKeyColumns = new ArrayList();
/*   83 */     this.baseColumns = new ArrayList();
/*   84 */     this.blobColumns = new ArrayList();
/*   85 */     this.attributes = new HashMap();
/*   86 */     this.internalAttributes = new HashMap();
/*      */   }
/*      */ 
/*      */   public FullyQualifiedTable getFullyQualifiedTable() {
/*   90 */     return this.fullyQualifiedTable;
/*      */   }
/*      */ 
/*      */   public String getSelectByExampleQueryId() {
/*   94 */     return this.tableConfiguration.getSelectByExampleQueryId();
/*      */   }
/*      */ 
/*      */   public String getSelectByPrimaryKeyQueryId() {
/*   98 */     return this.tableConfiguration.getSelectByPrimaryKeyQueryId();
/*      */   }
/*      */ 
/*      */   public GeneratedKey getGeneratedKey() {
/*  102 */     return this.tableConfiguration.getGeneratedKey();
/*      */   }
/*      */ 
/*      */   public IntrospectedColumn getColumn(String columnName) {
/*  106 */     if (columnName == null) {
/*  107 */       return null;
/*      */     }
/*      */ 
/*  110 */     for (IntrospectedColumn introspectedColumn : this.primaryKeyColumns) {
/*  111 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  112 */         if (introspectedColumn.getActualColumnName().equals(columnName))
/*      */         {
/*  114 */           return introspectedColumn;
/*      */         }
/*      */       }
/*  117 */       else if (introspectedColumn.getActualColumnName().equalsIgnoreCase(columnName))
/*      */       {
/*  119 */         return introspectedColumn;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  125 */     for (IntrospectedColumn introspectedColumn : this.baseColumns) {
/*  126 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  127 */         if (introspectedColumn.getActualColumnName().equals(columnName))
/*      */         {
/*  129 */           return introspectedColumn;
/*      */         }
/*      */       }
/*  132 */       else if (introspectedColumn.getActualColumnName().equalsIgnoreCase(columnName))
/*      */       {
/*  134 */         return introspectedColumn;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  140 */     for (IntrospectedColumn introspectedColumn : this.blobColumns) {
/*  141 */       if (introspectedColumn.isColumnNameDelimited()) {
/*  142 */         if (introspectedColumn.getActualColumnName().equals(columnName))
/*      */         {
/*  144 */           return introspectedColumn;
/*      */         }
/*      */       }
/*  147 */       else if (introspectedColumn.getActualColumnName().equalsIgnoreCase(columnName))
/*      */       {
/*  149 */         return introspectedColumn;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  154 */     return null;
/*      */   }
/*      */ 
/*      */   public boolean hasJDBCDateColumns()
/*      */   {
/*  165 */     boolean rc = false;
/*      */ 
/*  167 */     for (IntrospectedColumn introspectedColumn : this.primaryKeyColumns) {
/*  168 */       if (introspectedColumn.isJDBCDateColumn()) {
/*  169 */         rc = true;
/*  170 */         break;
/*      */       }
/*      */     }
/*      */ 
/*  174 */     if (!rc) {
/*  175 */       for (IntrospectedColumn introspectedColumn : this.baseColumns) {
/*  176 */         if (introspectedColumn.isJDBCDateColumn()) {
/*  177 */           rc = true;
/*  178 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  183 */     return rc;
/*      */   }
/*      */ 
/*      */   public boolean hasJDBCTimeColumns()
/*      */   {
/*  193 */     boolean rc = false;
/*      */ 
/*  195 */     for (IntrospectedColumn introspectedColumn : this.primaryKeyColumns) {
/*  196 */       if (introspectedColumn.isJDBCTimeColumn()) {
/*  197 */         rc = true;
/*  198 */         break;
/*      */       }
/*      */     }
/*      */ 
/*  202 */     if (!rc) {
/*  203 */       for (IntrospectedColumn introspectedColumn : this.baseColumns) {
/*  204 */         if (introspectedColumn.isJDBCTimeColumn()) {
/*  205 */           rc = true;
/*  206 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  211 */     return rc;
/*      */   }
/*      */ 
/*      */   public List<IntrospectedColumn> getPrimaryKeyColumns()
/*      */   {
/*  222 */     return this.primaryKeyColumns;
/*      */   }
/*      */ 
/*      */   public boolean hasPrimaryKeyColumns() {
/*  226 */     return this.primaryKeyColumns.size() > 0;
/*      */   }
/*      */ 
/*      */   public List<IntrospectedColumn> getBaseColumns() {
/*  230 */     return this.baseColumns;
/*      */   }
/*      */ 
/*      */   public List<IntrospectedColumn> getAllColumns()
/*      */   {
/*  240 */     List answer = new ArrayList();
/*  241 */     answer.addAll(this.primaryKeyColumns);
/*  242 */     answer.addAll(this.baseColumns);
/*  243 */     answer.addAll(this.blobColumns);
/*      */ 
/*  245 */     return answer;
/*      */   }
/*      */ 
/*      */   public List<IntrospectedColumn> getNonBLOBColumns()
/*      */   {
/*  256 */     List answer = new ArrayList();
/*  257 */     answer.addAll(this.primaryKeyColumns);
/*  258 */     answer.addAll(this.baseColumns);
/*      */ 
/*  260 */     return answer;
/*      */   }
/*      */ 
/*      */   public int getNonBLOBColumnCount() {
/*  264 */     return this.primaryKeyColumns.size() + this.baseColumns.size();
/*      */   }
/*      */ 
/*      */   public List<IntrospectedColumn> getNonPrimaryKeyColumns() {
/*  268 */     List answer = new ArrayList();
/*  269 */     answer.addAll(this.baseColumns);
/*  270 */     answer.addAll(this.blobColumns);
/*      */ 
/*  272 */     return answer;
/*      */   }
/*      */ 
/*      */   public List<IntrospectedColumn> getBLOBColumns() {
/*  276 */     return this.blobColumns;
/*      */   }
/*      */ 
/*      */   public boolean hasBLOBColumns() {
/*  280 */     return this.blobColumns.size() > 0;
/*      */   }
/*      */ 
/*      */   public boolean hasBaseColumns() {
/*  284 */     return this.baseColumns.size() > 0;
/*      */   }
/*      */ 
/*      */   public Rules getRules() {
/*  288 */     return this.rules;
/*      */   }
/*      */ 
/*      */   public String getTableConfigurationProperty(String property) {
/*  292 */     return this.tableConfiguration.getProperty(property);
/*      */   }
/*      */ 
/*      */   public String getPrimaryKeyType() {
/*  296 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_PRIMARY_KEY_TYPE);
/*      */   }
/*      */ 
/*      */   public String getBaseRecordType()
/*      */   {
/*  306 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_BASE_RECORD_TYPE);
/*      */   }
/*      */ 
/*      */   public String getExampleType()
/*      */   {
/*  314 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_EXAMPLE_TYPE);
/*      */   }
/*      */ 
/*      */   public String getRecordWithBLOBsType()
/*      */   {
/*  324 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_RECORD_WITH_BLOBS_TYPE);
/*      */   }
/*      */ 
/*      */   public String getIbatis2SqlMapFileName()
/*      */   {
/*  336 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_IBATIS2_SQL_MAP_FILE_NAME);
/*      */   }
/*      */ 
/*      */   public String getIbatis2SqlMapNamespace()
/*      */   {
/*  341 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_IBATIS2_SQL_MAP_NAMESPACE);
/*      */   }
/*      */ 
/*      */   public String getIbatis2SqlMapPackage()
/*      */   {
/*  351 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_IBATIS2_SQL_MAP_PACKAGE);
/*      */   }
/*      */ 
/*      */   public String getDAOImplementationType()
/*      */   {
/*  356 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_DAO_IMPLEMENTATION_TYPE);
/*      */   }
/*      */ 
/*      */   public String getDAOInterfaceType()
/*      */   {
/*  361 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_DAO_INTERFACE_TYPE);
/*      */   }
/*      */ 
/*      */   public boolean hasAnyColumns()
/*      */   {
/*  366 */     return (this.primaryKeyColumns.size() > 0) || (this.baseColumns.size() > 0) || (this.blobColumns.size() > 0);
/*      */   }
/*      */ 
/*      */   public void setTableConfiguration(TableConfiguration tableConfiguration)
/*      */   {
/*  371 */     this.tableConfiguration = tableConfiguration;
/*      */   }
/*      */ 
/*      */   public void setFullyQualifiedTable(FullyQualifiedTable fullyQualifiedTable) {
/*  375 */     this.fullyQualifiedTable = fullyQualifiedTable;
/*      */   }
/*      */ 
/*      */   public void setContext(Context context) {
/*  379 */     this.context = context;
/*      */   }
/*      */ 
/*      */   public void addColumn(IntrospectedColumn introspectedColumn) {
/*  383 */     if (introspectedColumn.isBLOBColumn())
/*  384 */       this.blobColumns.add(introspectedColumn);
/*      */     else {
/*  386 */       this.baseColumns.add(introspectedColumn);
/*      */     }
/*      */ 
/*  389 */     introspectedColumn.setIntrospectedTable(this);
/*      */   }
/*      */ 
/*      */   public void addPrimaryKeyColumn(String columnName) {
/*  393 */     boolean found = false;
/*      */ 
/*  395 */     Iterator iter = this.baseColumns.iterator();
/*  396 */     while (iter.hasNext()) {
/*  397 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*  398 */       if (introspectedColumn.getActualColumnName().equals(columnName)) {
/*  399 */         this.primaryKeyColumns.add(introspectedColumn);
/*  400 */         iter.remove();
/*  401 */         found = true;
/*  402 */         break;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  407 */     if (!found) {
/*  408 */       iter = this.blobColumns.iterator();
/*  409 */       while (iter.hasNext()) {
/*  410 */         IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*  411 */         if (introspectedColumn.getActualColumnName().equals(columnName)) {
/*  412 */           this.primaryKeyColumns.add(introspectedColumn);
/*  413 */           iter.remove();
/*  414 */           found = true;
/*  415 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public Object getAttribute(String name) {
/*  422 */     return this.attributes.get(name);
/*      */   }
/*      */ 
/*      */   public void removeAttribute(String name) {
/*  426 */     this.attributes.remove(name);
/*      */   }
/*      */ 
/*      */   public void setAttribute(String name, Object value) {
/*  430 */     this.attributes.put(name, value);
/*      */   }
/*      */ 
/*      */   public void initialize() {
/*  434 */     calculateJavaClientAttributes();
/*  435 */     calculateModelAttributes();
/*  436 */     calculateXmlAttributes();
/*      */ 
/*  438 */     if (this.tableConfiguration.getModelType() == ModelType.HIERARCHICAL)
/*  439 */       this.rules = new HierarchicalModelRules(this);
/*  440 */     else if (this.tableConfiguration.getModelType() == ModelType.FLAT)
/*  441 */       this.rules = new FlatModelRules(this);
/*      */     else {
/*  443 */       this.rules = new ConditionalModelRules(this);
/*      */     }
/*      */ 
/*  446 */     this.context.getPlugins().initialized(this);
/*      */   }
/*      */ 
/*      */   protected void calculateXmlAttributes()
/*      */   {
/*  453 */     setIbatis2SqlMapPackage(calculateIbatis2SqlMapPackage());
/*  454 */     setIbatis2SqlMapFileName(calculateIbatis2SqlMapFileName());
/*  455 */     setMyBatis3XmlMapperFileName(calculateMyBatis3XmlMapperFileName());
/*  456 */     setMyBatis3XmlMapperPackage(getIbatis2SqlMapPackage());
/*      */ 
/*  459 */     setIbatis2SqlMapNamespace(calculateIbatis2SqlMapNamespace());
/*  460 */     setSqlMapFullyQualifiedRuntimeTableName(calculateSqlMapFullyQualifiedRuntimeTableName());
/*  461 */     setSqlMapAliasedFullyQualifiedRuntimeTableName(calculateSqlMapAliasedFullyQualifiedRuntimeTableName());
/*      */ 
/*  463 */     setCountByExampleStatementId("countByExample");
/*  464 */     setDeleteByExampleStatementId("deleteByExample");
/*  465 */     setDeleteByPrimaryKeyStatementId("deleteByPrimaryKey");
/*  466 */     setInsertStatementId("insert");
/*  467 */     setInsertSelectiveStatementId("insertSelective");
/*  468 */     setSelectByExampleStatementId("selectByExample");
/*  469 */     setSelectByExampleWithBLOBsStatementId("selectByExampleWithBLOBs");
/*  470 */     setSelectByPrimaryKeyStatementId("selectByPrimaryKey");
/*  471 */     setUpdateByExampleStatementId("updateByExample");
/*  472 */     setUpdateByExampleSelectiveStatementId("updateByExampleSelective");
/*  473 */     setUpdateByExampleWithBLOBsStatementId("updateByExampleWithBLOBs");
/*  474 */     setUpdateByPrimaryKeyStatementId("updateByPrimaryKey");
/*  475 */     setUpdateByPrimaryKeySelectiveStatementId("updateByPrimaryKeySelective");
/*  476 */     setUpdateByPrimaryKeyWithBLOBsStatementId("updateByPrimaryKeyWithBLOBs");
/*  477 */     setBaseResultMapId("BaseResultMap");
/*  478 */     setResultMapWithBLOBsId("ResultMapWithBLOBs");
/*  479 */     setExampleWhereClauseId("Example_Where_Clause");
/*  480 */     setBaseColumnListId("Base_Column_List");
/*  481 */     setBlobColumnListId("Blob_Column_List");
/*  482 */     setMyBatis3UpdateByExampleWhereClauseId("Update_By_Example_Where_Clause");
/*      */   }
/*      */ 
/*      */   public void setBlobColumnListId(String s) {
/*  486 */     this.internalAttributes.put(InternalAttribute.ATTR_BLOB_COLUMN_LIST_ID, s);
/*      */   }
/*      */ 
/*      */   public void setBaseColumnListId(String s) {
/*  490 */     this.internalAttributes.put(InternalAttribute.ATTR_BASE_COLUMN_LIST_ID, s);
/*      */   }
/*      */ 
/*      */   public void setExampleWhereClauseId(String s) {
/*  494 */     this.internalAttributes.put(InternalAttribute.ATTR_EXAMPLE_WHERE_CLAUSE_ID, s);
/*      */   }
/*      */ 
/*      */   public void setMyBatis3UpdateByExampleWhereClauseId(String s)
/*      */   {
/*  499 */     this.internalAttributes.put(InternalAttribute.ATTR_MYBATIS3_UPDATE_BY_EXAMPLE_WHERE_CLAUSE_ID, s);
/*      */   }
/*      */ 
/*      */   public void setResultMapWithBLOBsId(String s)
/*      */   {
/*  506 */     this.internalAttributes.put(InternalAttribute.ATTR_RESULT_MAP_WITH_BLOBS_ID, s);
/*      */   }
/*      */ 
/*      */   public void setBaseResultMapId(String s)
/*      */   {
/*  511 */     this.internalAttributes.put(InternalAttribute.ATTR_BASE_RESULT_MAP_ID, s);
/*      */   }
/*      */ 
/*      */   public void setUpdateByPrimaryKeyWithBLOBsStatementId(String s) {
/*  515 */     this.internalAttributes.put(InternalAttribute.ATTR_UPDATE_BY_PRIMARY_KEY_WITH_BLOBS_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setUpdateByPrimaryKeySelectiveStatementId(String s)
/*      */   {
/*  522 */     this.internalAttributes.put(InternalAttribute.ATTR_UPDATE_BY_PRIMARY_KEY_SELECTIVE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setUpdateByPrimaryKeyStatementId(String s)
/*      */   {
/*  529 */     this.internalAttributes.put(InternalAttribute.ATTR_UPDATE_BY_PRIMARY_KEY_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setUpdateByExampleWithBLOBsStatementId(String s)
/*      */   {
/*  534 */     this.internalAttributes.put(InternalAttribute.ATTR_UPDATE_BY_EXAMPLE_WITH_BLOBS_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setUpdateByExampleSelectiveStatementId(String s)
/*      */   {
/*  541 */     this.internalAttributes.put(InternalAttribute.ATTR_UPDATE_BY_EXAMPLE_SELECTIVE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setUpdateByExampleStatementId(String s)
/*      */   {
/*  548 */     this.internalAttributes.put(InternalAttribute.ATTR_UPDATE_BY_EXAMPLE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setSelectByPrimaryKeyStatementId(String s)
/*      */   {
/*  553 */     this.internalAttributes.put(InternalAttribute.ATTR_SELECT_BY_PRIMARY_KEY_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setSelectByExampleWithBLOBsStatementId(String s)
/*      */   {
/*  558 */     this.internalAttributes.put(InternalAttribute.ATTR_SELECT_BY_EXAMPLE_WITH_BLOBS_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setSelectByExampleStatementId(String s)
/*      */   {
/*  565 */     this.internalAttributes.put(InternalAttribute.ATTR_SELECT_BY_EXAMPLE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setInsertSelectiveStatementId(String s)
/*      */   {
/*  570 */     this.internalAttributes.put(InternalAttribute.ATTR_INSERT_SELECTIVE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setInsertStatementId(String s)
/*      */   {
/*  575 */     this.internalAttributes.put(InternalAttribute.ATTR_INSERT_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setDeleteByPrimaryKeyStatementId(String s) {
/*  579 */     this.internalAttributes.put(InternalAttribute.ATTR_DELETE_BY_PRIMARY_KEY_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setDeleteByExampleStatementId(String s)
/*      */   {
/*  584 */     this.internalAttributes.put(InternalAttribute.ATTR_DELETE_BY_EXAMPLE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public void setCountByExampleStatementId(String s)
/*      */   {
/*  589 */     this.internalAttributes.put(InternalAttribute.ATTR_COUNT_BY_EXAMPLE_STATEMENT_ID, s);
/*      */   }
/*      */ 
/*      */   public String getBlobColumnListId()
/*      */   {
/*  594 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_BLOB_COLUMN_LIST_ID);
/*      */   }
/*      */ 
/*      */   public String getBaseColumnListId()
/*      */   {
/*  599 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_BASE_COLUMN_LIST_ID);
/*      */   }
/*      */ 
/*      */   public String getExampleWhereClauseId()
/*      */   {
/*  604 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_EXAMPLE_WHERE_CLAUSE_ID);
/*      */   }
/*      */ 
/*      */   public String getMyBatis3UpdateByExampleWhereClauseId()
/*      */   {
/*  609 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_MYBATIS3_UPDATE_BY_EXAMPLE_WHERE_CLAUSE_ID);
/*      */   }
/*      */ 
/*      */   public String getResultMapWithBLOBsId()
/*      */   {
/*  614 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_RESULT_MAP_WITH_BLOBS_ID);
/*      */   }
/*      */ 
/*      */   public String getBaseResultMapId()
/*      */   {
/*  619 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_BASE_RESULT_MAP_ID);
/*      */   }
/*      */ 
/*      */   public String getUpdateByPrimaryKeyWithBLOBsStatementId()
/*      */   {
/*  624 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_UPDATE_BY_PRIMARY_KEY_WITH_BLOBS_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getUpdateByPrimaryKeySelectiveStatementId()
/*      */   {
/*  629 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_UPDATE_BY_PRIMARY_KEY_SELECTIVE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getUpdateByPrimaryKeyStatementId()
/*      */   {
/*  634 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_UPDATE_BY_PRIMARY_KEY_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getUpdateByExampleWithBLOBsStatementId()
/*      */   {
/*  639 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_UPDATE_BY_EXAMPLE_WITH_BLOBS_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getUpdateByExampleSelectiveStatementId()
/*      */   {
/*  644 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_UPDATE_BY_EXAMPLE_SELECTIVE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getUpdateByExampleStatementId()
/*      */   {
/*  649 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_UPDATE_BY_EXAMPLE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getSelectByPrimaryKeyStatementId()
/*      */   {
/*  654 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_SELECT_BY_PRIMARY_KEY_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getSelectByExampleWithBLOBsStatementId()
/*      */   {
/*  659 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_SELECT_BY_EXAMPLE_WITH_BLOBS_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getSelectByExampleStatementId()
/*      */   {
/*  664 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_SELECT_BY_EXAMPLE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getInsertSelectiveStatementId()
/*      */   {
/*  669 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_INSERT_SELECTIVE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getInsertStatementId()
/*      */   {
/*  674 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_INSERT_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getDeleteByPrimaryKeyStatementId()
/*      */   {
/*  679 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_DELETE_BY_PRIMARY_KEY_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getDeleteByExampleStatementId()
/*      */   {
/*  684 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_DELETE_BY_EXAMPLE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   public String getCountByExampleStatementId()
/*      */   {
/*  689 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_COUNT_BY_EXAMPLE_STATEMENT_ID);
/*      */   }
/*      */ 
/*      */   protected String calculateJavaClientImplementationPackage()
/*      */   {
/*  694 */     JavaClientGeneratorConfiguration config = this.context.getJavaClientGeneratorConfiguration();
/*      */ 
/*  696 */     if (config == null) {
/*  697 */       return null;
/*      */     }
/*      */ 
/*  700 */     StringBuilder sb = new StringBuilder();
/*  701 */     if (StringUtility.stringHasValue(config.getImplementationPackage()))
/*  702 */       sb.append(config.getImplementationPackage());
/*      */     else {
/*  704 */       sb.append(config.getTargetPackage());
/*      */     }
/*  706 */     if (StringUtility.isTrue(config.getProperty("enableSubPackages")))
/*      */     {
/*  708 */       sb.append(this.fullyQualifiedTable.getSubPackage());
/*      */     }
/*      */ 
/*  711 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   protected String calculateJavaClientInterfacePackage() {
/*  715 */     JavaClientGeneratorConfiguration config = this.context.getJavaClientGeneratorConfiguration();
/*      */ 
/*  717 */     if (config == null) {
/*  718 */       return null;
/*      */     }
/*      */ 
/*  721 */     StringBuilder sb = new StringBuilder();
/*  722 */     sb.append(config.getTargetPackage());
/*  723 */     if (StringUtility.isTrue(config.getProperty("enableSubPackages")))
/*      */     {
/*  725 */       sb.append(this.fullyQualifiedTable.getSubPackage());
/*      */     }
/*      */ 
/*  728 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   protected void calculateJavaClientAttributes() {
/*  732 */     if (this.context.getJavaClientGeneratorConfiguration() == null) {
/*  733 */       return;
/*      */     }
/*      */ 
/*  736 */     StringBuilder sb = new StringBuilder();
/*  737 */     sb.append(calculateJavaClientImplementationPackage());
/*  738 */     sb.append('.');
/*  739 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  740 */     sb.append("DAOImpl");
/*  741 */     setDAOImplementationType(sb.toString());
/*      */ 
/*  743 */     sb.setLength(0);
/*  744 */     sb.append(calculateJavaClientInterfacePackage());
/*  745 */     sb.append('.');
/*  746 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  747 */     sb.append("DAO");
/*  748 */     setDAOInterfaceType(sb.toString());
/*      */ 
/*  750 */     sb.setLength(0);
/*  751 */     sb.append(calculateJavaClientInterfacePackage());
/*  752 */     sb.append('.');
/*  753 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  754 */     sb.append("Mapper");
/*  755 */     setMyBatis3JavaMapperType(sb.toString());
/*      */   }
/*      */ 
/*      */   protected String calculateJavaModelPackage() {
/*  759 */     JavaModelGeneratorConfiguration config = this.context.getJavaModelGeneratorConfiguration();
/*      */ 
/*  762 */     StringBuilder sb = new StringBuilder();
/*  763 */     sb.append(config.getTargetPackage());
/*  764 */     if (StringUtility.isTrue(config.getProperty("enableSubPackages")))
/*      */     {
/*  766 */       sb.append(this.fullyQualifiedTable.getSubPackage());
/*      */     }
/*      */ 
/*  769 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   protected void calculateModelAttributes() {
/*  773 */     String pakkage = calculateJavaModelPackage();
/*      */ 
/*  775 */     StringBuilder sb = new StringBuilder();
/*  776 */     sb.append(pakkage);
/*  777 */     sb.append('.');
/*  778 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  779 */     sb.append("Key");
/*  780 */     setPrimaryKeyType(sb.toString());
/*      */ 
/*  782 */     sb.setLength(0);
/*  783 */     sb.append(pakkage);
/*  784 */     sb.append('.');
/*  785 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  786 */     setBaseRecordType(sb.toString());
/*      */ 
/*  788 */     sb.setLength(0);
/*  789 */     sb.append(pakkage);
/*  790 */     sb.append('.');
/*  791 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  792 */     sb.append("WithBLOBs");
/*  793 */     setRecordWithBLOBsType(sb.toString());
/*      */ 
/*  795 */     sb.setLength(0);
/*  796 */     sb.append(pakkage);
/*  797 */     sb.append('.');
/*  798 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  799 */     sb.append("Example");
/*  800 */     setExampleType(sb.toString());
/*      */   }
/*      */ 
/*      */   protected String calculateIbatis2SqlMapPackage() {
/*  804 */     SqlMapGeneratorConfiguration config = this.context.getSqlMapGeneratorConfiguration();
/*      */ 
/*  807 */     StringBuilder sb = new StringBuilder(config.getTargetPackage());
/*  808 */     if (StringUtility.isTrue(config.getProperty("enableSubPackages")))
/*      */     {
/*  810 */       sb.append(this.fullyQualifiedTable.getSubPackage());
/*      */     }
/*  812 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   protected String calculateIbatis2SqlMapFileName() {
/*  816 */     StringBuilder sb = new StringBuilder();
/*  817 */     sb.append(this.fullyQualifiedTable.getIbatis2SqlMapNamespace());
/*  818 */     sb.append("_SqlMap.xml");
/*  819 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   protected String calculateMyBatis3XmlMapperFileName() {
/*  823 */     StringBuilder sb = new StringBuilder();
/*  824 */     sb.append(this.fullyQualifiedTable.getDomainObjectName());
/*  825 */     sb.append("Mapper.xml");
/*  826 */     return sb.toString();
/*      */   }
/*      */ 
/*      */   protected String calculateIbatis2SqlMapNamespace() {
/*  830 */     return this.fullyQualifiedTable.getIbatis2SqlMapNamespace();
/*      */   }
/*      */ 
/*      */   protected String calculateSqlMapFullyQualifiedRuntimeTableName() {
/*  834 */     return this.fullyQualifiedTable.getFullyQualifiedTableNameAtRuntime();
/*      */   }
/*      */ 
/*      */   protected String calculateSqlMapAliasedFullyQualifiedRuntimeTableName() {
/*  838 */     return this.fullyQualifiedTable.getAliasedFullyQualifiedTableNameAtRuntime();
/*      */   }
/*      */ 
/*      */   public String getFullyQualifiedTableNameAtRuntime() {
/*  842 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME);
/*      */   }
/*      */ 
/*      */   public String getAliasedFullyQualifiedTableNameAtRuntime()
/*      */   {
/*  847 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_ALIASED_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME);
/*      */   }
/*      */ 
/*      */   public abstract void calculateGenerators(List<String> paramList, ProgressCallback paramProgressCallback);
/*      */ 
/*      */   public abstract List<GeneratedJavaFile> getGeneratedJavaFiles();
/*      */ 
/*      */   public abstract List<GeneratedXmlFile> getGeneratedXmlFiles();
/*      */ 
/*      */   public abstract boolean isJava5Targeted();
/*      */ 
/*      */   public abstract int getGenerationSteps();
/*      */ 
/*      */   public void setRules(Rules rules)
/*      */   {
/*  905 */     this.rules = rules;
/*      */   }
/*      */ 
/*      */   public TableConfiguration getTableConfiguration() {
/*  909 */     return this.tableConfiguration;
/*      */   }
/*      */ 
/*      */   public void setDAOImplementationType(String DAOImplementationType) {
/*  913 */     this.internalAttributes.put(InternalAttribute.ATTR_DAO_IMPLEMENTATION_TYPE, DAOImplementationType);
/*      */   }
/*      */ 
/*      */   public void setDAOInterfaceType(String DAOInterfaceType)
/*      */   {
/*  918 */     this.internalAttributes.put(InternalAttribute.ATTR_DAO_INTERFACE_TYPE, DAOInterfaceType);
/*      */   }
/*      */ 
/*      */   public void setPrimaryKeyType(String primaryKeyType)
/*      */   {
/*  923 */     this.internalAttributes.put(InternalAttribute.ATTR_PRIMARY_KEY_TYPE, primaryKeyType);
/*      */   }
/*      */ 
/*      */   public void setBaseRecordType(String baseRecordType)
/*      */   {
/*  928 */     this.internalAttributes.put(InternalAttribute.ATTR_BASE_RECORD_TYPE, baseRecordType);
/*      */   }
/*      */ 
/*      */   public void setRecordWithBLOBsType(String recordWithBLOBsType)
/*      */   {
/*  933 */     this.internalAttributes.put(InternalAttribute.ATTR_RECORD_WITH_BLOBS_TYPE, recordWithBLOBsType);
/*      */   }
/*      */ 
/*      */   public void setExampleType(String exampleType)
/*      */   {
/*  938 */     this.internalAttributes.put(InternalAttribute.ATTR_EXAMPLE_TYPE, exampleType);
/*      */   }
/*      */ 
/*      */   public void setIbatis2SqlMapPackage(String sqlMapPackage)
/*      */   {
/*  943 */     this.internalAttributes.put(InternalAttribute.ATTR_IBATIS2_SQL_MAP_PACKAGE, sqlMapPackage);
/*      */   }
/*      */ 
/*      */   public void setIbatis2SqlMapFileName(String sqlMapFileName)
/*      */   {
/*  948 */     this.internalAttributes.put(InternalAttribute.ATTR_IBATIS2_SQL_MAP_FILE_NAME, sqlMapFileName);
/*      */   }
/*      */ 
/*      */   public void setIbatis2SqlMapNamespace(String sqlMapNamespace)
/*      */   {
/*  954 */     this.internalAttributes.put(InternalAttribute.ATTR_IBATIS2_SQL_MAP_NAMESPACE, sqlMapNamespace);
/*      */   }
/*      */ 
/*      */   public void setSqlMapFullyQualifiedRuntimeTableName(String fullyQualifiedRuntimeTableName)
/*      */   {
/*  961 */     this.internalAttributes.put(InternalAttribute.ATTR_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME, fullyQualifiedRuntimeTableName);
/*      */   }
/*      */ 
/*      */   public void setSqlMapAliasedFullyQualifiedRuntimeTableName(String aliasedFullyQualifiedRuntimeTableName)
/*      */   {
/*  968 */     this.internalAttributes.put(InternalAttribute.ATTR_ALIASED_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME, aliasedFullyQualifiedRuntimeTableName);
/*      */   }
/*      */ 
/*      */   public String getMyBatis3XmlMapperPackage()
/*      */   {
/*  975 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_MYBATIS3_XML_MAPPER_PACKAGE);
/*      */   }
/*      */ 
/*      */   public void setMyBatis3XmlMapperPackage(String mybatis3XmlMapperPackage)
/*      */   {
/*  980 */     this.internalAttributes.put(InternalAttribute.ATTR_MYBATIS3_XML_MAPPER_PACKAGE, mybatis3XmlMapperPackage);
/*      */   }
/*      */ 
/*      */   public String getMyBatis3XmlMapperFileName()
/*      */   {
/*  986 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_MYBATIS3_XML_MAPPER_FILE_NAME);
/*      */   }
/*      */ 
/*      */   public void setMyBatis3XmlMapperFileName(String mybatis3XmlMapperFileName)
/*      */   {
/*  991 */     this.internalAttributes.put(InternalAttribute.ATTR_MYBATIS3_XML_MAPPER_FILE_NAME, mybatis3XmlMapperFileName);
/*      */   }
/*      */ 
/*      */   public String getMyBatis3JavaMapperType()
/*      */   {
/*  997 */     return (String)this.internalAttributes.get(InternalAttribute.ATTR_MYBATIS3_JAVA_MAPPER_TYPE);
/*      */   }
/*      */ 
/*      */   public void setMyBatis3JavaMapperType(String mybatis3JavaMapperType)
/*      */   {
/* 1002 */     this.internalAttributes.put(InternalAttribute.ATTR_MYBATIS3_JAVA_MAPPER_TYPE, mybatis3JavaMapperType);
/*      */   }
/*      */ 
/*      */   public TargetRuntime getTargetRuntime()
/*      */   {
/* 1008 */     return this.targetRuntime;
/*      */   }
/*      */ 
/*      */   protected static enum InternalAttribute
/*      */   {
/*   53 */     ATTR_DAO_IMPLEMENTATION_TYPE, ATTR_DAO_INTERFACE_TYPE, ATTR_PRIMARY_KEY_TYPE, ATTR_BASE_RECORD_TYPE, ATTR_RECORD_WITH_BLOBS_TYPE, ATTR_EXAMPLE_TYPE, ATTR_IBATIS2_SQL_MAP_PACKAGE, ATTR_IBATIS2_SQL_MAP_FILE_NAME, ATTR_IBATIS2_SQL_MAP_NAMESPACE, ATTR_MYBATIS3_XML_MAPPER_PACKAGE, ATTR_MYBATIS3_XML_MAPPER_FILE_NAME, 
/*      */ 
/*   55 */     ATTR_MYBATIS3_JAVA_MAPPER_TYPE, ATTR_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME, ATTR_ALIASED_FULLY_QUALIFIED_TABLE_NAME_AT_RUNTIME, ATTR_COUNT_BY_EXAMPLE_STATEMENT_ID, ATTR_DELETE_BY_EXAMPLE_STATEMENT_ID, ATTR_DELETE_BY_PRIMARY_KEY_STATEMENT_ID, ATTR_INSERT_STATEMENT_ID, ATTR_INSERT_SELECTIVE_STATEMENT_ID, ATTR_SELECT_BY_EXAMPLE_STATEMENT_ID, ATTR_SELECT_BY_EXAMPLE_WITH_BLOBS_STATEMENT_ID, ATTR_SELECT_BY_PRIMARY_KEY_STATEMENT_ID, ATTR_UPDATE_BY_EXAMPLE_STATEMENT_ID, ATTR_UPDATE_BY_EXAMPLE_SELECTIVE_STATEMENT_ID, ATTR_UPDATE_BY_EXAMPLE_WITH_BLOBS_STATEMENT_ID, ATTR_UPDATE_BY_PRIMARY_KEY_STATEMENT_ID, ATTR_UPDATE_BY_PRIMARY_KEY_SELECTIVE_STATEMENT_ID, ATTR_UPDATE_BY_PRIMARY_KEY_WITH_BLOBS_STATEMENT_ID, ATTR_BASE_RESULT_MAP_ID, ATTR_RESULT_MAP_WITH_BLOBS_ID, ATTR_EXAMPLE_WHERE_CLAUSE_ID, ATTR_BASE_COLUMN_LIST_ID, ATTR_BLOB_COLUMN_LIST_ID, ATTR_MYBATIS3_UPDATE_BY_EXAMPLE_WHERE_CLAUSE_ID;
/*      */   }
/*      */ 
/*      */   public static enum TargetRuntime
/*      */   {
/*   49 */     IBATIS2, MYBATIS3;
/*      */   }
/*      */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.IntrospectedTable
 * JD-Core Version:    0.6.0
 */