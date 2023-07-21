package com.review.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.service.app.entity.Review;
import com.review.service.app.exception.ReviewException;
import com.review.service.app.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	/*
	 * Add or creating review and saving into database
	 */
	@Override
	public Review createReview(Review review) throws ReviewException {
		
		//creating random unique reviewId
		String randomReviewId = UUID.randomUUID().toString();
		review.setReviewId(randomReviewId);
		Review newReview = reviewRepository.save(review);
		if (newReview != null) {
			return newReview;
		}
		else {
			throw new ReviewException("Error Occured");
		}
	}

	/*
	 * Getting all Reviews from database
	 */
	@Override
	public List<Review> getAllReviews() throws ReviewException {
		
		List<Review> reviews = reviewRepository.findAll();
		if (reviews.isEmpty()) {
			throw new ReviewException("Empty List");
		}
		else {
			return reviews;
		}
	}

	/*
	 * Get particular Review based on Id.  
	 */
	@Override
	public Review getReviewById(String id) throws ReviewException {
		
		Optional<Review> opt = reviewRepository.findById(id);
		if (opt == null) {
			throw new ReviewException("Not found");
		}
		else {
			return opt.get();
		}
	}

	/*
	 * Delete Review from database
	 */
	@Override
	public Review deleteReview(Review review) throws ReviewException {
		
		if (review == null) {
			throw new ReviewException("Not found");
		}
		else {
			reviewRepository.delete(review);
			return review;
		}
	}

	/*
	 * Update Review and save new data into database
	 */
	@Override
	public Review updateReview(String reviewId, Review review) throws ReviewException {
		
		Optional<Review> opt = reviewRepository.findById(reviewId);
		if (opt.isEmpty()) {
			throw new ReviewException("Not found");
		}
		else {
			Review foundReview = opt.get();
			foundReview.setRating(review.getRating());
			foundReview.setComment(review.getComment());
			return reviewRepository.save(foundReview);
		}
	}

	
}
