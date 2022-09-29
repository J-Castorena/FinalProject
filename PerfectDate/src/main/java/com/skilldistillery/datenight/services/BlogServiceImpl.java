package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Blog;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.BlogRepository;
import com.skilldistillery.datenight.repositories.UserRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepo;
	
	@Autowired 
	private UserRepository userRepo;

	@Override
	public List<Blog> listAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public List<Blog> listBlogByUserId(int id) {
		return blogRepo.findByUserId(id);
	}
	

	@Override
	public Blog createBlog(int id, Blog blog) {
		Optional<User> userOp = userRepo.findById(id);
		if (userOp.isPresent()) {
			User user = userOp.get();
			blog.setUser(user);
			blogRepo.saveAndFlush(blog);
			return blog;
		}
		return null;
	}

	@Override
	public Blog updateBlog(Blog blog, int id) {
		Blog existing = findById(blog.getId());
		if (existing == null) {
			return null;
		}
		existing.setTitle(blog.getTitle());
		existing.setImageUrl(blog.getImageUrl());
		existing.setActive(blog.getActive());
		existing.setComments(blog.getComments());
		existing.setBlogDate(blog.getBlogDate());
		return blogRepo.saveAndFlush(existing);
	}

	private Blog findById(int id) {
		Blog b = null;
		Optional<Blog> blogOp = blogRepo.findById(id);
		if (blogOp.isPresent()) {
			b = blogOp.get();
		}
		return b;
	}

	@Override
	public boolean deleteBlog(int id) {
		Optional<Blog> blogToDeactivate = blogRepo.findById(id);
		if(blogToDeactivate.isPresent()) {
			Blog blog = blogToDeactivate.get();
			blog.setActive(false);
			blogRepo.saveAndFlush(blog);
			return true;
		}
		return false;
	}

}
