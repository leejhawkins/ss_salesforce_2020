package ss.sf.library.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ss.sf.Domain.Author;


public class AuthorDAO extends BaseDAO<Author> {

	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("Insert into tbl_author values (?,?)", new Object[] { author.getAuthorId(),author.getAuthorName() });
	}

	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("update tbl_author set authorName = ? where authorId = ?",
				new Object[] { author.getAuthorName(), author.getAuthorId() });
	}

	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("delete from tbl_author where authorId = ?", new Object[] {author.getAuthorId()});
	}

	public List<Author> readAuthors() throws SQLException, ClassNotFoundException {
		return read("select * from tbl_author", null);
	}
	
	public List<Author> readAuthorsByName(String authorName) throws SQLException, ClassNotFoundException {
		return read("select * from tbl_author where authorName  = ? ", new Object[] {authorName});
	}

	@Override
	List<Author> extractData(ResultSet rs)  throws SQLException, ClassNotFoundException {
		List<Author> authors = new ArrayList<>();
		while (rs.next()) {
			Author author = new Author();
			author.setAuthorId(rs.getInt("authorId"));
			author.setAuthorName(rs.getString("authorName"));
			authors.add(author);
		}
		return authors;
	}

}
