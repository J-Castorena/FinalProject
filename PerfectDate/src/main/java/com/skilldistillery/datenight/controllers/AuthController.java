package com.skilldistillery.datenight.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.services.AuthService;

@RestController
@CrossOrigin({"*", "http://localhost/"})
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("register")
	public User register(@RequestBody User user, HttpServletResponse res) {
	  if (user == null) {
	     res.setStatus(400);
	     return null;
	  }
	  user = authService.register(user);
	  return user;
	}
	 
	@GetMapping("authenticate")
	public User authenticate(Principal principal, HttpServletResponse res) {
	  if (principal == null) { // no Authorization header sent
	     res.setStatus(401);
	     res.setHeader("WWW-Authenticate", "Basic");
	     return null;
	  }
	  return authService.getUserByUsername(principal.getName());
	}
	
	// SMOKE TEST ONLY, DELETE/COMMENT OUT LATER
	@GetMapping("test/users/{userId}")
	public User getUserForTest(
	  @PathVariable Integer userId,
	  HttpServletResponse res
	) {
	  User user = authService.getUserById(userId);
	  if (user == null) {
	    res.setStatus(404);
	  }
	  return user;
	}
	
	
}
