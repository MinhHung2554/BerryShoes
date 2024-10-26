package com.example.berryshoes.service.impl;

import com.example.berryshoes.dto.request.SanPhamRequest;
import com.example.berryshoes.entity.SanPham;
import com.example.berryshoes.repository.SanPhamRepository;
import com.example.berryshoes.service.SanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Optional<SanPham> getById(Integer id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public SanPham create(SanPhamRequest requestDTO) {
        SanPham sanPham = new SanPham();
        sanPham.setMaSanPham(requestDTO.getMaSanPham());
        sanPham.setTenSanPham(requestDTO.getTenSanPham());
        // Thiết lập mối quan hệ với các thực thể khác
        // sanPham.setThuongHieu(thuongHieuRepository.findById(requestDTO.getIdThuongHieu()).orElse(null));
        // sanPham.setChatLieu(chatLieuRepository.findById(requestDTO.getIdChatLieu()).orElse(null));
        // sanPham.setDeGiay(deGiayRepository.findById(requestDTO.getIdDeGiay()).orElse(null));
        sanPham.setNguoiTao(requestDTO.getNguoiTao());
        sanPham.setTrangThai(requestDTO.getTrangThai());

        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham update(Integer id, SanPhamRequest requestDTO) {
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        if (optionalSanPham.isPresent()) {
            SanPham sanPham = optionalSanPham.get();
            sanPham.setMaSanPham(requestDTO.getMaSanPham());
            sanPham.setTenSanPham(requestDTO.getTenSanPham());
            // Thiết lập lại mối quan hệ
            // sanPham.setThuongHieu(thuongHieuRepository.findById(requestDTO.getIdThuongHieu()).orElse(null));
            // sanPham.setChatLieu(chatLieuRepository.findById(requestDTO.getIdChatLieu()).orElse(null));
            // sanPham.setDeGiay(deGiayRepository.findById(requestDTO.getIdDeGiay()).orElse(null));
            sanPham.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            sanPham.setTrangThai(requestDTO.getTrangThai());

            return sanPhamRepository.save(sanPham);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (sanPhamRepository.existsById(id)) {
            sanPhamRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sản phẩm không tồn tại");
        }
    }
}
