package com.chapter.tenth.innerclasses;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月6日下午3:42:49
 * @version 1.0
 */
public class DotThis {

	public class Inner {
		public DotThis dotThis() {
			return DotThis.this;
		}
	}

	public Inner getInner() {
		return new Inner();
	}

	void f() {
		System.out.println("DotThis.f();");
	}

	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.getInner();
		dti.dotThis().f();
		OuterTest3.Inner inner = new OuterTest3("kkk").new Inner();
	}
}
