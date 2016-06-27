package com.chapter.nine.interfaces.filters;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:23:55
 * @version 1.0
 */
public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
