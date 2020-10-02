package com.perscholas.junit5intro.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.perscholas.junit5intro.models.Student;

public class StudentDAO {
	public void testConnection() throws ClassNotFoundException, IOException, SQLException {
		DatabaseConnection dbConn = new DatabaseConnection();
		try
		{
			dbConn.getConnection();
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public Student getStudentById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Student s = null;
		
		String qString = "select * from students where id = ?";
		DatabaseConnection dbConn = new DatabaseConnection();
		
		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setEmail(rs.getString(2));
				s.setfName(rs.getString(3));
				s.setlName(rs.getString(4));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.getMessage();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return s;
	}
}
