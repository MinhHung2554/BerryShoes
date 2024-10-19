package com.example.berryshoes.repository;

import com.example.berryshoes.entity.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhuongThucThanhToanRepository extends JpaRepository<PhuongThucThanhToan, Integer> {

//    @Query("SELECT p FROM PhuongThucThanhToan p WHERE p.idHoaDon = :idHoaDon")
//    List<PhuongThucThanhToan> findByIdHoaDon(Integer idHoaDon);
}
