package com.ss.sf.training.day5;

public class OddsEvens {

	public static void main(String[] args) {
		
		int[] intArray = new int[] {23, 45, 56, 100, 2003, 405,93, 88};
		String str = new String();
		for(int num:intArray) {
			if (num%2==0) {
				str = str + "e" + num + ", ";
			} else {
				str = str + "o" + num + ", ";
			}
			
		}
		
		System.out.println("Numbers sorted as odds or evens:\n" + str);

	}

}
