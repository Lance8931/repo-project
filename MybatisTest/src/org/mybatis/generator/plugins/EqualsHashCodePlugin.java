/*     */ package org.mybatis.generator.plugins;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.PluginAdapter;
/*     */ import org.mybatis.generator.api.dom.OutputUtilities;
/*     */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*     */ import org.mybatis.generator.api.dom.java.JavaVisibility;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.Parameter;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.rules.Rules;
/*     */ import org.mybatis.generator.internal.util.JavaBeansUtil;
/*     */ 
/*     */ public class EqualsHashCodePlugin extends PluginAdapter
/*     */ {
/*     */   public boolean validate(List<String> warnings)
/*     */   {
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*     */     List columns;
/*  63 */     if (introspectedTable.getRules().generateRecordWithBLOBsClass())
/*  64 */       columns = introspectedTable.getNonBLOBColumns();
/*     */     else {
/*  66 */       columns = introspectedTable.getAllColumns();
/*     */     }
/*     */ 
/*  69 */     generateEquals(topLevelClass, columns, introspectedTable);
/*  70 */     generateHashCode(topLevelClass, columns, introspectedTable);
/*     */ 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  78 */     generateEquals(topLevelClass, introspectedTable.getPrimaryKeyColumns(), introspectedTable);
/*     */ 
/*  80 */     generateHashCode(topLevelClass, introspectedTable.getPrimaryKeyColumns(), introspectedTable);
/*     */ 
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/*  89 */     generateEquals(topLevelClass, introspectedTable.getAllColumns(), introspectedTable);
/*     */ 
/*  91 */     generateHashCode(topLevelClass, introspectedTable.getAllColumns(), introspectedTable);
/*     */ 
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   protected void generateEquals(TopLevelClass topLevelClass, List<IntrospectedColumn> introspectedColumns, IntrospectedTable introspectedTable)
/*     */   {
/* 117 */     Method method = new Method();
/* 118 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 119 */     method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
/*     */ 
/* 121 */     method.setName("equals");
/* 122 */     method.addParameter(new Parameter(FullyQualifiedJavaType.getObjectInstance(), "that"));
/*     */ 
/* 124 */     if (introspectedTable.isJava5Targeted()) {
/* 125 */       method.addAnnotation("@Override");
/*     */     }
/*     */ 
/* 128 */     this.context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
/*     */ 
/* 131 */     method.addBodyLine("if (this == that) {");
/* 132 */     method.addBodyLine("return true;");
/* 133 */     method.addBodyLine("}");
/*     */ 
/* 135 */     method.addBodyLine("if (that == null) {");
/* 136 */     method.addBodyLine("return false;");
/* 137 */     method.addBodyLine("}");
/*     */ 
/* 139 */     method.addBodyLine("if (getClass() != that.getClass()) {");
/* 140 */     method.addBodyLine("return false;");
/* 141 */     method.addBodyLine("}");
/*     */ 
/* 143 */     StringBuilder sb = new StringBuilder();
/* 144 */     sb.append(topLevelClass.getType().getShortName());
/* 145 */     sb.append(" other = (");
/* 146 */     sb.append(topLevelClass.getType().getShortName());
/* 147 */     sb.append(") that;");
/* 148 */     method.addBodyLine(sb.toString());
/*     */ 
/* 150 */     boolean first = true;
/* 151 */     Iterator iter = introspectedColumns.iterator();
/* 152 */     while (iter.hasNext()) {
/* 153 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */ 
/* 155 */       sb.setLength(0);
/*     */ 
/* 157 */       if (first) {
/* 158 */         sb.append("return (");
/* 159 */         first = false;
/*     */       } else {
/* 161 */         OutputUtilities.javaIndent(sb, 1);
/* 162 */         sb.append("&& (");
/*     */       }
/*     */ 
/* 165 */       String getterMethod = JavaBeansUtil.getGetterMethodName(introspectedColumn.getJavaProperty(), introspectedColumn.getFullyQualifiedJavaType());
/*     */ 
/* 169 */       if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
/* 170 */         sb.append("this.");
/* 171 */         sb.append(getterMethod);
/* 172 */         sb.append("() == ");
/* 173 */         sb.append("other.");
/* 174 */         sb.append(getterMethod);
/* 175 */         sb.append("())");
/*     */       } else {
/* 177 */         sb.append("this.");
/* 178 */         sb.append(getterMethod);
/* 179 */         sb.append("() == null ? other.");
/* 180 */         sb.append(getterMethod);
/* 181 */         sb.append("() == null : this.");
/* 182 */         sb.append(getterMethod);
/* 183 */         sb.append("().equals(other.");
/* 184 */         sb.append(getterMethod);
/* 185 */         sb.append("()))");
/*     */       }
/*     */ 
/* 188 */       if (!iter.hasNext()) {
/* 189 */         sb.append(';');
/*     */       }
/*     */ 
/* 192 */       method.addBodyLine(sb.toString());
/*     */     }
/*     */ 
/* 195 */     topLevelClass.addMethod(method);
/*     */   }
/*     */ 
/*     */   protected void generateHashCode(TopLevelClass topLevelClass, List<IntrospectedColumn> introspectedColumns, IntrospectedTable introspectedTable)
/*     */   {
/* 215 */     Method method = new Method();
/* 216 */     method.setVisibility(JavaVisibility.PUBLIC);
/* 217 */     method.setReturnType(FullyQualifiedJavaType.getIntInstance());
/* 218 */     method.setName("hashCode");
/* 219 */     if (introspectedTable.isJava5Targeted()) {
/* 220 */       method.addAnnotation("@Override");
/*     */     }
/*     */ 
/* 223 */     this.context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
/*     */ 
/* 226 */     method.addBodyLine("final int prime = 31;");
/* 227 */     method.addBodyLine("int result = 1;");
/*     */ 
/* 229 */     StringBuilder sb = new StringBuilder();
/* 230 */     boolean hasTemp = false;
/* 231 */     Iterator iter = introspectedColumns.iterator();
/* 232 */     while (iter.hasNext()) {
/* 233 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*     */ 
/* 235 */       FullyQualifiedJavaType fqjt = introspectedColumn.getFullyQualifiedJavaType();
/*     */ 
/* 238 */       String getterMethod = JavaBeansUtil.getGetterMethodName(introspectedColumn.getJavaProperty(), fqjt);
/*     */ 
/* 241 */       sb.setLength(0);
/* 242 */       if (fqjt.isPrimitive()) {
/* 243 */         if ("boolean".equals(fqjt.getFullyQualifiedName())) {
/* 244 */           sb.append("result = prime * result + (");
/* 245 */           sb.append(getterMethod);
/* 246 */           sb.append("() ? 1231 : 1237);");
/* 247 */           method.addBodyLine(sb.toString());
/* 248 */         } else if ("byte".equals(fqjt.getFullyQualifiedName())) {
/* 249 */           sb.append("result = prime * result + ");
/* 250 */           sb.append(getterMethod);
/* 251 */           sb.append("();");
/* 252 */           method.addBodyLine(sb.toString());
/* 253 */         } else if ("char".equals(fqjt.getFullyQualifiedName())) {
/* 254 */           sb.append("result = prime * result + ");
/* 255 */           sb.append(getterMethod);
/* 256 */           sb.append("();");
/* 257 */           method.addBodyLine(sb.toString());
/* 258 */         } else if ("double".equals(fqjt.getFullyQualifiedName())) {
/* 259 */           if (!hasTemp) {
/* 260 */             method.addBodyLine("long temp;");
/* 261 */             hasTemp = true;
/*     */           }
/* 263 */           sb.append("temp = Double.doubleToLongBits(");
/* 264 */           sb.append(getterMethod);
/* 265 */           sb.append("());");
/* 266 */           method.addBodyLine(sb.toString());
/* 267 */           method.addBodyLine("result = prime * result + (int) (temp ^ (temp >>> 32));");
/*     */         }
/* 269 */         else if ("float".equals(fqjt.getFullyQualifiedName())) {
/* 270 */           sb.append("result = prime * result + Float.floatToIntBits(");
/*     */ 
/* 272 */           sb.append(getterMethod);
/* 273 */           sb.append("());");
/* 274 */           method.addBodyLine(sb.toString());
/* 275 */         } else if ("int".equals(fqjt.getFullyQualifiedName())) {
/* 276 */           sb.append("result = prime * result + ");
/* 277 */           sb.append(getterMethod);
/* 278 */           sb.append("();");
/* 279 */           method.addBodyLine(sb.toString());
/* 280 */         } else if ("long".equals(fqjt.getFullyQualifiedName())) {
/* 281 */           sb.append("result = prime * result + (int) (");
/* 282 */           sb.append(getterMethod);
/* 283 */           sb.append("() ^ (");
/* 284 */           sb.append(getterMethod);
/* 285 */           sb.append("() >>> 32));");
/* 286 */           method.addBodyLine(sb.toString());
/* 287 */         } else if ("short".equals(fqjt.getFullyQualifiedName())) {
/* 288 */           sb.append("result = prime * result + ");
/* 289 */           sb.append(getterMethod);
/* 290 */           sb.append("();");
/* 291 */           method.addBodyLine(sb.toString());
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 297 */         sb.append("result = prime * result + ((");
/* 298 */         sb.append(getterMethod);
/* 299 */         sb.append("() == null) ? 0 : ");
/* 300 */         sb.append(getterMethod);
/* 301 */         sb.append("().hashCode());");
/* 302 */         method.addBodyLine(sb.toString());
/*     */       }
/*     */     }
/*     */ 
/* 306 */     method.addBodyLine("return result;");
/*     */ 
/* 308 */     topLevelClass.addMethod(method);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.plugins.EqualsHashCodePlugin
 * JD-Core Version:    0.6.0
 */