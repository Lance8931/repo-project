package com.chapter.eight.polymorphism.music;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月30日上午10:45:37
 * @version 1.0
 */
public class Wind extends Instrument {
	public void play(Note n) {
		System.out.println("Wind.play() " + n);
	}
}
