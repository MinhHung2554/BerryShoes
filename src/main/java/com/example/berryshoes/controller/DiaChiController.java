package com.example.berryshoes.controller;

import com.example.berryshoes.service.DiaChiService;
import com.example.berryshoes.dto.request.DiaChiRequest;
import com.example.berryshoes.dto.response.DiaChiResponse;
import com.example.berryshoes.entity.DiaChi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
