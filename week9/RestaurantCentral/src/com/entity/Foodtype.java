package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Foodtype")
public class Foodtype {
	@Id
	private int id; //01
	private String name; //Sea food
	@ManyToMany(mappedBy="foodtypes_restaurants")
	private List<Restaurant> restaurantList;
	
	public Foodtype(){
		this.restaurantList = new ArrayList<>();
	}
	
	
	public Foodtype(Integer id, String name){
		
		this();
		this.id = id;
		this.name = name;	
		
	}
	
	public List<Restaurant> getRestaurantList() {
		return restaurantList;
	}
	public void setRestaurantList(List<Restaurant> rList) {
		this.restaurantList = rList;
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
}
