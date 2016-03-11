/*     */ package org.mybatis.generator.internal.util;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ 
/*     */ public class JavaBeansUtil
/*     */ {
/*     */   public static String getGetterMethodName(String property, FullyQualifiedJavaType fullyQualifiedJavaType)
/*     */   {
/*  47 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  49 */     sb.append(property);
/*  50 */     if ((Character.isLowerCase(sb.charAt(0))) && (
/*  51 */       (sb.length() == 1) || (!Character.isUpperCase(sb.charAt(1))))) {
/*  52 */       sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/*     */     }
/*     */ 
/*  56 */     if (fullyQualifiedJavaType.equals(FullyQualifiedJavaType.getBooleanPrimitiveInstance()))
/*     */     {
/*  58 */       sb.insert(0, "is");
/*     */     }
/*  60 */     else sb.insert(0, "get");
/*     */ 
/*  63 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getSetterMethodName(String property)
/*     */   {
/*  78 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  80 */     sb.append(property);
/*  81 */     if ((Character.isLowerCase(sb.charAt(0))) && (
/*  82 */       (sb.length() == 1) || (!Character.isUpperCase(sb.charAt(1))))) {
/*  83 */       sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/*     */     }
/*     */ 
/*  87 */     sb.insert(0, "set");
/*     */ 
/*  89 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase)
/*     */   {
/*  94 */     StringBuilder sb = new StringBuilder();
/*     */ 
/*  96 */     boolean nextUpperCase = false;
/*  97 */     for (int i = 0; i < inputString.length(); i++) {
/*  98 */       char c = inputString.charAt(i);
/*     */ 
/* 100 */       switch (c) {
/*     */       case ' ':
/*     */       case '#':
/*     */       case '$':
/*     */       case '&':
/*     */       case '-':
/*     */       case '/':
/*     */       case '@':
/*     */       case '_':
/* 109 */         if (sb.length() <= 0) continue;
/* 110 */         nextUpperCase = true; break;
/*     */       default:
/* 115 */         if (nextUpperCase) {
/* 116 */           sb.append(Character.toUpperCase(c));
/* 117 */           nextUpperCase = false;
/*     */         } else {
/* 119 */           sb.append(Character.toLowerCase(c));
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 125 */     if (firstCharacterUppercase) {
/* 126 */       sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
/*     */     }
/*     */ 
/* 129 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getValidPropertyName(String inputString)
/*     */   {
/*     */     String answer;
/* 150 */     if (inputString == null) {
/* 151 */       answer = null;
/*     */     }
/*     */     else
/*     */     {
/* 152 */       if (inputString.length() < 2) {
/* 153 */         answer = inputString.toLowerCase(Locale.US);
/*     */       }
/*     */       else
/*     */       {
/* 155 */         if ((Character.isUpperCase(inputString.charAt(0))) && (!Character.isUpperCase(inputString.charAt(1))))
/*     */         {
/* 157 */           answer = inputString.substring(0, 1).toLowerCase(Locale.US) + inputString.substring(1);
/*     */         }
/*     */         else {
/* 160 */           answer = inputString;
/*     */         }
/*     */       }
/*     */     }
/* 164 */     return answer;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.util.JavaBeansUtil
 * JD-Core Version:    0.6.0
 */