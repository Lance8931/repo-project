package com.chapter.seven;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午9:57:39
 * @version 1.0
 */

class SmallBrain {

}

final class Dinosaur {
	final int i = 7;
	int j = 1;
	SmallBrain x = new SmallBrain();

	void f() {
		System.out.println("i:" + i + ";  j:" + j);
	}
}

// class Further extends Dinosaur {
// }

public class Jurassic {
	public static void main(String[] args) {
		Dinosaur n = new Dinosaur();
		n.j++;
		// n.i = 40;
		n.f();
	}
}
