
package com.ss.sf.test;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import com.ss.sf.week1.SumClump;

/**
 * @author leejh
 *
 */

public class SumClumpTest {
	
	int[] intArr1 = new int[] {1,2,3,3,3,5,6};
	int[] intArr2 = new int[] {1,3,4,5,5,8};
	int[] intArr3 = new int[] {1,2,4,4,4,4,8,9};
	
	int target1 = 14;
	int target2 = 20;
	int target3 = 7;
	
	@Test
	public void sumClumpTest() {
		
		
		assertTrue(SumClump.sumClump(0,intArr1,target1));
		assertFalse(SumClump.sumClump(0, intArr2, target2));
		assertFalse(SumClump.sumClump(0,intArr3,target3));
		
	}

}
