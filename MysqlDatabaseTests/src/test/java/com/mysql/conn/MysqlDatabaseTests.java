package com.mysql.conn;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatabaseTests {

	static final String JDBC_DRIVE = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.1.158:3316/hrdb";
	// Database credentials
	static final String USER = "admin";
	static final String PASS = "Allen62a!";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// Step 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 3: Open a connection
			System.out.println("Connection to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// Step 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select employee_id,first_name,last_name ,phone_number from employees where employee_id >= 100 and employee_id <= 112";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("employees_id " + " "+ "    " + "| first_name" + " "+"  "+"| last_name" + " " + "   "+ "| phone_number");
			while (rs.next()) {
				int employee_id= rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String phone_number = rs.getString("phone_number");
				
				System.out.println(employee_id + "         "+"    " + first_name + "        " +"    "+ last_name + "     " +"    "+ phone_number);

				
			}

			// Step 6: Clear-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing can be done
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!!!!!!!!!!!");
	}// end main

}
