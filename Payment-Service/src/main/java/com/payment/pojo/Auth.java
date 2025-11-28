package com.payment.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    private int authId;
    private String email;
    private String phoneNo;
    private String address;
    private LocalDate createdAt;

}