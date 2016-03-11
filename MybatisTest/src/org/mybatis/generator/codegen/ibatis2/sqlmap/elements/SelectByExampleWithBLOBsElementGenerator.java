/*    */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ public class SelectByExampleWithBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 37 */     XmlElement answer = new XmlElement("select");
/* 38 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getSelectByExampleWithBLOBsStatementId()));
/*    */ 
/* 41 */     answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getResultMapWithBLOBsId()));
/*    */ 
/* 43 */     answer.addAttribute(new Attribute("parameterClass", this.introspectedTable.getExampleType()));
/*    */ 
/* 46 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 48 */     answer.addElement(new TextElement("select"));
/* 49 */     XmlElement isParameterPresent = new XmlElement("isParameterPresent");
/* 50 */     XmlElement isEqualElement = new XmlElement("isEqual");
/* 51 */     isEqualElement.addAttribute(new Attribute("property", "distinct"));
/* 52 */     isEqualElement.addAttribute(new Attribute("compareValue", "true"));
/* 53 */     isEqualElement.addElement(new TextElement("distinct"));
/* 54 */     isParameterPresent.addElement(isEqualElement);
/* 55 */     answer.addElement(isParameterPresent);
/*    */ 
/* 57 */     StringBuilder sb = new StringBuilder();
/* 58 */     if (StringUtility.stringHasValue(this.introspectedTable.getSelectByExampleQueryId()))
/*    */     {
/* 60 */       sb.append('\'');
/* 61 */       sb.append(this.introspectedTable.getSelectByExampleQueryId());
/* 62 */       sb.append("' as QUERYID,");
/* 63 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 66 */     answer.addElement(getBaseColumnListElement());
/* 67 */     answer.addElement(new TextElement(","));
/* 68 */     answer.addElement(getBlobColumnListElement());
/*    */ 
/* 70 */     sb.setLength(0);
/* 71 */     sb.append("from ");
/* 72 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 74 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 76 */     XmlElement isParameterPresenteElement = new XmlElement("isParameterPresent");
/*    */ 
/* 78 */     answer.addElement(isParameterPresenteElement);
/*    */ 
/* 80 */     XmlElement includeElement = new XmlElement("include");
/* 81 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getExampleWhereClauseId()));
/*    */ 
/* 84 */     isParameterPresenteElement.addElement(includeElement);
/*    */ 
/* 86 */     XmlElement isNotNullElement = new XmlElement("isNotNull");
/* 87 */     isNotNullElement.addAttribute(new Attribute("property", "orderByClause"));
/*    */ 
/* 89 */     isNotNullElement.addElement(new TextElement("order by $orderByClause$"));
/*    */ 
/* 91 */     isParameterPresenteElement.addElement(isNotNullElement);
/*    */ 
/* 93 */     if (this.context.getPlugins().sqlMapSelectByExampleWithBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 96 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.SelectByExampleWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */