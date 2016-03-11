/*    */ package org.mybatis.generator.internal;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.StringTokenizer;
/*    */ import org.mybatis.generator.api.ShellCallback;
/*    */ import org.mybatis.generator.exception.ShellException;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class DefaultShellCallback
/*    */   implements ShellCallback
/*    */ {
/*    */   private boolean overwrite;
/*    */ 
/*    */   public DefaultShellCallback(boolean overwrite)
/*    */   {
/* 36 */     this.overwrite = overwrite;
/*    */   }
/*    */ 
/*    */   public File getDirectory(String targetProject, String targetPackage)
/*    */     throws ShellException
/*    */   {
/* 48 */     File project = new File(targetProject);
/* 49 */     if (!project.isDirectory()) {
/* 50 */       throw new ShellException(Messages.getString("Warning.9", targetProject));
/*    */     }
/*    */ 
/* 54 */     StringBuilder sb = new StringBuilder();
/* 55 */     StringTokenizer st = new StringTokenizer(targetPackage, ".");
/* 56 */     while (st.hasMoreTokens()) {
/* 57 */       sb.append(st.nextToken());
/* 58 */       sb.append(File.separatorChar);
/*    */     }
/*    */ 
/* 61 */     File directory = new File(project, sb.toString());
/* 62 */     if (!directory.isDirectory()) {
/* 63 */       boolean rc = directory.mkdirs();
/* 64 */       if (!rc) {
/* 65 */         throw new ShellException(Messages.getString("Warning.10", directory.getAbsolutePath()));
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 70 */     return directory;
/*    */   }
/*    */ 
/*    */   public void refreshProject(String project)
/*    */   {
/*    */   }
/*    */ 
/*    */   public boolean isMergeSupported() {
/* 78 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean isOverwriteEnabled() {
/* 82 */     return this.overwrite;
/*    */   }
/*    */ 
/*    */   public String mergeJavaFile(String newFileSource, String existingFileFullPath, String[] javadocTags)
/*    */     throws ShellException
/*    */   {
/* 88 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.DefaultShellCallback
 * JD-Core Version:    0.6.0
 */