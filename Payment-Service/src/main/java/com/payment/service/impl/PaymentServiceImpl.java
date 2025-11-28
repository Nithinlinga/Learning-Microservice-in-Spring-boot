package com.payment.service.impl;

import com.payment.client.AuthClient;
import com.payment.client.ProductClient;
import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseDTO;
import com.payment.entity.Payment;
import com.payment.pojo.Auth;
import com.payment.pojo.Product;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Override
    public ResponseDTO addPayment(RequestDTO requestDTO) {
        Auth auth = authClient.getUserDetails(requestDTO.getEmail()).
                orElseThrow(()-> new RuntimeException("email not found"));
        Product product = productClient.getProductById(requestDTO.getProductId()).orElseThrow(()-> new RuntimeException("product id not found"));
        Payment payment=modelMapper.map(requestDTO, Payment.class);
        payment.setAuthId(auth.getAuthId());
        payment.setProductName(product.getProductName());
        return modelMapper.map(paymentRepository.save(payment), ResponseDTO.class);

    }
}
