/**
 * 
 */
package com.ss.sf.week1;


import java.util.Arrays;


/**
 * @author leejh
 *
 */
public class NoX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr1 = new String[] {"ax","bb","cx"};
		String[] arr2 = new String[] {"xxax", "xbxbx","xxcx"};
		System.out.print(Arrays.toString(arr1)+" -> ");
		System.out.println(Arrays.toString(NoX.noX(arr1)));
		System.out.print(Arrays.toString(arr2)+" -> ");
		System.out.println(Arrays.toString(NoX.noX(arr2)));
		
		

	}
	public static String[] noX(String[] strArr) {
		for(int i=0;i<strArr.length;i++) {
			String str = "";
			for(int j=0;j<strArr[i].length();j++) {
				char c = strArr[i].charAt(j);
				if (c != 'x') {				
					str += c;
				}
			}
			strArr[i] = str;
		}
		return strArr;

	}

}
