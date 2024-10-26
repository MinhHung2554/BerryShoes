//package com.example.berryshoes.security;
//
//import com.example.berryshoes.entity.KhachHang;
//import com.example.berryshoes.repository.KhachHangRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private KhachHangRepository khachHangRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String taiKhoan) throws UsernameNotFoundException {
//        KhachHang khachHang = khachHangRepository.findByTaiKhoan(taiKhoan);
//        if (khachHang == null) {
//            throw new UsernameNotFoundException("Tài khoản không tồn tại");
//        }
//        return org.springframework.security.core.userdetails.User
//                .withUsername(khachHang.getTaiKhoan())
//                .password(khachHang.getMatKhau())
//                .authorities("USER") // Bạn có thể thay đổi quyền theo nhu cầu
//                .accountLocked(false) // Đặt theo logic của bạn
//                .disabled(false) // Đặt theo logic của bạn
//                .build();
//    }
//}
