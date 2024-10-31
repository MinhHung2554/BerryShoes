package com.example.berryshoes.controller;

import com.example.berryshoes.dto.response.NhanVienResponse;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.service.NhanVienService;
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
        NhanVienResponse reponse = new NhanVienResponse();
        reponse.setId(createdNhanVien.getId());
        reponse.setMaNhanVien(createdNhanVien.getMaNhanVien());
        reponse.setAnh(createdNhanVien.getAnh());
        reponse.setHoVaTen(createdNhanVien.getHoVaTen());
        reponse.setEmail(createdNhanVien.getEmail());
        reponse.setGioiTinh(createdNhanVien.getGioiTinh());
        reponse.setSoDienThoai(createdNhanVien.getSoDienThoai());
        reponse.setTaiKhoan(createdNhanVien.getTaiKhoan());
        reponse.setVaiTro(createdNhanVien.getVaiTro());
        reponse.setNguoiTao(createdNhanVien.getNguoiTao());
        reponse.setNgayTao(createdNhanVien.getNgayTao());
        reponse.setNguoiCapNhat(createdNhanVien.getNguoiCapNhat());
        reponse.setLanCapNhatCuoi(createdNhanVien.getLanCapNhatCuoi());
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

    private NhanVienResponse convertToResponse(NhanVien nv) {
        NhanVienResponse response = new NhanVienResponse();
        response.setId(nv.getId());
        response.setMaNhanVien(nv.getMaNhanVien());
        response.setAnh(nv.getAnh());
        response.setHoVaTen(nv.getHoVaTen());
        response.setEmail(nv.getEmail());
        response.setGioiTinh(nv.getGioiTinh());
        response.setSoDienThoai(nv.getSoDienThoai());
        response.setTaiKhoan(nv.getTaiKhoan());
        response.setVaiTro(nv.getVaiTro());
        response.setNguoiTao(nv.getNguoiTao());
        response.setNgayTao(nv.getNgayTao());
        response.setNguoiCapNhat(nv.getNguoiCapNhat());
        response.setLanCapNhatCuoi(nv.getLanCapNhatCuoi());
        return response;
    }

    // Tìm kiếm nhân viên theo tên và trangThai
//    @GetMapping("/search")
//    public ResponseEntity<?> searchNhanVienByName(@RequestBody String hovaTen) {
//        List<NhanVien> nhanVienList = nhanVienService.searchNhanVienByName(hovaTen);
//        if (nhanVienList == null || nhanVienList.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy nhân viên");
//        }
//        return ResponseEntity.ok(nhanVienList);
//    }
    @GetMapping("/search")
    public ResponseEntity<List<NhanVien>> searchNhanVien(@RequestParam String hoVaTen, @RequestParam(required = false) Integer trangThai) {
        List<NhanVien> nhanVienList = nhanVienService.findByHoVaTenAndTrangThai(hoVaTen, trangThai);
        return ResponseEntity.ok(nhanVienList);
    }

//    @GetMapping("/loc")
//    public ResponseEntity<List<NhanVien>> filterNhanVienByStatus(@RequestParam Integer trangThai) {
//        List<NhanVien> nhanVienList = nhanVienService.filterNhanVienByStatus(trangThai);
//        return ResponseEntity.ok(nhanVienList);
//    }
}
