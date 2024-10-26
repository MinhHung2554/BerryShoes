package com.example.berryshoes.service.impl;

import com.example.berryshoes.dto.request.PhieuGiamGiaRequest;
import com.example.berryshoes.entity.PhieuGiamGia;
import com.example.berryshoes.repository.PhieuGiamGiaRepository;
import com.example.berryshoes.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {

    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;

    @Override
    public List<PhieuGiamGia> getAllPhieuGiamGia() {
        return phieuGiamGiaRepository.findAll();
    }

    @Override
    public Optional<PhieuGiamGia> getPhieuGiamGiaById(Integer id) {
        return phieuGiamGiaRepository.findById(id);
    }

    @Override
    public PhieuGiamGia createPhieuGiamGia(PhieuGiamGiaRequest requestDTO) {
        PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
        phieuGiamGia.setMaCode(requestDTO.getMaCode());
        phieuGiamGia.setTenPhieu(requestDTO.getTenPhieu());
        phieuGiamGia.setGiaTriGiamToiDa(requestDTO.getGiaTriGiamToiDa());
        phieuGiamGia.setGiaTriGiam(requestDTO.getGiaTriGiam());
        phieuGiamGia.setDonToiThieu(requestDTO.getDonToiThieu());
        phieuGiamGia.setSoLuong(requestDTO.getSoLuong());
        phieuGiamGia.setLoaiPhieu(requestDTO.getLoaiPhieu());
        phieuGiamGia.setKieuPhieu(requestDTO.getKieuPhieu());
        phieuGiamGia.setNgayBatDau(Timestamp.valueOf(requestDTO.getNgayBatDau().toLocalDateTime()));
        phieuGiamGia.setNgayKetThuc(Timestamp.valueOf(requestDTO.getNgayKetThuc().toLocalDateTime()));
        phieuGiamGia.setNguoiTao(requestDTO.getNguoiTao());
        phieuGiamGia.setTrangThai(requestDTO.getTrangThai());

        return phieuGiamGiaRepository.save(phieuGiamGia);
    }

    @Override
    public PhieuGiamGia updatePhieuGiamGia(Integer id, PhieuGiamGiaRequest requestDTO) {
        Optional<PhieuGiamGia> optionalPhieuGiamGia = phieuGiamGiaRepository.findById(id);
        if (optionalPhieuGiamGia.isPresent()) {
            PhieuGiamGia phieuGiamGia = optionalPhieuGiamGia.get();
            phieuGiamGia.setMaCode(requestDTO.getMaCode());
            phieuGiamGia.setTenPhieu(requestDTO.getTenPhieu());
            phieuGiamGia.setGiaTriGiamToiDa(requestDTO.getGiaTriGiamToiDa());
            phieuGiamGia.setGiaTriGiam(requestDTO.getGiaTriGiam());
            phieuGiamGia.setDonToiThieu(requestDTO.getDonToiThieu());
            phieuGiamGia.setSoLuong(requestDTO.getSoLuong());
            phieuGiamGia.setLoaiPhieu(requestDTO.getLoaiPhieu());
            phieuGiamGia.setKieuPhieu(requestDTO.getKieuPhieu());
            phieuGiamGia.setNgayBatDau(Timestamp.valueOf(requestDTO.getNgayBatDau().toLocalDateTime()));
            phieuGiamGia.setNgayKetThuc(Timestamp.valueOf(requestDTO.getNgayKetThuc().toLocalDateTime()));
            phieuGiamGia.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            phieuGiamGia.setTrangThai(requestDTO.getTrangThai());

            return phieuGiamGiaRepository.save(phieuGiamGia);
        }
        return null;
    }

    @Override
    public void deletePhieuGiamGia(Integer id) {
        if (phieuGiamGiaRepository.existsById(id)) {
            phieuGiamGiaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Phiếu giảm giá không tồn tại");
        }
    }
}
