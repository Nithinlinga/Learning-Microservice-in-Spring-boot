package com.payment.client;

import com.payment.pojo.Auth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "auth-service")
public interface AuthClient {
    @GetMapping("/api/auth/get")
    public Optional<Auth> getUserDetails(@RequestParam String email);

}
