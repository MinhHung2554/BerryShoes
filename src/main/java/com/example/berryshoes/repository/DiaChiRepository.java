package com.example.berryshoes.repository;

import com.example.berryshoes.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi, Integer> {

//    @Query("SELECT d FROM DiaChi d WHERE d.khachHang = :idKhachHang")
//    List<DiaChi> findByIdKhachHang(Integer KhachHang);
//
//    @Query("SELECT d FROM DiaChi d WHERE d.tenNguoiNhan = :tenNguoiNhan")
//    List<DiaChi> findByTenNguoiNhan(String tenNguoiNhan);
}
