package com.chapter.nine.interfaces;


/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午3:37:33
 * @version 1.0
 */
public class TestFourteen {

	public static void printInterOne(InterOne one) {
		System.out.println(one.getClass().getSuperclass().getSimpleName());
	}

	public static void printInterTwo(InterTwo two) {
		System.out.println(two.getClass().getSuperclass().getSimpleName());
	}

	public static void printInterThree(InterThree three) {
		System.out.println(three.getClass().getSuperclass().getSimpleName());
	}

	public static void printInterFour(InterFour four) {
		System.out.println(four.getClass().getSuperclass().getSimpleName());
	}

	public static void main(String[] args) {
		ClassTwo two = new ClassTwo();
		printInterOne(two);
		printInterTwo(two);
		printInterThree(two);
		printInterFour(two);
	}
}

interface InterOne {
	void methodOne1();

	void methodOne2();
}

interface InterTwo {
	void methodTwo1();

	void methodTwo2();
}

interface InterThree {
	void methodThree1();

	void methodThree2();
}

interface InterFour extends InterOne, InterTwo, InterThree {
	void methodFour1();
}

class ClassOne {
	public void kkkk() {
		System.out.println("ClassOne.kkk()");
	}
}

class ClassTwo extends ClassOne implements InterFour {

	@Override
	public void methodOne1() {
	}

	@Override
	public void methodOne2() {
	}

	@Override
	public void methodTwo1() {
	}

	@Override
	public void methodTwo2() {
	}

	@Override
	public void methodThree1() {
	}

	@Override
	public void methodThree2() {
	}

	@Override
	public void methodFour1() {
	}
}