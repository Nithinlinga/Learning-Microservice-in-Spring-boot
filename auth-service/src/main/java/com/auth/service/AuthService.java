package com.auth.service;

import org.springframework.stereotype.Service;

import com.auth.dto.LoginDTO;
import com.auth.dto.RegisterDTO;
import com.auth.dto.ResponseDTO;

@Service
public interface AuthService {

	ResponseDTO registerUser(RegisterDTO registerDTO);

	ResponseDTO loginUser(LoginDTO loginDTO);

	ResponseDTO getUserDetails(String email);
	

}
