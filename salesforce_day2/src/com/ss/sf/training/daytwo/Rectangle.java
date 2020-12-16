package com.ss.sf.training.daytwo;

public class Rectangle implements Shape {
	float length;
	float width;
	
	public Rectangle(float length,float width) {
		
		this.length = length;
		this.width = width;
		
	}
	
	

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public double display() {
		// TODO Auto-generated method stub
		return 2*length + 2*width;
	}

}
