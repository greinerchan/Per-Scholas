package jpa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;




class StudentServiceImplTest {

	private static Connection conn;
	private static ResultSet rs;
	private static ResultSet rs2;
	private static ResultSet rs3;
	private static Student expected;
	private static StudentServiceImpl simpl;
	private static PreparedStatement stm;
	private static PreparedStatement stm2;
	private static PreparedStatement stm3;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
    	DatabaseConnection dbConn = new DatabaseConnection();
	    try {
	    	conn = dbConn.getConnection();
	    } catch (Exception e) {
	        System.out.println("Unable to connect to Database");
	    }
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if (conn != null) {
			conn.close();
		}
	}


	@BeforeEach
	void setUp() throws Exception {
		List<Course> list = new ArrayList<Course>();
		stm = conn.prepareStatement("Select * From student where email = ?");
		stm2 = conn.prepareStatement("Select * From student_course where Student_email = ?");
		stm3 = conn.prepareStatement("Select * From course where id = ?");
		stm.setString(1, "hluckham0@google.ru");
		stm2.setString(1, "hluckham0@google.ru");
		rs = stm.executeQuery();
		rs.next();
		rs2 = stm2.executeQuery();
		
		// add courses to the student field
		while (rs2.next()) {
			int id = rs2.getInt(2);
			stm3.setInt(1, id);
			rs3 = stm3.executeQuery();
			rs3.next();
			Course course = new Course(rs3.getInt(1), rs3.getString(2), rs3.getString(3));
			list.add(course);
		}
		
		// create a new student called expected
		expected = new Student();
		expected.setsEmail(rs.getString(1));
		expected.setsName(rs.getString(2));
		expected.setsPass(rs.getString(3));
		expected.setsCourses(list);
	}

	@AfterEach
	void tearDown() throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
	}

	@Test
	void testGetStudentByEmail() {
		simpl = new StudentServiceImpl();
		Student actual = simpl.getStudentByEmail("hluckham0@google.ru");
		
		// sameBeans check the deep copy of actual and expected value
		assertThat(actual, sameBeanAs(expected));
	}

}
