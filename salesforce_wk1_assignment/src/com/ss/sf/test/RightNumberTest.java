
package com.ss.sf.test;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.ss.sf.week1.RightNumber;

/**
 * @author leejh
 *
 */
public class RightNumberTest {
	
	int[] intArr1 = new int[] {234,675,89,1020};
	int[] intArr2 = new int[] {1002,0,98,2009};
	int[] intArr3 = new int[] {23,67,89,102,965,965,968};
	
	@Test
	public void rightNumberTest() {
		
		int[] test1 = new int[] {4,5,9,0};
		int[] test2 = new int[] {2,0,8,9};
		int[] test3 = new int[] {3,7,9,2,5,5,8};
		assertEquals(Arrays.toString(test1),Arrays.toString(RightNumber.rightNumber(intArr1)));
		assertEquals(Arrays.toString(test2),Arrays.toString(RightNumber.rightNumber(intArr2)));
		assertEquals(Arrays.toString(test3),Arrays.toString(RightNumber.rightNumber(intArr3)));
		
		
	}
	
	
	

}
