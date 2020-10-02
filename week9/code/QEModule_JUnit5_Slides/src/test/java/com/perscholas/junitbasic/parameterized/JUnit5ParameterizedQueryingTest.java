package com.perscholas.junitbasic.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import com.perscholas.junit5intro.dao.StudentDAO;
import com.perscholas.junit5intro.models.Student;

public class JUnit5ParameterizedQueryingTest {
	private static StudentDAO studentDAO = null;
	
	@BeforeAll
	public static void setUp() {
		studentDAO = new StudentDAO();
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,mgabriel@perscholas.org,Mike,Gabriel",
		"2,bvasquez@perscholas.org,Bairon,Vasquez"
		})
	void testGetStudentById(ArgumentsAccessor arguments) throws ArgumentAccessException, SQLException {
		System.out.println(this.toString());
		
		Student expected = new Student();
		expected.setId(arguments.getInteger(0));
		expected.setEmail(arguments.getString(1));
		expected.setfName(arguments.getString(2));
		expected.setlName(arguments.getString(3));
		
		Student actual = studentDAO.getStudentById(arguments.getInteger(0));
		assertEquals(expected, actual);
	}
}