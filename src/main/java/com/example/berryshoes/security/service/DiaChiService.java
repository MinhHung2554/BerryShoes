package com.example.berryshoes.security.service;

import com.example.berryshoes.dto.request.DiaChiRequest;
import com.example.berryshoes.entity.DiaChi;

import java.util.List;
import java.util.Optional;

public interface DiaChiService {
    List<DiaChi> getAllDiaChi();

    Optional<DiaChi> getDiaChiById(Integer id);

    DiaChi createDiaChi(DiaChiRequest requestDTO);

    DiaChi updateDiaChi(Integer id, DiaChiRequest requestDTO);

    void deleteDiaChi(Integer id);
}
