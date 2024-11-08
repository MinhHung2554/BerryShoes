package com.example.berryshoes.repository;

import com.example.berryshoes.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    @Query(nativeQuery = true, value = """
            SELECT * FROM SanPham WHERE TrangThai=1
               ORDER BY NgayTao DESC
            """)
    List<SanPham> getAllByNgayTao();
    // tìm id lớn nhất bên sp
    @Query(value = "SELECT MAX(s.id) FROM SanPham s")
    Integer findMaxIdSP();

    SanPham findFirstByOrderByNgayTaoDesc();

    boolean existsByTenSanPham(String tensanpham);
}
