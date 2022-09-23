package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.datenight.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	Review getReviewById(int reviewId);
}
