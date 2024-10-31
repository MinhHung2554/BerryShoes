package com.example.berryshoes.repository;

import com.example.berryshoes.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    //    NhanVien findByTaiKhoan(String taiKhoan);
//    List<NhanVien> findAllByHoVaTenContaining(String hoVaTen);
    @Query("SELECT nv FROM NhanVien nv WHERE (nv.hoVaTen LIKE %:hoVaTen%) AND (:trangThai IS NULL OR nv.trangThai = :trangThai)")
    List<NhanVien> findByHoVaTenAndTrangThai(@Param("hoVaTen") String hoVaTen, @Param("trangThai") Integer trangThai);
//    List<NhanVien> findByTrangThai(String trangThai);
}
