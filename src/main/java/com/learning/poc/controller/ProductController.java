package com.learning.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.poc.model.Products;
import com.learning.poc.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping()
	public List<Products> getAllProducts()
	{
		return productservice.getAllProducts();		
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Products> getProductById(@PathVariable Integer productId)
	{
		return productservice.getProductById(productId);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Products> addProduct(@RequestBody Products product)
	{
		return productservice.addProduct(product);
	}
	
	@PostMapping("/addProducts")
	public ResponseEntity<List<Products>> addProducts(@RequestBody List<Products> productList)
	{
		return productservice.addProducts(productList);
	}
	
	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<Products> updateProductById(@RequestBody Products product,@PathVariable Integer productId)
	{
		return productservice.updateProductById(product,productId);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer productId)
	{
		return productservice.deleteProductById(productId);
	}
	
}
