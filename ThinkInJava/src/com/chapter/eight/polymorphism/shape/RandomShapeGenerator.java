package com.chapter.eight.polymorphism.shape;

import java.util.Random;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:07:17
 * @version 1.0
 */
public class RandomShapeGenerator {
	private Random random = new Random(47);

	public Shape next() {
		switch (random.nextInt(3)) {
		default:
		case 0:
			return new Circle();
		case 1:
			return new Square();
		case 2:
			return new Triangle();
		}
	}
}
