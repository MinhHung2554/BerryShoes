package com.example.berryshoes.service.impl;

import com.example.berryshoes.dto.request.PhuongThucThanhToanRequest;
import com.example.berryshoes.entity.PhuongThucThanhToan;
import com.example.berryshoes.repository.PhuongThucThanhToanRepository;
import com.example.berryshoes.service.PhuongThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PhuongThucThanhToanServiceImpl implements PhuongThucThanhToanService {

    @Autowired
    private PhuongThucThanhToanRepository phuongThucThanhToanRepository;

    @Override
    public List<PhuongThucThanhToan> getAll() {
        return phuongThucThanhToanRepository.findAll();
    }

    @Override
    public Optional<PhuongThucThanhToan> getById(Integer id) {
        return phuongThucThanhToanRepository.findById(id);
    }

    @Override
    public PhuongThucThanhToan create(PhuongThucThanhToanRequest requestDTO) {
        PhuongThucThanhToan phuongThucThanhToan = new PhuongThucThanhToan();
        phuongThucThanhToan.setTenPhuongThuc(requestDTO.getTenPhuongThuc());
        phuongThucThanhToan.setMoTa(requestDTO.getMoTa());
        phuongThucThanhToan.setTongTien(requestDTO.getTongTien());
        phuongThucThanhToan.setMaGiaoDichVnPay(requestDTO.getMaGiaoDichVnPay());
        phuongThucThanhToan.setNguoiTao(requestDTO.getNguoiTao());
        phuongThucThanhToan.setTrangThai(requestDTO.getTrangThai());
        phuongThucThanhToan.setNgayTao(new Timestamp(System.currentTimeMillis()));

        return phuongThucThanhToanRepository.save(phuongThucThanhToan);
    }

    @Override
    public PhuongThucThanhToan update(Integer id, PhuongThucThanhToanRequest requestDTO) {
        Optional<PhuongThucThanhToan> optionalPhuongThucThanhToan = phuongThucThanhToanRepository.findById(id);
        if (optionalPhuongThucThanhToan.isPresent()) {
            PhuongThucThanhToan phuongThucThanhToan = optionalPhuongThucThanhToan.get();
            phuongThucThanhToan.setTenPhuongThuc(requestDTO.getTenPhuongThuc());
            phuongThucThanhToan.setMoTa(requestDTO.getMoTa());
            phuongThucThanhToan.setTongTien(requestDTO.getTongTien());
            phuongThucThanhToan.setMaGiaoDichVnPay(requestDTO.getMaGiaoDichVnPay());
            phuongThucThanhToan.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            phuongThucThanhToan.setTrangThai(requestDTO.getTrangThai());
            phuongThucThanhToan.setLanCapNhatCuoi(new Timestamp(System.currentTimeMillis()));

            return phuongThucThanhToanRepository.save(phuongThucThanhToan);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (phuongThucThanhToanRepository.existsById(id)) {
            phuongThucThanhToanRepository.deleteById(id);
        } else {
            throw new RuntimeException("Phương thức thanh toán không tồn tại");
        }
    }
}
