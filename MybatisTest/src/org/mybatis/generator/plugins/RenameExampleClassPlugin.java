/*    */ package org.mybatis.generator.plugins;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Properties;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.PluginAdapter;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class RenameExampleClassPlugin extends PluginAdapter
/*    */ {
/*    */   private String searchString;
/*    */   private String replaceString;
/*    */   private Pattern pattern;
/*    */ 
/*    */   public boolean validate(List<String> warnings)
/*    */   {
/* 67 */     this.searchString = this.properties.getProperty("searchString");
/* 68 */     this.replaceString = this.properties.getProperty("replaceString");
/*    */ 
/* 70 */     boolean valid = (StringUtility.stringHasValue(this.searchString)) && (StringUtility.stringHasValue(this.replaceString));
/*    */ 
/* 73 */     if (valid) {
/* 74 */       this.pattern = Pattern.compile(this.searchString);
/*    */     } else {
/* 76 */       if (!StringUtility.stringHasValue(this.searchString)) {
/* 77 */         warnings.add(Messages.getString("ValidationError.18", "RenameExampleClassPlugin", "searchString"));
/*    */       }
/*    */ 
/* 81 */       if (!StringUtility.stringHasValue(this.replaceString)) {
/* 82 */         warnings.add(Messages.getString("ValidationError.18", "RenameExampleClassPlugin", "replaceString"));
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 88 */     return valid;
/*    */   }
/*    */ 
/*    */   public void initialized(IntrospectedTable introspectedTable)
/*    */   {
/* 93 */     String oldType = introspectedTable.getExampleType();
/* 94 */     Matcher matcher = this.pattern.matcher(oldType);
/* 95 */     oldType = matcher.replaceAll(this.replaceString);
/*    */ 
/* 97 */     introspectedTable.setExampleType(oldType);
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.plugins.RenameExampleClassPlugin
 * JD-Core Version:    0.6.0
 */