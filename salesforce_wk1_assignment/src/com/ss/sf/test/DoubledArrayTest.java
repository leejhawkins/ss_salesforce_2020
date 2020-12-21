/**
 * 
 */
package com.ss.sf.test;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.ss.sf.week1.DoubledArray;

/**
 * @author leejh
 *
 */
public class DoubledArrayTest {
	
	int[] intArr1 = new int[] {23,67,89,102};
	int[] intArr2 = new int[] {1002,0,98,2009};
	int[] intArr3 = new int[] {23,67,89,102,965,965,968};
	
	@Test
	public void doubleArrayTest() {
		
		int[] test1 = new int[] {46,134,178,204};
		int[] test2 = new int[] {2004,0,196,4018};
		int[] test3 = new int[] {46,134,178,204,1930,1930,1936};
		assertEquals(Arrays.toString(test1),Arrays.toString(DoubledArray.doubled(intArr1)));
		assertEquals(Arrays.toString(test2),Arrays.toString(DoubledArray.doubled(intArr2)));
		assertEquals(Arrays.toString(test3),Arrays.toString(DoubledArray.doubled(intArr3)));
		
		
	}
	
	
	

}
