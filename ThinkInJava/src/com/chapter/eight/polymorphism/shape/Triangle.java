package com.chapter.eight.polymorphism.shape;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:04:42
 * @version 1.0
 */
public class Triangle extends Shape {
	public void draw() {
		System.out.println("Triangle.draw()");
	}

	public void erase() {
		System.out.println("Triangle.erase()");
	}
}
