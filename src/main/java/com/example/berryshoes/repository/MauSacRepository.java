package com.example.berryshoes.repository;

import com.example.berryshoes.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {

    @Query("SELECT m FROM MauSac m WHERE m.tenMauSac = :tenMauSac")
    MauSac findByTenMauSac(String tenMauSac);
}
