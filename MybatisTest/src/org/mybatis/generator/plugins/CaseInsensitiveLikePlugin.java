/*     */ package org.mybatis.generator.plugins;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.PluginAdapter;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.InnerClass;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*     */ 
/*     */ public class CaseInsensitiveLikePlugin extends PluginAdapter
/*     */ {
/*     */   public boolean validate(List<String> warnings)
/*     */   {
/*  53 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  60 */     InnerClass criteria = null;
/*     */ 
/*  62 */     for (InnerClass innerClass : topLevelClass.getInnerClasses()) {
/*  63 */       if ("Criteria".equals(innerClass.getType().getShortName())) {
/*  64 */         criteria = innerClass;
/*  65 */         break;
/*     */       }
/*     */     }
/*     */ 
/*  69 */     if (criteria == null)
/*     */     {
/*  71 */       return true;
/*     */     }
/*     */ 
/*  74 */     for (IntrospectedColumn introspectedColumn : introspectedTable.getNonBLOBColumns())
/*     */     {
/*  76 */       if ((!introspectedColumn.isJdbcCharacterColumn()) || (!introspectedColumn.isStringColumn()))
/*     */       {
/*     */         continue;
/*     */       }
/*     */ 
/*  81 */       Method method = new Method();
/*  82 */       method.setVisibility(JavaVisibility.PUBLIC);
/*  83 */       method.addParameter(new Parameter(introspectedColumn.getFullyQualifiedJavaType(), "value"));
/*     */ 
/*  86 */       StringBuilder sb = new StringBuilder();
/*  87 */       sb.append(introspectedColumn.getJavaProperty());
/*  88 */       sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/*  89 */       sb.insert(0, "and");
/*  90 */       sb.append("LikeInsensitive");
/*  91 */       method.setName(sb.toString());
/*  92 */       method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
/*     */ 
/*  94 */       sb.setLength(0);
/*  95 */       sb.append("addCriterion(\"upper(");
/*  96 */       sb.append(Ibatis2FormattingUtilities.getAliasedActualColumnName(introspectedColumn));
/*     */ 
/*  98 */       sb.append(") like\", value.toUpperCase(), \"");
/*  99 */       sb.append(introspectedColumn.getJavaProperty());
/* 100 */       sb.append("\");");
/* 101 */       method.addBodyLine(sb.toString());
/* 102 */       method.addBodyLine("return this;");
/*     */ 
/* 104 */       criteria.addMethod(method);
/*     */     }
/*     */ 
/* 107 */     return true;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.plugins.CaseInsensitiveLikePlugin
 * JD-Core Version:    0.6.0
 */