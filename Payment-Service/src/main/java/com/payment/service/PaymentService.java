package com.payment.service;

import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseDTO;

public interface PaymentService {
    ResponseDTO addPayment(RequestDTO requestDTO);
}
