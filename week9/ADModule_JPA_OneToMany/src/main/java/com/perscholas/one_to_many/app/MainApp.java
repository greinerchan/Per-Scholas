package com.perscholas.one_to_many.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.perscholas.one_to_many.models.Department;
import com.perscholas.one_to_many.models.Teacher;


public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("Relationship Test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Teacher teacher1 = new Teacher(1, "Mike", 60000);
		manager.persist(teacher1);
		
		Teacher teacher2 = new Teacher(2, "Bairon", 80000);
		manager.persist(teacher2);
		
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(teacher1);
		teacherList.add(teacher2);
		
		Department dept1 = new Department(1, "Test Department", teacherList);
		manager.persist(dept1);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
