package src.com.ss.sf.training.dayone;
import java.util.Scanner;
import java.util.Random;

public class NumberGuess {

	public static void main(String[] args) {
		Random rand = new Random();
		int randNumber = rand.nextInt(101);
		int guesses = 5;
		Scanner scanner = new Scanner(System.in);
		
		
		while(guesses > 0) {
			System.out.println("Pick a number between one and 100:");
			
			int input = scanner.nextInt();
			int diff = Math.abs(randNumber - input);
			guesses--;
			if (diff < 10) {
				System.out.println("Close enough, you win!!! The number was: " + randNumber);
				break;
			} else if(guesses < 1) {
				System.out.println("Sorry you ran out of guesses. The number was: " + randNumber);
				
			} else {
				System.out.println("Good guess but no.  You have " + guesses + " guesses left");
			}
			
		}
		scanner.close();

	}

}
