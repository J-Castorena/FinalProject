package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.Review;

public interface ReviewService {
	List<Review> index();

	Review reviewById(Integer id);

	Review createReview(Review review, int dateNightId);

	Review updateReview(Review review, int id, String username);

	boolean deleteReview(Integer id);
}
