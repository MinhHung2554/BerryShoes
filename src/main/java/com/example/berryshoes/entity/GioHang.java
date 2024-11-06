package com.example.berryshoes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GioHang")
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdKhachHang", nullable = false)
    @NotNull(message = "ID khách hàng không được để trống")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdSanPhamChiTiet", nullable = false)
    @NotNull(message = "ID sản phẩm không được để trống")
    private SanPhamChiTiet sanPhamChiTiet;

    @Column(name = "SoLuong")
    @NotNull(message = "Số lượng không được để trống")
    private Short soLuong;

    @CreationTimestamp
    @Column(name = "NgayTao", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ngayTao;

    @Column(name = "TrangThai", columnDefinition = "bit default 0")
    private Boolean trangThai = false;
}
