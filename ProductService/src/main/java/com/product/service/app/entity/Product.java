package com.product.service.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product {

	@Id
	private String productId;
	private String productName;
	private Integer availableQuantity;
	private Double price;
	@Transient
	private List<Review> reviews = new ArrayList<>();
}
