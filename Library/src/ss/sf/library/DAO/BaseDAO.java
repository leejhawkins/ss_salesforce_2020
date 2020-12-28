package ss.sf.library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
	
	Connection connection = null;
	PreparedStatement stmt = null;
	
	public void save(String sql, Object[] vals) throws ClassNotFoundException {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement(sql);
			int count = 1;
			for (Object o: vals) {
				stmt.setObject(count,o);
				count++;
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
			
	}
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		List<T> list = new ArrayList<>();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement(sql);
			
			int count = 1;
			if (vals != null) {
				for (Object o : vals) {
					stmt.setObject(count, o);
					count++;
				}
			}

			ResultSet rs = stmt.executeQuery();
			list = extractData(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return list;
	}

	abstract List<T> extractData(ResultSet rs) throws SQLException, ClassNotFoundException;
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}

}
