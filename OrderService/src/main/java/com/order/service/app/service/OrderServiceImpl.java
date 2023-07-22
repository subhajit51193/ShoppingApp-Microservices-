package com.order.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.app.entity.Order;
import com.order.service.app.exception.OrderException;
import com.order.service.app.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	/*
	 * Register or creating Order and saving into database
	 */
	@Override
	public Order createOrder(Order order) throws OrderException {
		
		//creating random unique OrderId
		String randomOrderId = UUID.randomUUID().toString();
		
		order.setOrderId(randomOrderId);
		Order newOrder =  orderRepository.save(order);
		if (newOrder != null) {
			return newOrder;
		}
		else {
			throw new OrderException("Error Occured");
		}
	}

	/*
	 * Getting all Orders from database
	 */
	@Override
	public List<Order> getAllOrders() throws OrderException {
		
		List<Order> orders = orderRepository.findAll();
		if (orders.isEmpty()) {
			throw new OrderException("Empty List");
		}
		else {
			return orders;
		}
	}

	
	/*
	 * Get particular Order based on OrderId.  
	 */
	@Override
	public Order getOrderById(String id) throws OrderException {
		
		Optional<Order> opt = orderRepository.findById(id);
		
		if (opt == null) {
			throw new OrderException("Not found");
		}
		else {
			return opt.get();
		}
	}

	/*
	 * Delete Order from database
	 */
	@Override
	public Order deleteOrder(Order order) throws OrderException {
		
		if (order == null) {
			throw new OrderException("Not found");
		}
		else {
			orderRepository.delete(order);
			return order;
		}
	}


}
