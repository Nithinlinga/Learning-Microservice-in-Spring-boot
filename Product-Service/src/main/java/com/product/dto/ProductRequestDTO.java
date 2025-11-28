package com.product.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
	private String email;
	private String productName;
	private int price;
	private String type;
	private LocalDate createdAt;

}
