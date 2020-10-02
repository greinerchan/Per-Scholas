package com.implementations;

import com.dao.DataSourceDAO;
import com.dao.ReviewDaoI;
import com.entity.Review;
import java.util.List;

public class ReviewDaoImpl extends DataSourceDAO implements ReviewDaoI {
	
  @Override
  public void add(Review review) {
  }

  @Override
  public List<Review> getAll() {
	return null;
  }

  @Override
  public List<Review> getAllReviewsByRestaurant(int restaurantId) {
	return null;
  }

  @Override
  public void deleteById(int id) {
  }

  @Override
  public void clearAll() {
	  
  }
}