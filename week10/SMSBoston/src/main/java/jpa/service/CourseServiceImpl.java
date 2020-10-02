package jpa.service;

import jpa.entitymodels.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class CourseServiceImpl implements CourseService {


	@Override
	public List<Course> getAllCourses() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Course c");
		List<Course> courseList = query.getResultList();
		return courseList;
	}

}
