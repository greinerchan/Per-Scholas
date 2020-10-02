package com.perscholas.many_to_many.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.perscholas.many_to_many.models.Department;
import com.perscholas.many_to_many.models.Teacher;

public class MainApp2 {
	public static void main(String[] args) {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("Relationship Test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		// Retrieve Teacher Bairon from database and assign to tempTch
		Teacher tempTch = manager.find(Teacher.class, 2);
		// Retrieve Test Department 3 from the database and add to Mike's list of departments
		Department tempDep = manager.find(Department.class, 2);
		tempTch.getTeacherDepartments().add(tempDep);
		// This is another way to add a department to a teacher's list
		tempTch.getTeacherDepartments().add(manager.find(Department.class, 3));
		// Bairon should now have two departments - 2 & 3
		
		// Assign Test Department 4 to Mary
		tempDep = manager.find(Department.class, 4);
		tempTch = manager.find(Teacher.class, 3);
		tempTch.getTeacherDepartments().add(tempDep);
		
		manager.getTransaction().commit();
		manager.close();

	}
}
