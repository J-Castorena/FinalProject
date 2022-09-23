package com.skilldistillery.datenight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.Review;
import com.skilldistillery.datenight.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Override
	public List<Review> index() {
		return reviewRepo.findAll();
	}

	@Override
	public Review reviewById(Integer id) {
		return reviewRepo.findReviewById(id);
	}

	@Override
	public Review createReview(Review review) {
		return reviewRepo.saveAndFlush(review);
	}

	@Override
	public Review updateReview(Review review) {
		Review reviewToUpdate = reviewRepo.findReviewById(review.getId());
		if(reviewToUpdate != null) {
			reviewToUpdate.setRating(review.getRating());
			reviewToUpdate.setComment(review.getComment());
			reviewToUpdate.setReviewDate(review.getReviewDate());
			reviewRepo.saveAndFlush(reviewToUpdate);
			return (reviewToUpdate);
		}
		return null;
	}

	@Override
	public boolean deleteReview(Integer id) {
		boolean reviewDeleted = false;
		if(reviewRepo.existsById(id)) {
			reviewRepo.deleteById(id);
			reviewDeleted = true;
		}
		return reviewDeleted;
	}

}
