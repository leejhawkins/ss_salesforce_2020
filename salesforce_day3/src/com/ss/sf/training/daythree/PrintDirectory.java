/**
 * 
 */
package com.ss.sf.training.daythree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author leejh
 *
 */
public class PrintDirectory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Get present working directory	path	
		try {String rootDirectory = new File(".").getCanonicalPath();
			PrintDirectory pd = new PrintDirectory();
			Scanner scanner = new Scanner(System.in);
			pd.printOutDirectory(rootDirectory,scanner);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		public void printOutDirectory(String rootDirectory,Scanner scanner) {
			System.out.println("Current Directory: " + rootDirectory + "\nFiles:\n");
			//	Get files and directories from root	path	
			File  directory = new File(rootDirectory);
			String[] directoryFiles = directory.list();
			//	Print files from directory
			if(!(directoryFiles == null)){
				//	print files in subdirectory				
				for (String file:directoryFiles) {
					System.out.println(file);
				}
			} else {
				System.out.println("No such directory exists or is not a directory");
				System.exit(0);
			}
			System.out.println("\nType in directory to search:");
			
			//	Ask user for directory to search		
			String input = scanner.nextLine();
			//	Check if user input is a file or subdirectory in directory		
			String subdirectory = rootDirectory + "/" + input;		
				
			scanner.reset();
			this.printOutDirectory(subdirectory,scanner);
			return;

		}
		

}
