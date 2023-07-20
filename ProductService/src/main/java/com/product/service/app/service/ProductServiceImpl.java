package com.product.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.service.app.entity.Product;
import com.product.service.app.repository.ProductRepository;
import com.product.service.exception.ProductException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	/*
	 * Add or creating Product and saving into database
	 */
	@Override
	public Product addProduct(Product product) throws ProductException {
		
		//creating random unique productid
		String randomProductId = UUID.randomUUID().toString();
		product.setProductId(randomProductId);
		Product newProduct = productRepository.save(product);
		if (newProduct != null) {
			return newProduct;
		}
		else {
			throw new ProductException("Error Occured");
		}
	}

	/*
	 * Getting all Products from database
	 */
	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> products = productRepository.findAll();
		
		if (products.isEmpty()) {
			throw new ProductException("Empty List");
		}
		else {
			return products;
		}
	}

	
	/*
	 * Get particular Product based on userId.  
	 */
	@Override
	public Product getProductById(String id) throws ProductException {
		
		Optional<Product> opt = productRepository.findById(id);
		
		if (opt == null) {
			throw new ProductException("Not found");
		}
		else {
			return opt.get();
		}
	}

	
	/*
	 * Delete Product from database
	 */
	@Override
	public Product deleteProduct(Product product) throws ProductException {
		
		if (product == null) {
			throw new ProductException("Not found");
		}
		else {
			productRepository.delete(product);
			return product;
		}
	}

	
	/*
	 * Update Product and save new data into database
	 */
	@Override
	public Product updateProduct(String productId, Product product) throws ProductException {
		
		Optional<Product> opt = productRepository.findById(productId);
		if (opt.isEmpty()) {
			throw new ProductException("Not found");
		}
		else {
			Product foundProduct = opt.get();
			foundProduct.setProductName(product.getProductName());
			foundProduct.setPrice(product.getPrice());
			foundProduct.setAvailableQuantity(product.getAvailableQuantity());
			return productRepository.save(foundProduct);
		}
	}

}
