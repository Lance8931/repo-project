/*     */ package org.mybatis.generator.api;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.MergeConstants;
/*     */ import org.mybatis.generator.exception.InvalidConfigurationException;
/*     */ import org.mybatis.generator.exception.ShellException;
/*     */ import org.mybatis.generator.internal.DefaultShellCallback;
/*     */ import org.mybatis.generator.internal.NullProgressCallback;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.XmlFileMergerJaxp;
/*     */ import org.mybatis.generator.internal.util.ClassloaderUtility;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ 
/*     */ public class MyBatisGenerator
/*     */ {
/*     */   private Configuration configuration;
/*     */   private ShellCallback shellCallback;
/*     */   private List<GeneratedJavaFile> generatedJavaFiles;
/*     */   private List<GeneratedXmlFile> generatedXmlFiles;
/*     */   private List<String> warnings;
/*     */   private Set<String> projects;
/*     */ 
/*     */   public MyBatisGenerator(Configuration configuration, ShellCallback shellCallback, List<String> warnings)
/*     */     throws InvalidConfigurationException
/*     */   {
/*  91 */     if (configuration == null) {
/*  92 */       throw new IllegalArgumentException(Messages.getString("RuntimeError.2"));
/*     */     }
/*     */ 
/*  95 */     this.configuration = configuration;
/*     */ 
/*  98 */     if (shellCallback == null)
/*  99 */       this.shellCallback = new DefaultShellCallback(false);
/*     */     else {
/* 101 */       this.shellCallback = shellCallback;
/*     */     }
/*     */ 
/* 104 */     if (warnings == null)
/* 105 */       this.warnings = new ArrayList();
/*     */     else {
/* 107 */       this.warnings = warnings;
/*     */     }
/* 109 */     this.generatedJavaFiles = new ArrayList();
/* 110 */     this.generatedXmlFiles = new ArrayList();
/* 111 */     this.projects = new HashSet();
/*     */ 
/* 113 */     this.configuration.validate();
/*     */   }
/*     */ 
/*     */   public void generate(ProgressCallback callback)
/*     */     throws SQLException, IOException, InterruptedException
/*     */   {
/* 132 */     generate(callback, null, null);
/*     */   }
/*     */ 
/*     */   public void generate(ProgressCallback callback, Set<String> contextIds)
/*     */     throws SQLException, IOException, InterruptedException
/*     */   {
/* 155 */     generate(callback, contextIds, null);
/*     */   }
/*     */ 
/*     */   public void generate(ProgressCallback callback, Set<String> contextIds, Set<String> fullyQualifiedTableNames)
/*     */     throws SQLException, IOException, InterruptedException
/*     */   {
/* 187 */     if (callback == null) {
/* 188 */       callback = new NullProgressCallback();
/*     */     }
/*     */ 
/* 191 */     this.generatedJavaFiles.clear();
/* 192 */     this.generatedXmlFiles.clear();
/*     */     List<Context> contextsToRun;
/* 196 */     if ((contextIds == null) || (contextIds.size() == 0)) {
/* 197 */       contextsToRun = this.configuration.getContexts();
/*     */     } else {
/* 199 */       contextsToRun = new ArrayList();
/* 200 */       for (Context context : this.configuration.getContexts()) {
/* 201 */         if (contextIds.contains(context.getId())) {
/* 202 */           contextsToRun.add(context);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 208 */     if (this.configuration.getClassPathEntries().size() > 0) {
/* 209 */       ClassLoader classLoader = ClassloaderUtility.getCustomClassloader(this.configuration.getClassPathEntries());
/*     */ 
/* 211 */       ObjectFactory.setExternalClassLoader(classLoader);
/*     */     }
/*     */ 
/* 215 */     int totalSteps = 0;
/* 216 */     for (Context context : contextsToRun) {
/* 217 */       totalSteps += context.getIntrospectionSteps();
/*     */     }
/* 219 */     callback.introspectionStarted(totalSteps);
/*     */ 
/* 221 */     for (Context context : contextsToRun) {
/* 222 */       context.introspectTables(callback, this.warnings, fullyQualifiedTableNames);
/*     */     }
/*     */ 
/* 227 */     totalSteps = 0;
/* 228 */     for (Context context : contextsToRun) {
/* 229 */       totalSteps += context.getGenerationSteps();
/*     */     }
/* 231 */     callback.generationStarted(totalSteps);
/*     */ 
/* 233 */     for (Context context : contextsToRun) {
/* 234 */       context.generateFiles(callback, this.generatedJavaFiles, this.generatedXmlFiles, this.warnings);
/*     */     }
/*     */ 
/* 239 */     callback.saveStarted(this.generatedXmlFiles.size() + this.generatedJavaFiles.size());
/*     */ 
/* 242 */     for (GeneratedXmlFile gxf : this.generatedXmlFiles) { 
				this.projects.add(gxf.getTargetProject());
/*     */       File targetFile;
/*     */       String source;
/*     */       try { File directory = this.shellCallback.getDirectory(gxf.getTargetProject(), gxf.getTargetPackage());
/*     */ 
/* 250 */         targetFile = new File(directory, gxf.getFileName());
/* 251 */         if (targetFile.exists())
/*     */         {
/* 252 */           if (gxf.isMergeable()) {
/* 253 */             source = XmlFileMergerJaxp.getMergedSource(gxf, targetFile);
/*     */           }
/* 255 */           else if (this.shellCallback.isOverwriteEnabled()) {
/* 256 */             source = gxf.getFormattedContent();
/* 257 */             this.warnings.add(Messages.getString("Warning.11", targetFile.getAbsolutePath()));
/*     */           }
/*     */           else {
/* 260 */             source = gxf.getFormattedContent();
/* 261 */             targetFile = getUniqueFileName(directory, gxf.getFileName());
/*     */ 
/* 263 */             this.warnings.add(Messages.getString("Warning.2", targetFile.getAbsolutePath()));
/*     */           }
/*     */         }
/*     */         else {
/* 267 */           source = gxf.getFormattedContent();
/*     */         }
/*     */       } catch (ShellException e) {
/* 270 */         this.warnings.add(e.getMessage());
/* 271 */       }continue;
/*     */ 
				callback.checkCancel();
/* 275 */       callback.startTask(Messages.getString("Progress.15", targetFile.getName()));
/*     */ 
/* 277 */       writeFile(targetFile, source);
/*     */     }
/*     */ 
/* 280 */     for (GeneratedJavaFile gjf : this.generatedJavaFiles) {
/* 281 */       this.projects.add(gjf.getTargetProject());
/*     */       try
/*     */       {
/* 286 */         File directory = this.shellCallback.getDirectory(gjf.getTargetProject(), gjf.getTargetPackage());
/*     */ 
/* 288 */         File targetFile = new File(directory, gjf.getFileName());
/*     */         String source;
/* 289 */         if (targetFile.exists())
/*     */         {
/* 290 */           if (this.shellCallback.isMergeSupported()) {
/* 291 */             source = this.shellCallback.mergeJavaFile(gjf.getFormattedContent(), targetFile.getAbsolutePath(), MergeConstants.OLD_ELEMENT_TAGS);
/*     */           }
/* 295 */           else if (this.shellCallback.isOverwriteEnabled()) {
/* 296 */             source = gjf.getFormattedContent();
/* 297 */             this.warnings.add(Messages.getString("Warning.11", targetFile.getAbsolutePath()));
/*     */           }
/*     */           else {
/* 300 */             source = gjf.getFormattedContent();
/* 301 */             targetFile = getUniqueFileName(directory, gjf.getFileName());
/*     */ 
/* 303 */             this.warnings.add(Messages.getString("Warning.2", targetFile.getAbsolutePath()));
/*     */           }
/*     */         }
/*     */         else {
/* 307 */           source = gjf.getFormattedContent();
/*     */         }
/*     */ 
/* 310 */         callback.checkCancel();
/* 311 */         callback.startTask(Messages.getString("Progress.15", targetFile.getName()));
/*     */ 
/* 313 */         writeFile(targetFile, source);
/*     */       } catch (ShellException e) {
/* 315 */         this.warnings.add(e.getMessage());
/*     */       }
/*     */     }
/*     */ 
/* 319 */     for (String project : this.projects) {
/* 320 */       this.shellCallback.refreshProject(project);
/*     */     }
/*     */ 
/* 323 */     callback.done();
/*     */   }
/*     */ 
/*     */   private void writeFile(File file, String content)
/*     */     throws IOException
/*     */   {
/* 333 */     BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
/* 334 */     bw.write(content);
/* 335 */     bw.close();
/*     */   }
/*     */ 
/*     */   private File getUniqueFileName(File directory, String fileName) {
/* 339 */     File answer = null;
/*     */ 
/* 342 */     StringBuilder sb = new StringBuilder();
/* 343 */     for (int i = 1; i < 1000; i++) {
/* 344 */       sb.setLength(0);
/* 345 */       sb.append(fileName);
/* 346 */       sb.append('.');
/* 347 */       sb.append(i);
/*     */ 
/* 349 */       File testFile = new File(directory, sb.toString());
/* 350 */       if (!testFile.exists()) {
/* 351 */         answer = testFile;
/* 352 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 356 */     if (answer == null) {
/* 357 */       throw new RuntimeException(Messages.getString("RuntimeError.3", directory.getAbsolutePath()));
/*     */     }
/*     */ 
/* 361 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.MyBatisGenerator
 * JD-Core Version:    0.6.0
 */