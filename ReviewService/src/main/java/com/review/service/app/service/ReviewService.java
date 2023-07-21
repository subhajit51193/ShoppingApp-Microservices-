package com.review.service.app.service;

import java.util.List;

import com.review.service.app.entity.Review;
import com.review.service.app.exception.ReviewException;

public interface ReviewService {

	public Review createReview(Review review) throws ReviewException;
	
	public List<Review> getAllReviews()throws ReviewException;
	
	public Review getReviewById(String id)throws ReviewException;
	
	public Review deleteReview(Review review)throws ReviewException;
	
	public Review updateReview(String reviewId, Review review)throws ReviewException;
}
