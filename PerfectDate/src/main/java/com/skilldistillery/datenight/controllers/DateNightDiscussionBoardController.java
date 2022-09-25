package com.skilldistillery.datenight.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("users/{id}/discussions")
	public DateNightDiscussionBoard addDiscussionBoardByUser(
			@PathVariable int id, 
			@RequestBody DateNightDiscussionBoard discussion,
			HttpServletResponse resp,
			HttpServletRequest req) {
		discussion = discussionServ.createDateNightDiscussionBoard(id, discussion);
		try {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			resp.setHeader("Location", url.toString());
		} catch (Exception e ) {
			e.printStackTrace();
			resp.setStatus(400);
			discussion = null;
		}
		return discussion;
	}
	
	@PutMapping("discussions/{id}")
	public DateNightDiscussionBoard updateDateNightDiscussionBoard(
			@PathVariable int id, 
			@RequestBody DateNightDiscussionBoard discussion,
			HttpServletResponse resp) {
		DateNightDiscussionBoard updateDiscussion = null;
		discussion.setId(id);
		try {
			updateDiscussion = discussionServ.updateDateNightDiscussionBoard(id, discussion);
			if (updateDiscussion == null) {
				resp.setStatus(404);
			}
		}catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			System.err.println("Error updating discussion Board");
		}
		return updateDiscussion;
	}
	
	@DeleteMapping("/discussions/{id}")
	public void deleteDateNightDiscussionBoard(
			@PathVariable int id, 
			HttpServletResponse resp) {
		try {
			boolean dateNightDiscussionBoardIsDeleted = discussionServ.deleteDateNightDiscussionBoard(id);
			if (dateNightDiscussionBoardIsDeleted) {
				resp.setStatus(204);
			}else {
				resp.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			
		}
	}

}
