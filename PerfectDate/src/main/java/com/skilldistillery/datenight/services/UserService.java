package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.User;

public interface UserService {

	List<User> index();
	
	User getUserById(int userId, String username);
	
	User getUserbyUsername(String username);
	
	User create(User user);
	
	User update(User user, int userId);
	
	boolean deleteUser(int userId);
	
}
