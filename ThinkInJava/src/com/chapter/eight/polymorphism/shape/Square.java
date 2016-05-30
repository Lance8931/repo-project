package com.chapter.eight.polymorphism.shape;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:04:42
 * @version 1.0
 */
public class Square extends Shape {
	public void draw() {
		System.out.println("Square.draw()");
	}

	public void erase() {
		System.out.println("Square.erase()");
	}
}
