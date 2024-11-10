package com.example.berryshoes.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
<<<<<<< HEAD
import lombok.Builder;
=======
>>>>>>> origin/main
import lombok.Data;

import java.sql.Timestamp;

@Data
<<<<<<< HEAD
@Builder
=======
>>>>>>> origin/main
public class AnhResponse {
    private Integer id;
    private String tenAnh;
    private Integer idSanPhamChiTiet; // Thêm ID của sản phẩm chi tiết

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp ngayTao;

    private String nguoiTao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lanCapNhatCuoi;

    private String nguoiCapNhat;
    private Boolean trangThai; // Dùng Boolean để khớp với kiểu dữ liệu trong entity
}
