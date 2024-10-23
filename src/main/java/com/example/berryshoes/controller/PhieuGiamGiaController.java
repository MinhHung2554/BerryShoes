package com.example.berryshoes.controller;

import com.example.berryshoes.dto.request.PhieuGiamGiaRequest;
import com.example.berryshoes.entity.PhieuGiamGia;
import com.example.berryshoes.service.PhieuGiamGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phieu-giam-gia")
@RequiredArgsConstructor
public class PhieuGiamGiaController {
    private final PhieuGiamGiaService phieuGiamGiaService;
    @GetMapping
    public ResponseEntity<List<PhieuGiamGia>> getAllPhieuGiamGia() {
        List<PhieuGiamGia> phieuGiamGiaList = phieuGiamGiaService.getAllPhieuGiamGia();
        return ResponseEntity.ok(phieuGiamGiaList);
    }

    // Lấy phiếu giảm giá theo ID
    @GetMapping("/{id}")
    public ResponseEntity<PhieuGiamGia> getPhieuGiamGiaById(@PathVariable Integer id) {
        Optional<PhieuGiamGia> phieuGiamGia = phieuGiamGiaService.getPhieuGiamGiaById(id);
        return phieuGiamGia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới phiếu giảm giá
    @PostMapping
    public ResponseEntity<PhieuGiamGia> createPhieuGiamGia(@RequestBody PhieuGiamGiaRequest requestDTO) {
        PhieuGiamGia createdPhieuGiamGia = phieuGiamGiaService.createPhieuGiamGia(requestDTO);
        return ResponseEntity.ok(createdPhieuGiamGia);
    }

    // Cập nhật phiếu giảm giá
    @PutMapping("/{id}")
    public ResponseEntity<PhieuGiamGia> updatePhieuGiamGia(@PathVariable Integer id, @RequestBody PhieuGiamGiaRequest requestDTO) {
        PhieuGiamGia updatedPhieuGiamGia = phieuGiamGiaService.updatePhieuGiamGia(id, requestDTO);
        return updatedPhieuGiamGia != null ? ResponseEntity.ok(updatedPhieuGiamGia) : ResponseEntity.notFound().build();
    }

    // Xóa phiếu giảm giá
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhieuGiamGia(@PathVariable Integer id) {
        phieuGiamGiaService.deletePhieuGiamGia(id);
        return ResponseEntity.noContent().build();
    }
}
