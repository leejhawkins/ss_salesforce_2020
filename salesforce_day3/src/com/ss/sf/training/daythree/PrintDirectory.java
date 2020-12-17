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
			System.out.println("Current Directory: " + rootDirectory + "\nFiles:\n");
			//	Get files and directories from root	path	
			File  directory = new File(rootDirectory);
			String[] directoryFiles = directory.list();
			//	Print files from directory		
			for (String file:directoryFiles) {
				System.out.println(file);
			}
			System.out.println("\nType in directory to search:");
			Scanner scanner = new Scanner(System.in);
			//	Ask user for directory to search		
			String input = scanner.nextLine();
			//	Check if user input is a file or subdirectory in directory		
			String subdirectory = rootDirectory + "/" + input;
			File subdirectoryFiles = new File(subdirectory);
			String[] filesInSubdirectory = subdirectoryFiles.list();
				//	Check if user input	is directory or file		
			if(!(filesInSubdirectory == null)){
					//	print files in subdirectory				
				for (String file:filesInSubdirectory) {
					System.out.println(file);
					}
			} else {
					
					System.out.println("No such directory exists or is not a directory");
			}
				
			scanner.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		

	}

}
