package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
