package com.example.berryshoes.controller;

import com.example.berryshoes.dto.request.DotGiamGiaRequest;
import com.example.berryshoes.dto.response.DotGiamGiaResponse;
import com.example.berryshoes.security.service.DotGiamGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dot-giam-gia")
@RequiredArgsConstructor
public class DotGiamGiaController {

    private final DotGiamGiaService dotGiamGiaService;

    // Lấy tất cả đợt giảm giá
    @GetMapping
    public ResponseEntity<List<DotGiamGiaResponse>> getAllDotGiamGia() {
        List<DotGiamGiaResponse> dotGiamGias = dotGiamGiaService.getAllDotGiamGia();
        return ResponseEntity.ok(dotGiamGias);
    }

    // Lấy đợt giảm giá theo ID
    @GetMapping("/{id}")
    public ResponseEntity<DotGiamGiaResponse> getDotGiamGiaById(@PathVariable Integer id) {
        return dotGiamGiaService.getDotGiamGiaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Tạo mới đợt giảm giá
    @PostMapping
    public ResponseEntity<DotGiamGiaResponse> createDotGiamGia(@RequestBody DotGiamGiaRequest requestDTO) {
        DotGiamGiaResponse createdDotGiamGia = dotGiamGiaService.createDotGiamGia(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDotGiamGia);
    }

    // Cập nhật đợt giảm giá
    @PutMapping("/{id}")
    public ResponseEntity<DotGiamGiaResponse> updateDotGiamGia(
            @PathVariable Integer id,
            @RequestBody DotGiamGiaRequest requestDTO) {
        DotGiamGiaResponse updatedDotGiamGia = dotGiamGiaService.updateDotGiamGia(id, requestDTO);
        return updatedDotGiamGia != null
                ? ResponseEntity.ok(updatedDotGiamGia)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Xóa đợt giảm giá
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDotGiamGia(@PathVariable Integer id) {
        dotGiamGiaService.deleteDotGiamGia(id);
        return ResponseEntity.noContent().build();
    }
}
