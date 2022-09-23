package com.skilldistillery.datenight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.BlogComment;
import com.skilldistillery.datenight.services.BlogCommentService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class BlogCommentController {

	
	@Autowired
	private BlogCommentService commentServ;
	
	@GetMapping
	public List<BlogComment> listAllComments(){
		return commentServ.listAllComments();
	}
}
