package com.example.berryshoes.repository;

import com.example.berryshoes.entity.KhachHangPhieuGiam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangPhieuGiamRepository extends JpaRepository<KhachHangPhieuGiam, Integer> {

}
