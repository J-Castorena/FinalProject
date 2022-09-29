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

import com.skilldistillery.datenight.entities.BlogComment;
import com.skilldistillery.datenight.services.BlogCommentService;

@CrossOrigin({ "*", "http://localhost/" })
@RestController
@RequestMapping("api")
public class BlogCommentController {

	@Autowired
	private BlogCommentService commentServ;

	@GetMapping("comments")
	public List<BlogComment> listAllComments() {
		return commentServ.listAllComments();
	}

	@GetMapping("blogs/{id}/comments")
	public List<BlogComment> listBlogCommentsByBlogId(@PathVariable int id, HttpServletResponse resp) {
		List<BlogComment> comments = commentServ.listCommentsByBlogId(id);
		if (comments == null) {
			resp.setStatus(404);
		}
		return comments;
	}

	@GetMapping("blogs/{id}/replies")
	public List<BlogComment> findReplies(@PathVariable int id){
		return commentServ.findReplies(id);
	}
	
	@PostMapping("blogs/{id}/comments")
	public BlogComment addBlogCommentByBlogId(
			@PathVariable int id, 
			@RequestBody BlogComment comment,
			HttpServletResponse resp,
			HttpServletRequest req, Principal principal) {
		try {
			comment = commentServ.createBlogComment(id, comment, principal.getName());
			if (comment == null) {
				resp.setStatus(404);
			} else {
				resp.setStatus(201);
				StringBuffer url = req.getRequestURL();
				resp.setHeader("Location", url.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(404);
		}

		return comment;
	}

	@PutMapping("comments/{id}")
	public BlogComment updateBlogComment(
			@PathVariable int id, 
			@RequestBody BlogComment comment,
			HttpServletResponse resp) {
		BlogComment updated = null;
		comment.setId(id);
		try {
			updated = commentServ.updateBlogComment(id, comment);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return updated;
	}
	
	@DeleteMapping("comments/{id}")
	public Boolean deleteBlogComment(
			@PathVariable int id, 
			HttpServletResponse resp) {
		boolean deleted = commentServ.deleteBlogComment(id);
		if (deleted) {
			resp.setStatus(204);
		}else {
			resp.setStatus(404);
		}
		return deleted;
	}
	
}
