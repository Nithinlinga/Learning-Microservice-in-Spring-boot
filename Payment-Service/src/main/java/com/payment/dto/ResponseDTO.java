package com.payment.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private int paymentId;
    private int authId;
    private String productName;
    private String paymentType;
    private int totalPrice;
}
