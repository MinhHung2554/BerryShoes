package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.NhanVienRequest;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.repository.NhanVienRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NhanVienService {
    // Lấy tất cả nhân viên
    List<NhanVien> getAllNhanVien();

    // Lấy nhân viên theo ID
    Optional<NhanVien> getNhanVienById(Integer id);

    // Tạo mới nhân viên
    NhanVien createNhanVien(NhanVienRequest requestDTO);

    // Cập nhật nhân viên
    NhanVien updateNhanVien(Integer id, NhanVienRequest requestDTO);

    // Xóa nhân viên
    void deleteNhanVien(Integer id);

}
