package com.skilldistillery.datenight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.BlogComment;
import com.skilldistillery.datenight.repositories.BlogCommentRepository;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {
	
	@Autowired
	private BlogCommentRepository commentRepo;

	@Override
	public List<BlogComment> listAllComments() {
		return commentRepo.findAll();
	}

	
	

}
