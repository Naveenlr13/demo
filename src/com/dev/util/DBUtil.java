package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection ;

	private final static String USERNAME = "root";
	private final static String PASSWORD = "0173";
	private final static String JDBCURL = "jdbc:mysql://localhost:3306/employee_jdbc";
	private final static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			//Load the Driver Class
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
