package jpa.service;


import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import javax.persistence.*;
import java.util.List;

public class StudentServiceImpl implements StudentService {



	// get all the student
	@Override
	public List<Student> getAllStudents() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> studentList = query.getResultList();
		return studentList;
	}

	// find the student by its email
	@Override
	public Student getStudentByEmail(String sEmail) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
		query.setParameter("email", sEmail);
		Student student = (Student) query.getSingleResult();
		if (student == null) {
			throw new AssertionError("No Student Can Be Found");
		}
		return student;
	}

	// check the credential of log in
	@Override
	public boolean validateStudent(String sEmail, String sPassword) {

		try {
			Student student = getStudentByEmail(sEmail);
			if (student != null && student.getsPass().equals(sPassword)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new AssertionError("No Student Can Be Found");
		}
	}
	
	// register the student to the course
	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
		query.setParameter("email", sEmail);
		Student student = (Student) query.getSingleResult();

		Query query2 = entityManager.createQuery("SELECT c FROM Course c WHERE c.cId = :id");
		query2.setParameter("id", cId);
		try {
			Course course = (Course) query2.getSingleResult();
			if (student.getsCourses().contains(course)) {
				throw new AssertionError("The Course already in Your Cart");
			}
			student.addCourses(course);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			throw new AssertionError("No Course is Found");
		}
	
	}

	// get student by email
	@Override
	public List<Course> getStudentCourses(String sEmail) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
		query.setParameter("email", sEmail);
		Student student = (Student) query.getSingleResult();
		return student.getsCourses();
	}
}
