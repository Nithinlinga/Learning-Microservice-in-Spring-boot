package com.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.dto.ProductRequestDTO;
import com.product.dto.ProductResponseDTO;

@Service
public interface ProductService {

	ProductResponseDTO addProduct(ProductRequestDTO productDto);

	List<ProductResponseDTO> getAllProducts();

	ProductResponseDTO getProductById(int productId);

	List<ProductResponseDTO> getProductByEmail(String email);

}
