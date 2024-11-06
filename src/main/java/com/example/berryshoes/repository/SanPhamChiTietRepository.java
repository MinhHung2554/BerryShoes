package com.example.berryshoes.repository;

import com.example.berryshoes.dto.request.SanPhamChiTietRequest;
import com.example.berryshoes.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet, Integer> {

 @Query("SELECT spct FROM SanPhamChiTiet spct " +
           "LEFT JOIN spct.kichCo kc " +
           "LEFT JOIN spct.mauSac ms " +
           "LEFT JOIN spct.dotGiamGia dgg " +
           "LEFT JOIN spct.sanPham sp " +
           "LEFT JOIN sp.thuongHieu th " +
           "LEFT JOIN sp.chatLieu cl " +
           "LEFT JOIN sp.deGiay dg " +
           "WHERE spct.id = :id")
 Optional<SanPhamChiTiet> findSanPhamChiTietByIdWithDetails(@Param("id") Integer id);

    @Query(value = """
            SELECT s FROM SanPhamChiTiet s WHERE s.sanPham.id = :id AND s.mauSac.tenMauSac LIKE %:ten%
            """)
    List<SanPhamChiTiet> listSizeColor(@Param("id") Integer id, @Param("ten") String ten);

    @Query("SELECT spct.giaTien FROM SanPhamChiTiet spct WHERE spct.id = :productId")
    BigDecimal findPriceByProductId(@Param("productId") Integer id);

    @Query("SELECT s FROM SanPhamChiTiet s WHERE s.sanPham.id = :id ")
    List<SanPhamChiTiet> listAllSize(@Param("id") Integer id);
}
