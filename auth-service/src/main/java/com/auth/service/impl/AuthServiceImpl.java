package com.auth.service.impl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.config.JwtUtil;
import com.auth.dto.LoginDTO;
import com.auth.dto.LoginResponseDTO;
import com.auth.dto.RegisterDTO;
import com.auth.dto.ResponseDTO;
import com.auth.entity.Auth;
import com.auth.entity.Auth.Role;
import com.auth.repository.AuthRepository;
import com.auth.service.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

	private final AuthRepository authRepository;

	private final ModelMapper mapper;
	
	private final PasswordEncoder passwordEncoder;
	
	private final JwtUtil jwtUtil;

	@Override
	public ResponseDTO registerUser(RegisterDTO registerDTO) {
		boolean user=authRepository.findByEmail(registerDTO.getEmail()).isPresent();
		if(user) {
			throw new RuntimeException("User with email Already Exists");
		}
		
		Auth auth=mapper.map(registerDTO,Auth.class);
		auth.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
		auth.setCreatedAt(LocalDate.now());
		auth.setRole(Role.USER);
		return mapper.map(authRepository.save(auth), ResponseDTO.class);
		
	}

	@Override
	public LoginResponseDTO loginUser(LoginDTO loginDTO) {
		Auth auth=authRepository.findByEmail(loginDTO.getEmail()).
				orElseThrow(()->new RuntimeException("User Not found"));
		if(passwordEncoder.matches(loginDTO.getPassword(), auth.getPassword())) {
			LoginResponseDTO dto=new LoginResponseDTO();
			dto.setToken(jwtUtil.generateToken(auth));
			return dto;
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
