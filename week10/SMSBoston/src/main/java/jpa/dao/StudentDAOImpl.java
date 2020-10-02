package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAllStudents() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    @Override
    public Student getStudentByEmail(String sEmail) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
        query.setParameter("email", sEmail);
        Student student = (Student) query.getSingleResult();
        return student;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
        query.setParameter("email", sEmail);
        Student student = (Student) query.getSingleResult();
        if (student != null && student.getsPass().equals(sPassword)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerStudentToCourse(String sEmail, int cId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SMSBoston");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.sEmail = :email");
        query.setParameter("email", sEmail);
        Student student = (Student) query.getSingleResult();

        Query query2 = entityManager.createQuery("SELECT c FROM Course c WHERE c.cId = :id");
        query2.setParameter("id", cId);
        Course course = (Course) query.getSingleResult();

        student.getsCourses().add(course);
    }

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
