package com.chapter.nine.interfaces.music5;

import com.chapter.eight.polymorphism.music.Note;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日下午3:47:38
 * @version 1.0
 */
interface Instrument {
	int VALUE = 5;// static & final

	public abstract void play(Note n);

	public abstract void adjust();
}

class Wind implements Instrument {
	public void play(Note n) {
		System.out.println("Wind.play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	public void adjust() {
		System.out.println("Adjust Wind");
	}
}

class Percussion implements Instrument {
	public void play(Note n) {
		System.out.println("Percussion.play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

	public void adjust() {
		System.out.println("Adjust Percussion");
	}
}

class Stringed implements Instrument {
	public void play(Note n) {
		System.out.println("Stringed.play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

	public void adjust() {

	}

}

class Brass extends Wind {
	public String toString() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	public String toString() {
		return "Woodwind";
	}

}

public class Music5 {
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
