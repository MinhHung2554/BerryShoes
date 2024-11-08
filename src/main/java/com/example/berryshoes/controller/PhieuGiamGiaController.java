package com.example.berryshoes.controller;

import com.example.berryshoes.dto.request.PhieuGiamGiaRequest;
import com.example.berryshoes.entity.HoaDon;
import com.example.berryshoes.entity.PhieuGiamGia;
import com.example.berryshoes.service.PhieuGiamGiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
        PhieuGiamGia createdPhieuGiamGia = phieuGiamGiaService.create(requestDTO);
        return ResponseEntity.ok(createdPhieuGiamGia);
    }

    // Cập nhật phiếu giảm giá
    @PutMapping("/{id}")
    public ResponseEntity<PhieuGiamGia> updatePhieuGiamGia(@PathVariable Integer id, @RequestBody PhieuGiamGiaRequest requestDTO) {
        PhieuGiamGia updatedPhieuGiamGia = phieuGiamGiaService.update(id, requestDTO);
        return updatedPhieuGiamGia != null ? ResponseEntity.ok(updatedPhieuGiamGia) : ResponseEntity.notFound().build();
    }

    // Xóa phiếu giảm giá
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhieuGiamGia(@PathVariable Integer id) {
        phieuGiamGiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    // Tìm kiếm phiếu giảm giá với các điều kiện
    @GetMapping("/search")
    public ResponseEntity<Page<PhieuGiamGia>> searchPhieuGiamGia(@RequestParam(required = false) String keySearch,
                                                                 @RequestParam(required = false) Timestamp tungaySearch,
                                                                 @RequestParam(required = false) Timestamp denngaySearch,
                                                                 @RequestParam(required = false) Boolean kieuSearch,
                                                                 @RequestParam(required = false) Boolean loaiSearch,
                                                                 @RequestParam(required = false) Integer ttSearch,
                                                                 Pageable pageable) {
        Page<PhieuGiamGia> phieuGiamGiaPage = phieuGiamGiaService.findAllOrderByNgayTaoDESC(
                keySearch, tungaySearch, denngaySearch, kieuSearch, loaiSearch, ttSearch, pageable);
        return ResponseEntity.ok(phieuGiamGiaPage);
    }

    // Lấy tất cả các phiếu giảm giá của một hóa đơn
    @GetMapping("/hoa-don/{hoaDonId}")
    public ResponseEntity<List<PhieuGiamGia>> getPhieuGiamGiaByHoaDon(@PathVariable Integer hoaDonId) {
        HoaDon hoaDon = new HoaDon(); // Assume HoaDon entity is correctly instantiated or fetched
        hoaDon.setId(hoaDonId);
        List<PhieuGiamGia> phieuGiamGiaList = phieuGiamGiaService.findAllByHoaDon(hoaDon);
        return ResponseEntity.ok(phieuGiamGiaList);
    }

    // Lấy phiếu giảm giá theo mã code
    @GetMapping("/ma-code/{maCode}")
    public ResponseEntity<PhieuGiamGia> getPhieuGiamGiaByMaCode(@PathVariable String maCode) {
        PhieuGiamGia phieuGiamGia = phieuGiamGiaService.findPhieuGiamGiaByMaCode(maCode);
        return phieuGiamGia != null ? ResponseEntity.ok(phieuGiamGia) : ResponseEntity.notFound().build();
    }

    // Lấy phiếu giảm giá mới nhất
    @GetMapping("/latest")
    public ResponseEntity<PhieuGiamGia> getLatestPhieuGiamGia() {
        PhieuGiamGia phieuGiamGia = phieuGiamGiaService.findFirstByOrderByNgayTaoDesc();
        return phieuGiamGia != null ? ResponseEntity.ok(phieuGiamGia) : ResponseEntity.notFound().build();
    }

    // Lấy phiếu giảm giá theo kiểu phiếu và trạng thái
    @GetMapping("/kieu-phieu/{kieuPhieu}/trang-thai/{trangThai}")
    public ResponseEntity<List<PhieuGiamGia>> getPhieuGiamGiaByKieuPhieuAndTrangThai(@PathVariable Boolean kieuPhieu,
                                                                                     @PathVariable Integer trangThai) {
        List<PhieuGiamGia> phieuGiamGiaList = phieuGiamGiaService.findAllByKieuPhieuAndTrangThai(kieuPhieu, trangThai);
        return ResponseEntity.ok(phieuGiamGiaList);
    }
}
