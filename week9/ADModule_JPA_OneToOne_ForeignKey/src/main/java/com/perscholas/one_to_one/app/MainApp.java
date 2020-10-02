package com.perscholas.one_to_one.app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.perscholas.one_to_one.models.Credential;
import com.perscholas.one_to_one.models.Teacher;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Relationship Test");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();

		int whichPart;

		Scanner s = new Scanner(System.in);
		System.out.println("Which part would you like to run?");
		whichPart = s.nextInt();

		if (whichPart == 1) {
			// Part 1 *************************************************

			Credential credential1 = new Credential(1, "teacher1", "teach1234");
			manager.persist(credential1);
			Teacher teacher1 = new Teacher(1, "Mike", 60000);
			teacher1.setCredential(credential1);
			manager.persist(teacher1);

			Credential credential2 = new Credential(2, "teacher2", "teach5678");
			manager.persist(credential2);
			Teacher teacher2 = new Teacher(2, "Bairon", 80000);
			teacher2.setCredential(credential2);
			manager.persist(teacher2);

			Teacher teacher3 = new Teacher(3, "John", 80000);
			manager.persist(teacher3);

		} else if (whichPart == 2) {
			// Part 2 *************************************************

			Query q = manager.createQuery("SELECT t from Teacher t WHERE t.id = 3");
			try {
				Teacher tempTch = (Teacher) q.getSingleResult();
				Credential c = new Credential(3, "teacher3", "teach3456");
				manager.persist(c);
				tempTch.setCredential(c);
				manager.persist(tempTch);

			} catch (NoResultException nre) {
				System.out.println("Teacher not found.");
			}

		} else {
			System.out.println("Invalid choice.");
		}
		s.close();

		try {
			manager.getTransaction().commit();
		} catch (Exception commit_e) {
			System.out.println("Transaction not completed. Something went wrong!!!");
			System.out.println(commit_e.getMessage());
		} finally {
			manager.close();
			factory.close();
		}
	}
}
