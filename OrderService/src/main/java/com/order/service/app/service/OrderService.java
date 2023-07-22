package com.order.service.app.service;

import java.util.List;

import com.order.service.app.entity.Order;
import com.order.service.app.exception.OrderException;

public interface OrderService {

	public Order createOrder(Order order) throws OrderException;
	
	public List<Order> getAllOrders() throws OrderException;
	
	public Order getOrderById(String id) throws OrderException;
	
	public Order deleteOrder(Order order)throws OrderException;
	
//	public Order updateOrder(String orderId,Order order)throws OrderException;
}
