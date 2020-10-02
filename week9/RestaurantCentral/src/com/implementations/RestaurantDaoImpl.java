package com.implementations;

import com.dao.DataSourceDAO;
import com.dao.RestaurantDaoI;
import com.entity.Foodtype;
import com.entity.Restaurant;
import java.util.List;

public class RestaurantDaoImpl extends DataSourceDAO implements RestaurantDaoI { //don't forget to shake hands with your interface!

  @Override
  public void add(Restaurant restaurant) {
  }

  @Override
  public List<Restaurant> getAll() {
	return null;
  }

  @Override
  public Restaurant findById(int id) {
	return null;

  }

  @Override
  public boolean update(int id) {
	return false;
  }

  @Override
  public void deleteById(int id) {
  }

  @Override
  public void clearAll() {
  }

  @Override
  public void addRestaurantToFoodtype(Restaurant restaurant, Foodtype foodtype){

  }

  @Override
  public List<Foodtype> getAllFoodtypesByRestaurant(int restaurantId){
	return null;
  }

}
