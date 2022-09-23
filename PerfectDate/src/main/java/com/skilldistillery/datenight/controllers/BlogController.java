package com.skilldistillery.datenight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.Blog;
import com.skilldistillery.datenight.services.BlogService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class BlogController {
	
	@Autowired
	private BlogService blogServ;
	
	@GetMapping("blogs")
	public List<Blog> listAllBlogs() {
		return blogServ.listAllBlogs();
	}
	

}
