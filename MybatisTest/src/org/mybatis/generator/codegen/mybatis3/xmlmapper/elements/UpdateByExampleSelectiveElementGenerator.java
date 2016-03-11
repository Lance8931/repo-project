/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
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
/* 44 */     answer.addAttribute(new Attribute("parameterType", "map"));
/*    */ 
/* 46 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     sb.append("update ");
/* 50 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 52 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 54 */     XmlElement dynamicElement = new XmlElement("set");
/* 55 */     answer.addElement(dynamicElement);
/*    */ 
/* 57 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getAllColumns())
/*    */     {
/* 59 */       XmlElement isNotNullElement = new XmlElement("if");
/* 60 */       sb.setLength(0);
/* 61 */       sb.append(introspectedColumn.getJavaProperty("record."));
/* 62 */       sb.append(" != null");
/* 63 */       isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
/* 64 */       dynamicElement.addElement(isNotNullElement);
/*    */ 
/* 66 */       sb.setLength(0);
/* 67 */       sb.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*    */ 
/* 69 */       sb.append(" = ");
/* 70 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "record."));
/*    */ 
/* 72 */       sb.append(',');
/*    */ 
/* 74 */       isNotNullElement.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 77 */     answer.addElement(getUpdateByExampleIncludeElement());
/*    */ 
/* 79 */     if (this.context.getPlugins().sqlMapUpdateByExampleSelectiveElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 82 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleSelectiveElementGenerator
 * JD-Core Version:    0.6.0
 */