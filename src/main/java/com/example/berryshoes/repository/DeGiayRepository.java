package com.example.berryshoes.repository;

import com.example.berryshoes.entity.DeGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeGiayRepository extends JpaRepository<DeGiay, Integer> {

    @Query("SELECT d FROM DeGiay d WHERE d.tenDeGiay = :tenDeGiay")
    DeGiay findByTenDeGiay(String tenDeGiay);
}
