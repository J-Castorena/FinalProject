package com.skilldistillery.datenight.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.services.UserService;

@RestController
@RequestMapping(path= "api")
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> index(){
		return userSvc.index();
	}
	
	@GetMapping("users/{userId}")
	public User getById(@PathVariable int userId, HttpServletResponse res ) {
		User user = userSvc.getUserById(userId);
		if(user == null) {
			res.setStatus(404);
		}
		return user;
	}
	
	@GetMapping("users/{username}")
	public User getByUsername(@PathVariable String username, HttpServletResponse res) {
		User user = userSvc.getUserbyUsername(username);
		if(user == null) {
			res.setStatus(404);
		}
		return user;
	}
	
	@PostMapping("users")
	public User create(@RequestBody User user, HttpServletResponse res) {
		User newUser = userSvc.create(user);
		if(newUser == null) {
			res.setStatus(400);
			return null;
		}
		res.setStatus(201);
		return newUser;
	}
	
	@PutMapping("users/{userId}")
	public User update(@RequestBody User user, @PathVariable int userId,HttpServletResponse res) {
		return userSvc.update(user, userId);
	}
	
	@DeleteMapping("users/{userId}")
	public void destroy(@PathVariable int userId, HttpServletResponse res) {
		if(userSvc.deleteUser(userId)) {
			res.setStatus(204);
		}else {
			res.setStatus(404);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
