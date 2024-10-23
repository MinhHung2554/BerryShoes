package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.DeGiayRequest;
import com.example.berryshoes.entity.DeGiay;
import com.example.berryshoes.repository.DeGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeGiayService {
    @Autowired
    private DeGiayRepository deGiayRepository;

    // Lấy tất cả đế giày
    public List<DeGiay> getAllDeGiay() {
        return deGiayRepository.findAll();
    }

    // Lấy đế giày theo ID
    public Optional<DeGiay> getDeGiayById(Integer id) {
        return deGiayRepository.findById(id);
    }

    // Tạo mới đế giày
    public DeGiay createDeGiay(DeGiayRequest requestDTO) {
        DeGiay deGiay = DeGiay.builder()
                .tenDeGiay(requestDTO.getTenDeGiay())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return deGiayRepository.save(deGiay);
    }

    // Cập nhật đế giày
    public DeGiay updateDeGiay(Integer id, DeGiayRequest requestDTO) {
        Optional<DeGiay> optionalDeGiay = deGiayRepository.findById(id);
        if (optionalDeGiay.isPresent()) {
            DeGiay deGiay = optionalDeGiay.get();
            deGiay.setTenDeGiay(requestDTO.getTenDeGiay());
            deGiay.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            deGiay.setTrangThai(requestDTO.getTrangThai());
            return deGiayRepository.save(deGiay);
        }
        return null;
    }

    // Xóa đế giày
    public void deleteDeGiay(Integer id) {
        if (deGiayRepository.existsById(id)) {
            deGiayRepository.deleteById(id);
        } else {
            throw new RuntimeException("Đế giày không tồn tại");
        }
    }
}
