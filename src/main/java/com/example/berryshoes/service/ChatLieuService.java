package com.example.berryshoes.service;

import com.example.berryshoes.dto.request.ChatLieuRequest;
import com.example.berryshoes.entity.ChatLieu;
import com.example.berryshoes.repository.ChatLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatLieuService {
    @Autowired
    private ChatLieuRepository chatLieuRepository;

    // Lấy tất cả chất liệu
    public List<ChatLieu> getAllChatLieu() {
        return chatLieuRepository.findAll();
    }

    // Lấy chất liệu theo ID
    public Optional<ChatLieu> getChatLieuById(Integer id) {
        return chatLieuRepository.findById(id);
    }

    // Tạo mới chất liệu
    public ChatLieu createChatLieu(ChatLieuRequest requestDTO) {
        ChatLieu chatLieu = ChatLieu.builder()
                .tenChatLieu(requestDTO.getTenChatLieu())
                .nguoiTao(requestDTO.getNguoiTao())
                .trangThai(requestDTO.getTrangThai())
                .build();
        return chatLieuRepository.save(chatLieu);
    }

    // Cập nhật chất liệu
    public ChatLieu updateChatLieu(Integer id, ChatLieuRequest requestDTO) {
        Optional<ChatLieu> optionalChatLieu = chatLieuRepository.findById(id);
        if (optionalChatLieu.isPresent()) {
            ChatLieu chatLieu = optionalChatLieu.get();
            chatLieu.setTenChatLieu(requestDTO.getTenChatLieu());
            chatLieu.setNguoiCapNhat(requestDTO.getNguoiCapNhat());
            chatLieu.setTrangThai(requestDTO.getTrangThai());
            return chatLieuRepository.save(chatLieu);
        }
        return null;
    }

    // Xóa chất liệu
    public void deleteChatLieu(Integer id) {
        if (chatLieuRepository.existsById(id)) {
            chatLieuRepository.deleteById(id);
        } else {
            throw new RuntimeException("Chất liệu không tồn tại");
        }
    }
}
