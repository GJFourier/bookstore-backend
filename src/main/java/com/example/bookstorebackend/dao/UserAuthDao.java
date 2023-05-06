package com.example.bookstorebackend.dao;

import com.example.bookstorebackend.entity.UserAuth;

public interface UserAuthDao {
    UserAuth getByUserId(Long userId);
    void deleteByUserId(Long userId);
    UserAuth getByUsername(String username);
}
