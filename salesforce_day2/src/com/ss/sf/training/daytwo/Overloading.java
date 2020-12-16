package com.ss.sf.training.daytwo;
import java.util.ArrayList;
import java.util.Scanner;


public class Overloading {
	public static void main(String[] args) {
		Overloading ovl = new Overloading();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter values separated by spaces: ");
		
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		ArrayList<Double> doubleArray = new ArrayList<Double>();
		ArrayList<String> stringArray = new ArrayList<String>();

		
		while (scanner.hasNext() == true)  {
			if (scanner.hasNextInt()) {
				intArray.add(scanner.nextInt());
				int size = intArray.size();
				int[] intArray2 = new int[size];
				for (int i =0; i<intArray2.length; i++) {
					intArray2[i] = intArray.get(i);
				}
				ovl.addValues(intArray2);
				
				
			} else if (scanner.hasNextDouble()) {
				doubleArray.add(scanner.nextDouble());
				int size = doubleArray.size();
				double[] double2 = new double[size];
				for (int i =0; i<double2.length; i++) {
					double2[i] = doubleArray.get(i);
				}
				ovl.addValues(double2);
				
			} else if (scanner.hasNext()){
				stringArray.add(scanner.next());
				ovl.addValues(stringArray);
			} else {
				break;
				
			}
			

		}
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
