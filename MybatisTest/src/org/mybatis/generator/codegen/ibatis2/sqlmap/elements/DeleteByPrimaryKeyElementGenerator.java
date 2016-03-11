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
/*    */ import org.mybatis.generator.internal.rules.Rules;
/*    */ 
/*    */ public class DeleteByPrimaryKeyElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 38 */     XmlElement answer = new XmlElement("delete");
/*    */ 
/* 40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getDeleteByPrimaryKeyStatementId()));
/*    */     String parameterClass;
/* 43 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass())
/* 44 */       parameterClass = this.introspectedTable.getPrimaryKeyType();
/*    */     else {
/* 46 */       parameterClass = this.introspectedTable.getBaseRecordType();
/*    */     }
/* 48 */     answer.addAttribute(new Attribute("parameterClass", parameterClass));
/*    */ 
/* 51 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 53 */     StringBuilder sb = new StringBuilder();
/* 54 */     sb.append("delete from ");
/* 55 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/* 56 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 58 */     boolean and = false;
/* 59 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*    */     {
/* 61 */       sb.setLength(0);
/* 62 */       if (and) {
/* 63 */         sb.append("  and ");
/*    */       } else {
/* 65 */         sb.append("where ");
/* 66 */         and = true;
/*    */       }
/*    */ 
/* 69 */       sb.append(Ibatis2FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*    */ 
/* 71 */       sb.append(" = ");
/* 72 */       sb.append(Ibatis2FormattingUtilities.getParameterClause(introspectedColumn));
/*    */ 
/* 74 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 77 */     if (this.context.getPlugins().sqlMapDeleteByPrimaryKeyElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 80 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.DeleteByPrimaryKeyElementGenerator
 * JD-Core Version:    0.6.0
 */