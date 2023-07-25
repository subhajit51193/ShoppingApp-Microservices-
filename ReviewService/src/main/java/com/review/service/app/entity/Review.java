package com.review.service.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reviews")
public class Review {

	@Id
	private String reviewId;
	private String userId;
	private String productId;
	private Integer rating;
	private String comment;
}
