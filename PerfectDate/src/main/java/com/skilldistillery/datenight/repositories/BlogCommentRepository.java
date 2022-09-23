package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.BlogComment;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Integer> {

}
