package com.product.dto;

import java.time.LocalDate;

import com.product.entity.Product;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
	private int productId;
	private int authId;
	private String productName;
	private int price;
	private String type;
	private LocalDate createdAt;

}
