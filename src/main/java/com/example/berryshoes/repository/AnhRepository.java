package com.example.berryshoes.repository;

import com.example.berryshoes.entity.Anh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnhRepository extends JpaRepository<Anh, Integer> {
    // Tìm kiếm ảnh theo tên ảnh (TenAnh)
    List<Anh> findByTenAnhContaining(String tenAnh);

    // Lọc ảnh theo trạng thái
    List<Anh> findByTrangThai(Boolean trangThai);
}
