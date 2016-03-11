/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
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
/* 37 */     String fqjt = this.introspectedTable.getExampleType();
/*    */ 
/* 39 */     XmlElement answer = new XmlElement("select");
/* 40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getSelectByExampleWithBLOBsStatementId()));
/*    */ 
/* 43 */     answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getResultMapWithBLOBsId()));
/*    */ 
/* 45 */     answer.addAttribute(new Attribute("parameterType", fqjt));
/*    */ 
/* 47 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 49 */     answer.addElement(new TextElement("select"));
/* 50 */     XmlElement ifElement = new XmlElement("if");
/* 51 */     ifElement.addAttribute(new Attribute("test", "distinct"));
/* 52 */     ifElement.addElement(new TextElement("distinct"));
/* 53 */     answer.addElement(ifElement);
/*    */ 
/* 55 */     StringBuilder sb = new StringBuilder();
/* 56 */     if (StringUtility.stringHasValue(this.introspectedTable.getSelectByExampleQueryId()))
/*    */     {
/* 58 */       sb.append('\'');
/* 59 */       sb.append(this.introspectedTable.getSelectByExampleQueryId());
/* 60 */       sb.append("' as QUERYID,");
/* 61 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 64 */     answer.addElement(getBaseColumnListElement());
/* 65 */     answer.addElement(new TextElement(","));
/* 66 */     answer.addElement(getBlobColumnListElement());
/*    */ 
/* 68 */     sb.setLength(0);
/* 69 */     sb.append("from ");
/* 70 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 72 */     answer.addElement(new TextElement(sb.toString()));
/* 73 */     answer.addElement(getExampleIncludeElement());
/*    */ 
/* 75 */     ifElement = new XmlElement("if");
/* 76 */     ifElement.addAttribute(new Attribute("test", "orderByClause != null"));
/* 77 */     ifElement.addElement(new TextElement("order by $orderByClause$"));
/* 78 */     answer.addElement(ifElement);
/*    */ 
/* 80 */     if (this.context.getPlugins().sqlMapSelectByExampleWithBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 83 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByExampleWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */