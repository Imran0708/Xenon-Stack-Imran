package com.service;

import com.dto.UserDto;
import com.entity.User;

public interface UserService {

	
	void saveuser(UserDto userdto);

	User authenticateUser(String email, String password);

	User getUserById(int userId);
	
	void updateUser(User user);
	
	
	

	



}
