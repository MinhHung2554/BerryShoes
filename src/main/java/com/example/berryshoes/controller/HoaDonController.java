package com.example.berryshoes.controller;

import com.example.berryshoes.dto.response.TrangThai;
import com.example.berryshoes.entity.HoaDon;
import com.example.berryshoes.entity.LichSuHoaDon;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.exception.MessageException;
import com.example.berryshoes.repository.HoaDonRepository;
import com.example.berryshoes.repository.LichSuHoaDonRepository;
import com.example.berryshoes.utils.UserUltis;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private LichSuHoaDonRepository lichSuHoaDonRepository;

    @Autowired
    private UserUltis userUltis;


    @PostMapping("/update-trang-thai")
    public ResponseEntity<?> capNhatTrangThai(@RequestParam Integer hoaDonId, @RequestParam Integer trangThai, HttpServletRequest request){
        Boolean check = TrangThai.kiemTraTonTai(trangThai);
        if(check == false){
            throw new MessageException("Trạng thái chỉ có giá trị từ 1 - 8");
        }
        Optional<HoaDon> hoaDon = hoaDonRepository.findById(hoaDonId);
        if(hoaDon.isEmpty()){
            throw new MessageException("Hóa đơn không tồn tại");
        }
        if(hoaDon.get().getTrangThai() == 6){
            throw new MessageException("Đơn hàng đã hủy, không thể cập nhật trạng thái");
        }
        // thêm case nào nếu cần, copy bên trên xuống, thay giá trị 6 thành value khác
        NhanVien nhanVien = userUltis.getLoggedInNhanVien(request);
        hoaDon.get().setTrangThai(trangThai);
        hoaDon.get().setLanCapNhatCuoi(new Timestamp(System.currentTimeMillis()));
        hoaDon.get().setNguoiCapNhat(nhanVien.getEmail());
        if(trangThai == 2) hoaDon.get().setNgayXacNhan(new Timestamp(System.currentTimeMillis()));
        if(trangThai == 4) hoaDon.get().setNgayVanChuyen(new Timestamp(System.currentTimeMillis()));
        if(trangThai == 5) hoaDon.get().setNgayNhanHang(new Timestamp(System.currentTimeMillis()));
        if(trangThai == 8) hoaDon.get().setNgayHoanThanh(new Timestamp(System.currentTimeMillis()));
        hoaDonRepository.save(hoaDon.get());
        LichSuHoaDon lichSuHoaDon = new LichSuHoaDon();
        lichSuHoaDon.setHoaDon(hoaDon.get());
        lichSuHoaDon.setNguoiCapNhat(nhanVien.getEmail());
        lichSuHoaDon.setTrangThai(trangThai);
        lichSuHoaDon.setLanCapNhatCuoi(new Timestamp(System.currentTimeMillis()));
        lichSuHoaDon.setNhanVien(nhanVien);
        lichSuHoaDon.setNgayTao(new Timestamp(System.currentTimeMillis()));
        lichSuHoaDonRepository.save(lichSuHoaDon);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/danh-sach-trang-thai")
    public ResponseEntity<?> viewListTrangThai(){
        return new ResponseEntity<>(TrangThai.initTrangThais(),HttpStatus.OK);
    }
}
