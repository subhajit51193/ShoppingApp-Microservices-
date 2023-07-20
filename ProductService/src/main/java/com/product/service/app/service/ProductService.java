package com.product.service.app.service;

import java.util.List;

import com.product.service.app.entity.Product;
import com.product.service.exception.ProductException;

public interface ProductService {

	public Product addProduct(Product product) throws ProductException;
	
	public List<Product> getAllProducts() throws ProductException;
	
	public Product getProductById(String id) throws ProductException;
	
	public Product deleteProduct(Product product)throws ProductException;
	
	public Product updateProduct(String productId,Product product) throws ProductException;
}
