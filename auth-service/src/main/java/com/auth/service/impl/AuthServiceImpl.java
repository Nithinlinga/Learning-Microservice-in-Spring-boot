package com.auth.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.dto.LoginDTO;
import com.auth.dto.RegisterDTO;
import com.auth.dto.ResponseDTO;
import com.auth.entity.Auth;
import com.auth.repository.AuthRepository;
import com.auth.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	private AuthRepository authRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDTO registerUser(RegisterDTO registerDTO) {
		boolean user=authRepository.findByEmail(registerDTO.getEmail()).isPresent();
		if(user) {
			throw new RuntimeException("User with email Already Exists");
		}
		
		Auth auth=mapper.map(registerDTO,Auth.class);
		auth.setCreatedAt(LocalDate.now());
		return mapper.map(authRepository.save(auth), ResponseDTO.class);
		
	}

	@Override
	public ResponseDTO loginUser(LoginDTO loginDTO) {
		Auth auth=authRepository.findByEmail(loginDTO.getEmail()).
				orElseThrow(()->new RuntimeException("User Not found"));
		if(auth.getPassword().equals(loginDTO.getPassword())) {
			return mapper.map(auth, ResponseDTO.class);
		}
		else {
			throw new RuntimeException("Bad Credentials");
		}
	}

	@Override
	public ResponseDTO getUserDetails(String email) {
		Auth auth=authRepository.findByEmail(email).
				orElseThrow(()->new RuntimeException("User Not found"));
		return mapper.map(auth, ResponseDTO.class);
		
	}

}
