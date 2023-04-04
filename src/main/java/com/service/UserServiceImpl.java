package com.service;

import com.dto.UserDto;


import com.entity.*;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.*;
@Service
@Transactional
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userepo;
	
//	role base registration
	@Override
	public void saveuser(UserDto userdto) 
	{

		User user = new User(userdto.getFirstName(), userdto.getLastName(), userdto.getEmail(),
				userdto.getMobileNo(), userdto.getGender(), userdto.getAddress(), userdto.getCity(), 
				userdto.getState(), userdto.getPinCode(), userdto.getPassword(),userdto.getDate(),
				userdto.getRole());
		
		if(user.getRole().equalsIgnoreCase("Restaurant")) {
			Restaurant restaurant = new Restaurant(userdto.getRestaurantName(),userdto.getLicenseNo(),userdto.getCateogry(),userdto.getRestaurantType(),userdto.getRestaurantImage());
					user.setRestaurant(restaurant);
					restaurant.setUser(user);
	
		}
		
	
		
		userepo.save(user);


		

	}

	
//	Login authentication
	@Override
	public User authenticateUser(String email, String password) {
		
		

		User checkUser = userepo.findByEmailAndPassword(email,password);
		int userId = checkUser.getUserId();
		return checkUser;
		
		
	}

//	get user by id
	@Override
	public User getUserById(int id) {
		
		User user =  userepo.getById(id);
		return user;
	}

	
//	save updated data
	@Override
	public void updateUser(User user) {
		
		this.userepo.save(user);

	}
	
	
	


	
}
