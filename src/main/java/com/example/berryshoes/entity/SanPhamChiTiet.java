package com.example.berryshoes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdSanPham", nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdKichCo", nullable = false)
    private KichCo kichCo;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", nullable = false)
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDotGiamGia")
    private DotGiamGia dotGiamGia;

    @Column(name = "MaSanPhamChiTiet")
    private String maSanPhamChiTiet;

    @Column(name = "QRCode")
    private String qrCode;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "GiaTien")
    private Double giaTien;

    @Column(name = "MoTa")
    private String moTa;

    @CreationTimestamp
    @Column(name = "NgayTao", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ngayTao;

    @Column(name = "NguoiTao", length = 100)
    private String nguoiTao;

    @UpdateTimestamp
    @Column(name = "LanCapNhatCuoi")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lanCapNhatCuoi;

    @Column(name = "NguoiCapNhat", length = 100)
    private String nguoiCapNhat;

    @Column(name = "TrangThai", columnDefinition = "bit default 1")
    private Boolean trangThai = true;
}
