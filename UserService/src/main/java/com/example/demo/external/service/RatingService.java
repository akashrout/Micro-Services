package com.example.demo.external.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Rating;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	//get
	
	//post
	@PostMapping("/ratings")
	ResponseEntity<Rating> createRating(Rating rating);
	
	//put
	@PutMapping("/ratings/{ratingId}")
	ResponseEntity<Rating>  upadteRating(@PathVariable("ratingId") String ratingId,Rating rating);
	
	//delete
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);

}
