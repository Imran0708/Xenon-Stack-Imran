package com.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.UserDto;

import com.entity.*;
import com.repository.MenuRepository;
import com.repository.RestaurantRepository;


@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	

	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private MenuRepository menuRepository;
	
	

	@Override
	public List<Restaurant> getallRestaurants() {

		return restaurantRepo.findAll();
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		
		Restaurant restaurant =restaurantRepo.getById(id);
		return restaurant;
	}

	
	public Restaurant getByUserdId(int id)
	{
		Restaurant restid = restaurantRepo.getRestByyUserId(id);
		
		return restid;
	}

	
	

	
	
	
	

	
	
}
