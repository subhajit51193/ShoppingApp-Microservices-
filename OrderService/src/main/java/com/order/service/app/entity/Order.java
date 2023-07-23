package com.order.service.app.entity;


import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "Orders")
public class Order {

	@Id
	private String orderId;
	private String userId;
	private Double totalAmount;
	private LocalDateTime orderDate;
}
