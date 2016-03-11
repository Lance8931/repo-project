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
/*    */ public class UpdateByExampleWithoutBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 41 */     XmlElement answer = new XmlElement("update");
/*    */ 
/* 43 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getUpdateByExampleStatementId()));
/*    */ 
/* 46 */     answer.addAttribute(new Attribute("parameterType", "map"));
/*    */ 
/* 48 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 50 */     StringBuilder sb = new StringBuilder();
/* 51 */     sb.append("update ");
/* 52 */     sb.append(this.introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
/*    */ 
/* 54 */     answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 57 */     sb.setLength(0);
/* 58 */     sb.append("set ");
/*    */ 
/* 60 */     Iterator iter = this.introspectedTable.getNonBLOBColumns().iterator();
/*    */ 
/* 62 */     while (iter.hasNext()) {
/* 63 */       IntrospectedColumn introspectedColumn = (IntrospectedColumn)iter.next();
/*    */ 
/* 65 */       sb.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
/*    */ 
/* 67 */       sb.append(" = ");
/* 68 */       sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "record."));
/*    */ 
/* 71 */       if (iter.hasNext()) {
/* 72 */         sb.append(',');
/*    */       }
/*    */ 
/* 75 */       answer.addElement(new TextElement(sb.toString()));
/*    */ 
/* 78 */       if (iter.hasNext()) {
/* 79 */         sb.setLength(0);
/* 80 */         OutputUtilities.xmlIndent(sb, 1);
/*    */       }
/*    */     }
/*    */ 
/* 84 */     answer.addElement(getUpdateByExampleIncludeElement());
/*    */ 
/* 86 */     if (this.context.getPlugins().sqlMapUpdateByExampleWithoutBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 89 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.UpdateByExampleWithoutBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */