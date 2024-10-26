package com.example.berryshoes.controller;

import com.example.berryshoes.service.SanPhamService;
import com.example.berryshoes.dto.request.SanPhamRequest;
import com.example.berryshoes.entity.SanPham;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/san-pham")
@RequiredArgsConstructor
public class SanPhamController {
    private final SanPhamService sanPhamService;
    @GetMapping
    public ResponseEntity<List<SanPham>> getAllSanPham() {
        List<SanPham> sanPhamList = sanPhamService.getAll();
        return ResponseEntity.ok(sanPhamList);
    }

    // Lấy sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable Integer id) {
        Optional<SanPham> sanPham = sanPhamService.getById(id);
        return sanPham.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới sản phẩm
    @PostMapping
    public ResponseEntity<SanPham> createSanPham(@RequestBody SanPhamRequest requestDTO) {
        SanPham createdSanPham = sanPhamService.create(requestDTO);
        return ResponseEntity.ok(createdSanPham);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable Integer id, @RequestBody SanPhamRequest requestDTO) {
        SanPham updatedSanPham = sanPhamService.update(id, requestDTO);
        return updatedSanPham != null ? ResponseEntity.ok(updatedSanPham) : ResponseEntity.notFound().build();
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSanPham(@PathVariable Integer id) {
        sanPhamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
