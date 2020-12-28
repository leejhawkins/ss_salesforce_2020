package ss.sf.library.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {
	public static String CONNECTION_USERNAME = "root";
	public static  String CONNECTION_PASSWORD = "hotsauce26";
	public static  String URL = "jdbc:mysql://localhost:3306/library";
	public static String driver = "com.mysql.cj.jdbc.Driver"; 
	
	public static synchronized Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(URL,CONNECTION_USERNAME,CONNECTION_PASSWORD);
		} catch (ClassNotFoundException  | SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return conn;	
	}
}
