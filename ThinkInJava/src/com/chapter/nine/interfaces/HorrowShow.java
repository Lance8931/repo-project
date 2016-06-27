package com.chapter.nine.interfaces;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午3:24:44
 * @version 1.0
 */
public class HorrowShow {
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	static void w(Lethal l) {
		l.kill();
	}

	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);

	}
}

interface Monster {
	void menace();// 威胁
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {// 致命的
	void kill();
}

class DragonZilla implements DangerousMonster {

	@Override
	public void menace() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class VeryBadVampire implements Vampire {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void menace() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void drinkBlood() {
		// TODO Auto-generated method stub

	}

}