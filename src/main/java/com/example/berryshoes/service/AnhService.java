package com.example.berryshoes.service;


import com.example.berryshoes.dto.response.AnhResponse;
import com.example.berryshoes.entity.Anh;

import java.util.List;
import java.util.Optional;

public interface AnhService {
    List<Anh> getAll();

    Optional<Anh> getAnhById(Integer id);

    Anh createAnh(Anh anh);

    Optional<Anh> updateAnh(Integer id, Anh anh);

    void deleteAnh(Integer id);

    List<Anh> searchAnhByTenAnh(String tenAnh);

    List<Anh> filterAnhByTrangThai(Boolean trangThai);
}
