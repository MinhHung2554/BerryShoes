package com.example.berryshoes.security.service.impl;

import com.example.berryshoes.dto.request.DeGiayRequest;
import com.example.berryshoes.entity.DeGiay;
import com.example.berryshoes.repository.DeGiayRepository;
import com.example.berryshoes.security.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeGiayServiceImpl implements DeGiayService {

    @Autowired
    private DeGiayRepository deGiayRepository;

    @Override
    public List<DeGiay> getAllDeGiay() {
        return deGiayRepository.findAll();
    }

    @Override
    public Optional<DeGiay> getDeGiayById(Integer id) {
        return deGiayRepository.findById(id);
    }

    @Override
    public DeGiay createDeGiay(DeGiayRequest requestDTO) {
        DeGiay deGiay = DeGiay.builder()
                .tenDeGiay(requestDTO.getTenDeGiay())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return deGiayRepository.save(deGiay);
    }

    @Override
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

    @Override
    public void deleteDeGiay(Integer id) {
        if (deGiayRepository.existsById(id)) {
            deGiayRepository.deleteById(id);
        } else {
            throw new RuntimeException("Đế giày không tồn tại");
        }
    }
}
