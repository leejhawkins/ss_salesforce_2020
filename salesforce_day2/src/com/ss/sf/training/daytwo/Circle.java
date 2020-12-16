package com.ss.sf.training.daytwo;

public class Circle implements Shape {
	
	private float radius;
	
	public Circle(float radius) {
		
		this.radius = radius;
		
	}
	
	

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return 3.14*radius*radius
		;
	}

	@Override
	public double display() {
		//Calculate perimeter 
		// TODO Auto-generated method stub
		return 2*3.14*radius;
	}

}
