package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Restaurant")
public class Restaurant {

	@Id
	private int id;
	private String name;
	private String address;
	private String zipcode;
	private String phone;
	private String website;
	private String email;
	@ManyToMany
	@JoinTable(name = "foodtypes_restaurants",
			joinColumns = @JoinColumn(name = "FoodtypeId"),
			inverseJoinColumns = @JoinColumn(name = "RestaurantId"))
	private List<Foodtype> foodtypeRestaurant;
	@OneToMany(targetEntity = Review.class)
	List<Review> rList;
	


	public Restaurant() {
		
		this.foodtypeRestaurant = new ArrayList<>();
	}



	public Restaurant(int id, String name, String address, String zipcode, String phone, String website, String email) {
		this();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.phone = phone;
		this.website = website;
		this.email = email;
	
	}

	public List<Foodtype> getFoodtypeRestaurant() {
		return foodtypeRestaurant;
	}

	public void setFoodtypeRestaurant(List<Foodtype> foodtypeRestaurant) {
		this.foodtypeRestaurant = foodtypeRestaurant;
	}

	public List<Review> getrList() {
		return rList;
	}

	public void setrList(List<Review> rList) {
		this.rList = rList;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
