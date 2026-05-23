package com.tradestream.authservice.interfaces;

import com.tradestream.authservice.dtos.RegisterRequest;
import com.tradestream.authservice.dtos.RegisterResponse;

public interface IAuthService {
	RegisterResponse register(RegisterRequest registerRequest);
}
