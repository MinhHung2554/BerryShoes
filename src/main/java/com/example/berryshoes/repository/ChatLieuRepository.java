package com.example.berryshoes.repository;

import com.example.berryshoes.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {

    @Query("SELECT c FROM ChatLieu c WHERE c.tenChatLieu = :tenChatLieu")
    boolean existsByTenChatLieu(String tenChatLieu);
}
