package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> index() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int userId, String username) {
		User user = null;
		Optional<User> op = userRepo.findById(userId);
		if(op.isPresent()) {
			user= op.get();
		}
		return user;
	}

	@Override
	public User getUserbyUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User create(User user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User update(User user, int userId) {
		Optional<User> op = userRepo.findById(userId);
		User users = null;
		if(op.isPresent()) {
			users = op.get();
			users.setEnabled(user.getEnabled());
			users.setRole(user.getRole());
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			users.setEmail(user.getEmail());
			users.setUsername(user.getUsername());
			users.setPassword(user.getPassword());
			users.setImageUrl(user.getImageUrl());
			users.setBiography(user.getBiography());
			users.setDob(user.getDob());
			userRepo.saveAndFlush(users);
			return(users);
		}
		return users;
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean deleted = false;
		if(userRepo.existsById(userId)) {
			userRepo.deleteById(userId);
			deleted = true;
		}
		return deleted;
	}

}
