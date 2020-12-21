package com.ss.sf.week1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SampleSingleton {

	
		
	private volatile static Connection conn = null;
		
	private volatile static SampleSingleton instance = null;
	
	public static SampleSingleton getInstance() {
		if (instance == null) {
			synchronized (SampleSingleton.class) {
				if (instance == null) {
					instance = new SampleSingleton();
				}
			}
		}
		return instance;
	}
	public static void databaseQuery(BigDecimal input) throws SQLException {
		try {
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id from table");
			List<String> ids = new ArrayList<>();
			
			while(rs.next()) {
				String id = rs.getString("id");
				ids.add(id);
			}
			rs.close();

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			conn.close();
		}
	}
}
