/**
 * 
 */
package com.ss.sf.week1;


import java.util.Arrays;

import java.util.Scanner;


/**
 * @author leejh
 *
 */
public class NumberTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many tests would you like to run?");
		
		int numTests = sc.nextInt();
		int[][] numArr = new int[2][numTests];
		int i = 0;
		
		while(numTests > i) {
			System.out.println("Input one number for test (1 = odd/even, 2 = prime check, 3 = palindrome check)\n and the number to check ");
			
			numArr[0][i] = sc.nextInt();
			numArr[1][i] = sc.nextInt();
			i++;
		
		}
		
		System.out.print(Arrays.toString(NumberTesting.numTests(numArr)));
		
		
		
	}
	public static String[] numTests(int[][] numArr) {
		String[] results = new String[numArr[0].length];
		for (int i=0;i<numArr[0].length;i++) {
			String result;
			switch(numArr[0][i]) {
			case 1:
				result = (numArr[1][i]%2 == 0) ? "EVEN":"ODD";
				results[i] = result;
				break;
			case 2:
				result = (NumberTesting.checkPrime(numArr[1][i])) ? "PRIME":"COMPOSITE";
				results[i] = result;
				break;
			case 3:
				result = (NumberTesting.checkPalindrome(numArr[1][i])) ? "PALINDROME":"NOT PALINDROME";
				results[i] = result;
				break;
			default:
				System.out.println("Number does not correspond to test");
			}
			
			}
			return results;
		}	
	public static boolean checkPrime(int num) {
		
		for (int i = 2; i<=num/2;i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkPalindrome(Integer numb) {
		
		String numStr = numb.toString();
		for (int i=0;i<=numStr.length()/2-1;i++) {
			if (numStr.charAt(i) != numStr.charAt(numStr.length()-1-i)) {
				return false;
			}
		}
		return true;
		
	}
}
