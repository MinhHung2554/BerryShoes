package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.ThuongHieuRequest;
import com.example.berryshoes.entity.ThuongHieu;
import com.example.berryshoes.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    // Lấy tất cả thương hiệu
    public List<ThuongHieu> getAllThuongHieu() {
        return thuongHieuRepository.findAll();
    }

    // Lấy thương hiệu theo ID
    public Optional<ThuongHieu> getThuongHieuById(Integer id) {
        return thuongHieuRepository.findById(id);
    }

    // Tạo mới thương hiệu
    public ThuongHieu createThuongHieu(ThuongHieuRequest requestDTO) {
        ThuongHieu thuongHieu = ThuongHieu.builder()
                .tenThuongHieu(requestDTO.getTenThuongHieu())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return thuongHieuRepository.save(thuongHieu);
    }

    // Cập nhật thương hiệu
    public ThuongHieu updateThuongHieu(Integer id, ThuongHieuRequest requestDTO) {
        Optional<ThuongHieu> optionalThuongHieu = thuongHieuRepository.findById(id);
        if (optionalThuongHieu.isPresent()) {
            ThuongHieu thuongHieu = optionalThuongHieu.get();
            thuongHieu.setTenThuongHieu(requestDTO.getTenThuongHieu());
            thuongHieu.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            thuongHieu.setTrangThai(requestDTO.getTrangThai());
            return thuongHieuRepository.save(thuongHieu);
        }
        return null;
    }

    // Xóa thương hiệu
    public void deleteThuongHieu(Integer id) {
        if (thuongHieuRepository.existsById(id)) {
            thuongHieuRepository.deleteById(id);
        } else {
            throw new RuntimeException("Thương hiệu không tồn tại");
        }
    }
}
