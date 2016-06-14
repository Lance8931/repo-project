package com.chapter.tenth.innerclasses;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月6日下午3:34:52
 * @version 1.0
 */
public class OuterTest3 {
	class Inner {
		Inner() {
			System.out.println("create Inner");
		}

		public String toString() {
			return string;
		}
	}

	Inner getInner() {
		return new Inner();
	}

	private String string;

	public OuterTest3(String string) {
		this.string = string;
	}

	public static void main(String[] args) {
		OuterTest3 outerTest3 = new OuterTest3("你猜。");
		OuterTest3.Inner inner = outerTest3.getInner();
		System.out.println(inner.toString());
	}
}
