/*    */ package org.mybatis.generator.internal.db;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.Driver;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Properties;
/*    */ import org.mybatis.generator.config.JDBCConnectionConfiguration;
/*    */ import org.mybatis.generator.internal.ObjectFactory;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ import org.mybatis.generator.internal.util.messages.Messages;
/*    */ 
/*    */ public class ConnectionFactory
/*    */ {
/* 38 */   private static ConnectionFactory instance = new ConnectionFactory();
/*    */ 
/*    */   public static ConnectionFactory getInstance() {
/* 41 */     return instance;
/*    */   }
/*    */ 
/*    */   public Connection getConnection(JDBCConnectionConfiguration config)
/*    */     throws SQLException
/*    */   {
/* 53 */     Driver driver = getDriver(config);
/*    */ 
/* 55 */     Properties props = new Properties();
/*    */ 
/* 57 */     if (StringUtility.stringHasValue(config.getUserId())) {
/* 58 */       props.setProperty("user", config.getUserId());
/*    */     }
/*    */ 
/* 61 */     if (StringUtility.stringHasValue(config.getPassword())) {
/* 62 */       props.setProperty("password", config.getPassword());
/*    */     }
/*    */ 
/* 65 */     props.putAll(config.getProperties());
/*    */ 
/* 67 */     Connection conn = driver.connect(config.getConnectionURL(), props);
/*    */ 
/* 69 */     if (conn == null) {
/* 70 */       throw new SQLException(Messages.getString("RuntimeError.7"));
/*    */     }
/*    */ 
/* 73 */     return conn;
/*    */   }
/*    */ 
/* 77 */   private Driver getDriver(JDBCConnectionConfiguration connectionInformation) { String driverClass = connectionInformation.getDriverClass();
/*    */     Driver driver;
/*    */     try {
/* 81 */       Class clazz = ObjectFactory.externalClassForName(driverClass);
/* 82 */       driver = (Driver)clazz.newInstance();
/*    */     } catch (Exception e) {
/* 84 */       throw new RuntimeException(Messages.getString("RuntimeError.8"), e);
/*    */     }
/*    */ 
/* 87 */     return driver;
/*    */   }
/*    */ }

/* Location:           C:\Users\sipingsoft-LILU.LJH\Desktop\mybatis-generator-core-1.3.0.jar
 * Qualified Name:     org.mybatis.generator.internal.db.ConnectionFactory
 * JD-Core Version:    0.6.0
 */