package com.payment.service;

import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseDTO;

import java.util.List;

public interface PaymentService {
    ResponseDTO addPayment(RequestDTO requestDTO);

    List<ResponseDTO> getProductPaymentById(String email);
}
