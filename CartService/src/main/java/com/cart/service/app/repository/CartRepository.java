package com.cart.service.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.service.app.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String>{

	/*
	 * Custome methods
	 */
}
