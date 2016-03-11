package org.mybatis.generator.util;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月11日下午2:04:15
 * @version 1.0
 */
public class LogFileUtil {
	
	public static void LogFileUtils(Date date,String className,String methodName){
		try {
			FileWriter writer = new FileWriter("D:\\logs\\Mybatis\\logs.txt",true);
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			writer.write("时间："+dateFormater.format(date)+"  类："+className+"   方法："+methodName+"\r\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
