package com.chapter.seven;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午10:10:24
 * @version 1.0
 */
class Insect {
	private int i = 9;
	protected int j;

	Insect() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	private static int x1 = printInit("static Insect.x1 initialized");

	static int printInit(String string) {
		System.out.println(string);
		return 47;
	}
}

public class Beetle extends Insect {
	private int k = printInit("Beetle.k initialized");

	public Beetle() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}

	private static int x2 = printInit("static Beetle.x2 initialized");

	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		// Beetle beetle = new Beetle();
		// 1.加载基类，初始化static域数值
		// 2.加载导出类，初始化static域数值
		// 3.运行导出类的main方法
		// 4.初始化Beetle的基类Insect，运行Insect的构造方法
		// 5.初始化Beetle，先初始化k，再运行Beetle的构造方法
	}
}
