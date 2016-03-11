 package org.mybatis.generator.api;
 
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;
 import org.mybatis.generator.config.Configuration;
 import org.mybatis.generator.config.Context;
 import org.mybatis.generator.config.MergeConstants;
 import org.mybatis.generator.exception.InvalidConfigurationException;
 import org.mybatis.generator.exception.ShellException;
 import org.mybatis.generator.internal.DefaultShellCallback;
 import org.mybatis.generator.internal.NullProgressCallback;
 import org.mybatis.generator.internal.ObjectFactory;
 import org.mybatis.generator.internal.XmlFileMergerJaxp;
 import org.mybatis.generator.internal.util.ClassloaderUtility;
 import org.mybatis.generator.internal.util.messages.Messages;
 
 public class MyBatisGenerator
 {
   private Configuration configuration;
   private ShellCallback shellCallback;
   private List<GeneratedJavaFile> generatedJavaFiles;
   private List<GeneratedXmlFile> generatedXmlFiles;
   private List<String> warnings;
   private Set<String> projects;
 
   public MyBatisGenerator(Configuration configuration, ShellCallback shellCallback, List<String> warnings)
     throws InvalidConfigurationException
   {
     if (configuration == null) {
       throw new IllegalArgumentException(Messages.getString("RuntimeError.2"));
     }
 
     this.configuration = configuration;
 
     if (shellCallback == null)
       this.shellCallback = new DefaultShellCallback(false);
     else {
       this.shellCallback = shellCallback;
     }
 
     if (warnings == null)
       this.warnings = new ArrayList();
     else {
       this.warnings = warnings;
     }
     this.generatedJavaFiles = new ArrayList();
     this.generatedXmlFiles = new ArrayList();
     this.projects = new HashSet();
 
     this.configuration.validate();
   }
 
   public void generate(ProgressCallback callback)
     throws SQLException, IOException, InterruptedException
   {
     generate(callback, null, null);
   }
 
   public void generate(ProgressCallback callback, Set<String> contextIds)
     throws SQLException, IOException, InterruptedException
   {
     generate(callback, contextIds, null);
   }
 
   public void generate(ProgressCallback callback, Set<String> contextIds, Set<String> fullyQualifiedTableNames)
     throws SQLException, IOException, InterruptedException
   {
     if (callback == null) {
       callback = new NullProgressCallback();
     }
 
     this.generatedJavaFiles.clear();
     this.generatedXmlFiles.clear();
     List<Context> contextsToRun;
     if ((contextIds == null) || (contextIds.size() == 0)) {
       contextsToRun = this.configuration.getContexts();
     } else {
       contextsToRun = new ArrayList();
       for (Context context : this.configuration.getContexts()) {
         if (contextIds.contains(context.getId())) {
           contextsToRun.add(context);
         }
       }
 
     }
 
     if (this.configuration.getClassPathEntries().size() > 0) {
       ClassLoader classLoader = ClassloaderUtility.getCustomClassloader(this.configuration.getClassPathEntries());
 
       ObjectFactory.setExternalClassLoader(classLoader);
     }
 
     int totalSteps = 0;
     for (Context context : contextsToRun) {
       totalSteps += context.getIntrospectionSteps();
     }
     callback.introspectionStarted(totalSteps);
 
     for (Context context : contextsToRun) {
       context.introspectTables(callback, this.warnings, fullyQualifiedTableNames);
     }
 
     totalSteps = 0;
     for (Context context : contextsToRun) {
       totalSteps += context.getGenerationSteps();
     }
     callback.generationStarted(totalSteps);
 
     for (Context context : contextsToRun) {
       context.generateFiles(callback, this.generatedJavaFiles, this.generatedXmlFiles, this.warnings);
     }
 
     callback.saveStarted(this.generatedXmlFiles.size() + this.generatedJavaFiles.size());
 
     for (GeneratedXmlFile gxf : this.generatedXmlFiles) { 
				this.projects.add(gxf.getTargetProject());
       File targetFile;
       String source;
       try { 
    	   
    	 File directory = this.shellCallback.getDirectory(gxf.getTargetProject(), gxf.getTargetPackage());
         targetFile = new File(directory, gxf.getFileName());
         if (targetFile.exists())
         {
           if (gxf.isMergeable()) {
             source = XmlFileMergerJaxp.getMergedSource(gxf, targetFile);
           }
           else if (this.shellCallback.isOverwriteEnabled()) {
             source = gxf.getFormattedContent();
             this.warnings.add(Messages.getString("Warning.11", targetFile.getAbsolutePath()));
           }
           else {
             source = gxf.getFormattedContent();
             targetFile = getUniqueFileName(directory, gxf.getFileName());
 
             this.warnings.add(Messages.getString("Warning.2", targetFile.getAbsolutePath()));
           }
         }
         else {
           source = gxf.getFormattedContent();
         }
       } catch (ShellException e) {
         this.warnings.add(e.getMessage());
         continue;
       }
 
	   callback.checkCancel();
       callback.startTask(Messages.getString("Progress.15", targetFile.getName()));
 
       writeFile(targetFile, source);
     }
 
     for (GeneratedJavaFile gjf : this.generatedJavaFiles) {
       this.projects.add(gjf.getTargetProject());
       try
       {
         File directory = this.shellCallback.getDirectory(gjf.getTargetProject(), gjf.getTargetPackage());
 
         File targetFile = new File(directory, gjf.getFileName());
         String source;
         if (targetFile.exists())
         {
           if (this.shellCallback.isMergeSupported()) {
             source = this.shellCallback.mergeJavaFile(gjf.getFormattedContent(), targetFile.getAbsolutePath(), MergeConstants.OLD_ELEMENT_TAGS);
           }
           else if (this.shellCallback.isOverwriteEnabled()) {
             source = gjf.getFormattedContent();
             this.warnings.add(Messages.getString("Warning.11", targetFile.getAbsolutePath()));
           }
           else {
             source = gjf.getFormattedContent();
             targetFile = getUniqueFileName(directory, gjf.getFileName());
 
             this.warnings.add(Messages.getString("Warning.2", targetFile.getAbsolutePath()));
           }
         }
         else {
           source = gjf.getFormattedContent();
         }
 
         callback.checkCancel();
         callback.startTask(Messages.getString("Progress.15", targetFile.getName()));
 
         writeFile(targetFile, source);
       } catch (ShellException e) {
         this.warnings.add(e.getMessage());
       }
     }
 
     for (String project : this.projects) {
       this.shellCallback.refreshProject(project);
     }
 
     callback.done();
   }
 
   private void writeFile(File file, String content)
     throws IOException
   {
     BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
     bw.write(content);
     bw.close();
   }
 
   private File getUniqueFileName(File directory, String fileName) {
     File answer = null;
 
     StringBuilder sb = new StringBuilder();
     for (int i = 1; i < 1000; i++) {
       sb.setLength(0);
       sb.append(fileName);
       sb.append('.');
       sb.append(i);
 
       File testFile = new File(directory, sb.toString());
       if (!testFile.exists()) {
         answer = testFile;
         break;
       }
     }
 
     if (answer == null) {
       throw new RuntimeException(Messages.getString("RuntimeError.3", directory.getAbsolutePath()));
     }
 
     return answer;
   }
 }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.MyBatisGenerator
 * JD-Core Version:    0.6.0
 */