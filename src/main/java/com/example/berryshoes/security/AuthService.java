package com.example.berryshoes.security;

import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
//    @Autowired
//    private KhachHangRepository khachHangRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    public String login(String taiKhoan, String matKhau) {
//        KhachHang khachHang = khachHangRepository.findByTaiKhoan(taiKhoan);
//        if (khachHang != null && passwordEncoder.matches(matKhau, khachHang.getMatKhau())) {
//            return jwtUtil.generateToken(taiKhoan);
//        }
//        throw new RuntimeException("Tài khoản hoặc mật khẩu không đúng");
//    }
}
