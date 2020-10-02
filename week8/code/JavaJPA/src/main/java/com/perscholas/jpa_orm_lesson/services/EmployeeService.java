package com.perscholas.jpa_orm_lesson.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.perscholas.jpa_orm_lesson.models.Employee;

public class EmployeeService {
	public Integer createEmployee(Employee newEmployee) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newEmployee);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return newEmployee.getEid();
	}
	
	public Employee findEmployee(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee foundEmployee = entityManager.find(Employee.class, eid);
		return foundEmployee;
	}
	
	public void updateEmployeeSalary(int eid, double newSalary) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee foundEmployee = entityManager.find(Employee.class, eid);
		foundEmployee.setSalary(newSalary);
		entityManager.getTransaction().commit();
	}
	
	public void removeEmployee(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee foundEmployee = entityManager.find(Employee.class, eid);
		entityManager.remove(foundEmployee);
		entityManager.getTransaction().commit();
	}

}
