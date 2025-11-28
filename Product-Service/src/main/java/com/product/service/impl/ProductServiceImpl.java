package com.product.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.client.AuthClient;
import com.product.dto.ProductRequestDTO;
import com.product.dto.ProductResponseDTO;
import com.product.entity.Product;
import com.product.pojo.Auth;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private AuthClient authClient;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProductResponseDTO addProduct(ProductRequestDTO productDto) {
		Auth auth=authClient.getUserDetails(productDto.getEmail()).orElseThrow(()->new RuntimeException("No User Found"));
		Product product=mapper.map(productDto, Product.class);
		product.setCreatedAt(LocalDate.now());
		product.setAuthId(auth.getAuthId());

		return mapper.map(productRepository.save(product), ProductResponseDTO.class);
	}

	@Override
	public List<ProductResponseDTO> getAllProducts() {
		List<Product> products=productRepository.findAll();
		
		return products.stream().map(p->mapper.map(p, ProductResponseDTO.class)).toList();
	}

	@Override
	public ProductResponseDTO getProductById(int productId) {
		// TODO Auto-generated method stub
		return mapper.map(productRepository.findById(productId),ProductResponseDTO.class);
	}

	@Override
	public List<ProductResponseDTO> getProductByEmail(String email) {
		// TODO Auto-generated method stub
		Auth auth=authClient.getUserDetails(email).orElseThrow(()->new RuntimeException("No User Found"));
		List<Product> products=productRepository.findAllByAuthId(auth.getAuthId());
		return products.stream().map(p->mapper.map(p, ProductResponseDTO.class)).toList();
	}

}
