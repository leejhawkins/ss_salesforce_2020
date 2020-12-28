package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ss.sf.Domain.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> {
	
	public List<Borrower> getBorrowerByCardNumber(int cardNumber) throws ClassNotFoundException, SQLException {
		return read("SELECT * from tbl_borrower WHERE cardNO=?", new Object[]{cardNumber});
	}

	@Override
	List<Borrower> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Borrower> borrowers = new ArrayList<>();
		
		while(rs.next()) {
			Borrower borrower = new Borrower();
			borrower.setCardNo(rs.getInt("cardNo"));
			borrower.setName(rs.getString("name"));
			borrower.setAddress(rs.getString("address"));
			borrower.setPhone(rs.getString("phone"));
			borrowers.add(borrower);
		}
		
		return borrowers;
	}

}
