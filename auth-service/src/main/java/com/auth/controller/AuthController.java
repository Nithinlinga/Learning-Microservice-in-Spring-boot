package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.LoginDTO;
import com.auth.dto.LoginResponseDTO;
import com.auth.dto.RegisterDTO;
import com.auth.dto.ResponseDTO;
import com.auth.service.AuthService;

import jakarta.ws.rs.QueryParam;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody RegisterDTO registerDTO){
		return new ResponseEntity<>(authService.registerUser(registerDTO),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginDTO loginDTO){
		return new ResponseEntity<>(authService.loginUser(loginDTO),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getUserDetails(@RequestParam String email){
		return new ResponseEntity<ResponseDTO>(authService.getUserDetails(email),HttpStatus.OK);
	}
}
