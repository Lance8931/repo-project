package com.chapter.eight.polymorphism;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日下午3:08:18
 * @version 1.0
 */
class Grain {
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain {
	public String toString() {
		return "Wheat";
	}
}

class Mill {
	Grain process() {
		return new Grain();
	}
}

class WheatMill extends Mill {
	Wheat process() {
		return new Wheat();
	}
}

public class CovariantReturn {
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);
		m = new WheatMill();
		g = m.process();
		System.out.println(g);
	}
}
