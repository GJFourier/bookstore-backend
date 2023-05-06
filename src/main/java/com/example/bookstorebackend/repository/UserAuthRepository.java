package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.entity.User;
import com.example.bookstorebackend.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    UserAuth getByUserId(Long userId);
    void deleteByUserId(Long userId);
    UserAuth getByUsername(String username);
}
