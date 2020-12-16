package com.ss.sf.training.daytwo;
import java.util.ArrayList;
import java.util.Scanner;


public class Overloading {
	public static void main(String[] args) {
		Overloading ovl = new Overloading();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter values separated by spaces: ");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		// Create arrays for three types integers, doubles and strings		
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		ArrayList<Double> doubleArray = new ArrayList<Double>();
		ArrayList<String> stringArray = new ArrayList<String>();
		while (scannedLine.hasNext())  {
			if (scannedLine.hasNextInt()) {
				intArray.add(scannedLine.nextInt());
				// create integer array to allow overloading of method			
				
			} else if (scannedLine.hasNextDouble()) {
				doubleArray.add(scannedLine.nextDouble());
				
				
			} else if (scannedLine.hasNext()){
				// only one arraylist type, kept string arraylist				
				stringArray.add(scannedLine.next());
				
			} else {
				
				
			}
			
		}
		int intSize = intArray.size();
		int[] intArray2 = new int[intSize];
		for (int i =0; i<intArray2.length; i++) {
			intArray2[i] = intArray.get(i);
		}						
		ovl.addValues(intArray2);
		int doubleSize = doubleArray.size();
		// create double array to allow overloading of method
		double[] double2 = new double[doubleSize];
		for (int i =0; i<double2.length; i++) {
			double2[i] = doubleArray.get(i);
		}
		ovl.addValues(double2);
		ovl.addValues(stringArray);
		scanner.close();
		
		
	}
	public void addValues(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("The sum of the integers is: " + sum);
	}
	public void addValues(double[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("The sum of the doubles is: " + sum);
	}
	public void addValues(ArrayList<String> arr) {
		System.out.print("The sum of the strings is: ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(" " + arr.get(i));
		}
		System.out.println();
		
	}
	
}
