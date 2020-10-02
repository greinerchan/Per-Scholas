package com.perscholas.many_to_many.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.perscholas.many_to_many.models.Department;
import com.perscholas.many_to_many.models.Teacher;


public class MainApp1 {
	public static void main(String[] args) {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("Relationship Test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Teacher teacher1 = new Teacher(1, "Mike", 60000);
		manager.persist(teacher1);
		
		// Bairon and Mary will be given departments in MainApp2
		manager.persist(new Teacher(2, "Bairon", 70000));
		manager.persist(new Teacher(3, "Mary", 80000));
		
		Department dept1 = new Department(1, "Test Department 1");
		manager.persist(dept1);
		
		Department dept2 = new Department(2, "Test Department 2");
		manager.persist(dept2);	
		
		teacher1.getTeacherDepartments().add(dept1);
		teacher1.getTeacherDepartments().add(dept2);
		
		// Test departments 3 & 4 will be assigned to a teachers in MainApp2
		manager.persist(new Department(3, "Test Department 3"));
		manager.persist(new Department(4, "Test Department 4"));	

		manager.getTransaction().commit();
		manager.close();

	}
}
