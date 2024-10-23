package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.DotGiamGiaRequest;
import com.example.berryshoes.dto.response.DotGiamGiaResponse;

import java.util.List;
import java.util.Optional;

public interface DotGiamGiaService {
    List<DotGiamGiaResponse> getAllDotGiamGia();

    Optional<DotGiamGiaResponse> getDotGiamGiaById(Integer id);

    DotGiamGiaResponse createDotGiamGia(DotGiamGiaRequest requestDTO);

    DotGiamGiaResponse updateDotGiamGia(Integer id, DotGiamGiaRequest requestDTO);

    void deleteDotGiamGia(Integer id);
}
