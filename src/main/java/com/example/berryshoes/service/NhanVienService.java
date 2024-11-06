package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.NhanVienRequest;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.repository.NhanVienRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface NhanVienService {
    // Lấy tất cả nhân viên
    List<NhanVien> getAllNhanVien();

    // Lấy nhân viên theo ID
    Optional<NhanVien> getNhanVienById(Integer id);

    // Tạo mới nhân viên
    NhanVien createNhanVien(NhanVienRequest requestDTO);

    // Cập nhật nhân viên
    NhanVien updateNhanVien(Integer id, NhanVienRequest requestDTO);

    // Xóa nhân viên
    void deleteNhanVien(Integer id);

    // Tìm kiếm nhân viên theo tên hoặc số điện thoại
    List<NhanVien> findByHoVaTenOrSoDienThoai(String hoVaTen, String soDienThoai);

    // Lọc nhân viên theo trạng thái
    List<NhanVien> findByTrangThai(Integer trangThai);

    // Tìm kiếm nhân viên theo tên và trạng thái
    List<NhanVien> findByHoVaTenAndTrangThai(String hoVaTen, Integer trangThai);

    // Lọc nhân viên theo ngày tạo và trạng thái
    List<NhanVien> findByFilter(Date startDate, Date endDate, Integer trangThai);

    // Lấy nhân viên mặc định theo ID
    NhanVien findByIdNhanVienMacDinh(Integer idNhanVien);

    // Tìm nhân viên theo mã nhân viên
    NhanVien findByMaNhanVien(String maNhanVien);
}
