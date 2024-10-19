package com.example.berryshoes.repository;

import com.example.berryshoes.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo, Integer> {

    @Query("SELECT k FROM KichCo k WHERE k.tenKichCo = :tenKichCo")
    KichCo findByTenKichCo(String tenKichCo);
}
