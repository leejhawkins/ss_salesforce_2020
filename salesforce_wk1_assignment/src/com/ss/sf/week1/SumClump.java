/**
 * 
 */
package com.ss.sf.week1;

/**
 * @author leejh
 *
 */
public class SumClump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int start1 = 0;
		int[] intArr1 = new int[] {1,4,4,6,8};
		int target1 = 14;
		System.out.println(SumClump.sumClump(start1, intArr1, target1));

	}
	public static boolean sumClump(int start, int[] intArr, int target) {
		
		if(target == 0) {
			return true;
		}
		if(start >= intArr.length) {
			return false;
		}
		int next = start +1;
		int clumpTotal = intArr[start];
		while(next < intArr.length && intArr[start] == intArr[next]) {
			System.out.println(intArr.length);
			next++;
			clumpTotal += intArr[start];
			System.out.println(clumpTotal +" " + next);
		}
		if(sumClump(next ,intArr,target - clumpTotal)) {
			return true;
		} 
			
		return sumClump(next, intArr, target);

	}

}
