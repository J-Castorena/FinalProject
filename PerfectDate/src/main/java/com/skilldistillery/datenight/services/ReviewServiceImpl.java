package com.skilldistillery.datenight.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.DateNight;
import com.skilldistillery.datenight.entities.Review;
import com.skilldistillery.datenight.entities.User;
import com.skilldistillery.datenight.repositories.AddressRepository;
import com.skilldistillery.datenight.repositories.DateNightRepository;
import com.skilldistillery.datenight.repositories.ReviewRepository;
import com.skilldistillery.datenight.repositories.UserRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private DateNightRepository dateRepo;
	
	@Override
	public List<Review> index() {
		return reviewRepo.findAll();
	}

	@Override
	public Review reviewById(Integer id) {
		return reviewRepo.findReviewById(id);
	}

	@Override
	public Review createReview(Review review, int dateNightId) {
		DateNight managedDateNight = dateRepo.findDateNightById(dateNightId);
		User user = managedDateNight.getUser();
		review.setUser(user);
		managedDateNight.addReview(review);
		return reviewRepo.saveAndFlush(review);
	}

	@Override
	public Review updateReview(Review review, int id, String username) {
		review.setId(id);
		User loggedInUser = userRepo.findByUsername(username);
		review.setUser(loggedInUser);
		Optional<Review> updatedReview = reviewRepo.findById(id);
		if (updatedReview.isPresent() && ((loggedInUser.getId() == review.getUser().getId()) || loggedInUser.getRole().equals("admin"))) {
			review.getDateNight().setAddress(review.getDateNight().getAddress());
			return reviewRepo.saveAndFlush(review);
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
