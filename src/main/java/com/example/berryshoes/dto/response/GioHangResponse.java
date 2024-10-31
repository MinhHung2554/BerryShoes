package com.example.berryshoes.dto.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GioHangResponse {
    private Integer id;
    private String maGioHang;
    private Integer khachHangId;
    private Timestamp ngayTao;
    private Timestamp lanCapNhatCuoi;
    private String nguoiCapNhat;
    private Boolean trangThai;
}
