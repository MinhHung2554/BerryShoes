package com.example.berryshoes.controller;

import com.example.berryshoes.dto.request.LoginDto;
import com.example.berryshoes.dto.response.MessageResponse;
import com.example.berryshoes.dto.response.TokenDto;
import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.dto.request.KhachHangRequest;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.entity.User;
import com.example.berryshoes.exception.MessageException;
import com.example.berryshoes.jwt.JwtUtils;
import com.example.berryshoes.repository.KhachHangRepository;
import com.example.berryshoes.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/public/login")
    public TokenDto authenticate(@RequestBody LoginDto loginDto) throws Exception {
        Optional<KhachHang> khachHang = khachHangRepository.findKhByEmail(loginDto.getEmail());
        Optional<NhanVien> nhanVien = nhanVienRepository.findByEmail(loginDto.getEmail());
        // check infor user
        if(khachHang.isEmpty() && nhanVien.isEmpty()){
            throw new MessageException("Không tìm thấy tài khoản");
        }
        else if(khachHang.isPresent()){
            if(passwordEncoder.matches(loginDto.getPassword(), khachHang.get().getMatKhau())){
                String token = jwtUtils.generateToken(loginDto.getEmail());
                return new TokenDto(token, "ROLE_CUSTOMER");
            }
            else{
                throw new MessageException("Mật khẩu không chính xác");
            }
        }
        else if(nhanVien.isPresent()){

            if(passwordEncoder.matches(loginDto.getPassword(), nhanVien.get().getMatKhau())){
                String role = "";
                if(nhanVien.get().getVaiTro() == 1){
                    role = "ROLE_ADMIN";
                }
                if(nhanVien.get().getVaiTro() == 0){
                    role = "ROLE_EMPLOYEE";
                }
                String token = jwtUtils.generateToken(loginDto.getEmail());
                return new TokenDto(token, role);
            }
            else{
                throw new MessageException("Mật khẩu không chính xác");
            }
        }
        throw new MessageException("Đăng nhập thất bại");
    }
    @PostMapping("/public/register")
    public MessageResponse registerCustomer(@RequestBody KhachHangRequest request) {
        // Kiểm tra email đã tồn tại
        if (khachHangRepository.existsByEmail(request.getEmail())) {
            throw new MessageException("Email đã được sử dụng.");
        }

        // Tạo mới Khách hàng
        KhachHang khachHang = new KhachHang();
        khachHang.setHoVaTen(request.getHoVaTen());
        khachHang.setNgaySinh(request.getNgaySinh());
        khachHang.setGioiTinh(request.getGioiTinh());
        khachHang.setSoDienThoai(request.getSoDienThoai());
        khachHang.setEmail(request.getEmail());
        khachHang.setMatKhau(passwordEncoder.encode(request.getMatKhau()));

        // Lưu khách hàng vào cơ sở dữ liệu
        khachHangRepository.save(khachHang);

        return new MessageResponse("Đăng ký thành công!");
    }

    @PostMapping("/admin/check-admin")
    public void checkAdmin() {

    }

    @PostMapping("/user/check-user")
    public void checkUser() {

    }

    @PostMapping("/all/check-all")
    public void checkAll() {

    }


    public Boolean checkUser(Optional<User> users){
        if(users.isPresent() == false){
            throw new MessageException("Không tìm thấy tài khoản", 404);
        }
        else if(users.get().getActivationKey() != null && users.get().getActived() == false){
            throw new MessageException("Tài khoản chưa được kích hoạt", 300);
        }
        else if(users.get().getActived() == false && users.get().getActivationKey() == null){
            throw new MessageException("Tài khoản đã bị khóa", 500);
        }
        return true;
    }
}
