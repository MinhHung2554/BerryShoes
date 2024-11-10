package com.example.berryshoes.repository;

import com.example.berryshoes.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {
//
//    @Query("SELECT s FROM SanPhamChiTiet s WHERE s.idSanPham = :idSanPham")
//    List<SanPhamChiTiet> findByIdSanPham(Integer idSanPham);
}
