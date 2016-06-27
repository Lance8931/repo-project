package com.chapter.tenth.innerclasses;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年6月6日下午5:28:30
 * @version 1.0
 */
class Parcel4 {
	private class PContents implements Contents {
		private int i = 11;

		@Override
		public int value() {
			return i;
		}

	}

	protected class PDestination implements Destination {
		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		@Override
		public String readLabel() {
			return label;
		}
	}

	public PDestination destination(String s) {
		return new PDestination(s);
	}

	public PContents contents() {
		return new PContents();
	}
}

public class TestParcel {
	public static void main(String[] args) {

		Parcel4 parcel4 = new Parcel4();
		Contents contents = parcel4.contents();
		Destination destination = parcel4.destination("sdfsdf");
		// Parcel4.PDestination pDestination = parcel4.new PDestination();
	}
}
