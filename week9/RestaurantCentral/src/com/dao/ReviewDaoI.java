package com.dao;

import com.entity.Review;
import java.util.List;

public interface ReviewDaoI {

  //create
  void add(Review review);

  //read
  List<Review> getAll();
  List<Review> getAllReviewsByRestaurant(int restaurantId);
  
  //no update for the review

  //delete
  void deleteById(int id);
  void clearAll();
}
