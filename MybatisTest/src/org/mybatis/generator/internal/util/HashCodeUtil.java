/*     */ package org.mybatis.generator.internal.util;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ 
/*     */ public final class HashCodeUtil
/*     */ {
/*     */   public static final int SEED = 23;
/*     */   private static final int fODD_PRIME_NUMBER = 37;
/*     */ 
/*     */   public static int hash(int aSeed, boolean aBoolean)
/*     */   {
/*  38 */     return firstTerm(aSeed) + (aBoolean ? 1 : 0);
/*     */   }
/*     */ 
/*     */   public static int hash(int aSeed, char aChar)
/*     */   {
/*  45 */     return firstTerm(aSeed) + aChar;
/*     */   }
/*     */ 
/*     */   public static int hash(int aSeed, int aInt)
/*     */   {
/*  56 */     return firstTerm(aSeed) + aInt;
/*     */   }
/*     */ 
/*     */   public static int hash(int aSeed, long aLong)
/*     */   {
/*  63 */     return firstTerm(aSeed) + (int)(aLong ^ aLong >>> 32);
/*     */   }
/*     */ 
/*     */   public static int hash(int aSeed, float aFloat)
/*     */   {
/*  70 */     return hash(aSeed, Float.floatToIntBits(aFloat));
/*     */   }
/*     */ 
/*     */   public static int hash(int aSeed, double aDouble)
/*     */   {
/*  77 */     return hash(aSeed, Double.doubleToLongBits(aDouble));
/*     */   }
/*     */ 
/*     */   public static int hash(int aSeed, Object aObject)
/*     */   {
/*  88 */     int result = aSeed;
/*  89 */     if (aObject == null) {
/*  90 */       result = hash(result, 0);
/*  91 */     } else if (!isArray(aObject)) {
/*  92 */       result = hash(result, aObject.hashCode());
/*     */     } else {
/*  94 */       int length = Array.getLength(aObject);
/*  95 */       for (int idx = 0; idx < length; idx++) {
/*  96 */         Object item = Array.get(aObject, idx);
/*     */ 
/*  98 */         result = hash(result, item);
/*     */       }
/*     */     }
/* 101 */     return result;
/*     */   }
/*     */ 
/*     */   private static int firstTerm(int aSeed)
/*     */   {
/* 108 */     return 37 * aSeed;
/*     */   }
/*     */ 
/*     */   private static boolean isArray(Object aObject) {
/* 112 */     return aObject.getClass().isArray();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.util.HashCodeUtil
 * JD-Core Version:    0.6.0
 */