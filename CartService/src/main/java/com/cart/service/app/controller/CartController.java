package com.cart.service.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.service.app.entity.Cart;
import com.cart.service.app.exception.CartException;
import com.cart.service.app.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<Cart> createCartHandler(@RequestBody Cart cart) throws CartException{
		
		Cart newCart = cartService.createCart(cart);
		return new ResponseEntity<>(newCart,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Cart>> getAllCartsHandler() throws CartException{
		List<Cart> carts = cartService.getAllCarts();
		return new ResponseEntity<List<Cart>>(carts,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCartByIdhandler(@PathVariable("id") String CartId) throws CartException{
		Cart foundCart = cartService.getCartById(CartId);
		return new ResponseEntity<Cart>(foundCart,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cart> deleteCartHandler(@PathVariable("id") String cartId) throws CartException{
		Cart cart = cartService.getCartById(cartId);
		Cart deletedCart = cartService.deleteCart(cart);
		return new ResponseEntity<Cart>(deletedCart,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCartHandler(@PathVariable("id") String cartId, @RequestBody Cart Cart) throws CartException{
		Cart updatedCart = cartService.updateCart(cartId, Cart);
		return new ResponseEntity<Cart>(updatedCart,HttpStatus.ACCEPTED);
	}
}
