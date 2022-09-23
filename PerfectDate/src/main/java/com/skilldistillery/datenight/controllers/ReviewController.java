package com.skilldistillery.datenight.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.services.ReviewService;

@RestController
@CrossOrigin({"*", "http://localhost/"})
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	
}
