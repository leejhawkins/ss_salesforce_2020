package com.ss.sf.training.daytwo;

public class Triangle implements Shape {
	
	double base;
	double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return .5*base*height;
	}

	@Override
	public double display() {
		// TODO Auto-generated method stub
		return .5*base*height;
	}

}
