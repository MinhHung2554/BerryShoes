package com.example.berryshoes.service.impl;

import com.example.berryshoes.dto.response.AnhResponse;
import com.example.berryshoes.entity.Anh;
import com.example.berryshoes.repository.AnhRepository;
import com.example.berryshoes.service.AnhService;
import lombok.RequiredArgsConstructor;
import com.example.berryshoes.entity.Anh;
import com.example.berryshoes.repository.AnhRepository;
import com.example.berryshoes.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AnhServiceImp implements AnhService {
    @Autowired
    AnhRepository anhRepository;

    @Override
    public List<Anh> getAll() {
        return anhRepository.findAll();
    }

}