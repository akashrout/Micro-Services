package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Rating;

public interface RatingService {
	
	//create
	
	Rating create(Rating rating);
	//get all rating
	List<Rating> getAllRatings();
	
	//get all by userId
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	
	

}
