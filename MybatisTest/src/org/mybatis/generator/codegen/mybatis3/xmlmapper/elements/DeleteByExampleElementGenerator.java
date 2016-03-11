/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class DeleteByExampleElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 36 */     XmlElement answer = new XmlElement("delete");
/*    */ 
/* 38 */     String fqjt = this.introspectedTable.getExampleType();
/*    */ 
/* 40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getDeleteByExampleStatementId()));
/*    */ 
/* 42 */     answer.addAttribute(new Attribute("parameterType", fqjt));
/*    */ 
/* 44 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 46 */     StringBuilder sb = new StringBuilder();
/* 47 */     sb.append("delete from ");
/* 48 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 50 */     answer.addElement(new TextElement(sb.toString()));
/* 51 */     answer.addElement(getExampleIncludeElement());
/*    */ 
/* 53 */     if (this.context.getPlugins().sqlMapDeleteByExampleElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 55 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.DeleteByExampleElementGenerator
 * JD-Core Version:    0.6.0
 */