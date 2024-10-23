package com.example.berryshoes.dto.request;

import com.example.berryshoes.entity.KhachHang; // import KhachHang
import lombok.Data;

@Data
public class DiaChiRequest {
    private KhachHang khachHang; // Cần thiết để thêm thông tin khách hàng
    private String tenDuong;
    private String xaPhuong;
    private String quanHuyen;
    private String tinhThanhPho;
    private String tenNguoiNhan;
    private String sdtNguoiNhan;
    private String nguoiTao;
    private String nguoiCapNhat;
    private Integer trangThai;
}
