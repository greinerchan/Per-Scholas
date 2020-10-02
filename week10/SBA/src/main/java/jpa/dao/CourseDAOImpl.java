package jpa.dao;

import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CourseDAOImpl implements CourseDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getAllCourses() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Course> theQuery =
                currentSession.createQuery("from Course", Course.class);
        List<Course> courseList = theQuery.getResultList();
        return courseList;
    }
}
