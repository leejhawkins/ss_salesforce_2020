package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ss.sf.pages.Publisher;

public class PublisherDAO extends BaseDAO<Publisher>{
	public void addPublisher(Publisher publisher) throws ClassNotFoundException {
		save("INSERT into tbl_publisher values(?,?,?,?)",new Object[] {publisher.getPublisherId(),publisher.getPublisherName(),
				publisher.getPublisherAddress(),publisher.getPublisherPhone()});
	}
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException {
		save("UPDATE tbl_publisher set publisherName = ?, publisherAddress=?, publisherPhone=? where publisherId =?", 
				new Object[] {publisher.getPublisherName(),publisher.getPublisherAddress(),publisher.getPublisherPhone(),publisher.getPublisherId()});
	}
	public void deletePublisher(int pubId) throws ClassNotFoundException {
		save("DELETE from tbl_publisher where publisherId = ?", new Object[] {pubId});
	}
	public List<Publisher> getPublishers() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_publisher",null);
	}
	

	@Override
	List<Publisher> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Publisher> publishers = new ArrayList<>();
		while(rs.next()) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(rs.getInt("publisherId"));
			publisher.setPublisherName(rs.getString("publisherName"));
			publisher.setPublisherAddress(rs.getString("publisherAddress"));
			publisher.setPublisherPhone(rs.getString("publisherPhone"));
			publishers.add(publisher);
		}
		return publishers;
	}

}
