package com.springtest;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月24日上午11:15:19
 * @version 1.0
 */
public class Car {
	private String brand;
	private double price;

	@Override
	public String toString() {
		return "brand:" + brand + "," + "price:" + price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
