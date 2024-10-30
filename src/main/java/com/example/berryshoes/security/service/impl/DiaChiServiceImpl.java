package com.example.berryshoes.security.service.impl;

import com.example.berryshoes.dto.request.DiaChiRequest;
import com.example.berryshoes.entity.DiaChi;
import com.example.berryshoes.repository.DiaChiRepository;
import com.example.berryshoes.security.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaChiServiceImpl implements DiaChiService {

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Override
    public List<DiaChi> getAllDiaChi() {
        return diaChiRepository.findAll();
    }

    @Override
    public Optional<DiaChi> getDiaChiById(Integer id) {
        return diaChiRepository.findById(id);
    }

    @Override
    public DiaChi createDiaChi(DiaChiRequest requestDTO) {
        DiaChi diaChi = DiaChi.builder()
                .khachHang(requestDTO.getKhachHang())
                .tenDuong(requestDTO.getTenDuong())
                .xaPhuong(requestDTO.getXaPhuong())
                .quanHuyen(requestDTO.getQuanHuyen())
                .tinhThanhPho(requestDTO.getTinhThanhPho())
                .tenNguoiNhan(requestDTO.getTenNguoiNhan())
                .sdtNguoiNhan(requestDTO.getSdtNguoiNhan())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return diaChiRepository.save(diaChi);
    }

    @Override
    public DiaChi updateDiaChi(Integer id, DiaChiRequest requestDTO) {
        Optional<DiaChi> optionalDiaChi = diaChiRepository.findById(id);
        if (optionalDiaChi.isPresent()) {
            DiaChi diaChi = optionalDiaChi.get();
            diaChi.setTenDuong(requestDTO.getTenDuong());
            diaChi.setXaPhuong(requestDTO.getXaPhuong());
            diaChi.setQuanHuyen(requestDTO.getQuanHuyen());
            diaChi.setTinhThanhPho(requestDTO.getTinhThanhPho());
            diaChi.setTenNguoiNhan(requestDTO.getTenNguoiNhan());
            diaChi.setSdtNguoiNhan(requestDTO.getSdtNguoiNhan());
            diaChi.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            diaChi.setTrangThai(requestDTO.getTrangThai());
            return diaChiRepository.save(diaChi);
        }
        return null;
    }

    @Override
    public void deleteDiaChi(Integer id) {
        if (diaChiRepository.existsById(id)) {
            diaChiRepository.deleteById(id);
        } else {
            throw new RuntimeException("Địa chỉ không tồn tại");
        }
    }
}
