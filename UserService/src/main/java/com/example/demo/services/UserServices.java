package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.User;

public interface UserServices {
	
	//create
	User saveUser(User user);
	
	//getAll
	List<User> getAllUser();
	
	
	//getSingle user of given Id
	User getSingleUser(String userId);
	
	//delete
	
	//update

}
