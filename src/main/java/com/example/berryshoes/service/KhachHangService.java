package com.example.berryshoes.service;
import com.example.berryshoes.dto.request.KhachHangRequest;
import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.entity.NhanVien;

import java.util.List;
import java.util.Optional;
public interface KhachHangService {
    List<KhachHang> getAllKhachHang();
    Optional<KhachHang> getKhachHangById(Integer id);
    KhachHang createKhachHang(KhachHangRequest requestDTO);
    KhachHang updateKhachHang(Integer id, KhachHangRequest requestDTO);
    void deleteKhachHang(Integer id);
    List<KhachHang> findByHoVaTenAndTrangThai(String hoVaTen, Integer trangThai);
}