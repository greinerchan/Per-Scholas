package com.implementations;

import com.dao.DataSourceDAO;
import com.dao.FoodtypeDaoI;
import com.entity.Foodtype;
import com.entity.Restaurant;

import java.util.List;

public class FoodtypeDaoImpl extends DataSourceDAO implements FoodtypeDaoI { // don't forget to shake hands with your interface!

	@Override
	public void add(Foodtype foodtype) {
	}

	@Override
	public List<Foodtype> getAll() {
		return null;
	}

	@Override
	public void deleteById(int id) {
	}

	@Override
	public void clearAll() {
	}

	@Override
	public void addFoodtypeToRestaurant(Foodtype foodtype, Restaurant restaurant) {
	}

	@Override
	public List<Restaurant> getAllRestaurantsForAFoodtype(int foodtypeId) {
		return null;
	}

	@Override
	public boolean update(int id) {
		return false;
	}

}
