package com.cart.service.app.service;

import java.util.List;

import com.cart.service.app.entity.Cart;
import com.cart.service.app.exception.CartException;


public interface CartService {

	public Cart createCart(Cart Cart) throws CartException;
	
	public List<Cart> getAllCarts() throws CartException;
	
	public Cart getCartById(String id) throws CartException;
	
	public Cart deleteCart(Cart Cart)throws CartException;
	
	public Cart updateCart(String CartId,Cart Cart)throws CartException;
}
