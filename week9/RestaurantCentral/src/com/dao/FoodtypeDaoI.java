package com.dao;

import com.entity.Foodtype;
import com.entity.Restaurant;

import java.util.List;

public interface FoodtypeDaoI {

  //create
  void add(Foodtype foodtype);
  void addFoodtypeToRestaurant(Foodtype foodtype, Restaurant restaurant);

  //read
  List<Foodtype> getAll();
  List<Restaurant> getAllRestaurantsForAFoodtype(int id);

  //update - user will be able to update any field of a record except the ID
  boolean update(int id);

  //delete
  void deleteById(int id);
  void clearAll();
}
