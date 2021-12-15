package com.example.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.insurance.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
