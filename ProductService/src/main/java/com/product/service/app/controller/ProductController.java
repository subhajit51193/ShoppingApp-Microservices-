package com.product.service.app.controller;

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

import com.product.service.app.entity.Product;
import com.product.service.app.service.ProductService;
import com.product.service.exception.ProductException;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product product) throws ProductException{
		
		Product newProduct = productService.addProduct(product);
		return new ResponseEntity<Product>(newProduct,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllUsersHandler() throws ProductException{
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getUserByIdhandler(@PathVariable("id") String userId) throws ProductException{
		Product foundProduct = productService.getProductById(userId);
		return new ResponseEntity<Product>(foundProduct,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteUserHandler(@PathVariable("id") String userId) throws ProductException{
		Product product = productService.getProductById(userId);
		Product deletedProduct = productService.deleteProduct(product);
		return new ResponseEntity<Product>(deletedProduct,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateUserHandler(@PathVariable("id") String productId, @RequestBody Product product) throws ProductException{
		Product updatedProduct = productService.updateProduct(productId, product);
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.ACCEPTED);
	}
}
