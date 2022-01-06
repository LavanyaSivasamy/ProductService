package com.learning.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.poc.exception.ResourceNotFoundException;
import com.learning.poc.model.Products;
import com.learning.poc.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepo;

	public List<Products> getAllProducts() 
	{		
		return productrepo.findAll();
	}
	
	public ResponseEntity<Products> getProductById(Integer productId)
	{
		Optional<Products> product =productrepo.findById(productId);
		if(product.isPresent())
		{
			return ResponseEntity.ok().body(product.get());
		}
		else
		{
			throw new ResourceNotFoundException("product not found in DB--"+productId);
		}
	}
	
	public ResponseEntity<Products> addProduct(Products product)
	{
		
		return ResponseEntity.ok().body(productrepo.save(product));
	}
	
	public ResponseEntity<List<Products>> addProducts(List<Products> productList)
	{
		return ResponseEntity.ok().body(productrepo.saveAll(productList));
	}
	
	public ResponseEntity<Products> updateProductById(Products product,Integer productId)
	{
		Optional<Products> productinDB =productrepo.findById(productId);
		if(productinDB.isPresent())
		{
			Products newProduct=productinDB.get();
			newProduct.setId(product.getId());
			newProduct.setName(product.getName());
			newProduct.setCode(product.getCode());
			newProduct.setPrice(product.getPrice());
			productrepo.save(newProduct);
			return ResponseEntity.ok().body(newProduct);
		}
		else
		{
			throw new ResourceNotFoundException("product not found in DB--"+productId);
		}
	}
	
	public ResponseEntity<String> deleteProductById(Integer productId)
	{
		Optional<Products> product =productrepo.findById(productId);
		if(product.isPresent())
		{
			productrepo.deleteById(productId);
			return ResponseEntity.ok().body("product details deleted successfully for Product Id--"+productId);
			}
		else
		{
			throw new ResourceNotFoundException("product not found in DB--"+productId);
		}
	}

}
