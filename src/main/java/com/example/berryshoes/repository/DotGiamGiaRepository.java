package com.example.berryshoes.repository;

import com.example.berryshoes.entity.DotGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DotGiamGiaRepository extends JpaRepository<DotGiamGia, Integer> {

//    @Query("SELECT d FROM DotGiamGia d WHERE d.id = :id")
//    DotGiamGia findById(Integer id);
}
