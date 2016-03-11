/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
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
/* 43 */     if (this.introspectedTable.getRules().generatePrimaryKeyClass()) {
/* 44 */       parameterClass = this.introspectedTable.getPrimaryKeyType();
/*    */     }
/*    */     else
/*    */     {
/* 48 */       if (this.introspectedTable.getPrimaryKeyColumns().size() > 1)
/* 49 */         parameterClass = "map";
/*    */       else {
/* 51 */         parameterClass = ((IntrospectedColumn)this.introspectedTable.getPrimaryKeyColumns().get(0)).getFullyQualifiedJavaType().toString();
/*    */       }
/*    */     }
/*    */ 
/* 55 */     answer.addAttribute(new Attribute("parameterType", parameterClass));
/*    */ 
/* 58 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 60 */     StringBuilder sb = new StringBuilder();
/* 61 */     sb.append("delete from ");
/* 62 */     sb.append(this.introspectedTable.getFullyQualifiedTableNameAtRuntime());
/* 63 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 65 */     boolean and = false;
/* 66 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getPrimaryKeyColumns())
/*    */     {
/* 68 */       sb.setLength(0);
/* 69 */       if (and) {
/* 70 */         sb.append("  and ");
/*    */       } else {
/* 72 */         sb.append("where ");
/* 73 */         and = true;
/*    */       }
/*    */ 
/* 76 */       sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
/*    */ 
/* 78 */       sb.append(" = ");
/* 79 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
/*    */ 
/* 81 */       answer.addElement(new TextElement(sb.toString()));
/*    */     }
/*    */ 
/* 84 */     if (this.context.getPlugins().sqlMapDeleteByPrimaryKeyElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 87 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.DeleteByPrimaryKeyElementGenerator
 * JD-Core Version:    0.6.0
 */