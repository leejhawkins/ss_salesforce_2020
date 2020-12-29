package ss.sf.pages;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.Scanner;

import ss.sf.Domain.Book;
import ss.sf.Domain.BookLoan;
import ss.sf.Domain.Borrower;
import ss.sf.Domain.Branch;
import ss.sf.library.DAO.BookDAO;
import ss.sf.library.DAO.BookLoanDAO;
import ss.sf.library.DAO.BorrowerDAO;
import ss.sf.library.data.Library;

public class BorrowerPage {
	public static void checkCard(Scanner scanner) throws ClassNotFoundException, SQLException, ParseException {
		
		System.out.println("Please enter library card number (press enter or quit to return to previous page)");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		BorrowerDAO borDAO = new BorrowerDAO();
		
		if (scannedLine.hasNextInt()) {
			int cardNumber = scannedLine.nextInt();
			List<Borrower> borrowers = borDAO.getBorrowerByCardNumber(cardNumber);
			
			if (borrowers.size() != 0) {
				BorrowerPage.borr1(scanner, borrowers.get(0));
				
				
			} else {
				System.out.println("Card does not exist");
				Library.getPage(scanner);
			}
			
		} else {
			Library.getPage(scanner);
		}
		
	}
	public static void borr1(Scanner scanner,Borrower borrower) throws ClassNotFoundException, SQLException, ParseException {
		System.out.println("Hello " + borrower.getName());
		System.out.println("1) Check out a book \n2) Return a book\n3) Search for books by author\n4) Leave");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			switch(choice) {
			case 1:
				BorrowerPage.checkOutBook(scanner, borrower);
				break;
			case 2:
				BorrowerPage.returnBooks(scanner, borrower);
				break;
			case 3:
				BorrowerPage.getBooksByAuthor(scanner, borrower);
				break;
			case 4:
				Library.getPage(scanner);
				break;
			default:
				System.out.println("Not a valid choice");
				Library.getPage(scanner);
			}
		}
	}
	public static void checkOutBook(Scanner scanner,Borrower borrower) throws ClassNotFoundException, SQLException, ParseException {
		Branch currentBranch = Library.getCurrentBranch(scanner);
		if (currentBranch != null) {
			BookLoanDAO bkLnDAO = new BookLoanDAO();
			BookDAO bkDAO = new BookDAO();
			List<Book> books = bkDAO.getBooksByBranch(currentBranch.getBranchId());
			System.out.println("Which book would you like to check out: ");
			books.forEach(book -> System.out.println(books.indexOf(book)+ 1 + ")." + book.getTitle() 
					+" by "+ book.getAuthor() ));
			System.out.println(books.size()+1 + "). Return to previous menu");
			
			Scanner scannedLine = new Scanner(scanner.nextLine());
			Book book = new Book();
			if (scannedLine.hasNextInt()) {
				int choice = scannedLine.nextInt();
				if (choice <= books.size()) {
					book = books.get(choice - 1);
				} else if (choice == books.size()+1) {
					borr1(scanner,borrower);
				} else {
					System.out.println("No such entry exists");
					checkOutBook(scanner,borrower);
				}
			} else {
				System.out.println("Invalid input");
				checkOutBook(scanner,borrower);
			}
			LocalDateTime dateOut = LocalDateTime.now();
			LocalDateTime dueDate =  dateOut.plus(2, ChronoUnit.WEEKS);
			bkLnDAO.checkOutBook(book.getBookId(),currentBranch.getBranchId(),borrower.getCardNo(),dateOut,dueDate);
			System.out.println("You checked out " + book.getTitle() + " by " + book.getAuthor() + " it is due back " 
			+ dueDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
			BorrowerPage.borr1(scanner, borrower);
		} else {
			BorrowerPage.borr1(scanner, borrower);
		}
		
	}
	public static void returnBooks(Scanner scanner,Borrower borrower) throws ClassNotFoundException, SQLException, ParseException {
		BookLoanDAO bklnDAO = new BookLoanDAO();
		List<BookLoan> bkLoans = bklnDAO.readCheckOutBooksByBorrower(borrower);
		System.out.println("Which book would you like to return?\n ");
		bkLoans.forEach(book -> System.out.println(bkLoans.indexOf(book)+1+") " + book.getTitle() + " checked out on " + book.getDateOut().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
				+ " due on " + book.getDueDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))));
		System.out.println(bkLoans.size()+1 + "). Return to previous menu");
		
		Scanner scannedLine = new Scanner(scanner.nextLine());
		BookLoan chckedBk = new BookLoan();
		if (scannedLine.hasNextInt()) {
			int choice = scannedLine.nextInt();
			if (choice <= bkLoans.size()) {
				chckedBk = bkLoans.get(choice - 1);
				bklnDAO.returnCheckedOutBook(chckedBk.getBookId(), borrower.getCardNo());
				BorrowerPage.borr1(scanner, borrower);
			} else if (choice == bkLoans.size()+1) {
				borr1(scanner,borrower);
			} else {
				System.out.println("No such entry exists");
				checkOutBook(scanner,borrower);
			}
		} else {
			System.out.println("Invalid input");
			checkOutBook(scanner,borrower);
		}
	}
	public static void getBooksByAuthor(Scanner scanner,Borrower borrower) throws ClassNotFoundException, SQLException, ParseException {
		BookDAO bkDAO = new BookDAO();
		System.out.println("Enter the author you would like to search for");
		Scanner scannedLine = new Scanner(scanner.nextLine());
		String author = scannedLine.next();
		List<Book> books = bkDAO.getBooksByAuthor(author);
		if (books.size() == 0) {
			System.out.println("There are not results for " + author);
			borr1(scanner, borrower);
		} else {
			books.forEach(book -> System.out.println(books.indexOf(book)+ 1 + ")." + book.getTitle() 
			+" by "+ book.getAuthor() ));
			System.out.println("\n");
			borr1(scanner, borrower);
		}
		
		
	}
}
