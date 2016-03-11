/*    */ package org.mybatis.generator.codegen.ibatis2.sqlmap.elements;
/*    */ 
/*    */ import org.mybatis.generator.api.IntrospectedColumn;
/*    */ import org.mybatis.generator.api.IntrospectedTable;
/*    */ import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
/*    */ import org.mybatis.generator.api.dom.xml.Attribute;
/*    */ import org.mybatis.generator.api.dom.xml.TextElement;
/*    */ import org.mybatis.generator.api.dom.xml.XmlElement;
/*    */ import org.mybatis.generator.codegen.AbstractGenerator;
/*    */ import org.mybatis.generator.config.GeneratedKey;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ public abstract class AbstractXmlElementGenerator extends AbstractGenerator
/*    */ {
/*    */   public abstract void addElements(XmlElement paramXmlElement);
/*    */ 
/*    */   protected XmlElement getSelectKey(IntrospectedColumn introspectedColumn, GeneratedKey generatedKey)
/*    */   {
/* 50 */     String identityColumnType = introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName();
/*    */ 
/* 53 */     XmlElement answer = new XmlElement("selectKey");
/* 54 */     answer.addAttribute(new Attribute("resultClass", identityColumnType));
/* 55 */     answer.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
/*    */ 
/* 57 */     if (StringUtility.stringHasValue(generatedKey.getType())) {
/* 58 */       answer.addAttribute(new Attribute("type", generatedKey.getType()));
/*    */     }
/* 60 */     answer.addElement(new TextElement(generatedKey.getRuntimeSqlStatement()));
/*    */ 
/* 64 */     return answer;
/*    */   }
/*    */ 
/*    */   protected XmlElement getBaseColumnListElement() {
/* 68 */     XmlElement answer = new XmlElement("include");
/* 69 */     answer.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getBaseColumnListId()));
/*    */ 
/* 72 */     return answer;
/*    */   }
/*    */ 
/*    */   protected XmlElement getBlobColumnListElement() {
/* 76 */     XmlElement answer = new XmlElement("include");
/* 77 */     answer.addAttribute(new Attribute("refid", this.introspectedTable.getIbatis2SqlMapNamespace() + "." + this.introspectedTable.getBlobColumnListId()));
/*    */ 
/* 80 */     return answer;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.codegen.ibatis2.sqlmap.elements.AbstractXmlElementGenerator
 * JD-Core Version:    0.6.0
 */