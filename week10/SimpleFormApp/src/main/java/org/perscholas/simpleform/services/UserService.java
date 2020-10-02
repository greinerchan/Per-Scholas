package org.perscholas.simpleform.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.perscholas.simpleform.models.User;





public class UserService {
	
	
	public User findUserByEmail(String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserSimpleForm Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email");
		query.setParameter("email", email);
		User user = (User)query.getSingleResult();
		return user;
	}
	
//	public Integer createUser(User newUser) {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UserSimpleForm Test");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		entityManager.persist(newUser);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		entityManagerFactory.close();
//		return newUser.getUserId();
//	}
	
	

}
