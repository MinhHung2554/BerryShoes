package com.example.berryshoes.service.impl;

import com.example.berryshoes.dto.request.SanPhamChiTietRequest;
import com.example.berryshoes.entity.SanPhamChiTiet;
import com.example.berryshoes.repository.SanPhamChiTietRepository;
import com.example.berryshoes.service.SanPhamChiTietService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    private final SanPhamChiTietRepository sanPhamChiTietRepository;

    @Override
    public List<SanPhamChiTiet> getAll() {
        return sanPhamChiTietRepository.findAll();
    }

    @Override
    public Optional<SanPhamChiTiet> getById(Integer id) {
        return sanPhamChiTietRepository.findById(id);
    }

    @Override
    public SanPhamChiTiet create(SanPhamChiTietRequest requestDTO) {
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        sanPhamChiTiet.setMaSanPhamChiTiet(requestDTO.getMaSanPhamChiTiet());
        sanPhamChiTiet.setQrCode(requestDTO.getQrCode());
        sanPhamChiTiet.setSoLuong(requestDTO.getSoLuong());
        sanPhamChiTiet.setGiaTien(requestDTO.getGiaTien());
        sanPhamChiTiet.setMoTa(requestDTO.getMoTa());
        // Thiết lập mối quan hệ với các thực thể khác
        // sanPhamChiTiet.setSanPham(sanPhamRepository.findById(requestDTO.getIdSanPham()).orElse(null));
        // sanPhamChiTiet.setKichCo(kichCoRepository.findById(requestDTO.getIdKichCo()).orElse(null));
        // sanPhamChiTiet.setMauSac(mauSacRepository.findById(requestDTO.getIdMauSac()).orElse(null));
        // sanPhamChiTiet.setDotGiamGia(dotGiamGiaRepository.findById(requestDTO.getIdDotGiamGia()).orElse(null));
        sanPhamChiTiet.setNguoiTao(requestDTO.getNguoiTao());
        sanPhamChiTiet.setTrangThai(requestDTO.getTrangThai());

        return sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    @Override
    public SanPhamChiTiet update(Integer id, SanPhamChiTietRequest requestDTO) {
        Optional<SanPhamChiTiet> optionalSanPhamChiTiet = sanPhamChiTietRepository.findById(id);
        if (optionalSanPhamChiTiet.isPresent()) {
            SanPhamChiTiet sanPhamChiTiet = optionalSanPhamChiTiet.get();
            sanPhamChiTiet.setMaSanPhamChiTiet(requestDTO.getMaSanPhamChiTiet());
            sanPhamChiTiet.setQrCode(requestDTO.getQrCode());
            sanPhamChiTiet.setSoLuong(requestDTO.getSoLuong());
            sanPhamChiTiet.setGiaTien(requestDTO.getGiaTien());
            sanPhamChiTiet.setMoTa(requestDTO.getMoTa());
            // Thiết lập lại mối quan hệ
            // sanPhamChiTiet.setSanPham(sanPhamRepository.findById(requestDTO.getIdSanPham()).orElse(null));
            // sanPhamChiTiet.setKichCo(kichCoRepository.findById(requestDTO.getIdKichCo()).orElse(null));
            // sanPhamChiTiet.setMauSac(mauSacRepository.findById(requestDTO.getIdMauSac()).orElse(null));
            // sanPhamChiTiet.setDotGiamGia(dotGiamGiaRepository.findById(requestDTO.getIdDotGiamGia()).orElse(null));
            sanPhamChiTiet.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            sanPhamChiTiet.setTrangThai(requestDTO.getTrangThai());

            return sanPhamChiTietRepository.save(sanPhamChiTiet);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (sanPhamChiTietRepository.existsById(id)) {
            sanPhamChiTietRepository.deleteById(id);
        } else {
            throw new RuntimeException("Chi tiết sản phẩm không tồn tại");
        }
    }
}
