package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	@Transactional
	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}

}
