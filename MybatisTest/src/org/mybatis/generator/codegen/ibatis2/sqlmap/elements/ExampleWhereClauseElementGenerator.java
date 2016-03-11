/*     */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
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
/*     */   public void addElements(XmlElement parentElement)
/*     */   {
/*  38 */     XmlElement answer = new XmlElement("sql");
/*     */ 
/*  40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getExampleWhereClauseId()));
/*     */ 
/*  43 */     this.context.getCommentGenerator().addComment(answer);
/*     */ 
/*  45 */     XmlElement outerIterateElement = new XmlElement("iterate");
/*  46 */     outerIterateElement.addAttribute(new Attribute("property", "oredCriteria"));
/*     */ 
/*  48 */     outerIterateElement.addAttribute(new Attribute("conjunction", "or"));
/*  49 */     outerIterateElement.addAttribute(new Attribute("prepend", "where"));
/*  50 */     outerIterateElement.addAttribute(new Attribute("removeFirstPrepend", "iterate"));
/*     */ 
/*  52 */     answer.addElement(outerIterateElement);
/*     */ 
/*  54 */     XmlElement isEqualElement = new XmlElement("isEqual");
/*  55 */     isEqualElement.addAttribute(new Attribute("property", "oredCriteria[].valid"));
/*     */ 
/*  57 */     isEqualElement.addAttribute(new Attribute("compareValue", "true"));
/*  58 */     outerIterateElement.addElement(isEqualElement);
/*     */ 
/*  60 */     isEqualElement.addElement(new TextElement("("));
/*     */ 
/*  62 */     XmlElement innerIterateElement = new XmlElement("iterate");
/*  63 */     innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/*  64 */     innerIterateElement.addAttribute(new Attribute("property", "oredCriteria[].criteriaWithoutValue"));
/*     */ 
/*  66 */     innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/*  67 */     innerIterateElement.addElement(new TextElement("$oredCriteria[].criteriaWithoutValue[]$"));
/*     */ 
/*  69 */     isEqualElement.addElement(innerIterateElement);
/*     */ 
/*  71 */     innerIterateElement = new XmlElement("iterate");
/*  72 */     innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/*  73 */     innerIterateElement.addAttribute(new Attribute("property", "oredCriteria[].criteriaWithSingleValue"));
/*     */ 
/*  75 */     innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/*  76 */     innerIterateElement.addElement(new TextElement("$oredCriteria[].criteriaWithSingleValue[].condition$ #oredCriteria[].criteriaWithSingleValue[].value#"));
/*     */ 
/*  79 */     isEqualElement.addElement(innerIterateElement);
/*     */ 
/*  81 */     innerIterateElement = new XmlElement("iterate");
/*  82 */     innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/*  83 */     innerIterateElement.addAttribute(new Attribute("property", "oredCriteria[].criteriaWithListValue"));
/*     */ 
/*  85 */     innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/*  86 */     innerIterateElement.addElement(new TextElement("$oredCriteria[].criteriaWithListValue[].condition$"));
/*     */ 
/*  88 */     XmlElement innerInnerIterateElement = new XmlElement("iterate");
/*  89 */     innerInnerIterateElement.addAttribute(new Attribute("property", "oredCriteria[].criteriaWithListValue[].values"));
/*     */ 
/*  91 */     innerInnerIterateElement.addAttribute(new Attribute("open", "("));
/*  92 */     innerInnerIterateElement.addAttribute(new Attribute("close", ")"));
/*  93 */     innerInnerIterateElement.addAttribute(new Attribute("conjunction", ","));
/*     */ 
/*  95 */     innerInnerIterateElement.addElement(new TextElement("#oredCriteria[].criteriaWithListValue[].values[]#"));
/*     */ 
/*  97 */     innerIterateElement.addElement(innerInnerIterateElement);
/*  98 */     isEqualElement.addElement(innerIterateElement);
/*     */ 
/* 100 */     innerIterateElement = new XmlElement("iterate");
/* 101 */     innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/* 102 */     innerIterateElement.addAttribute(new Attribute("property", "oredCriteria[].criteriaWithBetweenValue"));
/*     */ 
/* 104 */     innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/* 105 */     innerIterateElement.addElement(new TextElement("$oredCriteria[].criteriaWithBetweenValue[].condition$"));
/*     */ 
/* 107 */     innerIterateElement.addElement(new TextElement("#oredCriteria[].criteriaWithBetweenValue[].values[0]# and"));
/*     */ 
/* 109 */     innerIterateElement.addElement(new TextElement("#oredCriteria[].criteriaWithBetweenValue[].values[1]#"));
/*     */ 
/* 111 */     isEqualElement.addElement(innerIterateElement);
/*     */ 
/* 116 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*     */     {
/* 118 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*     */       {
/* 122 */         StringBuilder sb1 = new StringBuilder();
/* 123 */         StringBuilder sb2 = new StringBuilder();
/* 124 */         innerIterateElement = new XmlElement("iterate");
/* 125 */         innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/*     */ 
/* 128 */         sb1.append("oredCriteria[].");
/* 129 */         sb1.append(introspectedColumn.getJavaProperty());
/* 130 */         sb1.append("CriteriaWithSingleValue");
/*     */ 
/* 132 */         innerIterateElement.addAttribute(new Attribute("property", sb1.toString()));
/*     */ 
/* 134 */         innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/*     */ 
/* 137 */         sb2.append(sb1);
/*     */ 
/* 139 */         sb1.insert(0, '$');
/* 140 */         sb1.append("[].condition$ ");
/*     */ 
/* 142 */         sb2.insert(0, '#');
/* 143 */         sb2.append("[].value,handler=");
/* 144 */         sb2.append(introspectedColumn.getTypeHandler());
/* 145 */         sb2.append('#');
/*     */ 
/* 147 */         sb1.append(sb2);
/*     */ 
/* 149 */         innerIterateElement.addElement(new TextElement(sb1.toString()));
/* 150 */         isEqualElement.addElement(innerIterateElement);
/*     */ 
/* 152 */         sb1.setLength(0);
/* 153 */         sb2.setLength(0);
/* 154 */         sb1.append("oredCriteria[].");
/* 155 */         sb1.append(introspectedColumn.getJavaProperty());
/* 156 */         sb1.append("CriteriaWithListValue");
/*     */ 
/* 158 */         innerIterateElement = new XmlElement("iterate");
/* 159 */         innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/*     */ 
/* 161 */         innerIterateElement.addAttribute(new Attribute("property", sb1.toString()));
/*     */ 
/* 163 */         innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/*     */ 
/* 166 */         sb2.append('$');
/* 167 */         sb2.append(sb1);
/* 168 */         sb2.append("[].condition$");
/*     */ 
/* 170 */         innerIterateElement.addElement(new TextElement(sb2.toString()));
/*     */ 
/* 172 */         sb2.setLength(0);
/* 173 */         sb2.append(sb1);
/* 174 */         sb2.append("[].values");
/*     */ 
/* 176 */         innerInnerIterateElement = new XmlElement("iterate");
/* 177 */         innerInnerIterateElement.addAttribute(new Attribute("property", sb2.toString()));
/*     */ 
/* 179 */         innerInnerIterateElement.addAttribute(new Attribute("open", "("));
/*     */ 
/* 181 */         innerInnerIterateElement.addAttribute(new Attribute("close", ")"));
/*     */ 
/* 183 */         innerInnerIterateElement.addAttribute(new Attribute("conjunction", ","));
/*     */ 
/* 186 */         sb2.setLength(0);
/* 187 */         sb2.append('#');
/* 188 */         sb2.append(sb1);
/* 189 */         sb2.append("[].values[],handler=");
/* 190 */         sb2.append(introspectedColumn.getTypeHandler());
/* 191 */         sb2.append('#');
/*     */ 
/* 193 */         innerInnerIterateElement.addElement(new TextElement(sb2.toString()));
/*     */ 
/* 195 */         innerIterateElement.addElement(innerInnerIterateElement);
/* 196 */         isEqualElement.addElement(innerIterateElement);
/*     */ 
/* 198 */         sb1.setLength(0);
/* 199 */         sb2.setLength(0);
/* 200 */         sb1.append("oredCriteria[].");
/* 201 */         sb1.append(introspectedColumn.getJavaProperty());
/* 202 */         sb1.append("CriteriaWithBetweenValue");
/*     */ 
/* 204 */         innerIterateElement = new XmlElement("iterate");
/* 205 */         innerIterateElement.addAttribute(new Attribute("prepend", "and"));
/*     */ 
/* 207 */         innerIterateElement.addAttribute(new Attribute("property", sb1.toString()));
/*     */ 
/* 209 */         innerIterateElement.addAttribute(new Attribute("conjunction", "and"));
/*     */ 
/* 212 */         sb2.append('$');
/* 213 */         sb2.append(sb1);
/* 214 */         sb2.append("[].condition$");
/*     */ 
/* 216 */         innerIterateElement.addElement(new TextElement(sb2.toString()));
/*     */ 
/* 218 */         sb2.setLength(0);
/* 219 */         sb2.append(sb1);
/*     */ 
/* 221 */         sb1.insert(0, '#');
/* 222 */         sb1.append("[].values[0],handler=");
/* 223 */         sb1.append(introspectedColumn.getTypeHandler());
/* 224 */         sb1.append("# and");
/*     */ 
/* 226 */         sb2.insert(0, '#');
/* 227 */         sb2.append("[].values[1],handler=");
/* 228 */         sb2.append(introspectedColumn.getTypeHandler());
/* 229 */         sb2.append('#');
/*     */ 
/* 231 */         innerIterateElement.addElement(new TextElement(sb1.toString()));
/* 232 */         innerIterateElement.addElement(new TextElement(sb2.toString()));
/* 233 */         isEqualElement.addElement(innerIterateElement);
/*     */       }
/*     */     }
/*     */ 
/* 237 */     isEqualElement.addElement(new TextElement(")"));
/*     */ 
/* 239 */     if (this.context.getPlugins().sqlMapExampleWhereClauseElementGenerated(answer, this.introspectedTable))
/*     */     {
/* 242 */       parentElement.addElement(answer);
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.ExampleWhereClauseElementGenerator
 * JD-Core Version:    0.6.0
 */