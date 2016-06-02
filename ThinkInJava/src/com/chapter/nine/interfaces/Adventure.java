package com.chapter.nine.interfaces;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午3:01:57
 * @version 1.0
 */
public class Adventure {
	public static void t(CanFight x) {
		x.fight();
	}

	public static void u(CanSwim x) {
		x.swim();
	}

	public static void v(CanFly x) {
		x.fly();
	}

	public static void w(ActionCharacter x) {
		x.fight();
	}

	public static void main(String[] args) {
		Hero hero = new Hero();
		t(hero);
		u(hero);
		v(hero);
		w(hero);

	}
}

interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight() {
	}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

	@Override
	public void fly() {

	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub

	}
}