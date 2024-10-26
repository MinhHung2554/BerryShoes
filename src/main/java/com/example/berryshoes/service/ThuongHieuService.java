package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.ThuongHieuRequest;
import com.example.berryshoes.entity.ThuongHieu;

import java.util.List;
import java.util.Optional;

public interface ThuongHieuService {
    List<ThuongHieu> getAllThuongHieu();

    Optional<ThuongHieu> getThuongHieuById(Integer id);

    ThuongHieu createThuongHieu(ThuongHieuRequest requestDTO);

    ThuongHieu updateThuongHieu(Integer id, ThuongHieuRequest requestDTO);

    void deleteThuongHieu(Integer id);
}
