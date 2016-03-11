/*    */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class CountByExampleElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 35 */     XmlElement answer = new XmlElement("select");
/*    */ 
/* 37 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getCountByExampleStatementId()));
/*    */ 
/* 39 */     answer.addAttribute(new Attribute("parameterClass", this.introspectedTable.getExampleType()));
/*    */ 
/* 41 */     answer.addAttribute(new Attribute("resultClass", "java.lang.Integer"));
/*    */ 
/* 43 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 45 */     StringBuilder sb = new StringBuilder();
/* 46 */     sb.append("select count(*) from ");
/* 47 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 49 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 51 */     XmlElement includeElement = new XmlElement("include");
/* 52 */     sb.setLength(0);
/* 53 */     sb.append(this.introspectedTable.getIbatis2SqlMapNamespace());
/* 54 */     sb.append('.');
/* 55 */     sb.append(this.introspectedTable.getExampleWhereClauseId());
/* 56 */     includeElement.addAttribute(new Attribute("refid", sb.toString()));
/*    */ 
/* 59 */     answer.addElement(includeElement);
/*    */ 
/* 61 */     if (this.context.getPlugins().sqlMapCountByExampleElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 63 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.CountByExampleElementGenerator
 * JD-Core Version:    0.6.0
 */