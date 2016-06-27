package com.chapter.nine.interfaces.filters;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:26:54
 * @version 1.0
 */
public class HighPass extends Filter {
	double cutoff;

	public HighPass(double cutoff) {
		this.cutoff = cutoff;
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
