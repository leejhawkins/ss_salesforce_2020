package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ss.sf.Domain.Book;
import ss.sf.Domain.Branch;

public class BookDAO extends BaseDAO<Book> {
	
	public void addBook(Book book) throws ClassNotFoundException,SQLException {
		save("Insert into tbl_book (bookId,title,authId,pubId) values(?,?,(SELECT authorId from tbl_author where authorName = ?),(SELECT publisherId from tbl_publisher where publisherName=?))",new Object[] {book.getBookId(),book.getTitle(),book.getAuthor(),book.getPublisher()});
	}
	public void checkOutBook(int bookId, int branchId,int cardNo,LocalDate dateOut,LocalDate dueDate) throws ClassNotFoundException {
		save("Insert into tbl_book_loans (bookId,branchId,cardNo,dateOut,dueDate) values(?,?,?,?,?)",new Object[]{bookId,branchId,cardNo,dateOut,dueDate});
	}
	public void updateBook(int bookId, String newTitle, String newAuthor) throws ClassNotFoundException {
		save("UPDATE tbl_book SET title=?, authId=(SELECT authorId from tbl_author where authorName = ?) where bookId = ?", new Object[] {newTitle,newAuthor,bookId});
	}
	public void deleteBook(int bookId) throws ClassNotFoundException {
		save("DELETE from tbl_book where bookId = ?", new Object[] {bookId});
	}
	public List<Book> getBooksByBranch(int branchId) throws ClassNotFoundException,SQLException {
		return read("SELECT tbl_book.bookId,tbl_book.title,tbl_author.authorName,tbl_publisher.publisherName,tbl_book_copies.noOfCopies "
				+ "FROM tbl_book INNER JOIN tbl_author ON tbl_book.authId = tbl_author.authorId "
				+ " INNER JOIN tbl_publisher on tbl_publisher.publisherId = tbl_book.pubId "
				+ " INNER JOIN tbl_book_copies on tbl_book.bookId = tbl_book_copies.bookId where tbl_book_copies.branchId = ?;", new Object[] {branchId});
	}
	public List<Book> getBook(String bookName) throws ClassNotFoundException,SQLException {
		return read("SELECT tbl_book.title, tbl_book.bookId,tbl_author.authorName,tbl_publisher.publisherName "
				+ "FROM tbl_book INNER JOIN tbl_author ON tbl_book.authId = tbl_author.authorId"
				+ " INNER JOIN tbl_publisher on tbl_publisher.publisherId = tbl_book.pubId WHERE tbl_book.title = ?",  new Object[] {bookName});
	}
	public List<Book> getBooksByAuthor(String authorName) throws ClassNotFoundException,SQLException {
		return read("SELECT tbl_book.title, tbl_book.bookId,tbl_author.authorName,tbl_publisher.publisherName "
				+ "FROM tbl_book INNER JOIN tbl_author ON tbl_book.authId = tbl_author.authorId"
				+ " INNER JOIN tbl_publisher on tbl_publisher.publisherId = tbl_book.pubId WHERE tbl_author.authorName = ?",  new Object[] {authorName});
	}
	public List<Book> getAllBooks() throws ClassNotFoundException,SQLException {
		return read("SELECT tbl_book.title, tbl_book.bookId,tbl_author.authorName,tbl_publisher.publisherName,tbl_book_copies.noOfCopies "
				+ "FROM (tbl_book INNER JOIN tbl_author ON tbl_book.authId = tbl_author.authorId"
				+ " INNER JOIN tbl_publisher on tbl_publisher.publisherId = tbl_book.pubId) "
				+ " LEFT JOIN tbl_book_copies on tbl_book.bookId = tbl_book_copies.bookId", null);
	}
	public void updateInventory(Book book, int numberAdded,Branch branch) throws ClassNotFoundException {
		save("UPDATE tbl_book_copies set noOfCopies = ? where (bookId=? and branchId=?);", new Object[] {book.getNumberOfCopies() + numberAdded,book.getBookId(),branch.getBranchId()});
	}

	@Override
	List<Book> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		
		List<Book> books= new ArrayList<>();
		while(rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setAuthor(rs.getString("authorName"));
			book.setTitle(rs.getString("title"));
			book.setNumberOfCopies(rs.getInt("noOfCopies"));
			book.setPublisher(rs.getString("publisherName"));
			books.add(book);
		}
		return books;
	}

}
