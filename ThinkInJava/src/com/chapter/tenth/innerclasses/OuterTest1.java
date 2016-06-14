package com.chapter.tenth.innerclasses;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月6日下午3:19:18
 * @version 1.0
 */
public class OuterTest1 {
	class Inner {
		Inner() {
			System.out.println("create Inner");
		}
	}

	Inner getInner() {
		return new Inner();
	}

	public static void main(String[] args) {
		OuterTest1 outerTest1 = new OuterTest1();
		OuterTest1.Inner inner = outerTest1.getInner();
	}
}
