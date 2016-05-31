package com.chapter.eight.polymorphism;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日下午3:28:08
 * @version 1.0
 */
class Actor {
	public void act() {
	}
}

class HappyActor extends Actor {
	public void act() {
		System.out.println("HappyAcotr.");
	}
}

class SadActor extends Actor {
	public void act() {
		System.out.println("SadActor.");
	}
}

class Stage {
	private Actor actor = new HappyActor();

	public void change() {
		actor = new SadActor();
	}

	public void performPlay() {
		actor.act();
	}
}

public class Transmogrify {
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
}
