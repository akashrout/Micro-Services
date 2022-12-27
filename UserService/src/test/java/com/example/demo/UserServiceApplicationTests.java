package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Rating;
import com.example.demo.external.service.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private RatingService ratingService;
	
//	@Test
//	void createRating() {		
//		
//		Rating rating = Rating.builder().rating(21).userId("").feedback("Created using feign client").build();
//		ResponseEntity<Rating> createRating = ratingService.createRating(rating);
//		HttpStatus statusCode = createRating.getStatusCode();
//		System.out.println("new record created: "+createRating.getBody()+"..."+statusCode);
//		
//	}

}
