package com.example.berryshoes.repository;

import com.example.berryshoes.entity.DotGiamGia;
import com.example.berryshoes.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DotGiamGiaRepository extends JpaRepository<DotGiamGia, Integer> {
//    @Query("SELECT s FROM DotGiamGia s WHERE s.id =:IdDot")

    @Query("SELECT d FROM DotGiamGia d WHERE " +
            "(:keySearch IS NULL OR d.nguoiTao LIKE %:keySearch%) " +
            "AND (:tungaySearch IS NULL OR d.ngayBatDau >= :tungaySearch) " +
            "AND (:denngaySearch IS NULL OR d.ngayKetThuc <= :denngaySearch) " +
            "AND (:ttSearch IS NULL OR d.trangThai = :ttSearch) " +
            "ORDER BY d.ngayTao DESC")
    Page<DotGiamGia> findAllOrderByNgayTaoDESC(
            @Param("keySearch") String keySearch,
            @Param("tungaySearch") Timestamp tungaySearch,
            @Param("denngaySearch") Timestamp denngaySearch,
            @Param("ttSearch") Integer ttSearch,
            Pageable pageable);

    DotGiamGia findDotGiamGiaById(Integer id);

    DotGiamGia findFirstByOrderByNgayTaoDesc();
}
