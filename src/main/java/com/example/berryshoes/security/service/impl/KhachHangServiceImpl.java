package com.example.berryshoes.security.service.impl;

import com.example.berryshoes.dto.request.KhachHangRequest;
import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.repository.KhachHangRepository;
import com.example.berryshoes.security.service.KhachHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {
    private final KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> getKhachHangById(Integer id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang createKhachHang(KhachHangRequest requestDTO) {
        KhachHang khachHang = KhachHang.builder()
                .maKhachHang(requestDTO.getMaKhachHang())
                .anh(requestDTO.getAnh())
                .hoVaTen(requestDTO.getHoVaTen())
                .ngaySinh(requestDTO.getNgaySinh())
                .gioiTinh(requestDTO.getGioiTinh())
                .soDienThoai(requestDTO.getSoDienThoai())
                .email(requestDTO.getEmail())
                .taiKhoan(requestDTO.getTaiKhoan())
                .matKhau(requestDTO.getMatKhau())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang updateKhachHang(Integer id, KhachHangRequest requestDTO) {
        Optional<KhachHang> optionalKhachHang = khachHangRepository.findById(id);
        if (optionalKhachHang.isPresent()) {
            KhachHang khachHang = optionalKhachHang.get();
            khachHang.setMaKhachHang(requestDTO.getMaKhachHang());
            khachHang.setAnh(requestDTO.getAnh());
            khachHang.setHoVaTen(requestDTO.getHoVaTen());
            khachHang.setNgaySinh(requestDTO.getNgaySinh());
            khachHang.setGioiTinh(requestDTO.getGioiTinh());
            khachHang.setSoDienThoai(requestDTO.getSoDienThoai());
            khachHang.setEmail(requestDTO.getEmail());
            khachHang.setTaiKhoan(requestDTO.getTaiKhoan());
            khachHang.setMatKhau(requestDTO.getMatKhau());
            khachHang.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            khachHang.setTrangThai(requestDTO.getTrangThai());

            return khachHangRepository.save(khachHang);
        }
        return null;
    }

    @Override
    public void deleteKhachHang(Integer id) {
        if (khachHangRepository.existsById(id)) {
            khachHangRepository.deleteById(id);
        } else {
            throw new RuntimeException("Khách hàng không tồn tại");
        }
    }
}
