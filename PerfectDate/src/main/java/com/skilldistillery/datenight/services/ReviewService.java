package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.Review;

public interface ReviewService {
	List<Review> index();

	Review reviewById(Integer id);

	Review createReview(Review review);

	Review updateReview(Review review);

	boolean deleteReview(Integer id);
}
