/**
 * 
 */
package com.ss.sf.test;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.ss.sf.week1.NumberTesting;

/**
 * @author leejh
 *
 */
public class NumberTestingTest {
	
	int[][] intArr1 = {{1 , 2 , 3},{3 , 97, 98789}};
	int[][] intArr2 = {{3 , 2 , 3},{67865 , 1107, 1234554321}};
	
	@Test
	public void numTest() {
		
		String[] test1 = new String[] {"ODD","PRIME","PALINDROME"};
		String[] test2 = new String[] {"NOT PALINDROME","COMPOSITE","PALINDROME"};
		assertEquals(Arrays.toString(test1),Arrays.toString(NumberTesting.numTests(intArr1)));
		assertEquals(Arrays.toString(test2),Arrays.toString(NumberTesting.numTests(intArr2)));
		
		
		
	}
	
	
	

}
