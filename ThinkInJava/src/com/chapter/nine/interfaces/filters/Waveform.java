package com.chapter.nine.interfaces.filters;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:22:31
 * @version 1.0
 */
public class Waveform {
	private static long counter;

	private final long id = counter++;

	public String toString() {
		return "Waveform " + id;
	}
}
