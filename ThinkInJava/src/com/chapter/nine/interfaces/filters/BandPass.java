package com.chapter.nine.interfaces.filters;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月2日下午2:28:25
 * @version 1.0
 */
public class BandPass {
	double lowCutoff, highCutoff;

	public BandPass(double lowCut, double highCut) {
		lowCutoff = lowCut;
		highCutoff = highCut;
	}

	public Waveform process(Waveform input) {
		return input;
	}
}
