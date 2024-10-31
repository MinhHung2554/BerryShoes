package com.example.berryshoes.controller;

import com.example.berryshoes.dto.response.KhachHangResponse;
import com.example.berryshoes.service.KhachHangService;
import com.example.berryshoes.dto.request.KhachHangRequest;
import com.example.berryshoes.entity.KhachHang;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khachhang")
@RequiredArgsConstructor
public class KhachHangController {
    private final KhachHangService khachHangService;

    // Lấy tất cả khách hàng
    @GetMapping
    public ResponseEntity<List<KhachHang>> getAllKhachHang() {
        List<KhachHang> khachHangList = khachHangService.getAllKhachHang();
        return ResponseEntity.ok(khachHangList);
    }

    // Lấy khách hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable Integer id) {
        Optional<KhachHang> khachHang = khachHangService.getKhachHangById(id);
        return khachHang.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới khách hàng
    @PostMapping
    public ResponseEntity<KhachHang> createKhachHang(@RequestBody KhachHangRequest requestDTO) {
        KhachHang createdKhachHang = khachHangService.createKhachHang(requestDTO);
        KhachHangResponse response = new KhachHangResponse();
        response.setId(createdKhachHang.getId());
        response.setMaKhachHang(createdKhachHang.getMaKhachHang());
        response.setAnh(createdKhachHang.getAnh());
        response.setHoVaTen(createdKhachHang.getHoVaTen());
        response.setGioiTinh(createdKhachHang.getGioiTinh());
        response.setEmail(createdKhachHang.getEmail());
        response.setSoDienThoai(createdKhachHang.getSoDienThoai());
        response.setTaiKhoan(createdKhachHang.getTaiKhoan());
        response.setNguoiTao(createdKhachHang.getNguoiTao());
        response.setNgayTao(createdKhachHang.getNgayTao());
        response.setNguoiCapNhat(createdKhachHang.getNguoiCapNhat());
        response.setTrangThai(createdKhachHang.getTrangThai());
        return ResponseEntity.ok(createdKhachHang);
    }

    // Cập nhật khách hàng
    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> updateKhachHang(@PathVariable Integer id, @RequestBody KhachHangRequest requestDTO) {
        KhachHang updatedKhachHang = khachHangService.updateKhachHang(id, requestDTO);
        return updatedKhachHang != null ? ResponseEntity.ok(updatedKhachHang) : ResponseEntity.notFound().build();
    }

    // Xóa khách hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable Integer id) {
        khachHangService.deleteKhachHang(id);
        return ResponseEntity.noContent().build();
    }

    private KhachHangResponse convertToResponse(KhachHang kh) {
        KhachHangResponse response = new KhachHangResponse();
        response.setId(kh.getId());
        response.setMaKhachHang(kh.getMaKhachHang());
        response.setAnh(kh.getAnh());
        response.setHoVaTen(kh.getHoVaTen());
        response.setEmail(kh.getEmail());
        response.setGioiTinh(kh.getGioiTinh());
        response.setSoDienThoai(kh.getSoDienThoai());
        response.setTaiKhoan(kh.getTaiKhoan());
        response.setNguoiTao(kh.getNguoiTao());
        response.setNgayTao(kh.getNgayTao());
        response.setNguoiCapNhat(kh.getNguoiCapNhat());
        response.setLanCapNhatCuoi(kh.getLanCapNhatCuoi());
        return response;
    }

    // Tìm kiếm
    @GetMapping("/search")
    public ResponseEntity<List<KhachHang>> searchKhachHang(@RequestParam String hoVaTen, @RequestParam(required = false) Integer trangThai) {
        List<KhachHang> khachHangList = khachHangService.findByHoVaTenAndTrangThai(hoVaTen, trangThai);
        return ResponseEntity.ok(khachHangList);
    }
}
