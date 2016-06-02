package com.chapter.nine.interfaces.interfaceprocessor;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:32:54
 * @version 1.0
 */
public class Apply {
	public static void process(Processor p, Object s) {
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
	}
}
