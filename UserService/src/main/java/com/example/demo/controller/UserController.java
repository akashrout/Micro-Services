package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	//create user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user2 =  userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
		
	}
	
	//get single user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		User user = userServices.getSingleUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
	//get all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userServices.getAllUser();
		return ResponseEntity.ok(allUser);
		
	}

}
