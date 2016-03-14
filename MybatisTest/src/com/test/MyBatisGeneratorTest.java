package com.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.ant.AntProgressCallback;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月14日下午4:38:17
 * @version 1.0
 */
public class MyBatisGeneratorTest {

	/**
	 * 本地MyBatisGenerator代码使用
	 * 需要将配置文件generatorConfig.xml中的targetPackage改为项目下的包名路径
	 * targetProject改为项目的绝对路径
	 * 
	 * @param args
	 * @throws Exception
	 *
	 * @date 2016年3月14日下午5:08:28
	 * @author siping-L.J.H
	 */
	public static void main(String[] args) throws Exception {
	   List<String> warnings = new ArrayList<String>();
	   boolean overwrite = true;
	   File configFile = new File("D:\\code\\Git\\repo-project\\MybatisTest\\resource\\generatorConfig.xml");
	   ConfigurationParser cp = new ConfigurationParser(warnings);
	   Configuration config = cp.parseConfiguration(configFile);
	   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	   myBatisGenerator.generate(null);
	}

}
