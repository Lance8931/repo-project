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
/*    */ public class SelectByExampleWithoutBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 37 */     XmlElement answer = new XmlElement("select");
/*    */ 
/* 39 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getSelectByExampleStatementId()));
/*    */ 
/* 41 */     answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getBaseResultMapId()));
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
/*    */ 
/* 68 */     sb.setLength(0);
/* 69 */     sb.append("from ");
/* 70 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 72 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 74 */     XmlElement isParameterPresenteElement = new XmlElement("isParameterPresent");
/*    */ 
/* 76 */     answer.addElement(isParameterPresenteElement);
/*    */ 
/* 78 */     XmlElement includeElement = new XmlElement("include");
/* 79 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getExampleWhereClauseId()));
/*    */ 
/* 82 */     isParameterPresenteElement.addElement(includeElement);
/*    */ 
/* 84 */     XmlElement isNotNullElement = new XmlElement("isNotNull");
/* 85 */     isNotNullElement.addAttribute(new Attribute("property", "orderByClause"));
/*    */ 
/* 87 */     isNotNullElement.addElement(new TextElement("order by $orderByClause$"));
/*    */ 
/* 89 */     isParameterPresenteElement.addElement(isNotNullElement);
/*    */ 
/* 91 */     if (this.context.getPlugins().sqlMapSelectByExampleWithoutBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 94 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.SelectByExampleWithoutBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */