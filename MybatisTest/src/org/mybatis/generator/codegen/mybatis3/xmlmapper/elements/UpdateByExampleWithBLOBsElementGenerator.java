/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
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
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
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
/* 46 */     answer.addAttribute(new Attribute("parameterType", "map"));
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
/* 64 */       sb.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*    */ 
/* 66 */       sb.append(" = ");
/* 67 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "record."));
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
/* 83 */     answer.addElement(getUpdateByExampleIncludeElement());
/*    */ 
/* 85 */     if (this.context.getPlugins().sqlMapUpdateByExampleWithBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 88 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */