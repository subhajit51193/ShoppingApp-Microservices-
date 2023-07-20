package com.user.service.app.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private String orderId;
	private String userId;
	private Double totalAmount;
	private Date orderDate;
}
