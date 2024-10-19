package com.example.berryshoes.controller;

import com.example.berryshoes.dto.request.LoginRequest;
import com.example.berryshoes.dto.response.LoginResponse;
import com.example.berryshoes.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
//        String token = authService.login(loginRequest.getTaiKhoan(), loginRequest.getMatKhau());
//        return ResponseEntity.ok(new LoginResponse(token));
//    }
}
