package com.example.berryshoes.repository;

import com.example.berryshoes.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    KhachHang findByTaiKhoan(String taiKhoan);
}

