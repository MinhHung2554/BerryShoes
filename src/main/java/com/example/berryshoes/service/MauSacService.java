package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.MauSacRequest;
import com.example.berryshoes.entity.MauSac;
import com.example.berryshoes.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    // Lấy tất cả màu sắc
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    // Lấy màu sắc theo ID
    public Optional<MauSac> getMauSacById(Integer id) {
        return mauSacRepository.findById(id);
    }

    // Tạo mới màu sắc
    public MauSac createMauSac(MauSacRequest requestDTO) {
        MauSac mauSac = MauSac.builder()
                .maMauSac(requestDTO.getMaMauSac())
                .tenMauSac(requestDTO.getTenMauSac())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return mauSacRepository.save(mauSac);
    }

    // Cập nhật màu sắc
    public MauSac updateMauSac(Integer id, MauSacRequest requestDTO) {
        Optional<MauSac> optionalMauSac = mauSacRepository.findById(id);
        if (optionalMauSac.isPresent()) {
            MauSac mauSac = optionalMauSac.get();
            mauSac.setMaMauSac(requestDTO.getMaMauSac());
            mauSac.setTenMauSac(requestDTO.getTenMauSac());
            mauSac.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            mauSac.setTrangThai(requestDTO.getTrangThai());
            return mauSacRepository.save(mauSac);
        }
        return null;
    }

    // Xóa màu sắc
    public void deleteMauSac(Integer id) {
        if (mauSacRepository.existsById(id)) {
            mauSacRepository.deleteById(id);
        } else {
            throw new RuntimeException("Màu sắc không tồn tại");
        }
    }
}
