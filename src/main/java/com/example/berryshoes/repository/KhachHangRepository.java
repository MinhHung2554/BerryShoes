package com.example.berryshoes.repository;

import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    KhachHang findByTaiKhoan(String taiKhoan);
    @Query("SELECT kh FROM KhachHang kh WHERE (kh.hoVaTen LIKE %:hoVaTen%) AND (:trangThai IS NULL OR kh.trangThai = :trangThai)")
    List<KhachHang> findByHoVaTenAndTrangThai(@Param("hoVaTen") String hoVaTen, @Param("trangThai") Integer trangThai);

}

