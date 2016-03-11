/*     */ package org.mybatis.generator.api;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.xml.ConfigurationParser;
/*     */ import org.mybatis.generator.exception.InvalidConfigurationException;
/*     */ import org.mybatis.generator.exception.XMLParserException;
/*     */ import org.mybatis.generator.internal.DefaultShellCallback;
/*     */ import org.mybatis.generator.internal.util.messages.Messages;
/*     */ import org.mybatis.generator.logging.LogFactory;
/*     */ 
/*     */ public class ShellRunner
/*     */ {
/*     */   private static final String CONFIG_FILE = "-configfile";
/*     */   private static final String OVERWRITE = "-overwrite";
/*     */   private static final String CONTEXT_IDS = "-contextids";
/*     */   private static final String TABLES = "-tables";
/*     */   private static final String VERBOSE = "-verbose";
/*     */   private static final String FORCE_JAVA_LOGGING = "-forceJavaLogging";
/*     */   private static final String HELP_1 = "-?";
/*     */   private static final String HELP_2 = "-h";
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  53 */     if (args.length == 0) {
/*  54 */       usage();
/*  55 */       System.exit(0);
/*  56 */       return;
/*     */     }
/*     */ 
/*  59 */     Map arguments = parseCommandLine(args);
/*     */ 
/*  61 */     if (arguments.containsKey("-?")) {
/*  62 */       usage();
/*  63 */       System.exit(0);
/*  64 */       return;
/*     */     }
/*     */ 
/*  67 */     if (!arguments.containsKey("-configfile")) {
/*  68 */       writeLine(Messages.getString("RuntimeError.0"));
/*  69 */       return;
/*     */     }
/*     */ 
/*  72 */     List<String> warnings = new ArrayList<String>();
/*     */ 
/*  74 */     String configfile = (String)arguments.get("-configfile");
/*  75 */     File configurationFile = new File(configfile);
/*  76 */     if (!configurationFile.exists()) {
/*  77 */       writeLine(Messages.getString("RuntimeError.1", configfile));
/*  78 */       return;
/*     */     }
/*     */ 
/*  81 */     Set fullyqualifiedTables = new HashSet();
/*  82 */     if (arguments.containsKey("-tables")) {
/*  83 */       StringTokenizer st = new StringTokenizer((String)arguments.get("-tables"), ",");
/*  84 */       while (st.hasMoreTokens()) {
/*  85 */         String s = st.nextToken().trim();
/*  86 */         if (s.length() > 0) {
/*  87 */           fullyqualifiedTables.add(s);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  92 */     Set contexts = new HashSet();
/*  93 */     if (arguments.containsKey("-contextids")) {
/*  94 */       StringTokenizer st = new StringTokenizer((String)arguments.get("-contextids"), ",");
/*     */ 
/*  96 */       while (st.hasMoreTokens()) {
/*  97 */         String s = st.nextToken().trim();
/*  98 */         if (s.length() > 0) {
/*  99 */           contexts.add(s);
/*     */         }
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 105 */       ConfigurationParser cp = new ConfigurationParser(warnings);
/* 106 */       Configuration config = cp.parseConfiguration(configurationFile);
/*     */ 
/* 108 */       DefaultShellCallback shellCallback = new DefaultShellCallback(arguments.containsKey("-overwrite"));
/*     */ 
/* 111 */       MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
/*     */ 
/* 113 */       ProgressCallback progressCallback = arguments.containsKey("-verbose") ? new VerboseProgressCallback() : null;
/*     */ 
/* 116 */       myBatisGenerator.generate(progressCallback, contexts, fullyqualifiedTables);
/*     */     }
/*     */     catch (XMLParserException e) {
/* 119 */       writeLine(Messages.getString("Progress.3"));
/* 120 */       writeLine();
/* 121 */       for (String error : e.getErrors()) {
/* 122 */         writeLine(error);
/*     */       }
/*     */ 
/* 125 */       return;
/*     */     } catch (SQLException e) {
/* 127 */       e.printStackTrace();
/* 128 */       return;
/*     */     } catch (IOException e) {
/* 130 */       e.printStackTrace();
/* 131 */       return;
/*     */     } catch (InvalidConfigurationException e) {
/* 133 */       writeLine(Messages.getString("Progress.16"));
/* 134 */       for (String error : e.getErrors()) {
/* 135 */         writeLine(error);
/*     */       }
/* 137 */       return;
/*     */     }
/*     */     catch (InterruptedException e)
/*     */     {
/*     */     }
/*     */ 
/* 143 */     for (String warning : warnings) {
/* 144 */       writeLine(warning);
/*     */     }
/*     */ 
/* 147 */     if (warnings.size() == 0) {
/* 148 */       writeLine(Messages.getString("Progress.4"));
/*     */     } else {
/* 150 */       writeLine();
/* 151 */       writeLine(Messages.getString("Progress.5"));
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void usage() {
/* 156 */     String lines = Messages.getString("Usage.Lines");
/* 157 */     int iLines = Integer.parseInt(lines);
/* 158 */     for (int i = 0; i < iLines; i++) {
/* 159 */       String key = "Usage." + i;
/* 160 */       writeLine(Messages.getString(key));
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void writeLine(String message) {
/* 165 */     System.out.println(message);
/*     */   }
/*     */ 
/*     */   private static void writeLine() {
/* 169 */     System.out.println();
/*     */   }
/*     */ 
/*     */   private static Map<String, String> parseCommandLine(String[] args) {
/* 173 */     List<String> errors = new ArrayList<String>();
/* 174 */     Map arguments = new HashMap();
/*     */ 
/* 176 */     for (int i = 0; i < args.length; i++) {
/* 177 */       if ("-configfile".equalsIgnoreCase(args[i])) {
/* 178 */         if (i + 1 < args.length)
/* 179 */           arguments.put("-configfile", args[(i + 1)]);
/*     */         else {
/* 181 */           errors.add(Messages.getString("RuntimeError.19", "-configfile"));
/*     */         }
/*     */ 
/* 184 */         i++;
/* 185 */       } else if ("-overwrite".equalsIgnoreCase(args[i])) {
/* 186 */         arguments.put("-overwrite", "Y");
/* 187 */       } else if ("-verbose".equalsIgnoreCase(args[i])) {
/* 188 */         arguments.put("-verbose", "Y");
/* 189 */       } else if ("-?".equalsIgnoreCase(args[i])) {
/* 190 */         arguments.put("-?", "Y");
/* 191 */       } else if ("-h".equalsIgnoreCase(args[i]))
/*     */       {
/* 194 */         arguments.put("-?", "Y");
/* 195 */       } else if ("-forceJavaLogging".equalsIgnoreCase(args[i])) {
/* 196 */         LogFactory.forceJavaLogging();
/* 197 */       } else if ("-contextids".equalsIgnoreCase(args[i])) {
/* 198 */         if (i + 1 < args.length)
/* 199 */           arguments.put("-contextids", args[(i + 1)]);
/*     */         else {
/* 201 */           errors.add(Messages.getString("RuntimeError.19", "-contextids"));
/*     */         }
/*     */ 
/* 204 */         i++;
/* 205 */       } else if ("-tables".equalsIgnoreCase(args[i])) {
/* 206 */         if (i + 1 < args.length)
/* 207 */           arguments.put("-tables", args[(i + 1)]);
/*     */         else {
/* 209 */           errors.add(Messages.getString("RuntimeError.19", "-tables"));
/*     */         }
/* 211 */         i++;
/*     */       } else {
/* 213 */         errors.add(Messages.getString("RuntimeError.20", args[i]));
/*     */       }
/*     */     }
/*     */ 
/* 217 */     if (!errors.isEmpty()) {
/* 218 */       for (String error : errors) {
/* 219 */         writeLine(error);
/*     */       }
/*     */ 
/* 222 */       System.exit(-1);
/*     */     }
/*     */ 
/* 225 */     return arguments;
/*     */   }
/*     */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.api.ShellRunner
 * JD-Core Version:    0.6.0
 */