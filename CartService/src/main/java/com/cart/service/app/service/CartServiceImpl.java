package com.cart.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.service.app.entity.Cart;
import com.cart.service.app.exception.CartException;
import com.cart.service.app.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	/*
	 * Register or creating Cart and saving into database
	 */
	@Override
	public Cart createCart(Cart cart) throws CartException {
		
		//creating random unique cartId
		String randomcartId = UUID.randomUUID().toString();
		
		cart.setCartId(randomcartId);
		Cart newCart =  cartRepository.save(cart);
		if (newCart != null) {
			return newCart;
		}
		else {
			throw new CartException("Error Occured");
		}
	}

	/*
	 * Getting all Carts from database
	 */
	@Override
	public List<Cart> getAllCarts() throws CartException {
		
		List<Cart> Carts = cartRepository.findAll();
		if (Carts.isEmpty()) {
			throw new CartException("Empty List");
		}
		else {
			return Carts;
		}
	}

	
	/*
	 * Get particular Cart based on cartId.  
	 */
	@Override
	public Cart getCartById(String id) throws CartException {
		
		Optional<Cart> opt = cartRepository.findById(id);
		
		if (opt == null) {
			throw new CartException("Not found");
		}
		else {
			return opt.get();
		}
	}

	/*
	 * Delete Cart from database
	 */
	@Override
	public Cart deleteCart(Cart cart) throws CartException {
		
		if (cart == null) {
			throw new CartException("Not found");
		}
		else {
			cartRepository.delete(cart);
			return cart;
		}
	}

	
	/*
	 * Update Cart and save new data into database
	 */
	@Override
	public Cart updateCart(String cartId, Cart cart) throws CartException {
		
		Optional<Cart> opt = cartRepository.findById(cartId);
		if (opt.isEmpty()) {
			throw new CartException("Cart not found");
		}
		else {
			Cart foundCart = opt.get();
			foundCart.setProductId(cart.getProductId());
			foundCart.setQuantity(cart.getQuantity());
			return cartRepository.save(foundCart);
		}
	}

}
