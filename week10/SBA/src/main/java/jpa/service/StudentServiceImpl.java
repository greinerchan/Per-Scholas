package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Transactional
	@Override
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	@Transactional
	@Override
	public Student getStudentByEmail(String sEmail) {
		return studentDAO.getStudentByEmail(sEmail);
	}

	@Transactional
	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		return studentDAO.validateStudent(sEmail, sPassword);
	}

	@Transactional
	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		studentDAO.registerStudentToCourse(sEmail, cId);
	}

	@Transactional
	@Override
	public List<Course> getStudentCourses(String sEmail) {
		return studentDAO.getStudentCourses(sEmail);
	}
}
