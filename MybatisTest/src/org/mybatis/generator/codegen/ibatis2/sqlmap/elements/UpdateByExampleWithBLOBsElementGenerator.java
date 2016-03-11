/*    */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.OutputUtilities;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*    */ import org.mybatis.generator.config.Context;
/*    */ 
/*    */ public class UpdateByExampleWithBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 41 */     XmlElement answer = new XmlElement("update");
/*    */ 
/* 43 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getUpdateByExampleWithBLOBsStatementId()));
/*    */ 
/* 47 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 49 */     StringBuilder sb = new StringBuilder();
/* 50 */     sb.append("update ");
/* 51 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 53 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 56 */     sb.setLength(0);
/* 57 */     sb.append("set ");
/*    */ 
/* 59 */     Iterator iter = this.introspectedTable.getAllColumns().iterator();
/*    */ 
/* 61 */     while (iter.hasNext()) {
/* 62 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*    */ 
/* 64 */       sb.append(Ibatis2FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*    */ 
/* 66 */       sb.append(" = ");
/* 67 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn, "record."));
/*    */ 
/* 70 */       if (iter.hasNext()) {
/* 71 */         sb.append(',');
/*    */       }
/*    */ 
/* 74 */       answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 77 */       if (iter.hasNext()) {
/* 78 */         sb.setLength(0);
/* 79 */         OutputUtilities.xmlIndent(sb, 1);
/*    */       }
/*    */     }
/*    */ 
/* 83 */     XmlElement isParameterPresentElement = new XmlElement("isParameterPresent");
/*    */ 
/* 85 */     answer.addElement(isParameterPresentElement);
/*    */ 
/* 87 */     XmlElement includeElement = new XmlElement("include");
/* 88 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getExampleWhereClauseId()));
/*    */ 
/* 91 */     isParameterPresentElement.addElement(includeElement);
/*    */ 
/* 93 */     if (this.context.getPlugins().sqlMapUpdateByExampleWithBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 96 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByExampleWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */