package com.oracle.connection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Basic access class(Create database connection, close resources)
 * 
 * @author Hamit
 *
 */

public class BaseDao {

	final static Logger logger = Logger.getLogger(BaseDao.class);

	private String databaseServerHost;
	private String databasePort;
	private String databaseName;
	private String userName;
	private String userPassword;
	private String dbConnectionURL;

	private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	public Connection connectToOracleDB() {
		databaseServerHost = "192.168.1.181";
		databasePort = "1521";
		databaseName = "CDB1";
		userName = "C##hruser";
		userPassword = "hruser";
		dbConnectionURL = "jdbc:oracle:thin:@//" + databaseServerHost + ":" + databasePort + "/" + databaseName;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection(dbConnectionURL, userName, userPassword);
			statement = conn.createStatement();
			logger.info("Oracle dababase connection is successful!!!");	
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
		return conn;
	}

	/**
	 * connection database
	 * 
	 * @return
	 * @return
	 * @throws SQLException
	 */

	public static void closeAll(ResultSet resultset, Statement statement, Connection conn) {
		if (resultset != null) {
			try {
				resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
