package com.example.berryshoes.service;

import com.example.berryshoes.entity.GioHang;

import java.util.List;
import java.util.Optional;

public interface GioHangService {
    List<GioHang> getAllGioHang();
    Optional<GioHang> getGioHangById(Integer id);
    GioHang createGioHang(GioHang gioHang);
    Optional<GioHang> updateGioHang(Integer id, GioHang gioHang);
    void deleteGioHang(Integer id);
    List<GioHang> findByKhachHangId(Integer khachHangId);
    List<GioHang> filterGioHangByTrangThai(Boolean trangThai);
}
