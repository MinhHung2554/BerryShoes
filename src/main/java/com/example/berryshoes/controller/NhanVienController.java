package com.example.berryshoes.controller;

import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.security.service.NhanVienService;
import com.example.berryshoes.dto.request.NhanVienRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhanvien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;

    // Lấy tất cả nhân viên
    @GetMapping
    public ResponseEntity<List<NhanVien>> getAllNhanVien() {
        List<NhanVien> nhanVienList = nhanVienService.getAllNhanVien();
        return ResponseEntity.ok(nhanVienList);
    }

    // Lấy nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Integer id) {
        Optional<NhanVien> nhanVien = nhanVienService.getNhanVienById(id);
        return nhanVien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới nhân viên
    @PostMapping
    public ResponseEntity<NhanVien> createNhanVien(@Valid @RequestBody NhanVienRequest requestDTO) {
        NhanVien createdNhanVien = nhanVienService.createNhanVien(requestDTO);
        return ResponseEntity.ok(createdNhanVien);
    }

    // Cập nhật nhân viên
    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable Integer id, @Valid @RequestBody NhanVienRequest requestDTO) {
        NhanVien updatedNhanVien = nhanVienService.updateNhanVien(id, requestDTO);
        return updatedNhanVien != null ? ResponseEntity.ok(updatedNhanVien) : ResponseEntity.notFound().build();
    }

    // Xóa nhân viên
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Integer id) {
        nhanVienService.deleteNhanVien(id);
        return ResponseEntity.noContent().build();
    }
    // Tìm kiếm nhân viên theo tên
    @GetMapping("/search")
    public ResponseEntity<List<NhanVien>> searchNhanVienByName(@RequestParam String hovaTen) {
        List<NhanVien> nhanVienList = nhanVienService.searchNhanVienByName(hovaTen);
        return ResponseEntity.ok(nhanVienList);
    }
    @GetMapping("/loc")
    public ResponseEntity<List<NhanVien>> filterNhanVienByStatus(@RequestParam String trangThai) {
        List<NhanVien> nhanVienList = nhanVienService.filterNhanVienByStatus(trangThai);
        return ResponseEntity.ok(nhanVienList);
    }
}
