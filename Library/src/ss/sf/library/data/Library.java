/**
 * 
 */
package ss.sf.library.data;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ss.sf.Domain.Branch;
import ss.sf.library.DAO.BranchDAO;
import ss.sf.pages.AdministratorPage;
import ss.sf.pages.BorrowerPage;
import ss.sf.pages.LibrarianPage;

/**
 * @author leejh
 *
 */
public class Library {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Scanner scanner = new Scanner(System.in);
		Library lib = new Library();
		lib.getPage(scanner);
		
		
		
		

	}
	public void getPage(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("Welcome to the SS Libaray Management System.\n Which Category of user are you? (enter number only)");
		System.out.println("1) Librarian \n2) Administrator \n3) Borrower");
		
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int userType = scannedLine.nextInt();
			switch(userType) {
			case 1:
				LibrarianPage.lib1(scanner);
				break;
			case 2:
				AdministratorPage.admin1(scanner);
				break;
			case 3:
				BorrowerPage.checkCard(scanner);
				break;
			default:
				System.out.println(userType +" is not a valid choice");
				scanner.reset();
				this.getPage(scanner);
				return;
			}
		} else {
			System.out.println("Please only enter the number corresponding to your choices");
			scanner.reset();
			this.getPage(scanner);
			return;
		}
		
	}
	public static Branch getCurrentBranch(Scanner scanner) throws ClassNotFoundException, SQLException {
		BranchDAO brDAO = new BranchDAO();
		List<Branch> branches = brDAO.readBranches();
		branches.forEach(branch -> System.out.println(branches.indexOf(branch)+1+")"
		 + " " + branch.getBranchName() + "- " + branch.getBranchAddress()));
		Branch currentBranch = new Branch();
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			if (choice <= branches.size()) {
				currentBranch = branches.get(choice-1);
				return currentBranch;
				
			} else {
				return currentBranch;
			}
			
		}
		return currentBranch;
	}

}
