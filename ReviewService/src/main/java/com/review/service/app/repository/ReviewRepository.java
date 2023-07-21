package com.review.service.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.review.service.app.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, String>{

}
