package com.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		Connection connection = null;

		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // loading mysql driver
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal", "root", ""); // attempting to
																									// connect to MySQL
																									// database
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
