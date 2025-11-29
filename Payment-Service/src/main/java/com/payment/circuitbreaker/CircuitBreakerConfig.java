package com.payment.circuitbreaker;

import com.payment.client.AuthClient;
import com.payment.client.ProductClient;
import com.payment.exceptionhandling.ResourceNotFoundException;
import com.payment.pojo.Auth;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CircuitBreakerConfig {
    @Autowired
    private AuthClient authClient;
    @Autowired
    private ProductClient productClient;
    @CircuitBreaker(name="auth-service",fallbackMethod = "authFallback")
    public Auth getUserProfile(String email){
        return authClient.getUserDetails(email).orElseThrow(()->new ResourceNotFoundException(email+"not found"));

    }
    public Auth authFallback(String email,Throwable t){
        throw new ResourceNotFoundException("user not found with email"+email);
    }
}
