package ss.sf.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookLoan {
	private int bookId;
	private int cardNo;
	private String title;
	private int branchId;
	private LocalDateTime dateOut;
	private LocalDateTime dueDate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public LocalDateTime getDateOut() {
		return dateOut;
	}
	public void setDateOut(LocalDateTime dateOut) {
		this.dateOut = dateOut;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
