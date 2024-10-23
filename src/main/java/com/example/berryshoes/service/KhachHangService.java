package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.KhachHangRequest;
import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    // Lấy tất cả khách hàng
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    // Lấy khách hàng theo ID
    public Optional<KhachHang> getKhachHangById(Integer id) {
        return khachHangRepository.findById(id);
    }

    // Tạo mới khách hàng
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

    // Cập nhật khách hàng
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

    // Xóa khách hàng
    public void deleteKhachHang(Integer id) {
        if (khachHangRepository.existsById(id)) {
            khachHangRepository.deleteById(id);
        } else {
            throw new RuntimeException("Khách hàng không tồn tại");
        }
    }


}
