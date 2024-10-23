package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.KichCoRequest;
import com.example.berryshoes.entity.KichCo;
import com.example.berryshoes.repository.KichCoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KichCoService {
    @Autowired
    private KichCoRepository kichCoRepository;

    // Lấy tất cả kích cỡ
    public List<KichCo> getAllKichCo() {
        return kichCoRepository.findAll();
    }

    // Lấy kích cỡ theo ID
    public Optional<KichCo> getKichCoById(Integer id) {
        return kichCoRepository.findById(id);
    }

    // Tạo mới kích cỡ
    public KichCo createKichCo(KichCoRequest requestDTO) {
        KichCo kichCo = KichCo.builder()
                .tenKichCo(requestDTO.getTenKichCo())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return kichCoRepository.save(kichCo);
    }

    // Cập nhật kích cỡ
    public KichCo updateKichCo(Integer id, KichCoRequest requestDTO) {
        Optional<KichCo> optionalKichCo = kichCoRepository.findById(id);
        if (optionalKichCo.isPresent()) {
            KichCo kichCo = optionalKichCo.get();
            kichCo.setTenKichCo(requestDTO.getTenKichCo());
            kichCo.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            kichCo.setTrangThai(requestDTO.getTrangThai());
            return kichCoRepository.save(kichCo);
        }
        return null;
    }

    // Xóa kích cỡ
    public void deleteKichCo(Integer id) {
        if (kichCoRepository.existsById(id)) {
            kichCoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kích cỡ không tồn tại");
        }
    }
}
