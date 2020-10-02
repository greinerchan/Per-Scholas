package com.perscholas.many_to_one.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.perscholas.many_to_one.models.Department;
import com.perscholas.many_to_one.models.Teacher;


public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("Relationship Test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Department dept1 = new Department(1, "Test Department");
		manager.persist(dept1);
		
		Teacher teacher1 = new Teacher(1, "Mike", 60000, dept1);
		manager.persist(teacher1);
		
		Teacher teacher2 = new Teacher(2, "Bairon", 80000, dept1);
		manager.persist(teacher2);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
