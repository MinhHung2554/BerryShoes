package com.example.berryshoes.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private Integer role; // 0: Khách hàng, 1: Nhân viên
}
