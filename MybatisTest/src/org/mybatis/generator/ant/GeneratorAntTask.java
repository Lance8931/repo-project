/*     */ package org.mybatis.generator.ant;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.tools.ant.BuildException;
/*     */ import org.apache.tools.ant.Task;
/*     */ import org.apache.tools.ant.types.PropertySet;
/*     */ import org.mybatis.generator.api.MyBatisGenerator;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.xml.ConfigurationParser;
/*     */ import org.mybatis.generator.exception.InvalidConfigurationException;
/*     */ import org.mybatis.generator.exception.XMLParserException;
/*     */ import org.mybatis.generator.internal.DefaultShellCallback;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class GeneratorAntTask extends Task
/*     */ {
/*     */   private String configfile;
/*     */   private boolean overwrite;
/*     */   private PropertySet propertyset;
/*     */   private boolean verbose;
/*     */   private String contextIds;
/*     */   private String fullyQualifiedTableNames;
/*     */ 
/*     */   public void execute()
/*     */     throws BuildException
/*     */   {
/* 102 */     if (!StringUtility.stringHasValue(this.configfile)) {
/* 103 */       throw new BuildException(Messages.getString("RuntimeError.0"));
/*     */     }
/*     */ 
/* 106 */     List<String> warnings = new ArrayList();
/*     */ 
/* 108 */     File configurationFile = new File(this.configfile);
/* 109 */     if (!configurationFile.exists()) {
/* 110 */       throw new BuildException(Messages.getString("RuntimeError.1", this.configfile));
/*     */     }
/*     */ 
/* 114 */     Set fullyqualifiedTables = new HashSet();
/* 115 */     if (StringUtility.stringHasValue(this.fullyQualifiedTableNames)) {
/* 116 */       StringTokenizer st = new StringTokenizer(this.fullyQualifiedTableNames, ",");
/*     */ 
/* 118 */       while (st.hasMoreTokens()) {
/* 119 */         String s = st.nextToken().trim();
/* 120 */         if (s.length() > 0) {
/* 121 */           fullyqualifiedTables.add(s);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 126 */     Set contexts = new HashSet();
/* 127 */     if (StringUtility.stringHasValue(this.contextIds)) {
/* 128 */       StringTokenizer st = new StringTokenizer(this.contextIds, ",");
/* 129 */       while (st.hasMoreTokens()) {
/* 130 */         String s = st.nextToken().trim();
/* 131 */         if (s.length() > 0) {
/* 132 */           contexts.add(s);
/*     */         }
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 138 */       Properties p = this.propertyset == null ? null : this.propertyset.getProperties();
/*     */ 
/* 141 */       ConfigurationParser cp = new ConfigurationParser(p, warnings);
/* 142 */       Configuration config = cp.parseConfiguration(configurationFile);
/*     */ 
/* 144 */       DefaultShellCallback callback = new DefaultShellCallback(this.overwrite);
/*     */ 
/* 146 */       MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
/*     */ 
/* 148 */       myBatisGenerator.generate(new AntProgressCallback(this, this.verbose), contexts, fullyqualifiedTables);
/*     */     }
/*     */     catch (XMLParserException e)
/*     */     {
/* 152 */       for (String error : e.getErrors()) {
/* 153 */         log(error, 0);
/*     */       }
/*     */ 
/* 156 */       throw new BuildException(e.getMessage());
/*     */     } catch (SQLException e) {
/* 158 */       throw new BuildException(e.getMessage());
/*     */     } catch (IOException e) {
/* 160 */       throw new BuildException(e.getMessage());
/*     */     } catch (InvalidConfigurationException e) {
/* 162 */       for (String error : e.getErrors()) {
/* 163 */         log(error, 0);
/*     */       }
/*     */ 
/* 166 */       throw new BuildException(e.getMessage());
/*     */     }
/*     */     catch (InterruptedException e) {
/*     */     }
/*     */     catch (Exception e) {
/* 171 */       e.printStackTrace();
/* 172 */       throw new BuildException(e.getMessage());
/*     */     }
/*     */ 
/* 175 */     for (String error : warnings)
/* 176 */       log(error, 1);
/*     */   }
/*     */ 
/*     */   public String getConfigfile()
/*     */   {
/* 184 */     return this.configfile;
/*     */   }
/*     */ 
/*     */   public void setConfigfile(String configfile)
/*     */   {
/* 192 */     this.configfile = configfile;
/*     */   }
/*     */ 
/*     */   public boolean isOverwrite()
/*     */   {
/* 199 */     return this.overwrite;
/*     */   }
/*     */ 
/*     */   public void setOverwrite(boolean overwrite)
/*     */   {
/* 207 */     this.overwrite = overwrite;
/*     */   }
/*     */ 
/*     */   public PropertySet createPropertyset() {
/* 211 */     if (this.propertyset == null) {
/* 212 */       this.propertyset = new PropertySet();
/*     */     }
/*     */ 
/* 215 */     return this.propertyset;
/*     */   }
/*     */ 
/*     */   public boolean isVerbose() {
/* 219 */     return this.verbose;
/*     */   }
/*     */ 
/*     */   public void setVerbose(boolean verbose) {
/* 223 */     this.verbose = verbose;
/*     */   }
/*     */ 
/*     */   public String getContextIds() {
/* 227 */     return this.contextIds;
/*     */   }
/*     */ 
/*     */   public void setContextIds(String contextIds) {
/* 231 */     this.contextIds = contextIds;
/*     */   }
/*     */ 
/*     */   public String getFullyQualifiedTableNames() {
/* 235 */     return this.fullyQualifiedTableNames;
/*     */   }
/*     */ 
/*     */   public void setFullyQualifiedTableNames(String fullyQualifiedTableNames) {
/* 239 */     this.fullyQualifiedTableNames = fullyQualifiedTableNames;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.ant.GeneratorAntTask
 * JD-Core Version:    0.6.0
 */