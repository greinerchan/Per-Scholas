package org.perscholas.simpleform.app;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.perscholas.simpleform.models.User;
import org.perscholas.simpleform.services.UserService;





public class UserApp {

	public static void main(String[] args) {
	
			EntityManagerFactory factory  = Persistence.createEntityManagerFactory("UserSimpleForm Test");
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
//			
//			//User u1 = new User(1, "Mike", "Rupert", "mike@gmail.com","1234");
//			
//			
//		//	manager.persist(u1);
//			
//			
//			manager.getTransaction().commit();
//			manager.close();
//			factory.close();

			UserService us=new UserService();
		
			User u2=us.findUserByEmail("mike@gmail.com");
			System.out.println(u2.getFirstName());
		
		}
	}

