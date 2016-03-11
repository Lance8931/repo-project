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
/*    */ public class UpdateByExampleWithoutBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 41 */     XmlElement answer = new XmlElement("update");
/*    */ 
/* 43 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getUpdateByExampleStatementId()));
/*    */ 
/* 46 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     sb.append("update ");
/* 50 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 52 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 55 */     sb.setLength(0);
/* 56 */     sb.append("set ");
/*    */ 
/* 58 */     Iterator iter = this.introspectedTable.getNonBLOBColumns().iterator();
/*    */ 
/* 60 */     while (iter.hasNext()) {
/* 61 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*    */ 
/* 63 */       sb.append(Ibatis2FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*    */ 
/* 65 */       sb.append(" = ");
/* 66 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn, "record."));
/*    */ 
/* 69 */       if (iter.hasNext()) {
/* 70 */         sb.append(',');
/*    */       }
/*    */ 
/* 73 */       answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 76 */       if (iter.hasNext()) {
/* 77 */         sb.setLength(0);
/* 78 */         OutputUtilities.xmlIndent(sb, 1);
/*    */       }
/*    */     }
/*    */ 
/* 82 */     XmlElement isParameterPresentElement = new XmlElement("isParameterPresent");
/*    */ 
/* 84 */     answer.addElement(isParameterPresentElement);
/*    */ 
/* 86 */     XmlElement includeElement = new XmlElement("include");
/* 87 */     includeElement.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getExampleWhereClauseId()));
/*    */ 
/* 90 */     isParameterPresentElement.addElement(includeElement);
/*    */ 
/* 92 */     if (this.context.getPlugins().sqlMapUpdateByExampleWithoutBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 95 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.UpdateByExampleWithoutBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */