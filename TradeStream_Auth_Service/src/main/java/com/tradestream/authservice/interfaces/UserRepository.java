package com.tradestream.authservice.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradestream.authservice.dtos.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
