/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.mybatis.generator.api.GeneratedJavaFile;
/*     */ import org.mybatis.generator.api.GeneratedXmlFile;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.Plugin.ModelClassType;
/*     */ import org.mybatis.generator.api.dom.java.Field;
/*     */ import org.mybatis.generator.api.dom.java.Interface;
/*     */ import org.mybatis.generator.api.dom.java.Method;
/*     */ import org.mybatis.generator.api.dom.java.TopLevelClass;
/*     */ import org.mybatis.generator.api.dom.xml.Document;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.config.Context;
/*     */ 
/*     */ public final class PluginAggregator
/*     */   implements Plugin
/*     */ {
/*     */   private List<Plugin> plugins;
/*     */ 
/*     */   public PluginAggregator()
/*     */   {
/*  51 */     this.plugins = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void addPlugin(Plugin plugin) {
/*  55 */     this.plugins.add(plugin);
/*     */   }
/*     */ 
/*     */   public void setContext(Context context) {
/*  59 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   public void setProperties(Properties properties) {
/*  63 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   public boolean validate(List<String> warnings) {
/*  67 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   public boolean modelBaseRecordClassGenerated(TopLevelClass tlc, IntrospectedTable introspectedTable)
/*     */   {
/*  72 */     boolean rc = true;
/*     */ 
/*  74 */     for (Plugin plugin : this.plugins) {
/*  75 */       if (!plugin.modelBaseRecordClassGenerated(tlc, introspectedTable)) {
/*  76 */         rc = false;
/*  77 */         break;
/*     */       }
/*     */     }
/*     */ 
/*  81 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass tlc, IntrospectedTable introspectedTable)
/*     */   {
/*  86 */     boolean rc = true;
/*     */ 
/*  88 */     for (Plugin plugin : this.plugins) {
/*  89 */       if (!plugin.modelRecordWithBLOBsClassGenerated(tlc, introspectedTable))
/*     */       {
/*  91 */         rc = false;
/*  92 */         break;
/*     */       }
/*     */     }
/*     */ 
/*  96 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable table)
/*     */   {
/* 101 */     boolean rc = true;
/*     */ 
/* 103 */     for (Plugin plugin : this.plugins) {
/* 104 */       if (!plugin.sqlMapCountByExampleElementGenerated(element, table)) {
/* 105 */         rc = false;
/* 106 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 110 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element, IntrospectedTable table)
/*     */   {
/* 115 */     boolean rc = true;
/*     */ 
/* 117 */     for (Plugin plugin : this.plugins) {
/* 118 */       if (!plugin.sqlMapDeleteByExampleElementGenerated(element, table)) {
/* 119 */         rc = false;
/* 120 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 124 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable table)
/*     */   {
/* 129 */     boolean rc = true;
/*     */ 
/* 131 */     for (Plugin plugin : this.plugins) {
/* 132 */       if (!plugin.sqlMapDeleteByPrimaryKeyElementGenerated(element, table))
/*     */       {
/* 134 */         rc = false;
/* 135 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 139 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean modelExampleClassGenerated(TopLevelClass tlc, IntrospectedTable introspectedTable)
/*     */   {
/* 144 */     boolean rc = true;
/*     */ 
/* 146 */     for (Plugin plugin : this.plugins) {
/* 147 */       if (!plugin.modelExampleClassGenerated(tlc, introspectedTable)) {
/* 148 */         rc = false;
/* 149 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 153 */     return rc;
/*     */   }
/*     */ 
/*     */   public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable)
/*     */   {
/* 158 */     List answer = new ArrayList();
/* 159 */     for (Plugin plugin : this.plugins) {
/* 160 */       List temp = plugin.contextGenerateAdditionalJavaFiles(introspectedTable);
/*     */ 
/* 162 */       if (temp != null) {
/* 163 */         answer.addAll(temp);
/*     */       }
/*     */     }
/* 166 */     return answer;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles(IntrospectedTable introspectedTable)
/*     */   {
/* 171 */     List answer = new ArrayList();
/* 172 */     for (Plugin plugin : this.plugins) {
/* 173 */       List temp = plugin.contextGenerateAdditionalXmlFiles(introspectedTable);
/*     */ 
/* 175 */       if (temp != null) {
/* 176 */         answer.addAll(temp);
/*     */       }
/*     */     }
/* 179 */     return answer;
/*     */   }
/*     */ 
/*     */   public boolean modelPrimaryKeyClassGenerated(TopLevelClass tlc, IntrospectedTable introspectedTable)
/*     */   {
/* 184 */     boolean rc = true;
/*     */ 
/* 186 */     for (Plugin plugin : this.plugins) {
/* 187 */       if (!plugin.modelPrimaryKeyClassGenerated(tlc, introspectedTable)) {
/* 188 */         rc = false;
/* 189 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 193 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapResultMapWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 198 */     boolean rc = true;
/*     */ 
/* 200 */     for (Plugin plugin : this.plugins) {
/* 201 */       if (!plugin.sqlMapResultMapWithoutBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 203 */         rc = false;
/* 204 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 208 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 213 */     boolean rc = true;
/*     */ 
/* 215 */     for (Plugin plugin : this.plugins) {
/* 216 */       if (!plugin.sqlMapExampleWhereClauseElementGenerated(element, introspectedTable))
/*     */       {
/* 218 */         rc = false;
/* 219 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 223 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 228 */     boolean rc = true;
/*     */ 
/* 230 */     for (Plugin plugin : this.plugins) {
/* 231 */       if (!plugin.sqlMapInsertElementGenerated(element, introspectedTable))
/*     */       {
/* 233 */         rc = false;
/* 234 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 238 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 243 */     boolean rc = true;
/*     */ 
/* 245 */     for (Plugin plugin : this.plugins) {
/* 246 */       if (!plugin.sqlMapResultMapWithBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 248 */         rc = false;
/* 249 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 253 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 258 */     boolean rc = true;
/*     */ 
/* 260 */     for (Plugin plugin : this.plugins) {
/* 261 */       if (!plugin.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 263 */         rc = false;
/* 264 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 268 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 273 */     boolean rc = true;
/*     */ 
/* 275 */     for (Plugin plugin : this.plugins) {
/* 276 */       if (!plugin.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 278 */         rc = false;
/* 279 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 283 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 288 */     boolean rc = true;
/*     */ 
/* 290 */     for (Plugin plugin : this.plugins) {
/* 291 */       if (!plugin.sqlMapSelectByPrimaryKeyElementGenerated(element, introspectedTable))
/*     */       {
/* 293 */         rc = false;
/* 294 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 298 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable)
/*     */   {
/* 303 */     boolean rc = true;
/*     */ 
/* 305 */     for (Plugin plugin : this.plugins) {
/* 306 */       if (!plugin.sqlMapGenerated(sqlMap, introspectedTable)) {
/* 307 */         rc = false;
/* 308 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 312 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByExampleSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 317 */     boolean rc = true;
/*     */ 
/* 319 */     for (Plugin plugin : this.plugins) {
/* 320 */       if (!plugin.sqlMapUpdateByExampleSelectiveElementGenerated(element, introspectedTable))
/*     */       {
/* 322 */         rc = false;
/* 323 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 327 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 332 */     boolean rc = true;
/*     */ 
/* 334 */     for (Plugin plugin : this.plugins) {
/* 335 */       if (!plugin.sqlMapUpdateByExampleWithBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 337 */         rc = false;
/* 338 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 342 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 347 */     boolean rc = true;
/*     */ 
/* 349 */     for (Plugin plugin : this.plugins) {
/* 350 */       if (!plugin.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 352 */         rc = false;
/* 353 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 357 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 362 */     boolean rc = true;
/*     */ 
/* 364 */     for (Plugin plugin : this.plugins) {
/* 365 */       if (!plugin.sqlMapUpdateByPrimaryKeySelectiveElementGenerated(element, introspectedTable))
/*     */       {
/* 367 */         rc = false;
/* 368 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 372 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 377 */     boolean rc = true;
/*     */ 
/* 379 */     for (Plugin plugin : this.plugins) {
/* 380 */       if (!plugin.sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 382 */         rc = false;
/* 383 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 387 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 392 */     boolean rc = true;
/*     */ 
/* 394 */     for (Plugin plugin : this.plugins) {
/* 395 */       if (!plugin.sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(element, introspectedTable))
/*     */       {
/* 397 */         rc = false;
/* 398 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 402 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientCountByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 407 */     boolean rc = true;
/*     */ 
/* 409 */     for (Plugin plugin : this.plugins) {
/* 410 */       if (!plugin.clientCountByExampleMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 412 */         rc = false;
/* 413 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 417 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientCountByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 422 */     boolean rc = true;
/*     */ 
/* 424 */     for (Plugin plugin : this.plugins) {
/* 425 */       if (!plugin.clientCountByExampleMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 427 */         rc = false;
/* 428 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 432 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByExampleMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 437 */     boolean rc = true;
/*     */ 
/* 439 */     for (Plugin plugin : this.plugins) {
/* 440 */       if (!plugin.clientDeleteByExampleMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 442 */         rc = false;
/* 443 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 447 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByExampleMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 452 */     boolean rc = true;
/*     */ 
/* 454 */     for (Plugin plugin : this.plugins) {
/* 455 */       if (!plugin.clientDeleteByExampleMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 457 */         rc = false;
/* 458 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 462 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 467 */     boolean rc = true;
/*     */ 
/* 469 */     for (Plugin plugin : this.plugins) {
/* 470 */       if (!plugin.clientDeleteByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 472 */         rc = false;
/* 473 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 477 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 482 */     boolean rc = true;
/*     */ 
/* 484 */     for (Plugin plugin : this.plugins) {
/* 485 */       if (!plugin.clientDeleteByPrimaryKeyMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 487 */         rc = false;
/* 488 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 492 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 497 */     boolean rc = true;
/*     */ 
/* 499 */     for (Plugin plugin : this.plugins) {
/* 500 */       if (!plugin.clientInsertMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 502 */         rc = false;
/* 503 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 507 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 512 */     boolean rc = true;
/*     */ 
/* 514 */     for (Plugin plugin : this.plugins) {
/* 515 */       if (!plugin.clientInsertMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 517 */         rc = false;
/* 518 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 522 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 528 */     boolean rc = true;
/*     */ 
/* 530 */     for (Plugin plugin : this.plugins) {
/* 531 */       if (!plugin.clientGenerated(interfaze, topLevelClass, introspectedTable)) {
/* 532 */         rc = false;
/* 533 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 537 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 542 */     boolean rc = true;
/*     */ 
/* 544 */     for (Plugin plugin : this.plugins) {
/* 545 */       if (!plugin.clientSelectByExampleWithBLOBsMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 547 */         rc = false;
/* 548 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 552 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 557 */     boolean rc = true;
/*     */ 
/* 559 */     for (Plugin plugin : this.plugins) {
/* 560 */       if (!plugin.clientSelectByExampleWithBLOBsMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 562 */         rc = false;
/* 563 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 567 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 572 */     boolean rc = true;
/*     */ 
/* 574 */     for (Plugin plugin : this.plugins) {
/* 575 */       if (!plugin.clientSelectByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 577 */         rc = false;
/* 578 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 582 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 587 */     boolean rc = true;
/*     */ 
/* 589 */     for (Plugin plugin : this.plugins) {
/* 590 */       if (!plugin.clientSelectByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 592 */         rc = false;
/* 593 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 597 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 602 */     boolean rc = true;
/*     */ 
/* 604 */     for (Plugin plugin : this.plugins) {
/* 605 */       if (!plugin.clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 607 */         rc = false;
/* 608 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 612 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 617 */     boolean rc = true;
/*     */ 
/* 619 */     for (Plugin plugin : this.plugins) {
/* 620 */       if (!plugin.clientSelectByPrimaryKeyMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 622 */         rc = false;
/* 623 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 627 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 632 */     boolean rc = true;
/*     */ 
/* 634 */     for (Plugin plugin : this.plugins) {
/* 635 */       if (!plugin.clientUpdateByExampleSelectiveMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 637 */         rc = false;
/* 638 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 642 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 647 */     boolean rc = true;
/*     */ 
/* 649 */     for (Plugin plugin : this.plugins) {
/* 650 */       if (!plugin.clientUpdateByExampleSelectiveMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 652 */         rc = false;
/* 653 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 657 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 662 */     boolean rc = true;
/*     */ 
/* 664 */     for (Plugin plugin : this.plugins) {
/* 665 */       if (!plugin.clientUpdateByExampleWithBLOBsMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 667 */         rc = false;
/* 668 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 672 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 677 */     boolean rc = true;
/*     */ 
/* 679 */     for (Plugin plugin : this.plugins) {
/* 680 */       if (!plugin.clientUpdateByExampleWithBLOBsMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 682 */         rc = false;
/* 683 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 687 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 692 */     boolean rc = true;
/*     */ 
/* 694 */     for (Plugin plugin : this.plugins) {
/* 695 */       if (!plugin.clientUpdateByExampleWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 697 */         rc = false;
/* 698 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 702 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 707 */     boolean rc = true;
/*     */ 
/* 709 */     for (Plugin plugin : this.plugins) {
/* 710 */       if (!plugin.clientUpdateByExampleWithoutBLOBsMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 712 */         rc = false;
/* 713 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 717 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 722 */     boolean rc = true;
/*     */ 
/* 724 */     for (Plugin plugin : this.plugins) {
/* 725 */       if (!plugin.clientUpdateByPrimaryKeySelectiveMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 727 */         rc = false;
/* 728 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 732 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 737 */     boolean rc = true;
/*     */ 
/* 739 */     for (Plugin plugin : this.plugins) {
/* 740 */       if (!plugin.clientUpdateByPrimaryKeySelectiveMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 742 */         rc = false;
/* 743 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 747 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 752 */     boolean rc = true;
/*     */ 
/* 754 */     for (Plugin plugin : this.plugins) {
/* 755 */       if (!plugin.clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 757 */         rc = false;
/* 758 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 762 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 767 */     boolean rc = true;
/*     */ 
/* 769 */     for (Plugin plugin : this.plugins) {
/* 770 */       if (!plugin.clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 772 */         rc = false;
/* 773 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 777 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 783 */     boolean rc = true;
/*     */ 
/* 785 */     for (Plugin plugin : this.plugins) {
/* 786 */       if (!plugin.clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 788 */         rc = false;
/* 789 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 793 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 799 */     boolean rc = true;
/*     */ 
/* 801 */     for (Plugin plugin : this.plugins) {
/* 802 */       if (!plugin.clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 804 */         rc = false;
/* 805 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 809 */     return rc;
/*     */   }
/*     */ 
/*     */   public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles() {
/* 813 */     List answer = new ArrayList();
/* 814 */     for (Plugin plugin : this.plugins) {
/* 815 */       List temp = plugin.contextGenerateAdditionalJavaFiles();
/*     */ 
/* 817 */       if (temp != null) {
/* 818 */         answer.addAll(temp);
/*     */       }
/*     */     }
/* 821 */     return answer;
/*     */   }
/*     */ 
/*     */   public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles() {
/* 825 */     List answer = new ArrayList();
/* 826 */     for (Plugin plugin : this.plugins) {
/* 827 */       List temp = plugin.contextGenerateAdditionalXmlFiles();
/*     */ 
/* 829 */       if (temp != null) {
/* 830 */         answer.addAll(temp);
/*     */       }
/*     */     }
/* 833 */     return answer;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable)
/*     */   {
/* 838 */     boolean rc = true;
/*     */ 
/* 840 */     for (Plugin plugin : this.plugins) {
/* 841 */       if (!plugin.sqlMapDocumentGenerated(document, introspectedTable)) {
/* 842 */         rc = false;
/* 843 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 847 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType)
/*     */   {
/* 854 */     boolean rc = true;
/*     */ 
/* 856 */     for (Plugin plugin : this.plugins) {
/* 857 */       if (!plugin.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType))
/*     */       {
/* 859 */         rc = false;
/* 860 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 864 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType)
/*     */   {
/* 871 */     boolean rc = true;
/*     */ 
/* 873 */     for (Plugin plugin : this.plugins) {
/* 874 */       if (!plugin.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType))
/*     */       {
/* 876 */         rc = false;
/* 877 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 881 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, Plugin.ModelClassType modelClassType)
/*     */   {
/* 888 */     boolean rc = true;
/*     */ 
/* 890 */     for (Plugin plugin : this.plugins) {
/* 891 */       if (!plugin.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType))
/*     */       {
/* 893 */         rc = false;
/* 894 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 898 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 903 */     boolean rc = true;
/*     */ 
/* 905 */     for (Plugin plugin : this.plugins) {
/* 906 */       if (!plugin.sqlMapInsertSelectiveElementGenerated(element, introspectedTable))
/*     */       {
/* 908 */         rc = false;
/* 909 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 913 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable)
/*     */   {
/* 918 */     boolean rc = true;
/*     */ 
/* 920 */     for (Plugin plugin : this.plugins) {
/* 921 */       if (!plugin.clientInsertSelectiveMethodGenerated(method, interfaze, introspectedTable))
/*     */       {
/* 923 */         rc = false;
/* 924 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 928 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable)
/*     */   {
/* 933 */     boolean rc = true;
/*     */ 
/* 935 */     for (Plugin plugin : this.plugins) {
/* 936 */       if (!plugin.clientInsertSelectiveMethodGenerated(method, topLevelClass, introspectedTable))
/*     */       {
/* 938 */         rc = false;
/* 939 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 943 */     return rc;
/*     */   }
/*     */ 
/*     */   public void initialized(IntrospectedTable introspectedTable) {
/* 947 */     for (Plugin plugin : this.plugins)
/* 948 */       plugin.initialized(introspectedTable);
/*     */   }
/*     */ 
/*     */   public boolean sqlMapBaseColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 954 */     boolean rc = true;
/*     */ 
/* 956 */     for (Plugin plugin : this.plugins) {
/* 957 */       if (!plugin.sqlMapBaseColumnListElementGenerated(element, introspectedTable))
/*     */       {
/* 959 */         rc = false;
/* 960 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 964 */     return rc;
/*     */   }
/*     */ 
/*     */   public boolean sqlMapBlobColumnListElementGenerated(XmlElement element, IntrospectedTable introspectedTable)
/*     */   {
/* 969 */     boolean rc = true;
/*     */ 
/* 971 */     for (Plugin plugin : this.plugins) {
/* 972 */       if (!plugin.sqlMapBlobColumnListElementGenerated(element, introspectedTable))
/*     */       {
/* 974 */         rc = false;
/* 975 */         break;
/*     */       }
/*     */     }
/*     */ 
/* 979 */     return rc;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.PluginAggregator
 * JD-Core Version:    0.6.0
 */