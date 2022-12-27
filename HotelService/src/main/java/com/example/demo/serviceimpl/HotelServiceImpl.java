package com.example.demo.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HotelRepo;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelrepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelrepo.findAll();
	}

	@Override
	public Hotel getOneHotel(String hotelId) {
		// TODO Auto-generated method stub
		return hotelrepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with given Id not found!!"));
	}

}
