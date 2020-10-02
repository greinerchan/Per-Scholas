package com.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Foodtype;
import com.entity.Restaurant;

public class RestaurantCentral {

	public static void main(String[] args) {
		
		//int id, String name, String address, String zipcode, String phone, String website, String email)
		//id, name, address, zipcode, phone, website, email
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("RestaurantCentral");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();

		Foodtype ft = new Foodtype(1,"pasta");
		manager.persist(ft);
		Restaurant r1 = new Restaurant(1, "name1", "address1", "11111", "phone1", "website1", "email1");
		manager.persist(r1);
		Restaurant r2 = new Restaurant(2, "name2", "address2", "11112", "phone2", "website2", "email2");
		manager.persist(r2);
		//manager.persist(new Restaurant(2, "name2", "address2", "11112", "phone2", "website2", "email2"));
		ft.getRestaurantList().add(r1);
		ft.getRestaurantList().add(r2);
		


		
		
		

	}

}
