package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hotel;

public interface HotelService {
	
	//create
	Hotel createHotel(Hotel hotel);
	
	//getall
	List<Hotel> getAllHotel();
	
	//getone
	Hotel getOneHotel(String hotelId);
	

}
