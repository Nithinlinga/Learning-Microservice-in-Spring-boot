package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Integer>{

	Optional<Auth> findByEmail(String email);

}
