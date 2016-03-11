/*    */ package org.mybatis.generator.internal.util;
/*    */ 
/*    */ public final class EqualsUtil
/*    */ {
/*    */   public static boolean areEqual(boolean aThis, boolean aThat)
/*    */   {
/* 33 */     return aThis == aThat;
/*    */   }
/*    */ 
/*    */   public static boolean areEqual(char aThis, char aThat) {
/* 37 */     return aThis == aThat;
/*    */   }
/*    */ 
/*    */   public static boolean areEqual(long aThis, long aThat)
/*    */   {
/* 45 */     return aThis == aThat;
/*    */   }
/*    */ 
/*    */   public static boolean areEqual(float aThis, float aThat) {
/* 49 */     return Float.floatToIntBits(aThis) == Float.floatToIntBits(aThat);
/*    */   }
/*    */ 
/*    */   public static boolean areEqual(double aThis, double aThat) {
/* 53 */     return Double.doubleToLongBits(aThis) == Double.doubleToLongBits(aThat);
/*    */   }
/*    */ 
/*    */   public static boolean areEqual(Object aThis, Object aThat)
/*    */   {
/* 63 */     return aThis == null ? false : aThat == null ? true : aThis.equals(aThat);
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.util.EqualsUtil
 * JD-Core Version:    0.6.0
 */