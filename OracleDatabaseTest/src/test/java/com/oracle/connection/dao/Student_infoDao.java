package com.oracle.connection.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.oracle.connection.entity.Student_info;

/**
 * Table "Employees" Data access layer
 * 
 * @author Administrator
 *
 */
public class Student_infoDao {

	public static void addStudent(Student_info student_info) {

		BaseDao basedao = new BaseDao();

		Connection conn = null;
		PreparedStatement statement = null;

		try {

			conn = basedao.connectToOracleDB();
			statement = conn.prepareStatement("insert into student_info values(?,?,?,?)");
			statement.setLong(1, student_info.getStudent_id());
			statement.setString(2, student_info.getFirst_name());
			statement.setString(3, student_info.getLast_name());
			statement.setString(4,student_info.getEmail());

			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeAll(null, statement, conn);// close All connection
		}

	}

}
