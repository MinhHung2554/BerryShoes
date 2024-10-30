package com.example.berryshoes.repository;

import com.example.berryshoes.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {

    @Query("SELECT t FROM ThuongHieu t WHERE t.tenThuongHieu = :tenThuongHieu")
    ThuongHieu findByTenThuongHieu(String tenThuongHieu);
}
