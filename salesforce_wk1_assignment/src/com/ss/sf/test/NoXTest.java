package com.ss.sf.test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import com.ss.sf.week1.NoX;


public class NoXTest {
	
	String[] strArr1 = new String[] {"bxxaxd", "xbxabx","sxixcx"};
	String[] strArr2 = new String[] {"xcxaxt", "xdxoxg","mixxcxe"};
	String[] strArr3 = new String[] {"xxax", "xbxbx","xxcx","xxexxr","xtexxt","cixxp"};
	
	@Test
	public void noXTest() {
		String[] test1 = new String[] {"bad", "bab","sic"};
		String[] test2 = new String[] {"cat", "dog","mice"};
		String[] test3 = new String[] {"a","bb","c","er","tet","cip"};
		
		assertEquals(Arrays.toString(test1),Arrays.toString(NoX.noX(strArr1)));
		assertEquals(Arrays.toString(test2),Arrays.toString(NoX.noX(strArr2)));
		assertEquals(Arrays.toString(test3),Arrays.toString(NoX.noX(strArr3)));
	}

}
