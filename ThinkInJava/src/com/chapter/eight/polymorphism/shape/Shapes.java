package com.chapter.eight.polymorphism.shape;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:09:27
 * @version 1.0
 */
public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();

	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next();
		}
		for (Shape shape : s) {
			shape.draw();
			shape.method1();
		}
	}
}
