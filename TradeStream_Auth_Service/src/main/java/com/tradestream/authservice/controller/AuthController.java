package com.tradestream.authservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradestream.authservice.dtos.RegisterRequest;
import com.tradestream.authservice.dtos.RegisterResponse;
import com.tradestream.authservice.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	@Operation(summary = "Register New User", description = "Creates a new user account in the TradeStream platform")

	@ApiResponses(value = {

			@ApiResponse(responseCode = "201", description = "User registered successfully"),

			@ApiResponse(responseCode = "400", description = "Invalid request data"),

			@ApiResponse(responseCode = "409", description = "Email already exists") })
	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
		RegisterResponse response = authService.register(registerRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}
}
