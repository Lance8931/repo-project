/*    */ package org.mybatis.generator.config;
/*    */ 
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public enum ModelType
/*    */ {
/* 27 */   HIERARCHICAL("hierarchical"), 
/* 28 */   FLAT("flat"), 
/* 29 */   CONDITIONAL("conditional");
/*    */ 
/*    */   private final String modelType;
/*    */ 
/*    */   private ModelType(String modelType)
/*    */   {
/* 37 */     this.modelType = modelType;
/*    */   }
/*    */ 
/*    */   public String getModelType() {
/* 41 */     return this.modelType;
/*    */   }
/*    */ 
/*    */   public static ModelType getModelType(String type) {
/* 45 */     if (HIERARCHICAL.getModelType().equalsIgnoreCase(type))
/* 46 */       return HIERARCHICAL;
/* 47 */     if (FLAT.getModelType().equalsIgnoreCase(type))
/* 48 */       return FLAT;
/* 49 */     if (CONDITIONAL.getModelType().equalsIgnoreCase(type)) {
/* 50 */       return CONDITIONAL;
/*    */     }
/* 52 */     throw new RuntimeException(Messages.getString("RuntimeError.13", type));
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.ModelType
 * JD-Core Version:    0.6.0
 */