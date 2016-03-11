/*     */ package org.mybatis.generator.config;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.GeneratedJavaFile;
/*     */ import org.mybatis.generator.api.GeneratedXmlFile;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.JavaTypeResolver;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.ProgressCallback;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.PluginAggregator;
/*     */ import org.mybatis.generator.internal.db.ConnectionFactory;
/*     */ import org.mybatis.generator.internal.db.DatabaseIntrospector;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class Context extends PropertyHolder
/*     */ {
/*     */   private String id;
/*     */   private JDBCConnectionConfiguration jdbcConnectionConfiguration;
/*     */   private SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration;
/*     */   private JavaTypeResolverConfiguration javaTypeResolverConfiguration;
/*     */   private JavaModelGeneratorConfiguration javaModelGeneratorConfiguration;
/*     */   private JavaClientGeneratorConfiguration javaClientGeneratorConfiguration;
/*     */   private ArrayList<TableConfiguration> tableConfigurations;
/*     */   private ModelType defaultModelType;
/*  60 */   private String beginningDelimiter = "\"";
/*     */ 
/*  62 */   private String endingDelimiter = "\"";
/*     */   private CommentGeneratorConfiguration commentGeneratorConfiguration;
/*     */   private CommentGenerator commentGenerator;
/*     */   private PluginAggregator pluginAggregator;
/*     */   private List<PluginConfiguration> pluginConfigurations;
/*     */   private String targetRuntime;
/*     */   private String introspectedColumnImpl;
/*     */   private Boolean autoDelimitKeywords;
/*     */   private List<IntrospectedTable> introspectedTables;
/*     */ 
/*     */   public Context(ModelType defaultModelType)
/*     */   {
/*  87 */     if (defaultModelType == null)
/*  88 */       this.defaultModelType = ModelType.CONDITIONAL;
/*     */     else {
/*  90 */       this.defaultModelType = defaultModelType;
/*     */     }
/*     */ 
/*  93 */     this.tableConfigurations = new ArrayList();
/*  94 */     this.pluginConfigurations = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void addTableConfiguration(TableConfiguration tc) {
/*  98 */     this.tableConfigurations.add(tc);
/*     */   }
/*     */ 
/*     */   public JDBCConnectionConfiguration getJdbcConnectionConfiguration() {
/* 102 */     return this.jdbcConnectionConfiguration;
/*     */   }
/*     */ 
/*     */   public JavaClientGeneratorConfiguration getJavaClientGeneratorConfiguration() {
/* 106 */     return this.javaClientGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public JavaModelGeneratorConfiguration getJavaModelGeneratorConfiguration() {
/* 110 */     return this.javaModelGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public JavaTypeResolverConfiguration getJavaTypeResolverConfiguration() {
/* 114 */     return this.javaTypeResolverConfiguration;
/*     */   }
/*     */ 
/*     */   public SqlMapGeneratorConfiguration getSqlMapGeneratorConfiguration() {
/* 118 */     return this.sqlMapGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public void addPluginConfiguration(PluginConfiguration pluginConfiguration)
/*     */   {
/* 123 */     this.pluginConfigurations.add(pluginConfiguration);
/*     */   }
/*     */ 
/*     */   public void validate(List<String> errors)
/*     */   {
/* 133 */     if (!StringUtility.stringHasValue(this.id)) {
/* 134 */       errors.add(Messages.getString("ValidationError.16"));
/*     */     }
/*     */ 
/* 137 */     if (this.jdbcConnectionConfiguration == null)
/* 138 */       errors.add(Messages.getString("ValidationError.10", this.id));
/*     */     else {
/* 140 */       this.jdbcConnectionConfiguration.validate(errors);
/*     */     }
/*     */ 
/* 143 */     if (this.javaModelGeneratorConfiguration == null)
/* 144 */       errors.add(Messages.getString("ValidationError.8", this.id));
/*     */     else {
/* 146 */       this.javaModelGeneratorConfiguration.validate(errors, this.id);
/*     */     }
/*     */ 
/* 149 */     if (this.sqlMapGeneratorConfiguration == null)
/* 150 */       errors.add(Messages.getString("ValidationError.9", this.id));
/*     */     else {
/* 152 */       this.sqlMapGeneratorConfiguration.validate(errors, this.id);
/*     */     }
/*     */ 
/* 155 */     if (this.javaClientGeneratorConfiguration != null) {
/* 156 */       this.javaClientGeneratorConfiguration.validate(errors, this.id);
/*     */     }
/*     */ 
/* 159 */     if (this.tableConfigurations.size() == 0)
/* 160 */       errors.add(Messages.getString("ValidationError.3", this.id));
/*     */     else {
/* 162 */       for (int i = 0; i < this.tableConfigurations.size(); i++) {
/* 163 */         TableConfiguration tc = (TableConfiguration)this.tableConfigurations.get(i);
/*     */ 
/* 165 */         tc.validate(errors, i);
/*     */       }
/*     */     }
/*     */ 
/* 169 */     for (PluginConfiguration pluginConfiguration : this.pluginConfigurations)
/* 170 */       pluginConfiguration.validate(errors, this.id);
/*     */   }
/*     */ 
/*     */   public String getId()
/*     */   {
/* 175 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/* 179 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public void setJavaClientGeneratorConfiguration(JavaClientGeneratorConfiguration javaClientGeneratorConfiguration)
/*     */   {
/* 184 */     this.javaClientGeneratorConfiguration = javaClientGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public void setJavaModelGeneratorConfiguration(JavaModelGeneratorConfiguration javaModelGeneratorConfiguration)
/*     */   {
/* 189 */     this.javaModelGeneratorConfiguration = javaModelGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public void setJavaTypeResolverConfiguration(JavaTypeResolverConfiguration javaTypeResolverConfiguration)
/*     */   {
/* 194 */     this.javaTypeResolverConfiguration = javaTypeResolverConfiguration;
/*     */   }
/*     */ 
/*     */   public void setJdbcConnectionConfiguration(JDBCConnectionConfiguration jdbcConnectionConfiguration)
/*     */   {
/* 199 */     this.jdbcConnectionConfiguration = jdbcConnectionConfiguration;
/*     */   }
/*     */ 
/*     */   public void setSqlMapGeneratorConfiguration(SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration)
/*     */   {
/* 204 */     this.sqlMapGeneratorConfiguration = sqlMapGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public ModelType getDefaultModelType() {
/* 208 */     return this.defaultModelType;
/*     */   }
/*     */ 
/*     */   public XmlElement toXmlElement()
/*     */   {
/* 219 */     XmlElement xmlElement = new XmlElement("context");
/*     */ 
/* 221 */     if (this.defaultModelType != ModelType.CONDITIONAL) {
/* 222 */       xmlElement.addAttribute(new Attribute("defaultModelType", this.defaultModelType.getModelType()));
/*     */     }
/*     */ 
/* 226 */     if (StringUtility.stringHasValue(this.introspectedColumnImpl)) {
/* 227 */       xmlElement.addAttribute(new Attribute("introspectedColumnImpl", this.introspectedColumnImpl));
/*     */     }
/*     */ 
/* 231 */     if (StringUtility.stringHasValue(this.targetRuntime)) {
/* 232 */       xmlElement.addAttribute(new Attribute("targetRuntime", this.targetRuntime));
/*     */     }
/*     */ 
/* 236 */     addPropertyXmlElements(xmlElement);
/*     */ 
/* 238 */     if (this.commentGeneratorConfiguration != null) {
/* 239 */       xmlElement.addElement(this.commentGeneratorConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 242 */     if (this.jdbcConnectionConfiguration != null) {
/* 243 */       xmlElement.addElement(this.jdbcConnectionConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 246 */     if (this.javaTypeResolverConfiguration != null) {
/* 247 */       xmlElement.addElement(this.javaTypeResolverConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 250 */     if (this.javaModelGeneratorConfiguration != null) {
/* 251 */       xmlElement.addElement(this.javaModelGeneratorConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 255 */     if (this.sqlMapGeneratorConfiguration != null) {
/* 256 */       xmlElement.addElement(this.sqlMapGeneratorConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 259 */     if (this.javaClientGeneratorConfiguration != null) {
/* 260 */       xmlElement.addElement(this.javaClientGeneratorConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 263 */     for (TableConfiguration tableConfiguration : this.tableConfigurations) {
/* 264 */       xmlElement.addElement(tableConfiguration.toXmlElement());
/*     */     }
/*     */ 
/* 267 */     return xmlElement;
/*     */   }
/*     */ 
/*     */   public List<TableConfiguration> getTableConfigurations() {
/* 271 */     return this.tableConfigurations;
/*     */   }
/*     */ 
/*     */   public String getBeginningDelimiter() {
/* 275 */     return this.beginningDelimiter;
/*     */   }
/*     */ 
/*     */   public String getEndingDelimiter() {
/* 279 */     return this.endingDelimiter;
/*     */   }
/*     */ 
/*     */   public void addProperty(String name, String value)
/*     */   {
/* 284 */     super.addProperty(name, value);
/*     */ 
/* 286 */     if ("beginningDelimiter".equals(name))
/* 287 */       this.beginningDelimiter = value;
/* 288 */     else if ("endingDelimiter".equals(name))
/* 289 */       this.endingDelimiter = value;
/* 290 */     else if (("autoDelimitKeywords".equals(name)) && 
/* 291 */       (StringUtility.stringHasValue(value)))
/* 292 */       this.autoDelimitKeywords = new Boolean(StringUtility.isTrue(value));
/*     */   }
/*     */ 
/*     */   public CommentGenerator getCommentGenerator()
/*     */   {
/* 298 */     if (this.commentGenerator == null) {
/* 299 */       this.commentGenerator = ObjectFactory.createCommentGenerator(this);
/*     */     }
/*     */ 
/* 302 */     return this.commentGenerator;
/*     */   }
/*     */ 
/*     */   public CommentGeneratorConfiguration getCommentGeneratorConfiguration() {
/* 306 */     return this.commentGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public void setCommentGeneratorConfiguration(CommentGeneratorConfiguration commentGeneratorConfiguration)
/*     */   {
/* 311 */     this.commentGeneratorConfiguration = commentGeneratorConfiguration;
/*     */   }
/*     */ 
/*     */   public Plugin getPlugins() {
/* 315 */     return this.pluginAggregator;
/*     */   }
/*     */ 
/*     */   public String getTargetRuntime() {
/* 319 */     return this.targetRuntime;
/*     */   }
/*     */ 
/*     */   public void setTargetRuntime(String targetRuntime) {
/* 323 */     this.targetRuntime = targetRuntime;
/*     */   }
/*     */ 
/*     */   public String getIntrospectedColumnImpl() {
/* 327 */     return this.introspectedColumnImpl;
/*     */   }
/*     */ 
/*     */   public void setIntrospectedColumnImpl(String introspectedColumnImpl) {
/* 331 */     this.introspectedColumnImpl = introspectedColumnImpl;
/*     */   }
/*     */ 
/*     */   public int getIntrospectionSteps()
/*     */   {
/* 347 */     int steps = 0;
/*     */ 
/* 349 */     steps++;
/*     */ 
/* 355 */     steps += this.tableConfigurations.size() * 1;
/*     */ 
/* 357 */     return steps;
/*     */   }
/*     */ 
/*     */   public void introspectTables(ProgressCallback callback, List<String> warnings, Set<String> fullyQualifiedTableNames)
/*     */     throws SQLException, InterruptedException
/*     */   {
/* 388 */     this.introspectedTables = new ArrayList();
/* 389 */     JavaTypeResolver javaTypeResolver = ObjectFactory.createJavaTypeResolver(this, warnings);
/*     */ 
/* 392 */     Connection connection = null;
/*     */     try
/*     */     {
/* 395 */       callback.startTask(Messages.getString("Progress.0"));
/* 396 */       connection = getConnection();
/*     */ 
/* 398 */       DatabaseIntrospector databaseIntrospector = new DatabaseIntrospector(this, connection.getMetaData(), javaTypeResolver, warnings);
/*     */ 
/* 401 */       for (TableConfiguration tc : this.tableConfigurations) {
/* 402 */         String tableName = StringUtility.composeFullyQualifiedTableName(tc.getCatalog(), tc.getSchema(), tc.getTableName(), '.');
/*     */ 
/* 406 */         if ((fullyQualifiedTableNames != null) && (fullyQualifiedTableNames.size() > 0) && 
/* 408 */           (!fullyQualifiedTableNames.contains(tableName)))
/*     */         {
/*     */           continue;
/*     */         }
/*     */ 
/* 413 */         if (!tc.areAnyStatementsEnabled()) {
/* 414 */           warnings.add(Messages.getString("Warning.0", tableName));
/* 415 */           continue;
/*     */         }
/*     */ 
/* 418 */         callback.startTask(Messages.getString("Progress.1", tableName));
/* 419 */         List tables = databaseIntrospector.introspectTables(tc);
/*     */ 
/* 422 */         if (tables != null) {
/* 423 */           this.introspectedTables.addAll(tables);
/*     */         }
/*     */ 
/* 426 */         callback.checkCancel();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       DatabaseIntrospector databaseIntrospector;
/* 429 */       closeConnection(connection);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getGenerationSteps() {
/* 434 */     int steps = 0;
/*     */ 
/* 436 */     if (this.introspectedTables != null) {
/* 437 */       for (IntrospectedTable introspectedTable : this.introspectedTables) {
/* 438 */         steps += introspectedTable.getGenerationSteps();
/*     */       }
/*     */     }
/*     */ 
/* 442 */     return steps;
/*     */   }
/*     */ 
/*     */   public void generateFiles(ProgressCallback callback, List<GeneratedJavaFile> generatedJavaFiles, List<GeneratedXmlFile> generatedXmlFiles, List<String> warnings)
/*     */     throws InterruptedException
/*     */   {
/* 450 */     this.pluginAggregator = new PluginAggregator();
/* 451 */     for (PluginConfiguration pluginConfiguration : this.pluginConfigurations) {
/* 452 */       Plugin plugin = ObjectFactory.createPlugin(this, pluginConfiguration);
/*     */ 
/* 454 */       if (plugin.validate(warnings))
/* 455 */         this.pluginAggregator.addPlugin(plugin);
/*     */       else {
/* 457 */         warnings.add(Messages.getString("Warning.24", pluginConfiguration.getConfigurationType(), this.id));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 462 */     if (this.introspectedTables != null) {
/* 463 */       for (IntrospectedTable introspectedTable : this.introspectedTables) {
/* 464 */         callback.checkCancel();
/*     */ 
/* 466 */         introspectedTable.initialize();
/* 467 */         introspectedTable.calculateGenerators(warnings, callback);
/* 468 */         generatedJavaFiles.addAll(introspectedTable.getGeneratedJavaFiles());
/*     */ 
/* 470 */         generatedXmlFiles.addAll(introspectedTable.getGeneratedXmlFiles());
/*     */ 
/* 473 */         generatedJavaFiles.addAll(this.pluginAggregator.contextGenerateAdditionalJavaFiles(introspectedTable));
/*     */ 
/* 475 */         generatedXmlFiles.addAll(this.pluginAggregator.contextGenerateAdditionalXmlFiles(introspectedTable));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 480 */     generatedJavaFiles.addAll(this.pluginAggregator.contextGenerateAdditionalJavaFiles());
/*     */ 
/* 482 */     generatedXmlFiles.addAll(this.pluginAggregator.contextGenerateAdditionalXmlFiles());
/*     */   }
/*     */ 
/*     */   private Connection getConnection() throws SQLException
/*     */   {
/* 487 */     Connection connection = ConnectionFactory.getInstance().getConnection(this.jdbcConnectionConfiguration);
/*     */ 
/* 490 */     return connection;
/*     */   }
/*     */ 
/*     */   private void closeConnection(Connection connection) {
/* 494 */     if (connection != null)
/*     */       try {
/* 496 */         connection.close();
/*     */       }
/*     */       catch (SQLException e)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   public boolean autoDelimitKeywords()
/*     */   {
/* 505 */     return (this.autoDelimitKeywords != null) && (this.autoDelimitKeywords.booleanValue());
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.Context
 * JD-Core Version:    0.6.0
 */