package com.chapter.tenth.innerclasses;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月6日下午3:23:44
 * @version 1.0
 */
public class Test2 {
	private String string;

	public String toString() {
		return "输出：" + string;
	}

	public Test2(String i) {
		this.string = i;
	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence(5);
		Test2 test2 = null;
		for (int i = 0; i < 5; i++) {
			test2 = new Test2(Integer.valueOf(i).toString());
			sequence.add(test2);
		}
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.println(selector.current().toString());
			selector.next();
		}
	}
}
