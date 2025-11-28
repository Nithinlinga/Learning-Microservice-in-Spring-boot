package com.payment.client;

import com.payment.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "Product-Service")
public interface ProductClient {
    @GetMapping("/api/product/product/{productId}")
    public Optional<Product> getProductById(@PathVariable int productId);
}
