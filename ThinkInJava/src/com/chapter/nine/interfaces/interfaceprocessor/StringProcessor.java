package com.chapter.nine.interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:38:25
 * @version 1.0
 */
public abstract class StringProcessor implements Processor {

	@Override
	public String name() {
		return getClass().getSimpleName();
	}

	public abstract Object process(Object input);

	public static String s = "If she weights the same as a duck, she's made of wood.";

	public static void main(String[] args) {
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
	}
}

class Upcase extends StringProcessor {
	@Override
	public Object process(Object input) {
		return ((String) input).toUpperCase();
	}
}

class Downcase extends StringProcessor {
	@Override
	public Object process(Object input) {
		return ((String) input).toLowerCase();
	}
}

class Splitter extends StringProcessor {
	@Override
	public Object process(Object input) {
		return Arrays.toString(((String) input).split(" "));
	}
}