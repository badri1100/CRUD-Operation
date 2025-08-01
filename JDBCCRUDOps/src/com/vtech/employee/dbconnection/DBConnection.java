package com.vtech.employee.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String username = "root";
	private static final String password = "123456";

	public static Connection getConnnection() throws SQLException {
		return DriverManager.getConnection(URL, username, password);
	}
}