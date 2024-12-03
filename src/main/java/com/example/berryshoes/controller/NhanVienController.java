package com.example.berryshoes.controller;

import com.example.berryshoes.dto.response.NhanVienResponse;
import com.example.berryshoes.entity.KhachHang;
import com.example.berryshoes.repository.NhanVienRepository;
import com.example.berryshoes.service.NhanVienService;
import com.example.berryshoes.dto.request.NhanVienRequest;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.utils.UserUltis;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienService nhanVienService;
    @Autowired
    private final NhanVienRepository nvrp;

    @Autowired
    private UserUltis userUltis;

    // Lấy tất cả nhân viên
    @GetMapping
    public ResponseEntity<List<NhanVien>> getAllNhanVien() {
        List<NhanVien> nhanVienList = nhanVienService.getAllNhanVien();
        return ResponseEntity.ok(nhanVienList);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(Pageable pageable, @RequestParam(required = false) Integer trangthai){
        Page<NhanVien> page = null;
        page = nvrp.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    // Lấy nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Integer id) {
        Optional<NhanVien> nhanVien = nhanVienService.getNhanVienById(id);
        return nhanVien.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới nhân viên
    @PostMapping
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVienRequest requestDTO) {
        NhanVien createdNhanVien = nhanVienService.createNhanVien(requestDTO);
        return ResponseEntity.ok(createdNhanVien);
    }

    // Cập nhật nhân viên
    @PostMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable Integer id, @RequestBody NhanVienRequest requestDTO) {
        NhanVien updatedNhanVien = nhanVienService.updateNhanVien(id, requestDTO);
        return updatedNhanVien != null ? ResponseEntity.ok(updatedNhanVien) : ResponseEntity.notFound().build();
    }

    // Xóa nhân viên
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Integer id) {
        nhanVienService.deleteNhanVien(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/dang-dang-nhap")
    public ResponseEntity<?> nhanVienDangDangNhap(HttpServletRequest request) {
        NhanVien nhanVien = userUltis.getLoggedInNhanVien(request);
        NhanVienResponse nhanVienResponse = new NhanVienResponse();
        nhanVienResponse.setMaNhanVien(nhanVien.getMaNhanVien());
        nhanVienResponse.setEmail(nhanVien.getEmail());
        nhanVienResponse.setAnh(nhanVien.getAnh());
        nhanVienResponse.setHoVaTen(nhanVienResponse.getHoVaTen());
        nhanVienResponse.setId(nhanVien.getId());
        return new ResponseEntity<>(nhanVienResponse, HttpStatus.OK);
    }
}
