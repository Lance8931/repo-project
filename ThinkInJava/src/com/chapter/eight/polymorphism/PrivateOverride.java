package com.chapter.eight.polymorphism;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:43:39
 * @version 1.0
 */
public class PrivateOverride {
	private void f() {
		System.out.println("PrivateOverride f()");
	}

	public static void main(String[] args) {
		PrivateOverride po = new Derived();
		po.f();
	}
}

class Derived extends PrivateOverride {
	public void f() {
		System.out.println("Derived f()");
	}
}
