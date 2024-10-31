package com.example.berryshoes.controller;

import com.example.berryshoes.dto.request.AnhRequest;
import com.example.berryshoes.dto.response.AnhResponse;
import com.example.berryshoes.entity.Anh;
import com.example.berryshoes.service.AnhService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/anh")
@RequiredArgsConstructor
public class AnhController {

    private final AnhService anhService;

    // Lấy tất cả ảnh
    @GetMapping
    public ResponseEntity<List<Anh>> getAllAnh() {
        List<Anh> anhList = anhService.getAll();
        return ResponseEntity.ok(anhList);
    }

    // Lấy ảnh theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Anh> getAnhById(@PathVariable Integer id) {
        Optional<Anh> anh = anhService.getAnhById(id);
        return anh.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới ảnh
    @PostMapping
    public ResponseEntity<Anh> createAnh(@RequestBody Anh anh) {
        Anh createdAnh = anhService.createAnh(anh);
        return ResponseEntity.ok(createdAnh);
    }

    // Cập nhật ảnh
    @PutMapping("/{id}")
    public ResponseEntity<Anh> updateAnh(@PathVariable Integer id, @RequestBody Anh anh) {
        Optional<Anh> updatedAnh = anhService.updateAnh(id, anh);
        return updatedAnh.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa ảnh
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnh(@PathVariable Integer id) {
        anhService.deleteAnh(id);
        return ResponseEntity.noContent().build();
    }

    // Tìm kiếm ảnh theo tên
    @GetMapping("/search")
    public ResponseEntity<List<Anh>> searchAnhByTenAnh(@RequestParam String tenAnh) {
        List<Anh> anhList = anhService.searchAnhByTenAnh(tenAnh);
        return ResponseEntity.ok(anhList);
    }

    // Lọc ảnh theo trạng thái
    @GetMapping("/filter")
    public ResponseEntity<List<Anh>> filterAnhByTrangThai(@RequestParam Boolean trangThai) {
        List<Anh> anhList = anhService.filterAnhByTrangThai(trangThai);
        return ResponseEntity.ok(anhList);
    }
}