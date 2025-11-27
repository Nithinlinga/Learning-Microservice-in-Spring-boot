package com.auth.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authId;
	private String name;
	private String password;
	private String phoneNo;
	private String address;

}
