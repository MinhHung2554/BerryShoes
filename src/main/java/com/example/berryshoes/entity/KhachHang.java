package com.example.berryshoes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MaKhachHang", length = 50)
    @Length(max = 50, message = "Mã khách hàng không được vượt quá 50 ký tự")
    @NotBlank(message = "Mã khách hàng không được để trống")
    private String maKhachHang;

    @Column(name = "Anh", length = 300)
    @Length(max = 300, message = "Đường dẫn ảnh không được vượt quá 300 ký tự")
    private String anh;

    @Column(name = "HoVaTen", nullable = false, length = 100)
    @NotBlank(message = "Họ và tên không được để trống")
    @Length(max = 100, message = "Họ và tên không được vượt quá 100 ký tự")
    private String hoVaTen;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "GioiTinh", columnDefinition = "bit default 0")
    private Boolean gioiTinh = false;

    @Column(name = "SoDienThoai", length = 20)
    @Length(max = 20, message = "Số điện thoại không được vượt quá 20 ký tự")
    @NotBlank(message = "Sđt không được để trống")
    private String soDienThoai;

    @Column(name = "Email", length = 50)
    @Email(message = "Email không hợp lệ")
    @Length(max = 50, message = "Email không được vượt quá 50 ký tự")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Column(name = "TaiKhoan", length = 50)
    @Length(max = 50, message = "Tên tài khoản không được vượt quá 50 ký tự")
    @NotBlank(message = "Tài khoản không được để trống")
    private String taiKhoan;

    @Column(name = "MatKhau", length = 300)
    @Length(max = 300, message = "Mật khẩu không được vượt quá 300 ký tự")
    private String matKhau;

//    @Enumerated(EnumType.STRING)
//    private Role vaiTro = Role.KHACHHANG; //Hưng thêm
//    @Column(name = "VaiTro", length = 50)
//    private String vaiTro;


    @CreationTimestamp
    @Column(name = "NgayTao", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ngayTao;

    @Column(name = "NguoiTao", length = 100)
    @Length(max = 100, message = "Người tạo không được vượt quá 100 ký tự")
    private String nguoiTao;

    @UpdateTimestamp
    @Column(name = "LanCapNhatCuoi")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lanCapNhatCuoi;

    @Column(name = "NguoiCapNhat", length = 100)
    @Length(max = 100, message = "Người cập nhật không được vượt quá 100 ký tự")
    private String nguoiCapNhat;

    @Column(name = "TrangThai", nullable = false)
    private Integer trangThai;
}
