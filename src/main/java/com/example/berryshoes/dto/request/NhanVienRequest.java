package com.example.berryshoes.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
public class NhanVienRequest {
    @NotBlank(message = "Mã nhân viên không được để trống")
    @Size(max = 50, message = "Tên nhân viên không được vượt quá 50 ký tự")
    private String maNhanVien;
    private String anh;

    @NotBlank(message = "Họ và tên nhân viên không được để trống")
    private String hoVaTen;

    @NotBlank(message = "Ngày sinh không được để trống")
    private Date ngaySinh;
    private Boolean gioiTinh;

    @NotBlank(message = "Quê quán không được để trống")
    private String queQuan;

    @NotBlank(message = "Căn cước công dân không được để trống")
    private String cccd;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String soDienThoai;

    @NotBlank(message = "Email không được để trống")
    private String email;

    @NotBlank(message = "Tài khoản không được để trống")
    private String taiKhoan;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String matKhau;
    private Integer vaiTro;

    @NotBlank(message = "Người tạo không được để trống")
    private String nguoiTao;

    @NotBlank(message = "Người cập nhật không được để trống")
    private String nguoiCapNhat;
    private Integer trangThai;
}
