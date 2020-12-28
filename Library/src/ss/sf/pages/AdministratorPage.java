package ss.sf.pages;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ss.sf.Domain.Author;
import ss.sf.Domain.Book;
import ss.sf.Domain.Branch;
import ss.sf.library.DAO.AuthorDAO;
import ss.sf.library.DAO.BookDAO;
import ss.sf.library.DAO.BranchDAO;
import ss.sf.library.data.Library;

public class AdministratorPage {
	public static void admin1(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("What would you like to do:\n"
				+ "1) Add/Update/Delete Books\n"
				+ "2) Add/Update/Delete Authors\n"
				+ "3) Add/Update/Delete Publishers\n"
				+ "4) Add/Update/Delete Library Branches\n"
				+ "5) Add/Update/Delete Borrowers\n"
				+ "6) Change Due Date for Book Loan\n");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch (choice) {
			case 1:
				editBooks(scanner);
				break;
			case 2:
				editAuthors(scanner);
				break;
			case 3:
				EditPublishers.editPublishers(scanner);
				break;
			case 4:
				editBranches(scanner);
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				
			}
		} else {
			System.out.println("Please enter a number corresponding to a listed choice");
			admin1(scanner);
		}
		
	}
	public static void editBooks(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("What would you like to do\n?"
				+ "1) Add book\n2) Update book\n3) Delete Book");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch (choice) {
			case 1:
				addBook(scanner);
				break;
			case 2:
				editBook(scanner);
				break;
			case 3:
				deleteBook(scanner);
				break;
			default:
				
			}
		}
	}
	public static void editAuthors(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("What would you like to do?\n"
				+ "1) Add author\n2) Update author\n3) Delete author");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch (choice) {
			case 1:
				addAuthor(scanner);
				break;
			case 2:
				editAuthor(scanner);
				break;
			case 3:
				deleteAuthor(scanner);
				break;
			default:
				
			}
		}
	}
	public static void editBranches(Scanner scanner) throws ClassNotFoundException, SQLException {
		System.out.println("What would you like to do?\n"
				+ "1) Add branch\n2) Update branch\n3) Delete branch");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch (choice) {
			case 1:
				addBranch(scanner);
				break;
			case 2:
				editBranch(scanner);
				break;
			case 3:
				deleteBranch(scanner);
				break;
			default:
				
			}
		}
	}
	public static void addBook(Scanner scanner) throws ClassNotFoundException, SQLException {
		BookDAO bkDAO = new BookDAO();
		Book book = new Book();
		System.out.println("Enter the Id of the book you would like to enter:");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			book.setBookId(scannedLine.nextInt());
			
		}
		System.out.println("Enter the title of the book you would like to enter:");
		String title = scanner.nextLine();
		book.setTitle(title);
		AuthorDAO aDAO = new AuthorDAO();
		List<Author> authors = aDAO.readAuthors();
		authors.forEach(author -> System.out.println("Author Name: " + author.getAuthorName() + " Author Id: " + author.getAuthorId() ));
		System.out.println("Enter a valid author name for the book:");
		book.setAuthor(scanner.nextLine());
		System.out.println("Enter a valid publish for the book");
		String publisher = scanner.nextLine();
		book.setPublisher(publisher);
		bkDAO.addBook(book);
		admin1(scanner);
		
	}
	public static void editBook(Scanner scanner) throws ClassNotFoundException, SQLException {
		BookDAO bkDAO = new BookDAO();
		System.out.println("Enter the number of the book you would like to edit by row number");
		List<Book> books = bkDAO.getAllBooks();
		books.forEach(book -> System.out.println(books.indexOf(book)+1 + ") " + book.getTitle() + " by " + book.getAuthor() 
		 + " Book ID: " +book.getBookId()));
		Scanner scannedLine = new Scanner(scanner.nextLine());
		Book book = new Book();
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			book = books.get(choice - 1);
		}
		System.out.println("What would you like to change " + book.getTitle() + "'s title to?" );
		String newTitle = scanner.nextLine();
		System.out.println("Who would you like to change " + book.getTitle() + "'s author to?" );
		String newAuthor = scanner.nextLine();
		bkDAO.updateBook(book.getBookId(),newTitle,newAuthor);
		admin1(scanner);
	}
	public static void deleteBook(Scanner scanner) throws ClassNotFoundException, SQLException {
		BookDAO bkDAO = new BookDAO();
		System.out.println("Enter the number of the book you would like to deleted by Book Id");
		List<Book> books = bkDAO.getAllBooks();
		books.forEach(book -> System.out.println(books.indexOf(book)+1 + ") " + book.getTitle() + " by " + book.getAuthor() 
		 + " Book ID: " +book.getBookId()));
		Scanner scannedLine = new Scanner(scanner.nextLine());
		int bookId = 0;
		if (scannedLine.hasNextInt()) {
			bookId = scannedLine.nextInt();
		}
		bkDAO.deleteBook(bookId);
		admin1(scanner);
	}
	public static void addAuthor(Scanner scanner) throws ClassNotFoundException, SQLException {
		AuthorDAO aDAO = new AuthorDAO();
		Author author = new Author();
		System.out.println("Enter the Id of the author you would like to add:");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			author.setAuthorId(scannedLine.nextInt());
			
		}
		System.out.println("Enter the name of the author you would like to add:");
		String title = scanner.nextLine();
		author.setAuthorName(title);
		aDAO.addAuthor(author);
		admin1(scanner);
	}
	public static void editAuthor(Scanner scanner) throws ClassNotFoundException, SQLException {
		AuthorDAO aDAO = new AuthorDAO();
		List<Author> authors = aDAO.readAuthors();
		System.out.println("Enter the number of the author you would like to edit by row number");
		authors.forEach(author -> System.out.println(authors.indexOf(author) + 1 +") " + author.getAuthorName() + " Author ID: " + author.getAuthorId()));
		Scanner scannedLine = new Scanner(scanner.nextLine());
		Author author = new Author();
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			author = authors.get(choice - 1);
		}
		System.out.println("What would you like to change " + author.getAuthorId() + "'s name to?" );
		String newName = scanner.nextLine();
		author.setAuthorName(newName);
		aDAO.updateAuthor(author);
		admin1(scanner);
		
	}
	public static void deleteAuthor(Scanner scanner) throws ClassNotFoundException, SQLException {
		AuthorDAO aDAO = new AuthorDAO();
		List<Author> authors = aDAO.readAuthors();
		System.out.println("Enter the number of the author you would like to delete by Author Id");
		authors.forEach(author -> System.out.println(authors.indexOf(author) + 1 +") " + author.getAuthorName() + " Author ID: " + author.getAuthorId()));
		Scanner scannedLine = new Scanner(scanner.nextLine());
		Author author = new Author();
		if (scannedLine.hasNextInt()) {
			int authorId = scannedLine.nextInt();
			author.setAuthorId(authorId);
			
		}
		aDAO.deleteAuthor(author);
		admin1(scanner);
	}
	public static void addBranch(Scanner scanner) throws ClassNotFoundException, SQLException {
		BranchDAO brDAO = new BranchDAO();
		Branch branch = new Branch();
		System.out.println("Enter the Id of the branch you would like to add:");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			branch.setBranchId(scannedLine.nextInt());
			
		}
		System.out.println("Enter the name of the branch you would like to add:");
		String branchName = scanner.nextLine();
		branch.setBranchName(branchName);
		System.out.println("Enter the address of the branch you would like to add:");
		String branchAddress = scanner.nextLine();
		branch.setBranchAddress(branchAddress);
		brDAO.addBranch(branch);
		admin1(scanner);
		
	}
	public static void editBranch(Scanner scanner) throws ClassNotFoundException, SQLException {
		Branch currentBranch = Library.getCurrentBranch(scanner);
		BranchDAO brDAO = new BranchDAO();
		System.out.println("Please enter new branch name or enter N/A for no change:");
		Branch updatedBranch = new Branch();
		updatedBranch.setBranchId(currentBranch.getBranchId());
		
		String newName = scanner.nextLine();
		System.out.println("Please enter new branch address or enter N/A for no change:");
		if (newName.toLowerCase() == "n/a") {
			updatedBranch.setBranchName(currentBranch.getBranchName());			
		} else {
			updatedBranch.setBranchName(newName);
		}
		String newAddress = scanner.nextLine();
		if (newAddress.toLowerCase() == "n/a") {
			updatedBranch.setBranchAddress(currentBranch.getBranchAddress());			
		} else {
			updatedBranch.setBranchAddress(newAddress);
		}
		brDAO.updateBranch(updatedBranch);
		System.out.println(currentBranch.getBranchName() + " at " + currentBranch.getBranchAddress()
				+ " to " + updatedBranch.getBranchName() + " at " + updatedBranch.getBranchAddress());
		admin1(scanner);
	}
	
	public static void deleteBranch(Scanner scanner) throws ClassNotFoundException, SQLException {
		BranchDAO brDAO = new BranchDAO();
		List<Branch> branches = brDAO.readBranches();
		System.out.println();
		branches.forEach(branch -> System.out.println(branches.indexOf(branch)+1+") " +"Branch Id: " + branch.getBranchId() 
				 + " " + branch.getBranchName() + "- " + branch.getBranchAddress()) );
		Scanner scannedLine = new Scanner(scanner.nextLine());
		int branchId = 0;
		if (scannedLine.hasNextInt()) {
			branchId = scannedLine.nextInt();
			
		}
		brDAO.deleteBranch(branchId);
		admin1(scanner);
	}
	
}
