/*     */ package org.mybatis.generator.internal;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.Method;
/*     */ import org.mybatis.generator.exception.ShellException;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.w3c.dom.Attr;
/*     */ import org.w3c.dom.CDATASection;
/*     */ import org.w3c.dom.Comment;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.DocumentType;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.EntityReference;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.ProcessingInstruction;
/*     */ import org.w3c.dom.Text;
/*     */ 
/*     */ public class DomWriter
/*     */ {
/*     */   protected PrintWriter printWriter;
/*     */   protected boolean isXML11;
/*     */ 
/*     */   public synchronized String toString(Document document)
/*     */     throws ShellException
/*     */   {
/*  56 */     StringWriter sw = new StringWriter();
/*  57 */     this.printWriter = new PrintWriter(sw);
/*  58 */     write(document);
/*  59 */     String s = sw.toString();
/*  60 */     return s;
/*     */   }
/*     */ 
/*     */   protected Attr[] sortAttributes(NamedNodeMap attrs)
/*     */   {
/*  66 */     int len = attrs != null ? attrs.getLength() : 0;
/*  67 */     Attr[] array = new Attr[len];
/*  68 */     for (int i = 0; i < len; i++) {
/*  69 */       array[i] = ((Attr)attrs.item(i));
/*     */     }
/*  71 */     for (int i = 0; i < len - 1; i++) {
/*  72 */       String name = array[i].getNodeName();
/*  73 */       int index = i;
/*  74 */       for (int j = i + 1; j < len; j++) {
/*  75 */         String curName = array[j].getNodeName();
/*  76 */         if (curName.compareTo(name) < 0) {
/*  77 */           name = curName;
/*  78 */           index = j;
/*     */         }
/*     */       }
/*  81 */       if (index != i) {
/*  82 */         Attr temp = array[i];
/*  83 */         array[i] = array[index];
/*  84 */         array[index] = temp;
/*     */       }
/*     */     }
/*     */ 
/*  88 */     return array;
/*     */   }
/*     */ 
/*     */   protected void normalizeAndPrint(String s, boolean isAttValue)
/*     */   {
/*  95 */     int len = s != null ? s.length() : 0;
/*  96 */     for (int i = 0; i < len; i++) {
/*  97 */       char c = s.charAt(i);
/*  98 */       normalizeAndPrint(c, isAttValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void normalizeAndPrint(char c, boolean isAttValue)
/*     */   {
/* 106 */     switch (c) {
/*     */     case '<':
/* 108 */       this.printWriter.print("&lt;");
/* 109 */       break;
/*     */     case '>':
/* 112 */       this.printWriter.print("&gt;");
/* 113 */       break;
/*     */     case '&':
/* 116 */       this.printWriter.print("&amp;");
/* 117 */       break;
/*     */     case '"':
/* 122 */       if (isAttValue)
/* 123 */         this.printWriter.print("&quot;");
/*     */       else {
/* 125 */         this.printWriter.print('"');
/*     */       }
/* 127 */       break;
/*     */     case '\r':
/* 134 */       this.printWriter.print("&#xD;");
/* 135 */       break;
/*     */     default:
/* 148 */       if (((this.isXML11) && (((c >= '\001') && (c <= '\037') && (c != '\t') && (c != '\n')) || ((c >= '') && (c <= '')) || (c == ' '))) || ((isAttValue) && ((c == '\t') || (c == '\n'))))
/*     */       {
/* 152 */         this.printWriter.print("&#x");
/* 153 */         this.printWriter.print(Integer.toHexString(c).toUpperCase());
/* 154 */         this.printWriter.print(';');
/*     */       } else {
/* 156 */         this.printWriter.print(c);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   protected String getVersion(Document document)
/*     */   {
/* 164 */     if (document == null) {
/* 165 */       return null;
/*     */     }
/* 167 */     String version = null;
/* 168 */     Method getXMLVersion = null;
/*     */     try {
/* 170 */       getXMLVersion = document.getClass().getMethod("getXmlVersion", new Class[0]);
/*     */ 
/* 173 */       if (getXMLVersion != null) {
/* 174 */         version = (String)getXMLVersion.invoke(document, (Object[])null);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 181 */     return version;
/*     */   }
/*     */ 
/*     */   protected void writeAnyNode(Node node) throws ShellException
/*     */   {
/* 186 */     if (node == null) {
/* 187 */       return;
/*     */     }
/*     */ 
/* 190 */     short type = node.getNodeType();
/* 191 */     switch (type) {
/*     */     case 9:
/* 193 */       write((Document)node);
/* 194 */       break;
/*     */     case 10:
/* 197 */       write((DocumentType)node);
/* 198 */       break;
/*     */     case 1:
/* 201 */       write((Element)node);
/* 202 */       break;
/*     */     case 5:
/* 205 */       write((EntityReference)node);
/* 206 */       break;
/*     */     case 4:
/* 209 */       write((CDATASection)node);
/* 210 */       break;
/*     */     case 3:
/* 213 */       write((Text)node);
/* 214 */       break;
/*     */     case 7:
/* 217 */       write((ProcessingInstruction)node);
/* 218 */       break;
/*     */     case 8:
/* 221 */       write((Comment)node);
/* 222 */       break;
/*     */     case 2:
/*     */     case 6:
/*     */     default:
/* 225 */       throw new ShellException(Messages.getString("RuntimeError.18", Short.toString(type)));
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void write(Document node) throws ShellException
/*     */   {
/* 231 */     this.isXML11 = "1.1".equals(getVersion(node));
/* 232 */     if (this.isXML11)
/* 233 */       this.printWriter.println("<?xml version=\"1.1\" encoding=\"UTF-8\"?>");
/*     */     else {
/* 235 */       this.printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/*     */     }
/* 237 */     this.printWriter.flush();
/* 238 */     write(node.getDoctype());
/* 239 */     write(node.getDocumentElement());
/*     */   }
/*     */ 
/*     */   protected void write(DocumentType node) throws ShellException {
/* 243 */     this.printWriter.print("<!DOCTYPE ");
/* 244 */     this.printWriter.print(node.getName());
/* 245 */     String publicId = node.getPublicId();
/* 246 */     String systemId = node.getSystemId();
/* 247 */     if (publicId != null) {
/* 248 */       this.printWriter.print(" PUBLIC \"");
/* 249 */       this.printWriter.print(publicId);
/* 250 */       this.printWriter.print("\" \"");
/* 251 */       this.printWriter.print(systemId);
/* 252 */       this.printWriter.print('"');
/* 253 */     } else if (systemId != null) {
/* 254 */       this.printWriter.print(" SYSTEM \"");
/* 255 */       this.printWriter.print(systemId);
/* 256 */       this.printWriter.print('"');
/*     */     }
/*     */ 
/* 259 */     String internalSubset = node.getInternalSubset();
/* 260 */     if (internalSubset != null) {
/* 261 */       this.printWriter.println(" [");
/* 262 */       this.printWriter.print(internalSubset);
/* 263 */       this.printWriter.print(']');
/*     */     }
/* 265 */     this.printWriter.println('>');
/*     */   }
/*     */ 
/*     */   protected void write(Element node) throws ShellException {
/* 269 */     this.printWriter.print('<');
/* 270 */     this.printWriter.print(node.getNodeName());
/* 271 */     Attr[] attrs = sortAttributes(node.getAttributes());
/* 272 */     for (Attr attr : attrs) {
/* 273 */       this.printWriter.print(' ');
/* 274 */       this.printWriter.print(attr.getNodeName());
/* 275 */       this.printWriter.print("=\"");
/* 276 */       normalizeAndPrint(attr.getNodeValue(), true);
/* 277 */       this.printWriter.print('"');
/*     */     }
/*     */ 
/* 280 */     if (node.getChildNodes().getLength() == 0) {
/* 281 */       this.printWriter.print(" />");
/* 282 */       this.printWriter.flush();
/*     */     } else {
/* 284 */       this.printWriter.print('>');
/* 285 */       this.printWriter.flush();
/*     */ 
/* 287 */       Node child = node.getFirstChild();
/* 288 */       while (child != null) {
/* 289 */         writeAnyNode(child);
/* 290 */         child = child.getNextSibling();
/*     */       }
/*     */ 
/* 293 */       this.printWriter.print("</");
/* 294 */       this.printWriter.print(node.getNodeName());
/* 295 */       this.printWriter.print('>');
/* 296 */       this.printWriter.flush();
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void write(EntityReference node) {
/* 301 */     this.printWriter.print('&');
/* 302 */     this.printWriter.print(node.getNodeName());
/* 303 */     this.printWriter.print(';');
/* 304 */     this.printWriter.flush();
/*     */   }
/*     */ 
/*     */   protected void write(CDATASection node) {
/* 308 */     this.printWriter.print("<![CDATA[");
/* 309 */     this.printWriter.print(node.getNodeValue());
/* 310 */     this.printWriter.print("]]>");
/* 311 */     this.printWriter.flush();
/*     */   }
/*     */ 
/*     */   protected void write(Text node) {
/* 315 */     normalizeAndPrint(node.getNodeValue(), false);
/* 316 */     this.printWriter.flush();
/*     */   }
/*     */ 
/*     */   protected void write(ProcessingInstruction node) {
/* 320 */     this.printWriter.print("<?");
/* 321 */     this.printWriter.print(node.getNodeName());
/* 322 */     String data = node.getNodeValue();
/* 323 */     if ((data != null) && (data.length() > 0)) {
/* 324 */       this.printWriter.print(' ');
/* 325 */       this.printWriter.print(data);
/*     */     }
/* 327 */     this.printWriter.print("?>");
/* 328 */     this.printWriter.flush();
/*     */   }
/*     */ 
/*     */   protected void write(Comment node) {
/* 332 */     this.printWriter.print("<!--");
/* 333 */     String comment = node.getNodeValue();
/* 334 */     if ((comment != null) && (comment.length() > 0)) {
/* 335 */       this.printWriter.print(comment);
/*     */     }
/* 337 */     this.printWriter.print("-->");
/* 338 */     this.printWriter.flush();
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.DomWriter
 * JD-Core Version:    0.6.0
 */