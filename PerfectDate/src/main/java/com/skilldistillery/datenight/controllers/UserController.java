package com.skilldistillery.datenight.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> index(){
		return userSvc.index();
	}
	
	@GetMapping("users/{userId}")
	private User getById(@PathVariable int userId, HttpServletResponse res ) {
		User user = userSvc.getUserById(userId);
		if(user == null) {
			res.setStatus(404);
		}
		return user;
	}
	
	
	
}
