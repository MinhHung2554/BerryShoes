package com.example.berryshoes.repository;

import com.example.berryshoes.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    List<GioHang> findByKhachHang_Id(Integer khachHangId);
    List<GioHang> findByTrangThai(Boolean trangThai);
}
