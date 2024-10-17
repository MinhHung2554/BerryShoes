package com.example.berryshoes.controller;

import ch.qos.logback.core.model.Model;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NhanVienController {
    @Autowired
    NhanVienRepository nvRe;

    @GetMapping("nhanVien/index")
    public List<NhanVien> index(Model model) {
        return nvRe.findAll();
    }

    @PostMapping("nhanVien/add")
    public NhanVien add(@RequestBody NhanVien nv) {
        return nvRe.save(nv);
    }

    @PutMapping("/nhanVien/update/{id}")
    public NhanVien put(@PathVariable("id") String id, @RequestBody NhanVien nv) {
        nvRe.save(nv);
        return nv;
    }

    @DeleteMapping("/nhanVien/delete/{id}")
    public void delete(@PathVariable Integer id) {
        nvRe.deleteById(id);

    }
//    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
//        nvRe.deleteById(id);
//        return ResponseEntity.ok("ok");
//    }
}
