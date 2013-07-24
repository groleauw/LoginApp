package com.login;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionManager {
	static Connection conn;

	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "login";
			String uname = "root";
			String pwd = "3554";

			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(url + dbName, uname, pwd);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}

}