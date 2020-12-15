package com.ss.sf.training.dayone;

public class PrintTree4 {
	public static void printTree() {
		System.out.println("4).");
		System.out.println("-----------");
		for (int i = 3; i >= 0 ; i--) {
			int middle = 1 + 2*i;
			int side = (11 - middle)/2;
			for (int j = 0; j < side; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j < middle; j++) {
				System.out.print('*');
			}
			for (int j = 0; j < side; j++) {
				System.out.print(' ');
			}
			System.out.println();
			
			
		}
	}
}
