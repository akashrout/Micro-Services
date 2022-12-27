package com.example.demo.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourcesNotFoundException;
import com.example.demo.external.service.HotelService;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;


@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		//to generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// Implementing RATING SERVICE call : using RestTemplate
		
		return userRepository.findAll();
	}

	@Override
	public User getSingleUser(String userId) {
		// get single user
		User user =  userRepository.findById(userId)
				.orElseThrow(() -> new ResourcesNotFoundException("User with given ID is not available.." + userId));
		
		//fetch rating of above user from RATING SERVICE
		//http://localhost:9999/ratings/users/ee8ae41a-6a54-4e00-bec4-68e26a0d3bd2
		
		Rating[] ratingsOfUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} ", ratingsOfUser);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());
		
		List<Rating> ratingList =   ratings.stream().map(rating -> {
			//api call to hotel service
			//http://localhost:8888/hotels/49db219e-b37b-4046-b617-e50ae0332d19
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
//			logger.info("Hotel Response Status: {} ",forEntity.getStatusCode());
			//set the hotel to rating
			rating.setHotel(hotel);
			//return rating
			
			
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}

}
