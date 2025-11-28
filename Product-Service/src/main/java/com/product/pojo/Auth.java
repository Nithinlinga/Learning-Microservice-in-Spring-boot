package com.product.pojo;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
