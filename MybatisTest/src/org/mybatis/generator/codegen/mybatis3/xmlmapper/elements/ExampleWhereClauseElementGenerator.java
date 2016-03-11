/*     */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*     */ 
/*     */ import org.mybatis.generator.api.CommentGenerator;
/*     */ import org.mybatis.generator.api.IntrospectedColumn;
/*     */ import org.mybatis.generator.api.IntrospectedTable;
/*     */ import org.mybatis.generator.api.Plugin;
/*     */ import org.mybatis.generator.api.dom.xml.Attribute;
/*     */ import org.mybatis.generator.api.dom.xml.TextElement;
/*     */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.internal.util.StringUtility;
/*     */ 
/*     */ public class ExampleWhereClauseElementGenerator extends AbstractXmlElementGenerator
/*     */ {
/*     */   private boolean isForUpdateByExample;
/*     */ 
/*     */   public ExampleWhereClauseElementGenerator(boolean isForUpdateByExample)
/*     */   {
/*  36 */     this.isForUpdateByExample = isForUpdateByExample;
/*     */   }
/*     */ 
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  41 */     XmlElement answer = new XmlElement("sql");
/*     */ 
/*  43 */     if (this.isForUpdateByExample) {
/*  44 */       answer.addAttribute(new Attribute("id", this.introspectedTable.getMyBatis3UpdateByExampleWhereClauseId()));
/*     */     }
/*     */     else
/*     */     {
/*  48 */       answer.addAttribute(new Attribute("id", this.introspectedTable.getExampleWhereClauseId()));
/*     */     }
/*     */ 
/*  52 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  54 */     XmlElement whereElement = new XmlElement("where");
/*  55 */     answer.addElement(whereElement);
/*     */ 
/*  57 */     XmlElement outerForEachElement = new XmlElement("foreach");
/*  58 */     if (this.isForUpdateByExample) {
/*  59 */       outerForEachElement.addAttribute(new Attribute("collection", "example.oredCriteria"));
/*     */     }
/*     */     else {
/*  62 */       outerForEachElement.addAttribute(new Attribute("collection", "oredCriteria"));
/*     */     }
/*     */ 
/*  65 */     outerForEachElement.addAttribute(new Attribute("item", "criteria"));
/*  66 */     outerForEachElement.addAttribute(new Attribute("separator", "or"));
/*  67 */     whereElement.addElement(outerForEachElement);
/*     */ 
/*  69 */     XmlElement ifElement = new XmlElement("if");
/*  70 */     ifElement.addAttribute(new Attribute("test", "criteria.valid"));
/*  71 */     outerForEachElement.addElement(ifElement);
/*     */ 
/*  73 */     XmlElement trimElement = new XmlElement("trim");
/*  74 */     trimElement.addAttribute(new Attribute("prefix", "("));
/*  75 */     trimElement.addAttribute(new Attribute("suffix", ")"));
/*  76 */     trimElement.addAttribute(new Attribute("prefixOverrides", "and"));
/*     */ 
/*  78 */     ifElement.addElement(trimElement);
/*     */ 
/*  80 */     trimElement.addElement(getMiddleForEachElement(null));
/*     */ 
/*  82 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*     */     {
/*  84 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */       {
/*  86 */         trimElement.addElement(getMiddleForEachElement(introspectedColumn));
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  91 */     if (this.context.getPlugins().sqlMapExampleWhereClauseElementGenerated(answer, this.introspectedTable))
/*     */     {
/*  94 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ 
/*     */   private XmlElement getMiddleForEachElement(IntrospectedColumn introspectedColumn)
/*     */   {
/* 100 */     StringBuilder sb = new StringBuilder();
/*     */     String typeHandlerString;
/*     */     String criteriaAttribute;
/*     */     boolean typeHandled;
/* 104 */     if (introspectedColumn == null) {
/* 105 */       criteriaAttribute = "criteria.criteria";
/* 106 */       typeHandled = false;
/* 107 */       typeHandlerString = null;
/*     */     } else {
/* 109 */       sb.setLength(0);
/* 110 */       sb.append("criteria.");
/* 111 */       sb.append(introspectedColumn.getJavaProperty());
/* 112 */       sb.append("Criteria");
/* 113 */       criteriaAttribute = sb.toString();
/*     */ 
/* 115 */       typeHandled = true;
/*     */ 
/* 117 */       sb.setLength(0);
/* 118 */       sb.append(",typeHandler=");
/* 119 */       sb.append(introspectedColumn.getTypeHandler());
/* 120 */       typeHandlerString = sb.toString();
/*     */     }
/*     */ 
/* 123 */     XmlElement middleForEachElement = new XmlElement("foreach");
/* 124 */     middleForEachElement.addAttribute(new Attribute("collection", criteriaAttribute));
/*     */ 
/* 126 */     middleForEachElement.addAttribute(new Attribute("item", "criterion"));
/*     */ 
/* 128 */     XmlElement chooseElement = new XmlElement("choose");
/* 129 */     middleForEachElement.addElement(chooseElement);
/*     */ 
/* 131 */     XmlElement when = new XmlElement("when");
/* 132 */     when.addAttribute(new Attribute("test", "criterion.noValue"));
/* 133 */     when.addElement(new TextElement("and ${criterion.condition}"));
/* 134 */     chooseElement.addElement(when);
/*     */ 
/* 136 */     when = new XmlElement("when");
/* 137 */     when.addAttribute(new Attribute("test", "criterion.singleValue"));
/* 138 */     sb.setLength(0);
/* 139 */     sb.append("and ${criterion.condition} #{criterion.value");
/* 140 */     if (typeHandled) {
/* 141 */       sb.append(typeHandlerString);
/*     */     }
/* 143 */     sb.append('}');
/* 144 */     when.addElement(new TextElement(sb.toString()));
/* 145 */     chooseElement.addElement(when);
/*     */ 
/* 147 */     when = new XmlElement("when");
/* 148 */     when.addAttribute(new Attribute("test", "criterion.betweenValue"));
/* 149 */     sb.setLength(0);
/* 150 */     sb.append("and ${criterion.condition} #{criterion.value");
/* 151 */     if (typeHandled) {
/* 152 */       sb.append(typeHandlerString);
/*     */     }
/* 154 */     sb.append("} and #{criterion.secondValue");
/* 155 */     if (typeHandled) {
/* 156 */       sb.append(typeHandlerString);
/*     */     }
/* 158 */     sb.append('}');
/* 159 */     when.addElement(new TextElement(sb.toString()));
/* 160 */     chooseElement.addElement(when);
/*     */ 
/* 162 */     when = new XmlElement("when");
/* 163 */     when.addAttribute(new Attribute("test", "criterion.listValue"));
/* 164 */     when.addElement(new TextElement("and ${criterion.condition}"));
/* 165 */     XmlElement innerForEach = new XmlElement("foreach");
/* 166 */     innerForEach.addAttribute(new Attribute("collection", "criterion.value"));
/*     */ 
/* 168 */     innerForEach.addAttribute(new Attribute("item", "listItem"));
/* 169 */     innerForEach.addAttribute(new Attribute("open", "("));
/* 170 */     innerForEach.addAttribute(new Attribute("close", ")"));
/* 171 */     innerForEach.addAttribute(new Attribute("separator", ","));
/* 172 */     sb.setLength(0);
/* 173 */     sb.append("#{listItem");
/* 174 */     if (typeHandled) {
/* 175 */       sb.append(typeHandlerString);
/*     */     }
/* 177 */     sb.append('}');
/* 178 */     innerForEach.addElement(new TextElement(sb.toString()));
/* 179 */     when.addElement(innerForEach);
/* 180 */     chooseElement.addElement(when);
/*     */ 
/* 182 */     return middleForEachElement;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.ExampleWhereClauseElementGenerator
 * JD-Core Version:    0.6.0
 */