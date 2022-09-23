package com.skilldistillery.datenight.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.Blog;
import com.skilldistillery.datenight.services.BlogService;

@CrossOrigin({ "*", "http://localhost/" })
@RestController
@RequestMapping("api")
public class BlogController {

	@Autowired
	private BlogService blogServ;

	@GetMapping("blogs")
	public List<Blog> listAllBlogs() {
		return blogServ.listAllBlogs();
	}

	@GetMapping("users/{id}/blogs")
	public List<Blog> listBlogByUser(
			@PathVariable int id, 
			HttpServletResponse resp) {
		List<Blog> blogs = blogServ.listBlogByUserId(id);
		if (blogs == null) {
			resp.setStatus(404);
		}
		return blogs;
	}

	@PostMapping("users/{id}/blogs")
	public Blog addBlogByUserId(
			@PathVariable int id,
			@RequestBody Blog blog, 
			HttpServletResponse resp,
			HttpServletRequest req) {
		blog = blogServ.createBlog(id, blog);
	
	try {
		if (blog == null) {
			resp.setStatus(404);
		}else {
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			resp.setHeader("Location", url.toString());
		}
	} catch (Exception e) {
		e.printStackTrace();
		resp.setStatus(404);
	}
		return blog;
	}

	@PutMapping("blogs/{id}")
	public Blog updateBlog(@RequestBody Blog blog, @PathVariable int id, HttpServletResponse resp) {
		Blog updated = null;
		blog.setId(id);
		try {
			updated = blogServ.updateBlog(blog, id);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return updated;
	}

	@DeleteMapping("blogs/{id}")
	public Boolean deleteBlog(@PathVariable int id, HttpServletResponse resp) {
		Boolean deleted = blogServ.deleteBlog(id);
		if (deleted) {
			resp.setStatus(204);
		} else {
			resp.setStatus(404);
		}
		return deleted;
	}

}
