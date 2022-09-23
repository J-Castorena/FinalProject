package com.skilldistillery.datenight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.DateNightDiscussionBoard;
import com.skilldistillery.datenight.services.DateNightDiscussionBoardService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class DateNightDiscussionBoardController {
	
	@Autowired
	private DateNightDiscussionBoardService discussionServ;
	
	@GetMapping("discussions")
	public List<DateNightDiscussionBoard> listAllDiscussions(){
		return discussionServ.listAllDiscussions();
	}
	
	

}
