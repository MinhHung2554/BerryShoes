package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.PhieuGiamGiaRequest;
import com.example.berryshoes.entity.PhieuGiamGia;

import java.util.List;
import java.util.Optional;

public interface PhieuGiamGiaService {
    List<PhieuGiamGia> getAllPhieuGiamGia();
    Optional<PhieuGiamGia> getPhieuGiamGiaById(Integer id);
    PhieuGiamGia createPhieuGiamGia(PhieuGiamGiaRequest requestDTO);
    PhieuGiamGia updatePhieuGiamGia(Integer id, PhieuGiamGiaRequest requestDTO);
    void deletePhieuGiamGia(Integer id);
}
