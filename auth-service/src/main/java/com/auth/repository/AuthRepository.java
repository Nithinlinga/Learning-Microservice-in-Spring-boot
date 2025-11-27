package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, Integer>{

}
