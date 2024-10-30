package com.example.berryshoes.security.service.impl;

import com.example.berryshoes.dto.request.ThuongHieuRequest;
import com.example.berryshoes.entity.ThuongHieu;
import com.example.berryshoes.repository.ThuongHieuRepository;
import com.example.berryshoes.security.service.ThuongHieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ThuongHieuServiceImpl implements ThuongHieuService {
    private final ThuongHieuRepository thuongHieuRepository;

    @Override
    public List<ThuongHieu> getAllThuongHieu() {
        return thuongHieuRepository.findAll();
    }

    @Override
    public Optional<ThuongHieu> getThuongHieuById(Integer id) {
        return thuongHieuRepository.findById(id);
    }

    @Override
    public ThuongHieu createThuongHieu(ThuongHieuRequest requestDTO) {
        ThuongHieu thuongHieu = ThuongHieu.builder()
                .tenThuongHieu(requestDTO.getTenThuongHieu())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return thuongHieuRepository.save(thuongHieu);
    }

    @Override
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

    @Override
    public void deleteThuongHieu(Integer id) {
        if (thuongHieuRepository.existsById(id)) {
            thuongHieuRepository.deleteById(id);
        } else {
            throw new RuntimeException("Thương hiệu không tồn tại");
        }
    }
}
