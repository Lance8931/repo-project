/*     */ package org.mybatis.generator.internal.types;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class JdbcTypeNameTranslator
/*     */ {
/*  33 */   private static Map<Integer, String> typeToName = new HashMap();
/*     */   private static Map<String, Integer> nameToType;
/*     */ 
/*     */   public static String getJdbcTypeName(int jdbcType)
/*     */   {
/* 114 */     String answer = (String)typeToName.get(Integer.valueOf(jdbcType));
/* 115 */     if (answer == null) {
/* 116 */       answer = "OTHER";
/*     */     }
/*     */ 
/* 119 */     return answer;
/*     */   }
/*     */ 
/*     */   public static int getJdbcType(String jdbcTypeName)
/*     */   {
/* 131 */     Integer answer = (Integer)nameToType.get(jdbcTypeName);
/* 132 */     if (answer == null) {
/* 133 */       answer = Integer.valueOf(1111);
/*     */     }
/*     */ 
/* 136 */     return answer.intValue();
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  34 */     typeToName.put(Integer.valueOf(2003), "ARRAY");
/*  35 */     typeToName.put(Integer.valueOf(-5), "BIGINT");
/*  36 */     typeToName.put(Integer.valueOf(-2), "BINARY");
/*  37 */     typeToName.put(Integer.valueOf(-7), "BIT");
/*  38 */     typeToName.put(Integer.valueOf(2004), "BLOB");
/*  39 */     typeToName.put(Integer.valueOf(16), "BOOLEAN");
/*  40 */     typeToName.put(Integer.valueOf(1), "CHAR");
/*  41 */     typeToName.put(Integer.valueOf(2005), "CLOB");
/*  42 */     typeToName.put(Integer.valueOf(70), "DATALINK");
/*  43 */     typeToName.put(Integer.valueOf(91), "DATE");
/*  44 */     typeToName.put(Integer.valueOf(3), "DECIMAL");
/*  45 */     typeToName.put(Integer.valueOf(2001), "DISTINCT");
/*  46 */     typeToName.put(Integer.valueOf(8), "DOUBLE");
/*  47 */     typeToName.put(Integer.valueOf(6), "FLOAT");
/*  48 */     typeToName.put(Integer.valueOf(4), "INTEGER");
/*  49 */     typeToName.put(Integer.valueOf(2000), "JAVA_OBJECT");
/*  50 */     typeToName.put(Integer.valueOf(-4), "LONGVARBINARY");
/*  51 */     typeToName.put(Integer.valueOf(-1), "LONGVARCHAR");
/*  52 */     typeToName.put(Integer.valueOf(0), "NULL");
/*  53 */     typeToName.put(Integer.valueOf(2), "NUMERIC");
/*  54 */     typeToName.put(Integer.valueOf(1111), "OTHER");
/*  55 */     typeToName.put(Integer.valueOf(7), "REAL");
/*  56 */     typeToName.put(Integer.valueOf(2006), "REF");
/*  57 */     typeToName.put(Integer.valueOf(5), "SMALLINT");
/*  58 */     typeToName.put(Integer.valueOf(2002), "STRUCT");
/*  59 */     typeToName.put(Integer.valueOf(92), "TIME");
/*  60 */     typeToName.put(Integer.valueOf(93), "TIMESTAMP");
/*  61 */     typeToName.put(Integer.valueOf(-6), "TINYINT");
/*  62 */     typeToName.put(Integer.valueOf(-3), "VARBINARY");
/*  63 */     typeToName.put(Integer.valueOf(12), "VARCHAR");
/*     */ 
/*  65 */     nameToType = new HashMap();
/*  66 */     nameToType.put("ARRAY", Integer.valueOf(2003));
/*  67 */     nameToType.put("BIGINT", Integer.valueOf(-5));
/*  68 */     nameToType.put("BINARY", Integer.valueOf(-2));
/*  69 */     nameToType.put("BIT", Integer.valueOf(-7));
/*  70 */     nameToType.put("BLOB", Integer.valueOf(2004));
/*  71 */     nameToType.put("BOOLEAN", Integer.valueOf(16));
/*  72 */     nameToType.put("CHAR", Integer.valueOf(1));
/*  73 */     nameToType.put("CLOB", Integer.valueOf(2005));
/*  74 */     nameToType.put("DATALINK", Integer.valueOf(70));
/*  75 */     nameToType.put("DATE", Integer.valueOf(91));
/*  76 */     nameToType.put("DECIMAL", Integer.valueOf(3));
/*  77 */     nameToType.put("DISTINCT", Integer.valueOf(2001));
/*  78 */     nameToType.put("DOUBLE", Integer.valueOf(8));
/*  79 */     nameToType.put("FLOAT", Integer.valueOf(6));
/*  80 */     nameToType.put("INTEGER", Integer.valueOf(4));
/*  81 */     nameToType.put("JAVA_OBJECT", Integer.valueOf(2000));
/*  82 */     nameToType.put("LONGVARBINARY", Integer.valueOf(-4));
/*  83 */     nameToType.put("LONGVARCHAR", Integer.valueOf(-1));
/*  84 */     nameToType.put("NULL", Integer.valueOf(0));
/*  85 */     nameToType.put("NUMERIC", Integer.valueOf(2));
/*  86 */     nameToType.put("OTHER", Integer.valueOf(1111));
/*  87 */     nameToType.put("REAL", Integer.valueOf(7));
/*  88 */     nameToType.put("REF", Integer.valueOf(2006));
/*  89 */     nameToType.put("SMALLINT", Integer.valueOf(5));
/*  90 */     nameToType.put("STRUCT", Integer.valueOf(2002));
/*  91 */     nameToType.put("TIME", Integer.valueOf(92));
/*  92 */     nameToType.put("TIMESTAMP", Integer.valueOf(93));
/*  93 */     nameToType.put("TINYINT", Integer.valueOf(-6));
/*  94 */     nameToType.put("VARBINARY", Integer.valueOf(-3));
/*  95 */     nameToType.put("VARCHAR", Integer.valueOf(12));
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.types.JdbcTypeNameTranslator
 * JD-Core Version:    0.6.0
 */