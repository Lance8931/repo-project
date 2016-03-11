/*    */ package org.mybatis.generator.internal.util;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URI;
/*    */ import java.net.URL;
/*    */ import java.net.URLClassLoader;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class ClassloaderUtility
/*    */ {
/*    */   public static ClassLoader getCustomClassloader(List<String> entries)
/*    */   {
/* 43 */     List urls = new ArrayList();
/*    */ 
/* 46 */     if (entries != null) {
/* 47 */       for (String classPathEntry : entries) {
/* 48 */         File file = new File(classPathEntry);
/* 49 */         if (!file.exists()) {
/* 50 */           throw new RuntimeException(Messages.getString("RuntimeError.9", classPathEntry));
/*    */         }
/*    */ 
/*    */         try
/*    */         {
/* 55 */           urls.add(file.toURI().toURL());
/*    */         }
/*    */         catch (MalformedURLException e) {
/* 58 */           throw new RuntimeException(Messages.getString("RuntimeError.9", classPathEntry));
/*    */         }
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 64 */     ClassLoader parent = Thread.currentThread().getContextClassLoader();
/*    */ 
/* 66 */     URLClassLoader ucl = new URLClassLoader((URL[])urls.toArray(new URL[urls.size()]), parent);
/*    */ 
/* 69 */     return ucl;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.util.ClassloaderUtility
 * JD-Core Version:    0.6.0
 */