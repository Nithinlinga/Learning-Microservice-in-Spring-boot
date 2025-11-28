package com.product.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.pojo.Auth;

import jakarta.ws.rs.QueryParam;

@FeignClient(name = "auth-service")
public interface AuthClient {
	
	@GetMapping("/api/auth/get")
	public Optional<Auth> getUserDetails(@RequestParam("email") String email);
	

}
