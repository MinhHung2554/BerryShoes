package com.example.berryshoes.security.service;

import com.example.berryshoes.dto.request.MauSacRequest;
import com.example.berryshoes.entity.MauSac;

import java.util.List;
import java.util.Optional;

public interface MauSacService {
    List<MauSac> getAllMauSac();

    Optional<MauSac> getMauSacById(Integer id);

    MauSac createMauSac(MauSacRequest requestDTO);

    MauSac updateMauSac(Integer id, MauSacRequest requestDTO);

    void deleteMauSac(Integer id);
}
