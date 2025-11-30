package com.auth.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auth_entity")
public class Auth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authId;
	@Column(unique = true)
	private String email;
	private String password;
	private String phoneNo;
	private String address;
	private LocalDate createdAt;
	private Role role;
	
	public enum Role{
		ADMIN,USER
	}

}
