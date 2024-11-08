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

    // các sp mới nhất bên sp
    @Query("""
        SELECT sp.id, sp.tenSanPham, sp.ngayTao, 
               SUM(ct.soLuong) AS tongSoLuong, sp.trangThai, sp.maSanPham
        FROM SanPham sp
        JOIN SanPhamChiTiet ct ON sp.id = ct.id
        GROUP BY sp.id, sp.tenSanPham, sp.ngayTao, sp.trangThai, sp.maSanPham
        ORDER BY sp.ngayTao DESC, tongSoLuong DESC
       """)
    List<Object[]> findProductsWithTotalQuantityOrderByDateDesc();
    // search bên sp
//    @Query("""
//        SELECT sp.id, sp.tenSanPham, sp.ngayTao, SUM(SanPhamChiTiet.soLuong) AS tongSoLuong,
//               sp.trangThai, sp.maSanPham
//        FROM SanPham sp
//        JOIN sp spct
//        WHERE (sp.maSanPham LIKE %:masanpham% OR sp.tenSanPham LIKE %:key%)
//          AND (:trangthai IS NULL OR sp.trangThai = :trangthai)
//        GROUP BY sp.id, sp.tenSanPham, sp.ngayTao, sp.trangThai, sp.maSanPham
//        ORDER BY sp.ngayTao DESC, SUM(SanPhamChiTiet.soLuong) DESC
//       """)
//    List<Object[]> findByMasanphamAndTenSanPhamAndTrangThai(
//            @Param("masanpham") String masanpham,
//            @Param("key") String key,
//            @Param("trangthai") Integer trangthai
//    );
}
