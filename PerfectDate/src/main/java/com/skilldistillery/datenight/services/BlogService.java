package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.Blog;

public interface BlogService {

	List<Blog> listAllBlogs();

	List<Blog> listBlogByUserId(int id);

	Blog createBlog(Blog blog);

	Blog updateBlog(Blog blog, int id);

	boolean deleteBlog(int id);

}
