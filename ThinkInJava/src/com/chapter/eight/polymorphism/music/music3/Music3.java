package com.chapter.eight.polymorphism.music.music3;

import com.chapter.eight.polymorphism.music.Note;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午11:30:56
 * @version 1.0
 */
class Instrument {
	void play(Note n) {
		System.out.println("Instrument.play() " + n);
	}
}

class Wind extends Instrument {
	void play(Note n) {
		System.out.println("Wind.play() " + n);
	}

	String what() {
		return "Wind";
	}

	void adjust() {
		System.out.println("Adjust Wind");
	}
}

class Percussion extends Instrument {
	void play(Note n) {
		System.out.println("Percussion.play() " + n);
	}

	String what() {
		return "Percussion";
	}

	void adjust() {
		System.out.println("Adjust Percussion");
	}
}

class Stringed extends Instrument {
	void play(Note n) {
		System.out.println("Stringed.play() " + n);
	}

	String what() {
		return "Stringed";
	}

	void adjust() {
		System.out.println("Adjust Stringed");
	}
}

class Brass extends Wind {
	void play(Note n) {
		System.out.println("Brass.play() " + n);
	}

	void adjust() {
		System.out.println("Adjust Brass");
	}
}

class Woodwind extends Wind {
	void play(Note n) {
		System.out.println("Woodwind.play() " + n);
	}

	String what() {
		return "Woodwind";
	}

}

public class Music3 {
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
