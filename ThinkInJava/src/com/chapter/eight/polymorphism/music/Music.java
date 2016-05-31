package com.chapter.eight.polymorphism.music;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午10:46:51
 * @version 1.0
 */
class Stringed extends Instrument {
	public void play(Note n) {
		System.out.println("Stringed.play() " + n);
	}
}

class Brass extends Instrument {
	public void play(Note n) {
		System.out.println("Brass.play() " + n);
	}
}

public class Music {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void main(String[] args) {
		Wind flute = new Wind();
		Stringed flute1 = new Stringed();
		Brass flute2 = new Brass();
		tune(flute);
		tune(flute1);
		tune(flute2);
	}
}
