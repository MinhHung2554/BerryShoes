package com.example.berryshoes.controller;

import com.example.berryshoes.entity.GioHang;
import com.example.berryshoes.service.GioHangService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/giohang")
@RequiredArgsConstructor
public class GioHangController {

    private final GioHangService gioHangService;

    // Lấy tất cả giỏ hàng
    @GetMapping
    public ResponseEntity<List<GioHang>> getAllGioHang() {
        List<GioHang> gioHangList = gioHangService.getAllGioHang();
        return ResponseEntity.ok(gioHangList);
    }

    // Lấy giỏ hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<GioHang> getGioHangById(@PathVariable Integer id) {
        Optional<GioHang> gioHang = gioHangService.getGioHangById(id);
        return gioHang.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới giỏ hàng
    @PostMapping
    public ResponseEntity<GioHang> createGioHang(@Valid @RequestBody GioHang gioHang) {
        GioHang createdGioHang = gioHangService.createGioHang(gioHang);
        return ResponseEntity.ok(createdGioHang);
    }

    // Cập nhật giỏ hàng
    @PutMapping("/{id}")
    public ResponseEntity<GioHang> updateGioHang(@PathVariable Integer id, @Valid @RequestBody GioHang gioHang) {
        Optional<GioHang> updatedGioHang = gioHangService.updateGioHang(id, gioHang);
        return updatedGioHang.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa giỏ hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGioHang(@PathVariable Integer id) {
        gioHangService.deleteGioHang(id);
        return ResponseEntity.noContent().build();
    }

    // Tìm kiếm giỏ hàng theo IdKhachHang
    @GetMapping("/search")
    public ResponseEntity<List<GioHang>> searchGioHangByKhachHang(@RequestParam Integer khachHangId) {
        List<GioHang> gioHangList = gioHangService.findByKhachHangId(khachHangId);
        return ResponseEntity.ok(gioHangList);
    }

    // Lọc giỏ hàng theo trạng thái
    @GetMapping("/filter")
    public ResponseEntity<List<GioHang>> filterGioHangByTrangThai(@RequestParam Boolean trangThai) {
        List<GioHang> gioHangList = gioHangService.filterGioHangByTrangThai(trangThai);
        return ResponseEntity.ok(gioHangList);
    }
}
