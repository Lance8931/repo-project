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
/*    */ public class SelectByExampleWithoutBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 37 */     String fqjt = this.introspectedTable.getExampleType();
/*    */ 
/* 39 */     XmlElement answer = new XmlElement("select");
/*    */ 
/* 41 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getSelectByExampleStatementId()));
/*    */ 
/* 43 */     answer.addAttribute(new Attribute("resultMap", this.introspectedTable.getBaseResultMapId()));
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
/* 63 */     answer.addElement(getBaseColumnListElement());
/*    */ 
/* 65 */     sb.setLength(0);
/* 66 */     sb.append("from ");
/* 67 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 69 */     answer.addElement(new TextElement(sb.toString()));
/* 70 */     answer.addElement(getExampleIncludeElement());
/*    */ 
/* 72 */     ifElement = new XmlElement("if");
/* 73 */     ifElement.addAttribute(new Attribute("test", "orderByClause != null"));
/* 74 */     ifElement.addElement(new TextElement("order by ${orderByClause}"));
/* 75 */     answer.addElement(ifElement);
/*    */ 
/* 77 */     if (this.context.getPlugins().sqlMapSelectByExampleWithoutBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 80 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SelectByExampleWithoutBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */