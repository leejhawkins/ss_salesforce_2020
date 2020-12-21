package com.ss.sf.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class RightNumber {

	public static void main(String[] args) {
		System.out.println("Enter integers separated by spaces");
		Scanner sc = new Scanner(System.in);
		Scanner scannedLine = new Scanner(sc.nextLine());
		
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		while(scannedLine.hasNextInt()) {
			intArray.add(scannedLine.nextInt());
		}
		sc.close();
		int[] intArr = new int[intArray.size()];
		intArray.forEach(n -> intArr[intArray.indexOf(n)] = n);
		System.out.print(Arrays.toString(intArr)+" -> ");
		System.out.print(Arrays.toString(RightNumber.rightNumber(intArr)));
		

	}
	public static int[] rightNumber(int[] intArray) {
		for (int i=0;i<intArray.length;i++) {
			intArray[i] %= 10;
		}
		
		return intArray;

	}

}
