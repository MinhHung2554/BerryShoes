package com.example.berryshoes.Service;

import com.example.berryshoes.dto.request.NhanVienRequest;
import com.example.berryshoes.dto.response.NhanVienResponse;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Lấy tất cả nhân viên
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    // Lấy nhân viên theo ID
    public Optional<NhanVien> getNhanVienById(Integer id) {
        return nhanVienRepository.findById(id);
    }

    // Tạo mới nhân viên
    public NhanVien createNhanVien(NhanVienRequest requestDTO) {
        NhanVien nhanVien = NhanVien.builder()
                .maNhanVien(requestDTO.getMaNhanVien())
                .anh(requestDTO.getAnh())
                .hoVaTen(requestDTO.getHoVaTen())
                .ngaySinh(requestDTO.getNgaySinh())
                .gioiTinh(requestDTO.getGioiTinh())
                .queQuan(requestDTO.getQueQuan())
                .cccd(requestDTO.getCccd())
                .soDienThoai(requestDTO.getSoDienThoai())
                .email(requestDTO.getEmail())
                .taiKhoan(requestDTO.getTaiKhoan())
                .matKhau(requestDTO.getMatKhau())
                .vaiTro(requestDTO.getVaiTro())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return nhanVienRepository.save(nhanVien);
    }

    // Cập nhật nhân viên
    public NhanVien updateNhanVien(Integer id, NhanVienRequest requestDTO) {
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(id);
        if (optionalNhanVien.isPresent()) {
            NhanVien nhanVien = optionalNhanVien.get();
            nhanVien.setMaNhanVien(requestDTO.getMaNhanVien());
            nhanVien.setAnh(requestDTO.getAnh());
            nhanVien.setHoVaTen(requestDTO.getHoVaTen());
            nhanVien.setNgaySinh(requestDTO.getNgaySinh());
            nhanVien.setGioiTinh(requestDTO.getGioiTinh());
            nhanVien.setQueQuan(requestDTO.getQueQuan());
            nhanVien.setCccd(requestDTO.getCccd());
            nhanVien.setSoDienThoai(requestDTO.getSoDienThoai());
            nhanVien.setEmail(requestDTO.getEmail());
            nhanVien.setTaiKhoan(requestDTO.getTaiKhoan());
            nhanVien.setMatKhau(requestDTO.getMatKhau());
            nhanVien.setVaiTro(requestDTO.getVaiTro());
            nhanVien.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            nhanVien.setTrangThai(requestDTO.getTrangThai());

            return nhanVienRepository.save(nhanVien);
        }
        return null;
    }

    // Xóa nhân viên
    public void deleteNhanVien(Integer id) {
        if (nhanVienRepository.existsById(id)) {
            nhanVienRepository.deleteById(id);
        } else {
            throw new RuntimeException("Nhân viên không tồn tại");
        }
    }
}
