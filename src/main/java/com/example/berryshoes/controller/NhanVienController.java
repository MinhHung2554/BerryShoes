package com.example.berryshoes.controller;

import ch.qos.logback.core.model.Model;
import com.example.berryshoes.entity.NhanVien;
import com.example.berryshoes.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("NhanVien")
public class NhanVienController {
    @Autowired
    NhanVienRepository nhanVienRepository;

    @GetMapping("index")
    public List<NhanVien> index(Model model) {
        return nhanVienRepository.findAll();
    }

    @PostMapping("add")
    public NhanVien add(@RequestBody NhanVien nv) {
        return nhanVienRepository.save(nv);
    }

    @PutMapping("update/{id}")
    public NhanVien put(@PathVariable("id") String id, @RequestBody NhanVien nv) {
        nhanVienRepository.save(nv);
        return nv;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        nhanVienRepository.deleteById(id);

    }
//    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
//        nvRe.deleteById(id);
//        return ResponseEntity.ok("ok");
//    }

}
