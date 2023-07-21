package com.review.service.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.service.app.entity.Review;
import com.review.service.app.exception.ReviewException;
import com.review.service.app.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("/add")
	public ResponseEntity<Review> addReviewHandler(@RequestBody Review review) throws ReviewException{
		
		Review newReview = reviewService.createReview(review);
		return new ResponseEntity<Review>(newReview,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Review>> getAllreviewsHandler() throws ReviewException{
		List<Review> reviews = reviewService.getAllReviews();
		return new ResponseEntity<List<Review>>(reviews,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Review> getReviewByIdhandler(@PathVariable("id") String reviewId) throws ReviewException{
		Review foundReview = reviewService.getReviewById(reviewId);
		return new ResponseEntity<Review>(foundReview,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Review> deleteReviewHandler(@PathVariable("id") String reviewId) throws ReviewException{
		Review review = reviewService.getReviewById(reviewId);
		Review deletedReview = reviewService.deleteReview(review);
		return new ResponseEntity<Review>(deletedReview,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReviewHandler(@PathVariable("id") String reviewId, @RequestBody Review review) throws ReviewException{
		Review updatedReview = reviewService.updateReview(reviewId, review);
		return new ResponseEntity<Review>(updatedReview,HttpStatus.ACCEPTED);
	}
}
