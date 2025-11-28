package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRequestDTO;
import com.product.dto.ProductResponseDTO;
import com.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<ProductResponseDTO>  addProduct(@RequestBody ProductRequestDTO productDto){
		return new ResponseEntity<ProductResponseDTO>(productService.addProduct(productDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductResponseDTO>>  getAllProducts(){
		return new ResponseEntity<List<ProductResponseDTO>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductResponseDTO>  getProductById(@PathVariable int productId){
		return new ResponseEntity<ProductResponseDTO>(productService.getProductById(productId),HttpStatus.OK);
	}
	
	@GetMapping("/email")
	public ResponseEntity<List<ProductResponseDTO>>  getProductById(@RequestParam String email){
		return new ResponseEntity<List<ProductResponseDTO>>(productService.getProductByEmail(email),HttpStatus.OK);
	}
	

}
