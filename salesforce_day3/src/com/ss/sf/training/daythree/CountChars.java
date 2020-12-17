/**
 * 
 */
package com.ss.sf.training.daythree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author leejh
 *
 */
public class CountChars {

	/**count the number of specific characters that a user inputs
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("What single character would you like to search for?");
		Scanner sc = new Scanner(System.in);
		//	Get character from user
		String input = sc.next();
		char letter = input.charAt(0);
		//	Get file to read
		File file = new File("input/newfile.txt");
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			//	initialize variables for character count and data to read		
			String data;
			int charCount = 0;
			while((data = br.readLine()) != null) {
				//	String to lowercase to count all of a certain letter			
				String line = data.toLowerCase();
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == letter) {
						charCount++;
					}
					
				}
			}
			System.out.println("There are "+ charCount + " " + letter +"'s");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

}
