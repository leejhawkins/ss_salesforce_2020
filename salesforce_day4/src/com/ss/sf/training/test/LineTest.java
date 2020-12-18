package com.ss.sf.training.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ss.sf.training.dayfour.Line;

public class LineTest {
	
	
	Line line1 = new Line(2,4,6,7);
	Line line2 = new Line(1,2,5,4);
	Line line3 = new Line(2,4,10,20);
	
	@Test
	public void getSlopeTest() {
		
		double test1 = .75;
		double test2 = .5;
		
		assertEquals( test1, line1.getSlope(),.0001);
		assertEquals(test2,line2.getSlope(),.0001);
	}
	
	@Test 
	public void getDistanceTest() {
		
		double test1 = 5;
		double test2 = 4.4721;
		assertEquals( test1, line1.getDistance(),.0001);
		assertEquals(test2,line2.getDistance(),.0001);
	}
	
	@Test
	public void parallelToTest() {
		
		assertEquals(false,line1.parallelTo(line2));
		assertEquals(false,line1.parallelTo(line3));
		assertEquals(false,line2.parallelTo(line3));
		
		
	}

}
