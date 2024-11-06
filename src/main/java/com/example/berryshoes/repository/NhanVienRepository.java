package com.example.berryshoes.repository;

import com.example.berryshoes.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    // Tìm nhân viên bằng tên hoặc số điện thoại
    @Query("SELECT n FROM NhanVien n WHERE n.hoVaTen LIKE %:hoVaTen% OR n.soDienThoai LIKE %:soDienThoai%")
    List<NhanVien> findByHoVaTenOrSoDienThoai(@Param("hoVaTen") String hoVaTen, @Param("soDienThoai") String soDienThoai);

    // Tìm nhân viên theo trạng thái
    List<NhanVien> findByTrangThai(Integer trangThai);

    // Tìm nhân viên mặc định theo id
    @Query("SELECT n FROM NhanVien n WHERE n.id = :idNhanVien AND n.trangThai = 1")
    NhanVien findByIdNhanVienMacDinh(@Param("idNhanVien") Integer idNhanVien);

    // Tìm kiếm nhân viên theo tên hoặc trạng thái
    @Query("SELECT n FROM NhanVien n WHERE " +
            "(:hoVaTen IS NULL OR n.hoVaTen LIKE %:hoVaTen%) AND " +
            "(:trangThai IS NULL OR n.trangThai = :trangThai) " +
            "ORDER BY n.lanCapNhatCuoi DESC")
    List<NhanVien> findByHoVaTenAndTrangThai(@Param("hoVaTen") String hoVaTen, @Param("trangThai") Integer trangThai);

    // Lọc nhân viên theo ngày tạo
    @Query("SELECT n FROM NhanVien n WHERE " +
            "(:startDate IS NULL OR n.ngayTao >= :startDate) AND " +
            "(:endDate IS NULL OR n.ngayTao <= :endDate) AND " +
            "(:trangThai IS NULL OR n.trangThai = :trangThai) " +
            "ORDER BY n.lanCapNhatCuoi DESC")
    List<NhanVien> findByFilter(@Param("startDate") Date startDate,
                                @Param("endDate") Date endDate,
                                @Param("trangThai") Integer trangThai);

    // Tìm nhân viên theo mã nhân viên
    NhanVien findByMaNhanVien(String maNhanVien);
}