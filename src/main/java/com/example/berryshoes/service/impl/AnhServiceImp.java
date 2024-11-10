package com.example.berryshoes.service.impl;

<<<<<<< HEAD
import com.example.berryshoes.dto.response.AnhResponse;
import com.example.berryshoes.entity.Anh;
import com.example.berryshoes.repository.AnhRepository;
import com.example.berryshoes.service.AnhService;
import lombok.RequiredArgsConstructor;
=======
import com.example.berryshoes.entity.Anh;
import com.example.berryshoes.repository.AnhRepository;
import com.example.berryshoes.service.AnhService;
>>>>>>> origin/main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnhServiceImp implements AnhService {

    private final AnhRepository anhRepository;

=======

@Service
public class AnhServiceImp implements AnhService {
    @Autowired
    AnhRepository anhRepository;
>>>>>>> origin/main
    @Override
    public List<Anh> getAll() {
        return anhRepository.findAll();
    }
<<<<<<< HEAD
// Chuyển đổi từ entity Anh sang DTO AnhResponse


    @Override
    public Optional<Anh> getAnhById(Integer id) {
        return anhRepository.findById(id);
    }

    @Override
    public Anh createAnh(Anh anh) {
        return anhRepository.save(anh);
    }

    @Override
    public Optional<Anh> updateAnh(Integer id, Anh updatedAnh) {
        return anhRepository.findById(id).map(existingAnh -> {
            existingAnh.setTenAnh(updatedAnh.getTenAnh());
            existingAnh.setNguoiCapNhat(updatedAnh.getNguoiCapNhat());
            existingAnh.setTrangThai(updatedAnh.getTrangThai());
            return anhRepository.save(existingAnh);
        });
    }

    @Override
    public void deleteAnh(Integer id) {
        anhRepository.deleteById(id);
    }

    @Override
    public List<Anh> searchAnhByTenAnh(String tenAnh) {
        return anhRepository.findByTenAnhContaining(tenAnh);
    }

    @Override
    public List<Anh> filterAnhByTrangThai(Boolean trangThai) {
        return anhRepository.findByTrangThai(trangThai);
    }
=======
>>>>>>> origin/main
}
