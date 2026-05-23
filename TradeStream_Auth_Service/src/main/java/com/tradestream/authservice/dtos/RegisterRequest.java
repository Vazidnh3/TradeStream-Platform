package com.tradestream.authservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

	@Schema(description = "Full name of the user", example = "Vazid Shaik")
	@NotBlank(message = "Full name is requried")
	private String fullName;
	@Schema(description = "User email address", example = "vazid@gmail.com")
	@NotBlank(message = "Email is required")
	@Email
	private String email;
	@Schema(description = "User password", example = "Password@123")
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password;
}
