package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Blog;
import com.skilldistillery.datenight.entities.BlogComment;
import com.skilldistillery.datenight.repositories.BlogCommentRepository;
import com.skilldistillery.datenight.repositories.BlogRepository;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {
	
	@Autowired
	private BlogCommentRepository commentRepo;
	
	@Autowired
	private BlogRepository blogRepo;

	@Override
	public List<BlogComment> listAllComments() {
		return commentRepo.findAll();
	}

	@Override
	public List<BlogComment> listCommentsByBlogId(int id) {
		return commentRepo.findByBlogId(id);
	}

	@Override
	public BlogComment createBlogComment(int id, BlogComment comment) {
		Optional<Blog> blogOp = blogRepo.findById(id);
		if (blogOp.isPresent()) {
			Blog blog = blogOp.get();
			comment.setBlog(blog);
			commentRepo.saveAndFlush(comment);
			return comment;
			}
		return null;
	}

	@Override
	public BlogComment updateBlogComment(int id, BlogComment comment) {
		BlogComment existing = findById(comment.getId());
		if (existing == null) {
			return null;
		}
		existing.setUser(comment.getUser());
		existing.setMessage(comment.getMessage());
		existing.setBlogCommentDate(comment.getBlogCommentDate());
		existing.setBlog(comment.getBlog());
		existing.setImageUrl(comment.getImageUrl());
		return commentRepo.saveAndFlush(existing);
	}

	private BlogComment findById(int id) {
		BlogComment c = null;
		Optional<BlogComment> commentOp = commentRepo.findById(id);
		if (commentOp.isPresent()) {
			c = commentOp.get();
		}
		return c;
	}

	@Override
	public boolean deleteBlogComment(int id) {
		commentRepo.deleteById(id);
		return !commentRepo.existsById(id);
	}

	
	

}








