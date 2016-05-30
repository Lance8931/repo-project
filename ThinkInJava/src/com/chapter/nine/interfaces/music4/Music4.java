package com.chapter.nine.interfaces.music4;

import com.chapter.eight.polymorphism.music.Note;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日下午3:47:38
 * @version 1.0
 */
abstract class Instrument {
	private int i;

	public abstract void play(Note n);

	public String what() {
		return "Instrument";
	}

	public abstract void adjust();
}

class Wind extends Instrument {
	public void play(Note n) {
		System.out.println("Wind.play() " + n);
	}

	public String what() {
		return "Wind";
	}

	public void adjust() {
		System.out.println("Adjust Wind");
	}
}

class Percussion extends Instrument {
	public void play(Note n) {
		System.out.println("Percussion.play() " + n);
	}

	public String what() {
		return "Percussion";
	}

	public void adjust() {
		System.out.println("Adjust Percussion");
	}
}

class Stringed extends Instrument {
	public void play(Note n) {
		System.out.println("Stringed.play() " + n);
	}

	public String what() {
		return "Stringed";
	}

	public void adjust() {

	}

}

class Brass extends Wind {
	public void play(Note n) {
		System.out.println("Brass.play() " + n);
	}

	public void adjust() {
		System.out.println("Adjust Brass");
	}
}

class Woodwind extends Wind {
	public void play(Note n) {
		System.out.println("Woodwind.play() " + n);
	}

	public String what() {
		return "Woodwind";
	}

}

public class Music4 {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void tuneAll(Instrument[] i) {
		for (Instrument instrument : i) {
			tune(instrument);
		}
	}

	public static void main(String[] args) {
		Instrument[] orchestra = { new Wind(), new Percussion(),
				new Stringed(), new Brass(), new Woodwind() };
		tuneAll(orchestra);
	}
}
