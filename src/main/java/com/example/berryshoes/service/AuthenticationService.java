package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.LoginRequest;
import com.example.berryshoes.dto.response.LoginResponse;

public interface AuthenticationService {
    LoginResponse login(LoginRequest loginRequest);
}
