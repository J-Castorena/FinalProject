package com.skilldistillery.datenight.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.datenight.entities.Review;
import com.skilldistillery.datenight.services.ReviewService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost"})
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("reviews")
	public List<Review> showAllReviews(){
		return reviewService.index();
	}
	
	@GetMapping("reviews/{id}")
	public Review reviewById(@PathVariable Integer id) {
		return reviewService.reviewById(id);
	}
	@GetMapping("reviews/datenights/{id}")
	public List<Review> reviewByDateNightId(@PathVariable Integer id) {
		return reviewService.reviewByDateNightId(id);
	}

	@PostMapping("reviews/{dateNightId}")
	public Review addReview(@RequestBody Review review, 
			@PathVariable int dateNightId,
			HttpServletRequest req, 
			HttpServletResponse res) {

		try {
			reviewService.createReview(review, dateNightId);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL(); 
			url.append("/").append(review.getId()); 
			res.setHeader("Location", url.toString()); 
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
			review = null;
		}
		return review;

	}

	@PutMapping("reviews/{id}")
	public Review editReview(@PathVariable int id, @RequestBody Review review, Principal principal, HttpServletRequest req, HttpServletResponse res) {
		Review updateReview = null;
		try {
			updateReview = reviewService.updateReview(review, id, principal.getName());
			if (updateReview == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			System.err.println("Unable to update review.");
		}
		return review;
	}

	@DeleteMapping("reviews/{id}")
	public void deleteReview(@PathVariable Integer id, HttpServletResponse res) {
		try {
			boolean reviewIsDeleted = reviewService.deleteReview(id);
			if (reviewIsDeleted) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}

		} catch (Exception e) {
			res.setStatus(400);
		}

	}

}
