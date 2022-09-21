package com.skilldistillery.datenight.services;

import com.skilldistillery.datenight.entities.User;

public interface AuthService {
	public User register(User user);
	public User getUserByUsername(String username);
	User getUserById(int userId);
}
