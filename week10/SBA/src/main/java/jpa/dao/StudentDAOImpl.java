package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
        List<Student> studentList = theQuery.getResultList();
        return studentList;
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, sEmail);
        return student;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, sEmail);
        if (student.getsPass().equals(sPassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, sEmail);
        Course course = currentSession.get(Course.class, cId);
        student.getsCourses().add(course);
    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, sEmail);
        return student.getsCourses();
    }
}
