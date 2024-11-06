package com.example.berryshoes.repository;

import com.example.berryshoes.dto.request.SanPhamChiTietRequest;
import com.example.berryshoes.entity.KichCo;
import com.example.berryshoes.entity.MauSac;
import com.example.berryshoes.entity.SanPham;
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

    // search theo biến thể sản phẩm
    @Query("SELECT spct FROM SanPhamChiTiet spct WHERE spct.sanPham = :sanPham " +
            "AND (:key IS NULL OR spct.sanPham.tenSanPham LIKE :key OR spct.maSanPhamChiTiet LIKE :key) " +
            "AND (:idKichCo IS NULL OR spct.kichCo.id = :idKichCo) " +
            "AND (:idMauSac IS NULL OR spct.mauSac.id = :idMauSac) " +
            "AND (:trangThai IS NULL OR spct.sanPham.trangThai = :trangThai)")
    List<SanPhamChiTiet> searchBySanPham(
            @Param("sanPham") SanPham sanPham,
            @Param("key") String key,
            @Param("idKichCo") Integer idKichCo,
            @Param("idMauSac") Integer idMauSac,
            @Param("trangThai") Boolean trangThai
    );
    @Query(" SELECT s FROM SanPhamChiTiet s WHERE  s.mauSac=?1 AND s.kichCo=?2 AND s.sanPham=?3")
    SanPhamChiTiet findSPCT(MauSac mauSac, KichCo kichCo, SanPham sanPham);

}
