//package jpa.dao;
//
//import jpa.entitymodels.Course;
//import org.eclipse.persistence.sessions.factories.SessionFactory;
//
//import javax.persistence.*;
//import java.util.List;
//
//public class CourseDAOImpl implements CourseDAO{
//
//    @PersistenceContext
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Course> getAllCourses() {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createQuery("SELECT c FROM Course c");
//        List<Course> courseList = query.getResultList();
//        return courseList;
//    }
//}
