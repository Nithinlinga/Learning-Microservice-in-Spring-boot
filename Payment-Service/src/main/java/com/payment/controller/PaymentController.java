package com.payment.controller;

import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseDTO;
import com.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping
    public ResponseEntity<ResponseDTO> createPayment(@RequestBody RequestDTO requestDTO){
        return new ResponseEntity<ResponseDTO>(paymentService.addPayment(requestDTO), HttpStatus.CREATED);

    }
    @GetMapping("/get/payments")
    public ResponseEntity<List<ResponseDTO>>  getProductPaymentById(@RequestHeader("X-Role") String role, @RequestParam String email){
        if(role.equals("ADMIN")) {
            return new ResponseEntity<List<ResponseDTO>>(paymentService.getProductPaymentById(email),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);

        }
    }
}
