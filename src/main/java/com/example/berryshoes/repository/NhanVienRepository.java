package com.example.berryshoes.repository;

import com.example.berryshoes.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    NhanVien findByTaiKhoan(String taiKhoan);
    List<NhanVien> findByNameContainingIgnoreCase(String ten);
    List<NhanVien> findByTrangThai(String trangThai);
}
