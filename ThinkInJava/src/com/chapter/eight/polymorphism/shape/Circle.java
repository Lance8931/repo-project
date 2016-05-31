package com.chapter.eight.polymorphism.shape;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:04:42
 * @version 1.0
 */
public class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Circle.draw()");
	}

	public void erase() {
		System.out.println("Circle.erase()");
	}

	public void method1() {
		System.out.println("Circle.method1()");
	}
}
