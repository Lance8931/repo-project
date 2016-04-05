package com.activiti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月5日上午11:27:41
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-activiti.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class BaseTestCase extends AbstractJUnit4SpringContextTests {

	/**
	 * 使用配置文件spring-activiti.xml创建Activiti数据库的表
	 * 
	 *
	 * @date 2016年4月5日上午11:45:23
	 * @author siping-L.J.H
	 */
	@Test
	public void test() {
		System.out.println("test");
	}
}
