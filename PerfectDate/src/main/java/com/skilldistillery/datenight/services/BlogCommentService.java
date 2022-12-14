package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.BlogComment;

public interface BlogCommentService {
	

	List<BlogComment> listAllComments();

	List<BlogComment> listCommentsByBlogId(int id);

	BlogComment createBlogComment(int id, BlogComment comment, String username);
	
	BlogComment updateBlogComment(int id, BlogComment comment);
	
	boolean deleteBlogComment(int id);
	
	List<BlogComment> findReplies(int id);
}
