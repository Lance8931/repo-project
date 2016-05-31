package com.springtest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月24日上午11:18:15
 * @version 1.0
 */
public class AnnoIoCTest {
	public static void main(String[] args) {
		String[] locations = { "beans.xml" };
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				locations);
		Boss boss = (Boss) ctx.getBean("boss");
		System.out.println(boss);
		ctx.destroy();
	}
}
