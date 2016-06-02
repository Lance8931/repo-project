package com.chapter.nine.interfaces.interfaceprocessor;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:32:16
 * @version 1.0
 */
public interface Processor {
	String name();

	Object process(Object input);
}
