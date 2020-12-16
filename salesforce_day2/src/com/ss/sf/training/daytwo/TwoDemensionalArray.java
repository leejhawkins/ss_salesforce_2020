package com.ss.sf.training.daytwo;

import java.util.Random;

public class TwoDemensionalArray {
	
	public static void main(String[] args) {
		
		int[][] twodarr = new int[6][6];
		
		for (int i = 0; i < 6; i++) {
			for  (int j = 0; j < 6;j++) {
				Random rand = new Random();
				int randNumber = rand.nextInt(101);
				twodarr[i][j] = randNumber;
				System.out.print(twodarr[i][j]+ " ");
			}
			System.out.println();
		}
		int max = 0;
		int position1 = 0;
		int position2 = 0;
		for (int i = 0; i < 6; i++) {
			for  (int j = 0; j < 6;j++) {
				if(twodarr[i][j] > max) {
					max = twodarr[i][j];
					position1 = i;
					position2 = j;
				}
			}
		}
		System.out.println("Maximum value of 2d array is: " + max + " at " + "["+position1+"]"+ "["+position2+"]");
		
		
	}

}
