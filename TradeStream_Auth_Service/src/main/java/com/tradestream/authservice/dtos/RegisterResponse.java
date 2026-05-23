package com.tradestream.authservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
	@Schema(description = "Generated user ID", example = "1")
	private Long userId;
	@Schema(description = "message", example = "User registered successfully")
	private String message;
}
