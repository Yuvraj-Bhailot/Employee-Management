package com.em;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {

	public static Connection createConnection() {
		Connection connection = null;
		
		String JDBC_URL_EM = System.getenv("JDBC_URL_EM");
		String JDBC_USER = System.getenv("JDBC_USER");
		String JDBC_PASSWORD = System.getenv("JDBC_PASSWORD");
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(JDBC_URL_EM, JDBC_USER, JDBC_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
