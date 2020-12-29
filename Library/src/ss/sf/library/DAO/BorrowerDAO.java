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
	public List<Borrower> getAllBorrowers() throws ClassNotFoundException, SQLException {
		return read("SELECT * from tbl_borrower", null);
	}
	public void updateBorrower(Borrower borrower) throws ClassNotFoundException {
		save("UPDATE tbl_borrower SET name=?,address=?,phone=? where cardNo=?", new Object[] {borrower.getName(),borrower.getAddress(),borrower.getPhone(),borrower.getCardNo()});
	}
	public void deleteBorrower(int cardNo) throws ClassNotFoundException {
		save("DELETE from tbl_borrower where cardNo=?",new Object[] {cardNo});
	}
	public void addBorrower(Borrower borrower) throws ClassNotFoundException {
		save("INSERT into tbl_borrower (cardNo,name,address,phone) values(?,?,?,?)", new Object[] {borrower.getCardNo(),borrower.getName(),borrower.getAddress(),borrower.getPhone()});
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
