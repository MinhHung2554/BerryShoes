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
    // Tìm kiếm theo họ và tên hoặc số điện thoại
    @Query("SELECT k FROM KhachHang k WHERE k.hoVaTen LIKE %:name% OR k.soDienThoai LIKE %:phone%")
    List<KhachHang> findByHoVaTenOrSoDienThoai(@Param("name") String name, @Param("phone") String phone);

    // Tìm kiếm theo họ và tên và trạng thái
    @Query("SELECT k FROM KhachHang k WHERE k.hoVaTen LIKE %:name% AND (:status is null or k.trangThai = :status)")
    List<KhachHang> findByHoVaTenAndTrangThai(@Param("name") String name, @Param("status") Integer status);

    // Lọc theo trạng thái
    List<KhachHang> findByTrangThai(Integer trangThai);
}

