package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.DotGiamGiaRequest;
import com.example.berryshoes.dto.response.DotGiamGiaResponse;
import com.example.berryshoes.entity.DotGiamGia;
import com.example.berryshoes.repository.DotGiamGiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DotGiamGiaService {
    private final DotGiamGiaRepository dotGiamGiaRepository;

    // Lấy tất cả đợt giảm giá
    public List<DotGiamGiaResponse> getAllDotGiamGia() {
        return dotGiamGiaRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Lấy đợt giảm giá theo ID
    public Optional<DotGiamGiaResponse> getDotGiamGiaById(Integer id) {
        return dotGiamGiaRepository.findById(id)
                .map(this::convertToResponse);
    }

    // Tạo mới đợt giảm giá
    public DotGiamGiaResponse createDotGiamGia(DotGiamGiaRequest requestDTO) {
        DotGiamGia dotGiamGia = new DotGiamGia();
        dotGiamGia.setGiaTriGiam(requestDTO.getGiaTriGiam());
        dotGiamGia.setNgayBatDau(requestDTO.getNgayBatDau());
        dotGiamGia.setNgayKetThuc(requestDTO.getNgayKetThuc());
        dotGiamGia.setNguoiTao(requestDTO.getNguoiTao());
        dotGiamGia.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
        dotGiamGia.setTrangThai(requestDTO.getTrangThai());
        DotGiamGia savedDotGiamGia = dotGiamGiaRepository.save(dotGiamGia);
        return convertToResponse(savedDotGiamGia);
    }

    // Cập nhật đợt giảm giá
    public DotGiamGiaResponse updateDotGiamGia(Integer id, DotGiamGiaRequest requestDTO) {
        Optional<DotGiamGia> optionalDotGiamGia = dotGiamGiaRepository.findById(id);
        if (optionalDotGiamGia.isPresent()) {
            DotGiamGia dotGiamGia = optionalDotGiamGia.get();
            dotGiamGia.setGiaTriGiam(requestDTO.getGiaTriGiam());
            dotGiamGia.setNgayBatDau(requestDTO.getNgayBatDau());
            dotGiamGia.setNgayKetThuc(requestDTO.getNgayKetThuc());
            dotGiamGia.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            dotGiamGia.setTrangThai(requestDTO.getTrangThai());
            DotGiamGia updatedDotGiamGia = dotGiamGiaRepository.save(dotGiamGia);
            return convertToResponse(updatedDotGiamGia);
        }
        return null; // Hoặc ném ra ngoại lệ nếu không tìm thấy
    }

    // Xóa đợt giảm giá
    public void deleteDotGiamGia(Integer id) {
        dotGiamGiaRepository.deleteById(id);
    }

    // Chuyển đổi từ DotGiamGia sang DotGiamGiaResponse
    private DotGiamGiaResponse convertToResponse(DotGiamGia dotGiamGia) {
        return DotGiamGiaResponse.builder()
                .id(dotGiamGia.getId())
                .giaTriGiam(dotGiamGia.getGiaTriGiam())
                .ngayBatDau(dotGiamGia.getNgayBatDau())
                .ngayKetThuc(dotGiamGia.getNgayKetThuc())
                .ngayTao(dotGiamGia.getNgayTao())
                .nguoiTao(dotGiamGia.getNguoiTao())
                .lanCapNhatCuoi(dotGiamGia.getLanCapNhatCuoi())
                .nguoiCapNhat(dotGiamGia.getNguoiCapNhat())
                .trangThai(dotGiamGia.getTrangThai())
                .build();
    }
}
