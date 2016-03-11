/*    */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.CommentGenerator;
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.Plugin;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.ibatis2.Ibatis2FormattingUtilities;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.internal.rules.Rules;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ public class ResultMapWithoutBLOBsElementGenerator extends AbstractXmlElementGenerator
/*    */ {
/*    */   public void addElements(XmlElement parentElement)
/*    */   {
/* 39 */     boolean useColumnIndex = StringUtility.isTrue(this.introspectedTable.getTableConfigurationProperty("useColumnIndexes"));
/*    */ 
/* 42 */     XmlElement answer = new XmlElement("resultMap");
/* 43 */     answer.addAttribute(new Attribute("id", this.introspectedTable.getBaseResultMapId()));
/*    */     String returnType;
/* 47 */     if (this.introspectedTable.getRules().generateBaseRecordClass())
/* 48 */       returnType = this.introspectedTable.getBaseRecordType();
/*    */     else {
/* 50 */       returnType = this.introspectedTable.getPrimaryKeyType();
/*    */     }
/*    */ 
/* 53 */     answer.addAttribute(new Attribute("class", returnType));
/*    */ 
/* 56 */     this.context.getCommentGenerator().addComment(answer);
/*    */ 
/* 58 */     int i = 1;
/* 59 */     if ((StringUtility.stringHasValue(this.introspectedTable.getSelectByPrimaryKeyQueryId())) || (StringUtility.stringHasValue(this.introspectedTable.getSelectByExampleQueryId())))
/*    */     {
/* 63 */       i++;
/*    */     }
/*    */ 
/* 66 */     for (IntrospectedColumn introspectedColumn : this.introspectedTable.getNonBLOBColumns())
/*    */     {
/* 68 */       XmlElement resultElement = new XmlElement("result");
/*    */ 
/* 70 */       if (useColumnIndex) {
/* 71 */         resultElement.addAttribute(new Attribute("columnIndex", Integer.toString(i++)));
/*    */       }
/*    */       else {
/* 74 */         resultElement.addAttribute(new Attribute("column", Ibatis2FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)));
/*    */       }
/*    */ 
/* 79 */       resultElement.addAttribute(new Attribute("property", introspectedColumn.getJavaProperty()));
/*    */ 
/* 81 */       resultElement.addAttribute(new Attribute("jdbcType", introspectedColumn.getJdbcTypeName()));
/*    */ 
/* 84 */       if (StringUtility.stringHasValue(introspectedColumn.getTypeHandler()))
/*    */       {
/* 86 */         resultElement.addAttribute(new Attribute("typeHandler", introspectedColumn.getTypeHandler()));
/*    */       }
/*    */ 
/* 90 */       answer.addElement(resultElement);
/*    */     }
/*    */ 
/* 93 */     if (this.context.getPlugins().sqlMapResultMapWithoutBLOBsElementGenerated(answer, this.introspectedTable))
/*    */     {
/* 96 */       parentElement.addElement(answer);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.ResultMapWithoutBLOBsElementGenerator
 * JD-Core Version:    0.6.0
 */