/*     */ package org.mybatis.generator.config.xml;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.exception.XMLParserException;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.DocumentType;
/*     */ import org.w3c.dom.Element;
/*     */ import org.xml.sax.InputSource;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.SAXParseException;
/*     */ 
/*     */ public class ConfigurationParser
/*     */ {
/*     */   private List<String> warnings;
/*     */   private List<String> parseErrors;
/*     */   private Properties properties;
/*     */ 
/*     */   public ConfigurationParser(List<String> warnings)
/*     */   {
/*  48 */     this(null, warnings);
/*     */   }
/*     */ 
/*     */   public ConfigurationParser(Properties properties, List<String> warnings)
/*     */   {
/*  53 */     if (properties == null)
/*  54 */       this.properties = System.getProperties();
/*     */     else {
/*  56 */       this.properties = properties;
/*     */     }
/*     */ 
/*  59 */     if (warnings == null)
/*  60 */       this.warnings = new ArrayList();
/*     */     else {
/*  62 */       this.warnings = warnings;
/*     */     }
/*     */ 
/*  65 */     this.parseErrors = new ArrayList();
/*     */   }
/*     */ 
/*     */   public Configuration parseConfiguration(File inputFile)
/*     */     throws IOException, XMLParserException
/*     */   {
/*  71 */     FileReader fr = new FileReader(inputFile);
/*     */ 
/*  73 */     return parseConfiguration(fr);
/*     */   }
/*     */ 
/*     */   public Configuration parseConfiguration(Reader reader)
/*     */     throws IOException, XMLParserException
/*     */   {
/*  79 */     InputSource is = new InputSource(reader);
/*     */ 
/*  81 */     return parseConfiguration(is);
/*     */   }
/*     */ 
/*     */   public Configuration parseConfiguration(InputStream inputStream)
/*     */     throws IOException, XMLParserException
/*     */   {
/*  87 */     InputSource is = new InputSource(inputStream);
/*     */ 
/*  89 */     return parseConfiguration(is);
/*     */   }
/*     */ 
/*     */   private Configuration parseConfiguration(InputSource inputSource) throws IOException, XMLParserException
/*     */   {
/*  94 */     this.parseErrors.clear();
/*  95 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  96 */     factory.setValidating(true);
/*     */     try
/*     */     {
/*  99 */       DocumentBuilder builder = factory.newDocumentBuilder();
/* 100 */       builder.setEntityResolver(new ParserEntityResolver());
/*     */ 
/* 102 */       ParserErrorHandler handler = new ParserErrorHandler(this.warnings, this.parseErrors);
/*     */ 
/* 104 */       builder.setErrorHandler(handler);
/*     */ 
/* 106 */       Document document = null;
/*     */       try {
/* 108 */         document = builder.parse(inputSource);
/*     */       } catch (SAXParseException e) {
/* 110 */         throw new XMLParserException(this.parseErrors);
/*     */       } catch (SAXException e) {
/* 112 */         if (e.getException() == null)
/* 113 */           this.parseErrors.add(e.getMessage());
/*     */         else {
/* 115 */           this.parseErrors.add(e.getException().getMessage());
/*     */         }
/*     */       }
/*     */ 
/* 119 */       if (this.parseErrors.size() > 0) {
/* 120 */         throw new XMLParserException(this.parseErrors);
/*     */       }
/*     */ 
/* 124 */       Element rootNode = document.getDocumentElement();
/* 125 */       DocumentType docType = document.getDoctype();
/*     */       Configuration config;
/* 126 */       if ((rootNode.getNodeType() == 1) && (docType.getPublicId().equals("-//Apache Software Foundation//DTD Apache iBATIS Ibator Configuration 1.0//EN")))
/*     */       {
/* 129 */         config = parseIbatorConfiguration(rootNode);
/*     */       }
/*     */       else
/*     */       {
/* 130 */         if ((rootNode.getNodeType() == 1) && (docType.getPublicId().equals("-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN")))
/*     */         {
/* 133 */           config = parseMyBatisGeneratorConfiguration(rootNode);
/*     */         }
/* 135 */         else throw new XMLParserException(Messages.getString("RuntimeError.5"));
/*     */       }
/* 139 */       if (this.parseErrors.size() > 0) {
/* 140 */         throw new XMLParserException(this.parseErrors);
/*     */       }
/*     */ 
/* 143 */       return config;
/*     */     } catch (ParserConfigurationException e) {
/* 145 */       this.parseErrors.add(e.getMessage());
/* 146 */     }throw new XMLParserException(this.parseErrors);
/*     */   }
/*     */ 
/*     */   private Configuration parseIbatorConfiguration(Element rootNode)
/*     */     throws XMLParserException
/*     */   {
/* 152 */     IbatorConfigurationParser parser = new IbatorConfigurationParser(this.properties);
/*     */ 
/* 154 */     return parser.parseIbatorConfiguration(rootNode);
/*     */   }
/*     */ 
/*     */   private Configuration parseMyBatisGeneratorConfiguration(Element rootNode) throws XMLParserException
/*     */   {
/* 159 */     MyBatisGeneratorConfigurationParser parser = new MyBatisGeneratorConfigurationParser(this.properties);
/*     */ 
/* 161 */     return parser.parseConfiguration(rootNode);
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.config.xml.ConfigurationParser
 * JD-Core Version:    0.6.0
 */