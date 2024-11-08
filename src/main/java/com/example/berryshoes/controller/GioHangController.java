package com.example.berryshoes.controller;

import com.example.berryshoes.entity.GioHang;
import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.service.GioHangService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gio-hang")
@RequiredArgsConstructor
public class GioHangController {

    private final GioHangService gioHangService;

    // Lấy giỏ hàng của khách hàng theo trạng thái
    @GetMapping("/current/{khachHangId}/{trangThai}")
    public ResponseEntity<GioHang> getCurrentGioHang(@PathVariable Integer khachHangId, @PathVariable Integer trangThai) {
        KhachHang khachHang = new KhachHang();
        khachHang.setId(khachHangId);
        GioHang gioHang = gioHangService.findCurrentGioHang(khachHang, trangThai);
        return gioHang != null ? ResponseEntity.ok(gioHang) : ResponseEntity.notFound().build();
    }

    // Lấy giỏ hàng của khách hàng
    @GetMapping("/khach-hang/{khachHangId}")
    public ResponseEntity<GioHang> getGioHangByKhachHang(@PathVariable Integer khachHangId) {
        KhachHang khachHang = new KhachHang();
        khachHang.setId(khachHangId);
        GioHang gioHang = gioHangService.findByKhachHang(khachHang);
        return gioHang != null ? ResponseEntity.ok(gioHang) : ResponseEntity.notFound().build();
    }

    // Lấy giỏ hàng theo ID khách hàng
    @GetMapping("/id/{id}")
    public ResponseEntity<GioHang> getGioHangById(@PathVariable Integer id) {
        GioHang gioHang = gioHangService.findByIdKhachHang(id);
        return gioHang != null ? ResponseEntity.ok(gioHang) : ResponseEntity.notFound().build();
    }

    // Cập nhật số lượng trong giỏ hàng
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateSoLuong(@PathVariable Integer id, @RequestParam Integer soLuong) {
        gioHangService.updateSoLuongById(soLuong, id);
        return ResponseEntity.noContent().build();
    }

    // Lấy giỏ hàng theo gioHangId và spctId
    @GetMapping("/giohang/{gioHangId}/sanpham/{spctId}")
    public ResponseEntity<GioHang> getGioHangByGiohangIdAndSpctId(@PathVariable Integer gioHangId, @PathVariable Integer spctId) {
        GioHang gioHang = gioHangService.findByGiohangIdAndSanPhamChiTietId(gioHangId, spctId);
        return gioHang != null ? ResponseEntity.ok(gioHang) : ResponseEntity.notFound().build();
    }

    // Lấy tất cả giỏ hàng của một khách hàng
    @GetMapping("/all/{id}")
    public ResponseEntity<List<GioHang>> getAllGioHang(@PathVariable Integer id) {
        List<GioHang> gioHangList = gioHangService.findGioHangByGiohang(id);
        return ResponseEntity.ok(gioHangList);
    }

    // Xóa giỏ hàng theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGioHang(@PathVariable Integer id) {
        gioHangService.deleteGioHang(id);
        return ResponseEntity.noContent().build();
    }

    // Lấy thông tin khách hàng từ giỏ hàng
    @GetMapping("/khach-hang-info/{id}")
    public ResponseEntity<KhachHang> getKhachHangInfo(@PathVariable Integer id) {
        KhachHang khachHang = gioHangService.findByKhachHangId(id);
        return khachHang != null ? ResponseEntity.ok(khachHang) : ResponseEntity.notFound().build();
    }
}
