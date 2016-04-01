package com.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月1日下午2:09:28
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:context.xml");
		System.out.println("已成功发布RMI服务类");
	}
}
