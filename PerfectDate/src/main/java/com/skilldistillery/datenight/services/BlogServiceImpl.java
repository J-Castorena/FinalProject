package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Blog;
import com.skilldistillery.datenight.repositories.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepo;

	@Override
	public List<Blog> listAllBlogs() {
		return blogRepo.findAll();
	}

	@Override
	public List<Blog> listBlogByUserId(int id) {
		return blogRepo.findByUserId(id);
	}

	@Override
	public Blog createBlog(Blog blog) {
		if (blog.getUser() == null) {
			blog.setUser(null);
		}
		return blogRepo.saveAndFlush(blog);
	}

	@Override
	public Blog updateBlog(Blog blog, int id) {
		Blog existing = findById(blog.getId());
		if (existing == null) {
			return null;
		}
		existing.setUser(blog.getUser());
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
		blogRepo.deleteById(id);
		return !blogRepo.existsById(id);
	}

}
