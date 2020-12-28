/**
 * 
 */
package ss.sf.pages;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ss.sf.Domain.Book;
import ss.sf.Domain.Branch;
import ss.sf.library.DAO.BookDAO;
import ss.sf.library.DAO.BranchDAO;
import ss.sf.library.data.Library;

/**
 * @author leejh
 *
 */
public class LibrarianPage {
	
	public static void lib1(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("1) Enter Branch you manage \n2) Quit to previous menu");
		
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch(choice) {
			case 1:
				scanner.reset();
				LibrarianPage.lib2(scanner);
				break;
				
			case 2: 
				scanner.reset();
				Library lib = new Library();
				lib.getPage(scanner);
				break;
			default:
				System.out.println(choice +" is not a valid choice");
				scanner.reset();
				LibrarianPage.lib1(scanner);
				return;
			}
			
		} else {
			System.out.println("Please only enter a number for a valid choice");
			lib1(scanner);
		}
	}
	public static void lib2(Scanner scanner) throws ClassNotFoundException, SQLException {
		Branch currentBranch = Library.getCurrentBranch(scanner);
		if (currentBranch != null) {
			LibrarianPage.lib3(scanner,currentBranch);
		} else {
			LibrarianPage.lib1(scanner);
		}
	}
	public static void lib3(Scanner scanner,Branch branch) throws ClassNotFoundException, SQLException {
		
		
		System.out.println("Current Branch: " + branch.getBranchName() + "\n1). Update the details of the Library:\n" +
				"2). Add copies of Book to branch\n3) Quit to previous");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch(choice) {
			case 1:
				LibrarianPage.option1(scanner,branch);
				break;
			case 2:
				LibrarianPage.option2(scanner,branch);
				break;
			case 3: 
				LibrarianPage.lib2(scanner);
				break;
			}
		} else {
			System.out.println("Please only enter a number for a valid choice");
			lib3(scanner, branch);
		}
	}
	public static void option1(Scanner scanner,Branch branch) throws ClassNotFoundException, SQLException {
		BranchDAO brDAO = new BranchDAO();
		System.out.println("Please enter new branch name or enter N/A for no change:");
		Branch updatedBranch = new Branch();
		updatedBranch.setBranchId(branch.getBranchId());
		
		String newName = scanner.nextLine();
		System.out.println("Please enter new branch address or enter N/A for no change:");
		if (newName.toLowerCase() == "n/a") {
			updatedBranch.setBranchName(branch.getBranchName());			
		} else {
			updatedBranch.setBranchName(newName);
		}
		String newAddress = scanner.nextLine();
		if (newAddress.toLowerCase() == "n/a") {
			updatedBranch.setBranchAddress(branch.getBranchAddress());			
		} else {
			updatedBranch.setBranchAddress(newAddress);
		}
		brDAO.updateBranch(updatedBranch);
		System.out.println(branch.getBranchName() + " at " + branch.getBranchAddress()
				+ " to " + updatedBranch.getBranchName() + " at " + updatedBranch.getBranchAddress());
		LibrarianPage.lib3(scanner,branch);
	}
	public static void option2(Scanner scanner, Branch branch) throws ClassNotFoundException, SQLException {
		scanner.reset();
		BookDAO bkDAO = new BookDAO();
		List<Book> books = bkDAO.getBooksByBranch(branch.getBranchId());
		System.out.println("Choose a book to add to: ");
		books.forEach(book -> System.out.println(books.indexOf(book)+ 1 + ")." + book.getTitle() 
				+" by "+ book.getAuthor() + "Number of Copies: " + book.getNumberOfCopies() ));
		
		
		int chooseBook = scanner.nextInt();
		Book book = books.get(chooseBook-1);
		System.out.println("How many would you like to add to " + book.getTitle() + " there are currently " + book.getNumberOfCopies());
		int addInventory = scanner.nextInt();
		bkDAO.updateInventory(book,addInventory,branch);
		System.out.println("Updated " + book.getTitle() + " from " + book.getNumberOfCopies()
		+ " copies to " + (book.getNumberOfCopies() + addInventory) + " copies");
		LibrarianPage.lib3(scanner,branch);
		
	}
}
