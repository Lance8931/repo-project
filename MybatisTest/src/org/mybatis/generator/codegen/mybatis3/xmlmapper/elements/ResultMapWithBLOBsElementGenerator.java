/*    */ package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.rules.Rules;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ public class ResultMapWithBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 38 */     XmlElement answer = new XmlElement("resultMap");
/*    */ 
/* 40 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getResultMapWithBLOBsId()));
/*    */     String returnType;
/* 44 */     if (this.introspectedTable.getRules().generateRecordWithBLOBsClass()) {
/* 45 */       returnType = this.introspectedTable.getRecordWithBLOBsType();
/*    */     }
/*    */     else
/*    */     {
/* 49 */       returnType = this.introspectedTable.getBaseRecordType();
/*    */     }
/*    */ 
/* 52 */     answer.addAttribute(new Attribute("type", returnType));
/*    */ 
/* 55 */     answer.addAttribute(new Attribute("extends", this.introspectedTable.getBaseResultMapId()));
/*    */ 
/* 58 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 60 */     int i = this.introspectedTable.getNonBLOBColumnCount() + 1;
/* 61 */     if ((StringUtility.stringHasValue(this.introspectedTable.getSelectByPrimaryKeyQueryId())) || (StringUtility.stringHasValue(this.introspectedTable.getSelectByExampleQueryId())))
/*    */     {
/* 65 */       i++;
/*    */     }
/*    */ 
/* 68 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getBLOBColumns())
/*    */     {
/* 70 */       XmlElement resultElement = new XmlElement("result");
/*    */ 
/* 72 */       resultElement.addAttribute(new Attribute("column", MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/*    */ 
/* 75 */       resultElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*    */ 
/* 77 */       resultElement.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));
/*    */ 
/* 80 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*    */       {
/* 82 */         resultElement.addAttribute(new Attribute("typeHandler", introspectedColumn.getTypeHandler()));
/*    */       }
/*    */ 
/* 86 */       answer.addElement(resultElement);
/*    */     }
/*    */ 
/* 89 */     if (this.context.getPlugins().sqlMapResultMapWithBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 92 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.ResultMapWithBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */