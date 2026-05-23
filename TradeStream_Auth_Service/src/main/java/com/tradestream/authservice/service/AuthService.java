package com.tradestream.authservice.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tradestream.authservice.dtos.RegisterRequest;
import com.tradestream.authservice.dtos.RegisterResponse;
import com.tradestream.authservice.dtos.User;
import com.tradestream.authservice.entity.Role;
import com.tradestream.authservice.interfaces.IAuthService;
import com.tradestream.authservice.interfaces.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {

		if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists");
		}

		User user = User.builder().fullName(registerRequest.getFullName()).email(registerRequest.getEmail())
				.Password(passwordEncoder.encode(registerRequest.getPassword())).role(Role.ROLE_USER)
				.createdAt(LocalDateTime.now()).build();

		User savedUser = userRepository.save(user);

		return RegisterResponse.builder().userId(savedUser.getId()).message("User registered successfully").build();
	}

}
