package com.perscholas.junitbasic.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.perscholas.junit5intro.dao.DatabaseConnection;
import com.perscholas.junit5intro.dao.StudentDAO;
import com.perscholas.junit5intro.models.Student;

public class JUnit5ExpectedDataTest {
	private static Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private static StudentDAO studentDAO = null;
	private Student expected = null;
	
	@BeforeAll
	public static void setUp() {
		DatabaseConnection dbConn = new DatabaseConnection();
		try {
			conn = dbConn.getConnection();
			studentDAO = new StudentDAO();
		} 
		catch (SQLException | ClassNotFoundException | IOException e)
		{
			e.getMessage();
		}
	}
	
	@BeforeEach
	public void beforeEachMethod() throws SQLException {
		stmt = conn.prepareStatement("SELECT * FROM students WHERE id=?");
		stmt.setInt(1,1);
		rs = stmt.executeQuery();
		rs.next();
		expected = new Student();
		expected.setId(rs.getInt(1));
		expected.setEmail(rs.getString(2));
		expected.setfName(rs.getString(3));
		expected.setlName(rs.getString(4));
	}
	
	@Test
	public void testGetStudentById() throws SQLException {
		Student actual = studentDAO.getStudentById(1);
		assertEquals(expected, actual);
	}
	
	@AfterEach
	public void afterEachMethod() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
	}
	
	@AfterAll
	public static void tearDown() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
