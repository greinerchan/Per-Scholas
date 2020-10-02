package com.perscholas.junitbasic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.perscholas.junit5intro.dao.StudentDAO;
import com.perscholas.junit5intro.models.Student;

public class StudentDAOTest {
	
	private static StudentDAO studentDAO;
	
	@BeforeAll
	public static void setUp() {
		studentDAO = new StudentDAO();
		try {
			studentDAO.testConnection();
			System.out.println("Successful connection made!!!");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.getMessage();
		}
	}
	
	@Test
	public void testGetStudentById() throws SQLException {
		Student expected = new Student();
		expected.setId(1);
		expected.setfName("Mike");
		expected.setlName("Gabriel");
		expected.setEmail("mgabriel@perscholas.org");
		Student actual = studentDAO.getStudentById(1);
		assertEquals(expected.getEmail(), actual.getEmail());
	}
	
//	@Test
//	public void testStudent() {
//		Student a = new Student();
//		a.setId(1);
//		a.setEmail("mgabriel@perscholas.org");
//		a.setfName("Mike");
//		a.setlName("Gabriel");
//		
//		Student b = new Student();
//		b.setId(1);
//		b.setEmail("mgabriel@perscholas.org");
//		b.setfName("Mike");
//		b.setlName("Gabriel");		
//		
//		assertEquals(a, b);
//	}
}
