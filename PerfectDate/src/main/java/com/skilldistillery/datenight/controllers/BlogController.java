package com.skilldistillery.datenight.controllers;

import java.util.List;

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

	@GetMapping("user/{id}/blogs")
	public List<Blog> listBlogByUser(@PathVariable int id, HttpServletResponse resp) {
		List<Blog> blogs = blogServ.listBlogByUserId(id);
		if (blogs == null) {
			resp.setStatus(404);
		}
		return blogs;
	}

	@PostMapping("blogs")
	public Blog createBlog(@RequestBody Blog blog, HttpServletResponse resp) {
		Blog created = null;
		try {
			created = blogServ.createBlog(blog);
			resp.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
		return created;
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
