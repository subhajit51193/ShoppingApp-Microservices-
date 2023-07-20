package com.user.service.app.entity;

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

/*
 * Creating entity with all required variables
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	
	@Transient
	private List<Cart> itemsInCart = new ArrayList<>();
	
	@Transient
	private List<Order> orders = new ArrayList<>();
	
	@Transient
	private Wallet wallet;
	
	@Transient
	private List<Review> reviews = new ArrayList<>();
}
