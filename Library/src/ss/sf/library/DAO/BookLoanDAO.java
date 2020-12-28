package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ss.sf.Domain.BookLoan;
import ss.sf.Domain.Borrower;

public class BookLoanDAO extends BaseDAO<BookLoan> {
	
	public void returnCheckedOutBook(int bookId,int cardNo) throws ClassNotFoundException {
		System.out.println(bookId);
		save("DELETE from tbl_book_loans where CONCAT(bookId,cardNo) = CONCAT(?,?)", new Object[] {bookId,cardNo});
	}
	public List<BookLoan> readCheckOutBooksByBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		return read("SELECT tbl_book.title,tbl_book_loans.bookId,tbl_book_loans.dateOut,tbl_book_loans.dueDate FROM "
				+ "tbl_book_loans INNER JOIN tbl_book ON tbl_book_loans.bookId = tbl_book.bookId where cardNo=?", new Object[] {borrower.getCardNo()});
	}
	@Override
	List<BookLoan> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<BookLoan> chckedBks = new ArrayList<>();
		while(rs.next()){
			BookLoan chckedBk = new BookLoan();
			chckedBk.setTitle(rs.getString("title"));
			chckedBk.setBookId(rs.getInt("bookId"));
			chckedBk.setDateOut(rs.getDate("dateOut").toLocalDate());
			chckedBk.setDueDate(rs.getDate("dueDate").toLocalDate());
			chckedBks.add(chckedBk);
		}
		return chckedBks;
	}
	

}
