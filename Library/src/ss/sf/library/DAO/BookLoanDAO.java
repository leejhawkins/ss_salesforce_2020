package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import ss.sf.Domain.BookLoan;
import ss.sf.Domain.Borrower;

public class BookLoanDAO extends BaseDAO<BookLoan> {
	
	public void returnCheckedOutBook(int bookId,int cardNo) throws ClassNotFoundException {
		
		save("DELETE from tbl_book_loans where CONCAT(bookId,cardNo) = CONCAT(?,?)", new Object[] {bookId,cardNo});
	}
	public void checkOutBook(int bookId, int branchId,int cardNo,LocalDateTime dateOut,LocalDateTime dueDate) throws ClassNotFoundException {
		save("Insert into tbl_book_loans (bookId,branchId,cardNo,dateOut,dueDate) values(?,?,?,?,?)",new Object[]{bookId,branchId,cardNo,dateOut,dueDate});
	}
	public void changeDueDate(BookLoan bookLoan) throws ClassNotFoundException {
		System.out.println();
		save("UPDATE tbl_book_loans set dueDate=? where CONCAT(bookId,cardNo) = CONCAT(?,?)", new Object[] {bookLoan.getDueDate(),bookLoan.getBookId(),bookLoan.getCardNo()});
	}
	public List<BookLoan> readCheckOutBooksByBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		return read("SELECT tbl_book.title,tbl_book_loans.bookId,tbl_book_loans.dateOut,tbl_book_loans.dueDate,tbl_book_loans.cardNo FROM "
				+ "tbl_book_loans INNER JOIN tbl_book ON tbl_book_loans.bookId = tbl_book.bookId where cardNo=?", new Object[] {borrower.getCardNo()});
	}
	
	public List<BookLoan> readAllBookLoans() throws ClassNotFoundException, SQLException{
		return read("SELECT tbl_book.title,tbl_book_loans.bookId,tbl_book_loans.dateOut,tbl_book_loans.dueDate,tbl_book_loans.cardNo FROM "
				+ "tbl_book_loans INNER JOIN tbl_book ON tbl_book_loans.bookId = tbl_book.bookId", null);
	}
	@Override
	List<BookLoan> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<BookLoan> chckedBks = new ArrayList<>();
		while(rs.next()){
			BookLoan chckedBk = new BookLoan();
			chckedBk.setTitle(rs.getString("title"));
			chckedBk.setBookId(rs.getInt("bookId"));
			chckedBk.setCardNo(rs.getInt("cardNo"));
			chckedBk.setDateOut(rs.getDate("dateOut").toLocalDate().atStartOfDay());
			chckedBk.setDueDate(rs.getDate("dueDate").toLocalDate().atStartOfDay());
			chckedBks.add(chckedBk);
		}
		return chckedBks;
	}
	

}
