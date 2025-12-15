package com.payment.service.impl;

import com.payment.circuitbreaker.CircuitBreakerConfig;
import com.payment.client.AuthClient;
import com.payment.client.ProductClient;
import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseDTO;
import com.payment.entity.Payment;
import com.payment.exceptionhandling.ResourceNotFoundException;
import com.payment.pojo.Auth;
import com.payment.pojo.Product;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private AuthClient authClient;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CircuitBreakerConfig circuitBreakerConfig;
    @Override
    public ResponseDTO addPayment(RequestDTO requestDTO) {
        Auth auth = circuitBreakerConfig.getUserProfile(requestDTO.getEmail());
        Product product = productClient.getProductById(requestDTO.getProductId()).orElseThrow(()-> new ResourceNotFoundException(requestDTO.getProductId()+ "not found"));
        Payment payment=modelMapper.map(requestDTO, Payment.class);
        payment.setAuthId(auth.getAuthId());
        payment.setProductName(product.getProductName());
        return modelMapper.map(paymentRepository.save(payment), ResponseDTO.class);

    }

    @Override
    public List<ResponseDTO> getProductPaymentById(String email) {
        Auth auth = circuitBreakerConfig.getUserProfile(email);
        List<Payment> payments=paymentRepository.findAllByAuthId(auth.getAuthId());
        return payments.stream().map(p->modelMapper.map(p, ResponseDTO.class)).toList();
    }


}
