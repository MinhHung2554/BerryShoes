package com.example.berryshoes.security.service;

import com.example.berryshoes.dto.request.PhieuGiamGiaRequest;
import com.example.berryshoes.entity.PhieuGiamGia;

import java.util.List;
import java.util.Optional;

public interface PhieuGiamGiaService {
    List<PhieuGiamGia> getAllPhieuGiamGia();
    Optional<PhieuGiamGia> getPhieuGiamGiaById(Integer id);
    PhieuGiamGia create(PhieuGiamGiaRequest requestDTO);
    PhieuGiamGia update(Integer id, PhieuGiamGiaRequest requestDTO);
    void delete(Integer id);
}
