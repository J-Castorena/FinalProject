package com.skilldistillery.datenight.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUserId(int id);
	
}
