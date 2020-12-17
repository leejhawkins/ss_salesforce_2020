/**
 * 
 */
package com.ss.sf.training.daythree;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author leejh Write user input to text file
 *
 */
public class AppendFile {

	/**
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		AppendFile af = new AppendFile();
		System.out.print("What would like to add to the text file?\n");
		//	Get user text to write to file	
		Scanner scanner = new Scanner(System.in);		
		
		af.appendToFile(scanner);		
			
	}
	public void appendToFile(Scanner scanner) throws IOException {
		
		String input = scanner.nextLine();
		//	The file to be written to	
		File file = new File("output/output.txt");
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		//	Write to file and close scanner	
		bw.write("\n" + input);
		bw.close();
		System.out.print("What would like to add to the text file?\n");
		scanner.reset();
		this.appendToFile(scanner);
		
	}

}
