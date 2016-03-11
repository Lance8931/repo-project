/*    */ package org.mybatis.generator.internal.util.messages;
/*    */ 
/*    */ import java.text.MessageFormat;
/*    */ import java.util.MissingResourceException;
/*    */ import java.util.ResourceBundle;
/*    */ 
/*    */ public class Messages
/*    */ {
/*    */   private static final String BUNDLE_NAME = "org.mybatis.generator.internal.util.messages.messages";
/* 28 */   private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("org.mybatis.generator.internal.util.messages.messages");
/*    */ 
/*    */   public static String getString(String key)
/*    */   {
/*    */     try
/*    */     {
/* 36 */       return RESOURCE_BUNDLE.getString(key); } catch (MissingResourceException e) {
/*    */     }
/* 38 */     return '!' + key + '!';
/*    */   }
/*    */ 
/*    */   public static String getString(String key, String parm1)
/*    */   {
/*    */     try {
/* 44 */       return MessageFormat.format(RESOURCE_BUNDLE.getString(key), new Object[] { parm1 });
/*    */     } catch (MissingResourceException e) {
/*    */     }
/* 47 */     return '!' + key + '!';
/*    */   }
/*    */ 
/*    */   public static String getString(String key, String parm1, String parm2)
/*    */   {
/*    */     try {
/* 53 */       return MessageFormat.format(RESOURCE_BUNDLE.getString(key), new Object[] { parm1, parm2 });
/*    */     } catch (MissingResourceException e) {
/*    */     }
/* 56 */     return '!' + key + '!';
/*    */   }
/*    */ 
/*    */   public static String getString(String key, String parm1, String parm2, String parm3)
/*    */   {
/*    */     try
/*    */     {
/* 63 */       return MessageFormat.format(RESOURCE_BUNDLE.getString(key), new Object[] { parm1, parm2, parm3 });
/*    */     } catch (MissingResourceException e) {
/*    */     }
/* 66 */     return '!' + key + '!';
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.util.messages.Messages
 * JD-Core Version:    0.6.0
 */