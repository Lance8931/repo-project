/*    */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class UpdateByExampleSelectiveElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 38 */     XmlElement answer = new XmlElement("update");
/*    */ 
/* 40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getUpdateByExampleSelectiveStatementId()));
/*    */ 
/* 44 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 46 */     StringBuilder sb = new StringBuilder();
/*    */ 
/* 48 */     sb.append("update ");
/* 49 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 51 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 53 */     XmlElement dynamicElement = new XmlElement("dynamic");
/* 54 */     dynamicElement.addAttribute(new Attribute("prepend", "set"));
/* 55 */     answer.addElement(dynamicElement);
/*    */ 
/* 57 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getAllColumns())
/*    */     {
/* 59 */       XmlElement isNotNullElement = new XmlElement("isNotNull");
/* 60 */       isNotNullElement.addAttribute(new Attribute("prepend", ","));
/* 61 */       isNotNullElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty("record.")));
/*    */ 
/* 63 */       dynamicElement.addElement(isNotNullElement);
/*    */ 
/* 65 */       sb.setLength(0);
/* 66 */       sb.append(Ibatis2FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*    */ 
/* 68 */       sb.append(" = ");
/* 69 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn, "record."));
/*    */ 
/* 72 */       isNotNullElement.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 75 */     XmlElement isParameterPresentElement = new XmlElement("isParameterPresent");
/*    */ 
/* 77 */     answer.addElement(isParameterPresentElement);
/*    */ 
/* 79 */     XmlElement includeElement = new XmlElement("include");
/* 80 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getExampleWhereClauseId()));
/*    */ 
/* 83 */     isParameterPresentElement.addElement(includeElement);
/*    */ 
/* 85 */     if (this.context.getPlugins().sqlMapUpdateByExampleSelectiveElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 88 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByExampleSelectiveElementGenerator
 * JD-Core Version:    0.6.0
 */