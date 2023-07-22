package com.order.service.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.app.entity.Order;
import com.order.service.app.exception.OrderException;
import com.order.service.app.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add")
	public ResponseEntity<Order> createOrderHandler(@RequestBody Order order) throws OrderException{
		
		Order newOrder = orderService.createOrder(order);
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrdersHandler() throws OrderException{
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(orders,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderByIdhandler(@PathVariable("id") String orderId) throws OrderException{
		Order foundOrder = orderService.getOrderById(orderId);
		return new ResponseEntity<Order>(foundOrder,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Order> deleteOrderHandler(@PathVariable("id") String orderId) throws OrderException{
		Order order = orderService.getOrderById(orderId);
		Order deletedOrder = orderService.deleteOrder(order);
		return new ResponseEntity<Order>(deletedOrder,HttpStatus.ACCEPTED);
	}
}
