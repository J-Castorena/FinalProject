package com.skilldistillery.datenight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.datenight.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	@Query(value="SELECT * FROM review WHERE id = :reviewId", nativeQuery = true)
	Review findReviewById(@Param("reviewId") Integer reviewId);
}
