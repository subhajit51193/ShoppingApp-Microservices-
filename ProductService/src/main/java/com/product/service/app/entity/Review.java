package com.product.service.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	private String reviewId;
	private String userId;
	private String productId;
	private Integer rating;
	private String comment;
}
