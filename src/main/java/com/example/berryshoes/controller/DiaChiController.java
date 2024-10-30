package com.example.berryshoes.controller;

import com.example.berryshoes.service.DiaChiService;
import com.example.berryshoes.dto.request.DiaChiRequest;
import com.example.berryshoes.dto.response.DiaChiResponse;
import com.example.berryshoes.entity.DiaChi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dia-chi")
@RequiredArgsConstructor
public class DiaChiController {
    @Autowired
    private DiaChiService diaChiService;

    // Lấy tất cả địa chỉ
    @GetMapping
    public ResponseEntity<List<DiaChiResponse>> getAllDiaChi() {
        List<DiaChi> diaChiList = diaChiService.getAllDiaChi();
        List<DiaChiResponse> responseList = diaChiList.stream().map(dc -> {
            DiaChiResponse response = new DiaChiResponse();
            response.setId(dc.getId());
            response.setKhachHang(dc.getKhachHang());
            response.setTenDuong(dc.getTenDuong());
            response.setXaPhuong(dc.getXaPhuong());
            response.setQuanHuyen(dc.getQuanHuyen());
            response.setTinhThanhPho(dc.getTinhThanhPho());
            response.setTenNguoiNhan(dc.getTenNguoiNhan());
            response.setSdtNguoiNhan(dc.getSdtNguoiNhan());
            response.setNgayTao(dc.getNgayTao());
            response.setNguoiTao(dc.getNguoiTao());
            response.setLanCapNhatCuoi(dc.getLanCapNhatCuoi());
            response.setNguoiCapNhat(dc.getNguoiCapNhat());
            response.setTrangThai(dc.getTrangThai());
            return response;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    // Lấy địa chỉ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<DiaChiResponse> getDiaChiById(@PathVariable Integer id) {
        Optional<DiaChi> diaChi = diaChiService.getDiaChiById(id);
        return diaChi.map(dc -> {
            DiaChiResponse response = new DiaChiResponse();
            response.setId(dc.getId());
            response.setKhachHang(dc.getKhachHang());
            response.setTenDuong(dc.getTenDuong());
            response.setXaPhuong(dc.getXaPhuong());
            response.setQuanHuyen(dc.getQuanHuyen());
            response.setTinhThanhPho(dc.getTinhThanhPho());
            response.setTenNguoiNhan(dc.getTenNguoiNhan());
            response.setSdtNguoiNhan(dc.getSdtNguoiNhan());
            response.setNgayTao(dc.getNgayTao());
            response.setNguoiTao(dc.getNguoiTao());
            response.setLanCapNhatCuoi(dc.getLanCapNhatCuoi());
            response.setNguoiCapNhat(dc.getNguoiCapNhat());
            response.setTrangThai(dc.getTrangThai());
            return ResponseEntity.ok(response);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới địa chỉ
    @PostMapping
    public ResponseEntity<DiaChiResponse> createDiaChi(@RequestBody DiaChiRequest requestDTO) {
        DiaChi createdDiaChi = diaChiService.createDiaChi(requestDTO);
        DiaChiResponse response = new DiaChiResponse();
        response.setId(createdDiaChi.getId());
        response.setKhachHang(createdDiaChi.getKhachHang());
        response.setTenDuong(createdDiaChi.getTenDuong());
        response.setXaPhuong(createdDiaChi.getXaPhuong());
        response.setQuanHuyen(createdDiaChi.getQuanHuyen());
        response.setTinhThanhPho(createdDiaChi.getTinhThanhPho());
        response.setTenNguoiNhan(createdDiaChi.getTenNguoiNhan());
        response.setSdtNguoiNhan(createdDiaChi.getSdtNguoiNhan());
        response.setNgayTao(createdDiaChi.getNgayTao());
        response.setNguoiTao(createdDiaChi.getNguoiTao());
        response.setLanCapNhatCuoi(createdDiaChi.getLanCapNhatCuoi());
        response.setNguoiCapNhat(createdDiaChi.getNguoiCapNhat());
        response.setTrangThai(createdDiaChi.getTrangThai());
        return ResponseEntity.status(201).body(response);
    }

    // Cập nhật địa chỉ
    @PutMapping("/{id}")
    public ResponseEntity<DiaChiResponse> updateDiaChi(@PathVariable Integer id, @RequestBody DiaChiRequest requestDTO) {
        DiaChi updatedDiaChi = diaChiService.updateDiaChi(id, requestDTO);
        if (updatedDiaChi != null) {
            DiaChiResponse response = new DiaChiResponse();
            response.setId(updatedDiaChi.getId());
            response.setKhachHang(updatedDiaChi.getKhachHang());
            response.setTenDuong(updatedDiaChi.getTenDuong());
            response.setXaPhuong(updatedDiaChi.getXaPhuong());
            response.setQuanHuyen(updatedDiaChi.getQuanHuyen());
            response.setTinhThanhPho(updatedDiaChi.getTinhThanhPho());
            response.setTenNguoiNhan(updatedDiaChi.getTenNguoiNhan());
            response.setSdtNguoiNhan(updatedDiaChi.getSdtNguoiNhan());
            response.setNgayTao(updatedDiaChi.getNgayTao());
            response.setNguoiTao(updatedDiaChi.getNguoiTao());
            response.setLanCapNhatCuoi(updatedDiaChi.getLanCapNhatCuoi());
            response.setNguoiCapNhat(updatedDiaChi.getNguoiCapNhat());
            response.setTrangThai(updatedDiaChi.getTrangThai());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // Xóa địa chỉ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiaChi(@PathVariable Integer id) {
        diaChiService.deleteDiaChi(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/details")
    public ResponseEntity<DiaChi> getDiaChiByDetails(@RequestParam String ten, @RequestParam String sdt,
                                                     @RequestParam String tenduong, @RequestParam String tinhthanh,
                                                     @RequestParam String quanhuyen, @RequestParam String xaphuong) {
        DiaChi diaChi = diaChiService.findByTenNguoiNhanAndSdtNguoiNhanAndTenDuongAndTinhThanhPhoAndQuanHuyenAndXaPhuong(ten, sdt, tenduong, tinhthanh, quanhuyen, xaphuong);
        return ResponseEntity.ok(diaChi);
    }

    @GetMapping("/trangthai/{trangThai}")
    public ResponseEntity<List<DiaChi>> getDiaChiByTrangThai(@PathVariable Integer trangThai) {
        List<DiaChi> diaChiList = diaChiService.findByTrangThai(trangThai);
        return ResponseEntity.ok(diaChiList);
    }

    @GetMapping("/khachhang/macdinh/{idKhachHang}")
    public ResponseEntity<DiaChi> getDiaChiMacDinh(@PathVariable Integer idKhachHang) {
        DiaChi diaChi = diaChiService.findByIdKhachHangMacDinh(idKhachHang);
        return ResponseEntity.ok(diaChi);
    }

    @GetMapping("/khachhang/{idKhachHang}")
    public ResponseEntity<List<DiaChi>> getDiaChiByIdKhachHang(@PathVariable Integer idKhachHang) {
        List<DiaChi> diaChiList = diaChiService.findByIdKhachHang(idKhachHang);
        return ResponseEntity.ok(diaChiList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DiaChi>> searchDiaChi(@RequestParam String ht, @RequestParam String sdt) {
        List<DiaChi> diaChiList = diaChiService.findByHoTenHoacSdt(ht, sdt);
        return ResponseEntity.ok(diaChiList);
    }

    @GetMapping("/key")
    public ResponseEntity<List<DiaChi>> searchByKey(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) Date startDate,
                                                    @RequestParam(required = false) Date endDate,
                                                    @RequestParam(required = false) Integer status) {
        List<DiaChi> diaChiList = diaChiService.findByKey(name, startDate, endDate, status);
        return ResponseEntity.ok(diaChiList);
    }

    @GetMapping("/tinhthanhpho")
    public ResponseEntity<List<DiaChi>> searchByTinhThanhPho(@RequestParam String tinhThanhPho) {
        List<DiaChi> diaChiList = diaChiService.findByTinhThanhPho(tinhThanhPho);
        return ResponseEntity.ok(diaChiList);
    }

    @GetMapping("/khachhang/{idKhachHang}/trangthai/{trangThai}")
    public ResponseEntity<List<DiaChi>> getDiaChiByIdKhachHangAndTrangThai(@PathVariable Integer idKhachHang, @PathVariable Integer trangThai) {
        List<DiaChi> diaChiList = diaChiService.findByIdKhachHangAndTrangThai(idKhachHang, trangThai);
        return ResponseEntity.ok(diaChiList);
    }

}
