package com.example.berryshoes.service.impl;

import com.example.berryshoes.entity.GioHang;
import com.example.berryshoes.repository.GioHangRepository;
import com.example.berryshoes.service.GioHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GioHangServiceImpl implements GioHangService {

    private final GioHangRepository gioHangRepository;

    @Override
    public List<GioHang> getAllGioHang() {
        return gioHangRepository.findAll();
    }

    @Override
    public Optional<GioHang> getGioHangById(Integer id) {
        return gioHangRepository.findById(id);
    }

    @Override
    public GioHang createGioHang(GioHang gioHang) {
        return gioHangRepository.save(gioHang);
    }

    @Override
    public Optional<GioHang> updateGioHang(Integer id, GioHang updatedGioHang) {
        return gioHangRepository.findById(id).map(existingGioHang -> {
            existingGioHang.setKhachHang(updatedGioHang.getKhachHang());
            existingGioHang.setSanPhamChiTiet(updatedGioHang.getSanPhamChiTiet());
            existingGioHang.setSoLuong(updatedGioHang.getSoLuong());
            existingGioHang.setTrangThai(updatedGioHang.getTrangThai());
            return gioHangRepository.save(existingGioHang);
        });
    }

    @Override
    public void deleteGioHang(Integer id) {
        gioHangRepository.deleteById(id);
    }

    @Override
    public List<GioHang> findByKhachHangId(Integer khachHangId) {
        return gioHangRepository.findByKhachHang_Id(khachHangId);
    }

    @Override
    public List<GioHang> filterGioHangByTrangThai(Boolean trangThai) {
        return gioHangRepository.findByTrangThai(trangThai);
    }
}
