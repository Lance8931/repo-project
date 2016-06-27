package com.chapter.nine.interfaces.filters;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:25:20
 * @version 1.0
 */
public class LowPass extends Filter {
	double cutoff;

	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
